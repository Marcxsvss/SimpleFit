
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
  
  SELECT * FROM maquinas;
  
  INSERT INTO `users`(`dni`,`nombre`,`email`,`password`,`sexo`,`edad`,`altura`,`peso`,`somatotipo`,`alergias`) VALUES
  ('50387394Y','Marcos Verdu Sanchez','markitos76449@gmail.com','1234','M',21,184,83,'ectomorfo',null);
  
  SELECT * FROM users;
  
  