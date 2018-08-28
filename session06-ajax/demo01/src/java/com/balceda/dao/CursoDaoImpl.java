/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.dao;

import com.balceda.model.Curso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author jbalceda
 */
public class CursoDaoImpl implements CursoDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CursoDaoImpl() {
        emf = Persistence.createEntityManagerFactory("escuelaPU");
        em = emf.createEntityManager();
    }

    @Override
    public Curso consultar(String nombre) {
        Curso c;
        Query query = em.createNamedQuery("Curso.findByVchCurNombre");
        query.setParameter("vchCurNombre", nombre);

        try {
            c = (Curso) query.getSingleResult();
        } catch (NoResultException ex) {
            c = null;
        }
        return c;
    }

}
