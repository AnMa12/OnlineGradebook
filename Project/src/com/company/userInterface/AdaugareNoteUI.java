package com.company.userInterface;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JList;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;


import javax.swing.JComboBox;

import static com.company.positions.Profesor.getID_MP;
import static com.company.positions.Profesor.getMateriiByID;
import static com.company.database.DataBaseLogin.conn;

public class AdaugareNoteUI extends JFrame{

    private static AdaugareNoteUI adaugareNoteUI;
    private static JFrame frame;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AdaugareNoteUI window = new AdaugareNoteUI(1);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void callAdaugareNoteUI(int id) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    adaugareNoteUI = new AdaugareNoteUI(id);
                    //adaugareNoteUI.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the application.
     */
    public  AdaugareNoteUI(int id) throws SQLException, NullPointerException, Exception{
            initialize(id);

    }


    private void initialize(int id) throws SQLException{

        JTextField textField;
        JTextField textField_1;

        frame = new JFrame();
        frame.setBounds(100, 100, 307, 244);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205));
        panel.setForeground(new Color(255, 228, 196));
        panel.setBounds(0, 0, 296, 210);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNota = new JLabel("NOTA:");
        lblNota.setBounds(30, 84, 46, 14);
        panel.add(lblNota);

        JLabel lblMateria = new JLabel("MATERIA:");
        lblMateria.setBounds(30, 124, 68, 14);
        panel.add(lblMateria);

        JLabel lblData = new JLabel("DATA:");
        lblData.setBounds(30, 165, 46, 14);
        panel.add(lblData);

        JLabel lblIdElev = new JLabel("ID elev:");
        lblIdElev.setBounds(30, 48, 46, 14);
        panel.add(lblIdElev);


        textField = new JTextField();
        textField.setBounds(99, 45, 100, 20);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(99, 81, 100, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(99, 120, 100, 22);
        ArrayList<String> materii = getMateriiByID(id);
        for(String plm: materii){
           // System.out.println(plm);
            comboBox.addItem(plm);
        }


        comboBox.setSelectedItem(null);
        panel.add(comboBox);

        JDateChooser dateChooser = new JDateChooser();
        dateChooser.setBounds(97, 165, 102, 20);
        panel.add(dateChooser);

        JButton btnAdauga = new JButton("Adauga");
        btnAdauga.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                String id_elev = textField.getText();
                String nota = textField_1.getText();
                String materie = String.valueOf(comboBox.getSelectedItem());
                SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
                String data = sdf.format(dateChooser.getDate());

                String query = "INSERT INTO note VALUES(?,?,?,?)";
                PreparedStatement pst = null;
                try {
                    pst = conn.prepareStatement(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    pst.setInt(1,Integer.parseInt(nota));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    pst.setString(2,data);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    pst.setInt(3,Integer.parseInt(id_elev));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    pst.setInt(4,getID_MP(id,materie));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    pst.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println(id_elev);
                System.out.println(nota);
                System.out.println(materie);
                System.out.println(data);
            }
        });
        btnAdauga.setBounds(209, 161, 77, 23);
        panel.add(btnAdauga);
        frame.setVisible(true);
        JButton btnElevi = new JButton("Elevi");
        btnElevi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0)  {

            }
        });
        btnElevi.setBounds(30, 11, 89, 23);
        panel.add(btnElevi);
    }
}


