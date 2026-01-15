package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.MutationQuery;

import com.tca.entities.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
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
    	/*
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
    		
    	}*/
    /*	
    	// Select * from student where city like 'P%';
		//cq  --> 
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Student> cq = cb.createQuery(Student.class);
		Root<Student> root = cq.from(Student.class);
		
		cq.select(root)
		  .where(cb.like(root.get("city"), "P%"));
		
		//Query<Student> query = session.createQuery(cq);
		
		//List<Student> L = query.list();
		
		
		List<Student> L = session.createQuery(cq)
								.list();
      		
		for(Student S : L)
		{
			System.out.println(S.getRno() + " " + S.getName() + " " + S.getPercentage() + " " + S.getCity());
		}
    	*/
    	/*
    	// Select max(per) from student;
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		
		CriteriaQuery<Float> cq =  cb.createQuery(Float.class);
		Root<Student> root = cq.from(Student.class);
		
		cq.select(cb.max(root.get("percentage")));
		
		
		Query<Float> query = session.createQuery(cq);
		
		Float ans = query.getSingleResult();
		
		System.out.println("Maximum Percentage : " +  ans);
    	*/
    	/*
    	// Select city, count(*) from student group by city having count(*)>=2;
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		
		Root<Student> root = cq.from(Student.class);
		
		Expression<Long> exp = cb.count(root);
		        		
		cq.multiselect(root.get("city"), exp );
		cq.groupBy(root.get("city"));
		cq.having(cb.ge(exp, 1));
		
		
		Query<Object[]> query = session.createQuery(cq);
		
		List<Object[]> list = query.getResultList();
		
		for(Object[] row : list)
		{
			System.out.println(row[0] + " -->" + row[1]);
		}
		*/
    	/*
    	// Above code Using Tuple
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Tuple> cq = cb.createTupleQuery(); 

		Root<Student> root = cq.from(Student.class);

		// Define aggregate expression
		Expression<Long> exp = cb.count(root);

		// Select both columns with aliases
		cq.multiselect(
		    root.get("city").alias("city"),
		    exp.alias("count")
		);

		// Group and Having clause
		cq.groupBy(root.get("city"));
		cq.having(cb.ge(exp, 1));

		// Execute query
		Query<Tuple> query = session.createQuery(cq);
		List<Tuple> list = query.getResultList();

		// Fetch results using aliases
		for (Tuple tuple : list) 
		{
		    String city = tuple.get("city", String.class);
		    Long count = tuple.get("count", Long.class);

		    System.out.println(city + " --> " + count);
		}
    	*/
    	/*
    	// cu ---> UPDATE Student set per=99 where rno=108
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaUpdate<Student>  cu = cb.createCriteriaUpdate(Student.class);
		
		Root<Student> root = cu.from(Student.class);
		
		cu.set("percentage", 99.0)
		  .where(cb.equal(root.get("rno"),103));
		
		MutationQuery query = session.createMutationQuery(cu);
		int rowcnt = query.executeUpdate();
		System.out.println("No. of Rows Modified :" +  rowcnt);
		*/
    	
    	// DELETE FROM student where city=HYDRABAD;
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaDelete<Student> cd = cb.createCriteriaDelete(Student.class);
		
		Root<Student> root = cd.from(Student.class);
		
		cd.where(cb.equal(root.get("city"), "Nashik"));
		
		MutationQuery query = session.createMutationQuery(cd);
		int rowcnt = query.executeUpdate();
		System.out.println("No. of Rows Deleted :" +  rowcnt);
		
    	
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
