package edu.waa.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.Professor;
import edu.waa.portal.model.StudentCourseEnrolled;
 

@Repository
public interface StudentGradeRepository extends CrudRepository<StudentCourseEnrolled, Integer>{
	
	/*@Modifying
	@Query("update StrudentCourseEnrolled sc where sc.studentid = :studentid")
	public void updateStudentGrade(@Param("studentid") int id);*/	
	 
}
