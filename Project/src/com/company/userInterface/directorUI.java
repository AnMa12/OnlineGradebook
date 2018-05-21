package com.company.userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static com.company.detaliiElev.Note.adaugareNota;
import static com.company.positions.Elev.createElev;
import static com.company.positions.Elev.deleteElev;
import static com.company.positions.Elev.updateElev;
import static com.company.positions.Profesor.getID_MP;
import static com.company.positions.Profesor.getMateriiByID;
import static com.company.positions.Profesor.getProfesorNameByID;
import static com.company.userInterface.AfisareEleviUI.callAfisareEleviUI;

public class DirectorUI extends JFrame {
    private JFrame frame;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private static DirectorUI directorUI;
    private JTextField textField_3;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    //DirectorUI window = new DirectorUI(5);
                    //window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void callDirectorUI(int id) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    directorUI = new DirectorUI(id);
                    directorUI.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
        	public DirectorUI(int id) throws SQLException {
            initialize(id);
        }

        private void initialize(int id) throws SQLException {
            frame = new JFrame();
            frame.setBounds(100, 100, 450, 345);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().setLayout(null);

            JPanel panel = new JPanel();
            panel.setBackground(new Color(255, 235, 205));
            panel.setBounds(0, 0, 227, 306);
            frame.getContentPane().add(panel);
            panel.setLayout(null);

            JLabel lblNewLabel = new JLabel("");
            lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
            lblNewLabel.setBounds(10, 278, 210, 25);
            panel.add(lblNewLabel);
            lblNewLabel.setText(getProfesorNameByID(id));

            JLabel label = new JLabel("");
            label.setBounds(0, 11, 220, 256);
            label.setIcon(new ImageIcon("E:\\facultate\\Sem2an2\\java\\rsz_neutral-s005-512.png"));
            panel.add(label);

            JPanel panel_1 = new JPanel();
            panel_1.setBackground(new Color(224, 255, 255));
            panel_1.setBounds(223, 0, 211, 306);
            frame.getContentPane().add(panel_1);
            panel_1.setLayout(null);


            JLabel lblIntroduId = new JLabel("Introdu ID: ");
            lblIntroduId.setBounds(10, 139, 89, 23);
            panel_1.add(lblIntroduId);
            lblIntroduId.setVisible(false);

            textField = new JTextField();
            textField.setBounds(98, 140, 103, 20);
            panel_1.add(textField);
            textField.setColumns(10);
            textField.setVisible(false);

            JLabel lblIntroduNume = new JLabel("Introdu nume:");
            lblIntroduNume.setBounds(10, 173, 89, 14);
            panel_1.add(lblIntroduNume);
            lblIntroduNume.setVisible(false);

            textField_1 = new JTextField();
            textField_1.setBounds(98, 171, 103, 20);
            panel_1.add(textField_1);
            textField_1.setColumns(10);
            textField_1.setVisible(false);

            JLabel lblIntroduPrenume = new JLabel("Introdu Prenume");
            lblIntroduPrenume.setBounds(10, 201, 81, 14);
            panel_1.add(lblIntroduPrenume);
            lblIntroduPrenume.setVisible(false);

            textField_2 = new JTextField();
            textField_2.setBounds(98, 198, 103, 20);
            panel_1.add(textField_2);
            textField_2.setColumns(10);
            textField_2.setVisible(false);

            JLabel lblIntroduClasa = new JLabel("Introdu clasa");
            lblIntroduClasa.setBounds(10, 232, 81, 14);
            panel_1.add(lblIntroduClasa);
            lblIntroduClasa.setVisible(false);

            textField_3 = new JTextField();
            textField_3.setBounds(98, 229, 103, 20);
            panel_1.add(textField_3);
            textField_3.setColumns(10);
            textField_3.setVisible(false);

            JButton btnTrimite = new JButton("Trimite");
            btnTrimite.setBounds(60, 272, 89, 23);
            panel_1.add(btnTrimite);
            btnTrimite.setVisible(false);

            JButton btnNewButton = new JButton("Sterge elev");
            btnNewButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent arg0) {
                    //OPTIUNEA DE STERGERE ELEV
                    lblIntroduId.setVisible(true);
                    textField.setVisible(true);
                    btnTrimite.setVisible(true);
                    btnTrimite.setText("Sterge");
                    //CAND APASAM BUTONUL STERGEM ELEVEUL
                    btnTrimite.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                        //LUAM ID-UL PE CARE IL VREM SI STERGEM ELEVUL
                            String id_elev = textField.getText();
                            try {
                                //DELETE
                                deleteElev(Integer.parseInt(id_elev));
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            });
            btnNewButton.setBounds(64, 45, 104, 23);
            panel_1.add(btnNewButton);

            JButton btnElevi = new JButton("Lista Elevi");
            btnElevi.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //READ
                    callAfisareEleviUI();
                    lblIntroduId.setVisible(false);
                    textField.setVisible(false);
                    btnTrimite.setVisible(false);
                    textField_3.setVisible(false);
                    lblIntroduClasa.setVisible(false);
                    textField_2.setVisible(false);
                    lblIntroduPrenume.setVisible(false);
                    textField_1.setVisible(false);
                    lblIntroduNume.setVisible(false);
                }
            });
            btnElevi.setBounds(64, 11, 104, 23);
            panel_1.add(btnElevi);

            JButton btnNewButton_1 = new JButton("Adauga elev");
            btnNewButton_1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //CREATE
                    lblIntroduId.setVisible(true);
                    textField.setVisible(true);
                    textField_3.setVisible(true);
                    lblIntroduClasa.setVisible(true);
                    textField_2.setVisible(true);
                    lblIntroduPrenume.setVisible(true);
                    textField_1.setVisible(true);
                    lblIntroduNume.setVisible(true);

                    btnTrimite.setVisible(true);
                    btnTrimite.setText("Adauga");
                    //CAND APASAM BUTONUL ADAUGAM ELEVUL
                    btnTrimite.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                            //LUAM ID-UL PE CARE IL VREM SI STERGEM ELEVUL
                            String id_elev = textField.getText();
                            String clasaElev= textField_3.getText();
                            String prenumeElev = textField_2.getText();
                            String numeElev = textField_1.getText();

                            try {
                                //CREATE
                                createElev(Integer.parseInt(id_elev),numeElev,prenumeElev,clasaElev);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            });
            btnNewButton_1.setBounds(64, 79, 104, 23);
            panel_1.add(btnNewButton_1);

            JButton btnNewButton_0 = new JButton("Update elev");
            btnNewButton_0.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //UPDATE
                    lblIntroduId.setVisible(true);
                    textField.setVisible(true);
                    textField_1.setVisible(true);
                    lblIntroduNume.setVisible(true);

                    textField_3.setVisible(false);
                    lblIntroduClasa.setVisible(false);
                    textField_2.setVisible(false);
                    lblIntroduPrenume.setVisible(false);

                    btnTrimite.setVisible(true);
                    btnTrimite.setText("Update");
                    //CAND APASAM BUTONUL UPDATAM ELEVUL
                    btnTrimite.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent arg0) {
                            //LUAM ID-UL PE CARE IL VREM SI UPDATAM NUMELE
                            String id_elev = textField.getText();
                            String numeElev = textField_1.getText();

                            try {
                                //CREATE
                                updateElev(Integer.parseInt(id_elev),numeElev);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            });
            btnNewButton_0.setBounds(64, 113, 104, 23);
            panel_1.add(btnNewButton_0);
        }
    }



