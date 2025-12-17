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
        FileInputStream fileInputStream = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        Properties properties = null;
        
        try
        {
        	fileInputStream = new FileInputStream("src/main/resources/hibernate.properties");
        	properties = new Properties();
        	properties.load(fileInputStream);
        	configuration = new Configuration().setProperties(properties).addResource("student.hbm.xml");
        	
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	Student student = new Student();
        	student.setRollNumber(101);
        	student.setName("Akash ");
        	student.setPercentage(80.0);
        	
        	
        	session.saveOrUpdate(student);
        	transaction.commit();
        }
        catch(Exception e)
        {
        	transaction.rollback();
        	e.printStackTrace();
        }
        finally
        {	try 
        	{
				fileInputStream.close();
        	} 
        	catch (IOException e) 
        	{
			// TODO Auto-generated catch block
        		e.printStackTrace();
        	}
        	session.close();
        	sessionFactory.close();
        }
    }
}
