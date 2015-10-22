package edu.waa.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String courseName;
	
	@NotEmpty
	private String courseDescription;
	
	@Range(min = 100,max = 999, message = "{Size.Number.validation}")
	private int courseLevel;

	public Course()
	{
		
	}

	public Course(String courseName, String courseDescription, int courseLevel) {
		super();
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.courseLevel = courseLevel;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(int courseLevel) {
		this.courseLevel = courseLevel;
	}

	

}