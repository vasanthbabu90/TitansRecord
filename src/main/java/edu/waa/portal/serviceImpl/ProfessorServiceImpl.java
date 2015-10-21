package edu.waa.portal.serviceImpl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.waa.portal.model.Professor;
import edu.waa.portal.repositories.ProfessorRepository;
import edu.waa.portal.repositories.StudentGradeRepository;
import edu.waa.portal.service.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {
	
	@Resource(name = "profRepo")
	ProfessorRepository professorRepository;

	@Autowired
	StudentGradeRepository studentGradeRepository;

	@Override
	public void save(Professor professor) {
		professorRepository.save(professor);
	}
	
	public void updateProfessor(Professor professor) {
		
		System.out.println(">>>>>>>>>>>>>>>>>" +  professor.getId() + "   " +professor.getFullName());
		professorRepository.updateProfessor(professor.getId(),professor.getFullName(),professor.getGender(),professor.getEmail(),professor.getPhone());
	}

	@Override
	public List<Professor> getAllProfessors() {

		return (List<Professor>) professorRepository.findAll();
	}
	@Override
	public Professor getProfessorById(int id) {
		 
		return professorRepository.getProfessorById(id);
	}

	@Override
	public void deleteProfessor(int id) {
		professorRepository.delete(id);		
	}



}


 
 