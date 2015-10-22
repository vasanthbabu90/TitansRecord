package edu.waa.portal.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.Range;

@Entity
public class Phone implements Serializable {
	public Phone() {
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Range(min = 100,max = 999, message = "{Size.Number.validation}")
	private int area;
	
	@Range(min = 100,max = 999, message = "{Size.Number.validation}")
	private int prefix;
	
	@Range(min = 100,max = 999, message = "{Size.Number.validation}")
	private int number;

	public Phone(int area, int prefix, int number) {
		this.area = area;
		this.prefix = prefix;
		this.number = number;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getPrefix() {
		return prefix;
	}

	public void setPrefix(int prefix) {
		this.prefix = prefix;
	}

	@Override
	public String toString() {
		return "Phone [area=" + area + ", prefix=" + prefix + ", number=" + number + "]";
	}
	
	
	
}
