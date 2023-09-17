# Stock Management System

A console-based Java application designed to assist in managing various aspects of inventory, including suppliers, item categories, and items. This system provides a user-friendly interface to facilitate efficient inventory management.

## Table of Contents

1. [Introduction](#introduction)
2. [Features](#features)
3. [Usage](#usage)
4. [Installation](#installation)
5. [Contributing](#contributing)
6. [Version](#version)
6. [License](#license)

## Introduction

Welcome to the IJSE Stock Management System!

The IJSE Stock Management System is a user-friendly command-line application designed to help you manage your stock, suppliers, and item categories efficiently. Whether you're a small business owner or an inventory manager, this system provides the tools you need to keep track of your products, suppliers, and more.

With this system, you can:

- Manage your suppliers, add new ones, update their information, and view the existing suppliers.
- Maintain a list of item categories, add new categories, delete old ones, and update category names.
- Keep track of your inventory by adding new items, updating their details, and viewing the available items.
- Search for suppliers and items based on various criteria.
- Rank items by unit price to make informed purchasing decisions.
- Change your login credentials securely.

This README will guide you through the features, installation process, and how to contribute to the project. Let's get started!

## Features

### 1. Login System

- **Secure Login**: Users must enter a username and password for verification.

### 2. Dashboard

- **Central Hub**: Interactive dashboard for easy navigation.

### 3. Supplier Management

- **Add Supplier**: Add new suppliers with unique IDs and names.
- **Update Supplier**: Modify supplier information.
- **Delete Supplier**: Remove suppliers.
- **View Suppliers**: List all registered suppliers.
- **Search Supplier**: Find a supplier by ID.

### 4. Stock Management

#### Item Categories

- **Manage Categories**: Add, delete, and update item categories.
- **Add New Category**: Create new item categories.
- **Delete Category**: Remove item categories (updates associated items).
- **Update Category**: Modify category names.
- **Stock Management**: Quick access to stock management.

#### Items

- **Add Item**: Add items with unique codes, descriptions, prices, quantities, categories, and suppliers.
- **Get Items Supplier Wise**: Retrieve items by supplier.
- **View Items**: Detailed view of categorized items.
- **Rank Items by Price**: Display items ranked by unit prices.

# Usage

The IJSE Stock Management System is a command-line application that offers a range of functionalities to efficiently manage your stock, suppliers, and item categories. Below, you'll find instructions on how to use each of the core features.

## Dashboard

To get started, run the program and you'll be presented with the main dashboard. From here, you can access various features:

- [Change the credentials](#change-the-credentials): Update your login credentials for added security.
- [Supplier Manage](#supplier-manage): Manage your suppliers, including adding, updating, deleting, viewing, and searching for suppliers.
- [Stock Manage](#stock-manage): Handle your stock, including managing item categories, adding items, viewing items, searching items, and ranking items by unit price.
- [Logout](#logout): Log out of your current session.
- [Exit the system](#exit-the-system): Close the application.

## Change the Credentials

You can change your login credentials to enhance security. Follow the prompts to verify your current username and password and set a new password.

## Supplier Manage

In the Supplier Management section, you can perform the following actions:

- [Add Supplier](#add-supplier): Add a new supplier to your list.
- [Update Supplier](#update-supplier): Update the details of an existing supplier.
- [Delete Supplier](#delete-supplier): Delete a supplier from your records.
- [View Suppliers](#view-suppliers): View the list of all your suppliers.
- [Search Supplier](#search-supplier): Search for a specific supplier.
- [Go to Home Page](#home-page): Return to the main dashboard.

## Stock Manage

The Stock Management section allows you to:

- [Manage Item Categories](#manage-item-categories): Add, update, and delete item categories.
- [Add Item](#add-item): Add new items to your stock.
- [Get Items Supplier Wise](#get-items-supplier-wise): Retrieve items from a specific supplier.
- [View Items](#view-items): View all items organized by category.
- [Rank Items Per Unit Price](#rank-items-per-unit-price): Sort items by unit price.
- [Go to Home Page](#home-page-1): Return to the main dashboard.

For detailed usage instructions on each feature, refer to the corresponding sections below.

# Installation

To get started with the IJSE Stock Management System, follow these steps for installation:

## Prerequisites

- Java Development Kit (JDK): Make sure you have Java JDK 8 or later installed on your system. You can download it from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html) or use an open-source JDK distribution like OpenJDK.

## Clone the Repository

First, clone this repository to your local machine using [Git](https://git-scm.com/):

```bash
git clone https://github.com/yourusername/ijse-stock-management.git
```

# Contributing

Contributions to the IJSE Stock Management System are welcome! Here's how you can contribute:

1. Fork the repository to your GitHub account.

2. Clone your forked repository to your local machine.

3. Create a new branch for your contribution:

   ```bash
   git checkout -b feature/new-feature
   ```
4. Make your changes and commit them with clear messages.

5. Push your changes to your fork.

6. Create a pull request (PR) to the original repository.

7. Collaborate with project maintainers and address feedback.

8. Once your PR is approved, it will be merged into the main project.

# Version
0.1.0

# License
Copyright &copy: 2023 Sahan Lakmal <br>
This project is license under this [License](License.txt)