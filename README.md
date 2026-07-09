⚽ Club Management & Analytics System

Welcome to the repository for the Club Management & Analytics System.

This project is a full-stack desktop application engineered to manage complex sports organization data, including hierarchical staff structures, historical player statistics, and team rosters. It was built with a strong emphasis on data integrity, object-oriented design, and architectural best practices.
🗂️ Repository Navigation & Architecture

To maintain a strict separation of concerns and clearly demonstrate the distinct architectural layers of this application, the codebase is fundamentally split across two main branches.

Please navigate to the branches below to explore the code:

    👉 branch: BD — Database & Backend Logic

        Focus: Relational Database Management System (RDBMS) design and implementation.

        Contents: This branch contains the core data infrastructure. You will find the highly normalized PostgreSQL schemas, the complex relational modeling (handling historical, time-bound player stints), custom database triggers, and strict foreign key constraints designed to enforce data integrity entirely at the database level.

    👉 branch: OO — Object-Oriented Java & User Interface

        Focus: Application logic, GUI, and database connectivity.

        Contents: This branch houses the Java application. It showcases a strict Model-View-Controller (MVC) architecture decoupling the Java Swing frontend from the business logic. It also includes the Data Access Object (DAO) pattern implementation, utilizing raw JDBC to securely and efficiently communicate with the PostgreSQL backend.

🛠️ Tech Stack & Design Patterns

    Database: PostgreSQL, Database Triggers, Advanced Relational Design

    Application: Java, Swing (GUI), JDBC

    Architecture & Patterns: MVC (Model-View-Controller), DAO (Data Access Object), OOP (Object-Oriented Programming)

    Modeling: UML (Unified Modeling Language)

Select a branch from the dropdown menu above to dive into the code!
