package com.aina.spring_mvc.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "realisateur")
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", nullable = false, length = 70)
    private String email;

    @Column(name = "mdp", nullable = false, length = 60)
    private String mdp;

    @Column(name = "nom", length = 150)
    private String nom;

    @Column(name = "prenom", length = 150)
    private String prenom;

    @Column(name = "datenaissance")
    private LocalDate datenaissance;

    @Column(name = "nationalite", nullable = false, length = 70)
    private String nationalite;

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public LocalDate getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(LocalDate datenaissance) {
        this.datenaissance = datenaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}