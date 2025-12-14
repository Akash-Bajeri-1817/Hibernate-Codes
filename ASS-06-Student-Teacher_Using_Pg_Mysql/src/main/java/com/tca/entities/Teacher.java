package com.tca.entities;

public class Teacher
{
	private Integer teacherId;
	private String name;
	private Double salary;
	
	public Integer getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
