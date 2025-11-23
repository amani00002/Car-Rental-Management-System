# 🚗 Car Rental Management System  

Un projet complet de gestion de location automobile combinant **une application web (HTML/CSS + PHP)** et **une application desktop Java (Swing)**.

---

## 🌐 1. Application Web (HTML/CSS + PHP)

Le dossier **`car-rental-website`** contient un site web permettant de gérer les opérations d’une agence de location de voitures.

### ✔️ Fonctionnalités principales

#### 👥 Gestion des clients
- Ajout, modification et affichage des clients  
  *(client.html, client.php)*

#### 🚘 Gestion des modèles et marques de voitures
- Consultation et mise à jour des informations des véhicules  
  *(model.html, brand.php)*

#### 💰 Gestion des prix et des locations
- Consultation et modification des tarifs *(price.html, price.php)*  
- Enregistrement d’une nouvelle location *(rental.html, rentalinsert.php)*  
- Mise à jour d’une location existante *(update_rental.html, updaterental.php)*  

---

### 🛠️ Backend (PHP)
- Backend développé en **PHP**
- Connexion à la base via **PDO** *(pdo.php)*
- Opérations **CRUD** réparties dans plusieurs scripts  
  *(insert.php, update.php, delete.php, etc.)*

### 🎨 Frontend (HTML/CSS)
- Interface simple et fonctionnelle  
- Pages dédiées : home, about, models, rental…  
- Fichiers CSS + images intégrés *(home.css, img1.png, etc.)*

---

## 💻 2. Application Desktop Java (Java Swing GUI)

Dans le dossier **`java-app-rental`**, on trouve l’application Java Swing.

### 🎯 Fichier principal
- **CarRentalGUI.java**

### ✔️ Fonctionnalités
Interface graphique permettant de :
- gérer les voitures  
- gérer les clients  
- gérer les locations  
- mettre à jour les données  

Cette application peut servir :
- d’outil interne pour les employés de l’agence  
- ou de complément à l’application web

---

## 🧩 Objectif du projet

Ce projet démontre un système complet de gestion de location de voitures incluant :

- 🌐 **Une interface web** pour l’utilisation en ligne  
- 💻 **Une application desktop Java** pour la gestion interne  
- 🗄️ **Un backend PHP commun** pour la manipulation des données  

C’est un excellent projet pour pratiquer :

- Développement web (**HTML/CSS**)  
- Programmation serveur (**PHP + PDO**)  
- Développement desktop (**Java Swing**)  
- Conception de systèmes **CRUD** complets  

---
