/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jtech.mavitech.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author judicael
 */
@Entity
@Table(name = "vehiculetracteur")
@NamedQueries({
    @NamedQuery(name = "Vehiculetracteur.findAll", query = "SELECT v FROM Vehiculetracteur v")})
public class Vehiculetracteur implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idvehicule")
    private Integer idvehicule;
    @Column(name = "numchassis")
    private String numchassis;
    @Column(name = "immatriculation")
    private String immatriculation;
    @Column(name = "marque")
    private String marque;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "vehicule_remorque",
            joinColumns = @JoinColumn(name = "vehiculetracteur"),
            inverseJoinColumns = @JoinColumn(name = "remorque"))
    private Remorque remorque;

    public Vehiculetracteur() {
    }

    public Vehiculetracteur(Integer idvehicule) {
        this.idvehicule = idvehicule;
    }

    public Integer getIdvehicule() {
        return idvehicule;
    }

    public void setIdvehicule(Integer idvehicule) {
        this.idvehicule = idvehicule;
    }

    public String getNumchassis() {
        return numchassis;
    }

    public void setNumchassis(String numchassis) {
        this.numchassis = numchassis;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Remorque getRemorque() {
        return remorque;
    }

    public void setRemorque(Remorque remorque) {
        this.remorque = remorque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idvehicule != null ? idvehicule.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculetracteur that = (Vehiculetracteur) o;
        return Objects.equals(idvehicule, that.idvehicule) && Objects.equals(numchassis, that.numchassis) && Objects.equals(immatriculation, that.immatriculation) && Objects.equals(marque, that.marque) && Objects.equals(remorque, that.remorque);
    }

    @Override
    public String toString() {
        return "mavitech.Vehiculetracteur[ idvehicule=" + idvehicule + " ]";
    }
    
}
