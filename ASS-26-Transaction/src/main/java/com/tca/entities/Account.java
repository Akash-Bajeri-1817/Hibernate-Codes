package com.tca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account
{
	@Id
	@Column(name = "acccount_number")
	private Integer account_number;
	
	@Column(name = "account_holder")
	private String account_holder;
	
	@Column(name = "acoount_type")
	private String acoount_type;
	
	@Column(name = "balance")
	private Float balance;

	public Integer getAccount_number()
	{
		return account_number;
	}

	public void setAccount_number(Integer account_number)
	{
		this.account_number = account_number;
	}

	public String getAccount_holder()
	{
		return account_holder;
	}

	public void setAccount_holder(String account_holder)
	{
		this.account_holder = account_holder;
	}

	public String getAcoount_type()
	{
		return acoount_type;
	}

	public void setAcoount_type(String acoount_type)
	{
		this.acoount_type = acoount_type;
	}

	public Float getBalance()
	{
		return balance;
	}

	public void setBalance(Float balance)
	{
		this.balance = balance;
	}
	
	
}
