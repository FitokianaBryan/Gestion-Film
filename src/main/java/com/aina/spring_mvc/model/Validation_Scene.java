package com.aina.spring_mvc.model;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "Validation_Scene")
public class Validation_Scene {
    @Id
    private int IDScene;
    @Column(name = "etat")
    private int Etat;
    @Column(name = "moment")
    private java.sql.Timestamp Moment;

    public Validation_Scene() {
    }

    public Validation_Scene(int idscene) {
        this.IDScene = idscene;
    }


    public Validation_Scene(int IDScene, int etat, Timestamp moment) {
        this.IDScene = IDScene;
        Etat = etat;
        Moment = moment;
    }

    public int getIDScene() {
        return IDScene;
    }

    public void setIDScene(int IDScene) {
        this.IDScene = IDScene;
    }

    public int getEtat() {
        return Etat;
    }

    public void setEtat(int etat) {
        Etat = etat;
    }

    public Timestamp getMoment() {
        return Moment;
    }

    public void setMoment(Timestamp moment) {
        Moment = moment;
    }

    @Entity
    @Immutable
    @Table(name = "liste_planning_scene")
    public static class ListePlanningScene {

        @Id
        @Column(name = "idplanning_scene")
        private Integer idplanningScene;

        @Column(name = "idscene")
        private Integer idscene;

        @Column(name = "datedebut")
        private Timestamp datedebut;

        @Column(name = "datefin")
        private Timestamp datefin;

        @Column(name = "id")
        private Integer id;

        @Column(name = "nom")
        private String nom;

        @Column(name = "idfilm_series")
        private Integer idfilmSeries;

        @Column(name = "idplateau")
        private Integer idplateau;

        @Column(name = "duree")
        private Integer duree;

        public Integer getDuree() {
            return duree;
        }

        public Integer getIdplateau() {
            return idplateau;
        }

        public Integer getIdfilmSeries() {
            return idfilmSeries;
        }

        public String getNom() {
            return nom;
        }

        public Integer getId() {
            return id;
        }

        public Timestamp getDatefin() {
            return datefin;
        }

        public Timestamp getDatedebut() {
            return datedebut;
        }

        public Integer getIdscene() {
            return idscene;
        }

        public Integer getIdplanningScene() {
            return idplanningScene;
        }

        public void setIdplanningScene(Integer idplanningScene) {
            this.idplanningScene = idplanningScene;
        }

        public void setIdscene(Integer idscene) {
            this.idscene = idscene;
        }

        public void setDatedebut(Timestamp datedebut) {
            this.datedebut = datedebut;
        }

        public void setDatefin(Timestamp datefin) {
            this.datefin = datefin;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public void setNom(String nom) {
            this.nom = nom;
        }

        public void setIdfilmSeries(Integer idfilmSeries) {
            this.idfilmSeries = idfilmSeries;
        }

        public void setIdplateau(String idplateau) {
            this.idplateau = Integer.parseInt(idplateau);
        }

        public void setDuree(Integer duree) {
            this.duree = duree;
        }
        public ListePlanningScene() {
        }

        public ListePlanningScene(Integer idplanningScene, Integer idscene, Timestamp datedebut, Timestamp datefin, Integer id, String nom, Integer idfilmSeries, Integer idplateau, Integer duree) {
            this.idplanningScene = idplanningScene;
            this.idscene = idscene;
            this.datedebut = datedebut;
            this.datefin = datefin;
            this.id = id;
            this.nom = nom;
            this.idfilmSeries = idfilmSeries;
            this.idplateau = idplateau;
            this.duree = duree;
        }
    }
}
