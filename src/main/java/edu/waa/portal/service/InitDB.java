package edu.waa.portal.service;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.Student;
import edu.waa.portal.model.User;
import edu.waa.portal.model.UserRole;
import edu.waa.portal.repositories.CourseRepository;
import edu.waa.portal.repositories.LoginRepository;
import edu.waa.portal.repositories.StudentRepository;

@Service
public class InitDB 
{
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@PostConstruct
	public void init()
	{
		User user = new User("roger", "12345");
		UserRole userRole = new UserRole();
		
		userRole.setRolename("ROLE_ADMIN");
		userRole.setUser(user);
		
		user.setUserRole(userRole);
		loginRepository.save(user);
		
		
		
		
	}

}
