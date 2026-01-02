package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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
    	Query<Student> query = session.createQuery("from Student", Student.class);
    	
    	List<Student> list= query.list(); // Query is fired Select * from student;
   	 
		for(Student s : list)
		{
			System.out.println("Roll Number : " + s.getRno());
			System.out.println("Name        : " + s.getName());
			System.out.println("Percentage  : " + s.getPercentage());
			System.out.println("City        : " + s.getCity());
			System.out.println("-----------------------------------------");
		}*/
    /*	
    	// Test Code - Displaying All records with SPECIFIC columns
		
		Query<Object[]> query = session.createQuery("SELECT rno,name,percentage,city FROM Student", Object[].class);  		
		
		List<Object[]> list= query.getResultList();
		
		for(Object[] ob : list)
		{
			
			for(Object data : ob)
			{
				System.out.print(data +" ");
			}
			System.out.println();
		}
    	*/
    	/*
    	Query<Object[]> query = session.createQuery("SELECT rno,name,percentage,percentage+5 FROM Student", Object[].class);  		
		
		List<Object[]> list= query.getResultList();
		
		for(Object[] ob : list)
		{
			
			for(Object data : ob)
			{
				System.out.print(data +" ");
			}
			System.out.println();
		}*/
    	/*
    	// Test Code - Aggregate Function count(), max(), min(), sum(), avg()
		
		Query<Long> q1 = session.createQuery("SELECT count(*) FROM Student", Long.class );        		
		
		Long n = q1.getSingleResult();
		System.out.println("No. of Records : " + n);
		
		Query<Float> q2 = session.createQuery("SELECT max(percentage) FROM Student", Float.class);
		Float maxPer = q2.getSingleResult();
		System.out.println("Maximum Percentage : " + maxPer);
		*/
    	
    	// Test Code - GROUP BY
		/*
		Query<Object[]> query = session.createQuery("SELECT city, count(*) FROM Student GROUP BY city HAVING count(*)>=2", Object[].class);  		
		
		List<Object[]> list= query.getResultList();
		
		for(Object[] ob : list)
		{
			
			String city = (String) ob[0];
			Long   cnt  = (Long)   ob[1];
			
			System.out.println("CITY : " + city +" No of Admissions: "+ cnt);
			
			
		
//			for(Object data : ob)
//			{
//				System.out.print(data +" ");
//			}
//			
//			System.out.println();
		}
		*/
    	/*
    	// WHERE Clause
		
        	Query<Student> query = session.createQuery("FROM Student WHERE percentage>=70 AND percentage<=80",Student.class);
        
        	//	Query<Student> query = session.createQuery("FROM Student WHERE per BETWEEN 70 AND 80",Student.class);	
        	
        	//  Query<Student> query = session.createQuery("FROM Student WHERE city='PUNE' OR city='MUMBAI'",Student.class);
        	
        //	Query<Student> query = session.createQuery("FROM Student WHERE city LIKE 'P%' ",Student.class);
        	
        	//	Query<Student> query = session.createQuery("FROM Student WHERE per IS NOT NULL ",Student.class);
        		
        	List<Student> L = query.list();
        	
        	for(Student s : L)
    		{
    			System.out.println("Roll Number : " + s.getRno());
    			System.out.println("Name        : " + s.getName());
    			System.out.println("Percentage  : " + s.getPercentage());
    			System.out.println("City        : " + s.getCity());
    			System.out.println("-----------------------------------------");
    		}*/
    	
    	/*// Dynamic SQL Using Positional Paramter
		
		Float d1 = 70.0f;
		Float d2 = 80.0f;
		
		Query<Student> query = session.createQuery("FROM Student WHERE percentage>=?1 AND percentage<= ?2",Student.class);	
		
		query.setParameter(1, d1);
		query.setParameter(2, d2);
		
		List<Student> L = query.list();
    	
    	for(Student s : L)
		{
			System.out.println("Roll Number : " + s.getRno());
			System.out.println("Name        : " + s.getName());
			System.out.println("Percentage  : " + s.getPercentage());
			System.out.println("City        : " + s.getCity());
			System.out.println("-----------------------------------------");
		}*/
    	/*
    	// Dynamic SQL Using Named Paramter
		
		Float d1 = 70.0f;
		Float d2 = 80.0f;
		
		Query<Student> query = session.createQuery("FROM Student WHERE percentage>= :minper AND percentage<= :maxper",Student.class);	
		
		query.setParameter("minper", d1);
		query.setParameter("maxper", d2);
		
		List<Student> L = query.list();
    	
    	for(Student s : L)
		{
			System.out.println("Roll Number : " + s.getRno());
			System.out.println("Name        : " + s.getName());
			System.out.println("Percentage  : " + s.getPercentage());
			System.out.println("City        : " + s.getCity());
			System.out.println("-----------------------------------------");
		}
        */
    	
    	
    	/*// Update
		
		Query<?> query = session.createQuery("UPDATE Student SET percentage = percentage + :val WHERE city = :tempcity ");
		query.setParameter("val", 5.0);
		query.setParameter("tempcity", "Mumbai");
		
		int rowCount = query.executeUpdate();
		System.out.println("No. of Recrods Updated : " + rowCount);
    	*/
    	
    	// DELETE
		
		Query<?> query = session.createQuery("DELETE FROM Student WHERE city = :tempcity ");
		query.setParameter("tempcity", "Mumbai");
		
		int rowCount = query.executeUpdate();
		System.out.println("No. of Recrods Deleted : " + rowCount);
		
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
