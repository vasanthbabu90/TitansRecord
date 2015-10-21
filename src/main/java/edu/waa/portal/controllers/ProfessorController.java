package edu.waa.portal.controllers;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.CourseProfessor;
import edu.waa.portal.model.Professor;
import edu.waa.portal.service.CourseProfessorService;
import edu.waa.portal.service.ProfessorService;


@Controller
//@RequestMapping(value = "/professor")
public class ProfessorController 
{
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	CourseProfessorService courseProfessorService;
	
	@RequestMapping(value = "/editProfessor", method = RequestMethod.GET)
	public String getProfessorById(@RequestParam("id") int id,Model model)
	{
		 Professor professor = professorService.getProfessorById(id);
		 model.addAttribute("editProfessor", professor);		 
		 
		 return "editProfessor";		
		 
	}
	
	@RequestMapping(value = "/editProfessor", method = RequestMethod.POST)
	public String saveProfessor(@Valid @ModelAttribute("editProfessor") Professor professor , BindingResult result){
		
		if(result.hasErrors()){
			return "editProfessor";
		}		
		professorService.updateProfessor(professor);	 
		
		return "redirect:/listProfessors";
	}	
	
	@RequestMapping(value = "/deleteProfessor", method = RequestMethod.GET)
	public String deleteProfessor(@RequestParam("id") int id){
				
		professorService.deleteProfessor(id);
		
		return "redirect:/listProfessors";
	}
		  
		  
	@RequestMapping(value = "/coursesByProfessorName", method = RequestMethod.GET)
	public String getCoursesByProfessorName(@RequestParam("name") String name, Model model)
	{	
		 List<CourseProfessor> professorCourses = courseProfessorService.getCoursesAssigned(name);
		 model.addAttribute("professorCourses", professorCourses);
		 
		 return "listProfessorCourses";				 
	}


}
