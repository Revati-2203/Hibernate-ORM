package com.projectWM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class EmbededDemo {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		cfg.configure();
		SessionFactory factory = cfg.buildSessionFactory();
		Student student1= new Student();
		student1.setId(1432);
		student1.setName("Revati");
		student1.setCity("wardha");
		
		Certificate certificate = new Certificate();
		certificate.setCourseName("Hibernate");
		certificate.setDuration("1 Day");
		
		student1.setCertify(certificate);
		
		Session s= factory.openSession();
		Transaction tx = s.beginTransaction();
				
				//save objects
		s.save(student1);
		
		tx.commit();
		s.close();
		factory.close();
	}
}
