package com.company.userInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import static com.company.positions.Profesor.getProfesorNameByID;
import static com.company.userInterface.AdaugaAbsenteUI.callAdaugaAbsenteUI;
import static com.company.userInterface.AdaugareNoteUI.callAdaugareNoteUI;

public class ProfesorUI extends JFrame {

    private JFrame frame;
    private static ProfesorUI profesorUI;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProfesorUI window = new ProfesorUI(1);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public static void callProfesorUI(int id) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    profesorUI = new ProfesorUI(id);
                    profesorUI.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    public ProfesorUI(int id) throws SQLException {
        initialize(id);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize(int id) throws SQLException{
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 326);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 434, 287);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(255, 235, 205));
        panel_1.setBounds(0, 0, 224, 287);
        panel.add(panel_1);
        panel_1.setLayout(null);

        JLabel label = new JLabel("");
        label.setIcon(new ImageIcon("E:\\facultate\\Sem2an2\\java\\download.png"));
        label.setBounds(10, 62, 204, 225);
        panel_1.add(label);

        JLabel numeProfesor = new JLabel("");
        numeProfesor.setHorizontalAlignment(SwingConstants.CENTER);
        numeProfesor.setFont(new Font("Lucida Calligraphy", Font.BOLD | Font.ITALIC, 15));
        numeProfesor.setForeground(new Color(0, 0, 0));
        numeProfesor.setBounds(0, 0, 224, 61);
        panel_1.add(numeProfesor);

        numeProfesor.setText(getProfesorNameByID(id));

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(224, 255, 255));
        panel_2.setBounds(222, 0, 212, 287);
        panel.add(panel_2);
        panel_2.setLayout(null);

        JButton btnNewButton = new JButton("New button");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                callAdaugareNoteUI(id);
            }
        });

        btnNewButton.setBackground(new Color(100, 149, 237));
        btnNewButton.setIcon(new ImageIcon("E:\\facultate\\Sem2an2\\java\\rsz_note.png"));
        btnNewButton.setBounds(76, 30, 74, 69);
        panel_2.add(btnNewButton);

        JLabel lblAdaugareNote = new JLabel("Adaugare note");
        lblAdaugareNote.setHorizontalAlignment(SwingConstants.CENTER);
        lblAdaugareNote.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
        lblAdaugareNote.setBounds(55, 110, 123, 14);
        panel_2.add(lblAdaugareNote);

        JButton btnNewButton_1 = new JButton("New button");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
                callAdaugaAbsenteUI(id);
            }
        });

        btnNewButton_1.setIcon(new ImageIcon("E:\\facultate\\Sem2an2\\java\\rsz_bad-naughty-student-002-512.png"));
        btnNewButton_1.setBounds(76, 146, 74, 69);
        panel_2.add(btnNewButton_1);

        JLabel lblAdaugareAbsente = new JLabel("Adaugare absente");
        lblAdaugareAbsente.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
        lblAdaugareAbsente.setBounds(42, 226, 136, 14);
        panel_2.add(lblAdaugareAbsente);
    }


}
