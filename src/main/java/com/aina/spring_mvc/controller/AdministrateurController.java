package com.aina.spring_mvc.controller;

import com.aina.spring_mvc.fonction.Liste;
import com.aina.spring_mvc.model.*;
import org.aina.HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdministrateurController {
    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    @GetMapping("/loginAdmin")
    public String action(Model model){
        model.addAttribute("mail","admin");
        model.addAttribute("psswd","admin");
        return "loginAdmin";
    }
    @GetMapping("/deconnexionadmin")
    public String deconnexion(HttpServletRequest request) {
        request.getSession().invalidate();
        return "LoginAdmin";
    }

    @PostMapping("/traitementLoginAdmin")
    public String actionTraitement(HttpServletRequest request, Model model, @RequestParam(value = "email") String email, @RequestParam(value = "psswd") String psswd ){
        Administrateur administrateur = new Administrateur(email,psswd);
        if (Administrateur.adminExiste(dao, administrateur)) {
            PlanningScene planningScene = new PlanningScene();
            int limit = 6;
            int page = (request.getAttribute("page") == null ? 1 : (int)request.getAttribute("page"));
            System.out.println("page: "+page);
            model.addAttribute("planningScenes",new Liste().paginateListValidation(new Liste().getListeFor(dao,0),limit,page));
            List<Acteur> listacteurs = dao.findAll(Acteur.class);
            model.addAttribute("listeacteurs",listacteurs);
            List<Plateau> listplateaux = dao.findAll(Plateau.class);
            model.addAttribute("listeplateaux",listplateaux);
            List<Validation_Scene> nonvalide = new Liste().paginateListValidation(new Liste().getListeFor(dao,1),limit,page);
            model.addAttribute("listenonvalide",nonvalide);
            return "acceuil-admin";
        }
        return "loginAdmin";
    }

    @GetMapping("/toAccueilAdmin")
    public String toAccueilAdmin(HttpServletRequest request, Model model) {
        try {
            int page = (request.getAttribute("page") == null ? 1 : (int)request.getAttribute("page"));
            int limit = 6;
            List<PlanningScene> planningScene = new Liste().paginateListValidation(new Liste().getListeFor(dao,0),limit,page);
            model.addAttribute("planningScenes",planningScene);
            List<Acteur> listacteurs = dao.findAll(Acteur.class);
            model.addAttribute("listeacteurs",listacteurs);
            List<Plateau> listplateaux = dao.findAll(Plateau.class);
            model.addAttribute("listeplateaux",listplateaux);
            List<PlanningScene> nonvalide = new Liste().paginateListValidation(new Liste().getListeFor(dao,1),limit,page);
            model.addAttribute("listenonvalide",nonvalide);
        }
        catch(Exception e) { throw e; }
        finally { return "acceuil-admin"; }
    }

    @PostMapping("/validerPlanningScene")
    public String validerPlanningScene(HttpServletRequest request) throws Exception {
        try {

            /*A MODIFIER EN URGENCE!*/
            // Update
//            PlanningScene planningSceneUpdate = dao.findById(PlanningScene.class, id);
//            planningSceneUpdate.setValidation(1);

            java.util.Date now = new java.util.Date();
            String date = (request.getParameter("datevalidation").equals("") ? new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(now) : request.getParameter("datevalidation"));
            java.sql.Timestamp datevalidation = new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(date).getTime());
            String[] id = request.getParameterValues("id");
            int validation = Integer.parseInt(request.getParameter("validation"));
            for(int i = 0 ; i < id.length ; i++) {
                Validation_Scene valide = dao.findById(Validation_Scene.class, Integer.parseInt(id[i]));
                valide.setEtat(validation);
                valide.setMoment(datevalidation);
                dao.update(valide);
            }
            return "redirect:/toAccueilAdmin";
        }
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    @PostMapping("/newIndispoPlateau")
    public String newIndispoPlateau(HttpServletRequest request) {
        try {
            int IDPlateau = Integer.parseInt(request.getParameter("plateau"));
            java.sql.Timestamp datedebut= new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("datedebut")).getTime());
            java.sql.Timestamp datefin= new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("datefin")).getTime());
            Indisponibilite_Plateau indispo = new Indisponibilite_Plateau(IDPlateau,datedebut,datefin);
            dao.create(indispo);
        }
        catch(Exception e) { throw e; }
        finally { return "redirect:/toAccueilAdmin"; }
    }

    @PostMapping("/newIndispoActeur")
    public String newIndispoActeur(HttpServletRequest request) {
        try {
            int IDActeur = Integer.parseInt(request.getParameter("acteur"));
            java.sql.Timestamp datedebut= new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("datedebut")).getTime());
            java.sql.Timestamp datefin= new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("datefin")).getTime());
            Indisponibilite_Acteur indispo = new Indisponibilite_Acteur(IDActeur,datedebut,datefin);
            dao.create(indispo);
        }
        catch(Exception e) { throw e; }
        finally { return "redirect:/toAccueilAdmin"; }
    }



}
