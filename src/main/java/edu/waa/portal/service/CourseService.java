package edu.waa.portal.service;

import java.util.List;

import edu.waa.portal.model.Course;

public interface CourseService {
	public void save(Course course);
	public List<Course> getAllCourses();
}
