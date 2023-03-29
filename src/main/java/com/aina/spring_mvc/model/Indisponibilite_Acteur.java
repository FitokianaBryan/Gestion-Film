package com.aina.spring_mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
@Entity
@Table(name = "indisponibilite_acteur")
public class Indisponibilite_Acteur {
    @Id
    private  int IDActeur;
    @Column(name = "datedebut")
    public java.sql.Timestamp DateDebut;
    @Column(name = "datefin")
    public java.sql.Timestamp DateFin;

    public Indisponibilite_Acteur() {
    }

    public Indisponibilite_Acteur(int IDActeur, Timestamp dateDebut, Timestamp dateFin) {
        this.IDActeur = IDActeur;
        DateDebut = dateDebut;
        DateFin = dateFin;
    }

    public int getIDActeur() {
        return IDActeur;
    }

    public void setIDActeur(int IDActeur) {
        this.IDActeur = IDActeur;
    }

    public Timestamp getDateDebut() {
        return DateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        DateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return DateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        DateFin = dateFin;
    }
}
