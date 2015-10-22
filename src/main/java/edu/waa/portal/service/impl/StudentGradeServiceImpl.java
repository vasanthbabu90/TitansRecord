package edu.waa.portal.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.waa.portal.model.Course;
import edu.waa.portal.model.CourseProfessor;
import edu.waa.portal.model.Professor;
import edu.waa.portal.model.StudentCourseEnrolled;
import edu.waa.portal.repositories.CourseProfessorRepository;
import edu.waa.portal.repositories.ProfessorRepository;
import edu.waa.portal.repositories.StudentGradeRepository;
import edu.waa.portal.service.CourseProfessorService;
import edu.waa.portal.service.ProfessorService;
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

	@Override
	public List<StudentCourseEnrolled> getStudentsWithCourse(int courseLevel) {
		
		return (List<StudentCourseEnrolled>) studentGradeRepository.getStudentsWithCourse(courseLevel);
		
	}

	@Override
	public StudentCourseEnrolled getStudentEnrolledById(int enrollmentId) {
		return studentGradeRepository.findOne(enrollmentId);
	}

	@Override
	public void updateStudentGrade(StudentCourseEnrolled studentEnrolled) {
		
		studentGradeRepository.updateStudentGrade(studentEnrolled.getEnrolledId(),studentEnrolled.getGrade());		
	}

}
