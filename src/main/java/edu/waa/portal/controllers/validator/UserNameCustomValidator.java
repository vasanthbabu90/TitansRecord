package edu.waa.portal.controllers.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import edu.waa.portal.model.Student;
import edu.waa.portal.service.StudentService;

@Component
public class UserNameCustomValidator implements Validator
{

	@Autowired
	StudentService studentService;
	
	@Override
	public boolean supports(Class clazz) {
		
		return Student.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object targetUser, Errors errors) 
	{
		Student student = (Student) targetUser;
		if(studentService.doesUserNameExist(student.getUserName()))
		{
			System.out.println("*************"+errors);
			errors.rejectValue("userName", "userName.exists");	
			System.out.println("*************"+errors.getAllErrors().get(0));
		}
		
	}
	
	

}
