package com.company.userInterface;

import com.company.loginInterface.loginUI;
import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.createConnection;
import static com.company.database.DataBaseLogin.stmt;
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




public class NoteElevUI extends JFrame {

    private JFrame frame;
    private JTable table;
    private static NoteElevUI noteElevUI;
    private  DefaultTableModel model;


    public static void main(String[] args) throws Exception {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NoteElevUI window = new NoteElevUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static  void callNoteUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                     noteElevUI = new NoteElevUI();
                    noteElevUI.frame.setVisible(true);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public NoteElevUI() throws SQLException, NullPointerException, Exception {
        initialize();
        try {
            //createConnection();
            model = new DefaultTableModel();
            table.setModel(model);

            model.addColumn("NOTA");
            model.addColumn("DATA");
            model.addColumn("MATERIE");
            model.addColumn("PROFESOR");



            stmt = conn.createStatement();
            String sql = "select n.nota,n.data_notei,m.denumire, p.nume, p.prenume\n" +
                    "from materiiprof mp join materie m on (mp.id_materie = m.id_materie)\n" +
                    "                    join profesor p on (mp.id_profesor = p.id_profesor)\n" +
                    "                    join note n on (n.id_mp = mp.id_mp)\n" +
                    "where n.id_elev = 1; ";
            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("n.nota"),
                        rs.getString("n.data_notei"),
                        rs.getString("m.denumire"),
                        rs.getString("p.nume") + " " +
                                rs.getString("p.prenume")

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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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





