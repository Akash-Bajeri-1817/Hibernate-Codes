package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Employee;
import com.tca.entities.Executive;



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
        	configuration = new Configuration()
        			.configure()
        			.addAnnotatedClass(com.tca.entities.Employee.class)
        			.addAnnotatedClass(com.tca.entities.Executive.class);
        	
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	Employee employee = new Employee();
        	employee.setEmpid(101);
        	employee.setName("Akash Bajeri");
        	session.persist(employee);
        	
        	Executive executive = new Executive();
        	executive.setEmpid(102);
        	executive.setName("Akshay Anarse");
        	executive.setRole("Developer");
        	session.persist(executive);
        	
        	
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
