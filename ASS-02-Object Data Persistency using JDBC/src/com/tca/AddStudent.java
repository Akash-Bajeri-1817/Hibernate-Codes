package com.tca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import com.tca.entities.Student;
import com.tca.util.StudentUtil;

public class AddStudent 
{

	public static void main(String[] args) 
	{		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		try
		{
			
			System.out.print("Enter the roll number : ");
			int rollNumber = Integer.parseInt(br.readLine());
			
			System.out.print("Enter the name : ");
			String name = br.readLine();
			
			System.out.print("Enter the percentage : ");
			double percentage = Double.parseDouble(br.readLine());
			
			Student s = new Student();
			s.setName(name);
			s.setPercentage(percentage);
			s.setRollNumber(rollNumber);
			if( StudentUtil.addStudent(s) )
				System.out.println("Record is Inserted Succesfully");
				
		}
		catch(SQLException se)
		{
			System.out.println("Failed to save record");
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println("Fail to load class ");
		}
		catch(Exception e)
		{
			System.out.println("======== Failed =========");
			e.printStackTrace();
		}
		finally
		{
			System.out.println("============ Resources Closed =============");
			
			try 
			{
				br.close();
			} 
			catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
