package com.aina.spring_mvc.view;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "liste_role")
public class ListeRole {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "idscene")
    private Integer idscene;

    @Column(name = "idacteur")
    private Integer idacteur;

    @Column(name = "idcategoriepersonnage")
    private Integer idcategoriepersonnage;

    @Column(name = "nom", length = 70)
    private String nom;


    @Column(name = "nom_prenom")
    private String nomPrenom;

    @Column(name = "categorie", length = 70)
    private String categorie;


    @Column(name = "scenario")
    private String scenario;

    public String getScenario() {
        return scenario;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getNomPrenom() {
        return nomPrenom;
    }

    public String getNom() {
        return nom;
    }

    public Integer getIdcategoriepersonnage() {
        return idcategoriepersonnage;
    }

    public Integer getIdacteur() {
        return idacteur;
    }

    public Integer getIdscene() {
        return idscene;
    }

    public void setIdscene(Integer idscene) {
        this.idscene = idscene;
    }

    public void setIdacteur(Integer idacteur) {
        this.idacteur = idacteur;
    }

    public void setIdcategoriepersonnage(Integer idcategoriepersonnage) {
        this.idcategoriepersonnage = idcategoriepersonnage;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNomPrenom(String nomPrenom) {
        this.nomPrenom = nomPrenom;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public void setScenario(String scenario) {
        this.scenario = scenario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ListeRole(Integer id, Integer idscene, Integer idacteur, Integer idcategoriepersonnage, String nom, String nomPrenom, String categorie, String scenario) {
        this.id = id;
        this.idscene = idscene;
        this.idacteur = idacteur;
        this.idcategoriepersonnage = idcategoriepersonnage;
        this.nom = nom;
        this.nomPrenom = nomPrenom;
        this.categorie = categorie;
        this.scenario = scenario;
    }

    public ListeRole() {
    }
}