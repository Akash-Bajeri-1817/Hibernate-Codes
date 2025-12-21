package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Book;



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
        	configuration = new Configuration().configure().addAnnotatedClass(com.tca.entities.Book.class);
        	sessionFactory = configuration.buildSessionFactory();
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	Book book = new Book();
        	book.setIsbmNumber(1234567910);
        	book.setBookName("Pawankhind");
        	book.setAuthor("Ranjeet Desai");
        	book.setPrice(100.0);
        	book.setPublisher("akash");
        	
        	session.persist(book);
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
