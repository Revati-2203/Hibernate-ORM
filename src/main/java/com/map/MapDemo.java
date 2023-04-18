package com.map;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating question
		Question q1=new Question();
		q1.setQuestionId(1212);
		q1.setQuestion("what is java?");
		
		
//one to one
//		//creating answer
//		Answer a1=new Answer();
//		a1.setAnswerId(343);
//		a1.setAnswer("Java is Programming language");
//		
//		q1.setAnswer(a1);
//		a1.setQuestion(q1);
		

		
	

//many to one
		Answer ans=new Answer();
		ans.setAnswerId(3436);
		ans.setAnswer("Java is Programming language");
		ans.setQuestion(q1);
		
		Answer ans1=new Answer();
		ans.setAnswerId(3636);
		ans.setAnswer("With help of Java, we can create softwares");
		ans.setQuestion(q1);
		
		Answer ans2=new Answer();
		ans.setAnswerId(336);
		ans.setAnswer("Java has differnt type of frameworks.");
		ans.setQuestion(q1);
		
		List<Answer> list= new ArrayList<>();
		list.add(ans);
		list.add(ans1);
		list.add(ans2);
		
		q1.setAnswers(list);
		
		
		
		//session
		Session s= factory.openSession();
		
		Transaction tx = s.beginTransaction();
		
		
		//save
		s.save(q1);
		s.persist(ans);
		s.persist(ans1);
		s.persist(ans2);
		
		tx.commit();
		
		
//one to one 
//		//fetching
//		Question newQ=(Question)s.get(Question.class, 121212);
//		System.out.println(newQ.getQuestion());
//		System.out.println(newQ.getAnswer().getAnswer());	
		
		
		s.close();
		factory.close();
	}
}
