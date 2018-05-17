package com.company.positions;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static com.company.positions.Profesor.getProfesorNameByID;

public class Materie {
    public static String getMaterieNameByID(int ID_MATERIE) throws SQLException {
        String searchedMaterie = "";

        //STEP 4: Execute a query
        stmt = conn.createStatement();
        String sql = "SELECT DENUMIRE FROM materie WHERE ID_MATERIE =" + ID_MATERIE;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            searchedMaterie = searchedMaterie + rs.getString("DENUMIRE");
        }
        rs.close();

        if(!searchedMaterie.equals(""))
            return searchedMaterie;
        return "nonexistentId";
    }

    public static String getMaterieProfesorNameByID(int ID_MP) throws SQLException {
        //cu id-ul de materie profesor mergem in tabela materie profesor pentru a ajunge la ID_Materie
        //si ID_PROFESOR corespunzator si de acolo afisam numele materie cu profesorul respectiv
        String searchedMaterieProfesor = "";

        //STEP 4: Execute a query
        stmt = conn.createStatement();
        String sql = "SELECT ID_MATERIE, ID_PROFESOR FROM materiiprof WHERE ID_MP =" + ID_MP;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            searchedMaterieProfesor = searchedMaterieProfesor +
                    getMaterieNameByID(Integer.parseInt(rs.getString("ID_MATERIE"))) +
                    " (cu " +
                    getProfesorNameByID(Integer.parseInt(rs.getString("ID_PROFESOR"))) +
                    "): ";
        }
        rs.close();

        if(!searchedMaterieProfesor.equals(""))
            return searchedMaterieProfesor;
        return "nonexistentId";
    }
    public static String getClase(int ID_MP) throws SQLException {
        //cu id-ul de materie profesor mergem in tabela materie profesor pentru a ajunge la ID_Materie
        //si ID_PROFESOR corespunzator si de acolo afisam numele materie cu profesorul respectiv
        String searchedMaterieProfesor = "";

        //STEP 4: Execute a query
        stmt = conn.createStatement();
        String sql = "SELECT ID_MATERIE, ID_PROFESOR FROM materiiprof WHERE ID_MP =" + ID_MP;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            searchedMaterieProfesor = searchedMaterieProfesor +
                    getMaterieNameByID(Integer.parseInt(rs.getString("ID_MATERIE"))) +
                    " (cu " +
                    getProfesorNameByID(Integer.parseInt(rs.getString("ID_PROFESOR"))) +
                    "): ";
        }
        rs.close();

        if(!searchedMaterieProfesor.equals(""))
            return searchedMaterieProfesor;
        return "nonexistentId";
    }
}