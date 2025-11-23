<?php
// Include the database connection function from functions.php
include 'functions.php';

// Establish a PDO connection to the MySQL database
$pdo = pdo_connect_mysql();

// Define a variable to store the insert result message
$insert_result = '';

// Check if the form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve form data
    $locDate = $_POST['locDate'];
    $sDate = $_POST['sDate'];
    $eDate = $_POST['eDate'];
    $rentalType = $_POST['rentalType'];
    $immat = $_POST['immat'];
    $idClient = $_POST['idClient'];

    // Prepare the SQL statement to insert a new rental
    $stmt = $pdo->prepare('INSERT INTO rental (locDate, sDate, eDate, rentalType, immat, idClient) VALUES (?, ?, ?, ?, ?, ?)');

    // Execute the SQL statement
    if ($stmt->execute([$locDate, $sDate, $eDate, $rentalType, $immat, $idClient])) {
        // If the insert was successful, set the insert result message
        $insert_result = 'Rental inserted successfully!';
    } else {
        // If the insert failed, set an error message
        $insert_result = 'Error inserting rental: ' . $stmt->errorInfo()[2];
    }
}

// Include the HTML content from rental.html (or your form page)
include 'rental.html';

// Display the insert result message
if ($insert_result) {
    echo "<p>$insert_result</p>";
}
?>
