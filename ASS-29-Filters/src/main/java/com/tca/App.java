package com.tca;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tca.entities.Student;

import jakarta.persistence.Tuple;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;




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
    	configuration.addAnnotatedClass(com.tca.entities.Student.class);
    	
    	sessionFactory = configuration.buildSessionFactory();
    	session = sessionFactory.openSession();
    	transaction = session.beginTransaction();
    /*	
		// select * from student
    	CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    	CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
    	Root<Student> root = criteriaQuery.from(Student.class);
    	criteriaQuery.select(root);
    	
    	Query<Student> query = session.createQuery(criteriaQuery);
    	List<Student> list = query.list(); // print * from student
    	
    	for(Student student : list)
    	{
    		System.out.println(student.getRno() + " " + student.getName() + " " + student.getPercentage() + " " + student.getCity());
    		
    	}
    	*/
    	/*
    	// select * from student  order by per desc
    	CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    	CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
    	Root<Student> root = criteriaQuery.from(Student.class);
    	criteriaQuery.select(root).orderBy(criteriaBuilder.desc(root.get("percentage"))); // it is class member name
    	
    	Query<Student> query = session.createQuery(criteriaQuery);
    	List<Student> list = query.list(); // print * from student
    	
    	for(Student student : list)
    	{
    		System.out.println(student.getRno() + " " + student.getName() + " " + student.getPercentage() + " " + student.getCity());
    		
    	}
    	*/
    	/*
    	// select * from student where per >= 70 and per <= 90
    	CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    	CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
    	Root<Student> root = criteriaQuery.from(Student.class);
    	
    	Predicate p1 =  criteriaBuilder.greaterThanOrEqualTo(root.<Float>get("percentage"), 70.0f);
    	Predicate p2 = criteriaBuilder.greaterThanOrEqualTo(root.<Float>get("percentage"), 90.0f);
    	
    	criteriaQuery.select(root).where(criteriaBuilder.and(p1, p2));
    	
    	
    	Query<Student> query = session.createQuery(criteriaQuery);
    	List<Student> list = query.list(); // print * from student
    	
    	for(Student student : list)
    	{
    		System.out.println(student.getRno() + " " + student.getName() + " " + student.getPercentage() + " " + student.getCity());
    		
    	}*/
    	
    	// Specific Column - select name,city,per from student;
		
		// Tuple (stud_name:AAA, city:PUNE, per:70), (BBB,BANGLORE,90)
    	CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
    	CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
    	Root<Student> root = criteriaQuery.from(Student.class);
    	
    	
    	criteriaQuery.multiselect(root.get("name").alias("name"), root.get("city").alias("city"));
    	
    	
    	Query<Tuple> query = session.createQuery(criteriaQuery);
    	List<Tuple> list = query.getResultList(); // print * from student
    	
    	for(Tuple t : list)
    	{
    		System.out.println(t.get("name") + " " + t.get("city") );
    		
    	}
    	
    	
    	
    	
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
