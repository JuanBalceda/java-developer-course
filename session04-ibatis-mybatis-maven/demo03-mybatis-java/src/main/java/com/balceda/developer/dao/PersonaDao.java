package com.balceda.developer.dao;

import com.balceda.developer.model.Persona;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface PersonaDao {

    @Insert("INSERT INTO persona(nombres, apellidos, edad) VALUES(#{nombres}, #{apellidos}, #{edad})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertPersona(Persona persona);

    @Update("UPDATE persona SET nombres=#{nombres}, apellidos=#{apellidos}, edad=#{edad} WHERE id=#{id}")
    void updatePersona(Persona persona);

    @Select("SELECT id AS id, nombres as nombres, apellidos as apellidos, edad as edad FROM persona WHERE id=#{id}")
    Persona getPersonaById(int id);

    @Delete("DELETE FROM persona WHERE id=#{id}")
    void deletePersona(int id);

    @Select("SELECT * FROM persona")
    @Results({
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "nombres", column = "nombres"),
        @Result(property = "apellidos", column = "apellidos"),
        @Result(property = "edad", column = "edad")
    })
    List<Persona> getAllPersonas();

}
