package com.company.userInterface;

import com.company.loginInterface.loginUI;
import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static com.company.userInterface.NoteElevUI.callNoteUI;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JToggleButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;


public class elevUI extends JFrame{

    private JFrame frame;
    private static elevUI elevUI;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        //callElevUI();
    }

    /**
     * Create the application.
     */
    public elevUI(int id) throws SQLException {
        initialize(id);
    }
    public static void callElevUI(int id) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    elevUI window = new elevUI(id);
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
    /**
     * Initialize the contents of the frame.
     */
    private void initialize(int id)throws SQLException {
        stmt = conn.createStatement();
        String sql = "SELECT nume,prenume,nume_clasa  FROM elev WHERE id_elev = " + id ;
        ResultSet rs = stmt.executeQuery(sql);
        String numeeElev = "";
        String prenumeElev = "";
        String numeClasa = "";
        while(rs.next()){
            numeeElev = rs.getString("NUME");
            prenumeElev = rs.getString("PRENUME");
            numeClasa  = rs.getString("NUME_CLASA");
        }
        rs.close();
        stmt.close();

        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new CompoundBorder());
        panel.setBackground(new Color(255, 228, 196));
        panel.setBounds(0, 0, 223, 361);
        frame.getContentPane().add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("E:\\facultate\\Sem2an2\\java\\35785-200.png"));
        lblNewLabel.setBounds(10, 79, 207, 118);
        panel.add(lblNewLabel);

        JLabel lblNume = new JLabel("Nume:");
        lblNume.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
        lblNume.setBounds(10, 217, 46, 14);
        panel.add(lblNume);

        JLabel lblClasa = new JLabel("Clasa:");
        lblClasa.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
        lblClasa.setBounds(10, 269, 46, 14);
        panel.add(lblClasa);

        JLabel numeElev = new JLabel("");
        numeElev.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        numeElev.setForeground(SystemColor.textText);
        numeElev.setBounds(37, 242, 180, 14);
        panel.add(numeElev);
        numeElev.setText( numeeElev + " " + prenumeElev );

        JLabel clasaElev = new JLabel("");
        clasaElev.setForeground(SystemColor.windowText);
        clasaElev.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
        clasaElev.setBounds(37, 294, 180, 14);
        panel.add(clasaElev);
        clasaElev.setText( numeClasa );

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(173, 216, 230));
        panel_1.setBounds(223, 0, 211, 361);
        frame.getContentPane().add(panel_1);
        panel_1.setLayout(null);

        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.addMouseListener(new MouseAdapter() {
            //situatie elev
            @Override
            public void mouseClicked(MouseEvent arg0) {
                callNoteUI();
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
        });
        lblNewLabel_1.setBounds(72, 29, 57, 59);
        panel_1.add(lblNewLabel_1);
        lblNewLabel_1.setIcon(new ImageIcon("E:\\facultate\\Sem2an2\\java\\rsz_images.jpg"));

        JLabel lblNewLabel_2 = new JLabel("New label");
        lblNewLabel_2.addMouseListener(new MouseAdapter() {
            //profesoriElev
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        lblNewLabel_2.setIcon(new ImageIcon("E:\\facultate\\Sem2an2\\java\\rsz_1images.jpg"));
        lblNewLabel_2.setBounds(72, 139, 57, 56);
        panel_1.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
            //Absente elev
            @Override
            public void mouseClicked(MouseEvent e) {
            }
        });
        lblNewLabel_3.setIcon(new ImageIcon("E:\\facultate\\Sem2an2\\java\\rsz_images_1.jpg"));
        lblNewLabel_3.setBounds(72, 246, 57, 58);
        panel_1.add(lblNewLabel_3);

        JLabel lblNote = new JLabel("Note");
        lblNote.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
        lblNote.setBounds(82, 99, 36, 14);
        panel_1.add(lblNote);

        JLabel lblProfesori = new JLabel("Profesori");
        lblProfesori.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
        lblProfesori.setBounds(72, 206, 67, 14);
        panel_1.add(lblProfesori);

        JLabel lblAbsente = new JLabel("Absente");
        lblAbsente.setFont(new Font("Lucida Handwriting", Font.BOLD, 11));
        lblAbsente.setBounds(72, 315, 57, 14);
        panel_1.add(lblAbsente);
    }
}

