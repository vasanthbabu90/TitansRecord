package edu.waa.portal.service;

import java.util.List;

import edu.waa.portal.model.Professor;

public interface ProfessorService {
	
	public void save(Professor professor);
	
	public void updateProfessor(Professor professor);

	public List<Professor> getAllProfessors();

	public Professor getProfessorById(int id);

}
