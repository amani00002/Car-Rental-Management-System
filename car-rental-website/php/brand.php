<?php
// Include functions.php
include 'functions.php';

// Establish a PDO connection to the MySQL database
$pdo = pdo_connect_mysql();

// Define variables to store the retrieved immat and price
$immat_result = '';
$price_result = '';

// Check if the form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve form data
    $brand = $_POST['brand'];
    $model = $_POST['model'];

    // Prepare the SQL statement to retrieve the immat and price by brand and model
    $stmt = $pdo->prepare('SELECT immat, priceByDay FROM car WHERE brand = ? AND model = ?');

    // Execute the SQL statement
    if ($stmt->execute([$brand, $model])) {
        // Fetch the immat and price from the result set
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        if ($row) {
            // If the brand and model exist, set the retrieved immat and price
            $immat_result = 'Immat for Car with Brand ' . $brand . ' and Model ' . $model . ': ' . $row['immat'];
            $price_result = 'Price for Car with Brand ' . $brand . ' and Model ' . $model . ': ' . $row['priceByDay'];
        } else {
            // If the brand and model do not exist, set a message
            $immat_result = 'Car with Brand ' . $brand . ' and Model ' . $model . ' not found!';
            $price_result = '';
        }
    } else {
        // If there's an error executing the SQL statement, set an error message
        $immat_result = 'Error retrieving data: ' . $stmt->errorInfo()[2];
        $price_result = '';
    }
}

// Include the HTML content from find-car.html
include 'model.html';
?>
