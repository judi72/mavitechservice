/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtech.mavitech.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 *
 * @author judicael
 */
@Embeddable
public class TracterPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idvehicule")
    private int idvehicule;
    @Basic(optional = false)
    @Column(name = "idremorque")
    private int idremorque;

    public TracterPK() {
    }

    public TracterPK(int idvehicule, int idremorque) {
        this.idvehicule = idvehicule;
        this.idremorque = idremorque;
    }

    public int getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(int idvehicule) {
        this.idvehicule = idvehicule;
    }

    public int getIdremorque() {
        return idremorque;
    }

    public void setIdremorque(int idremorque) {
        this.idremorque = idremorque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idvehicule;
        hash += (int) idremorque;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TracterPK)) {
            return false;
        }
        TracterPK other = (TracterPK) object;
        if (this.idvehicule != other.idvehicule) {
            return false;
        }
        if (this.idremorque != other.idremorque) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mavitech.TracterPK[ idvehicule=" + idvehicule + ", idremorque=" + idremorque + " ]";
    }
    
}
