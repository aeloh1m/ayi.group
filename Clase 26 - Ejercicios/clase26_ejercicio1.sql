/*

1) Realizar un programa con JDBC

- Elegir el motor de bases de datos que tengan instalado. (MySQL, Microsoft SQL Server, PostgreSQL, SQLite, etc)
- Utilizar Maven para gestionar las dependencias.

- Crear las tablas correspondiente a un sistema gestión de ventas de una casa de deportes: 

=== Productos
 (número identificador único, nombre, categoria, descripcion, precio, cantidad en stock y proveedor),
 
=== Categorías (número identificatorio, descripción),  

===  Clientes 
 (número identificador de cliente, nombre, apellido, dirección, correo electrónico, número de teléfono 
 y fecha de registro), 
 
 === Proveedores 
 (número identificador de proveedor, nombre de la empresa, razón social, contacto, dirección, correo electrónico
 y número de teléfono),  
 
 === Ventas (número identificador de ventas, numero identificador del cliente, fecha
 de venta, total de la venta, método de pago utilizado),
 
=== Método de pago 
(número identificador del método de pago, descripción), 

=== Detalle de Venta 
(número identificador del detalle de venta, identificador de la venta, identificador del producto,
 cantidad vendida, precio unitario en el momento de la venta).
 
- Cargar los datos de todas las tablas desde el programa de Java.
- Para la carga de datos por teclado utilizar BufferedReader.
- Utilizar el patrón de diseño DAO.
- Realizar un menú de opciones en el programa.
- Consultar los datos de todas las tablas individualmente.
- Realizar consultas multitablas, aquí el usuario del programa podrá solicitar de qué tablas mostrar los datos.
- Actualizar datos de las tablas, aquí el usuario podrá elegir que datos actualizar y de qué tabla.
- Utilizar transacciones para la inserción, actualización y eliminación de datos en la bases de datos.

*/

CREATE DATABASE ejercicio1_clase26;

CREATE TABLE `ejercicio1_clase26`.`productos` (
  `id_productos` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `categoria` VARCHAR(45) NULL,
  `descripcion` VARCHAR(45) NULL,
  `precio` DECIMAL NULL,
  `cantidad` INT NULL,
  `id_proveedor` INT NULL,
  PRIMARY KEY (`id_productos`));

CREATE TABLE `ejercicio1_clase26`.`categorias` (
  `id_categoria` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_categoria`));

CREATE TABLE `ejercicio1_clase26`.`clientes` (
  `id_clientes` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `fecha_de_registro` DATETIME NULL,
  PRIMARY KEY (`id_clientes`));

CREATE TABLE `ejercicio1_clase26`.`proveedores` (
  `id_proveedor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `razon_social` VARCHAR(45) NULL,
  `contacto` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`id_proveedor`));

CREATE TABLE `ejercicio1_clase26`.`ventas` (
  `id_ventas` INT NOT NULL AUTO_INCREMENT,
  `cliente_id` INT NULL,
  `fecha_de_venta` DATETIME NULL,
  `total` DECIMAL NULL,
  `met_de_pago_id` INT NULL,
  PRIMARY KEY (`id_ventas`));
  
  CREATE TABLE `ejercicio1_clase26`.`metodos_de_pagos` (
  `id_metodos_de_pago` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_metodos_de_pago`));
  
  CREATE TABLE `ejercicio1_clase26`.`detalles_de_ventas` (
  `id_detalles_de_venta` INT NOT NULL AUTO_INCREMENT,
  `id_producto` INT NULL,
  `id_venta` INT NULL,
  `cant_vendida` INT NULL,
  `precio_de_venta` DECIMAL NULL,
  PRIMARY KEY (`id_detalles_de_venta`));
  
  # FKS
  
  ALTER TABLE `ejercicio1_clase26`.`productos` 
ADD INDEX `id_proveedor_idx` (`id_proveedor` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase26`.`productos` 
ADD CONSTRAINT `id_proveedor`
  FOREIGN KEY (`id_proveedor`)
  REFERENCES `ejercicio1_clase26`.`proveedores` (`id_proveedor`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `ejercicio1_clase26`.`ventas` 
ADD INDEX `cliente_id_idx` (`cliente_id` ASC) VISIBLE,
ADD INDEX `met_pago_id_idx` (`met_de_pago_id` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase26`.`ventas` 
ADD CONSTRAINT `cliente_id`
  FOREIGN KEY (`cliente_id`)
  REFERENCES `ejercicio1_clase26`.`clientes` (`id_clientes`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `met_pago_id`
  FOREIGN KEY (`met_de_pago_id`)
  REFERENCES `ejercicio1_clase26`.`metodos_de_pagos` (`id_metodos_de_pago`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `ejercicio1_clase26`.`detalles_de_ventas` 
ADD INDEX `id_producto_idx` (`id_producto` ASC) VISIBLE,
ADD INDEX `id_venta_idx` (`id_venta` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase26`.`detalles_de_ventas` 
ADD CONSTRAINT `id_producto`
  FOREIGN KEY (`id_producto`)
  REFERENCES `ejercicio1_clase26`.`productos` (`id_productos`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `id_venta`
  FOREIGN KEY (`id_venta`)
  REFERENCES `ejercicio1_clase26`.`ventas` (`id_ventas`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `ejercicio1_clase26`.`productos` 
ADD COLUMN `id_categoria` INT NULL AFTER `id_proveedor`,
ADD INDEX `id_categoria_idx` (`id_categoria` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase26`.`productos` 
ADD CONSTRAINT `id_categoria`
  FOREIGN KEY (`id_categoria`)
  REFERENCES `ejercicio1_clase26`.`categorias` (`id_categoria`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;





