package com.company.detaliiElev;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class Absente {
    public static int getNrAbsenteElevByID (int ID_ELEV) throws SQLException {
        int numarAbsente = 0;
        //mergem in tabela de absente si vedem care au id-ul elevului
        //si care sunt nemotivate si le numaram

        String sql = "SELECT ID_ELEV, motivat FROM absente";
        ResultSet rs = stmt.executeQuery(sql);
        //STEP 5: Extract data from result set
        while (rs.next()) {
            int idElev = rs.getInt("ID_ELEV");
            String motivat = rs.getString("motivat");

            if (idElev == ID_ELEV && motivat.equals("nemotivat")) {
                numarAbsente++;
            }
        }
        return numarAbsente;
    }

    public static void adaugareAbsenta(int ID_ELEV, int ID_MP, String data_absentei, String motivat) throws SQLException {
        //STEP 4: Execute a query
        System.out.println("Inserting absenta into absenta table");
        stmt = conn.createStatement();

        String sql = "INSERT INTO absente " +
                "VALUES ('" + data_absentei + "', '" +  motivat + "', " + ID_ELEV + ", " + ID_MP + ")";
        stmt.executeUpdate(sql);

        System.out.println("Inserted absenta into absenta table");
    }

    public static void motivareAbsenta(int ID_ELEV, int ID_MP, String data_absentei) throws SQLException {
        //STEP 4: Execute a query
        System.out.println("Motivare absenta");
        stmt = conn.createStatement();
        String sql = "UPDATE absente " +
                "SET motivat = motivat WHERE ID_ELEV = " + ID_ELEV;
        stmt.executeUpdate(sql);
        System.out.println("Absenta motivata");
    }
}
