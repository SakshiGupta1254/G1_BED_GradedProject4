package com.greatlearning.employeemanagement.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;
import lombok.Data;

@Entity
@Table(name = "employees")
@Getter
@Setter
@Data
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int id;
	@Column(name = "emp_first_name")
	private String firstName;
	@Column(name = "emp_last_name")
	private String lastName;
	@Column(name = "emp_email") 
	private String email;
	
	public Integer getId()
	{
		return id;
	}
	public Integer setId(Integer Id)
	{
		return this.id = Id;
	}
	public String getFirstName()
	{
		return firstName;
	}
	public String setFirstName(String firstName)
	{
		return this.firstName = firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public String setLastName(String lastName)
	{
		return this.lastName = lastName;
	}
	public String setEmail(String email)
	{
		return this.email = email;
	}
	public String getEmail()
	{
		return email;
	}

	


}



