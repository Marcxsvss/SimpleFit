-- Crea la base de datos si no existe
CREATE DATABASE IF NOT EXISTS SimpleFit;
-- Seleccionar la base de datos recién creada
USE SimpleFit;





CREATE TABLE `users`(
  `dni` varchar(255) PRIMARY KEY,
  `nombre` varchar(255),
  `email` varchar(255) UNIQUE NOT NULL,
  `password` varchar(255),
  `sexo` varchar(255),
  `edad` int,
  `altura` int,
  `peso` int,
  `somatotipo` varchar(255),
  `lactosa` boolean,
  `gluten` boolean
);

CREATE TABLE `maquinas` (
  `maquinaid` int PRIMARY KEY,
  `nombre` varchar(255),
  `musculo` varchar(255),
  `imagen` blob,
  `descripcion` varchar(255)
);

CREATE TABLE `rutinas` (
  `rutinaid` int PRIMARY KEY,
  `userid` varchar(255),
  `nombre` varchar(255),
  `frecuencia` int,
  `duracion` int,
  `descripcion` varchar(255),
  `objetivo` varchar(255)
);

ALTER TABLE `rutinas` ADD FOREIGN KEY (`userid`) REFERENCES `users` (`dni`);

CREATE TABLE `dietas`(
  `dietaid` int PRIMARY KEY,
  `userid` varchar(255),
  `descripcion` longtext,
  `nombre` varchar(255),
  `objetivo` varchar(255),
  `calorias` int,
  `lactosa` boolean,
  `gluten` boolean
);

ALTER TABLE `dietas` ADD FOREIGN KEY (`userid`) REFERENCES `users` (`dni`);




CREATE TABLE `rutinamaquina` (
  `rutinaid` int,
  `maquinaid` int,
  PRIMARY KEY (`rutinaid`, `maquinaid`)
);

ALTER TABLE `rutinamaquina` ADD FOREIGN KEY (`rutinaid`) REFERENCES `rutinas` (`rutinaid`);

ALTER TABLE `rutinamaquina` ADD FOREIGN KEY (`maquinaid`) REFERENCES `maquinas` (`maquinaid`);




