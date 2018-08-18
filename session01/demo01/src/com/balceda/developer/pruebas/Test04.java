/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.developer.pruebas;

import com.balceda.developer.pojos.Curso;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;

/**
 *
 * @author jbalceda
 */
public class Test04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        Criteria crit = session.createCriteria(Curso.class);
        Curso curso = new Curso();
        curso.setNombre("Java");
        crit.add(Example.create(curso));
        List<Curso> results = crit.list();
        for (Curso c : results) {
            System.out.println("" + c.getNombre());
        }
    }

}
