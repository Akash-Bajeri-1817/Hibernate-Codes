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
        	
        	Student student = new Student();
        	student.setRollNumber(101);
        	student.setName("Akash Bajeri");
        	student.setPercentage(80.0);
        	
        	
        	/*
        	  The saveOrUpdate() method in Hibernate is a versatile "smart" method. It frees you from having to manually check if a record already exists in the database.

			It automatically decides whether to perform a save() (INSERT) or an update() (UPDATE) based on the state of the object you pass to it.
			
			1. How it Works (The Logic)
			When you pass an object to session.saveOrUpdate(object), Hibernate looks at the Primary Key (Identifier) of that object:
			
			If the ID is null (or empty): Hibernate assumes this is a new object (Transient). It calls save(), which generates a new ID and fires an INSERT query.
			
			If the ID is present (not null): Hibernate assumes this is an existing object (Detached). It calls update(), which fires an UPDATE query to save changes to the row with that ID.
        	 */
        	session.saveOrUpdate(student);
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
