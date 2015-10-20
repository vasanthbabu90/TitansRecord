package edu.waa.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.Professor; 
import edu.waa.portal.repositories.ProfessorRepository;
import edu.waa.portal.repositories.StudentGradeRepository;
import edu.waa.portal.service.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;
	
	@Autowired
	StudentGradeRepository studentGradeRepository;
	
		
	@Override
	public Professor getProfessorById(int id) {
		 
		return professorRepository.getProfessorById(id);
	}

	@Override
	public void Save(Professor professor) {

		professorRepository.save(professor);
		
	}  
	 
}
