package com.tca;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Address;
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
			configuration = new Configuration().configure().addAnnotatedClass(com.tca.entities.Student.class);
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Address address = new Address();
			address.setCity("Pune");
			address.setState("Maharashtra");
			address.setCountry("India");
			
			Student student = new Student();
			student.setRollNumber(101);
			student.setName("Akash");
			student.setPercentage(70.0);
			student.setAddress(address);
			
			session.persist(student);
			
			transaction.commit();
		} 
        catch (Exception e)
		{
			transaction.rollback();
		}
        finally 
        {
			session.close();
			sessionFactory.close();
		}
    }
}
