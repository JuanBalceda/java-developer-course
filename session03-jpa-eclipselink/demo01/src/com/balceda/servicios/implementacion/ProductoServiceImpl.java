/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.servicios.implementacion;

import com.balceda.dao.excepciones.ExcepcionDAO;
import com.balceda.dao.implementacion.DAOFactory;
import com.balceda.dao.interfaces.ProductoDAO;
import com.balceda.entidades.Productos;
import com.balceda.servicios.excepciones.ExcepcionService;
import com.balceda.servicios.interfaces.ProductoService;
import java.util.List;

/**
 *
 * @author jbalceda
 */
public class ProductoServiceImpl implements ProductoService {

    ProductoDAO dao;

    public ProductoServiceImpl() {
        DAOFactory factory = DAOFactory.getInstance();
        dao = factory.getProductoDao();
    }
    
    @Override
    public void create(Productos t) throws ExcepcionService {
        try {
            dao.create(t);
        } catch (ExcepcionDAO ex) {
            throw new ExcepcionService();
        }
    }

    @Override
    public void update(Productos t) throws ExcepcionService {
        try {
            dao.update(t);
        } catch (ExcepcionDAO ex) {
            throw new ExcepcionService();
        }
    }

    @Override
    public void delete(Productos t) throws ExcepcionService {
        try {
            dao.delete(t);
        } catch (ExcepcionDAO ex) {
            throw new ExcepcionService();
        }
    }

    @Override
    public Productos find(Object id) throws ExcepcionService {
        Productos p;
        try {
            p = dao.find(id);
        } catch (ExcepcionDAO ex) {
            throw new ExcepcionService();
        }
        return p;
    }

    @Override
    public List<Productos> findAll() throws ExcepcionService {
        List<Productos> pList;
        try {
            pList = dao.findAll();
        } catch (ExcepcionDAO ex) {
            throw new ExcepcionService();
        }
        return pList;
    }

}
