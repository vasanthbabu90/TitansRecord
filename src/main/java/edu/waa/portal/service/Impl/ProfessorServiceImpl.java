package edu.waa.portal.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.waa.portal.model.Professor;
import edu.waa.portal.repositories.ProfessorRepository;
import edu.waa.portal.service.ProfessorService;

@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService {
	@Resource(name = "profRepo")
	ProfessorRepository ProfessorRepository;

	@Override
	public void save(Professor professor) {
		ProfessorRepository.save(professor);
	}

	@Override
	public List<Professor> getAllProfessors() {

		return (List<Professor>) ProfessorRepository.findAll();
	}

}
