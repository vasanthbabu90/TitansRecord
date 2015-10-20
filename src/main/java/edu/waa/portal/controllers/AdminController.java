package edu.waa.portal.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.Professor;
import edu.waa.portal.model.Student;
import edu.waa.portal.service.CourseService;
import edu.waa.portal.service.ProfessorService;
import edu.waa.portal.service.StudentService;

@Controller
public class AdminController {

	@Autowired
	StudentService studentService;
	@Autowired
	ProfessorService professorService;
	@Autowired
	CourseService courseService;

	// students add and display
	@RequestMapping(value = "/listStudents", method = RequestMethod.GET)
	public String allStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "listStudents";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.GET)
	public String inputStudent(@ModelAttribute("addStudent") Student student) {
		return "addStudent";
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	public String addStudent(@Valid @ModelAttribute("addStudent") Student student, BindingResult result, Model model) {
		if (result.hasErrors()) {
			System.out.println("errors >>>>>>>>" + result.getAllErrors().toString());
			return "addStudent";
		}
		model.addAttribute("student", student);
		studentService.save(student);
		return "redirect:/listStudents";
	}

	// professor add and display
	@RequestMapping(value = "/listProfessor", method = RequestMethod.GET)
	public String allProfessors(Model model) {
		model.addAttribute("professors", professorService.getAllProfessors());
		return "listProfessor";
	}
	@RequestMapping(value = "/addProfessor", method = RequestMethod.GET)
	public String inputProfessor(@ModelAttribute("addProfessor") Professor professor) {
		return "addProfessor";
	}

	@RequestMapping(value = "/addProfessor", method = RequestMethod.POST)
	public String addProfessor(@ModelAttribute("addProfessor") Professor professor) {
		professorService.save(professor);
		return "redirect:/listProfessor";
	}

	// course add and display
	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public String inputCourse(@ModelAttribute("addCourse") Course course) {
		return "addCourse";
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("addCourse") Course course) {
		courseService.save(course);
		return "redirect:/home";
	}
}
