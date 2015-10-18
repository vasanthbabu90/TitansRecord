package edu.waa.portal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1720286551568661971L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	
	private String name;
	private int age;
	
	public Employee()
	{
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
