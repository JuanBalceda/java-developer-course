/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.dao.implementacion;

import com.balceda.dao.interfaces.ProductoDAO;
import com.balceda.entidades.Productos;

/**
 *
 * @author jbalceda
 */
public class DAOFactory {
    
    private DAOFactory() {
    }
    
    public static DAOFactory getInstance() {
        return DAOFactoryHolder.INSTANCE;
    }
    
    private static class DAOFactoryHolder {

        private static final DAOFactory INSTANCE = new DAOFactory();
    }
    
    public ProductoDAO getProductoDao(){
        return new ProductoDAOImpl(Productos.class);
    }
}
