package com.aina.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "acteur_film_series")
public class ActeurFilmSery {

    @Id
    @Column(name = "idfilm_series", nullable = false)
    private Integer idfilmSeries;

    @JoinColumn(name = "idacteur", nullable = false)
    private Integer idacteur;

    public Integer getIdacteur() {
        return idacteur;
    }

    public void setIdacteur(Integer idacteur) {
        this.idacteur = idacteur;
    }

    public Integer getIdfilmSeries() {
        return idfilmSeries;
    }

    public void setIdfilmSeries(Integer idfilmSeries) {
        this.idfilmSeries = idfilmSeries;
    }
}