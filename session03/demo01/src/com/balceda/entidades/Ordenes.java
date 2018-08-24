/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jbalceda
 */
@Entity
@Table(name = "ordenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ordenes.findAll", query = "SELECT o FROM Ordenes o")
    , @NamedQuery(name = "Ordenes.findByOrden", query = "SELECT o FROM Ordenes o WHERE o.orden = :orden")
    , @NamedQuery(name = "Ordenes.findByFecha", query = "SELECT o FROM Ordenes o WHERE o.fecha = :fecha")
    , @NamedQuery(name = "Ordenes.findByMonto", query = "SELECT o FROM Ordenes o WHERE o.monto = :monto")
    , @NamedQuery(name = "Ordenes.findByEstado", query = "SELECT o FROM Ordenes o WHERE o.estado = :estado")})
public class Ordenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "monto")
    private Float monto;
    @Basic(optional = false)
    @Column(name = "estado")
    private Character estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ordenes")
    private Collection<OrdenesDetalle> ordenesDetalleCollection;
    @JoinColumn(name = "codigoCli", referencedColumnName = "codigoCli")
    @ManyToOne(optional = false)
    private Clientes codigoCli;

    public Ordenes() {
    }

    public Ordenes(Integer orden) {
        this.orden = orden;
    }

    public Ordenes(Integer orden, Character estado) {
        this.orden = orden;
        this.estado = estado;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<OrdenesDetalle> getOrdenesDetalleCollection() {
        return ordenesDetalleCollection;
    }

    public void setOrdenesDetalleCollection(Collection<OrdenesDetalle> ordenesDetalleCollection) {
        this.ordenesDetalleCollection = ordenesDetalleCollection;
    }

    public Clientes getCodigoCli() {
        return codigoCli;
    }

    public void setCodigoCli(Clientes codigoCli) {
        this.codigoCli = codigoCli;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orden != null ? orden.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ordenes)) {
            return false;
        }
        Ordenes other = (Ordenes) object;
        if ((this.orden == null && other.orden != null) || (this.orden != null && !this.orden.equals(other.orden))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.balceda.entidades.Ordenes[ orden=" + orden + " ]";
    }
    
}
