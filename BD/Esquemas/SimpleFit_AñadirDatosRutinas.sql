INSERT INTO usuarios (email, password, nombre, altura, peso, edad, sexo, somatotipo, rutinaState, acceso) VALUES
('marcos@gmail.com','12345678','marcos','184','84','16-28','Masculino','ectomorfo',2,1),
('ana@hotmail.com','password123','Ana','165','60','18-30','Femenino','mesomorfo',1,2),
('pablo@yahoo.com','mypassword','Pablo','175','78','20-32','Masculino','endomorfo',3,1),
('maria@gmail.com','maria1234','Maria','170','65','22-34','Femenino','ectomorfo',2,3),
('carlos@gmail.com','carlos987','Carlos','180','80','24-36','Masculino','mesomorfo',1,2),
('luisa@yahoo.com','luisa456','Luisa','160','55','26-38','Femenino','endomorfo',3,1),
('pedro@hotmail.com','pedro123','Pedro','185','90','28-40','Masculino','ectomorfo',2,3),
('sofia@gmail.com','sofia789','Sofia','175','68','18-30','Femenino','mesomorfo',1,2),
('juan@yahoo.com','juan321','Juan','170','75','20-32','Masculino','endomorfo',3,1),
('laura@hotmail.com','laura654','Laura','168','62','22-34','Femenino','ectomorfo',2,3),
('andres@gmail.com','andres987','Andres','178','85','24-36','Masculino','mesomorfo',1,2);

 INSERT INTO rutinas(rutinaid,titulo,descripcion,frecuencia,diasdescanso,dificultad)
 VALUES
(2, 'Bro Split', 'Se enfoca en un grupo muscular específico cada día.', 5, 2, 'Avanzada'),
(3, '5x5', 'Se centra en realizar 5 series de 5 repeticiones de ejercicios compuestos pesados.', 3, 4, 'Intermedia'),
(4, 'PHAT', 'Combina entrenamiento de potencia y entrenamiento de hipertrofia.', 5, 2, 'Avanzada'),
(5, 'PHUL', 'Similar a PHAT, pero se divide en entrenamientos de potencia y hipertrofia para la parte superior e inferior del cuerpo.', 4, 3, 'Avanzada'),
(6, 'FST-7', 'Se centra en estirar la fascia muscular para promover el crecimiento muscular.', 5, 2, 'Avanzada'),
(7, 'GVT', 'Implica hacer 10 series de 10 repeticiones para un ejercicio específico.', 3, 4, 'Avanzada'),
(9, 'Full Body Workout', 'Rutina para entrenar todo el cuerpo en cada sesión', 3, 2, 'Principiante'),
(10,'Split Routine','Es una forma común de dividir los grupos musculares a lo largo de la semana para darles tiempo para recuperarse y permitir un entrenamiento enfocado para cada grupo muscular. ',4,3,'Intermedio');
-- podria meter ppl, push pull legs
INSERT INTO usuariorutina (userid, rutinaid)
VALUES 
    ('marcos@gmail.com', 10),
    ('marcos@gmail.com', 2),
    ('marcos@gmail.com', 3);



