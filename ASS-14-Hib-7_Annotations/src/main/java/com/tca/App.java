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
    		configuration = new Configuration().configure();
    		configuration.addAnnotatedClass(com.tca.entities.Student.class);
    		
    		sessionFactory = configuration.buildSessionFactory();
    		session = sessionFactory.openSession();
    		transaction = session.beginTransaction();
    		
    		Student student = new Student();
    		student.setRollNumber(210);
    		student.setName("shlok kardile");
    		student.setPercentage(66.0);
    		student.setCity("Pune");
    		
    		session.persist(student);
    		transaction.commit();
    	}
    	catch(Exception e)
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
