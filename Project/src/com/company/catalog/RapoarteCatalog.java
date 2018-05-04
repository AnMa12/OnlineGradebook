package com.company.catalog;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.DB_URL;
import static com.company.database.DataBaseLogin.PASS;
import static com.company.database.DataBaseLogin.USER;
import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static com.company.personnel.Elev.getElevNameByID;

public class RapoarteCatalog {

    public static void medieClasa (String nume_clasa) {
        //trebuie luate toate notele elevilor dintr-o clasa
    }

    public static void situatieElev (int idElevCautat) {
        //cautam in tabela de note doar notele care
        //au la ID_ELEV elevul dorit, si facem media cu ele
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT nota, data_notei, ID_ELEV, ID_MP FROM note";
            ResultSet rs = stmt.executeQuery(sql);
            int numarNote = 0;
            int sumaNote = 0;
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int nota  = rs.getInt("nota");
                String last = rs.getString("data_notei");
                int idElev = rs.getInt("ID_ELEV");
                int idMaterieProf  = rs.getInt("ID_MP");

                System.out.println("nota: " + nota);

                //daca elevul curent este cel cautat trebuie sa ii afisam situatia
                if(idElev == idElevCautat) {
                    numarNote ++;
                    sumaNote += nota;
                }
            }

            double medie = 0;
            if(numarNote != 0) {
                medie = sumaNote/numarNote;
            }

            System.out.println("MEDIA ELEVULUI " + getElevNameByID(idElevCautat) + " este: " + medie );
            rs.close();
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}
