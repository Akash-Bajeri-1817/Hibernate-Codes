package com.tca.entities;


import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student
{
	@Id
	private Integer rollNumber;
	private String name;
	private Double percentage;
	
	@Embedded
	private Address address;

	public Integer getRollNumber()
	{
		return rollNumber;
	}

	public void setRollNumber(Integer rollNumber)
	{
		this.rollNumber = rollNumber;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public Double getPercentage()
	{
		return percentage;
	}

	public void setPercentage(Double percentage)
	{
		this.percentage = percentage;
	}

	public Address getAddress()
	{
		return address;
	}

	public void setAddress(Address address)
	{
		this.address = address;
	}
	
	
	
	
}
