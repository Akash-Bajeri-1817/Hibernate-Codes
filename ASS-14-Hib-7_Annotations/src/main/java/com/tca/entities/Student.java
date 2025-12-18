package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class Student 
{
	@Id
	@Column(name="Roll_Number")
	private Integer rollNumber;
	
	@Column(name="std_name")
	private String name;
	
	@Column(name="std_percentage")
	private Double percentage;
	
	@Column(name="std_city")
	private String city;
	
	public Integer getRollNumber() {
		return rollNumber;
	}
	
	public void setRollNumber(Integer rollNumber) {
		this.rollNumber = rollNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", percentage=" + percentage + ", city=" + city
				+ "]";
	}
	
	
}
