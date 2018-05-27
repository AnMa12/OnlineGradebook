package com.company.catalog;
import java.sql.SQLException;
import static com.company.loginInterface.loginUI.callLoginUI;

public class LoginCatalog {

    public static void login() throws SQLException {
        /*TASK 1: Sistem de autentificare cu nume de utilizator si parola */
        callLoginUI();
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

    private static void loginProfesor() throws SQLException {
        /* TASK 3: gestiunea notelor si absentelor – profesorii pot face operatii de tip CRUD
           pe notele si absentele unui detaliiElev. O nota are identificatorul elevului,
           denumirea materiei, nota si data. O absenta are numele studentului,
           materia si data; */
        //aici o sa se poata acecsa metodele din clasa note si absente

        System.out.println("este profesor");

        //adaugareNota(21, 2, 9, "15-04-2018");
        //adaugareAbsenta(19, 2, "01-05-2018", "nemotivat");
        //PROBLEME MODIFICA DAR NU SE MODIFICA IN BAZA DE DATE motivareAbsenta(18,1,"01-05-2018");
    }

    private static void loginElev() throws SQLException {
        /* TASK 4: Rapoarte catalog – sa se implementeze raport pentru afisarea mediei
           notelor pe clasa si un raport pentru afisarea situatiei unui detaliiElev (afisarea
           notelor, numarul total de absente, media generala); */
        //aici o sa se poata accesa metodele din clasa rapoarte

        System.out.println("este detaliiElev");

        //situatieElev(22);
        }

    }
