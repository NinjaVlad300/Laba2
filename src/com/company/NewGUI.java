package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGUI {

    private JButton чтениеButton;
    private JButton записьButton;
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panel;

    public NewGUI() {
        Calculater calc = new Calculater();
        Reader r = new Reader();
        Writer wr = new Writer();



        чтениеButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calc.calculater(r.Reading(textField1.getText()));
                    JOptionPane.showMessageDialog(null, "Файл загружен", "Import", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Файл не найден", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

        записьButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    wr.Writing(calc, textField2.getText());
                    JOptionPane.showMessageDialog(null, "Файл сохранен", "Export", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка в пути файла", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });

    }

    public JPanel getJPanel(){
        return  panel;
    }

}

