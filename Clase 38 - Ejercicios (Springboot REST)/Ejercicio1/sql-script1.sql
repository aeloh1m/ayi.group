CREATE DATABASE EJERCICIOSCLASE38;
USE EJERCICIOSCLASE38;

CREATE TABLE `ejerciciosclase38`.`usuarios` (
  `id_usuario` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  PRIMARY KEY (`id_usuario`));
  
  
INSERT INTO `ejerciciosclase38`.`usuarios`
(`id_usuario`,
`nombre`,
`apellido`)
VALUES
(1, "Romualdo", "Pérez"), (2, "Twicha", "Kappa"), (3, "María", "Remilli");
