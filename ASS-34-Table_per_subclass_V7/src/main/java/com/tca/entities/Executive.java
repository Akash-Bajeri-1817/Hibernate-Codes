package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

@Entity(name = "EXE01")
@PrimaryKeyJoinColumn(name = "empid")
public class Executive extends Employee
{
	@Column(name = "role")
	private String role;

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}
	
	
}
