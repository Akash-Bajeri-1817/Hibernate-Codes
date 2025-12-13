package com.tca.ASS_04_Teacher;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.ASS_04_Teacher.entities.Teacher;

public class App {
    public static void main(String[] args)
    {
    		Configuration configuration = null;
    		SessionFactory sessionFactory = null;
    		Session session = null;
    		Transaction transaction = null;
    		
    		try
    		{
    			configuration = new Configuration();
    			configuration.configure();
    			
    			sessionFactory = configuration.buildSessionFactory();
    			session = sessionFactory.openSession();
    			transaction = session.beginTransaction();
    			
    			Teacher teacher = new Teacher();
    			teacher.setTeacherId(101);
    			teacher.setTeacherName("Sachin sir");
    			teacher.setCity("Pune");
    			teacher.setSalary(100000.0);
    			
    			session.save(teacher);
    			transaction.commit();
    			System.out.println("Record saved successfully !!!");
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
