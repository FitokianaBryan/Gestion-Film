package com.aina.spring_mvc.model;

import javax.persistence.*;

@Entity
@Table(name = "categorie_personnage")
public class CategoriePersonnage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "categorie", nullable = false, length = 70)
    private String categorie;

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}