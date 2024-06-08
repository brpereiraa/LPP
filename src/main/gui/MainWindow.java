package main.gui;
import main.src.*;

import javax.swing.*;
import java.time.format.DateTimeParseException;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;

public class MainWindow extends JFrame {
    static ArrayList<Restaurant> restaurants = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();

    public MainWindow(){
        JFrame frame;
        JButton buttonC, buttonR, buttonL, buttonLR;
        JPanel panelC, panelR;
        Color LightBlue;

        restaurants.add(new RestaurantEco("RestaurantA", "Porto", 500, true));
        restaurants.add(new RestaurantLux("RestaurantB", "Porto", 500, true, false));

        reservations.add(new Reservation(LocalDate.now().plusDays(1), LocalTime.of(12, 0), 4, Reservation.StatusReservation.ACTIVE, restaurants.get(1)));
        reservations.add(new Reservation(LocalDate.now().plusDays(2), LocalTime.of(18, 30), 2, Reservation.StatusReservation.CANCELED , restaurants.get(0)));

        frame = new JFrame("Restaurant App");
        buttonC = new JButton("Create Restaurant");
        buttonR = new JButton("Make Reservation");
        buttonL = new JButton("List Reservations");
        buttonLR = new JButton("List restaurants");
        panelR = new JPanel();
        panelC = new JPanel();

        LightBlue = new Color(0, 0, 128);

//        frame.getContentPane().setBackground(Color.black);
        panelC.setBackground(LightBlue);
        panelR.setBackground(LightBlue);
        panelC.setLayout(new GridLayout(2,2));
        panelR.setLayout(new GridLayout(2,2));

        buttonC.setBounds(150, 200, 200, 50);
        buttonR.setBounds(400, 200, 200, 50);
        buttonL.setBounds(150, 260, 200, 50);
        buttonLR.setBounds(400, 260, 200, 50);

        buttonC.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { createRestaurant(); }
        });

        buttonLR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { listRestaurant(); }
        });

        buttonL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { listReservations(); }
        });

        buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { createReservation(); }
        });

        frame.add(buttonC);
        frame.add(buttonR);
        frame.add(buttonL);
        frame.add(buttonLR);

        frame.setSize(800, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void createRestaurant(){
        JFrame frame = new JFrame("Restaurant Creation");
        frame.setSize(600, 600);
        frame.setLayout(null);

        JLabel labelT = new JLabel("Restaurant type: ");
        String[] arr = {"Economy", "Luxury", "Executive"};
        JComboBox<String> categories = new JComboBox<>(arr);
        categories.setSelectedIndex(0);
        categories.setBounds(160, 50, 150, 30);
        labelT.setBounds(50, 50, 100, 30);

        JLabel labelN = new JLabel("Restaurant name: ");
        JTextField textN = new JTextField();
        labelN.setBounds(50, 100, 150, 30);
        textN.setBounds(200, 100, 150, 30);

        JLabel labelL = new JLabel("Restaurant location: ");
        JTextField textL = new JTextField();
        labelL.setBounds(50, 150, 150, 30);
        textL.setBounds(200, 150, 150, 30);

        JLabel labelC = new JLabel("Restaurant capacity: ");
        JTextField textC = new JTextField();
        labelC.setBounds(50, 200, 150, 30);
        textC.setBounds(200, 200, 150, 30);

        // Additional fields for subclass attributes
        JLabel labelWifi = new JLabel("WiFi: ");
        JCheckBox checkWifi = new JCheckBox();
        labelWifi.setBounds(50, 250, 150, 30);
        checkWifi.setBounds(200, 250, 150, 30);
        labelWifi.setVisible(true);
        checkWifi.setVisible(true);

        JLabel labelValet = new JLabel("Valet: ");
        JCheckBox checkValet = new JCheckBox();
        JLabel labelTastingMenu = new JLabel("Tasting Menu: ");
        JCheckBox checkTastingMenu = new JCheckBox();
        labelValet.setBounds(50, 250, 150, 30);
        checkValet.setBounds(200, 250, 150, 30);
        labelTastingMenu.setBounds(50, 300, 150, 30);
        checkTastingMenu.setBounds(200, 300, 150, 30);
        labelValet.setVisible(false);
        checkValet.setVisible(false);
        labelTastingMenu.setVisible(false);
        checkTastingMenu.setVisible(false);

        JLabel labelPrivateRoom = new JLabel("Private Room: ");
        JCheckBox checkPrivateRoom = new JCheckBox();
        JLabel labelGourmetMenu = new JLabel("Gourmet Menu: ");
        JCheckBox checkGourmetMenu = new JCheckBox();
        labelPrivateRoom.setBounds(50, 250, 150, 30);
        checkPrivateRoom.setBounds(200, 250, 150, 30);
        labelGourmetMenu.setBounds(50, 300, 150, 30);
        checkGourmetMenu.setBounds(200, 300, 150, 30);
        labelPrivateRoom.setVisible(false);
        checkPrivateRoom.setVisible(false);
        labelGourmetMenu.setVisible(false);
        checkGourmetMenu.setVisible(false);

        JButton addButton = new JButton("Add Restaurant");
        addButton.setBounds(200, 350, 150, 30);

        categories.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedType = (String) categories.getSelectedItem();
                // Hide all subclass-specific fields
                labelWifi.setVisible(false);
                checkWifi.setVisible(false);
                labelValet.setVisible(false);
                checkValet.setVisible(false);
                labelTastingMenu.setVisible(false);
                checkTastingMenu.setVisible(false);
                labelPrivateRoom.setVisible(false);
                checkPrivateRoom.setVisible(false);
                labelGourmetMenu.setVisible(false);
                checkGourmetMenu.setVisible(false);

                // Show fields based on selected type
                if (selectedType.equals("Economy")) {
                    labelWifi.setVisible(true);
                    checkWifi.setVisible(true);
                } else if (selectedType.equals("Luxury")) {
                    labelValet.setVisible(true);
                    checkValet.setVisible(true);
                    labelTastingMenu.setVisible(true);
                    checkTastingMenu.setVisible(true);
                } else if (selectedType.equals("Executive")) {
                    labelPrivateRoom.setVisible(true);
                    checkPrivateRoom.setVisible(true);
                    labelGourmetMenu.setVisible(true);
                    checkGourmetMenu.setVisible(true);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = textN.getText();
                    String location = textL.getText();
                    int capacity = Integer.parseInt(textC.getText());
                    String type = (String) categories.getSelectedItem();

                    if (name.isEmpty() || location.isEmpty() || capacity <= 0) {
                        throw new IllegalArgumentException("Please fill all fields correctly.");
                    }

                    Restaurant restaurant;
                    if (type.equals("Economy")) {
                        boolean wifi = checkWifi.isSelected();
                        restaurant = new RestaurantEco(name, location, capacity, wifi);
                    } else if (type.equals("Luxury")) {
                        boolean valet = checkValet.isSelected();
                        boolean tastingMenu = checkTastingMenu.isSelected();
                        restaurant = new RestaurantLux(name, location, capacity, valet, tastingMenu);
                    } else if (type.equals("Executive")) {
                        boolean privateRoom = checkPrivateRoom.isSelected();
                        boolean gourmetMenu = checkGourmetMenu.isSelected();
                        restaurant = new RestaurantExec(name, location, capacity, privateRoom, gourmetMenu);
                    } else {
                        throw new IllegalArgumentException("Invalid restaurant type selected.");
                    }

                    restaurants.add(restaurant);
                    JOptionPane.showMessageDialog(frame, "Restaurant added successfully!");

                    // Clear the input fields
                    textN.setText("");
                    textL.setText("");
                    textC.setText("");
                    checkWifi.setSelected(false);
                    checkValet.setSelected(false);
                    checkTastingMenu.setSelected(false);
                    checkPrivateRoom.setSelected(false);
                    checkGourmetMenu.setSelected(false);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for capacity.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        frame.add(categories);
        frame.add(labelT);
        frame.add(labelN);
        frame.add(labelL);
        frame.add(labelC);
        frame.add(textN);
        frame.add(textL);
        frame.add(textC);
        frame.add(labelWifi);
        frame.add(checkWifi);
        frame.add(labelValet);
        frame.add(checkValet);
        frame.add(labelTastingMenu);
        frame.add(checkTastingMenu);
        frame.add(labelPrivateRoom);
        frame.add(checkPrivateRoom);
        frame.add(labelGourmetMenu);
        frame.add(checkGourmetMenu);
        frame.add(addButton);

        frame.setVisible(true);
    }

    public void listRestaurant(){
        JFrame frame;
        DefaultTableModel model;
        JTable table;

        String[] columnNames = {
                "Name", "Location", "Capacity", "Type",
                "WiFi", "Valet", "Tasting Menu", "Private Room", "Gourmet Menu"
        };
        frame = new JFrame("Restaurant List");
        model = new DefaultTableModel(columnNames, 0);

        for (Restaurant restaurant : restaurants) {
            Object[] row = new Object[9]; // Initialize with 9 columns
            row[0] = restaurant.getName();
            row[1] = restaurant.getLocation();
            row[2] = restaurant.getCapacity();

            if (restaurant instanceof RestaurantEco) {
                row[3] = "Economy";
                row[4] = ((RestaurantEco) restaurant).getWifi();
                row[5] = null;
                row[6] = null;
                row[7] = null;
                row[8] = null;
            } else if (restaurant instanceof RestaurantLux) {
                row[3] = "Luxury";
                row[4] = null;
                row[5] = ((RestaurantLux) restaurant).getValet();
                row[6] = ((RestaurantLux) restaurant).getMenu();
                row[7] = null;
                row[8] = null;
            } else if (restaurant instanceof RestaurantExec) {
                row[3] = "Executive";
                row[4] = null;
                row[5] = null;
                row[6] = null;
                row[7] = ((RestaurantExec) restaurant).getRoom();
                row[8] = ((RestaurantExec) restaurant).getMenu();
            }
            model.addRow(row);
        }

        frame.setLayout(new BorderLayout(10, 10));

        table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton deleteButton = new JButton("Delete Restaurant");
        buttonPanel.add(deleteButton);

        // Add action listener for delete button
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) table.getValueAt(selectedRow, 0);
                    Iterator<Restaurant> restaurantIterator = restaurants.iterator();
                    while (restaurantIterator.hasNext()) {
                        Restaurant restaurant = restaurantIterator.next();
                        if (restaurant.getName().equals(name)) {
                            restaurantIterator.remove();

                            Iterator<Reservation> reservationIterator = reservations.iterator();
                            while (reservationIterator.hasNext()) {
                                Reservation reservation = reservationIterator.next();
                                if (reservation.getRestaurant().equals(restaurant)) {
                                    reservationIterator.remove();
                                }
                            }
                            break;
                        }
                    }
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a restaurant to delete.");
                }
            }
        });

        frame.add(tablePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void listReservations(){
        JFrame frame = new JFrame("Reserva List");
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout(10, 10));

        String[] columnNames = {"Schedule", "Hour", "Number of people", "Status", "Restaurant"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (Reservation reservation : reservations) {
            Object[] row = {reservation.getData(), reservation.getHora(), reservation.getNumPeople(), reservation.getStatus(), reservation.getRestaurant().getName()};
            model.addRow(row);
        }

        JTable table = new JTable(model);
        table.setPreferredScrollableViewportSize(new Dimension(500, 200));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel tablePanel = new JPanel();
        tablePanel.setLayout(new BorderLayout());
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        tablePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton removeButton = new JButton("Remove");
        buttonPanel.add(removeButton);

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    reservations.remove(selectedRow);
                    model.removeRow(selectedRow);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please select a reservation to remove.");
                }
            }
        });

        frame.add(tablePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public void createReservation(){
        JFrame frame;
        JComboBox<String> statusComboBox;
        JComboBox<Restaurant> restaurantComboBox;
        JLabel labelD, labelT, labelN, labelS, labelR;
        JTextField textD, textT, textN;
        JButton addButton;

        String[] statusArr = {"ACTIVE", "CANCELED", "FINISHED"};
        statusComboBox = new JComboBox<>(statusArr);
        restaurantComboBox = new JComboBox<>(restaurants.toArray(new Restaurant[0]));

        frame = new JFrame("Reservation Creation");
        labelD = new JLabel("Date (yyyy-mm-dd): ");
        labelT = new JLabel("Time (HH:mm): ");
        labelN = new JLabel("Number of people: ");
        labelS = new JLabel("Status: ");
        labelR = new JLabel("Restaurant: ");
        textD = new JTextField();
        textT = new JTextField();
        textN = new JTextField();
        addButton = new JButton("Add Reservation");

        statusComboBox.setSelectedIndex(0);
        statusComboBox.setBounds(160, 150, 150, 30);
        labelS.setBounds(50, 150, 100, 30);

        restaurantComboBox.setSelectedIndex(0);
        restaurantComboBox.setBounds(160, 200, 150, 30);
        labelR.setBounds(50, 200, 100, 30);

        labelD.setBounds(50, 50, 150, 30);
        textD.setBounds(200, 50, 150, 30);

        labelT.setBounds(50, 100, 150, 30);
        textT.setBounds(200, 100, 150, 30);

        labelN.setBounds(50, 250, 150, 30);
        textN.setBounds(200, 250, 150, 30);

        addButton.setBounds(200, 300, 150, 30);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    LocalDate date = LocalDate.parse(textD.getText());
                    LocalTime time = LocalTime.parse(textT.getText());
                    int numberOfPeople = Integer.parseInt(textN.getText());
                    Reservation.StatusReservation status = Reservation.StatusReservation.valueOf((String) statusComboBox.getSelectedItem());
                    Restaurant selectedRestaurant = (Restaurant) restaurantComboBox.getSelectedItem();

                    Reservation reservation = new Reservation(date, time, numberOfPeople, status, selectedRestaurant);
                    reservations.add(reservation);
                    JOptionPane.showMessageDialog(frame, "Reservation added successfully!");

                    textD.setText("");
                    textT.setText("");
                    textN.setText("");
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid date and time.");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Please enter a valid number for number of people.");
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage());
                }
            }
        });

        frame.add(statusComboBox);
        frame.add(labelS);
        frame.add(labelD);
        frame.add(labelT);
        frame.add(labelN);
        frame.add(labelR);
        frame.add(textD);
        frame.add(textT);
        frame.add(textN);
        frame.add(restaurantComboBox);
        frame.add(addButton);

        frame.setSize(600, 400);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
