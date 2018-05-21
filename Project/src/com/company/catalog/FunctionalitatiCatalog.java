package com.company.catalog;

import java.sql.SQLException;

import static com.company.catalog.LoginCatalog.login;
import static com.company.database.DataBaseLogin.createConnection;
import static com.company.detaliiElev.Absente.adaugareAbsenta;
import static com.company.detaliiElev.Note.adaugareNota;
import static com.company.positions.Profesor.getID_MP;

public class FunctionalitatiCatalog {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createConnection();
        login();
    }
}
