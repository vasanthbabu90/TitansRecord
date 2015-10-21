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
import edu.waa.portal.model.CourseProfessor;
import edu.waa.portal.model.Professor;
import edu.waa.portal.model.Student;
import edu.waa.portal.service.CourseProfessorService;
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
	@Autowired
	CourseProfessorService courseProfessor;

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
	@RequestMapping(value = "/listProfessors", method = RequestMethod.GET)
	public String allProfessors(Model model) {
		model.addAttribute("professors", professorService.getAllProfessors());
		return "listProfessors";
	}

	@RequestMapping(value = "/addProfessor", method = RequestMethod.GET)
	public String inputProfessor(@ModelAttribute("addProfessor") Professor professor) {
		return "addProfessor";
	}

	@RequestMapping(value = "/addProfessor", method = RequestMethod.POST)
	public String addProfessor(@ModelAttribute("addProfessor") Professor professor) {
		professorService.save(professor);
		return "redirect:/listProfessors";
	}

	// course add and display
	@RequestMapping(value = "/listCourses", method = RequestMethod.GET)
	public String allCourses(Model model) {
		model.addAttribute("courses", courseService.getAllCourses());
		return "listCourses";
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.GET)
	public String inputCourse(@ModelAttribute("addCourse") Course course) {
		return "addCourse";
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST)
	public String addCourse(@ModelAttribute("addCourse") Course course) {
		courseService.save(course);
		return "redirect:/listCourses";
	}

	// courses and Professor
	@RequestMapping(value = "/assignCourses", method = RequestMethod.GET)
	public String listCoursesAndProfessors(@ModelAttribute("courseProf") CourseProfessor courseProf, Model model) {
		model.addAttribute("availableCourses", courseService.getAllCourses());
		model.addAttribute("availableProfessors", professorService.getAllProfessors());
		model.addAttribute("courseProfessorList", courseProfessor.getAllAssigned());

		return "assignCourses";
	}

	@RequestMapping(value = "/assignCourses", method = RequestMethod.POST)
	public String assignCourses(@Valid @ModelAttribute("courseProf") CourseProfessor courseProf, Model model) {
		courseProfessor.save(courseProf);
		return "redirect:assignCourses";
	}
}
