package edu.waa.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.StudentCourseEnrolled;

@Repository
public interface StudentCourseEnrollRepository extends CrudRepository<StudentCourseEnrolled, Integer>
{
	
	@Query("select u from Course u")
	List<Course> getAllAvailableCourses();
	
}
