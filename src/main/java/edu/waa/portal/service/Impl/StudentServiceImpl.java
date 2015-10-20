package edu.waa.portal.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.waa.portal.model.Student;
import edu.waa.portal.repositories.StudentRepository;
import edu.waa.portal.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Resource(name = "studentRepo")
	StudentRepository stdRepo;

	@Override
	public void save(Student student) {
		stdRepo.save(student);

	}

	@Override
	public List<Student> getAllStudents() {
		return (List<Student>) stdRepo.findAll();
	}

}
