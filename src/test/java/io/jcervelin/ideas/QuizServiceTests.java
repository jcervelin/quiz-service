package io.jcervelin.ideas;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.jcervelin.ideas.entities.Alternative;
import io.jcervelin.ideas.entities.Question;
import io.jcervelin.ideas.entities.Quiz;
import io.jcervelin.ideas.entities.QuizEntity;
import io.jcervelin.ideas.entities.State;
import io.jcervelin.ideas.entities.StateEnum;
import io.jcervelin.ideas.repository.QuizServiceRepository;
import io.jcervelin.ideas.service.QuizServiceServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class QuizServiceTests {
	
	@InjectMocks
	private QuizServiceServiceImpl service;
	
	@Mock
	private QuizServiceRepository repo;
	
	private List<QuizEntity> returnetList = new ArrayList<>();
	
	private Quiz q2;
	
	private QuizEntity q1;

	
	@Before
	public void load() {
		q1 = new QuizEntity();
		q1.set_id(new ObjectId("5a66a07182902b4b7c7defc2"));
		q1.setName("Enquete sobre Atualidades");
		
		Question qu1 = new Question();
		qu1.setName("Qual capital do Brasil?");
		
		Alternative a1 = new Alternative();
		a1.setText("Brasilia");
		a1.setCorrect(false);

		Alternative a2 = new Alternative();
		a2.setText("Rio de Janeiro");
		a2.setCorrect(true);
		
		Alternative a3 = new Alternative();
		a3.setText("São Paulo");
		a3.setCorrect(false);
		
		qu1.setAlternatives(Arrays.asList(a1,a2,a3));
		
		Question qu3 = new Question();
		qu3.setName("Qual capital do Afeganist�o?");
		
		Alternative a7 = new Alternative();
		a7.setText("Não sei");
		a7.setCorrect(true);

		Alternative a8 = new Alternative();
		a8.setText("Sei lá");
		a8.setCorrect(false);
		
		Alternative a9 = new Alternative();
		a9.setText("Não quero saber");
		a9.setCorrect(false);
		
		qu3.setAlternatives(Arrays.asList(a7,a8,a9));
		q1.setQuestions(Arrays.asList(qu1,qu3));
		
		List<State> states = new ArrayList<>();
		
		states.add(new State(StateEnum.SP));
		states.add(new State(StateEnum.RJ));
		states.add(new State(StateEnum.SC));
		q1.setStates(states);
		
		returnetList.add(q1);

		q2 = new Quiz();
		q2.setId("5a66a07182902b4b7c7defc2");
		q2.setName("Enquete sobre Atualidades");
		
		Question qu2 = new Question();
		qu2.setName("Qual capital do Brasil?");

		Alternative a4 = new Alternative();
		a4.setText("Brasilia");
		a4.setCorrect(true);

		Alternative a5 = new Alternative();
		a5.setText("Rio de Janeiro");
		a5.setCorrect(false);
		
		Alternative a6 = new Alternative();
		a6.setText("São Paulo");
		a6.setCorrect(false);
		
		qu2.setAlternatives(Arrays.asList(a4,a5,a6));
		

		Question qu4 = new Question();
		qu4.setName("Qual capital do Afeganist�o?");
		
		Alternative a10 = new Alternative();
		a10.setText("Não sei");
		a10.setCorrect(true);

		Alternative a11 = new Alternative();
		a11.setText("Sei lá");
		a11.setCorrect(false);
		
		Alternative a12 = new Alternative();
		a12.setText("Não quero saber");
		a12.setCorrect(false);
		
		qu4.setAlternatives(Arrays.asList(a10,a11,a12));
		
		q2.setQuestions(Arrays.asList(qu2,qu4));
		
		
		List<State> states1 = new ArrayList<>();
		
		states1.add(new State(StateEnum.SP));
		states1.add(new State(StateEnum.RJ));
		states1.add(new State(StateEnum.SC));
		q2.setStates(states1);
	}
	
	@Test
	public void calculateResult() {
		//Optional<QuizEntity> op = Optional.of(q1);
		when(repo.findBy_id(Matchers.any(ObjectId.class))).thenReturn(q1);
		when(repo.findByStates(Matchers.any())).thenReturn(returnetList);
		Float f1 = service.calculateResult(q2);
		Assert.assertEquals(50.0f, f1, 0.02f);
	}

}
