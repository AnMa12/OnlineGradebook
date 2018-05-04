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
}