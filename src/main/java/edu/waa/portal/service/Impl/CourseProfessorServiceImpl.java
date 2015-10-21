package edu.waa.portal.service.Impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import edu.waa.portal.model.CourseProfessor;
import edu.waa.portal.repositories.CourseProfessorRepository;
import edu.waa.portal.service.CourseProfessorService;

@Service
@Transactional
public class CourseProfessorServiceImpl implements CourseProfessorService {

	@Resource(name = "courseProf")
	CourseProfessorRepository courseProfRepo;

	@Override
	public void save(CourseProfessor CourseProfessor) {
		courseProfRepo.save(CourseProfessor);
	}

	@Override
	public List<CourseProfessor> getAllAssigned() {
		return (List<CourseProfessor>) courseProfRepo.findAll();
	}

}
