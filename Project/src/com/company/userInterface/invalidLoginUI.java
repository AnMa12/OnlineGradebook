package com.company.userInterface;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import static com.company.userInterface.loginUI.callLoginUI;

public class invalidLoginUI extends JFrame {

    public invalidLoginUI() {
        String messege = "Username sau parola invalida";

        JLabel label = new JLabel(messege);
        JButton tryAgainButton = new JButton("Incearca iar");

        createLayout(label, tryAgainButton);

        setVisible(true);
        setTitle("Invalid Login");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                callLoginUI();
            }
        });
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        pack();
    }
}
