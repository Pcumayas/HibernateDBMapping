package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class).buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a session
			session.beginTransaction();

			// get the instructor detail object
			int theId = 6;

			Instructor tempIns = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " + tempIns);

			// delete
			if (tempIns != null) {
				System.out.println("Deleting instructor: " + tempIns);
				session.delete(tempIns);
			}
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

			//

		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			session.clear();

			factory.close();
		}

	}

}
