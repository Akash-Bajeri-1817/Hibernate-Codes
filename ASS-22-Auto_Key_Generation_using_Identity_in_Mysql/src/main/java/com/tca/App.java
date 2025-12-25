package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;

public class App
{
    public static void main(String[] args) 
    {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        
        try 
        {
        	configuration = new Configuration().configure().addAnnotatedClass(Student.class);
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	Student student = new Student();
        	student.setPercentage(30.0);
        	student.setName("Akash Bajeri");
        	
        	session.persist(student);
        	Integer rno = (Integer) session.getIdentifier(student);
        	System.out.println("Record saves for roll number : " + rno);
        	transaction.commit();
			
		} catch (Exception e) 
        {
			transaction.rollback();
			e.printStackTrace();
		}
        finally 
        {
			session.close();
			sessionFactory.close();
		}
    }
}
