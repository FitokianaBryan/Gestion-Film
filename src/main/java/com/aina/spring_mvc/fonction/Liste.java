package com.aina.spring_mvc.fonction;

import com.aina.spring_mvc.connexion.Connexion;
import com.aina.spring_mvc.model.PlanningScene;
import com.aina.spring_mvc.model.PrioriteScene;
import com.aina.spring_mvc.model.Scene;
import com.aina.spring_mvc.model.Validation_Scene;
import org.aina.HibernateDao;
import org.hibernate.query.Query;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Liste {
    //pagination
    public List paginateListValidation(List list, int pageSize, int pageNumber) {
        int size = list.size();
        int page = (pageNumber <= 0 ? 1 : pageNumber);
        int startIndex = (page - 1) * pageSize;
        if (startIndex >= size) {
            startIndex = size;
        }
        int endIndex = Math.min(startIndex + pageSize, size);
        if (endIndex > size) {
            endIndex = size;
        }
        return new ArrayList<>(list.subList(startIndex, endIndex));
    }
    //LISTE DES SCENES NON PLANNIFIEES
    public List<Scene> getListeNonPlanifie(HibernateDao dao) {
        List<Scene> list = new ArrayList<Scene>();
        try {
            List<PlanningScene> plannings = dao.findAll(PlanningScene.class);
            List<Scene> scenes = dao.findAll(Scene.class);
            Set<Integer> plannedIds = new HashSet<>();
            for (PlanningScene ps : plannings) {
                plannedIds.add(ps.getIdscene());
            }
            for (Scene s : scenes) {
                if (!plannedIds.contains(s.getId())) {
                    list.add(s);
                }
            }
        }
        catch(Exception e) { throw e; }
        finally { return list; }
    }
    //LISTE DES PLANNING SCENE AVEC COMME ETAT l'ETAT VOULU
    public List<PlanningScene> getListeFor(HibernateDao dao, int Etat) {
        List<PlanningScene> list = new ArrayList<PlanningScene>();
        try {
            List<Validation_Scene> validations = dao.findAll(Validation_Scene.class);
            List<PlanningScene> plannings = dao.findAll(PlanningScene.class);
            for(PlanningScene plan : plannings) {
                for(Validation_Scene validation : validations) {
                    if(plan.getIdscene() == validation.getIDScene()) {
                        if(validation.getEtat() == Etat) {
                            list.add(plan);
                        }
                    }
                }
            }
        }
        catch(Exception e) { throw e; }
        finally { return list; }
    }

    //LISTE DES SCENES AVEC COMME DateValidation > now
    public List<Scene> getListeValidationNow(HibernateDao dao) {
        List<Scene> list = new ArrayList<Scene>();
        try {
            java.sql.Date now = new java.sql.Date(System.currentTimeMillis());
//            .after(obj3.getDateEtat())
            List<Scene> scenes = dao.findAll(Scene.class);
            Validation_Scene valide = new Validation_Scene();
            valide.setEtat(11);
            List<Validation_Scene> validations = dao.findWhere(valide);
            for(Scene scene : scenes) {
                for (Validation_Scene validate : validations) {
                    if(scene.getId() == validate.getIDScene()) {
                        if(now.after(validate.getMoment())) {
                            list.add(scene);
                        }
                    }
                }
            }
        }
        catch(Exception e) { throw e; }
        finally { return list; }
    }
    //RECHERCHE DE SCENE
    public List<Scene> ResearchScene(HibernateDao dao, int jouractuelle, int moisactuelle, int anneeactuelle, java.util.Date dateDefinedfirst, java.util.Date dateDefinedend) {
        List<Scene> list = new ArrayList<Scene>();
        try {
            List<PlanningScene> plannings = new ArrayList<PlanningScene>();
            String request = "SELECT * FROM Planning_Scene";
            Research recherche = new Research(request);
            recherche.add(!(jouractuelle == 0),"extract(day from datedebut) = ?",jouractuelle);
            recherche.add(!(moisactuelle == 0),"extract(month from datedebut) = ?",moisactuelle);
            recherche.add(!(anneeactuelle == 0),"extract(year from datedebut) = ?",anneeactuelle);
            recherche.add(!(dateDefinedfirst == null),"datedebut >= ?",dateDefinedfirst);
            recherche.add(!(dateDefinedend == null),"datedebut <= ?",dateDefinedend);
            Connexion con = new Connexion(request);
            con.Execute();
            PreparedStatement stm = recherche.newStatement(con.getCnt());
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                int idplanning_scene = rs.getInt("idplanning_scene");
                int idscene = rs.getInt("idscene");
                java.sql.Timestamp datedebut = rs.getTimestamp("datedebut");
                java.sql.Timestamp datefin = rs.getTimestamp("datefin");
                PlanningScene plann = new PlanningScene(idplanning_scene,idscene,datedebut,datefin);
                plannings.add(plann);
            }
            List<Scene> scenes = getListeValidationNow(dao);
            for(Scene scene : scenes) {
                for(PlanningScene plan : plannings) {
                    if(scene.getId() == plan.getIdscene()) {
                        list.add(scene);
                    }
                }
            }
            rs.close();
            stm.close();
            con.Close();
        }
        catch(Exception e) { throw e; }
        finally { return list; }
    }

    public List<Scene> PrioriteScene(List<Scene> valides, HibernateDao dao) throws Exception {
        List<Scene> result = new ArrayList<Scene>();
        PrioriteScene prio = new PrioriteScene();
        prio.setPriorite(1);
        List<PrioriteScene> priorites = dao.findWhere(prio);
        for(Scene scene : valides) {
            for(PrioriteScene priorite : priorites) {
                if(scene.getId() == priorite.getIDScene()) {
                    result.add(scene);
                }
            }
        }
        PrioriteScene prio2 = new PrioriteScene();
        prio2.setPriorite(0);
        List<PrioriteScene> prios = dao.findWhere(prio2);
        for(Scene scene : valides) {
            for(PrioriteScene prios2 : prios) {
                if(scene.getId() == prios2.getIDScene()) {
                    result.add(scene);
                }
            }
        }
        return result;
    }
}
