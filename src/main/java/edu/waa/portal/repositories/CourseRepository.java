package edu.waa.portal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.waa.portal.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{

}
