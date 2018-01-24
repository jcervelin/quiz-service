package io.jcervelin.ideas.repository;

import java.util.List;

import io.jcervelin.ideas.entities.QuizEntity;

public interface QuizServiceCustomRepository {

	public List<QuizEntity> findByStates(List<String> states);
}
