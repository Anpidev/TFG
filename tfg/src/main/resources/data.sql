-- Insertar usuarios (corregido)
INSERT INTO usuarios (dni, usuario, nombre, apellido, tipo, email, password) VALUES
-- Administrador
('12345678A', 'ADMIN', 'Angela', 'Ruiz', 'admin', 'admin@hospital.com', 'admin123'),

-- Médicos
('23456789B', 'MEDICO1', 'Carlos', 'García', 'medico', 'c.garcia@hospital.com', 'medico123'),

-- Enfermeras
('45678901D', 'ENFERMERA1', 'Ana', 'Rodríguez', 'enfermera', 'a.rodriguez@hospital.com', 'enfermera123'),

-- Pacientes
('67890123F', 'PACIENTE1', 'Juan', 'Pérez', 'paciente', 'j.perez@gmail.com', 'paciente123'),
('67890124F', 'PACIENTE2', 'Maria', 'Pérez', 'paciente', 'm.perez@gmail.com', 'paciente123'),
('67890125F', 'PACIENTE3', 'Ana', 'Pérez', 'paciente', 'a.perez@gmail.com', 'paciente123');

-- Insertar analíticas
INSERT INTO analiticas (paciente_id, medico_id, estado, observaciones) VALUES
-- Analíticas para Juan Pérez (paciente_id 4), Maria Perez (id5) y Ana Perez (id6)
(4, 2, 'creada', 'Control anual rutinario'),
(5, 2, 'creada', 'Control anual rutinario'),
(6, 2, 'creada', 'Control anual rutinario');

-- Insertar parámetros para las analíticas
INSERT INTO parametros (analitica_id, nombre) VALUES
-- Parámetros para la primera analítica (id 1)
(1, 'Hemoglobina'),
(1, 'Hematocrito'),
(1, 'Leucocitos'),
-- Parámetros para la primera analítica (id 2)
(2, 'Hemoglobina'),
(2, 'Hematocrito'),
(2, 'Leucocitos'),
-- Parámetros para la primera analítica (id 3)
(3, 'Hemoglobina'),
(3, 'Hematocrito'),
(3, 'Leucocitos');