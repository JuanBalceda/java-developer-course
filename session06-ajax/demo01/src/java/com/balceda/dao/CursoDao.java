/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.dao;

import com.balceda.model.Curso;

/**
 *
 * @author jbalceda
 */
public interface CursoDao {
    Curso consultar(String nombre);
}
