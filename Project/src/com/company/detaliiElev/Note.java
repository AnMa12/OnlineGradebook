package com.company.detaliiElev;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static com.company.positions.Materie.getMaterieProfesorNameByID;

public class Note {

    public static double getNoteMedieElevByID(int ID_ELEV) throws SQLException {
        //metoda returneaza media + notele
        //cautam in tabela de note doar notele care au la ID_ELEV elevul dorit, si facem media cu ele
        stmt = conn.createStatement();
        String sql = "SELECT nota, data_notei, ID_ELEV, ID_MP FROM note";
        ResultSet rs = stmt.executeQuery(sql);
            //in acelasi timp calculam si media
            int numarNote = 0;
            int sumaNote = 0;

        while(rs.next()){
            //Retrieve by column name
            int nota  = rs.getInt("nota");
            String last = rs.getString("data_notei");
            int idElev = rs.getInt("ID_ELEV");
            int idMaterieProf  = rs.getInt("ID_MP");

            System.out.println(" -" + getMaterieProfesorNameByID(idMaterieProf) + nota);

            if(idElev == ID_ELEV) {
                numarNote ++;
                sumaNote += nota;
            }
        }
        rs.close();

        double medie = 0;
        if(numarNote != 0) {
            medie = sumaNote/numarNote;
        }
        return medie;
    }

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
