package edu.waa.portal.service;

import java.util.List;
import java.util.Map;

import edu.waa.portal.model.*;

public interface ProfessorService {

	public Professor getProfessorById(int id);
	public void Save(Professor professor); 
}
