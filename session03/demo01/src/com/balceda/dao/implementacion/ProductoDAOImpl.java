/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.dao.implementacion;

import com.balceda.dao.excepciones.ExcepcionDAO;
import com.balceda.dao.interfaces.ProductoDAO;
import com.balceda.entidades.Productos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author jbalceda
 */
public class ProductoDAOImpl extends EntidadDaoImpl<Productos> implements ProductoDAO {

    EntityManagerFactory emf;
    EntityManager em;

    public ProductoDAOImpl(Class<Productos> objeto) {
        super(objeto);
        emf = Persistence.createEntityManagerFactory("dev_sesion03PU");
        em = emf.createEntityManager();
    }

    @Override
    public List<Productos> filterByPrecios(Float priceMin, Float priceMax) throws ExcepcionDAO {
        List<Productos> lista;
        Query q = em.createNamedQuery("Productos.filter");
        q.setParameter("priceMin", priceMin);
        q.setParameter("priceMax", priceMax);
        try {
            lista = q.getResultList();
        } catch (NoResultException e) {
            lista = null;
        }
        return lista;
    }
}
