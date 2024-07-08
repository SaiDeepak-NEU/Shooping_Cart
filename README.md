# Shopping Cart Application

This is a simple Shopping Cart backend application built with Spring Boot, using Controllers, Models, Services, and Repositories to manage product items. The application connects to a PostgreSQL database and uses environment variables for configuration.

## Table of Contents
- [Shopping Cart Application](#shopping-cart-application)
  - [Table of Contents](#table-of-contents)
  - [Prerequisites](#prerequisites)
  - [Environment Setup](#environment-setup)
  - [Starting the Application](#starting-the-application)
  - [Endpoints](#endpoints)

## Prerequisites

- Java 17
- Maven
- PostgreSQL
- Git
- Any editor(Eclipse or IntelliJ)

## Environment Setup

Create a `.env` file in the root directory with the following content:

DB_URL=your_URL
DB_USERNAME=your_username
DB_PASSWORD=your_password

## Starting the Application

1. Clone the repository
2. cd Cart
3. mvn clean install
4. Run the CartApplication.java file

The application will start on http://localhost:8080

## Endpoints

1. To add an item: URL: /api/cart/add
    Method: POST
    Request Body:
     {
    "name": "Product Name",
    "price": 10.0,
    "quantity": 1
    }
2. To fetch all items: URL: /api/cart/items
    Method: GET


    



