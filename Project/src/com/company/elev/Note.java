package com.company.elev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import static com.company.database.DataBaseLogin.DB_URL;
import static com.company.database.DataBaseLogin.PASS;
import static com.company.database.DataBaseLogin.USER;

public class Note {

    private static Connection conn = null;
    private static Statement stmt = null;

    public static void adaugareNota(int ID_ELEV, int ID_MP, int nota, String data_notei) throws SQLException {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting nota into note table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO note " +
                    "VALUES (" + nota + ", '" +  data_notei + "', " + ID_ELEV + ", " + ID_MP + ")";
            stmt.executeUpdate(sql);

            System.out.println("Inserted nota into the note...");
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            if(stmt!=null) {
                conn.close();
            }
            try{
                if(null != conn) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }
}
