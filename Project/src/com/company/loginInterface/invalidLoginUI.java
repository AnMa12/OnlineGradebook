package com.company.loginInterface;

import javax.swing.*;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.company.loginInterface.loginUI.callLoginUI;

public class invalidLoginUI extends JFrame {

    public invalidLoginUI(int tipEroare) {

        JButton tryAgainButton = null;
        if(tipEroare == 2) {
            tryAgainButton = new JButton("Parola invalida - Incearca iar");
        } else {
            tryAgainButton = new JButton("Username invalid - Incearca iar");
        }

        createLayout(tryAgainButton);

        setVisible(true);
        setTitle("JButtons");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                callLoginUI();
            }
        });
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);

        gl.setAutoCreateContainerGaps(true);
        gl.setAutoCreateGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        );

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
        );

        gl.linkSize(arg[0]);

        pack();
    }
}
