
USE simplefit;


INSERT INTO `maquinas` (`maquinaid`, `nombre`, `musculo`, `imagen`) VALUES
  (1, 'Press de pecho sentado', 'Pecho', NULL),
  (2, 'Máquina de pecho inclinada', 'Pecho', NULL),
  (3, 'Fondos en paralelas', 'Pecho', NULL),
  (4, 'Máquina de pecho declinada', 'Pecho', NULL),
  (5, 'Press de banca con barra', 'Pecho', NULL),
  (6, 'Press con mancuernas', 'Pecho', NULL),
  (7, 'Peck Deck con doble polea alta', 'Pecho', NULL),
  (8, 'Pec Deck en maquina', 'Pecho', NULL),
  (9, 'Press inclinado en multipower', 'Pecho', NULL),
  (10, 'Press inclinado con mancuernas', 'Pecho', NULL);
  
INSERT INTO `maquinas` (`maquinaid`, `nombre`, `musculo`, `imagen`) VALUES
  (11, 'Pull over polea alta', 'Espalda', NULL),
  (12, 'Jalon prono', 'Espalda', NULL),
  (13, 'Jalon supino', 'Espalda', NULL),
  (14, 'Jalon neutro', 'Espalda', NULL),
  (15, 'Dominadas', 'Espalda', NULL),
  (16, 'Remo Barra T', 'Espalda', NULL),
  (17, 'Remo polea', 'Espalda', NULL),
  (18, 'Remo hammer', 'Espalda', NULL);
  
INSERT INTO `maquinas` (`maquinaid`, `nombre`, `musculo`, `imagen`) VALUES
  (19, 'Elevacion polea', 'Anterior', NULL),
  (20, 'Press militar maquina', 'Anterior', NULL),
  (21, 'Press militar mancuernas', 'Anterior', NULL),
  (22, 'Press militar multipower', 'Anterior', NULL);
  
INSERT INTO `maquinas` (`maquinaid`, `nombre`, `musculo`, `imagen`) VALUES
  (23, 'Elevacion lateral polea', 'Lateral', NULL),
  (24, 'Elevacion lateral polea unilateral', 'Lateral', NULL),
  (25, 'elevacion lateral mancuernas', 'Lateral', NULL),
  (26, 'Press militar multipower', 'Lateral', NULL);

INSERT INTO `maquinas` (`maquinaid`, `nombre`, `musculo`, `imagen`) VALUES
  (27, 'Extensión lateral doble en polea alta', 'Posterior', NULL),
  (28, 'Face pull polea', 'Posterior', NULL),
  (29, 'Aperturas Invertidas en máquina contractora', 'Posterior', NULL),
  (30, 'Elevacion posterior mancuernas', 'Posterior', NULL);
  
INSERT INTO `maquinas` (`maquinaid`, `nombre`, `musculo`, `imagen`) VALUES
  (31, 'Extension triceps en polea', 'Triceps', NULL),
  (32, 'Press frances', 'Triceps', NULL),
  (33, 'Extension triceps unilateral polea', 'Triceps', NULL);
  
INSERT INTO `maquinas` (`maquinaid`, `nombre`, `musculo`, `imagen`) VALUES
  (34, 'Curl mancuerna', 'Biceps', NULL),
  (35, 'Curl polea', 'Biceps', NULL),
  (36, 'Curl barra Z', 'Biceps', NULL),
  (37, 'Predicador Polea', 'Biceps', NULL);
  
INSERT INTO `maquinas` (`maquinaid`, `nombre`, `musculo`, `imagen`) VALUES
  (34, 'Curl mancuerna', 'Biceps', NULL),
  (35, 'Curl polea', 'Biceps', NULL),
  (36, 'Curl barra Z', 'Biceps', NULL),
  (37, 'Predicador Polea', 'Biceps', NULL);  

  

  
  
  
  
  
  SELECT * FROM maquinas;
  
  INSERT INTO `users`(`dni`,`nombre`,`email`,`password`,`sexo`,`edad`,`altura`,`peso`,`somatotipo`,`alergias`) VALUES
  ('50387394Y','Marcos Verdu Sanchez','markitos76449@gmail.com','1234','M',21,184,83,'ectomorfo',null);
  
  SELECT * FROM users;
  
  