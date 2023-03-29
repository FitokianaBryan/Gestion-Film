package com.aina.spring_mvc.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "acteur")
public class Acteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 150)
    private String nom;

    @Column(name = "prenom", length = 150)
    private String prenom;

    @Column(name = "genre", nullable = false, length = 40)
    private String genre;

    @Column(name = "datenaissance", nullable = false)
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

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}