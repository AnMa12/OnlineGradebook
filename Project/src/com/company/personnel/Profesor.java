package com.company.personnel;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class Profesor {

    public static String getProfesorNameByID(int ID_PROFESOR) throws SQLException {
        String searchedProfesor = "";

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

        if(!searchedProfesor.equals(""))
            return searchedProfesor;
        return "nonexistentId";
    }
}
