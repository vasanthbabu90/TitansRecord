package edu.waa.portal.controllers;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import edu.waa.portal.model.LoginUser;
import edu.waa.portal.model.Professor;
import edu.waa.portal.model.Student;
import edu.waa.portal.model.User;
import edu.waa.portal.repositories.LoginRepository;
import edu.waa.portal.repositories.ProfessorRepository;
import edu.waa.portal.repositories.StudentRepository;

@Controller
@SessionAttributes("USERID")
public class LoginController 
{
	@Autowired
	StudentRepository studentRepo;
	
	@Resource(name = "profRepo")
	ProfessorRepository professorRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
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
				model.addAttribute("USERID", student.getStudentId());
				return "redirect:/student/viewProfile"; //to home page
			}
		}
		
			model.addAttribute("Message", "Invalid Password or userName");
			return "LoginPage";
			
		
	}
	
	
	/** for professor **/
	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public String adminLogin(Model model)
	{
		System.out.println("inside professor login ");
		//model.addAttribute("loginAction", "StudentLogin");
		model.addAttribute("loginUser", new LoginUser());
		return "LoginPage";
	}
	
	@RequestMapping(value = "/professor", method = RequestMethod.POST)
	public String adminLogin(@ModelAttribute("loginUser") LoginUser loginUser, Model model)
	{
		
		System.out.println("user id "+loginUser.getUserId() +" pass"+loginUser.getPassword());
		Professor professor = professorRepository.findOne(loginUser.getUserId());
		System.out.println("from DB user id "+professor.getId() +" pass in DB "+professor.getPassword());
		
		if(professor != null)
		{
			if((professor.getId() == loginUser.getUserId()) && (professor.getPassword().equals(loginUser.getPassword())))
			{
				model.addAttribute("USERID", professor.getId());
				return "redirect:/professor/viewprofessor"; //to view last 
			}
		}
		
			model.addAttribute("Message", "Invalid Password or userName");
			return "LoginPage";
			
		
	}
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminLogin(ModelMap model) {
		System.out.println("inside admin Login login ");
		return "adminhome";
	}
	
	
	/** for security **/
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("inside security login ");
		return "login";
	}
	
	// not using 
	@RequestMapping(value = "/securitycheck", method = RequestMethod.POST)
	public String secuirtylogin(User user) {
		System.out.println("inside security login check" + user.getUsername() +"pass "+user.getPassword());
		User userFromDB = loginRepository.getUserByName(user.getUsername());
		System.out.println("value from DB " + userFromDB.getUsername() +"pass "+userFromDB.getPassword());
		
		if(userFromDB.getUsername().equals(user.getUsername()) && userFromDB.getPassword().equals(user.getPassword()))
		{
			System.out.println("inside if");
			return "redirect:/admin";
		}
		return "redirect:/login";
		
	}
	
	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {
		model.addAttribute("error", "true");
		return "denied";
	}
	

}
