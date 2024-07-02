package com.blockchain.ehealthservice.payload;

import jakarta.persistence.Column;

import java.util.Set;

public class SignupRequest {

    private String username;
    private String email;
    private String password;

    private String nom;

    private String prenom;

    private String tel;

    private String fonction;

    private String nationalite;
    Set<String> role;

    public SignupRequest() {
    }

    public SignupRequest(String username, String email, String password, String nom, String prenom, String tel, String nationalite, Set<String> role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.nationalite = nationalite;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFonction(){
        return fonction;
    }

    public void setFonction(String fonction){
        this.fonction = fonction;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
