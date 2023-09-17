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

# Contributing

Contributions to the IJSE Stock Management System project are highly encouraged and appreciated! If you'd like to contribute, please follow these guidelines:

1. **Fork the Repository**: Start by forking this repository to your GitHub account. You can do this by clicking the "Fork" button at the top right corner of the repository's page.

2. **Clone the Forked Repository**: After forking, clone your forked repository to your local machine using the `git clone` command. Replace `yourusername` with your actual GitHub username.

    ```bash
    git clone https://github.com/yourusername/ijse-stock-management.git
    ```

3. **Create a New Branch**: Before making any changes, create a new branch for your work. Use a descriptive name for your branch that summarizes the purpose of your changes.

    ```bash
    git checkout -b feature/your-feature-name
    ```

4. **Make Changes**: Make your desired changes and improvements to the codebase. Ensure that your code follows the project's coding standards and conventions.

5. **Test Your Changes**: Thoroughly test your changes to make sure they work as expected and do not introduce any regressions.

6. **Commit Your Changes**: Commit your changes with clear and concise commit messages. Use present tense and provide a brief summary of your changes.

    ```bash
    git commit -m "Add feature: description of your changes"
    ```

7. **Push to Your Fork**: Push your changes to your forked repository on GitHub.

    ```bash
    git push origin feature/your-feature-name
    ```

8. **Create a Pull Request**: Go to the original repository on GitHub and click the "New Pull Request" button. Provide a clear title and description for your pull request, explaining the purpose of your changes.

9. **Code Review**: Your pull request will be reviewed by project maintainers. Be prepared to address any feedback or suggestions for improvement.

10. **Merge and Celebrate**: Once your pull request is approved, it will be merged into the main project. Congratulations on your contribution!

Please note that by contributing to this project, you agree to follow the [code of conduct](CODE_OF_CONDUCT.md). Be respectful and considerate of others throughout the contribution process.

Thank you for contributing to the IJSE Stock Management System! Your contributions help make this project better for everyone.


# Version
0.1.0

# License
Copyright &copy: 2023 Sahan Lakmal <br>
This project is license under this [License](License.txt)