package com.company.database;

import java.sql.*;

public class DataBase {
    // JDBC driver name and database URL
    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://myownpi.ddns.net:3306/catalog";

    //  Database credentials
    public static final String USER = "admin";
    public static final String PASS = "admin";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement stmt = null;
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT ID_ELEV, nume, prenume, nume_clasa FROM elev";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("ID_ELEV");
                String last = rs.getString("nume");
                String first = rs.getString("prenume");
                String schoolClass = rs.getString("nume_clasa");


                //Display values
                System.out.print("ID: " + id);
                System.out.print(", School Class: " + schoolClass);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample