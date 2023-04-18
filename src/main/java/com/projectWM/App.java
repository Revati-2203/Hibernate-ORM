package com.projectWM;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {
		System.out.println("Project Started..");
	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		System.out.println(factory);
		System.out.println(factory.isClosed());

		// creating student
		Student st = new Student();
		st.setId(101);
		st.setName("Smith");
		st.setCity("Pune");

		System.out.println(st);

		// creating object of address class
		Address ad = new Address();
		ad.setStreet("Street1");
		ad.setCity("Pune");
		ad.setOpen(true);
		ad.setAddedDate(new Date());
		ad.setX(1276.345);

		// Reading image
		FileInputStream fis = new FileInputStream("src/main/java/images.png");
		byte[] data = new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(st);
		session.save(ad);
		tx.commit();
		session.close();
		System.out.println("Done..");
	}
}
