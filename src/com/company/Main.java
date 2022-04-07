package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

        JFrame frame = new JFrame();
        frame.setContentPane(new NewGUI().getJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setBounds(400,250,430,200);
        frame.setVisible(true);
    }
}
