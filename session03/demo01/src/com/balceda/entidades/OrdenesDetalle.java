/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jbalceda
 */
@Entity
@Table(name = "ordenes_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrdenesDetalle.findAll", query = "SELECT o FROM OrdenesDetalle o")
    , @NamedQuery(name = "OrdenesDetalle.findByOrden", query = "SELECT o FROM OrdenesDetalle o WHERE o.ordenesDetallePK.orden = :orden")
    , @NamedQuery(name = "OrdenesDetalle.findByCodigo", query = "SELECT o FROM OrdenesDetalle o WHERE o.ordenesDetallePK.codigo = :codigo")
    , @NamedQuery(name = "OrdenesDetalle.findByCantidad", query = "SELECT o FROM OrdenesDetalle o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "OrdenesDetalle.findByPrecio", query = "SELECT o FROM OrdenesDetalle o WHERE o.precio = :precio")})
public class OrdenesDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected OrdenesDetallePK ordenesDetallePK;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    /*
    @JoinColumn(name = "codigo", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Productos productos;
    */
    @JoinColumn(name = "orden", referencedColumnName = "orden", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ordenes ordenes;

    public OrdenesDetalle() {
    }

    public OrdenesDetalle(OrdenesDetallePK ordenesDetallePK) {
        this.ordenesDetallePK = ordenesDetallePK;
    }

    public OrdenesDetalle(int orden, int codigo) {
        this.ordenesDetallePK = new OrdenesDetallePK(orden, codigo);
    }

    public OrdenesDetallePK getOrdenesDetallePK() {
        return ordenesDetallePK;
    }

    public void setOrdenesDetallePK(OrdenesDetallePK ordenesDetallePK) {
        this.ordenesDetallePK = ordenesDetallePK;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }
/*
    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
*/
    public Ordenes getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(Ordenes ordenes) {
        this.ordenes = ordenes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ordenesDetallePK != null ? ordenesDetallePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDetalle)) {
            return false;
        }
        OrdenesDetalle other = (OrdenesDetalle) object;
        if ((this.ordenesDetallePK == null && other.ordenesDetallePK != null) || (this.ordenesDetallePK != null && !this.ordenesDetallePK.equals(other.ordenesDetallePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.balceda.entidades.OrdenesDetalle[ ordenesDetallePK=" + ordenesDetallePK + " ]";
    }
    
}
