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
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	Student student = (Student)session.get(Student.class, 202);
        	student.setName("BBBBB");
        	student.setPercentage(50.0);
        	
        	/*
        	  get(): Hits the database immediately. When you call this method, Hibernate executes a SELECT query right away to fetch the record.
        	  get(): Returns null if the object does not exist in the database. This makes it safe to use if you aren't sure the ID is valid.
        	  get() returns the actual entity object fully initialized with data from the database
        	 */
        	session.update(student);
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
