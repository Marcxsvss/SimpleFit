-- DROP DATABASE SimpleFit;
-- Crea la base de datos si no existe
CREATE DATABASE IF NOT EXISTS simplefit;
-- Seleccionar la base de datos recién creada
USE simplefit;


CREATE TABLE `usuarios`(
  `email` varchar(255) PRIMARY KEY,
  `password` varchar(255),
  `nombre` varchar(255),
  `altura` varchar(255),
  `peso` varchar(255),
  `edad` varchar(255),
  `sexo` varchar(255),
  `somatotipo` varchar(255),
  `rutinastate` int,
  `acceso` int
);


CREATE TABLE `maquinas` (
  `maquinaid` int PRIMARY KEY,
  `nombre` varchar(255),
  `musculo` varchar(255),
  `imagen` longtext,
  `descripcion` varchar(255)
);
select * from maquinas;
CREATE TABLE `rutinas` (
  `rutinaid` int PRIMARY KEY,
  `titulo` varchar(255),
  `descripcion` varchar(255),
  `frecuencia` int,
  `diasdescanso` int,
  `dificultad` varchar(255)
);
select * from rutinas;

CREATE TABLE `consejos` (
  `consejoid` int PRIMARY KEY,
  `consejo` varchar(255)
);
select * from rutinas;
CREATE TABLE `rutinamaquina` (
  `rutinaid` int,
  `maquinaid` int,
  `dia` varchar(255),
  PRIMARY KEY (`rutinaid`, `maquinaid`, `dia`)
);
ALTER TABLE `rutinamaquina` ADD FOREIGN KEY (`rutinaid`) REFERENCES `rutinas` (`rutinaid`);
ALTER TABLE `rutinamaquina` ADD FOREIGN KEY (`maquinaid`) REFERENCES `maquinas` (`maquinaid`);

select * from rutinamaquina;

CREATE TABLE `usuariorutina` (
  `userid` varchar(255),
  `rutinaid` int,
  PRIMARY KEY (`userid`, `rutinaid`)
);
select * from usuariorutina;

ALTER TABLE `usuariorutina` ADD FOREIGN KEY (`userid`) REFERENCES `usuarios` (`email`);

ALTER TABLE `usuariorutina` ADD FOREIGN KEY (`rutinaid`) REFERENCES `rutinas` (`rutinaid`);






