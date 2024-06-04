package main.gui;
import main.src.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    public MainWindow(){
        JFrame frame;
        JButton buttonC, buttonR, buttonL;
        JPanel panelC, panelR;
        Color LightBlue;

        frame = new JFrame("Restaurant App");
        buttonC = new JButton("Create Restaurant");
        buttonR = new JButton("Make Reservation");
        buttonL = new JButton("List Reservations");
        panelR = new JPanel();
        panelC = new JPanel();

        LightBlue = new Color(0, 0, 128);

//        frame.getContentPane().setBackground(Color.black);
        panelC.setBackground(LightBlue);
        panelR.setBackground(LightBlue);
        panelC.setLayout(new GridLayout(2,2));
        panelR.setLayout(new GridLayout(2,2));

        buttonC.setBounds(50, 200, 200, 50);
        buttonR.setBounds(300, 200, 200, 50);
        buttonL.setBounds(550, 200, 200, 50);

        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createRestaurant();
            }
        });

        frame.add(buttonC);
        frame.add(buttonR);
        frame.add(buttonL);

        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void createRestaurant(){
        JFrame frame;
        JComboBox<String> categories;
        JLabel labelT, labelN, labelL, labelC;

        String[] arr = { "Economy, Luxury, Executive" };
        categories = new JComboBox<>(arr);
        frame = new JFrame("Restaurant Creation");
        labelT = new JLabel("Restaurant type: ");
        labelN = new JLabel("Restaurant name: ");
        labelL = new JLabel("Restaurant location: ");
        labelC = new JLabel("Restaurant capacity: ");


        categories.setSelectedIndex(0);
        categories.setBounds(160, 50, 150, 30);
        labelT.setBounds(50, 50, 100, 30);


//        categories.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                switch (categories.getSelectedIndex()){
//                    case 0:
//
//                }
//            }
//        });

        labelN.setBounds(50, 100, 100, 30);
        labelL.setBounds(50, 150, 100, 30);
        labelC.setBounds(50, 200, 100, 30);

        frame.add(categories);
        frame.add(labelT);
        frame.add(labelN);
        frame.add(labelL);
        frame.add(labelC);

        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
