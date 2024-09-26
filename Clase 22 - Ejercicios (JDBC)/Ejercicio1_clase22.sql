/*
1) Realizar un programa con JDBC
● Elegir el motor de bases de datos que tengan instalado. (MySQL, Microsoft
SQL Server, PostgreSQL, SQLite, etc)
● Buscar en internet el conector y agregarlo al proyecto de Java (Intelli IDEA,
Eclipse o Netbeans)
● Crear una base de datos simple con 4 tablas: Usuarios (IdUsuarios, nombre
de usuarios, password de usuarios, IdPersona, tipo de usuario), Personas
(IdPersonas, nombres, apellido, tipo de documento, número de documento),
Documentos (Número de documento, descripción) y Tipo de Usuarios (Id
tipo de usuario, descripción).
● Crear un menú de opciones.
● De preferencia utilizar la clase BufferedReader para la lectura de datos por
teclado.
*/

CREATE DATABASE ejercicio1_clase22;

CREATE TABLE `ejercicio1_clase22`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre_usuario` VARCHAR(45) NULL,
  `password` VARCHAR(45) NULL,
  `tipo_de_usuario` VARCHAR(45) NULL,
  `id_persona` INT NULL,
  PRIMARY KEY (`id_usuario`));
  
  CREATE TABLE `ejercicio1_clase22`.`personas` (
  `id_personas` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `tipo_de_documento` INT NULL,
  `nro_documento` INT NULL,
  PRIMARY KEY (`id_personas`));
  
  CREATE TABLE `ejercicio1_clase22`.`tipo_de_usuarios` (
  `id_tipo_de_usuarios` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_tipo_de_usuarios`));
  
  ALTER TABLE `ejercicio1_clase22`.`usuarios` 
ADD INDEX `id_persona_idx` (`id_persona` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase22`.`usuarios` 
ADD CONSTRAINT `id_persona`
  FOREIGN KEY (`id_persona`)
  REFERENCES `ejercicio1_clase22`.`personas` (`id_personas`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
  ALTER TABLE `ejercicio1_clase22`.`usuarios` 
ADD COLUMN `tipo_de_usuario` INT NULL AFTER `id_persona`,
ADD INDEX `tipo_de_usuario_idx` (`tipo_de_usuario` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase22`.`usuarios` 
ADD CONSTRAINT `tipo_de_usuario`
  FOREIGN KEY (`tipo_de_usuario`)
  REFERENCES `ejercicio1_clase22`.`tipo_de_usuarios` (`id_tipo_de_usuarios`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
  
SHOW GLOBAL VARIABLES LIKE 'PORT';

USE ejercicio1_clase22;

SELECT * FROM USUARIOS;

INSERT INTO `ejercicio1_clase22`.`usuarios`
(`id_usuario`,
`nombre_usuario`,
`password`)
VALUES
(1, "petit", "petit123"), (2, "ramen", "ramen123"), (3, "rimal", "rimal123");
