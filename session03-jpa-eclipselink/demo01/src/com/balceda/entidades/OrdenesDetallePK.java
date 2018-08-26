/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author jbalceda
 */
@Embeddable
public class OrdenesDetallePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "orden")
    private int orden;
    @Basic(optional = false)
    @Column(name = "codigo")
    private int codigo;

    public OrdenesDetallePK() {
    }

    public OrdenesDetallePK(int orden, int codigo) {
        this.orden = orden;
        this.codigo = codigo;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) orden;
        hash += (int) codigo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrdenesDetallePK)) {
            return false;
        }
        OrdenesDetallePK other = (OrdenesDetallePK) object;
        if (this.orden != other.orden) {
            return false;
        }
        if (this.codigo != other.codigo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.balceda.entidades.OrdenesDetallePK[ orden=" + orden + ", codigo=" + codigo + " ]";
    }
    
}
