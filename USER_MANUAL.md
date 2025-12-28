# GearRent Pro - User Manual

## 1. Introduction

Welcome to the GearRent Pro User Manual. This guide provides detailed instructions on how to use the GearRent Pro application to manage your equipment rental business.

GearRent Pro is a comprehensive, multi-branch equipment rental system designed to streamline your daily operations. It offers a wide range of features, including:

*   **Inventory Management:** Track your equipment across multiple branches.
*   **Customer Management:** Maintain a database of your customers and their rental history.
*   **Reservations and Rentals:** Create and manage equipment reservations and rentals.
*   **Billing and Reporting:** Generate reports to gain insights into your business performance.

This manual is divided into sections based on user roles to help you quickly find the information you need.

## 2. Getting Started

Before you can use GearRent Pro, you need to launch the application and log in with your user credentials.

### 2.1. Launching the Application

To launch the application, follow the instructions in the `README.md` file.

### 2.2. Logging In

Once the application is running, you will be presented with the login screen. Enter your username and password, and then click the "Login" button.

The application includes a set of default users with different roles. You can use these credentials to log in:

*   **Admin:**
    *   **Username:** `admin`
    *   **Password:** `admin123`
*   **Branch Manager (Panadura Branch):**
    *   **Username:** `manager1`
    *   **Password:** `manager123`
*   **Staff (Panadura Branch):**
    *   **Username:** `staff1`
    *   **Password:** `staff123`

Your assigned role determines which features and functionalities you can access within the application.

## 3. Admin Functionalities

As an Admin, you have access to the highest level of administrative functions in the system. Your primary responsibilities include managing branches, categories, and membership configurations.

### 3.1. Managing Branches

The "Manage Branches" screen allows you to perform CRUD (Create, Read, Update, Delete) operations for branches.

*   **To add a new branch:** Click the "Add New" button and fill in the required information, including the branch code, name, address, and contact details.
*   **To edit an existing branch:** Select the branch from the list and click the "Edit" button.
*   **To delete a branch:** Select the branch from the list and click the "Delete" button.

### 3.2. Managing Categories

The "Manage Categories" screen enables you to manage the equipment categories.

*   **To add a new category:** Click the "Add New" button and provide the category name, description, base price factor, and weekend multiplier.
*   **To edit an existing category:** Select the category from the list and click the "Edit" button.
*   **To activate or deactivate a category:** Use the status toggle next to each category.

### 3.3. Managing Membership Configurations

The "Manage Membership" screen allows you to define membership levels and their associated discount percentages.

*   **To add a new membership level:** Click the "Add New" button and specify the membership level name and the discount percentage.
*   **To edit an existing membership level:** Select the level from the list and click the "Edit" button.

## 4. Branch Manager Functionalities

As a Branch Manager, you are responsible for managing the day-to-day operations of your assigned branch. This includes managing the equipment inventory and generating reports.

### 4.1. Managing Equipment

The "Manage Equipment" screen allows you to manage the equipment in your branch's inventory.

*   **To add a new piece of equipment:** Click the "Add New" button and enter the equipment's details, including its category, brand, model, purchase year, daily base price, and security deposit amount.
*   **To edit an existing piece of equipment:** Select the equipment from the list and click the "Edit" button.
*   **To update the status of a piece of equipment:** Select the equipment and choose the appropriate status (e.g., "Available," "Under Maintenance").

### 4.2. Generating Reports

The "Reports" section provides you with valuable insights into your branch's performance.

*   **Branch-wise Revenue Report:** This report displays the total rental income, late fees, and damage charges for your branch within a selected date range.
*   **Equipment Utilization Report:** This report shows how many days each piece of equipment in your branch was rented versus available, helping you understand the utilization rate of your inventory.

## 5. Staff Functionalities

As a Staff member, you are responsible for handling the core rental operations, including managing customers, reservations, and rentals.

### 5.1. Managing Customers

The "Manage Customers" screen allows you to manage the customer database.

*   **To add a new customer:** Click the "Add New" button and enter the customer's personal details and assign a membership level.
*   **To edit an existing customer:** Select the customer from the list and click the "Edit" button.
*   **To view a customer's rental history:** Select the customer to see a list of their past and active rentals.

### 5.2. Managing Reservations

The "Reservations" screen allows you to create and manage equipment reservations.

*   **To create a new reservation:** Select the branch, equipment, customer, and date range. The system will validate the reservation for any scheduling conflicts.
*   **To cancel a reservation:** Select the reservation from the list and click the "Cancel" button.
*   **To convert a reservation to a rental:** Select the reservation and click the "Convert to Rental" button. The system will recalculate the costs and create a new rental record.

### 5.3. Managing Rentals

The "Rentals" screen is where you can create new rentals and manage existing ones.

*   **To create a new rental:** Select the equipment, customer, and date range. The system will calculate the rental amount, including any applicable discounts.
*   **To view rental details:** Select a rental from the list to see its complete details, including the payment status and rental status.

### 5.4. Processing Returns

The "Process Return" screen is used to handle the return of rented equipment.

*   **To process a return:** Select the active rental and enter the actual return date.
*   **To record damages:** If the equipment is damaged, you can add a damage description and a damage charge.
*   **To calculate late fees:** The system will automatically calculate any late fees if the equipment is returned after the due date.
*   **To finalize the return:** The system will calculate the final amount to be refunded to the customer or paid by the customer, and the rental will be marked as "Returned."
