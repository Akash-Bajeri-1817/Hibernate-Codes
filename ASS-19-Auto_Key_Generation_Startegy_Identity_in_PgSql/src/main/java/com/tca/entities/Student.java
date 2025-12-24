package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "tca_student")
public class Student 
{
	@Id
	@SequenceGenerator(name = "tca", sequenceName = "tcaseq", allocationSize = 1, initialValue = 201)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tca")
	@Column(name = "roll_number")
	private Integer rollNumber;
	
	@Column(name = "student_name", nullable =false)
	private String name;
	
	@Column(name = "percentage", nullable = false, columnDefinition = "float check(percentage >0 and percentage < 100)")
	private Double percentage;

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

	@Override
	public String toString() {
		return "Student [rollNumber=" + rollNumber + ", name=" + name + ", percentage=" + percentage + "]";
	}
	
	
}
