package io.jcervelin.ideas.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.jcervelin.ideas.entities.QuizEntity;

@Repository
public interface QuizServiceRepository extends CrudRepository <QuizEntity, ObjectId>, QuizServiceCustomRepository {

	public List<QuizEntity> findByStates(List<String> states);
	
	public QuizEntity findBy_id(ObjectId id);
	

	//db.getCollection('quiz').find({"states.code":{$in:["MG"]}})
}
