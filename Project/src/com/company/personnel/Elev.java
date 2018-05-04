package com.company.personnel;

import java.sql.*;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class Elev {

    public static String getElevNameByID(int ID_ELEV) throws SQLException {
        String searchedName = "";
            //STEP 4: Execute a query
            System.out.println("Searching name from the table elev");
            stmt = conn.createStatement();
            String sql = "SELECT nume, prenume FROM elev WHERE ID_ELEV =" + ID_ELEV;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                searchedName = searchedName + rs.getString("nume") + " " +
                        rs.getString("prenume");
            }
            rs.close();
            System.out.println("Found name from the table elev");

            if(!searchedName.equals(""))
            return searchedName;
        return "nonexistentId";
    }

    public static void createElev(int ID_ELEV, String nume,
                               String prenume, String nume_clasa) throws SQLException {
            //STEP 4: Execute a query
            System.out.println("Inserting record into table elev");
            stmt = conn.createStatement();
            String sql = "INSERT INTO elev " +
                    "VALUES (" + ID_ELEV + ", '" + nume + "', '" + prenume + "', '" + nume_clasa + "')";
            stmt.executeUpdate(sql);
            System.out.println("Inserted record into table elev");
    }

    public static void readElev() throws SQLException {
            //STEP 4: Execute a query
            System.out.println("Reading record from table elev");
            stmt = conn.createStatement();

            String sql = "SELECT ID_ELEV, nume, prenume, nume_clasa FROM elev";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("ID_ELEV");
                String last = rs.getString("nume");
                String first = rs.getString("prenume");
                String schoolClass = rs.getString("nume_clasa");
                //Display values
                System.out.print("ID: " + id);
                System.out.print(", School Class: " + schoolClass);
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);
            }
            rs.close();
            System.out.println("Done Reading record from table elev");
    }

    public static void updateElev(int ID_ELEV, String numeNou) throws SQLException {
            //STEP 4: Execute a query
            System.out.println("Updating record from table elev");
            stmt = conn.createStatement();
            String sql = "UPDATE elev " +
                    "SET nume = '" + numeNou + "' WHERE ID_ELEV = " + ID_ELEV;
            stmt.executeUpdate(sql);
            System.out.println("Updated record from table elev");
    }

    public static void deleteElev(int ID_ELEV) throws SQLException {
            //STEP 4: Execute a query
            System.out.println("Deleting record from table elev");
            stmt = conn.createStatement();
            String sql = "DELETE FROM elev " +
                    "WHERE ID_ELEV = " + ID_ELEV;
            stmt.executeUpdate(sql);
            System.out.println("Deleted record from table elev");
    }
}
