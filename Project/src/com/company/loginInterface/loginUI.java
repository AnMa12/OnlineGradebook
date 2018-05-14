package com.company.loginInterface;

import  com.company.userInterface.elevUI;
import com.company.userInterface.directorUI;

import com.company.userInterface.profesorUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;


import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class loginUI extends JFrame {

    private static loginUI loginPage;
    private JFrame frame;

    private JTextField usernameField;
    private JPasswordField passwordField;

    /*public static void callLoginUI() {
        EventQueue.invokeLater(() -> {
            try {
                loginPage = new loginUI();
                loginPage.frame.setVisible(true);
            }catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });

    }*/

    public static void callLoginUI() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    loginPage = new loginUI();
                    loginPage.frame.setVisible(true);
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private loginUI() {

        frame = new JFrame();
        frame.getContentPane().setForeground(new Color(204, 153, 0));
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel1 = new JPanel();
        panel1.setBorder(UIManager.getBorder("Spinner.border"));
        panel1.setBackground(new Color(255, 204, 102));
        panel1.setBounds(0, 0, 434, 49);
        frame.getContentPane().add(panel1);
        panel1.setLayout(null);

        JLabel log = new JLabel("Login");
        log.setForeground(Color.WHITE);
        log.setBackground(Color.WHITE);
        log.setFont(new Font("Berlin Sans FB Demi", Font.BOLD, 27));
        log.setBounds(41, 11, 98, 38);
        panel1.add(log);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(0, 0, 102));
        panel2.setBounds(0, 0, 434, 261);
        frame.getContentPane().add(panel2);
        panel2.setLayout(null);

        JLabel usernameLabel= new JLabel("Username:");
        usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setBounds(49, 108, 91, 23);
        panel2.add(usernameLabel);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setBounds(49, 159, 78, 23);
        panel2.add(passwordLabel);

        //JLabel usernameLabel = new JLabel("Username");
        //JLabel passwordLabel = new JLabel("Password");

        passwordField = new JPasswordField();
        passwordField.setToolTipText("");
        passwordField.setBounds(137, 162, 208, 20);
        panel2.add(passwordField);

        usernameField = new JTextField();
        usernameField.setBounds(137, 111, 208, 20);
        panel2.add(usernameField);
        usernameField.setColumns(10);

        //usernameField = new JTextField(15);
        //passwordField = new JPasswordField(15);


        JButton loginBtn = new JButton("Login");
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        loginBtn.setBackground(SystemColor.activeCaptionBorder);
        loginBtn.setBounds(258, 206, 89, 23);
        panel2.add(loginBtn);


        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String username = usernameField.getText();
                    String password = passwordField.getText();
                    testUsernamePassword(username, password);
                    //and open the correct user page
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        //createLayout(usernameLabel, usernameField, passwordLabel, passwordField, loginBtn);
        //setTitle("Login");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void testUsernamePassword(String username, String password) throws SQLException {
        //luam datele dupa username-ul introdus
        stmt = conn.createStatement();
        String sql = "SELECT IDD,parola, tip FROM login WHERE username = '" + username + "'";
        ResultSet rs = stmt.executeQuery(sql);
        String tip = "", parola = "";
        int id = 0;
        while(rs.next()){
            id = rs.getInt("IDD");
            parola = rs.getString("parola");
            tip  = rs.getString("tip");
        }

        rs.close();
        stmt.close();

        //testam daca parola este coreta si daca username-ul este de tip Elev/profesor/director
        int loginSuccess = 0;
        int tipEroare = 0;

        if (!username.isEmpty() && !password.isEmpty()) {
            if(tip.equals("")) {
                tipEroare = 1; //System.out.println("-username inexistent-");
            }
            else if(parola.equals(password)) {
                loginSuccess = 1;
                switch (tip) {
                    case "elev": {
                        //elevUI elevUI = new elevUI();
                        //elevUI.setVisible(true);
                        com.company.userInterface.elevUI.callElevUI(id);
                        break;
                    }
                    case "profesor": {
                        profesorUI profesorUI = new profesorUI();
                        profesorUI.setVisible(true);
                        break;
                    }
                    case "director": {
                        directorUI directorUI = new directorUI();
                        directorUI.setVisible(true);
                        break;
                    }
                }
            }
            else {
                tipEroare = 2; //System.out.println("-parola incorecta-" + password + parola);}
            }

        }

        loginPage.frame.dispose();
        if(loginSuccess == 0) {
            //pagina de login apare pana se adauga un user si o parola corecta
            invalidLoginUI invalid = new invalidLoginUI(tipEroare);
            invalid.setVisible(true);
        }
    }


}
