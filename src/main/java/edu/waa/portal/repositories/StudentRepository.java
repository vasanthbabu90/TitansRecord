package edu.waa.portal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.waa.portal.model.Student;

@Repository("studentRepo")
public interface StudentRepository extends CrudRepository<Student, Integer> {
	/*@Query("select s from Student s where s.id = :id")
	Student locateOneEmployeeByHisNumber(@Param("id") int id);*/
}
