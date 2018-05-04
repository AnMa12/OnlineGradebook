package com.company.personnel;

import java.sql.*;

import static com.company.database.DataBase.DB_URL;
import static com.company.database.DataBase.PASS;
import static com.company.database.DataBase.USER;

public class Elev {

    private static Connection conn = null;
    private static Statement stmt = null;

    public static void createElev(int ID_ELEV, String nume,
                               String prenume, String nume_clasa) throws SQLException {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting record into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO elev " +
                    "VALUES (" + ID_ELEV + ", '" + nume + "', '" + prenume + "', '" + nume_clasa + "')";
            stmt.executeUpdate(sql);

            System.out.println("Inserted record into the table...");
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            if(stmt!=null) {
                conn.close();
            }
            try{
                if(null != conn) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void deleteElev(int ID_ELEV) throws SQLException {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Deleting record from the table...");

            stmt = conn.createStatement();
            String sql = "DELETE FROM elev " +
                    "WHERE ID_ELEV = " + ID_ELEV;
            stmt.executeUpdate(sql);

            System.out.println("Deleted record from the table...");
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            if(stmt!=null) {
                conn.close();
            }
            try{
                if(null != conn) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}
