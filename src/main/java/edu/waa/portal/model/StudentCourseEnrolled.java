package edu.waa.portal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentCourseEnrolled 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int enrolledId;
	
	private int CourseId;
	
	private String courseDescription;	
	
	private int studentID;
	
	private String grade;


	/*public StudentCourseEnrolled()
	{
		
	}
	
	
	
	public StudentCourseEnrolled(int courseId, String courseDescription, int studentID) {
		super();
		CourseId = courseId;
		this.courseDescription = courseDescription;
		this.studentID = studentID;
	}*/



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


	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
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
