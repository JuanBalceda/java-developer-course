/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.developer.app;

import com.balceda.developer.model.Cliente;
import com.balceda.developer.model.Factura;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author jbalceda
 */
public class Test01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();

            Cliente cliente = new Cliente(105, "José Carlos");

            cliente.addFactura(new Factura(9, 500.0, cliente));
            cliente.addFactura(new Factura(10, 1500.0, cliente));
            cliente.addFactura(new Factura(11, 900.0, cliente));

            session.getTransaction().begin();
            session.save(cliente);
            session.getTransaction().commit();
            System.out.println("Todo ok.");
        } catch (HibernateException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }

}
