package io.jcervelin.ideas.service;

import java.util.List;

import io.jcervelin.ideas.entities.Quiz;

public interface QuizServiceService {
	
	public List<Quiz> findByStates(List<String> states);
	
	public List<Quiz> removeAnswers(List<Quiz> quizes);

	public float calculateResult(Quiz quizAnswered);
	
}
