package edu.waa.portal.service;

import java.util.List; 
import edu.waa.portal.model.CourseProfessor;

public interface CourseProfessorService {
	public void save(CourseProfessor CourseProfessor);
	public List<CourseProfessor> getAllAssigned();
	public List<CourseProfessor> getCoursesAssigned(String professorName);
 
}
