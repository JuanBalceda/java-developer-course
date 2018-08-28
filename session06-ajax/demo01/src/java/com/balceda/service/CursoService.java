/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.service;

import com.balceda.model.Curso;

/**
 *
 * @author jbalceda
 */
public interface CursoService {
    Curso consultar(String nombre);
}
