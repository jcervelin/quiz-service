package io.jcervelin.ideas.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bson.types.ObjectId;

public class Converter {
	
	public static Quiz entityToQuiz(QuizEntity entity) {
		Quiz quiz = new Quiz();
		quiz.setId(entity.get_id().toString());
		quiz.setName(entity.getName());
		quiz.setQuestions(entity.getQuestions());
		quiz.setStates(entity.getStates());
		return quiz;
	}
	
	public static QuizEntity quizToEntity(Quiz quiz) {
		QuizEntity entity = new QuizEntity();
		entity.set_id(quiz.getId() != null ? new ObjectId(quiz.getId()): null);
		entity.setName(quiz.getName());
		entity.setQuestions(quiz.getQuestions());
		entity.setStates(quiz.getStates());
		return entity;
	}
	
	public static List<State> allStates() {
		List<StateEnum> allStates = Arrays.asList(StateEnum.values());
		List<State> states = new ArrayList<>();
		allStates.forEach(s -> states.add(new State(s)));
		return states;
	}
	
	
	public static List<State> stateStringArrayToListState(String[] statesArray) {
		List<String> statesString = Arrays.asList(statesArray);
		List<State> states = new ArrayList<>();
		statesString.forEach(s -> states.add(new State(StateEnum.valueOf(s))));
		return states;
	}
	
	


}
