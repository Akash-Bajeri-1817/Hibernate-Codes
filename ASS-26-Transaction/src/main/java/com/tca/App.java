package com.tca;

import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Account;

public class App 
{
    public static void main(String[] args) 
    {
        Configuration configuration = null;
        SessionFactory sessionFactory = null;
        Session session = null;
        Transaction transaction = null;
        
        Integer senderAccountNumber = 101;
        Integer receiverAccountNumber = 102;
        Float amount = 3000.0f;
        try
		{
			configuration = new Configuration().configure();
			configuration =  configuration.addAnnotatedClass(com.tca.entities.Account.class);
			sessionFactory = configuration.buildSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			
			Account senderAccount  = session.find(Account.class , senderAccountNumber, LockMode.PESSIMISTIC_WRITE);
			senderAccount.setBalance( senderAccount.getBalance() - amount);
			
			System.out.println("Press key to continue !!!");
			System.in.read();
			
			Account recAccount = session.find(Account.class , receiverAccountNumber, LockMode.PESSIMISTIC_WRITE);
			recAccount.setBalance( recAccount.getBalance() + amount);
			
			transaction.commit();
			System.out.println("Transaction completed successfully");
			
		} catch (Exception e)
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
