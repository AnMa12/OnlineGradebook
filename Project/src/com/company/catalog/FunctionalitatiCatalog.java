package com.company.catalog;

import java.sql.SQLException;

import static com.company.catalog.LoginCatalog.login;
import static com.company.database.DataBaseLogin.createConnection;

public class FunctionalitatiCatalog {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createConnection();
        login();
    }
}
