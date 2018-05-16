package connect;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import javax.swing.JList;
import com.toedter.calendar.JCalendar;


import javax.swing.JComboBox;

public class AdaugareNoteUI extends JFrame{

    private static AdaugareNoteUI adaugareNoteUI;
    private static JFrame frame;
    private static JTextField textField;
    private static JTextField textField_1;
    private static JTextField textField_3;

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
    /**
     * Create the application.
     */
    public  AdaugareNoteUI(int id) throws SQLException, NullPointerException, Exception{
        initialize(id);
    }


    private void initialize(int id) {
        frame = new JFrame();
        frame.setBounds(100, 100, 431, 244);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(255, 250, 205));
        panel.setForeground(new Color(255, 228, 196));
        panel.setBounds(0, 0, 420, 210);
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

        JButton btnElevi = new JButton("Elevi");
        btnElevi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {
            }
        });
        btnElevi.setBounds(30, 11, 89, 23);
        panel.add(btnElevi);

        textField = new JTextField();
        textField.setBounds(99, 45, 86, 20);
        panel.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(99, 81, 86, 20);
        panel.add(textField_1);
        textField_1.setColumns(10);

        textField_3 = new JTextField();
        textField_3.setBounds(99, 162, 86, 20);
        panel.add(textField_3);
        textField_3.setColumns(10);

        JCalendar calendar = new JCalendar();
        calendar.setBounds(209, 26, 198, 153);
        panel.add(calendar);

        JComboBox comboBox = new JComboBox();
        comboBox.setBounds(99, 120, 86, 22);
        comboBox.addItem("plmmm");
        comboBox.setSelectedItem(null);
        panel.add(comboBox);
    }
}


