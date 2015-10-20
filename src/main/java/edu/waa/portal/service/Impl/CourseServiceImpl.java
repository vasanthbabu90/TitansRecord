package edu.waa.portal.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import edu.waa.portal.model.Course;
import edu.waa.portal.repositories.CourseRepository;
import edu.waa.portal.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Resource(name = "courseRepo")
	CourseRepository courseRepo;

	@Override
	public void save(Course course) {
		courseRepo.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return (List<Course>) courseRepo.findAll();
	}

}
