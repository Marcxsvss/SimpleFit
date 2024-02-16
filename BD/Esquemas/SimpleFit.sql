-- Crea la base de datos si no existe
CREATE DATABASE IF NOT EXISTS SimpleFit;

-- Seleccionar la base de datos recién creada
USE SimpleFitmaquinas;


CREATE TABLE `users` (
  `dni` int PRIMARY KEY,
  `nombre` varchar(255),
  `email` varchar(255),
  `sexo` varchar(255),
  `edad` int,
  `altura` int,
  `alergias` varchar(255)
);

CREATE TABLE `maquinas` (
  `id` int PRIMARY KEY auto_increment,
  `nombre` varchar(255),
  `musculo` varchar(255),
  `imagen` blob
);

CREATE TABLE `rutinas` (
  `id` int PRIMARY KEY,
  `userid` int,
  `nombre` varchar(255),
  `frecuencia` int,
  `maquinas` longtext
);


