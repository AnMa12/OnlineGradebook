package com.company.elev;

import java.sql.SQLException;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class Note {

    public static void adaugareNota(int ID_ELEV, int ID_MP, int nota, String data_notei) throws SQLException {
        //STEP 4: Execute a query
        System.out.println("Inserting nota into note table...");
        stmt = conn.createStatement();

        String sql = "INSERT INTO note " +
                     "VALUES (" + nota + ", '" +  data_notei + "', " + ID_ELEV + ", " + ID_MP + ")";
        stmt.executeUpdate(sql);

        System.out.println("Inserted nota into the note...");
    }
}
