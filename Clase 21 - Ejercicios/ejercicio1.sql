CREATE DATABASE ejercicio1_clase21;

# A) Diseñar una tabla llamada Estudiantes que contenga los campos
# id_estudiante, nombre, edad y email, y otra tabla llamada Cursos que
# tenga id_curso, nombre_curso y duracion.

CREATE TABLE `ejercicio1_clase21`.`estudiantes` (
  `id_estudiante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `edad` INT NULL,
  `mail` VARCHAR(45) NULL,
  PRIMARY KEY (`id_estudiante`));

CREATE TABLE `ejercicio1_clase21`.`cursos` (
  `id_curso` INT NOT NULL AUTO_INCREMENT,
  `nombre__curso` VARCHAR(45) NULL,
  `duracion` VARCHAR(45) NULL,
  PRIMARY KEY (`id_curso`));
# B) Agregar un nuevo campo llamado fecha_inicio a la tabla Cursos y otro
# campo telefono a la tabla Estudiantes.

ALTER TABLE `ejercicio1_clase21`.`cursos` 
ADD COLUMN `fecha_inicio` DATETIME NULL AFTER `duracion`;

ALTER TABLE `ejercicio1_clase21`.`estudiantes` 
ADD COLUMN `telefono` VARCHAR(45) NULL AFTER `mail`;

# C) Agregar al menos dos estudiantes y dos cursos a sus respectivas tablas
# con datos relevantes.

USE ejercicio1_clase21;
SELECT * FROM ESTUDIANTES;

INSERT INTO `ejercicio1_clase21`.`estudiantes` 
(`id_estudiante`, `nombre`, `edad`, `mail`, `telefono`) 
VALUES 
(1, "Paula", 23, "aguerrero@gmail.com", "+54341374555"),
(2, "Juan", 22, "juan@gmail.com", "+54341234567"),
(3, "Maria", 25, "maria@gmail.com", "+54347654321");


INSERT INTO `ejercicio1_clase21`.`estudiantes` 
(`id_estudiante`, `nombre`, `edad`, `mail`, `telefono`) 
VALUES 
(1, "Paula", 23, "aguerrero@gmail.com", "+54341374555"),
(2, "Juan", 22, "juan@gmail.com", "+54341234567"),
(3, "Maria", 25, "maria@gmail.com", "+54347654321");

INSERT INTO `ejercicio1_clase21`.`cursos` 
(`id_curso`, `nombre__curso`, `duracion`, `fecha_inicio`) 
VALUES 
(1, "Java", "6 meses", '2023-05-06 00:00:00'), 
(2, "React", "3 meses", '2023-02-03 00:00:00'), 
(3, "Fundamentos de programacion", "8 meses", '2023-02-04 00:00:00');

# D) Cambiar la edad de un estudiante y la duración de un curso existente en
# las tablas.

SELECT * FROM ESTUDIANTES;

UPDATE `ejercicio1_clase21`.`estudiantes` 
SET `edad` = 25 
WHERE `id_estudiante` = 1;

UPDATE `ejercicio1_clase21`.`cursos`
SET`duracion` = "3 meses"
WHERE `id_curso` = 1;

# E) Seleccionar todos los estudiantes y mostrar sus nombres y sus correos
# electrónicos.

SELECT nombre, mail from estudiantes;

#f) Mostrar los nombres de los estudiantes junto con los cursos en los que
# están inscriptos, utilizando una tabla adicional Inscripciones que relaciona a
# los estudiantes con los cursos.

CREATE TABLE `ejercicio1_clase21`.`cursos_estudiantes` (
  `id_curso` INT NOT NULL,
  `id_estudiante` INT NOT NULL,
  PRIMARY KEY (`id_curso`, `id_estudiante`),
  INDEX `id_estudiante_idx` (`id_estudiante` ASC) VISIBLE,
  CONSTRAINT `id_curso`
    FOREIGN KEY (`id_curso`)
    REFERENCES `ejercicio1_clase21`.`cursos` (`id_curso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_estudiante`
    FOREIGN KEY (`id_estudiante`)
    REFERENCES `ejercicio1_clase21`.`estudiantes` (`id_estudiante`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

INSERT INTO `ejercicio1_clase21`.`cursos_estudiantes` 
(`id_curso`, `id_estudiante`) 
VALUES 
(1, 1),  -- Paula está inscrita en Java
(1, 2),  -- Juan está inscrito en Java
(2, 1);  -- Paula está inscrita en React

SELECT * FROM CURSOS;

SELECT e.nombre AS nombre_estudiante, c.nombre__curso AS nombre_curso
FROM cursos_estudiantes i
INNER JOIN estudiantes e ON i.id_estudiante = e.id_estudiante
INNER JOIN cursos c ON i.id_curso = c.id_curso;


