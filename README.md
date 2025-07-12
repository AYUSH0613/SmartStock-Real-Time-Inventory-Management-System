# SmartStock - Real-Time Inventory Management System

SmartStock is a console-based real-time inventory management system developed in Java. It allows users to manage products by adding, restocking, and selling inventory while ensuring data persistence with MongoDB. Key data structures like `HashMap` and `Stack` are used to manage product data and support undo functionality. The system is designed for real-time interaction and data integrity through a menu-driven interface.

---

## 🚀 Features

- ➕ Add new products with unique IDs, names, and quantities  
- 🔁 Restock existing products  
- 🛒 Sell products with quantity validation  
- ↩️ Undo last operation (add, restock, or sell)  
- 📦 Display current inventory  
- 💾 Persistent data storage using MongoDB  
- 💻 Console-based user interface for easy interaction  

---

## 🧪 Example Usage

When you run the application, you will see a menu like this:

===== SmartStock Inventory System =====

Add Product

Restock Product

Sell Product

Display Inventory

Undo Last Operation

Exit
Enter your choice:

mathematica
Copy
Edit

### 💡 Sample Session

```text
Enter your choice: 1
Enter Product ID: P001
Enter Product Name: Apple
Enter Quantity: 100
Product added successfully!

Enter your choice: 2
Enter Product ID to restock: P001
Enter quantity to add: 50
Product restocked successfully!

Enter your choice: 3
Enter Product ID to sell: P001
Enter quantity to sell: 30
Product sold successfully!

Enter your choice: 4
Current Inventory:
ID: P001 | Name: Apple | Quantity: 120

Enter your choice: 5
Undo successful: Last operation reverted.

Enter your choice: 4
Current Inventory:
ID: P001 | Name: Apple | Quantity: 150

```
💻 Technologies Used
🧠 Java (JDK 11 or higher)

🗃️ MongoDB (Local or MongoDB Atlas)

🔌 MongoDB Java Driver (mongodb-driver-sync)

📂 Manual setup (Maven is not used currently)