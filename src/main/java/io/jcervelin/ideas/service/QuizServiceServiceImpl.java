package io.jcervelin.ideas.service;

import static io.jcervelin.ideas.entities.Converter.entityToQuiz;
import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jcervelin.ideas.entities.Question;
import io.jcervelin.ideas.entities.Quiz;
import io.jcervelin.ideas.repository.QuizServiceRepository;

@Service
public class QuizServiceServiceImpl implements QuizServiceService{
	
	private QuizServiceRepository repo;
	private float points = 0f;

	@Autowired
	public QuizServiceServiceImpl(QuizServiceRepository repo) {
		this.repo = repo;
	}

	public List<Quiz> findByStates(List<String> states) {
		
		
		return repo.findByStates(states).stream().map(qe -> entityToQuiz(qe)).collect(toList());
	}
	
	public List<Quiz> removeAnswers(List<Quiz> quizes) {
		quizes.forEach(qi -> qi.getQuestions()
				.forEach(qe -> qe.getAlternatives()
						.forEach(a -> a.setCorrect(false))));
		return quizes;
	}

	public float calculateResult(Quiz quizAnswered) {
		Quiz quiz = entityToQuiz(repo.findById(new ObjectId(quizAnswered.getId())).get());
		List<Question> questions = quiz.getQuestions().stream().sorted(Comparator.comparing(qe -> qe.getName())).collect(toList());
		List<Question> questionsAnswered = quizAnswered.getQuestions().stream().sorted(Comparator.comparing(qe -> qe.getName())).collect(toList());
		
		questions.forEach(qe -> 
			questionsAnswered.forEach(qw ->{
				if (qe.getAlternatives().stream().filter(alt -> alt.isCorrect()).findFirst()
						.equals(qw.getAlternatives().stream().filter(altw -> altw.isCorrect()).findFirst()))
					points++;
			})
		);
		float percent = (points * 100.0f) / quizAnswered.getQuestions().size();
		double percent2places = Math.round(percent * 100.0f) / 100.0f;
		return (float) percent2places;
	}
	
}
