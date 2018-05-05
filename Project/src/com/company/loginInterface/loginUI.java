package com.company.loginInterface;

import com.company.userInterface.directorUI;
import com.company.userInterface.elevUI;
import com.company.userInterface.profesorUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.database.DataBaseLogin.conn;
import static com.company.database.DataBaseLogin.stmt;
import static javax.swing.LayoutStyle.ComponentPlacement.UNRELATED;

public class loginUI extends JFrame {

    private static loginUI loginPage;

    private JTextField usernameField;
    private JTextField passwordField;

    public static void callLoginUI() {
        EventQueue.invokeLater(() -> {
            loginPage = new loginUI();
            loginPage.setVisible(true);
        });
    }

    private loginUI() {
        JLabel usernameLabel = new JLabel("Username");
        JLabel passwordLabel = new JLabel("Password");

        usernameField = new JTextField(15);
        passwordField = new JTextField(15);
        JButton loginBtn = new JButton("Login");

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

        createLayout(usernameLabel, usernameField, passwordLabel, passwordField, loginBtn);
        setTitle("Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void testUsernamePassword(String username, String password) throws SQLException {
        //luam datele dupa username-ul introdus
        stmt = conn.createStatement();
        String sql = "SELECT parola, tip FROM login WHERE username = '" + username + "'";
        ResultSet rs = stmt.executeQuery(sql);
        String tip = "", parola = "";
        while(rs.next()){
            parola = rs.getString("parola");
            tip  = rs.getString("tip");
        }
        rs.close();

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
                        case "elev":
                            new elevUI();
                            break;
                        case "profesor":
                            new profesorUI();
                            break;
                        case "director":
                            new directorUI();
                            break;
                    }
            }
            else {
                tipEroare = 2; //System.out.println("-parola incorecta-" + password + parola);}
            }

        }

        loginPage.dispose();
        if(loginSuccess == 0) {
            //pagina de login apare pana se adauga un user si o parola corecta
            new invalidLoginUI(tipEroare);
        }
    }

    private void createLayout(Component... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createParallelGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1])
                        .addComponent(arg[2])
                        .addComponent(arg[3])
                        .addComponent(arg[4]))
                .addGap(50)
        );

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(50)
                .addGroup(gl.createSequentialGroup()
                        .addComponent(arg[0])
                        .addComponent(arg[1], GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(arg[2])
                        .addComponent(arg[3], GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(UNRELATED)
                        .addComponent(arg[4]))
                .addGap(50)
        );

        pack();
    }
}
