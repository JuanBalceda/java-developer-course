package com.balceda.developer.model;

public class Factura {

    private int nro;
    private double importe;
    private Cliente cliente;

    public Factura() {
    }

    public Factura(int nro, double importe) {
        super();
        this.nro = nro;
        this.importe = importe;
    }

    public Factura(int nro, double importe, Cliente cliente) {
        super();
        this.nro = nro;
        this.importe = importe;
        this.cliente = cliente;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
