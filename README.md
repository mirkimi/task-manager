Pre-requisite
1. Make sure to replace the placeholder in the application.properties with values in your local environment.
2. Execute the SQL script to load the data into TESTDB.

Overview

This project aims to develop, design and maintain a Java Springboot API which provides functionality to create, delete, view amd update tasks.

Framework and Technology used

1. Java 17
2. Java Springboot 3.2.5
3. Hibernate and JPA
4. JDBC MS SQL
5. Embedded tomcat server

Design and Implementation

1. GET @/getAllTasks - retrieve all tasks.
2. GET @/getTasks - retrieve all tasks using pagination.
3. POST @/getTaskById - retrieve task based on Id passed in the request payload.
4. POST @/saveTask - to save a task.
5. PATCH @/updateTask - to update a task.
6. DELETE @/deleteTask - to delete a task.

Improvement Area

1. Authentication & Authorization
   This API does not require any authentication and authorization due to limited time. But there's a plan in hand to implement them.

2. Implement SSL certificate
   As of now, the API operates in http instead of https due to no SSL certificate being imported.
