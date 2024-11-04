/*
 Crear un proyecto de Hibernate:

Crear una base de datos con una sola tabla Personas (número identificatorio, nombre, apellido) 
Realizar un programa que lea datos por teclado
Utilizar la clase Scanner
El programa deberá tener un menú de opciones para leer personas, crear, actualizar datos y eliminar.
Realizar el CRUD
Utilizar la base de datos que prefieras.*/

CREATE DATABASE clase45_ejercicios;
USE clase45_ejercicios;

CREATE TABLE `clase45_ejercicios`.`personas` (
  `nro_identificatorio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  PRIMARY KEY (`nro_identificatorio`));

