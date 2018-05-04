package com.company.catalog;

import java.sql.SQLException;

import static com.company.elev.Absente.getNrAbsenteElevByID;
import static com.company.elev.Note.getNoteMedieElevByID;
import static com.company.positions.Elev.getElevNameByID;

public class RapoarteCatalog {

    public static void medieClasa (String nume_clasa) {
        //trebuie luate toate notele elevilor dintr-o clasa
    }

    public static void situatieElev (int idElevCautat) throws SQLException {
        System.out.println("Fisa elevului: " + getElevNameByID(idElevCautat));
        System.out.println("Note: ");
        System.out.println("Medie: " + getNoteMedieElevByID(idElevCautat)); //afisare note + return medie
        System.out.println("Numar de absente nemotivate: " + getNrAbsenteElevByID(idElevCautat));
    }
}