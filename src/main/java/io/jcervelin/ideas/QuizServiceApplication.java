package io.jcervelin.ideas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
//@EnableDiscoveryClient
public class QuizServiceApplication implements CommandLineRunner{
	/*@Autowired
	private QuizServiceRepository repo;*/

	public static void main(String[] args) {
		SpringApplication.run(QuizServiceApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		/*QuizEntity q1 = new QuizEntity();
		q1 = new QuizEntity();
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
		qu3.setName("Qual capital do Afeganistão?");
		
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
		List<QuizEntity> returnetList = new ArrayList<>();
		
		returnetList.add(q1);

		QuizEntity q2 = new QuizEntity();
		q2 = new QuizEntity();
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
		qu4.setName("Qual capital do Afeganistão?");
		
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
		returnetList.add(q2);
		repo.save(returnetList);*/		
	}
}
