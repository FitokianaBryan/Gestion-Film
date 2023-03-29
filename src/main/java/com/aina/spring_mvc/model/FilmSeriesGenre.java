package com.aina.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "film_series_genre")
public class FilmSeriesGenre {

    @Id
    @Column(name = "idfilm_series", nullable = false)
    private Integer idfilmSeries;


    @Column(name = "idcategorie", nullable = false)
    private Integer idcategorie;

    public Integer getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    public Integer getIdfilmSeries() {
        return idfilmSeries;
    }

    public void setIdfilmSeries(Integer idfilmSeries) {
        this.idfilmSeries = idfilmSeries;
    }
}