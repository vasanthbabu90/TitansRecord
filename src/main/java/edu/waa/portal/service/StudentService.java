package edu.waa.portal.service;

import java.util.List;

import edu.waa.portal.model.Student;

public interface StudentService {
public void save(Student student);
public List<Student> getAllStudents();
}
