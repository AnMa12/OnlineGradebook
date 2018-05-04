package com.company.catalog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class LoginCatalog {

    public static void login() throws SQLException {
        /*TASK 1: Sistem de autentificare cu nume de utilizator si parola */
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter username");
        String username = keyboard.next();
        System.out.println("enter password");
        String password = keyboard.next();

        //vedem daca parola este corecta
        //vedem daca username-ul este de tip elev/profesor/director
        stmt = conn.createStatement();
        String sql = "SELECT parola, tip FROM login WHERE username = '" + username + "'";
        ResultSet rs = stmt.executeQuery(sql);
        String tip = "";
        String parola = "";
        while(rs.next()){
            parola = rs.getString("parola");
            tip  = rs.getString("tip");
        }
        rs.close();

        //TREBUIE FACUT CEVA CA SA SE POATA INTRODUCE PAROLA PANA E CORECTA
        if(parola.equals(password)) {
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
        else System.out.println("-parola incorecta-");
    }

    private static void loginDirector() {
        /* TASK 2: gestiunea elevilor – directorul scolii poate face operatii de tip
           CRUD(create, read, update, delete) pe datele acestora: nume, prenume, numar
           matricol, clasa;*/
        //aici o sa se poata accesa metodele din clasa Elev

        System.out.println("este director");

        //createElev(22, "Hincu", "Mihaela", "12A");
        //readElev();
        //updateElev(22, "Marinela");
        //deleteElev(22);
    }

    private static void loginProfesor() {
        /* TASK 3: gestiunea notelor si absentelor – profesorii pot face operatii de tip CRUD
           pe notele si absentele unui elev. O nota are identificatorul elevului,
           denumirea materiei, nota si data. O absenta are numele studentului,
           materia si data; */
        //aici o sa se poata acecsa metodele din clasa note si absente

        System.out.println("este profesor");

        //adaugareNota(21, 2, 9, "15-04-2018");
        //adaugareAbsenta(19, 2, "01-05-2018", "nemotivat");
        //PROBLEME MODIFICA DAR NU SE MODIFICA IN BAZA DE DATE motivareAbsenta(18,1,"01-05-2018");
    }

    private static void loginElev() {
        /* TASK 4: Rapoarte catalog – sa se implementeze raport pentru afisarea mediei
           notelor pe clasa si un raport pentru afisarea situatiei unui elev (afisarea
           notelor, numarul total de absente, media generala); */
        //aici o sa se poata accesa metodele din clasa rapoarte

        System.out.println("este elev");

        //situatieElev(22);
        }




    }
