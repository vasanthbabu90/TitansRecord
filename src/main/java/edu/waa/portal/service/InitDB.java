package edu.waa.portal.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.Student;
import edu.waa.portal.repositories.CourseRepository;
import edu.waa.portal.repositories.StudentRepository;

@Service
public class InitDB 
{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@PostConstruct
	public void init()
	{
		Date date = new Date(2015, 05, 22); //my sql date formate 2015-05-02 (yy-mm-dd)
		Student student = new Student("Nadal", date, "male", "nadal.gmail.com","12345","vasanth", date);
		Student student1 = new Student("Nadal", date, "male", "nadal.gmail.com","12345","Nadal", date);
		studentRepository.save(student);
		studentRepository.save(student1);
		
			Course course1 = new Course("BigData", "BigData", "425");
			Course course2 = new Course("SystemAnalysis", "SystemAnalysis", "435");
						
			courseRepository.save(course1);
			courseRepository.save(course2);
			
		
		
		
	}

}
