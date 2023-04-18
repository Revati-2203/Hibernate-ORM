package com.projectWM;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
		 cfg.configure();
		 SessionFactory factory = cfg.buildSessionFactory();
		 Session session= factory.openSession();
		 //load vs get (study)
		 //load-student:101
		 Student student= (Student)session.load(Student.class,101);
		 System.out.println(student);
		 
		 //get
		 Address ad= (Address)session.get(Address.class, 1);
		 System.out.println(ad.getStreet()+" : "+ad.getCity());
		 
		 session.close();
		 factory.close();
	}
}
