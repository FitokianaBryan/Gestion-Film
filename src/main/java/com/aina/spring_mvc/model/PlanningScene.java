package com.aina.spring_mvc.model;

import org.springframework.expression.ParseException;

import javax.persistence.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;

@Entity
@Table(name = "planning_scene")
public class PlanningScene {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idplanning_scene", nullable = false)
    private Integer id;

    @Column(name = "idscene", nullable = false)
    private Integer idscene;

    @Column(name = "datedebut")
    private Timestamp datedebut;

    @Column(name = "datefin")
    private Timestamp datefin;

    public PlanningScene() {
    }

    public PlanningScene(Integer id, Integer idscene, Timestamp datedebut, Timestamp datefin) {
        this.id = id;
        this.idscene = idscene;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Timestamp getDatefin() {
        return datefin;
    }


    public void setDatefin(String datefin) {
        try {
            java.util.Date dtn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(datefin);
            Timestamp timestamp = new Timestamp(dtn.getTime());
            this.datefin = timestamp;
        }
        catch (ParseException | java.text.ParseException exp){
            exp.getMessage();
        }

    }

    public Timestamp getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(String datedebut) {

        try {
            java.util.Date dtn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(datedebut);
            Timestamp timestamp = new Timestamp(dtn.getTime());
            this.datedebut = timestamp;
        }
        catch (ParseException | java.text.ParseException exp){
            exp.getMessage();
        }
    }

    public Integer getIdscene() {
        return idscene;
    }

    public void setIdscene(String idscene) {
        this.idscene = Integer.parseInt(idscene);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}