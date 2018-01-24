package io.jcervelin.ideas.controller;

import static io.jcervelin.ideas.entities.Converter.*;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.jcervelin.ideas.entities.Quiz;
import io.jcervelin.ideas.entities.State;
import io.jcervelin.ideas.service.QuizServiceService;

@RestController
@RequestMapping("/quizes")
public class QuizServiceController {
	
	private QuizServiceService service;
	
	@Autowired
	public QuizServiceController(QuizServiceService service) {
		this.service = service;
	}

	@GetMapping("/answers")
	public List<Quiz> listQuizesByStates (@RequestParam(value="states") String[] statesArray) {
		List<String> states = Arrays.asList(statesArray);
		return service.findByStates(states);
	}
	
	@GetMapping
	public List<Quiz> listQuizesByStatesWithoutAnswers (@RequestParam(value="states") String[] statesArray) {		
		return service.removeAnswers(listQuizesByStates(statesArray));
	}	
	
	@GetMapping("/states")
	public List<State> listStates() {
		return allStates();
	}
	
	@GetMapping("/result")
	public Float result (Quiz quizAnswered) {
		Float result = service.calculateResult(quizAnswered);
		return result;
	}

}
