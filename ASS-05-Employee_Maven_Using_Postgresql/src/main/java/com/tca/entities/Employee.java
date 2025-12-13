package com.tca.entities;

public class Employee 
{
	private Integer employeeId;
	private String name;
	private String city;
	private String designation;
	private Double salary;
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", city=" + city + ", designation="
				+ designation + ", salary=" + salary + "]";
	}

}
