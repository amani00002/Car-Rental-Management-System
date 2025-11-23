<?php
// Include functions.php
include 'functions.php';

// Establish a PDO connection to the MySQL database
$pdo = pdo_connect_mysql();

// Define a variable to store the insert result message
$insert_result = '';

// Check if the form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve form data
    $idClient = $_POST['idClient'];
    $fName = $_POST['fName'];
    $lName = $_POST['lName'];
    $phone = $_POST['phone'];
    $street = $_POST['street'];
    $city = $_POST['city'];
    $job = $_POST['job'];

    // Prepare the SQL statement to insert a new client
    $stmt = $pdo->prepare('INSERT INTO Client (idClient, fName, lName, phone, street, city, job) VALUES (?, ?, ?, ?, ?, ?, ?)');

    // Execute the SQL statement
    if ($stmt->execute([$idClient, $fName, $lName, $phone, $street, $city, $job])) {
        // If the insert was successful, set the insert result message
        $insert_result = 'Client inserted successfully!';
    } else {
        // If the insert failed, set an error message
        $insert_result = 'Error inserting client: ' . $stmt->errorInfo()[2];
    }
}

// Include the HTML content from client.html
include 'client.html';
?>
