package com.aina.spring_mvc.model;

import org.aina.HibernateDao;

import javax.persistence.*;

@Entity
@Table(name = "administrateur")
public class Administrateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "psswd", length = 50)
    private String psswd;

    public Administrateur(String email, String psswd) {
        this.email = email;
        this.psswd = psswd;
    }

    public Administrateur() {

    }

    public String getPsswd() {
        return psswd;
    }

    public void setPsswd(String psswd) {
        this.psswd = psswd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public static boolean adminExiste(HibernateDao hibernateDao, Administrateur administrateur) {
        if (hibernateDao.findWhere(administrateur).size() != 0) {
            return true;
        }
        return false;
    }
}