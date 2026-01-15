package com.tca.entities;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.FilterDefs;
import org.hibernate.annotations.Filters;
import org.hibernate.annotations.ParamDef;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
@FilterDefs({
	@FilterDef(name = "cityfilter", parameters = @ParamDef(name = "tca", type = String.class)),
	@FilterDef(name = "perfilter", parameters = @ParamDef(name = "akash", type = Float.class))
})

@Filters({
	@Filter(name = "cityfilter", condition = "scity = :tca"),
	@Filter(name = "perfilter", condition = "sper >= :akash")
})

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
