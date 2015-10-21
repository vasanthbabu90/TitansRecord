package edu.waa.portal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.waa.portal.model.Course;
import edu.waa.portal.repositories.CourseRepository;
import edu.waa.portal.service.CourseService;

@Service
@Transactional
public class CourseServiceImpl implements CourseService
{

	@Autowired
	CourseRepository courseRepository;
	@Override
	public void saveCourse(Course course) 
	{
		System.out.println("inside service ");
		courseRepository.save(course);
		
	}
	

}
