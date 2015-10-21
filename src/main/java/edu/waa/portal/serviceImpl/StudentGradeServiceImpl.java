package edu.waa.portal.serviceImpl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.waa.portal.repositories.StudentGradeRepository;
import edu.waa.portal.service.StudentGradeService;

@Service
@Transactional
public class StudentGradeServiceImpl implements StudentGradeService {

	@Autowired
	StudentGradeRepository studentGradeRepository;

	@Override
	public void updateStudentGrade(Map<Integer, String> studentGrades) {

		studentGrades.forEach((k, v) -> {
			studentGradeRepository.updateStudentGrade(k,v);
		});

	}

}
