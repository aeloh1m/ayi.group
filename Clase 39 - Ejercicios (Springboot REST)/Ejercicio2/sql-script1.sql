CREATE DATABASE EJERCICIOSCLASE38;
USE EJERCICIOSCLASE38;

CREATE TABLE `ejerciciosclase38`.`empleados` (
  `legajo` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `apellido` VARCHAR(45) NULL,
  `nro_sucursal` INT NULL,
  PRIMARY KEY (`legajo`));

CREATE TABLE `ejerciciosclase38`.`sucursales` (
  `nro_sucursal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `dirección` VARCHAR(45) NULL,
  `barrio` VARCHAR(45) NULL,
  PRIMARY KEY (`nro_sucursal`));

ALTER TABLE `ejerciciosclase38`.`empleados` 
ADD INDEX `nro_sucursal_idx` (`nro_sucursal` ASC) VISIBLE;
;
ALTER TABLE `ejerciciosclase38`.`empleados` 
ADD CONSTRAINT `nro_sucursal`
  FOREIGN KEY (`nro_sucursal`)
  REFERENCES `ejerciciosclase38`.`sucursales` (`nro_sucursal`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


INSERT INTO `ejerciciosclase38`.`sucursales`
(`nro_sucursal`,
`nombre`,
`dirección`,
`barrio`)
VALUES
(1, "Falabella", "Cochabamba 300", "Centro"),
(2, "Starbucks", "Rilla 3200", "Sur Zarita"),
(3, "Café Martinez", "Bartolomé 451", "Centro");

INSERT INTO `ejerciciosclase38`.`empleados`
(`legajo`,
`nombre`,
`apellido`,
`nro_sucursal`)
VALUES
(1, "Manuel", "Edamame", 1), (2, "Emanuel", "Tilla", 1), (3, "Karina", "Mayyek", 2), (4, "Maciel", "Bonfatti", 3);

SELECT * FROM empleados em
LEFT JOIN sucursales su
ON em.nro_sucursal=su.nro_sucursal;

SELECT * FROM empleados;
