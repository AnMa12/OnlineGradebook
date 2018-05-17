package com.company.positions;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static com.company.database.DataBaseLogin.conn;

public class Profesor {

    public static String getProfesorNameByID(int ID_PROFESOR) throws SQLException {
        String searchedProfesor = "";

        //STEP 4: Execute a query
        //System.out.println("Searching profesor from the table...");
        stmt = conn.createStatement();
        String sql = "SELECT nume, prenume FROM profesor WHERE ID_PROFESOR =" + ID_PROFESOR;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            searchedProfesor = searchedProfesor + rs.getString("nume")
                    + " " + rs.getString("prenume");
        }
        rs.close();
        //System.out.println("Found profesor from the table...");

        if(!searchedProfesor.equals(""))
            return searchedProfesor;
        return "nonexistentId";
    }
    public static ArrayList<String> getMateriiByID(int ID_PROFESOR)throws SQLException{
        stmt = conn.createStatement();
        ArrayList<String> mat = new ArrayList<String>();;
        String sql = "select m.denumire\n" +
                "from materiiprof mp join materie m on (mp.id_materie = m.id_materie)\n" +
                "                    join profesor p on (mp.id_profesor = p.id_profesor)\n" +
                "WHERE p.id_profesor = " + ID_PROFESOR;
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()) {
            String materie = rs.getString("denumire");
            mat.add(materie);

        }
        rs.close();
                return mat;

    }
    public static int  getID_MP(int ID_PROFESOR,String materie) throws SQLException{
        stmt = conn.createStatement();
        String sql = "select id_mp\n" +
                "from materiiprof mp join materie m on (mp.id_materie = m.id_materie)\n" +
                "where id_profesor = " + ID_PROFESOR +
                " and m.denumire = ' " + materie +"'; ";
        ResultSet rs = stmt.executeQuery(sql);

            int  id_mp = rs.getInt("id_mp");



        rs.close();
        return id_mp;

    }

}
