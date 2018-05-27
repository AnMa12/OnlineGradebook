package com.company.userInterface;

import com.company.loginInterface.loginUI;
import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.createConnection;
import static com.company.database.DataBaseLogin.stmt;
import static com.company.positions.Elev.getClassElevByID;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Dimension;

import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class ProfesorElevUI extends JFrame {

    private JFrame frame;
    private JTable table;
    private static ProfesorElevUI profesorElevUI;
    private  DefaultTableModel model;


    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProfesorElevUI window = new ProfesorElevUI(1);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static  void callProfesorElevUI(int id) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    profesorElevUI = new ProfesorElevUI(id);
                    //noteElevUI.frame.setVisible(true); - !!! trebuie stearsa
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public ProfesorElevUI(int id) throws SQLException, NullPointerException, Exception {
        initialize();
        try {
            //createConnection();
            model = new DefaultTableModel();
            table.setModel(model);

            model.addColumn("NUME");
            model.addColumn("PRENUME");
            model.addColumn("MATERIE");

            stmt = conn.createStatement();
            String sql = "select  p.nume, p.prenume, m.denumire\n" +
                    "from materiiprof mp join materie m on (mp.id_materie = m.id_materie)\n" +
                    "                    join profesor p on (mp.id_profesor = p.id_profesor)\n" +
                    "                    join clasa cl on (cl.id_mp = mp.id_mp)\n" +
                    "where cl.nume = '" + getClassElevByID(id) + "';";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getString("nume"),
                        rs.getString("prenume"),
                        rs.getString("denumire")

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





