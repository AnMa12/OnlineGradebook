package com.company.catalog;
import java.sql.SQLException;

import static com.company.catalog.LoginCatalog.login;
import static com.company.catalog.RapoarteCatalog.getClasaByIdElev;
import static com.company.catalog.RapoarteCatalog.medieClasa;
import static com.company.database.DataBaseLogin.createConnection;
import static com.company.detaliiElev.Note.getMedieElevByID;

public class FunctionalitatiCatalog {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createConnection();
        login();



    }
}
