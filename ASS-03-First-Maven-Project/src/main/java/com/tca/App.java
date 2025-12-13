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
        Configuration configuratiion = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        
        try
        {
        		configuratiion = new Configuration();
        		configuratiion.configure(); // load and parse XML files
        		
        		sessionFactory = configuratiion.buildSessionFactory();
        		session = sessionFactory.openSession();
        		transaction = session.beginTransaction();
        		
        		Student student = new Student();
        		student.setName("Akash");
        		student.setPercentage(60.0);
        		student.setRollNumber(101);
        		
        		session.save(student);
        		
        		transaction.commit();
        		System.out.println("Record is saved successfully !!");
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
