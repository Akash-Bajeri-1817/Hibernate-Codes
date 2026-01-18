package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity(name = "EMP01")
@Inheritance(strategy = InheritanceType.JOINED)
public class Employee
{
	@Id
	@Column(name = "empid")
	private Integer empid;
	
	@Column(name = "name")
	private String name;

	public Integer getEmpid()
	{
		return empid;
	}

	public void setEmpid(Integer empid)
	{
		this.empid = empid;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	
}
