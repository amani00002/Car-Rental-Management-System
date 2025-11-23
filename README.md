🚗 1. Application Web (HTML/CSS + PHP)

Le dossier car-rental-website contient un site web permettant de gérer les opérations d'une agence de location de voitures.

Fonctionnalités principales :

Gestion des clients

Ajout, modification et affichage des clients (client.html, client.php).

Gestion des modèles et marques de voitures

Pages pour consulter et modifier les informations des véhicules (model.html, brand.php).

Gestion des prix et locations

Consultation et mise à jour des tarifs (price.html, price.php)

Enregistrement d’une nouvelle location (rental.html, rentalinsert.php)

Modification d’une location (update_rental.html, updaterental.php)

Backend :

Le backend est en PHP.

La base de données est gérée via PDO (pdo.php).

Les opérations CRUD (Create, Read, Update, Delete) sont réparties dans plusieurs scripts (insert.php, update.php, etc.).

Frontend :

Interface HTML/CSS simple et fonctionnelle.

Plusieurs pages dédiées (home, about, models, rental, etc.).

Fichiers CSS et images inclus (home.css, img1.png, etc.).

💻 2. Application Java (Java Swing GUI)

Dans java-app-rental, on trouve un fichier principal :

CarRentalGUI.java

Fonctionnalités incluses :

Une interface Swing permettant de :

gérer les voitures,

gérer les clients,

gérer les locations,

mettre à jour les données.

Cette interface sert soit :

d’application complémentaire au site web,

soit d’outil local pour un employé de l’agence.

🧩 Objectif du projet

Ce projet vise à montrer un système complet de gestion de location automobile, combinant :

une interface web pour l’utilisation en ligne,

une application desktop Java pour la gestion interne,

un backend PHP commun pour la manipulation des données.

C’est un projet idéal pour pratiquer :

développement web (HTML/CSS),

programmation serveur (PHP + PDO),

création d’interfaces desktop (Java Swing),

logique métier autour d’un système CRUD complet.
