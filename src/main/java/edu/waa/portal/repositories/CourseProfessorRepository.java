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
public interface CourseProfessorRepository extends CrudRepository<CourseProfessor, Integer>{
 
	/*@Query("select cp from CourseProfessor cp where cp.profId = :profId")
	public List<CourseProfessor> getCoursesAssigned(@Param("profId") int profId);*/
}
