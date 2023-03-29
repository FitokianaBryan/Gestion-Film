package com.aina.spring_mvc;

import com.aina.spring_mvc.fonction.Liste;
import com.aina.spring_mvc.model.Indisponibilite_Plateau;
import com.aina.spring_mvc.model.PlanningScene;
import com.aina.spring_mvc.model.Scene;
import org.aina.HibernateDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static Timestamp[] calculerNouvellesDates(List<Indisponibilite_Plateau> indisponibilites, Timestamp datedebut, Timestamp datefin, int idplateau) {
        Timestamp nouvelleDateDebut = datedebut;
        Timestamp nouvelleDateFin = datefin;

        // Parcourir toutes les indisponibilités
        for (Indisponibilite_Plateau indisponibilite : indisponibilites) {
            if(idplateau == indisponibilite.getIDPlateau()) {
                // Vérifier si la date de début est incluse dans l'indisponibilité
                if (indisponibilite.getDateDebut().before(datedebut) && indisponibilite.getDateFin().after(datedebut)) {
                    nouvelleDateDebut = new Timestamp(indisponibilite.getDateFin().getTime());
                    nouvelleDateFin = new Timestamp(indisponibilite.getDateFin().getTime() + datefin.getTime() - datedebut.getTime());
                }

                // Vérifier si la date de fin est incluse dans l'indisponibilité
                if (indisponibilite.getDateDebut().before(datefin) && indisponibilite.getDateFin().after(datefin)) {
                    nouvelleDateDebut = new Timestamp(indisponibilite.getDateFin().getTime() - datefin.getTime() + datedebut.getTime());
                    nouvelleDateFin = new Timestamp(indisponibilite.getDateFin().getTime());
                }

                // Vérifier si l'indisponibilité inclut les deux dates de début et de fin
                if (indisponibilite.getDateDebut().compareTo(datedebut) <= 0 && indisponibilite.getDateFin().compareTo(datefin) >= 0) {
                    // Ajouter la durée de l'indisponibilité à la nouvelle date de fin
                    long dureeIndisponibilite = indisponibilite.getDateFin().getTime() - indisponibilite.getDateDebut().getTime();
                    nouvelleDateDebut = new Timestamp(indisponibilite.getDateFin().getTime() + 1);
                    nouvelleDateFin = new Timestamp(nouvelleDateDebut.getTime() + datefin.getTime() - datedebut.getTime() + dureeIndisponibilite);
                }

                // Vérifier si la date de début est incluse dans l'indisponibilité et que la date de fin est après l'indisponibilité
                if (indisponibilite.getDateDebut().compareTo(datedebut) >= 0 && indisponibilite.getDateFin().compareTo(datefin) >= 0 && indisponibilite.getDateDebut().before(datefin)) {
                    nouvelleDateDebut = new Timestamp(indisponibilite.getDateFin().getTime() + 1);
                    nouvelleDateFin = new Timestamp(nouvelleDateDebut.getTime() + datefin.getTime() - datedebut.getTime());
                }
            }
        }

        return new Timestamp[] { nouvelleDateDebut, nouvelleDateFin };
    }

    private List<Scene> getListeNonPlanifie() {
        HibernateDao dao = (HibernateDao) new ClassPathXmlApplicationContext("spring-context.xml").getBean("hibernateDAO");
        List<Scene> list = new ArrayList<Scene>();
        try {
            List<PlanningScene> plannings = dao.findAll(PlanningScene.class);
            System.out.println("planning: "+plannings);
            List<Scene> scenes = dao.findAll(Scene.class);
            System.out.println("scenes: "+scenes);
            Set<Integer> plannedIds = new HashSet<>();
            for (PlanningScene ps : plannings) {
                plannedIds.add(ps.getIdscene());
            }
            System.out.println(plannedIds);
//            List<Scene> unplannedScenes = new ArrayList<>();
            for (Scene s : scenes) {
                if (!plannedIds.contains(s.getId())) {
                    list.add(s);
                }
            }
            System.out.println("results: "+list);
        }
        catch(Exception e) { throw e; }
        finally { return list; }
    }

    public static void main(String[] args) throws Exception {
        HibernateDao dao = (HibernateDao) new ClassPathXmlApplicationContext("spring-context.xml").getBean("hibernateDAO");
        System.out.println(LocalDate.now().getDayOfMonth());
    }
}
