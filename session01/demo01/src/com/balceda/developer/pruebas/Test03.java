/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.developer.pruebas;

import com.balceda.developer.pojos.Curso;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author jbalceda
 */
public class Test03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();
        Query query = session.createQuery("from Curso");
        //query.setFirstResult(1);
        //query.setMaxResults(2);
        List<Curso> results = query.list();
        for (Curso c : results) {
            System.out.println("" + c.getNombre());
        }
    }

}
