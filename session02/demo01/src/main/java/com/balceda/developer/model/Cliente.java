package com.balceda.developer.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    private int idcli;
    private String nombre;
    private Set<Factura> facturas = new HashSet<>();

    public Cliente() {
    }

    public Cliente(int idcli, String nombre) {
        this.idcli = idcli;
        this.nombre = nombre;
    }

    public Cliente(int idcli, String nombre, Set<Factura> facturas) {
        this.idcli = idcli;
        this.nombre = nombre;
        this.facturas = facturas;
    }

    public int getIdcli() {
        return idcli;
    }

    public void setIdcli(int idcli) {
        this.idcli = idcli;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

    public void addFactura(Factura factura) {
        this.facturas.add(factura);
    }

}
