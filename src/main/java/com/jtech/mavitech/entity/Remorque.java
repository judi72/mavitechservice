/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtech.mavitech.entity;

import jakarta.persistence.*;

import java.io.Serializable;

/**
 *
 * @author judicael
 */
@Entity
@Table(name = "remorque")
@NamedQueries({
    @NamedQuery(name = "Remorque.findAll", query = "SELECT r FROM Remorque r")})
public class Remorque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idremorque")
    private Integer idremorque;
    @Column(name = "immatriculationrem")
    private String immatriculationrem;
    @Column(name = "nbreroue")
    private String nbreroue;

    public Remorque() {
    }

    public Remorque(Integer idremorque) {
        this.idremorque = idremorque;
    }

    public Integer getIdremorque() {
        return idremorque;
    }

    public void setIdremorque(Integer idremorque) {
        this.idremorque = idremorque;
    }

    public String getImmatriculationrem() {
        return immatriculationrem;
    }

    public void setImmatriculationrem(String immatriculationrem) {
        this.immatriculationrem = immatriculationrem;
    }

    public String getNbreroue() {
        return nbreroue;
    }

    public void setNbreroue(String nbreroue) {
        this.nbreroue = nbreroue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idremorque != null ? idremorque.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Remorque)) {
            return false;
        }
        Remorque other = (Remorque) object;
        if ((this.idremorque == null && other.idremorque != null) || (this.idremorque != null && !this.idremorque.equals(other.idremorque))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mavitech.Remorque[ idremorque=" + idremorque + " ]";
    }
    
}
