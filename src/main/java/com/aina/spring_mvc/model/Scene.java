package com.aina.spring_mvc.model;

import org.springframework.expression.ParseException;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Entity
@Table(name = "scene")
public class Scene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "nom")
    private String nom;


    @Column(name = "idfilm_series", nullable = false)
    private Integer idfilmSeries;

    @Column(name = "idplateau", nullable = false)
    private Integer idplateau;

    @Column(name = "duree", nullable = false)
    private Integer duree;


    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Integer getIdplateau() {
        return idplateau;
    }

    public void setIdplateau(Integer idplateau) {
        this.idplateau = idplateau;
    }

    public Integer getIdfilmSeries() {
        return idfilmSeries;
    }

    public void setIdfilmSeries(Integer idfilmSeries) {
        this.idfilmSeries = idfilmSeries;
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