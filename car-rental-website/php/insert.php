<?php
// Start session
session_start();

// Include functions.php
include 'functions.php';

// Establish a PDO connection to the MySQL database
$pdo = pdo_connect_mysql();

// Define a variable to store the insert result message
$insert_result = '';

// Check if the form is submitted
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // Retrieve form data
    $immat = $_POST['immat'];
    $brand = $_POST['brand'];
    $model = $_POST['model'];
    $price = $_POST['price'];

    // Prepare the SQL statement to insert a new car
    $stmt = $pdo->prepare('INSERT INTO car (immat, brand, model, priceByDay) VALUES (?, ?, ?, ?)');

    // Execute the SQL statement
    if ($stmt->execute([$immat, $brand, $model, $price])) {
        // If the insert was successful, set the insert result message
        $_SESSION['insert_result'] = 'Car inserted successfully!';
    } else {
        // If the insert failed, set an error message
        $_SESSION['insert_result'] = 'Error inserting car: ' . $stmt->errorInfo()[2];
    }

    // Redirect to the same page to clear form data and prevent form resubmission
    header("Location: {$_SERVER['PHP_SELF']}");
    exit();
}

// Check if the insert_result message is set in the session
if (isset($_SESSION['insert_result'])) {
    $insert_result = $_SESSION['insert_result'];
    // Unset the session variable
    unset($_SESSION['insert_result']);
}

// Include the HTML content from insert.html
include 'insert.html';
?>
