package com.balceda.developer.dao;

import com.balceda.developer.model.Persona;
import java.util.List;

public interface PersonaDao {

	void insertPersona(Persona persona);

	void updatePersona(Persona persona);
	
	Persona getPersonaById(int id);
	
	void deletePersona(int id);

	List<Persona> getAllPersonas();

}
