package edu.waa.portal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.waa.portal.model.LoginUser;
import edu.waa.portal.model.Student;
import edu.waa.portal.repositories.StudentRepository;

@Controller
@SessionAttributes("studentID")
public class LoginController 
{
	@Autowired
	StudentRepository studentRepo;
	
	@RequestMapping(value = "/student", method = RequestMethod.GET)
	public String studentLogin(Model model)
	{
		System.out.println("inside student login ");
		//model.addAttribute("loginAction", "StudentLogin");
		model.addAttribute("loginUser", new LoginUser());
		return "LoginPage";
	}
	
	@RequestMapping(value = "/student", method = RequestMethod.POST)
	public String studentLogin(@ModelAttribute("loginUser") LoginUser loginUser, Model model)
	{
		
		System.out.println("user id "+loginUser.getUserId() +" pass"+loginUser.getPassword());
		Student student = studentRepo.findOne(loginUser.getUserId());
		if(student != null)
		{
			if(student.getStudentId() == loginUser.getUserId() && student.getPassword().equals(loginUser.getPassword()))
			{
				model.addAttribute("studentID", student.getStudentId());
				return "redirect:/student/editProfile"; //to home page
			}
		}
		
			model.addAttribute("Message", "Invalid Password or userName");
			return "Login";
			
		
	}
	
	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public String professorLoginLogin(Model model)
	{
		model.addAttribute("loginUser", new LoginUser());
		return "LoginPage";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}
	

}
