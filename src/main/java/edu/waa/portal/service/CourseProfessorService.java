package edu.waa.portal.service;

import java.util.List;
import java.util.Map;

import edu.waa.portal.model.*;

public interface CourseProfessorService {

	public List<CourseProfessor> getCoursesAssigned(String professorName);
	 
}
