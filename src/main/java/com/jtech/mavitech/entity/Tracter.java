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
@Table(name = "tracter")
@NamedQueries({
    @NamedQuery(name = "Tracter.findAll", query = "SELECT t FROM Tracter t")})
public class Tracter implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TracterPK tracterPK;
    @Column(name = "dateremorquage")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateremorquage;
    @Column(name = "datefinremorquage")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datefinremorquage;

    public Tracter() {
    }

    public Tracter(TracterPK tracterPK) {
        this.tracterPK = tracterPK;
    }

    public Tracter(int idvehicule, int idremorque) {
        this.tracterPK = new TracterPK(idvehicule, idremorque);
    }

    public TracterPK getTracterPK() {
        return tracterPK;
    }

    public void setTracterPK(TracterPK tracterPK) {
        this.tracterPK = tracterPK;
    }

    public Date getDateremorquage() {
        return dateremorquage;
    }

    public void setDateremorquage(Date dateremorquage) {
        this.dateremorquage = dateremorquage;
    }

    public Date getDatefinremorquage() {
        return datefinremorquage;
    }

    public void setDatefinremorquage(Date datefinremorquage) {
        this.datefinremorquage = datefinremorquage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tracterPK != null ? tracterPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tracter)) {
            return false;
        }
        Tracter other = (Tracter) object;
        if ((this.tracterPK == null && other.tracterPK != null) || (this.tracterPK != null && !this.tracterPK.equals(other.tracterPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mavitech.Tracter[ tracterPK=" + tracterPK + " ]";
    }
    
}
