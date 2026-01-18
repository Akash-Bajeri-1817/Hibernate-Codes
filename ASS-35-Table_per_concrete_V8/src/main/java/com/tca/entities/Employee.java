package com.tca.entities;

import jakarta.persistence.Entity;

@Entity
public class Employee extends Person
{
	private Double salary;

	public Double getSalary()
	{
		return salary;
	}

	public void setSalary(Double salary)
	{
		this.salary = salary;
	}
	
	
	
}
