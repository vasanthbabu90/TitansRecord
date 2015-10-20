package edu.waa.portal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.waa.portal.model.Professor;

@Repository("profRepo")
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
	@Query("select p from Professor p where p.id = :id")
	public Professor getProfessorById(@Param("id") int id);	
}


