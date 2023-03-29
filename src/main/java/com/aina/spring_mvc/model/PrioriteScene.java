package com.aina.spring_mvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "priorite_scene")
public class PrioriteScene {
    @Id
    private int IDScene;
    @Column(name = "priorite")
    private int Priorite;

    public PrioriteScene(int IDScene, int priorite) {
        this.IDScene = IDScene;
        Priorite = priorite;
    }

    public PrioriteScene() {
    }

    public PrioriteScene(int IDScene) {
        this.IDScene = IDScene;
    }

    public int getIDScene() {
        return IDScene;
    }

    public void setIDScene(int IDScene) {
        this.IDScene = IDScene;
    }

    public int getPriorite() {
        return Priorite;
    }

    public void setPriorite(int priorite) {
        Priorite = priorite;
    }
}
