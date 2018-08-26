package com.balceda.dao.interfaces;

import com.balceda.dao.excepciones.ExcepcionDAO;
import com.balceda.entidades.Productos;
import java.util.List;

/**
 *
 * @author jbalceda
 */
public interface ProductoDAO extends EntidadDAO<Productos> {

    public List<Productos> filterByPrecios(Float inicio, Float fin) throws ExcepcionDAO;
}
