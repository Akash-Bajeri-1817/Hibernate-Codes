package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Employee;

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
        	
        	Employee employee = new Employee();
        	employee.setEmployeeId(101);
        	employee.setName("Anil Ghule");
        	employee.setCity("Alandi");
        	employee.setDesignation("Manging Director");
        	employee.setSalary(400000.0);
        	
        	session.save(employee);
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
