<?php
// Include functions.php
include 'functions.php';

// Establish a PDO connection to the MySQL database
$pdo = pdo_connect_mysql();

// Define a variable to store the update result message
$update_result = '';

// Check if the form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve form data
    $immat = $_POST['immat'];
    $priceByDay = $_POST['priceByDay'];

    // Prepare the SQL statement to update the car's price by day
    $stmt = $pdo->prepare('UPDATE car SET priceByDay = ? WHERE immat = ?');

    // Execute the SQL statement
    if ($stmt->execute([$priceByDay, $immat])) {
        // If the update was successful, set the update result message
        $update_result = 'Car price updated successfully!';
    } else {
        // If the update failed, set an error message
        $update_result = 'Error updating car price: ' . $stmt->errorInfo()[2];
    }
}

// Include the HTML content from update.html
include 'update.html';
?>
