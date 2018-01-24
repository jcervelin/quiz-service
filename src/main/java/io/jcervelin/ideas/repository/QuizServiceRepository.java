package io.jcervelin.ideas.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import io.jcervelin.ideas.entities.QuizEntity;

@Repository
public interface QuizServiceRepository extends MongoRepository<QuizEntity, ObjectId>, QuizServiceCustomRepository {

	public List<QuizEntity> findByStates(List<String> states);

	//db.getCollection('quiz').find({"states.code":{$in:["MG"]}})
}
