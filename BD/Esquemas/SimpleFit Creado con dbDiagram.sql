-- Crea la base de datos si no existe
CREATE DATABASE IF NOT EXISTS SimpleFit2;

-- Seleccionar la base de datos recién creada
USE SimpleFit2;

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
  `maquinaid` int PRIMARY KEY,
  `nombre` varchar(255),
  `musculo` varchar(255),
  `imagen` blob
);

CREATE TABLE `rutinas` (
  `rutinaid` int PRIMARY KEY,
  `userid` int,
  `nombre` varchar(255),
  `frecuencia` int,
  `maquinas` longtext
);

CREATE TABLE `dietas` (
  `dietaid` int PRIMARY KEY,
  `userid` int,
  `descripcion` longtext,
  `nombre` varchar(255),
  `objetivo` varchar(255),
  `calorias` int,
  `duracion` int
);

CREATE TABLE `alimentos` (
  `alimentoid` int PRIMARY KEY,
  `Nombre` varchar(255),
  `Calorias` int,
  `Proteinas` int,
  `Grasas` int,
  `Carbohidratos` int
);

CREATE TABLE `dietaAlimento` (
  `dietaid` int,
  `alimentoid` int,
  `cantidad` int
);

CREATE TABLE `rutinaMaquina` (
  `rutinaid` int,
  `maquinaid` int
);

CREATE TABLE `dietaAlimento_alimentos` (
  `alimentoid` int,
  `alimentos_alimentoid` int,
  PRIMARY KEY (`dietaAlimento_alimentoid`, `alimentos_alimentoid`)
);

ALTER TABLE `dietaAlimento_alimentos` ADD FOREIGN KEY (`dietaAlimento_alimentoid`) REFERENCES `dietaAlimento` (`alimentoid`);

ALTER TABLE `dietaAlimento_alimentos` ADD FOREIGN KEY (`alimentos_alimentoid`) REFERENCES `alimentos` (`alimentoid`);


CREATE TABLE `rutinaMaquina_rutinas` (
  `rutinaMaquina_rutinaid` int,
  `rutinas_rutinaid` int,
  PRIMARY KEY (`rutinaMaquina_rutinaid`, `rutinas_rutinaid`)
);

ALTER TABLE `rutinaMaquina_rutinas` ADD FOREIGN KEY (`rutinaMaquina_rutinaid`) REFERENCES `rutinaMaquina` (`rutinaid`);

ALTER TABLE `rutinaMaquina_rutinas` ADD FOREIGN KEY (`rutinas_rutinaid`) REFERENCES `rutinas` (`rutinaid`);

