package com.balceda.developer.daos;

import com.balceda.developer.pojos.Persona;
import java.util.List;

public interface PersonaDao {

	void registrar(Persona persona);

	void actualizar(Persona persona);
	
	Persona obtener(Long id);
	
	void eliminar(Long id);

	List<Persona> listar();

}
