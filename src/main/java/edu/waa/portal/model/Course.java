package edu.waa.portal.model;

import java.sql.Date;
import java.util.List;

public class Course {
	
	private long id;
	private String courseName;	
	private String courseDescription;
	private String courseLevel;
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

	public String getCourseLevel() {
		return courseLevel;
	}
	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}
	

}
