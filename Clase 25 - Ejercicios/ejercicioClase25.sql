/*
Comando maven para la 
app de
consola: mvn archetype:generate -DgroupId=com.clase25 -DartifactId=ejercicioClase25 -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
*/

/*
1) Realizar un programa con JDBC
● Elegir el motor de bases de datos que tengan instalado. (MySQL, Microsoft
SQL Server, PostgreSQL, SQLite, etc)
● Crear las tablas correspondiente a un sistema de gestión de eventos:
Eventos (número identificatorio del evento, nombre del evento, fecha y
lugar), Participantes (número identificatorio del participante, nombre,
correo electronico y telefono), Inscripciones a los eventos (numero
identificatorio de inscripcion del evento, numero identificador del evento,
número identificador del participante y fecha de inscripción), Organizadores
(número identificatorio del organizador, nombre, contacto y descripción de
la organización).
● Crear un menú de opciones
● Insertar datos en todas las tablas. Realizar las validaciones correspondientes.
● Utilizar la clase Scanner para la carga de datos por teclado.
● Consultar los datos de los eventos, participantes, inscripciones a eventos y
organizadores. Todo los datos en una consulta multitabla.
● Eliminar todos los datos de todas las tablas.
 */
 
 CREATE DATABASE ejercicio_clase25;
 
 CREATE TABLE `ejercicio_clase25`.`eventos` (
  `id_eventos` INT NOT NULL AUTO_INCREMENT,
  `nombre_evento` VARCHAR(45) NULL,
  `fecha` DATETIME NULL,
  `lugar` VARCHAR(45) NULL,
  PRIMARY KEY (`id_eventos`));
  
  CREATE TABLE `ejercicio_clase25`.`participantes` (
  `id_participante` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  PRIMARY KEY (`id_participante`));
  
  CREATE TABLE `ejercicio_clase25`.`inscripciones` (
  `id_inscripcion` INT NOT NULL AUTO_INCREMENT,
  `inscripcionescol` VARCHAR(45) NULL,
  `fecha_inscripcion` DATETIME NULL,
  PRIMARY KEY (`id_inscripcion`));

CREATE TABLE `ejercicio_clase25`.`eventos_inscripciones` (
  `id_evento` INT NOT NULL,
  `id_inscripto` INT NOT NULL,
  PRIMARY KEY (`id_evento`, `id_inscripto`),
  INDEX `id_inscripto_idx` (`id_inscripto` ASC) VISIBLE,
  CONSTRAINT `id_inscripto`
    FOREIGN KEY (`id_inscripto`)
    REFERENCES `ejercicio_clase25`.`inscripciones` (`id_inscripcion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `id_evento`
    FOREIGN KEY (`id_evento`)
    REFERENCES `ejercicio_clase25`.`eventos` (`id_eventos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
    CREATE TABLE `ejercicio_clase25`.`organizadores` (
  `id_organizador` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NULL,
  `contacto` VARCHAR(45) NULL,
  `desc_organizacion` VARCHAR(45) NULL,
  `id_evento` INT NULL,
  PRIMARY KEY (`id_organizador`),
  INDEX `id_evento_idx` (`id_evento` ASC) VISIBLE,
  CONSTRAINT `evento_id`
    FOREIGN KEY (`id_evento`)
    REFERENCES `ejercicio_clase25`.`eventos` (`id_eventos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

# FK participantes -> inscripciones
ALTER TABLE `ejercicio_clase25`.`participantes` 
ADD COLUMN `id_inscripcion` INT NULL AFTER `telefono`,
ADD INDEX `inscripcion_id_idx` (`id_inscripcion` ASC) VISIBLE;
;
ALTER TABLE `ejercicio_clase25`.`participantes` 
ADD CONSTRAINT `inscripcion_id`
  FOREIGN KEY (`id_inscripcion`)
  REFERENCES `ejercicio_clase25`.`inscripciones` (`id_inscripcion`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;


