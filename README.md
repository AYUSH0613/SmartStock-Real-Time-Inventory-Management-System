# SmartStock - Real-Time Inventory Management System

## Project Overview
SmartStock is a console-based real-time inventory management system developed in Java. It uses MongoDB to persistently store product data, allowing users to add, restock, sell, and manage products efficiently. The application uses key data structures like HashMap and Stack to handle inventory operations and supports undo functionality for user actions.

## Features
- Add new products with unique IDs, names, and quantities  
- Restock existing products  
- Sell products with stock validation  
- Undo last operation (add, restock, sell)  
- Display current inventory  
- Persistent data storage using MongoDB  
- Console-based user interface for easy interaction  

## Technologies Used
- Java (JDK 11+)  
- MongoDB (Local or MongoDB Atlas)  
- MongoDB Java Driver (`mongodb-driver-sync`)  
- Maven for dependency management  

## Getting Started

### Prerequisites
- Java Development Kit (JDK 11 or higher)  
- MongoDB server running locally or a MongoDB Atlas cluster  
- Maven installed  

### Installation & Setup
1. Clone the repository:
   ```bash
   git clone https://github.com/AYUSH0613/SmartStock-Real-Time-Inventory-Management-System
