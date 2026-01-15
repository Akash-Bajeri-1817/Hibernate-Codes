package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Filter;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

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
    	
		/*
		 * Filter filter = session.enableFilter("cityfilter");
		 * filter.setParameter("tca", "Pune");
		 */
    	
    	Filter filter = session.enableFilter("perfilter");
    	filter.setParameter("akash", 90.f);
    	
    	Query<Student> query = session.createQuery("from Student", Student.class);
    	
    	List<Student> list= query.list(); // Query is fired Select * from student;
   	 
		for(Student s : list)
		{
			System.out.println("Roll Number : " + s.getRno());
			System.out.println("Name        : " + s.getName());
			System.out.println("Percentage  : " + s.getPercentage());
			System.out.println("City        : " + s.getCity());
			System.out.println("-----------------------------------------");
		}
    
    	
    	transaction.commit();
    
	}
    catch (Exception e)
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
