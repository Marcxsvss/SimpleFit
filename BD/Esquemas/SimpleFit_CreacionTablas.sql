 DROP DATABASE Simplefit;
-- Crea la base de datos si no existe
CREATE DATABASE IF NOT EXISTS SimpleFit;
-- Seleccionar la base de datos recién creada
USE SimpleFit;


CREATE TABLE `usuarios`(
  `email` varchar(255) PRIMARY KEY,
  `password` varchar(255),
  `dni` varchar(255) UNIQUE NOT NULL,
  `nombre` varchar(255),
  `altura` varchar(255),
  `peso` varchar(255),
  `edad` varchar(255),
  `sexo` varchar(255),
  `somatotipo` varchar(255),
  `rutinastate` int
);

CREATE TABLE `maquinas` (
  `maquinaid` int PRIMARY KEY,
  `nombre` varchar(255),
  `musculo` varchar(255),
  `imagen` longtext,
  `descripcion` varchar(255)
);

CREATE TABLE `rutinas` (
  `rutinaid` int PRIMARY KEY,
  `titulo` varchar(255),
  `descripcion` varchar(255),
  `frecuencia` int,
  `diasdescanso` int,
  `dificultad` varchar(255)
);


CREATE TABLE `consejos` (
  `consejoid` int PRIMARY KEY,
  `consejo` varchar(255)
);

CREATE TABLE `rutinamaquina` (
  `rutinaid` int,
  `maquinaid` int,
  PRIMARY KEY (`rutinaid`, `maquinaid`)
);

ALTER TABLE `rutinamaquina` ADD FOREIGN KEY (`rutinaid`) REFERENCES `rutinas` (`rutinaid`);

ALTER TABLE `rutinamaquina` ADD FOREIGN KEY (`maquinaid`) REFERENCES `maquinas` (`maquinaid`);

CREATE TABLE `usuariorutina` (
  `userid` varchar(255),
  `rutinaid` int,
  PRIMARY KEY (`userid`, `rutinaid`)
);

ALTER TABLE `usuariorutina` ADD FOREIGN KEY (`userid`) REFERENCES `usuarios` (`email`);

ALTER TABLE `usuariorutina` ADD FOREIGN KEY (`rutinaid`) REFERENCES `rutinas` (`rutinaid`);






