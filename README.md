# Intelligent Cricket Team Selection System (ICTSS) - Backend

The **Intelligent Cricket Team Selection System (ICTSS)** is a Spring Boot application designed to help selectors, coaches, and analysts make data-driven decisions for cricket team selection using advanced machine learning and real-time analytics.

## Table of Contents
- [Project Overview](#project-overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Requirements](#requirements)
- [Installation](#installation)
- [Running the Application](#running-the-application)
- [Folder Structure](#folder-structure)
- [API Endpoints](#api-endpoints)
- [Future Enhancements](#future-enhancements)

## Project Overview

The Intelligent Cricket Team Selection System (ICTSS) aims to optimize the process of selecting cricket teams based on player statistics, match conditions, and real-time analytics. The backend is built using **Spring Boot** with a **MySQL** database, **Java** for business logic, and **Python** for the machine learning model.

The system includes:
- Secure user authentication and role management.
- Player and team management.
- Real-time recommendations for team selection using data-driven insights.
- Advanced analytics for player performance, team dynamics, and match outcomes.

## Features

- **User Authentication**: Secure registration, login, logout, and role-based access control (Admin, Coach, Selector, Analyst).
- **Player Management**: Add, update, delete, and view detailed player statistics.
- **Team Selection**: Automatically suggest the best team based on data, and allow manual adjustment.
- **Playground Management**: Manage cricket grounds including location, conditions, and match history.
- **Reports & Analytics**: Generate and view detailed performance reports and analytics.

## Technologies Used

- **Spring Boot** - Backend framework
- **MySQL** - Relational database
- **Angular** - Frontend framework (for the Web UI)
- **Java** - Backend logic
- **Python** - Machine learning model
- **Maven** - Build tool
- **CoreUI** - Admin template for the frontend UI
- **JPA/Hibernate** - ORM for database interactions

## Requirements

Before you start, ensure you have the following installed:

- Java 17 or higher
- Maven 3.6 or higher
- MySQL 8.x
- Python 3.x (for machine learning components)

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/your-repository/ictss-backend.git
cd ictss-backend
