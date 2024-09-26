/*
Realizar un programa con JDBC
● Elegir el motor de bases de datos que tengan instalado. (MySQL, Microsoft
SQL Server, PostgreSQL, SQLite, etc)
● Buscar en internet el conector y agregarlo al proyecto de Java (Intelli IDEA,
Eclipse o Netbeans)
● Crear un menú de opciones.
● De preferencia utilizar la clase BufferedReader para la lectura de datos por
teclado.
● Diseñar una base de datos para un sistema de seguimiento de proyectos.
Crea tablas para proyectos, empleados y tareas. Incluir atributos como
nombre del proyecto, fecha de inicio, nombre del empleado y estado de la
tarea.
● El programa JDBC debe conectarse a dicha base de datos.
● Insertar datos en las tablas
● Extraer los datos de las tablas y mostrarlos
*/

CREATE DATABASE ejercicio1_clase24;

# Proyectos
CREATE TABLE `ejercicio1_clase24`.`proyectos` (
  `id_proyecto` INT NOT NULL AUTO_INCREMENT,
  `nombre_proyecto` VARCHAR(45) NULL,
  `fecha_inicio` DATETIME NULL,
  PRIMARY KEY (`id_proyecto`));

# Empleados
CREATE TABLE `ejercicio1_clase24`.`empleados` (
  `id_empleado` INT NOT NULL AUTO_INCREMENT,
  `nombre_empleado` VARCHAR(45) NULL,
  PRIMARY KEY (`id_empleado`));
  
# proyectos_empleados
  CREATE TABLE `ejercicio1_clase24`.`proyectos_empleados` (
  `id_empleado` INT NOT NULL,
  `id_proyecto` INT NOT NULL,
  PRIMARY KEY (`id_empleado`, `id_proyecto`),
  INDEX `id_proyecto_idx` (`id_proyecto` ASC) VISIBLE,
  CONSTRAINT `id_empleado`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `ejercicio1_clase24`.`empleados` (`id_empleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_proyecto`
    FOREIGN KEY (`id_proyecto`)
    REFERENCES `ejercicio1_clase24`.`proyectos` (`id_proyecto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

# Tareas    
CREATE TABLE `ejercicio1_clase24`.`tareas` (
  `id_tarea` INT NOT NULL AUTO_INCREMENT,
  `estado_tarea` BIT NULL,
  PRIMARY KEY (`id_tarea`));

# FK empleados => tareas

ALTER TABLE `ejercicio1_clase24`.`empleados` 
ADD COLUMN `id_tarea` INT NULL AFTER `nombre_empleado`,
ADD INDEX `id_tarea_idx` (`id_tarea` ASC) VISIBLE;
;
ALTER TABLE `ejercicio1_clase24`.`empleados` 
ADD CONSTRAINT `id_tarea`
  FOREIGN KEY (`id_tarea`)
  REFERENCES `ejercicio1_clase24`.`tareas` (`id_tarea`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


  
  

