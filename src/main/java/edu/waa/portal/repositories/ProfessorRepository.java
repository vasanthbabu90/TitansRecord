package edu.waa.portal.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.waa.portal.model.Professor;

@Repository("profRepo")
public interface ProfessorRepository extends CrudRepository<Professor, String> {

}
