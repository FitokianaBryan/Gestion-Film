package com.aina.spring_mvc.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Table(name = "film_series")
public class FilmSery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "duree", nullable = false)
    private Integer duree;

    @Column(name = "datetournage", nullable = false)
    private Timestamp datetournage;

    @Column(name = "idrealisateur", nullable = false)
    private Integer idrealisateur;


    public Integer getIdrealisateur() {
        return idrealisateur;
    }

    public void setIdrealisateur(Integer idrealisateur) {
        this.idrealisateur = idrealisateur;
    }

    public Timestamp getDatetournage() {
        return datetournage;
    }

    public void setDatetournage(Timestamp datetournage) {
        this.datetournage = datetournage;
    }

    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}