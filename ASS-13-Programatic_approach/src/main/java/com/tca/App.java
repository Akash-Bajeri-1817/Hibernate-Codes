package com.tca;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
        	
        	configuration = new Configuration();
        	configuration.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        	configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/hibernate");
        	configuration.setProperty("hibernate.connection.username" ,"root");
        	configuration.setProperty("hibernate.connection.password" ,"root");
        	
        	configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		 	configuration.setProperty("hibernate.show_sql", "true");
		 	configuration.setProperty("hibernate.format", "false");
		 	configuration.setProperty("hibernate.hbm2ddl.auto", "create");
		 	        		
    		configuration.addResource("Student.hbm.xml");
        	
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	Student student = new Student();
        	student.setRollNumber(101);
        	student.setName("Akash ");
        	student.setPercentage(90.0);
        	
        	
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
