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
public class ProfessorController 
{
	
	@Autowired
	ProfessorService professorService;
	
	@Autowired
	CourseProfessorService courseProfessorService;
	
	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public String getProfessorById(@RequestParam("id") int id,Model model)
	{
		 Professor professor = professorService.getProfessorById(id);
		 model.addAttribute("professor", professor);
		 
		 return "professor";		
		 
	}
	
	@RequestMapping(value = "/professor", method = RequestMethod.POST)
	public String saveProfessor(@Valid @ModelAttribute("professor") Professor professor , BindingResult result,RedirectAttributes redirectAttributes){
		
		if(result.hasErrors()){
			return "professor";
		}		
		professorService.Save(professor);
		
		redirectAttributes.addAttribute("professor", professor);
		
		return "redirect:professorView";
	}
		  
	  @RequestMapping(value="/professorView", method = RequestMethod.GET)
	  public String professorView(Model model) throws IOException {

		 Professor professor = (Professor)( ((ModelMap) model).get("professor") );

	  	  if (professor == null)
	  		throw new IOException("The Professor is Null, Try Again!");
	  	  
	        return "professorView";
	  }
	  
		@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public String getCoursesAssignedByProfId(@RequestParam("profId") int profId,Model model)
		{
			 List<CourseProfessor> coures = courseProfessorService.getCoursesAssigned(profId);
			 model.addAttribute("professorCourses", coures);
			 
			 return "professorCourseView";		
			 
		}


}
