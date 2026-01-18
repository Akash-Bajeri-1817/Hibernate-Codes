package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Executive extends Person
{
	@Column(name = "role")
	private String role;
	
	@Column(name = "bouns")
	private Double bouns;

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public Double getBouns()
	{
		return bouns;
	}

	public void setBouns(Double bouns)
	{
		this.bouns = bouns;
	}
	
	
}
