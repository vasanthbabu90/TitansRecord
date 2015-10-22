package edu.waa.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

@Entity
public class StudentCourseEnrolled 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrolledId;
	
	@Range(min = 100,max = 999, message = "{Size.Number.validation}")
	private int courseIdLevel;
	
	@NotEmpty
	private String courseDescription;
		
	private int studentID;
	
	private String grade;

	public StudentCourseEnrolled()
	{
		
	}
	
	
	
	public StudentCourseEnrolled(int courseIdLevel, String courseDescription, int studentID) {
		super();
		this.courseIdLevel = courseIdLevel;
		this.courseDescription = courseDescription;
		this.studentID = studentID;
	}



	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}



	public int getEnrolledId() {
		return enrolledId;
	}


	public void setEnrolledId(int enrolledId) {
		this.enrolledId = enrolledId;
	}


	public int getCourseIdLevel() {
		return courseIdLevel;
	}

	public void setCourseIdLevel(int courseIdLevel) {
		this.courseIdLevel = courseIdLevel;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	
	

}
