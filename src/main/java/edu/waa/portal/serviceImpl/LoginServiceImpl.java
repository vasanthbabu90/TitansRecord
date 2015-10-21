package edu.waa.portal.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.waa.portal.model.User;
import edu.waa.portal.model.UserRole;
import edu.waa.portal.repositories.LoginRepository;
import edu.waa.portal.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService
{

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public void saveUser(User user) {
		// TODO Auto-generated method stub
		
		UserRole userRole = new UserRole();
		userRole.setRolename("ROLE_STUDENT");
		userRole.setUser(user);
		
		user.setUserRole(userRole);
		
		loginRepository.save(user);
	}
	
	

}
