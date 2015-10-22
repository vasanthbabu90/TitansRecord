package edu.waa.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.CourseProfessor;
import edu.waa.portal.model.Professor;
import edu.waa.portal.model.StudentCourseEnrolled;
 

@Repository
public interface StudentGradeRepository extends CrudRepository<StudentCourseEnrolled, Integer>{
	
	@Modifying
	@Transactional
	@Query("update StudentCourseEnrolled s set s.grade=:grade where s.enrolledId = :enrolledId")
	public void updateStudentGrade(@Param("enrolledId") int enrolledId,@Param("grade") String grade);

	@Query("select s from StudentCourseEnrolled s where s.courseIdLevel = :courseIdLevel")
	public List<StudentCourseEnrolled> getStudentsWithCourse(@Param("courseIdLevel") int courseIdLevel);
	 
}
