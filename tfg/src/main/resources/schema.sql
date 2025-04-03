-- Eliminación de tablas en orden correcto
DROP TABLE IF EXISTS analiticas_parametros; -- Nueva tabla para la relación muchos-a-muchos
DROP TABLE IF EXISTS analiticas;
DROP TABLE IF EXISTS usuarios;

-- Eliminación de tablas en orden correcto
DROP TABLE IF EXISTS analiticas_parametros;
DROP TABLE IF EXISTS analiticas;
DROP TABLE IF EXISTS usuarios;

-- Tabla usuarios (sin cambios)
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(20) UNIQUE NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    rol VARCHAR(10) NOT NULL CHECK (rol IN ('PACIENTE', 'ENFERMERA', 'MEDICO', 'ADMIN')),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Tabla analiticas (sin cambios)
CREATE TABLE analiticas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    medico_id INT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(10) DEFAULT 'CREADA' CHECK (estado IN ('CREADA', 'EXTRAIDA', 'COMPLETADA', 'CANCELADA')),
    observaciones VARCHAR(1000),
    FOREIGN KEY (paciente_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES usuarios(id)
);

-- Nueva tabla para almacenar la relación entre analíticas y parámetros (enums)
CREATE TABLE analiticas_parametros (
    analitica_id INT NOT NULL,
    parametro VARCHAR(50) NOT NULL,
    PRIMARY KEY (analitica_id, parametro),
    FOREIGN KEY (analitica_id) REFERENCES analiticas(id) ON DELETE CASCADE
);

