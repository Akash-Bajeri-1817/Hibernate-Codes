package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;




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
		Query<Student> query = session.createNamedQuery("GET_ALL_INFO", Student.class);
		
		List<Student> L = query.list();
		
		for(Student s : L)
		{
			System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() +" " + s.getCity());
		}
*/
		
/*       		
		Query<Student> query = session.createNamedQuery("GET_CITYWISE", Student.class);
		query.setParameter("abc", "PUNE");
		
		List<Student> L = query.list();
		
		for(Student s : L)
		{
			System.out.println(s.getRno() + " " + s.getName() + " " + s.getPer() +" " + s.getCity());
		}
*/        		

/*
		MutationQuery query = session.createNamedMutationQuery("MODIFY_STUDENT_CITY");
		query.setParameter("ncity","POONA");
		query.setParameter("ocity", "PUNE");
		
		int rowCount = query.executeUpdate();
		
		System.out.println("No. of Records Modified : " +  rowCount);
*/
		
		MutationQuery query = session.createNamedMutationQuery("REMOVE_STUDENT");
		query.setParameter("rollnumber", 104);
		int rowCount = query.executeUpdate();
		System.out.println("No. of Records Deleted : " +  rowCount);
    
    	
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
