/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.servicios.excepciones;

/**
 *
 * @author jbalceda
 */
public class ExcepcionService extends Exception {

    /**
     * Creates a new instance of <code>ExcepcionService</code> without detail
     * message.
     */
    public ExcepcionService() {
    }

    /**
     * Constructs an instance of <code>ExcepcionService</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcepcionService(String msg) {
        super(msg);
    }
}
