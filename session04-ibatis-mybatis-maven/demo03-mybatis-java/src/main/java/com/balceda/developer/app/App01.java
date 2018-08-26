/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.developer.app;

import com.balceda.developer.dao.PersonaDaoImpl;
import com.balceda.developer.model.Persona;

/**
 *
 * @author jbalceda
 */
public class App01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonaDaoImpl daoImpl = new PersonaDaoImpl();
        Persona p = new Persona("Olimpo", "Carpio", 30);
        daoImpl.insertPersona(p);
    }
    
}
