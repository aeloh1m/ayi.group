CREATE DATABASE ejercicio1_clase28;

/*
EJERCICIOS

1) Realizar un programa con JDBC

Elegir el motor de bases de datos que tengan instalado. (MySQL, Microsoft SQL Server, PostgreSQL, SQLite, etc)
Crear el proyecto con Maven o también se puede probar con Gradle.
Crear la base de datos de una escuela de verano en donde se deben realizar las facturación a cada asociado,
 se tienen las siguientes tablas 
== Socio (identificador de socio, nombre, apellido, fecha de nacimiento, correo electronico, telefono), 
== Facturas (código de factura, tipo de factura, numero de socio, fecha de emisión, monto total, estado de la factura), 
== Tipo de factura (código de factura, descripción), 
== Estado de factura (identificador de estado, descripcion),
== Actividades (código de actividad, nombre, descripción, costo, duración), 
== Inscripciones (identificador de inscripción, identificador de socio, identificador de la actividad, fecha de inscripción)

Cargar todos los datos de todas las tablas desde el programa de Java
Consultar los datos de las tablas.
El programa deberá permitir que el usuario elija qué datos mostrar (Consulta multitabla).
El programa deberá permitirle al usuario realizar modificaciones sobre los datos almacenados en la base de datos.
Para la carga de datos por teclado utilizar la clase BufferedReader
Se solicita que el programa cuente con un menú de opciones.
Se solicita utilizar la clase PreparedStatement de la API de JDBC.
El programa debe permitir la eliminación de los datos de las tablas por parte del usuario.

*/

CREATE TABLE `ejercicio1_clase28`.`socios` (
  `id_socio` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `fecha_nacimiento` DATE NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`id_socio`));

CREATE TABLE `ejercicio1_clase28`.`facturas` (
  `id_factura` INT NOT NULL AUTO_INCREMENT,
  `tipo_de_factura_id` INT NULL,
  `socio_id` INT NULL,
  `fecha_de_emision` DATETIME NULL,
  `monto_total` DECIMAL NULL,
  `estado_factura_id` INT NULL,
  PRIMARY KEY (`id_factura`));

CREATE TABLE `ejercicio1_clase28`.`tipo_de_facturas` (
  `id_tipo_de_facturas` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipo_de_facturas`));
  
  CREATE TABLE `ejercicio1_clase28`.`estado_de_facturas` (
  `id_estado_de_facturas` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_estado_de_facturas`));

  
  CREATE TABLE `ejercicio1_clase28`.`actividades` (
  `id_actividades` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `duracion` TIME NULL,
  `costo` DECIMAL NULL,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_actividades`));
  
  CREATE TABLE `ejercicio1_clase28`.`inscripciones` (
  `id_inscripciones` INT NOT NULL AUTO_INCREMENT,
  `id_socio` INT NULL,
  `actividad_id` INT NULL,
  `fecha_de_inscripcion` DATETIME NULL,
  PRIMARY KEY (`id_inscripciones`));

# FKS

ALTER TABLE `ejercicio1_clase28`.`facturas` 
ADD INDEX `estado_de_factura_id_idx` (`estado_factura_id` ASC) VISIBLE,
ADD INDEX `tipo_de_factura_id_idx` (`tipo_de_factura_id` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase28`.`facturas` 
ADD CONSTRAINT `tipo_de_factura_id`
  FOREIGN KEY (`tipo_de_factura_id`)
  REFERENCES `ejercicio1_clase28`.`tipo_de_facturas` (`id_tipo_de_facturas`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `estado_de_factura_id`
  FOREIGN KEY (`estado_factura_id`)
  REFERENCES `ejercicio1_clase28`.`estado_de_facturas` (`id_estado_de_facturas`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `ejercicio1_clase28`.`inscripciones` 
ADD INDEX `actividad_id_idx` (`actividad_id` ASC) VISIBLE,
ADD INDEX `id_socio_idx` (`id_socio` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase28`.`inscripciones` 
ADD CONSTRAINT `id_socio`
  FOREIGN KEY (`id_socio`)
  REFERENCES `ejercicio1_clase28`.`socios` (`id_socio`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `actividad_id`
  FOREIGN KEY (`actividad_id`)
  REFERENCES `ejercicio1_clase28`.`actividades` (`id_actividades`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ALTER TABLE `ejercicio1_clase28`.`facturas` 
ADD INDEX `socio_id_idx` (`socio_id` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase28`.`facturas` 
ADD CONSTRAINT `socio_id`
  FOREIGN KEY (`socio_id`)
  REFERENCES `ejercicio1_clase28`.`socios` (`id_socio`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;





