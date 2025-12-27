package com.tca;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import com.tca.entities.Student;
import com.tca.entities.StudentComposite;

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
    	   configuration = new 	Configuration().configure();
    	   configuration.addAnnotatedClass(com.tca.entities.Student.class);
    	   sessionFactory = configuration.buildSessionFactory();
    	   session = sessionFactory.openSession();
    	   transaction = session.beginTransaction();
    	   
    	   StudentComposite ckey = new StudentComposite();
    	   ckey.setFirstName("Akshay");
    	   ckey.setLastName("Anarse");
    	   
    	   Student student = new Student();
    	   student.setComposite(ckey);
    	   student.setCity("Satara");
    	   student.setPercentage(90.0);
    	   
    	   session.persist(student);
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
