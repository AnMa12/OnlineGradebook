package com.company.catalog;

import java.sql.SQLException;

import static com.company.database.DataBaseLogin.createConnection;
import static com.company.loginInterface.loginUI.callLoginUI;

public class FunctionalitatiCatalog {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        createConnection();
        callLoginUI();
    }
}
