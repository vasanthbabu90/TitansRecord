package edu.waa.portal.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>
{
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update Student u set u.imageUploadedOrNot = ?1 where u.studentId = ?2") //more than one query annotation allowed at java 1.8 or above
	void updateImageUploadedOrNotField(Boolean value, Integer studentId);
	
	@Query("select u from Student u where u.userName= ?1")
	Student findByUserName(String userName);
	
	
	/*@Query("select u from Student u")
	List<Student> getAllAvailableuserName();*/
	
}
