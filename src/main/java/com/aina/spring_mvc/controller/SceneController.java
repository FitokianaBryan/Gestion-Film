package com.aina.spring_mvc.controller;

import com.aina.spring_mvc.connexion.Connexion;
import com.aina.spring_mvc.fonction.Liste;
import com.aina.spring_mvc.fonction.Utils;
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
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class SceneController {

    @Autowired
    HibernateDao dao;

    public HibernateDao getDao() {
        return dao;
    }

    public void setDao(HibernateDao dao) {
        this.dao = dao;
    }

    @GetMapping("/planning")
    public String planning(HttpServletRequest request, Model model){
        int limit = 6;

        int page_nonvalide = (request.getSession().getAttribute("page-nonvalide") == null ? 1 : (int)request.getSession().getAttribute("page-nonvalide"));
        List<Scene> nonvalides = new Liste().paginateListValidation(new Liste().getListeNonPlanifie(dao),limit,page_nonvalide);

        int page_valide = (request.getSession().getAttribute("page-valide") == null ? 1 : (int)request.getSession().getAttribute("page-valide"));
        List<Scene> valides = new Liste().getListeValidationNow(dao);

        int countnonvalide = new Liste().getListeNonPlanifie(dao).size();
        int countvalide = request.getSession().getAttribute("liste_scene_recherche") == null ? new Liste().getListeValidationNow(dao).size() : ((List<Scene>)request.getSession().getAttribute("liste_scene_recherche")).size();


        //LISTES
        request.getSession().setAttribute("liste_scene",nonvalides);
        request.getSession().setAttribute("liste_scene_valide",new Liste().paginateListValidation(valides,limit,page_valide));

        //NUMEROS DE PAGES
        request.getSession().setAttribute("page-nonvalide",page_nonvalide);
        request.getSession().setAttribute("page-valide",page_valide);

        //COUNT
        request.getSession().setAttribute("countnonvalide",countnonvalide);
        request.getSession().setAttribute("countvalide",countvalide);
        request.getSession().setAttribute("liste_plannings",dao.findAll(PlanningScene.class));

        return "planning";
    }

    @PostMapping("/triagedate")
    public String recherche(HttpServletRequest request, Model model) {
        try {
            System.out.println(request.getParameter("option"));
            int jouractuel = (request.getParameter("option").equals("jour") ? LocalDate.now().getDayOfMonth(): 0);
            int moisactuel = (request.getParameter("option").equals("mois") ? LocalDate.now().getMonthValue() : 0);
            int anneeactuel = (request.getParameter("option").equals("annee") ? LocalDate.now().getYear() : 0);
            java.util.Date datedeb = (request.getParameter("datedeb").equals("") ? null : new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datedeb")));
            java.util.Date datefin = (request.getParameter("datefin").equals("") ? null : new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("datefin")));
            int limit = 6;
            int page = 1;

            List<Scene> values = new Liste().ResearchScene(dao,jouractuel,moisactuel,anneeactuel,datedeb,datefin);

            request.getSession().setAttribute("liste_scene",new Liste().paginateListValidation(new Liste().getListeNonPlanifie(dao),limit,page));
            request.getSession().setAttribute("liste_scene_valide", values);
            request.getSession().setAttribute("liste_plannings",dao.findAll(PlanningScene.class));
        }
        catch(Exception e) { throw e; }
        finally { return "planning"; }
    }

    public ArrayList<Validation_Scene.ListePlanningScene> planningScenes(int idplateau) throws Exception {
        String requete= "select * from liste_planning_scene where idplateau=? ";
        ArrayList<Validation_Scene.ListePlanningScene> planningScenes=new ArrayList<>();
        Connexion con=new Connexion(requete);
        con.getStm().setInt(1,idplateau);
        con.Execute();
        ResultSet res=con.getRes();
        Validation_Scene.ListePlanningScene e=null;
        try{
            while(res.next())
            {
                int idp= res.getInt("idplanning_scene");
                int idsc=res.getInt("idscene");
                Timestamp idact=res.getTimestamp("datedebut");
                Timestamp idcat=res.getTimestamp("datefin");
                int id=res.getInt("id");
                String nom=res.getString("nom");
                int idfls=res.getInt("idfilm_series");
                int idplt=res.getInt("idplateau");
                int duree=res.getInt("duree");
                e=new Validation_Scene.ListePlanningScene(idp,idsc,idact,idcat,id,nom,idfls,idplt,duree);
                planningScenes.add(e);
            }
        }
        catch(Exception sqle){
            throw new Exception(sqle);
        }
        finally{
            con.getStm().executeQuery().close();
            con.Close();
        }
        return planningScenes;
    }

    @GetMapping("/toPermuter")
    public String toPermuter(HttpServletRequest request) {
        try {
            List<PlanningScene> list = dao.findAll(PlanningScene.class);
            request.getSession().setAttribute("listepourpermutation",list);
            request.setAttribute("response","none");
        }
        catch(Exception e) { throw e; }
        finally { return "Permutation"; }
    }

    @PostMapping("/permuter")
    public String permuter(HttpServletRequest request) {
        try {
            int idscene1 = Integer.parseInt(request.getParameter("idscene1"));
            int idscene2 = Integer.parseInt(request.getParameter("idscene2"));
            PlanningScene planning1 = dao.findById(PlanningScene.class,idscene1);
            PlanningScene planning2 = dao.findById(PlanningScene.class,idscene2);
            System.out.println("avant");
            System.out.println(planning1.getIdscene());
            planning1.setIdscene(request.getParameter("idscene2"));
            planning2.setIdscene(request.getParameter("idscene1"));

            dao.update(planning2);
            dao.update(planning1);
            System.out.println("après");
            System.out.println(planning1.getIdscene());
            request.setAttribute("response","update");
            List<PlanningScene> list = dao.findAll(PlanningScene.class);
            request.getSession().setAttribute("listepourpermutation",list);
        }
        catch(Exception e) { throw e; }
        finally { return "Permutation"; }
    }

    @GetMapping("/forPaginationPlanning/{page}/{list}")
    public String forPagination(HttpServletRequest request,@PathVariable int page, @PathVariable String list) {
        try {
            if(list.equals("nonevalide")) {
                List<Scene>  listnonvalide = (List<Scene>)request.getSession().getAttribute("liste_scene");
                request.getSession().setAttribute("liste_scene",new Liste().paginateListValidation(listnonvalide,6,page));
            }
            if(list.equals("valide")) {
                List<Scene>  valide = (List<Scene>)request.getSession().getAttribute("liste_scene_valide");
                request.getSession().setAttribute("liste_scene",new Liste().paginateListValidation(valide,6,page));
            }
        }
        catch(Exception e) { throw e; }
        finally { return "redirect:/planning"; }
    }

    @GetMapping("/listescene")
    public String listescene(Model model,@RequestParam(value = "idtournage") String idtournage){
        Scene scene= new Scene();
        scene.setIdfilmSeries(Integer.parseInt(idtournage));
        model.addAttribute("listescene",dao.findWhere(scene));
        return "listescene";
    }
    @GetMapping("/listeplanningscene")
    public String listeplanningscene(Model model,@RequestParam(value = "idplateau") String idplateau){
        try{
            model.addAttribute("listeplanningscene",planningScenes(Integer.parseInt(idplateau)));
        }catch(Exception exp){
            exp.printStackTrace();
        }

        return "listeplanningscene";
    }

    @PostMapping("/insertplanning")
    public String insertplanning(HttpServletRequest request) throws Exception {
        PlanningScene planningScene=null;
        String[] sceneID=request.getParameterValues("scene[]");
        if (sceneID != null && sceneID.length > 0) {
            for (String id : sceneID) {
                planningScene=new PlanningScene();
                planningScene.setIdscene(id);
                List<Indisponibilite_Plateau> indispoplateau = dao.findAll(Indisponibilite_Plateau.class);
                java.sql.Timestamp datedeb = new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("datedeb")).getTime());
                java.sql.Timestamp datefin = new java.sql.Timestamp(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(request.getParameter("datefin")).getTime());
                java.sql.Timestamp[] dates = new Utils().calculerNouvellesDates(indispoplateau,datedeb,datefin,Integer.parseInt(id));
                planningScene.setDatedebut(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(dates[0]));
                planningScene.setDatefin(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm").format(dates[1]));
                dao.create(planningScene);
                Validation_Scene validation = new Validation_Scene(Integer.parseInt(id),0,new java.sql.Timestamp(new java.util.Date().getTime()));
                dao.create(validation);
            }
        }
        else {
            System.out.println("No id were selected");
        }

        return "redirect:/planning";
    }
    @GetMapping("/redirectajoutscene")
    public String redirectajoutscene(Model model){
        model.addAttribute("listefilms",dao.findAll(FilmSery.class));
        model.addAttribute("listeplateau",dao.findAll(Plateau.class));
        return "ajoutscene";
    }
    @PostMapping("/insererscene")
    public String insererscene(HttpServletRequest request,Model model){
        Scene scene= new Scene();
        int idfilm=Integer.parseInt(request.getParameter("film"));
        int idplateau=Integer.parseInt(request.getParameter("plateau"));
        int duree=Integer.parseInt(request.getParameter("duree"));
        scene.setIdfilmSeries(idfilm);
        scene.setIdplateau(idplateau);
        scene.setDuree(duree);
        scene.setNom(request.getParameter("nom"));
        try{
            dao.create(scene);
            model.addAttribute("mety","1");

        }catch(Exception exp){
            throw exp;
        }
        return "redirect:/redirectajoutscene";
    }


}
