package com.company;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Java BorderLayout - utilizat pentru a aranja componentele in 5 regiuni:
 * nord, sud, est, vest si centru
 * Fiecare regiune poate contine numai o componenta
 * Ofera 5 constante pentru fiecare regiune definite astfel:
 * public static final int NORTH;
 * public static final int SOUTH; etc
 */

class GridL {
    JFrame f;
    GridL() {
        f = new JFrame();
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        f.add(btn1);
        f.add(btn2);
        f.add(btn3);
        f.add(btn4);
        f.add(btn5);
        f.add(btn6);
        f.setLayout(new GridLayout(2, 3));
        // Setam dispose on close pentru a inchide aplicatia la inchiderea frame-ului
        // daca nu setam setDefaultCloseOperaton acesta va avea default HIDE_ON_CLOSE
        // care va ascunde fereastra dar va lasa aplicatia sa ruleze in continuare in fundal
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setSize(300, 300);
        f.setVisible(true);
    }
}

/**
 * Java BoxLayout este folosit pentru a aranja componetele vertical sau
 orizontal
 * este gasit in pachetul javax.swing
 */
class BoxL {
    Button buttons[];
    JFrame f;

    BoxL() {
        f = new JFrame();
        buttons = new Button [5];
        for (int i = 0; i < 5; i++) {
            buttons[i] = new Button ("Button " + (i + 1));
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new GridL();
                    f.dispose();
                }
            });
            f.add(buttons[i]);
        }
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLayout (new BoxLayout(f.getContentPane(), BoxLayout.X_AXIS));
        f.setSize(400,400);
        f.setVisible(true);
    }
}

public class Main{
    public static void main (String[] args){
        /**
         * Se ruleaza clasele pe rand
         */


        new BoxL();


    }
}