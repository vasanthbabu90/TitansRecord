package edu.waa.portal.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.waa.portal.model.Professor;
import edu.waa.portal.model.StudentCourseEnrolled;
import edu.waa.portal.model.StudentGrade;
import edu.waa.portal.service.CourseService;
import edu.waa.portal.service.ProfessorService;
import edu.waa.portal.service.StudentGradeService;
 

@Controller
public class StudentGradeController {

	@Autowired
	private StudentGradeService studentGradeService;
	
	@Autowired
	private CourseService courseService;
	 
	
 	@RequestMapping(value = "/getStudentsWithCourse", method = RequestMethod.GET)
	public String getStudentsWithCourse(@RequestParam("course") int courseLevel, Model model) {
	
 		model.addAttribute("studentsList", studentGradeService.getStudentsWithCourse(courseLevel));		
 		return "listStudentsForGrade"; 		
	}
		
 	@RequestMapping(value = "/editStudentGrade", method = RequestMethod.GET)
	public String editStudentGrade(@RequestParam("id") int enrollmentId, Model model) {	

 		model.addAttribute("studentEnrolled", studentGradeService.getStudentEnrolledById(enrollmentId));
 		 		
 		return "updateStudentGrade";
 		
	}
	
	@RequestMapping(value = "/editStudentGrade", method = RequestMethod.POST)
	public String editProfessor(@Valid @ModelAttribute("studentEnrolled") StudentCourseEnrolled studentEnrolled , BindingResult result){
		
		if(result.hasErrors()){
			return "updateStudentGrade";
		}		
		studentGradeService.updateStudentGrade(studentEnrolled);		
		
		return "redirect:/getStudentsWithCourse?course="+studentEnrolled.getCourseIdLevel();
	}	
	
 	
 	
 	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal server error")
	public void handleServerErrors(Exception ex) {	}
}
