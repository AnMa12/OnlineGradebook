package com.company.personnel;

import java.sql.*;

import static com.company.database.DataBaseLogin.DB_URL;
import static com.company.database.DataBaseLogin.PASS;
import static com.company.database.DataBaseLogin.USER;
import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class Elev {

    public static String getElevNameByID(int ID_ELEV) throws SQLException {
        String searchedName = "";
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Searching name from the table...");
            stmt = conn.createStatement();
            String sql = "SELECT nume, prenume FROM elev WHERE ID_ELEV =" + ID_ELEV;
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                searchedName = searchedName + rs.getString("nume") + " " +
                        rs.getString("prenume");
            }
            rs.close();
            System.out.println("Found name from the table...");
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            if(stmt!=null) conn.close();
            try{
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");

        if(!searchedName.equals(""))
            return searchedName;
        return "nonexistentId";
    }

    public static void createElev(int ID_ELEV, String nume,
                               String prenume, String nume_clasa) throws SQLException {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Inserting record into the table...");
            stmt = conn.createStatement();

            String sql = "INSERT INTO elev " +
                    "VALUES (" + ID_ELEV + ", '" + nume + "', '" + prenume + "', '" + nume_clasa + "')";
            stmt.executeUpdate(sql);

            System.out.println("Inserted record into the table...");
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

    public static void readElev() {
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

    public static void updateElev(int ID_ELEV, String numeNou) throws SQLException {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Updating record from the table...");
            stmt = conn.createStatement();
            String sql = "UPDATE elev " +
                    "SET nume = '" + numeNou + "' WHERE ID_ELEV = " + ID_ELEV;
            stmt.executeUpdate(sql);
            System.out.println("Updated record from the table...");
        } catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            if(stmt!=null) conn.close();
            try{
                if(conn!=null) {
                    conn.close();
                }
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }

    public static void deleteElev(int ID_ELEV) throws SQLException {
        try{
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Deleting record from the table...");

            stmt = conn.createStatement();
            String sql = "DELETE FROM elev " +
                    "WHERE ID_ELEV = " + ID_ELEV;
            stmt.executeUpdate(sql);

            System.out.println("Deleted record from the table...");
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
