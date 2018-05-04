package com.company;

import java.sql.SQLException;

import static com.company.personnel.Elev.createElev;
import static com.company.personnel.Elev.deleteElev;

public class Main {

    public static void main(String[] args) throws SQLException {
	createElev(22, "Hincu", "Mihaela", "12A");
	deleteElev(22);
    }
}
