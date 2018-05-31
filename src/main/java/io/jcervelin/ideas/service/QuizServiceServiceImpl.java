package io.jcervelin.ideas.service;

import io.jcervelin.ideas.entities.Alternative;
import io.jcervelin.ideas.entities.Converter;
import io.jcervelin.ideas.entities.Question;
import io.jcervelin.ideas.entities.Quiz;
import io.jcervelin.ideas.repository.QuizServiceRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

import static io.jcervelin.ideas.entities.Converter.entityToQuiz;
import static java.util.stream.Collectors.toList;

@Service
public class QuizServiceServiceImpl implements QuizServiceService{
	
	private QuizServiceRepository repo;
	private float points = 0f;

	@Autowired
	public QuizServiceServiceImpl(QuizServiceRepository repo) {
		this.repo = repo;
	}

	public List<Quiz> findByStates(List<String> states) {
		
		
		return repo.findByStates(states).stream().map(Converter::entityToQuiz).collect(toList());
	}
	
	public List<Quiz> removeAnswers(List<Quiz> quizes) {
		quizes.forEach(qi -> qi.getQuestions()
				.forEach(qe -> qe.getAlternatives()
						.forEach(a -> a.setCorrect(false))));
		return quizes;
	}

	public float calculateResult(Quiz quizAnswered) {
		points = 0f;
		Quiz quiz = entityToQuiz(repo.findBy_id(new ObjectId(quizAnswered.getId())));
		List<Question> questions = quiz.getQuestions().stream().sorted(Comparator.comparing(Question::getName)).collect(toList());
		List<Question> questionsAnswered = quizAnswered.getQuestions().stream().sorted(Comparator.comparing(Question::getName)).collect(toList());
		
		questions.forEach(qe -> 
			questionsAnswered.forEach(qw ->{
				if (qe.getAlternatives().stream().filter(Alternative::isCorrect).findFirst()
						.equals(qw.getAlternatives().stream().filter(Alternative::isCorrect).findFirst()))
					points++;
			})
		);
		float percent = (points * 100.0f) / quizAnswered.getQuestions().size();
		double percent2places = Math.round(percent * 100.0f) / 100.0f;
		return (float) percent2places;
	}
	
}
