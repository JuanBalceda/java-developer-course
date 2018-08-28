/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.dao;

/**
 *
 * @author jbalceda
 */
public class DaoFactory {

    public static final int JPA = 0;
    public static final int HIBERNATE = 1;
    public static final int MYBATIS = 2;
    
    private DaoFactory() {
    }

    public static DaoFactory getInstance() {
        return DaoFactoryHolder.INSTANCE;
    }

    private static class DaoFactoryHolder {

        private static final DaoFactory INSTANCE = new DaoFactory();
    }

    public CursoDao getCursoDao(int tipo) {
        switch (tipo) {
            case JPA:
                return new CursoDaoImpl();
            case HIBERNATE:
                //return new AdministradorDaoImplHbn();
            case MYBATIS:
                //return new AdministradorDaoImplMyBatis();
            default:
                return null;
        }
    }
}
