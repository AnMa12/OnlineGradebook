package com.company.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static com.company.detaliiElev.Absente.getNrAbsenteElevByID;
import static com.company.detaliiElev.Note.getNoteMedieElevByID;
import static com.company.positions.Elev.getElevNameByID;

public class RapoarteCatalog {

    public static String getClasaByIdElev(int idElev) throws SQLException {
        stmt = conn.createStatement();
        String sql = "SELECT nume_clasa\n" +
                "        FROM elev\n" +
                "        WHERE ID_ELEV = " + idElev + ";";
        ResultSet rs = stmt.executeQuery(sql);
        String numeClasa = "";
        while(rs.next()) {
            numeClasa = numeClasa + rs.getString("nume_clasa");
        }

        rs.close();
        return numeClasa;
    }

    public static double medieClasa (String numeClasa) throws SQLException {
        //trebuie luate toate notele elevilor dintr-o clasa
        //STEP 4: Execute a query
        stmt = conn.createStatement();
        String sql = "SELECT AVG(n.nota) FROM note n WHERE id_elev " +
                     "IN ( SELECT e.ID_ELEV FROM elev e WHERE nume_clasa = '" + numeClasa + "');" ;
        ResultSet rs = stmt.executeQuery(sql);
        double medieClasa = 0;
        while(rs.next()) {
            medieClasa = rs.getInt("AVG(n.nota)");
        }

        rs.close();
        return medieClasa;
    }

    public static void situatieElev (int idElevCautat) throws SQLException {
        System.out.println("Fisa elevului: " + getElevNameByID(idElevCautat));
        System.out.println("Note: ");
        System.out.println("Medie: " + getNoteMedieElevByID(idElevCautat)); //afisare note + return medie
        System.out.println("Numar de absente nemotivate: " + getNrAbsenteElevByID(idElevCautat));
    }
}