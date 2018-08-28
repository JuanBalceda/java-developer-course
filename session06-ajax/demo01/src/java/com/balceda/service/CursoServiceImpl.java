/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.service;

import com.balceda.dao.CursoDao;
import com.balceda.dao.DaoFactory;
import com.balceda.model.Curso;

/**
 *
 * @author jbalceda
 */
public class CursoServiceImpl implements CursoService{

    CursoDao dao;
    
    public CursoServiceImpl() {
        DaoFactory factory = DaoFactory.getInstance();
        dao = factory.getCursoDao(DaoFactory.JPA);
    }
    
    @Override
    public Curso consultar(String nombre) {
        return dao.consultar(nombre);
    }
    
}
