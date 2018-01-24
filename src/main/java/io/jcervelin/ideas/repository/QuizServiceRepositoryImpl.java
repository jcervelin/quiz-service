package io.jcervelin.ideas.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import io.jcervelin.ideas.entities.QuizEntity;

public class QuizServiceRepositoryImpl implements QuizServiceCustomRepository {

	@Autowired
	private MongoTemplate template;
	
	public List<QuizEntity> findByStates(List<String> states) {
		Query query = new Query(Criteria.where("states.code").in(states));
		List<QuizEntity> list = template.find(query, QuizEntity.class);
		return list;
	}

}
