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
public interface ProfessorRepository extends CrudRepository<Professor, Integer>{
	
	@Query("select p from Professor p where p.id = :id")
	public Professor getProfessorById(@Param("id") int id);	
	
}
