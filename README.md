# Order Service - Java Microservice

This project is a simple Order Management microservice built using Spring Boot.

## Tech Stack
- Java
- Spring Boot
- REST API
- Maven

## Features
- Create Order
- Get Order By ID
- Exception Handling
- UUID based order generation

## Project Structure

controller → Handles REST APIs  
service → Business logic  
model → Domain models  
exception → Custom exception handling  

## API Endpoints

POST /orders
Create a new order.

GET /orders/{id}
Fetch order by ID.

## Run Project

mvn spring-boot:run
