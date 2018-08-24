/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jbalceda
 */
@Entity
@Table(name = "productos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")
    , @NamedQuery(name = "Productos.findByCodigo", query = "SELECT p FROM Productos p WHERE p.productosPK.codigo = :codigo")
    , @NamedQuery(name = "Productos.findByTipo", query = "SELECT p FROM Productos p WHERE p.productosPK.tipo = :tipo")
    , @NamedQuery(name = "Productos.findByDescripcion", query = "SELECT p FROM Productos p WHERE p.descripcion = :descripcion")
    , @NamedQuery(name = "Productos.findByPrecio", query = "SELECT p FROM Productos p WHERE p.precio = :precio")
    , @NamedQuery(name = "Productos.findByStock", query = "SELECT p FROM Productos p WHERE p.stock = :stock")
    , @NamedQuery(name = "Productos.findByStatus", query = "SELECT p FROM Productos p WHERE p.status = :status")
    , @NamedQuery(name = "Productos.filter", query = "SELECT p FROM Productos p WHERE p.precio <= :priceMin AND p.precio >= :priceMax")})
public class Productos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosPK productosPK;
    @Column(name = "descripcion")
    private String descripcion;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio")
    private Float precio;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "status")
    private Character status;
    /*
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<OrdenesDetalle> ordenesDetalleCollection;
    @JoinColumn(name = "tipo", referencedColumnName = "tipo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categoria categoria;
    */
    public Productos() {
    }

    public Productos(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public Productos(int codigo, Character tipo) {
        this.productosPK = new ProductosPK(codigo, tipo);
    }

    public ProductosPK getProductosPK() {
        return productosPK;
    }

    public void setProductosPK(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
/*
    @XmlTransient
    public Collection<OrdenesDetalle> getOrdenesDetalleCollection() {
        return ordenesDetalleCollection;
    }

    public void setOrdenesDetalleCollection(Collection<OrdenesDetalle> ordenesDetalleCollection) {
        this.ordenesDetalleCollection = ordenesDetalleCollection;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
*/
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosPK != null ? productosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.productosPK == null && other.productosPK != null) || (this.productosPK != null && !this.productosPK.equals(other.productosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.balceda.entidades.Productos[ productosPK=" + productosPK + " ]";
    }
    
}
