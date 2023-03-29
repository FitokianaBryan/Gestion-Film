package com.aina.spring_mvc.controller;

import com.aina.spring_mvc.model.FilmSery;
import com.aina.spring_mvc.model.Realisateur;
import com.aina.spring_mvc.model.Scene;
import org.aina.HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class RealisateurController {

    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    @GetMapping("/")
    public String index(HttpServletRequest request, Model model){
        model.addAttribute("email","Berlanti@gmail.com");
        model.addAttribute("mdp","Berlanti");
        return "Loginrealisateur";
    }

    @GetMapping("/index")
    public String defaut(HttpServletRequest request, Model model){
        model.addAttribute("email","Berlanti@gmail.com");
        model.addAttribute("mdp","Berlanti");
        return "Loginrealisateur";
    }

    @GetMapping("/accueil")
    public String get(HttpServletRequest request){
        return "accueil-realisateur";
    }

    @GetMapping("/deconnnexionauteur")
    public String deconnexionauteur(HttpServletRequest request){
        request.getSession().invalidate();
        return "Loginrealisateur";
    }

    @PostMapping("/loginnreal")
    public String connect(HttpServletRequest request, Model model) {

        Realisateur realisateur= new Realisateur();
        realisateur.setEmail(request.getParameter("email"));
        realisateur.setMdp(request.getParameter("mdp"));
        List<Realisateur> tp =dao.findWhere(realisateur);
        FilmSery tourn= new FilmSery();
        if(tp.size()==0) {
            model.addAttribute("erreur","1");
            return "Loginrealisateur";
        }
        else{
            tourn.setIdrealisateur(tp.get(0).getId());
            request.getSession().setAttribute("realisateur",tp.get(0));
            model.addAttribute("films",dao.paginationwhere(tourn,1,3));
            return "accueil-realisateur";
         }
        }
    @GetMapping("/listefilms")
    public String listefilms(HttpServletRequest request,Model model){
        Realisateur real=(Realisateur) request.getSession().getAttribute("realisateur");
        FilmSery tourn=new FilmSery();
        tourn.setIdrealisateur(real.getId());
        model.addAttribute("films",dao.paginationwhere(tourn,1,3));
        return "accueil-realisateur";
    }
    }

