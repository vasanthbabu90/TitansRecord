package edu.waa.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.CourseProfessor;
import edu.waa.portal.model.Professor;
import edu.waa.portal.repositories.CourseProfessorRepository;
import edu.waa.portal.repositories.ProfessorRepository;
import edu.waa.portal.repositories.StudentGradeRepository;
import edu.waa.portal.service.CourseProfessorService;
import edu.waa.portal.service.ProfessorService;

@Service
@Transactional
public class CourseProfessorServiceImpl implements CourseProfessorService {

	@Autowired
	CourseProfessorRepository  courseProfessorRepository;
	  

	@Override
	public List<CourseProfessor> getCoursesAssigned(int profId) {
		 
		return (List<CourseProfessor>)courseProfessorRepository.getCoursesAssigned(profId);
	}
 
}
