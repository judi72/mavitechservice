/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtech.mavitech.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author judicael
 */
@Entity
@Table(name = "visitetechnique")
@NamedQueries({
    @NamedQuery(name = "Visitetechnique.findAll", query = "SELECT v FROM Visitetechnique v")})
public class Visitetechnique implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvisite")
    private Integer idvisite;
    @Basic(optional = false)
    @Column(name = "idvehicule")
    private int idvehicule;
    @Column(name = "datevisite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datevisite;
    @Column(name = "datevalidite")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datevalidite;
    @Column(name = "observation")
    private String observation;

    public Visitetechnique() {
    }

    public Visitetechnique(Integer idvisite) {
        this.idvisite = idvisite;
    }

    public Visitetechnique(Integer idvisite, int idvehicule) {
        this.idvisite = idvisite;
        this.idvehicule = idvehicule;
    }

    public Integer getIdvisite() {
        return idvisite;
    }

    public void setIdvisite(Integer idvisite) {
        this.idvisite = idvisite;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

    public Date getDatevisite() {
        return datevisite;
    }

    public void setDatevisite(Date datevisite) {
        this.datevisite = datevisite;
    }

    public Date getDatevalidite() {
        return datevalidite;
    }

    public void setDatevalidite(Date datevalidite) {
        this.datevalidite = datevalidite;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvisite != null ? idvisite.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Visitetechnique)) {
            return false;
        }
        Visitetechnique other = (Visitetechnique) object;
        if ((this.idvisite == null && other.idvisite != null) || (this.idvisite != null && !this.idvisite.equals(other.idvisite))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mavitech.Visitetechnique[ idvisite=" + idvisite + " ]";
    }
    
}
