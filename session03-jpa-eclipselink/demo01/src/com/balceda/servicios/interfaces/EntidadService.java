/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.servicios.interfaces;

import com.balceda.servicios.excepciones.ExcepcionService;
import java.util.List;

/**
 *
 * @author jbalceda
 */
public interface EntidadService<T> {

    public void create(T t) throws ExcepcionService;

    public void update(T t) throws ExcepcionService;

    public void delete(T t) throws ExcepcionService;

    public T find(Object id) throws ExcepcionService;

    public List<T> findAll() throws ExcepcionService;
}
