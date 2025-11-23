<?php
// Function to establish a PDO connection to the MySQL database
function pdo_connect_mysql() {
    $servername = "localhost";
    $username = "root";
    $password = "root";
    $dbname = "car";

    try {
        $pdo = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
        // Set the PDO error mode to exception
        $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
        return $pdo;
    } catch (PDOException $e) {
        // If connection fails, throw an exception
        throw new PDOException($e->getMessage());
    }
}

// Function to include header HTML template
function template_header($title) {
    echo '<!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>' . $title . '</title>
        <link rel="stylesheet" href="styles.css">
        <!-- Include any other meta tags, CSS files, or JavaScript files here -->
    </head>
    <body>';
}

// Function to include footer HTML template
function template_footer() {
    echo '</body>
    </html>';
}
?>
