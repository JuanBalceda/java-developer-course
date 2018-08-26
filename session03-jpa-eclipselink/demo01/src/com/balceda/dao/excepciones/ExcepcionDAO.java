/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.dao.excepciones;

/**
 *
 * @author jbalceda
 */
public class ExcepcionDAO extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionDAO</code> without detail
     * message.
     */
    public ExcepcionDAO() {
    }

    /**
     * Constructs an instance of <code>ExcepcionDAO</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionDAO(String msg) {
        super(msg);
    }
}
