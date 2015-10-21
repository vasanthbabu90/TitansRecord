package edu.waa.portal.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.waa.portal.model.User;

@Repository
public interface LoginRepository extends CrudRepository<User, Integer>
{
	@Query("select u from User u where u.username = ?1")
	User getUserByName(String name);
	

}
