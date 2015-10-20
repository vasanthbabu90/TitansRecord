package edu.waa.portal.repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.waa.portal.model.Professor;

@Repository("profRepo")
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {
	@Query("select p from Professor p where p.id = :id")
	public Professor getProfessorById(@Param("id") int id);		
	
	@Modifying
	@Transactional
	@Query("update Professor p set p.fullName = :fullName, p.gender = :gender, p.email = :email, p.phone = :phone where p.id = :id")
	public void updateProfessor(@Param("id") int id,@Param("fullName") String fullName,@Param("gender") String gender,@Param("email") String email,@Param("phone") String phone);	
 
}

