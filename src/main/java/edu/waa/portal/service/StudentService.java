package edu.waa.portal.service;

import java.util.List;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.Student;
import edu.waa.portal.model.StudentCourseEnrolled;

public interface StudentService 
{
	
	public void enrollCourses(List<Integer> courseIds, List<String> courseDesc, Integer studentId);
	
	public List<String> getAvailableCourses();
	
	public Student getStudentProfile(int studentId);
	
	public void updateStudentProfile(Student student);
	
	public void updateImageUploadedOrNotField(Integer studentId);
	
	public List<StudentCourseEnrolled> getStudentEnrolledCourses(int studentId);
	
	public boolean doesUserNameExist(String userName);

}
