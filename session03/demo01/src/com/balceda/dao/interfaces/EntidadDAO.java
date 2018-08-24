package com.balceda.dao.interfaces;

import com.balceda.dao.excepciones.ExcepcionDAO;
import java.util.List;

/**
 *
 * @author jbalceda
 */
public interface EntidadDAO<T> {

    public void create(T t) throws ExcepcionDAO;

    public void update(T t) throws ExcepcionDAO;

    public void delete(T t) throws ExcepcionDAO;

    public T find(Object id) throws ExcepcionDAO;

    public List<T> findAll() throws ExcepcionDAO;

}
