package com.car.gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class CarRentalGUI extends JFrame {
    private JTextField brandField, modelField, priceField, immatField;
    private JTextField firstNameField, lastNameField, phoneField, streetField, cityField, jobField, clientIdField, rentalLocDateField;
    private JTextField rentalImmatField, rentalClientIdField, rentalTypeField, rentalStartDateField, rentalEndDateField;
    private JTextField saleImmatField, saleClientIdField, salePriceField, saleDateField;
    private JTextArea outputArea;

    private JButton updateLocationPriceButton, updateRentalButton;
    private JTextField updateLocationPriceImmatField, updateLocationPriceField;
    private JTextField updateRentalIDField, updateRentalReturnDateField;

    private JTextField searchBrandField, searchModelField;
    private JButton searchByBrandButton, searchByModelButton;

    private Connection connection;

    public CarRentalGUI() {
        // Set up the main window
        setTitle("Car Rental System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize components
        JTabbedPane tabbedPane = new JTabbedPane();

        // Add Car Panel
        JPanel addCarPanel = new JPanel(new GridLayout(5, 2));
        addCarPanel.add(new JLabel("Brand:"));
        brandField = new JTextField();
        addCarPanel.add(brandField);
        addCarPanel.add(new JLabel("Model:"));
        modelField = new JTextField();
        addCarPanel.add(modelField);
        addCarPanel.add(new JLabel("Price per day:"));
        priceField = new JTextField();
        addCarPanel.add(priceField);
        addCarPanel.add(new JLabel("Immat:"));
        immatField = new JTextField();
        addCarPanel.add(immatField);
        JButton addCarButton = new JButton("Add Car");
        addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCar();
            }
        });
        addCarPanel.add(addCarButton);

        // Add Customer Panel
        JPanel addCustomerPanel = new JPanel(new GridLayout(8, 2));
        addCustomerPanel.add(new JLabel("Client ID:"));
        clientIdField = new JTextField();
        addCustomerPanel.add(clientIdField);
        addCustomerPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        addCustomerPanel.add(firstNameField);
        addCustomerPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        addCustomerPanel.add(lastNameField);
        addCustomerPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        addCustomerPanel.add(phoneField);
        addCustomerPanel.add(new JLabel("Street:"));
        streetField = new JTextField();
        addCustomerPanel.add(streetField);
        addCustomerPanel.add(new JLabel("City:"));
        cityField = new JTextField();
        addCustomerPanel.add(cityField);
        addCustomerPanel.add(new JLabel("Job:"));
        jobField = new JTextField();
        addCustomerPanel.add(jobField);
        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });
        addCustomerPanel.add(addCustomerButton);

        // Rental Panel
        JPanel rentalPanel = new JPanel(new GridLayout(7, 2));
        rentalPanel.add(new JLabel("Rental Car Immat:"));
        rentalImmatField = new JTextField();
        rentalPanel.add(rentalImmatField);
        rentalPanel.add(new JLabel("Client ID:"));
        rentalClientIdField = new JTextField();
        rentalPanel.add(rentalClientIdField);
        rentalPanel.add(new JLabel("Rental Type:"));
        rentalTypeField = new JTextField();
        rentalPanel.add(rentalTypeField);
        rentalPanel.add(new JLabel("Start Date (YYYY-MM-DD):"));
        rentalStartDateField = new JTextField();
        rentalPanel.add(rentalStartDateField);
        rentalPanel.add(new JLabel("End Date (YYYY-MM-DD):"));
        rentalEndDateField = new JTextField();
        rentalPanel.add(rentalEndDateField);
        rentalPanel.add(new JLabel("Loc Date (YYYY-MM-DD):"));
        rentalLocDateField = new JTextField();
        rentalPanel.add(rentalLocDateField);
        JButton addRentalButton = new JButton("Add Rental");
        addRentalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRental();
            }
        });
        rentalPanel.add(addRentalButton);

        // Sale Panel
        JPanel salePanel = new JPanel(new GridLayout(5, 2));
        salePanel.add(new JLabel("Sale Car Immat:"));
        saleImmatField = new JTextField();
        salePanel.add(saleImmatField);
        salePanel.add(new JLabel("Client ID:"));
        saleClientIdField = new JTextField();
        salePanel.add(saleClientIdField);
        salePanel.add(new JLabel("Sale Price:"));
        salePriceField = new JTextField();
        salePanel.add(salePriceField);
        salePanel.add(new JLabel("Sale Date (YYYY-MM-DD):"));
        saleDateField = new JTextField();
        salePanel.add(saleDateField);
        JButton addSaleButton = new JButton("Add Sale");
        addSaleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSale();
            }
        });
        salePanel.add(addSaleButton);

        // Output Area
        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add panels to tabbed pane
        tabbedPane.addTab("Add Car", addCarPanel);
        tabbedPane.addTab("Add Customer", addCustomerPanel);
        tabbedPane.addTab("Add Rental", rentalPanel);
        tabbedPane.addTab("Add Sale", salePanel);

        // Update Panel
        JPanel updatePanel = new JPanel(new GridLayout(8, 2));
        updatePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        updatePanel.add(new JLabel("Update Location Price (Immat):"));
        updateLocationPriceImmatField = new JTextField();
        updatePanel.add(updateLocationPriceImmatField);
        updatePanel.add(new JLabel("New Price:"));
        updateLocationPriceField = new JTextField();
        updatePanel.add(updateLocationPriceField);
        updatePanel.add(new JLabel("Update Rental (ID):"));
        updateRentalIDField = new JTextField();
        updatePanel.add(updateRentalIDField);
        updatePanel.add(new JLabel("Return Date (YYYY-MM-DD):"));
        updateRentalReturnDateField = new JTextField();
        updatePanel.add(updateRentalReturnDateField);
        updateLocationPriceButton = new JButton("Update Location Price");
        updateLocationPriceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLocationPrice(updateLocationPriceImmatField.getText(), Float.parseFloat(updateLocationPriceField.getText()));
            }
        });
        updatePanel.add(updateLocationPriceButton);
        updateRentalButton = new JButton("Update Rental");
        updateRentalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRentalWithReturnDate(Integer.parseInt(updateRentalIDField.getText()), updateRentalReturnDateField.getText());
            }
        });
        updatePanel.add(updateRentalButton);
        tabbedPane.addTab("Update", updatePanel);

        // Search Panel
        JPanel searchPanel = new JPanel(new GridLayout(3, 2));
        searchPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        searchPanel.add(new JLabel("Search Cars by Brand:"));
        searchBrandField = new JTextField();
        searchPanel.add(searchBrandField);
       
        searchPanel.add(new JLabel("Search Cars by Model:"));
        searchModelField = new JTextField();
        searchPanel.add(searchModelField);
        searchByModelButton = new JButton("Search by Model"); 
        searchByBrandButton = new JButton("Search by Brand");
        searchPanel.add(searchByBrandButton);
        searchPanel.add(searchByModelButton);
        tabbedPane.addTab("Search", searchPanel);

        // Add components to main frame
        add(tabbedPane, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Establish database connection
        connectToDatabase();

        // Action Listeners for Search
        searchByBrandButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCarsByBrand(searchBrandField.getText());
            }
        });

        searchByModelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchCarsByModel(searchModelField.getText());
            }
        });
    }

    private void connectToDatabase() {
        try {
            String url = "jdbc:mysql://localhost:3306/car";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url, user, password);
            outputArea.append("Connected to database\n");
        } catch (SQLException e) {
            e.printStackTrace();
            outputArea.append("Failed to connect to database\n");
        }
    }

    private void searchCarsByBrand(String brand) {
        try {
            String query = "SELECT immat FROM car WHERE brand = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, brand);
            ResultSet resultSet = statement.executeQuery();
            outputArea.append("Cars with brand " + brand + ":\n");
            while (resultSet.next()) {
                String immat = resultSet.getString("immat");
                outputArea.append(immat + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            outputArea.append("Error searching for cars by brand\n");
        }
    }

    private void searchCarsByModel(String model) {
        try {
            String query = "SELECT immat FROM car WHERE model = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, model);
            ResultSet resultSet = statement.executeQuery();
            outputArea.append("Cars with model " + model + ":\n");
            while (resultSet.next()) {
                String immat = resultSet.getString("immat");
                outputArea.append(immat + "\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            outputArea.append("Error searching for cars by model\n");
        }
    }

    // Other methods for adding car, customer, rental, sale, updating location price and rental, etc.
    private void addCar() {
        String brand = brandField.getText();
        String model = modelField.getText();
        String price = priceField.getText();
        String immat = immatField.getText();

        try {
            String query = "INSERT INTO Car (immat, brand, model, priceByDay) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, immat);
            statement.setString(2, brand);
            statement.setString(3, model);
            statement.setFloat(4, Float.parseFloat(price));
            statement.executeUpdate();
            outputArea.append("Car added: " + brand + " " + model + "\n");
        } catch (SQLException e) {
            outputArea.append("Error adding car: " + e.getMessage() + "\n");
        }
    }


     private void addCustomer() {
        String idClient = clientIdField.getText();
        String fName = firstNameField.getText();
        String lName = lastNameField.getText();
        String phone = phoneField.getText();
        String street = streetField.getText();
        String city = cityField.getText();
        String job = jobField.getText();

        try {
            String query = "INSERT INTO Client (idClient, fName, lName, phone, street, city, job) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idClient);
            statement.setString(2, fName);
            statement.setString(3, lName);
            statement.setString(4, phone);
            statement.setString(5, street);
            statement.setString(6, city);
            statement.setString(7, job);
            statement.executeUpdate();
            outputArea.append("Customer added: " + fName + " " + lName + "\n");
        } catch (SQLException e) {
            outputArea.append("Error adding customer: " + e.getMessage() + "\n");
        }
    }

   private void addRental() {
    String immat = rentalImmatField.getText();
    String idClient = rentalClientIdField.getText();
    String rentalType = rentalTypeField.getText();
    String sDate = rentalStartDateField.getText();
    String eDate = rentalEndDateField.getText();
    String locDate = rentalLocDateField.getText();
    
    try {
        // Prepare SQL query
        String query = "INSERT INTO Rental (locDate, sDate, eDate, rentalType, immat, idClient) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, locDate);
        statement.setString(2, sDate);
        statement.setString(3, eDate);
        statement.setString(4, rentalType);
        statement.setString(5, immat);
        statement.setString(6, idClient);
        
        // Execute SQL query
        int rowsInserted = statement.executeUpdate();
        
        if (rowsInserted > 0) {
            outputArea.append("Rental added for car: " + immat + " and client: " + idClient + "\n");
        } else {
            outputArea.append("Failed to add rental.\n");
        }
    } catch (SQLException e) {
        outputArea.append("Error adding rental: " + e.getMessage() + "\n");
    }
}


    private void addSale() {
        String immat = saleImmatField.getText();
        String idClient = saleClientIdField.getText();
        float salePrice = Float.parseFloat(salePriceField.getText());
        String saleDate = saleDateField.getText();

        try {
            String query = "INSERT INTO Sale (immat, idClient, salePrice, saleDate) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, immat);
            statement.setString(2, idClient);
            statement.setFloat(3, salePrice);
            statement.setString(4, saleDate);
            statement.executeUpdate();
            outputArea.append("Sale added for car: " + immat + " and client: " + idClient + "\n");
        } catch (SQLException e) {
            outputArea.append("Error adding sale: " + e.getMessage() + "\n");
        }
    }


   private void updateLocationPrice(String immat, float newPriceByDay) {
        try {
            String query = "UPDATE Car SET priceByDay = ? WHERE immat = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setFloat(1, newPriceByDay);
            statement.setString(2, immat);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                outputArea.append("Location price updated for car: " + immat + "\n");
            } else {
                outputArea.append("Car not found with registration number: " + immat + "\n");
            }
        } catch (SQLException e) {
            outputArea.append("Error updating location price: " + e.getMessage() + "\n");
        }
    }
    
     
   private void updateRentalWithReturnDate(int rentalID, String eDate) {
    try {
        String query = "UPDATE Rental SET eDate = ? WHERE rentalID = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, eDate);
        statement.setInt(2, rentalID);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            outputArea.append("Return date updated for rental ID: " + rentalID + "\n");
        } else {
            outputArea.append("Rental not found with ID: " + rentalID + "\n");
        }
    } catch (SQLException e) {
        outputArea.append("Error updating rental: " + e.getMessage() + "\n");
    }
}


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CarRentalGUI().setVisible(true);
            }
        });
    }
}
