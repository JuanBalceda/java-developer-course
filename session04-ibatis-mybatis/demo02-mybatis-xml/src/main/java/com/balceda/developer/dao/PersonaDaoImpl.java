package com.balceda.developer.dao;

import com.balceda.developer.model.Persona;
import com.balceda.developer.util.MyBatisUtil;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class PersonaDaoImpl implements PersonaDao {

    @Override
    public void insertPersona(Persona persona) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            PersonaDao dao = sqlSession.getMapper(PersonaDao.class);
            dao.insertPersona(persona);
            sqlSession.commit();
        }
    }

    @Override
    public void updatePersona(Persona persona) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            PersonaDao dao = sqlSession.getMapper(PersonaDao.class);
            dao.updatePersona(persona);
            sqlSession.commit();
        }
    }

    @Override
    public Persona getPersonaById(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            PersonaDao dao = sqlSession.getMapper(PersonaDao.class);
            return dao.getPersonaById(id);
        }
    }

    @Override
    public void deletePersona(int id) {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            PersonaDao dao = sqlSession.getMapper(PersonaDao.class);
            dao.deletePersona(id);
            sqlSession.commit();
        }
    }

    @Override
    public List<Persona> getAllPersonas() {
        try (SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory().openSession()) {
            PersonaDao dao = sqlSession.getMapper(PersonaDao.class);
            return dao.getAllPersonas();
        }
    }

}
