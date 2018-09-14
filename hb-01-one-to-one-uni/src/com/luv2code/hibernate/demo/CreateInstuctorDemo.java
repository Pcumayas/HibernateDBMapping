package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstuctorDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// create the objects
			Instructor tempInstructor = new Instructor("Dumpty", "Cu", "DC@luv2code.com");
			
			InstructorDetail tempIDetail = new InstructorDetail("luv2sleep.com/youtube", "sleep");
			
			// associate the objects
			tempInstructor.setInstructorDetail(tempIDetail);
			
			// start a session
			session.beginTransaction();
			
			// save the instructor
			// THIS ALSO SAVES DETAILS OBJECT
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
			// 
			
		} finally {
			factory.close();
		}

	}

}
