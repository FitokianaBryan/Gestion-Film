package com.aina.spring_mvc.controller;

import com.aina.spring_mvc.model.Action;
import com.aina.spring_mvc.model.FilmSery;
import com.aina.spring_mvc.model.Realisateur;
import org.aina.HibernateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ActionController {
    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }
    @GetMapping("/action")
    public String action(Model model,@RequestParam(value = "idrole") String idrole){
        Action action =new Action();
        action.setIdrole(Integer.parseInt(idrole));
        model.addAttribute("idr",Integer.parseInt(idrole));
        model.addAttribute("actionlist",dao.findWhere(action));
        return "actionacteur";
    }
}
