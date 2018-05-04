package com.company.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class LoginCatalog {

    public static void login() throws SQLException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter username");
        String username = keyboard.next();

        //vedem daca username-ul este de tip elev/profesor/director
        stmt = conn.createStatement();
        String sql = "SELECT tip FROM login WHERE username = '" + username + "'";
        ResultSet rs = stmt.executeQuery(sql);
        String tip = "";
        while(rs.next()){
            tip  = rs.getString("tip");
        }
        rs.close();

        switch (tip) {
            case "elev":
                loginElev();
                break;
            case "profesor":
                loginProfesor();
                break;
            case "director":
                loginDirector();
                break;
            default:
                System.out.println("-username inexistent-");
                break;
        }
    }

    private static void loginElev() {
        System.out.println("este elev");
    }

    private static void loginProfesor() {
        System.out.println("este profesor");
    }

    private static void loginDirector() {
        System.out.println("este director");
    }
}
