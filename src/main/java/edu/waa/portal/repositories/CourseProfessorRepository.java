package edu.waa.portal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.waa.portal.model.CourseProfessor;

@Repository("courseProf")
public interface CourseProfessorRepository extends CrudRepository<CourseProfessor, String>{

}
