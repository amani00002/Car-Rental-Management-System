<?php
session_start();

$servername = "localhost";
$username = "root";
$password = "root";
$dbname = "Car";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$update_result = "";

if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $rentalId = $_POST["rentalId"];
    $returnDate = $_POST["returnDate"];

    $sql = "UPDATE Rental SET eDate = ? WHERE rentalID = ?";

    if ($stmt = $conn->prepare($sql)) {
        $stmt->bind_param("si", $returnDate, $rentalId);

        if ($stmt->execute()) {
            $_SESSION['update_result'] = "Rental updated successfully.";
        } else {
            $_SESSION['update_result'] = "Error updating rental: " . $stmt->error;
        }

        $stmt->close();
    } else {
        $_SESSION['update_result'] = "Error preparing statement: " . $conn->error;
    }

    header("Location: {$_SERVER['REQUEST_URI']}");
    exit();
}

// Check if the update_result message is set in the session
if (isset($_SESSION['update_result'])) {
    $update_result = $_SESSION['update_result'];
    // Unset the session variable
    unset($_SESSION['update_result']);
}

$conn->close();




include 'update_rental.html';
?>
