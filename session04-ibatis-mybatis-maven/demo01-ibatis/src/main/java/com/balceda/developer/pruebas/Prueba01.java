package com.balceda.developer.pruebas;

import com.balceda.developer.daos.PersonaDaoImpl;
import com.balceda.developer.pojos.Persona;
import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class Prueba01 {

    public static void main(String[] args) {

        Reader rd;
        try {
            rd = Resources.getResourceAsReader("sqlMapConfig.xml");
            SqlMapClient smc = SqlMapClientBuilder.buildSqlMapClient(rd);

            Persona persona = new Persona("Juan", "Balceda", 26);
            PersonaDaoImpl dao = new PersonaDaoImpl(smc);
            dao.registrar(persona);
        } catch (IOException e) {
            System.out.println("error: "+e.getMessage());
        }

    }

}
