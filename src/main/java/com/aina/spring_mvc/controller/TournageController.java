package com.aina.spring_mvc.controller;

import com.aina.spring_mvc.connexion.Connexion;
import com.aina.spring_mvc.model.Action;
import com.aina.spring_mvc.model.Scene;
import com.aina.spring_mvc.view.ListeRole;
import org.aina.HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.util.ArrayList;

@Controller
public class TournageController {

    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }


    public ArrayList<ListeRole> rolelistfilm(int idscene) throws Exception {
        String requete= "select * from liste_role where idscene=? ";
        ArrayList<ListeRole> listeRoles=new ArrayList<>();
        Connexion con=new Connexion(requete);
        con.getStm().setInt(1,idscene);
        con.Execute();
        ResultSet res=con.getRes();
        ListeRole e=null;
        try{
            while(res.next())
            {
                int id= res.getInt("id");
                int idsc=res.getInt("idscene");
                int idact=res.getInt("idacteur");
                int idcat=res.getInt("idcategoriepersonnage");
                String nom=res.getString("nom");
                String nomPrenom=res.getString("nom_prenom");
                String cat=res.getString("categorie");
                String scenario=res.getString("scenario");
                e=new ListeRole(id,idsc,idact,idcat,nom,nomPrenom,cat,scenario);
                listeRoles.add(e);
            }
        }
        catch(Exception sqle){
            throw new Exception(sqle);
        }
        finally{
            con.getStm().executeQuery().close();
            con.Close();
        }
        return listeRoles;
    }

    @GetMapping("/listerole")
    public String listerole(Model model,@RequestParam(value = "idscene") String idscene){
        try {
            model.addAttribute("listerole", rolelistfilm(Integer.parseInt(idscene)));
        }
        catch (Exception e){
            e.getMessage();
        }
        return "listeroleacteur";
    }

}
