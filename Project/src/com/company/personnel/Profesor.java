package com.company.personnel;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.*;
import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class Profesor {

    public static String getProfesorNameByID(int ID_PROFESOR) throws SQLException {
        String searchedProfesor = "";

        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Searching profesor from the table...");
            stmt = conn.createStatement();
            String sql = "SELECT nume, prenume FROM profesor WHERE ID_PROFESOR =" + ID_PROFESOR;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                searchedProfesor = searchedProfesor + rs.getString("nume")
                                 + " " + rs.getString("prenume");
            }
            rs.close();
            System.out.println("Found profesor from the table...");
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

        if(!searchedProfesor.equals(""))
            return searchedProfesor;
        return "nonexistentId";
    }
}
