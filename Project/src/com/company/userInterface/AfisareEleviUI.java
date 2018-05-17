package com.company.userInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;

public class AfisareEleviUI {
    private JFrame frame;
    private JTable table;
    private static AfisareEleviUI afisareEleviUI;
    private DefaultTableModel model;

    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static  void callAfisareEleviUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    afisareEleviUI = new AfisareEleviUI();
                    //noteElevUI.frame.setVisible(true); - !!! trebuie stearsa
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public AfisareEleviUI() throws SQLException, NullPointerException, Exception {
        initialize();
        try {
            //createConnection();
            model = new DefaultTableModel();
            table.setModel(model);

            model.addColumn("ID");
            model.addColumn("NUME");
            model.addColumn("PRENUME");
            model.addColumn("CLASA");



            stmt = conn.createStatement();
            String sql = "SELECT * FROM elev" ;
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("ID_ELEV"),
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("nume_clasa")


                });
            }
            rs.close();
            stmt.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    private void initialize() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setBounds(100, 100, 500, 450);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        table = new JTable();
        table.setPreferredScrollableViewportSize(new Dimension(450, 300));

        table.setCellSelectionEnabled(true);
        scrollPane.setViewportView(table);
        table.setColumnSelectionAllowed(true);
        table.setFillsViewportHeight(true);

        frame.setVisible(true);
    }
}
