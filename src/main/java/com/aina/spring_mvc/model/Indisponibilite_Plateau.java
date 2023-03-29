package com.aina.spring_mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "indisponibilite_plateau")
public class Indisponibilite_Plateau {
    @Id
    private int IDPlateau;
    @Column(name = "datedebut")
    public java.sql.Timestamp DateDebut;
    @Column(name = "datefin")
    public java.sql.Timestamp DateFin;

    public Indisponibilite_Plateau() { }

    public Indisponibilite_Plateau(int IDPlateau, Timestamp dateDebut, Timestamp dateFin) {
        this.IDPlateau = IDPlateau;
        DateDebut = dateDebut;
        DateFin = dateFin;
    }


    public int getIDPlateau() {
        return IDPlateau;
    }

    public void setIDPlateau(int IDPlateau) {
        this.IDPlateau = IDPlateau;
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
