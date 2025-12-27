package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student 
{
	@EmbeddedId
	private StudentComposite composite;
	@Column(name = "city")
	private String city;
	@Column(name = "percentage")
	private Double percentage;
	
	public StudentComposite getComposite() {
		return composite;
	}
	public void setComposite(StudentComposite composite) {
		this.composite = composite;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
}
