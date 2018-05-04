package com.company.catalog;

import java.sql.SQLException;

import static com.company.catalog.RapoarteCatalog.situatieElev;
import static com.company.database.DataBaseLogin.createConnection;

public class FunctionalitatiCatalog {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createConnection();

        //createElev(22, "Hincu", "Mihaela", "12A");
        //readElev();
        //updateElev(22, "Marinela");
        //deleteElev(22);

        //adaugareNota(21, 2, 9, "15-04-2018");
        //adaugareAbsenta(19, 2, "01-05-2018", "nemotivat");
        //PROBLEME MODIFICA DAR NU SE MODIFICA IN BAZA DE DATE motivareAbsenta(18,1,"01-05-2018");

        situatieElev(22);

    }
}
