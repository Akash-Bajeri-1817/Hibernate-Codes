package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
@NamedQueries(
		value = {
					@NamedQuery(name="GET_ALL_INFO", query="FROM Student"),
					@NamedQuery(name="GET_CITYWISE", query="FROM Student where city= :abc "),
					@NamedQuery(name="MODIFY_STUDENT_CITY", 
								query="UPDATE Student SET city= :ncity WHERE city= :ocity"),
					@NamedQuery(name="REMOVE_STUDENT",
								query="DELETE FROM Student where rno=:rollnumber")
				} 
		)

public class Student
{
	@Id
	@Column(name = "srno")
	private Integer rno;
	
	@Column(name = "sname")
	private String name;
	
	@Column(name = "sper")
	private Float percentage;
	
	@Column(name = "scity")
	private String city;
	
	public Integer getRno()
	{
		return rno;
	}
	public void setRno(Integer rno)
	{
		this.rno = rno;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Float getPercentage()
	{
		return percentage;
	}
	public void setPercentage(Float percentage)
	{
		this.percentage = percentage;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	
	
}
