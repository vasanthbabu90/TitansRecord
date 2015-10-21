package edu.waa.portal.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Phone implements Serializable {
	public Phone() {
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	//@NotNull @Min(100) @Max(999)
	private int area;
	//@NotNull @Min(100) @Max(999)
	private int prefix;
	//@NotNull @Min(100) @Max(999)
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
}
