package edu.waa.portal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.CourseProfessor;
import edu.waa.portal.model.Professor;

@Repository
public interface CourseProfessorRepository extends CrudRepository<CourseProfessor, String>{
 
	@Query("select c from CourseProfessor c where c.professorName = :professorName")
	public List<CourseProfessor> getCoursesAssigned(@Param("professorName") String professorName);
}
