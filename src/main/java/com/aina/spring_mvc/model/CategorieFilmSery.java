package com.aina.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "categorie_film_series")
public class CategorieFilmSery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "genre", nullable = false, length = 70)
    private String genre;

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}