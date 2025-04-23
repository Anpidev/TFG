-- Insertar roles
INSERT INTO rol (nombre) VALUES ('ENFERMERA'), ('MEDICO'), ('ADMIN');

-- Insertar usuarios (con rol_id en lugar de nombre)
INSERT INTO usuarios (nombre_usuario, rol_id, password) VALUES
('angela', 3,  '$2a$12$gvuYqiqw9gxYmxpEGiNXwehikUoAXaIgECAsrgyuvV7Vg4GEheGIu'), -- admin123
('medico1', 2, '$2a$12$gvuYqiqw9gxYmxpEGiNXwehikUoAXaIgECAsrgyuvV7Vg4GEheGIu'), -- medico123
('enfermera1', 1, '$2a$12$7sPOGDeBL5r9D8kolcm7PuS4/1PoJYCjTBMUluP9acQEXQYa0akkO'); -- enfermera123

-- Insertar pacientes 
INSERT INTO pacientes (dni, nombre, apellido, email, telefono) VALUES
('23456789B', 'Carlos', 'García', 'c.garcia@hospital.com', '55555555'),
('45678901D', 'Ana', 'Rodríguez', 'a.rodriguez@hospital.com', '55555555'),
('67890123F', 'Juan', 'Pérez', 'j.perez@gmail.com', '55555555'),
('67890124F', 'Maria', 'Pérez', 'm.perez@gmail.com', '55555555'),
('67890125F', 'Ana', 'Pérez', 'a.perez@gmail.com', '55555555');

-- Insertar medicos 
INSERT INTO medicos (colegiado, nombre, apellido, email, telefono) VALUES
('COL12345', 'Carlos', 'García', 'c.garcia@hospital.com', '55555555'),
('COL67890', 'Ana', 'Rodríguez', 'a.rodriguez@hospital.com', '55555555'),
('COL13579', 'Juan', 'Pérez', 'j.perez@gmail.com', '55555555'),
('COL24680', 'Maria', 'Pérez', 'm.perez@gmail.com', '55555555'),
('COL35791', 'Ana', 'Pérez', 'a.perez@gmail.com', '55555555');

-- Insertar analíticas 
INSERT INTO analiticas (paciente_id, medico_id, estado, observaciones) VALUES
(4, 2, 'CREADA', 'Control anual rutinario'),
(5, 2, 'CREADA', 'Control anual rutinario'),
(1, 2, 'CREADA', 'Control anual rutinario');

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