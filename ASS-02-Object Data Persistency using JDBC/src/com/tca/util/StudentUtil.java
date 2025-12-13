package com.tca.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class StudentUtil 
{
	public static boolean addStudent(Student s) throws SQLException, ClassNotFoundException
	{
		Connection con = null;
		PreparedStatement ps = null;
		
		
		final String DB_DRIVER = "org.postgresql.Driver";
		final String DB_URL = "jdbc:postgresql://localhost/hibernate";
		final String DB_USER = "root";
		final String DB_PASS = "root";
		
		try
		{
			Class.forName(DB_DRIVER);
			
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			
			ps = con.prepareStatement("INSERT INTO STUDENT VALUES(?,?,?)");
			ps.setInt(1, s.getRollNumber());
			ps.setString(2, s.getName());
			ps.setDouble(3, s.getPercentage());
			
			if( (ps.executeUpdate()) == 1 )
				return true;
		}
		finally
		{
			System.out.println("============ Resources Closed =============");
			try 
			{
				con.close();
			} 
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return false;
	}
	
	public static List<Student> fetAllRecotds() throws ClassNotFoundException, SQLException
	{
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Student> l = new ArrayList<>();
		
		final String DB_DRIVER = "org.postgresql.Driver";
		final String DB_URL = "jdbc:postgresql://localhost/hibernate";
		final String DB_USER = "root";
		final String DB_PASS = "root";
		
		try
		{
			Class.forName(DB_DRIVER);
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			
			ps = con.prepareStatement("select * from student");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				int rno = rs.getInt(1);
				String name = rs.getString(2);
				double per = rs.getDouble(3);
				
				Student s = new Student();
				s.setRollNumber(rno);
				s.setName(name);
				s.setPercentage(per);
				
				l.add(s);
			}
			
		}
		finally
		{
			con.close();
		}
		
		return l;
	}

}
