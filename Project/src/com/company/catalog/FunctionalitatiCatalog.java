package com.company.catalog;

import java.sql.SQLException;

import static com.company.catalog.RapoarteCatalog.situatieElev;
import static com.company.database.DataBaseLogin.createConnection;
import static com.company.personnel.Elev.*;
import static com.company.elev.Note.*;

public class FunctionalitatiCatalog {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createConnection();

        //createElev(22, "Hincu", "Mihaela", "12A");
        //readElev();
        //updateElev(22, "Marinela");
        //deleteElev(22);

        //adaugareNota(21, 2, 9, "15-04-2018");

        situatieElev(22);
    }
}
