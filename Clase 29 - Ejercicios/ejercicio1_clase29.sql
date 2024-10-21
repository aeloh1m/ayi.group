/*
Realizar un programa con JDBC
● Elegir el motor de bases de datos que tengan instalado. (MySQL, Microsoft
SQL Server, PostgreSQL, SQLite, etc)
● Crear el proyecto con Maven o Gradle.
● Crear la base de datos de un congreso donde se exponen diferentes
videojuegos: 

== Personas (numero de documento, nombre, apellido, ciudad
donde reside, provincia donde reside), 
== Videojuegos (número identificador, nombre, descripcion, genero de videojuego, 
persona desarrolladora),
== Genero (codigo identificatorio, descripción), 
== Conferencia (persona
expositora, tematica, fecha y hora, duración), 
== Stand donde se exponen
videojuegos (código identificatorio del stand, videojuego expuesto, persona
que expositora, sector donde está ubicado el stand, dimensiones “alto x
ancho”), 
== Sector (código del sector, nombre, ubicación),
== Ciudades (código identificatorio, descripción), 
== Provincias (código
identificatorio, descripción)

EJERCICIOS

● Crear un menú de opciones para que el usuario del programa pueda elegir
diferentes opciones.
● Utilizar cualquiera de las clases vistas para el ingreso de datos por teclado.
● Utilizar el patrón de diseño DAO para estructurar de forma correcta el
código.
● El usuario del sistema, podrá ingresar datos en todas las tablas, realizar las
validaciones correspondientes para la carga de datos.
● El usuario del sistema podrá consultar datos de todas las tablas.
● El usuario del sistema podrá actualizar datos de todas las tablas.
● El usuario también puede eliminar datos específicos de las tablas.
*/

CREATE DATABASE ejercicio1_clase29;

-- Crear tabla para personas
CREATE TABLE `ejercicio1_clase29`.`personas` (
  `documento` INT NOT NULL,
  `nombre` VARCHAR(50) NULL,
  `apellido` VARCHAR(50) NULL,
  `ciudad_id` INT NULL,
  `provincia_id` INT NULL,
  PRIMARY KEY (`documento`)
);

-- Crear tabla para videojuegos
CREATE TABLE `ejercicio1_clase29`.`videojuegos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NULL,
  `descripcion` TEXT NULL,
  `genero_id` INT NULL,
  `desarrolladora_id` INT NULL,
  PRIMARY KEY (`id`)
);

-- Crear tabla para géneros
CREATE TABLE `ejercicio1_clase29`.`genero` (
  `codigo` INT NOT NULL,
  `descripcion` VARCHAR(50) NULL,
  PRIMARY KEY (`codigo`)
);

-- Crear tabla para conferencias
CREATE TABLE `ejercicio1_clase29`.`conferencias` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `expositora_id` INT NULL,
  `tematica` VARCHAR(100) NULL,
  `fecha_hora` DATETIME NULL,
  `duracion` INT NULL,
  PRIMARY KEY (`id`)
);

-- Crear tabla para stands
CREATE TABLE `ejercicio1_clase29`.`stands` (
  `codigo` INT NOT NULL AUTO_INCREMENT,
  `videojuego_id` INT NULL,
  `expositor_id` INT NULL,
  `sector_id` INT NULL,
  `dimensiones` VARCHAR(50) NULL,
  PRIMARY KEY (`codigo`)
);

-- Crear tabla para sectores
CREATE TABLE `ejercicio1_clase29`.`sectores` (
  `codigo` INT NOT NULL,
  `nombre` VARCHAR(50) NULL,
  `ubicacion` VARCHAR(100) NULL,
  PRIMARY KEY (`codigo`)
);

-- Crear tabla para ciudades
CREATE TABLE `ejercicio1_clase29`.`ciudades` (
  `codigo` INT NOT NULL,
  `descripcion` VARCHAR(100) NULL,
  PRIMARY KEY (`codigo`)
);

-- Crear tabla para provincias
CREATE TABLE `ejercicio1_clase29`.`provincias` (
  `codigo` INT NOT NULL,
  `descripcion` VARCHAR(100) NULL,
  PRIMARY KEY (`codigo`)
);

# FKS
ALTER TABLE `ejercicio1_clase29`.`personas`
ADD CONSTRAINT `fk_ciudad`
FOREIGN KEY (`ciudad_id`) REFERENCES `ejercicio1_clase29`.`ciudades`(`codigo`);

ALTER TABLE `ejercicio1_clase29`.`personas`
ADD CONSTRAINT `fk_provincia`
FOREIGN KEY (`provincia_id`) REFERENCES `ejercicio1_clase29`.`provincias`(`codigo`);

ALTER TABLE `ejercicio1_clase29`.`videojuegos`
ADD CONSTRAINT `fk_genero`
FOREIGN KEY (`genero_id`) REFERENCES `ejercicio1_clase29`.`genero`(`codigo`);

ALTER TABLE `ejercicio1_clase29`.`videojuegos`
ADD CONSTRAINT `fk_desarrolladora`
FOREIGN KEY (`desarrolladora_id`) REFERENCES `ejercicio1_clase29`.`personas`(`documento`);

ALTER TABLE `ejercicio1_clase29`.`conferencias`
ADD CONSTRAINT `fk_expositora`
FOREIGN KEY (`expositora_id`) REFERENCES `ejercicio1_clase29`.`personas`(`documento`);

ALTER TABLE `ejercicio1_clase29`.`stands`
ADD CONSTRAINT `fk_videojuego`
FOREIGN KEY (`videojuego_id`) REFERENCES `ejercicio1_clase29`.`videojuegos`(`id`);

ALTER TABLE `ejercicio1_clase29`.`stands`
ADD CONSTRAINT `fk_expositor`
FOREIGN KEY (`expositor_id`) REFERENCES `ejercicio1_clase29`.`personas`(`documento`);

ALTER TABLE `ejercicio1_clase29`.`stands`
ADD CONSTRAINT `fk_sector`
FOREIGN KEY (`sector_id`) REFERENCES `ejercicio1_clase29`.`sectores`(`codigo`);

