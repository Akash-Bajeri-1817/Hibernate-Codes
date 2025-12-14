package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.Teacher;

public class App 
{
    public static void main(String[] args)
    {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        
        Configuration configurationMysql = null;
        SessionFactory sessionFactoryMysql = null;
        Session sessionMysql = null;
        Transaction transactionMysql = null;
        
        try
        {
        	configuration = new Configuration().configure("postgresql.cfg.xml");
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	configurationMysql = new Configuration().configure("mysql.cfg.xml");
        	sessionFactoryMysql = configurationMysql.buildSessionFactory();
        	sessionMysql = sessionFactoryMysql.openSession();
        	transactionMysql = sessionMysql.beginTransaction();
        	
        	Student student = new Student();
        	student.setRollNumber(202);
        	student.setName("Akash Bajeri");
        	student.setPercentage(87.90);
        	
        	session.save(student);
        	sessionMysql.save(student);
        	
        	Teacher teacher = new Teacher();
        	teacher.setTeacherId(303);
        	teacher.setName("Dhanashree mam");
        	teacher.setSalary(300000.0);
        	
        	session.save(teacher);
        	sessionMysql.save(teacher);
        	
        	transaction.commit();
        	transactionMysql.commit();
        	System.out.println("Records are saved successfully");
        }
        catch(Exception e)
        {
        	transaction.rollback();
        	transactionMysql.rollback();
        	e.printStackTrace();
        }
        finally
        {
        	session.close();
        	sessionFactory.close();
        	
        	sessionMysql.close();
        	sessionFactoryMysql.close();
        }
    }
}
