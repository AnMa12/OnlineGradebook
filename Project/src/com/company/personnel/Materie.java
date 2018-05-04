package com.company.personnel;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.*;
import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static com.company.personnel.Profesor.getProfesorNameByID;

public class Materie {
    public static String getMaterieNameByID(int ID_MATERIE) throws SQLException {
        String searchedMaterie = "";

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Searching materie from the table...");
            stmt = conn.createStatement();
            String sql = "SELECT DENUMIRE FROM materie WHERE ID_MATERIE =" + ID_MATERIE;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                searchedMaterie = searchedMaterie + rs.getString("DENUMIRE");
            }
            rs.close();
            System.out.println("Found materie from the table...");
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            if(stmt!=null) conn.close();
            try{
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        if(!searchedMaterie.equals(""))
            return searchedMaterie;
        return "nonexistentId";
    }

    public static String getMaterieProfesorNameByID(int ID_MP) throws SQLException {
        //cu id-ul de materie profesor mergem in tabela
        //materie profesor pentru a ajunge la ID_Materie
        //si ID_PROFESO corespunzator si de acolo afisam
        //numele materie cu profesorul respectiv
        String searchedMaterieProfesor = "";

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Searching materieprofesor from the table...");
            stmt = conn.createStatement();
            String sql = "SELECT ID_MATERIE, ID_PROFESOR FROM materiiprof WHERE ID_MP =" + ID_MP;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                searchedMaterieProfesor = searchedMaterieProfesor +
                        "Materia " +
                            getMaterieProfesorNameByID(Integer.parseInt(rs.getString("ID_MATERIE"))) +
                        " ( " +
                            getProfesorNameByID(Integer.parseInt(rs.getString("ID_PROFESOR"))) +
                        " )";
            }
            rs.close();
            System.out.println("Found materieprofesor from the table...");
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            if(stmt!=null) conn.close();
            try{
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        if(!searchedMaterieProfesor.equals(""))
            return searchedMaterieProfesor;
        return "nonexistentId";
    }
}
