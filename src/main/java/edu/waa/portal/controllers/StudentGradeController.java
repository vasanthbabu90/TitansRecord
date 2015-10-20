package edu.waa.portal.controllers;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.waa.portal.model.StudentCourseEnrolled;
import edu.waa.portal.model.StudentGrade;
import edu.waa.portal.service.ProfessorService;
import edu.waa.portal.service.StudentGradeService;
 

@Controller
@RequestMapping(value = "rest/studentGrade")
public class StudentGradeController {


	@Autowired
	private StudentGradeService studentGradeService;
	 

 	@RequestMapping(value = "/saveGrade", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String saveStudentGrade(@RequestBody List<StudentGrade> studentGrades, HttpServletRequest request) {
		 
 		Map<Integer, String> grades = studentGrades.stream().collect(Collectors.toMap(StudentGrade::getSutdentid, StudentGrade::getGrade));
 	 		
 		studentGradeService.updateStudentGrade(grades);
 		
 		return "home";
	}
 	/*{
 		  "cars":[
 		    {
 		      "color":"Blue",
 		      "miles":100,
 		      "vin":"1234"
 		    },
 		    {
 		      "color":"Red",
 		      "miles":400,
 		      "vin":"1235"
 		    }
 		  ] 		
 		}*/

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason="Internal server error")
	public void handleServerErrors(Exception ex) {	}
}
