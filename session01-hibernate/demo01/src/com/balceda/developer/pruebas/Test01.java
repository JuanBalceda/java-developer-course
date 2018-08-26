/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.developer.pruebas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.balceda.developer.pojos.Curso;

/**
 *
 * @author jbalceda
 */
public class Test01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crea un SessionFactory y un objeto Session
        SessionFactory sessions = new Configuration().configure().buildSessionFactory();
        Session session = sessions.openSession();

        // Encapsula el cilo de vida de las operaciones en una transaccion
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            // Crea un objeto curso y la graba a la base de datos
            Curso c1 = new Curso();
            c1.setId("c04");
            c1.setNombre("Javascript");
            c1.setCreditos(4);
            session.save(c1);

            // Crea otra curso y la agrega a la base de datos
            Curso c2 = new Curso();
            c2.setId("c05");
            c2.setNombre("Kotlin");
            c2.setCreditos(5);
            session.save(c2);

            // Obtiene objetos de la base de datos
            Curso curso = (Curso) session.get(Curso.class, c1.getId());
            System.out.println("Primer curso = " + curso.getNombre());
            curso = (Curso) session.get(Curso.class, c2.getId());
            System.out.println("Segundo curso = " + curso.getNombre());

            tx.commit();
            tx = null;
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}
