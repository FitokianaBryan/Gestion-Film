package com.aina.spring_mvc.controller;

import com.aina.spring_mvc.model.Plateau;
import com.aina.spring_mvc.model.Scene;
import org.aina.HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlateauController {

    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }
    @GetMapping("/listeplateau")
    public String listeplateau(Model model){
        model.addAttribute("listeplateau",dao.findAll(Plateau.class));
        return "listeplateau";
    }

}
