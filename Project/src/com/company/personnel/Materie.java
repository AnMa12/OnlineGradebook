package com.company.personnel;

public class Materie {
    public static String getMaterieNameByID() {
        String searchedMaterie = "";



        if(!searchedMaterie.equals(""))
            return searchedMaterie;
        return "nonexistentId";
    }

    public static String getMaterieProfesorNameByID(int ID_MP) {
        //cu id-ul de materie profesor mergem in tabela
        //materie profesor pentru a ajunge la ID_Materie
        //si ID_PROFESO corespunzator si de acolo afisam
        //numele materie cu profesorul respectiv
        String searchedMaterieProfesor = "";



        if(!searchedMaterieProfesor.equals(""))
            return searchedMaterieProfesor;
        return "nonexistentId";
    }
}
