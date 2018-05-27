package com.company.database;

import java.sql.*;

public class DataBaseLogin {
    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://myownpi.ddns.net:3306/catalog";

    //  Database credentials
    public static final String USER = "admin";
    public static final String PASS = "admin";

    public static Connection conn = null;
    public static Statement stmt = null;

    public static void createConnection() throws ClassNotFoundException, SQLException {
        //STEP 2: Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        //STEP 3: Open a connection
        System.out.println("Connecting to a selected database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
        System.out.println("Connected database successfully...");
    }
}