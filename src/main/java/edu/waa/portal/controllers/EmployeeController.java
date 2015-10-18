package edu.waa.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.waa.portal.model.Employee;
import edu.waa.portal.repositories.EmployeeRepository;

@Controller
public class EmployeeController 
{
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employeeSave()
	{
		System.out.println("inside employee controller ");
		Employee emp = new Employee();
		emp.setName("roger");
		emp.setAge(13);
		employeeRepository.save(emp);
		
		return "home";
	}

}
