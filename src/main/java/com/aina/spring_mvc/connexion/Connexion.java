/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aina.spring_mvc.connexion;

import java.sql.*;

/**
 *
 * @author Eloic
 */
public class Connexion {
    Connection cnt;
    PreparedStatement stm;
    ResultSet res;

    public Connexion(String req) {
        try {
            Class.forName("org.postgresql.Driver");
            String user = "postgres";
            String password = "1618";
            this.cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gestionfilm", user,
                    password);
            this.stm = this.cnt.prepareStatement(req);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//    public Connexion() {
//        try {
//            Class.forName("org.postgresql.Driver");
//            String user = "postgres";
//            String password = "root";
//            this.cnt = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gestionfilm", user,
//                    password);
//        } catch (SQLException sqle) {
//            sqle.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public Connection getCnt() {
        return cnt;
    }

    public void setCnt(Connection cnt) {
        this.cnt = cnt;
    }

    public void getCommit() throws Exception {
        this.stm.executeQuery("commit");
    }

    public PreparedStatement getStm() {
        return stm;
    }

    public void setStm(PreparedStatement stm) {
        this.stm = stm;
    }

    public ResultSet getRes() {
        return res;
    }

    public void setRes(ResultSet res) {
        this.res = res;
    }

    public void Execute() {
        try {
            this.res = this.stm.executeQuery();
        } catch (Exception sqle) {
            sqle.fillInStackTrace();
        }
    }

    public void Close() throws Exception {
        this.cnt.close();
    }
}
