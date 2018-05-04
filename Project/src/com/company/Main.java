package com.company;

import java.sql.SQLException;

import static com.company.personnel.Elev.addElev;

public class Main {

    public static void main(String[] args) throws SQLException {
	addElev(22, "Hincu", "Mihaela", "12A");
    }
}
