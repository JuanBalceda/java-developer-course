package com.balceda.developer.daos;

import com.balceda.developer.pojos.Persona;
import java.sql.SQLException;
import java.util.List;


import com.ibatis.sqlmap.client.SqlMapClient;

public class PersonaDaoImpl  implements PersonaDao {
	
	private SqlMapClient sqlMapClient;

	public void setSqlMapClient(SqlMapClient sqlMapClient) {
		this.sqlMapClient = sqlMapClient;
	}

	public PersonaDaoImpl(SqlMapClient sqlMapClient) {
		this.setSqlMapClient(sqlMapClient);
	}

	public void registrar(Persona persona) {
		try {
			sqlMapClient.insert("persona.registrar", persona);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void actualizar(Persona persona) {
		try {
			sqlMapClient.update("persona.actualizar", persona);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public Persona obtener(Long id) {
		try {
			return (Persona) sqlMapClient.queryForObject("persona.obtener", id);
		} catch (SQLException e) {
			return null;
		}
	}


	public void eliminar(Long id) {
		try {
			sqlMapClient.delete("persona.eliminar", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public List<Persona> listar() {
		try {
			return (List<Persona>)sqlMapClient.queryForList("persona.listar");
		} catch (SQLException e) {
			return null;
		}
	}

}
