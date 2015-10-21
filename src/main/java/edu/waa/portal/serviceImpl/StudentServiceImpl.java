package edu.waa.portal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.Student;
import edu.waa.portal.model.StudentCourseEnrolled;
import edu.waa.portal.repositories.StudentCourseEnrollRepository;
import edu.waa.portal.repositories.StudentRepository;
import edu.waa.portal.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService
{

	@Autowired
	StudentCourseEnrollRepository studentEnrollRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentCourseEnrollRepository studentCourseEnrollRepository;
	
	@Override
	public void enrollCourses(List<Integer> courseIds, List<String> courseDesc, Integer studentId) 
	{
		
		for (int i = 0; i < courseIds.size(); i++)
		{
			
			StudentCourseEnrolled stndCourEnroll = new StudentCourseEnrolled(courseIds.get(i), courseDesc.get(i), studentId);
			studentEnrollRepository.save(stndCourEnroll);
			
		}
		
		
	}

	@Override
	public List<String> getAvailableCourses() 
	{
		List<String> listCourseName = new ArrayList<String>();
		List<Course> listOfCourses = studentEnrollRepository.getAllAvailableCourses();
		for (Course course : listOfCourses) 
		{
			StringBuffer sb = new StringBuffer(Integer.toString(course.getCourseLevel())).append("-").append(course.getCourseDescription());
			System.out.println("stri buffer value "+sb.toString());
			
			listCourseName.add(sb.toString());
			
		}
		return listCourseName;
		
	}

	@Override
	public Student getStudentProfile(int studentId) 
	{
		return studentRepository.findOne(studentId);
		
		
	}

	@Override
	public void updateStudentProfile(Student student) 
	{
		
		studentRepository.save(student);
		
	}

	@Override
	public void updateImageUploadedOrNotField(Integer studentId) 
	{
		studentRepository.updateImageUploadedOrNotField(true, studentId);
		
	}

	@Override
	public List<StudentCourseEnrolled> getStudentEnrolledCourses(int studentId) 
	{
				
		return (List<StudentCourseEnrolled>) studentCourseEnrollRepository.findAll();
	}

	@Override
	public boolean doesUserNameExist(String userName) 
	{
		Student studentOb = studentRepository.findByUserName(userName);
		
		if(studentOb != null)
			return true;
		else
			return false;
	}
	
	@Override
	public void save(Student student) {
		studentRepository.save(student);

	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) studentRepository.findAll();
	}
	

}
