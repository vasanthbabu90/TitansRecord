/*package edu.waa.portal.controllers.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import edu.waa.portal.model.Student;
import edu.waa.portal.repositories.StudentRepository;

public class UsernameValidator implements ConstraintValidator<UserName, String> {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void initialize(UserName paramA) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext ctx)  //this userName is different
	{
		List<Student> stdList = new ArrayList<Student>();
		System.out.println("first size "+stdList.size());
		
		try {
			System.out.println("inside try "+stdList.size());
			stdList = studentRepository.getAllAvailableuserName();
			
		} catch (Exception e) {
			System.out.println("inside catch");
			return true;
		}
		
		System.out.println("list size "+stdList.size());
		if(stdList.size() == 0) {
			return true;
		}
		for (Student student : stdList) {
			if(student.getUserName().equals(userName));
				return false;
		}
		
		return true;
	}

}
*/