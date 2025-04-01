-- Insertar usuarios 
INSERT INTO usuarios (dni, usuario, nombre, apellido, tipo, email, password) VALUES
('12345678A', 'ADMIN', 'Angela', 'Ruiz', 'ADMIN', 'admin@hospital.com', 'admin123'),
('23456789B', 'MEDICO1', 'Carlos', 'García', 'MEDICO', 'c.garcia@hospital.com', 'medico123'),
('45678901D', 'ENFERMERA1', 'Ana', 'Rodríguez', 'ENFERMERA', 'a.rodriguez@hospital.com', 'enfermera123'),
('67890123F', 'PACIENTE1', 'Juan', 'Pérez', 'PACIENTE', 'j.perez@gmail.com', 'paciente123'),
('67890124F', 'PACIENTE2', 'Maria', 'Pérez', 'PACIENTE', 'm.perez@gmail.com', 'paciente123'),
('67890125F', 'PACIENTE3', 'Ana', 'Pérez', 'PACIENTE', 'a.perez@gmail.com', 'paciente123');

-- Insertar analíticas 
INSERT INTO analiticas (paciente_id, medico_id, estado, observaciones) VALUES
(4, 2, 'CREADA', 'Control anual rutinario'),
(5, 2, 'CREADA', 'Control anual rutinario'),
(6, 2, 'CREADA', 'Control anual rutinario');

-- Insertar parámetros usando los valores del Enum 
INSERT INTO analiticas_parametros (analitica_id, parametro) VALUES
-- Parámetros para la primera analítica (id 1)
(1, 'HEMOGLOBINA'),
(1, 'HEMATOCRITO'),
(1, 'LEUCOCITOS'),
-- Parámetros para la segunda analítica (id 2)
(2, 'HEMOGLOBINA'),
(2, 'HEMATOCRITO'),
(2, 'LEUCOCITOS'),
-- Parámetros para la tercera analítica (id 3)
(3, 'HEMOGLOBINA'),
(3, 'HEMATOCRITO'),
(3, 'LEUCOCITOS');