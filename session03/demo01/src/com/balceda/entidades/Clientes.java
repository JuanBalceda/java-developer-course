/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.balceda.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "clientes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c")
    , @NamedQuery(name = "Clientes.findByCodigoCli", query = "SELECT c FROM Clientes c WHERE c.codigoCli = :codigoCli")
    , @NamedQuery(name = "Clientes.findByLogin", query = "SELECT c FROM Clientes c WHERE c.login = :login")
    , @NamedQuery(name = "Clientes.findByPassword", query = "SELECT c FROM Clientes c WHERE c.password = :password")
    , @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Clientes.findByDireccion", query = "SELECT c FROM Clientes c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Clientes.findByFonoCasa", query = "SELECT c FROM Clientes c WHERE c.fonoCasa = :fonoCasa")
    , @NamedQuery(name = "Clientes.findByFonoMovil", query = "SELECT c FROM Clientes c WHERE c.fonoMovil = :fonoMovil")
    , @NamedQuery(name = "Clientes.findByTsexo", query = "SELECT c FROM Clientes c WHERE c.tsexo = :tsexo")
    , @NamedQuery(name = "Clientes.findByEmail", query = "SELECT c FROM Clientes c WHERE c.email = :email")
    , @NamedQuery(name = "Clientes.findByCiudad", query = "SELECT c FROM Clientes c WHERE c.ciudad = :ciudad")
    , @NamedQuery(name = "Clientes.findBySaldo", query = "SELECT c FROM Clientes c WHERE c.saldo = :saldo")})
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoCli")
    private Integer codigoCli;
    @Basic(optional = false)
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "fono_casa")
    private String fonoCasa;
    @Column(name = "fono_movil")
    private String fonoMovil;
    @Column(name = "tsexo")
    private Character tsexo;
    @Column(name = "email")
    private String email;
    @Column(name = "ciudad")
    private String ciudad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Float saldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoCli")
    private Collection<Ordenes> ordenesCollection;

    public Clientes() {
    }

    public Clientes(Integer codigoCli) {
        this.codigoCli = codigoCli;
    }

    public Clientes(Integer codigoCli, String login) {
        this.codigoCli = codigoCli;
        this.login = login;
    }

    public Integer getCodigoCli() {
        return codigoCli;
    }

    public void setCodigoCli(Integer codigoCli) {
        this.codigoCli = codigoCli;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFonoCasa() {
        return fonoCasa;
    }

    public void setFonoCasa(String fonoCasa) {
        this.fonoCasa = fonoCasa;
    }

    public String getFonoMovil() {
        return fonoMovil;
    }

    public void setFonoMovil(String fonoMovil) {
        this.fonoMovil = fonoMovil;
    }

    public Character getTsexo() {
        return tsexo;
    }

    public void setTsexo(Character tsexo) {
        this.tsexo = tsexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Float getSaldo() {
        return saldo;
    }

    public void setSaldo(Float saldo) {
        this.saldo = saldo;
    }

    @XmlTransient
    public Collection<Ordenes> getOrdenesCollection() {
        return ordenesCollection;
    }

    public void setOrdenesCollection(Collection<Ordenes> ordenesCollection) {
        this.ordenesCollection = ordenesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoCli != null ? codigoCli.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.codigoCli == null && other.codigoCli != null) || (this.codigoCli != null && !this.codigoCli.equals(other.codigoCli))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.balceda.entidades.Clientes[ codigoCli=" + codigoCli + " ]";
    }
    
}
