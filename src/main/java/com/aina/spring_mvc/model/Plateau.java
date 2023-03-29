package com.aina.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "plateau")
public class Plateau {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nomplateau", nullable = false)
    private String nomplateau;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomplateau() {
        return nomplateau;
    }

    public void setNomplateau(String nomplateau) {
        this.nomplateau = nomplateau;
    }
}