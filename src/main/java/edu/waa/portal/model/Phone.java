package edu.waa.portal.model;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Phone implements Serializable {

	public Phone() {
	}
	private static final long serialVersionUID = 1L;

	//@NotNull @Min(100)	@Max(999)
	private Integer area;
	//@NotNull @Min(100)	@Max(999)
	private Integer prefix;
	//@NotNull @Min(100)	@Max(999)
	private Integer number;

	public Phone(Integer area, Integer prefix, Integer number) {
		this.area = area;
		this.prefix = prefix;
		this.number = number;
	}

	public Integer getArea() {
		return area;
	}

	public void setArea(Integer area) {
		this.area = area;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Integer getPrefix() {
		return prefix;
	}

	public void setPrefix(Integer prefix) {
		this.prefix = prefix;
	}
}
