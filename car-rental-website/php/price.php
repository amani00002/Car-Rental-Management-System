<?php
// Include functions.php
include 'functions.php';

// Establish a PDO connection to the MySQL database
$pdo = pdo_connect_mysql();

// Define a variable to store the retrieved price
$price_result = '';

// Check if the form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve form data
    $immat = $_POST['immat'];

    // Prepare the SQL statement to retrieve the price by immat
    $stmt = $pdo->prepare('SELECT priceByDay FROM car WHERE immat = ?');

    // Execute the SQL statement
    if ($stmt->execute([$immat])) {
        // Fetch the price from the result set
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($row) {
            // If the immat exists, set the retrieved price
            $price_result = 'Price for Car with Immat ' . $immat . ' is: ' . $row['priceByDay'];
        } else {
            // If the immat does not exist, set a message
            $price_result = 'Car with Immat ' . $immat . ' not found!';
        }
    } else {
        // If there's an error executing the SQL statement, set an error message
        $price_result = 'Error retrieving price: ' . $stmt->errorInfo()[2];
    }
}

// Include the HTML content from retrieve-price.html
include 'price.html';
?>
