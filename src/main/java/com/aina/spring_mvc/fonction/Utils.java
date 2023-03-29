package com.aina.spring_mvc.fonction;

import com.aina.spring_mvc.model.Indisponibilite_Plateau;

import java.sql.Timestamp;
import java.util.List;

public class Utils {
    public static Timestamp[] calculerNouvellesDates(List<Indisponibilite_Plateau> indisponibilites, Timestamp datedebut, Timestamp datefin, int idplateau) {

        Timestamp nouvelleDateDebut = datedebut;
        Timestamp nouvelleDateFin = datefin;

        // Parcourir toutes les indisponibilités
        for (Indisponibilite_Plateau indisponibilite : indisponibilites) {
            if(idplateau == indisponibilite.getIDPlateau()) {
                // Vérifier si la date de début est incluse dans l'indisponibilité
                if (indisponibilite.getDateDebut().before(datedebut) && indisponibilite.getDateFin().after(datedebut)) {
                    nouvelleDateDebut = new Timestamp(indisponibilite.getDateFin().getTime() + 3600_000 + 3600_000);
                    nouvelleDateFin = new Timestamp(indisponibilite.getDateFin().getTime() + datefin.getTime() - datedebut.getTime() + 3600_000 + 3600_000);
                }

                // Vérifier si la date de fin est incluse dans l'indisponibilité
                if (indisponibilite.getDateDebut().before(datefin) && indisponibilite.getDateFin().after(datefin)) {
                    nouvelleDateDebut = new Timestamp(indisponibilite.getDateFin().getTime() - datefin.getTime() + datedebut.getTime() + 3600_000 + 3600_000);
                    nouvelleDateFin = new Timestamp(indisponibilite.getDateFin().getTime() + 3600_000 + 3600_000);
                }
            }
        }

        return new Timestamp[] { nouvelleDateDebut, nouvelleDateFin };
    }
}
