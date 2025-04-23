-- Eliminación de tablas en orden correcto
DROP TABLE IF EXISTS analiticas_parametros; -- Nueva tabla para la relación muchos-a-muchos
DROP TABLE IF EXISTS analiticas;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS medicos;
DROP TABLE IF EXISTS pacientes;
DROP TABLE IF EXISTS rol;

-- Tabla medicos 
CREATE TABLE medicos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    colegiado VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20)
);

-- Tabla roles
CREATE TABLE rol (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL UNIQUE CHECK (nombre IN ('ENFERMERA', 'MEDICO', 'ADMIN'))
);

-- Tabla usuarios (modificada para usar ID de rol)
CREATE TABLE usuarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre_usuario VARCHAR(50) UNIQUE NOT NULL,
    rol_id INT NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (rol_id) REFERENCES rol(id)
);

-- Tabla pacientes 
CREATE TABLE pacientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    dni VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    telefono VARCHAR(20)
);

-- Tabla analiticas 
CREATE TABLE analiticas (
    id INT PRIMARY KEY AUTO_INCREMENT,
    paciente_id INT NOT NULL,
    medico_id INT NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(10) DEFAULT 'CREADA' CHECK (estado IN ('CREADA', 'EXTRAIDA', 'COMPLETADA', 'CANCELADA')),
    observaciones VARCHAR(1000),
    FOREIGN KEY (paciente_id) REFERENCES pacientes(id) ON DELETE CASCADE,
    FOREIGN KEY (medico_id) REFERENCES medicos(id)
);

-- Nueva tabla para almacenar la relación entre analíticas y parámetros (enums)
CREATE TABLE analiticas_parametros (
    analitica_id INT NOT NULL,
    parametro VARCHAR(50) NOT NULL,
    PRIMARY KEY (analitica_id, parametro),
    FOREIGN KEY (analitica_id) REFERENCES analiticas(id) ON DELETE CASCADE
);