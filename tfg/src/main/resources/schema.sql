-- Eliminación de tablas en orden correcto
DROP TABLE IF EXISTS parametros;
DROP TABLE IF EXISTS analiticas;
DROP TABLE IF EXISTS usuarios;

-- Tabla usuarios (corregido)
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(20) UNIQUE NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    tipo VARCHAR(10) NOT NULL CHECK (tipo IN ('paciente', 'enfermera', 'medico', 'admin')),
    email VARCHAR(100) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);

-- Tabla analiticas
CREATE TABLE analiticas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    medico_id INT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(10) DEFAULT 'creada' CHECK (estado IN ('creada', 'extraida', 'completada', 'cancelada')),
    observaciones VARCHAR(1000),
    FOREIGN KEY (paciente_id) REFERENCES usuarios(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES usuarios(id)
);

-- Tabla parametros
CREATE TABLE parametros (
    id INT PRIMARY KEY AUTO_INCREMENT,
    analitica_id INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    FOREIGN KEY (analitica_id) REFERENCES analiticas(id) ON DELETE CASCADE
);