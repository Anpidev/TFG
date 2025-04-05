-- Insertar usuarios 
INSERT INTO usuarios (dni, usuario, nombre, apellido, rol, email, password) VALUES
('12345678A', 'ADMIN', 'Angela', 'Ruiz', 'ADMIN', 'admin@hospital.com', '$2a$12$LWXqvwqrn38/FaU7berc4ueeKLCsSsz1VuAoR1JhlKkyqAgljERWK'),
('23456789B', 'MEDICO1', 'Carlos', 'García', 'MEDICO', 'c.garcia@hospital.com', '$2a$12$gvuYqiqw9gxYmxpEGiNXwehikUoAXaIgECAsrgyuvV7Vg4GEheGIu'),
('45678901D', 'ENFERMERA1', 'Ana', 'Rodríguez', 'ENFERMERA', 'a.rodriguez@hospital.com', '$2a$12$7sPOGDeBL5r9D8kolcm7PuS4/1PoJYCjTBMUluP9acQEXQYa0akkO'),
('67890123F', 'PACIENTE1', 'Juan', 'Pérez', 'PACIENTE', 'j.perez@gmail.com', '$2a$12$nbBT3EuHV2idgBqO5y8CneOgGGY9x2oKTw4REt7m0gar27rmvi8hm'),
('67890124F', 'PACIENTE2', 'Maria', 'Pérez', 'PACIENTE', 'm.perez@gmail.com', '$2a$12$nbBT3EuHV2idgBqO5y8CneOgGGY9x2oKTw4REt7m0gar27rmvi8hm'),
('67890125F', 'PACIENTE3', 'Ana', 'Pérez', 'PACIENTE', 'a.perez@gmail.com', '$2a$12$nbBT3EuHV2idgBqO5y8CneOgGGY9x2oKTw4REt7m0gar27rmvi8hm');

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