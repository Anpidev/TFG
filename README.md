# Analítica Express - Backend (Spring Boot)

![Java](https://img.shields.io/badge/Java-17-blue.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.X-brightgreen.svg)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-green.svg)
![Spring Security](https://img.shields.io/badge/Spring%20Security-brightgreen.svg)
![H2 Database](https://img.shields.io/badge/H2%20Database-orange.svg)
![JWT](https://img.shields.io/badge/Auth-JWT-yellowgreen.svg)
![Maven](https://img.shields.io/badge/Maven-red.svg)

Este es el componente backend de la aplicación Analítica Express, desarrollado con Java y Spring Boot. Proporciona una API RESTful para gestionar usuarios, pacientes, médicos y análisis clínicos, incluyendo un robusto sistema de autenticación y autorización basado en JWT.

**Proyecto realizado por:** Ángela Ruiz Rivas
**Curso:** 2025 DAW - EUROFORMAC FP

**Repositorio Frontend:** [Enlace a repositorio del Frontend]([https://github.com/tu-usuario/analitica-express/tree/main/analitica-express-frontend](https://github.com/Anpidev/AnaliticaExpress)) 


---

## Tabla de Contenidos

1.  [Funcionalidades Principales](#funcionalidades-principales)
2.  [Tecnologías Utilizadas](#tecnologías-utilizadas)
3.  [Estructura del Proyecto Backend](#estructura-del-proyecto-backend)
4.  [Configuración y Puesta en Marcha](#configuración-y-puesta-en-marcha)
5.  [Endpoints de la API](#endpoints-de-la-api)
6.  [Seguridad](#seguridad)
7.  [Base de Datos](#base-de-datos)

---

## 1. Funcionalidades Principales

*   Gestión completa (CRUD) de Pacientes, Médicos y Analíticas.
*   Registro y autenticación de Usuarios (ADMIN, MEDICO, ENFERMERA).
*   Autorización basada en roles para el acceso a los endpoints.
*   Generación y validación de JSON Web Tokens (JWT) para sesiones stateless.
*   Transferencia de JWTs mediante cookies HTTP-only (`Secure`, `SameSite=None`).
*   Mapeo objeto-relacional con Spring Data JPA y Hibernate.
*   Configuración de CORS para permitir la comunicación con el frontend.

## 2. Tecnologías Utilizadas

*   Java 17
*   Spring Boot 3.x
*   Spring Data JPA
*   Spring Security
*   Hibernate (como implementación de JPA)
*   H2 Database (para desarrollo, con scripts `schema.sql` y `data.sql`)
*   JSON Web Tokens (JWT) - Librería `jjwt`
*   Maven (Gestor de dependencias)
*   Lombok (para reducir código boilerplate en modelos y DTOs - *opcional, si lo usaste*)

## 3. Estructura del Proyecto Backend

Localizado en la carpeta actual.

*   **`src/main/java/com/tfg/tfg`** (o la ruta de tu paquete principal):
    *   **`config`**: Configuración de seguridad (`SecurityConfig.java`).
    *   **`dto`**: Data Transfer Objects para la comunicación (`AnaliticaDto.java`, `NuevoUsuarioDto.java`, `LoginUserDto.java`, etc.).
    *   **`jwt`**: Clases relacionadas con JWT (`JwtUtil.java`, `JwtConfig.java`, `JwtEntryPoint.java`, `JwtAuthenticationFilter.java`).
    *   **`mappers`**: Conversores entre entidades JPA y DTOs (`AnaliticaMapper.java`).
    *   **`models`**: Entidades JPA (`Analitica.java`, `Paciente.java`, `Medico.java`, `Usuario.java`, `Rol.java`) y Enums (`EstadoAnalitica.java`, `Parametros.java`, `Roles.java`).
    *   **`repositories`**: Interfaces que extienden `JpaRepository` (`AnaliticaRepository.java`, `UsuarioRepository.java`, etc.).
    *   **`restcontrollers`**: Controladores REST que exponen los endpoints (`AnaliticaRestController.java`, `AuthController.java`, etc.).
    *   **`services`**: Clases de lógica de negocio (`AnaliticaService.java`, `UsuarioService.java`, `AuthService.java`, `CookieService.java`).
*   **`src/main/resources`**:
    *   **`application.properties`**: Configuración de la aplicación.
    *   **`schema.sql`**: Script DDL para la creación de tablas.
    *   **`data.sql`**: Script DML para la inserción de datos iniciales.
*   **`pom.xml`**: Archivo de configuración de Maven.

## 4. Configuración y Puesta en Marcha

### Prerrequisitos

*   JDK 17 o superior.
*   Maven 3.x.

### Ejecución

1.  Asegúrate de estar en el directorio raíz de este proyecto backend.
2.  Compilar y ejecutar la aplicación Spring Boot:
    *   Usando Maven: `mvn spring-boot:run`
    *   O importando el proyecto en tu IDE (Eclipse, IntelliJ) y ejecutando la clase principal `com.tfg.tfg.AnaliticaExpressApplication.java`.
3.  El backend estará disponible en `http://localhost:8080`.
4.  La consola H2 estará disponible en `http://localhost:8080/h2-console`.



## 5. Endpoints de la API

*   **Autenticación (`/webapi/auth`)**
    *   `POST /login`: Inicio de sesión de usuario.
    *   `POST /register`: Registro de nuevo usuario.
    *   `POST /logout`: Cierre de sesión.
    *   `GET /check-auth`: Verifica si el usuario está autenticado (protegido).
    *   `GET /usuario/detalles`: Obtiene detalles del usuario autenticado (protegido).
*   **Analíticas (`/webapi/analiticas`)** (Protegido según roles)
    *   `GET /`: Obtener todas las analíticas.
    *   `POST /`: Crear una nueva analítica.
    *   `PUT /{id}`: Actualizar el estado de una analítica.
    *   `DELETE /{id}`: Eliminar una analítica.
*   **Pacientes (`/webapi/pacientes`)** (Protegido según roles)
    *   `GET /`: Obtener todos los pacientes.
    *   `POST /`: Crear un nuevo paciente.
    *   `DELETE /{id}`: Eliminar un paciente.
*   **Médicos (`/webapi/medicos`)** (Protegido según roles)
    *   `GET /`: Obtener todos los médicos.
    *   `POST /`: Crear un nuevo médico.
    *   `DELETE /{id}`: Eliminar un médico.

_Para probar los endpoints, se recomienda usar una herramienta como Postman o Thunder Client._

## 6. Seguridad

*   Implementada con Spring Security.
*   Autenticación basada en JWT.
*   Los JWTs se transmiten mediante cookies HTTP-only (`Secure`, `SameSite=None`).
*   Autorización basada en roles (`ADMIN`, `MEDICO`, `ENFERMERA`).
*   Contraseñas hasheadas con `BCryptPasswordEncoder`.
*   Configuración de CORS para permitir peticiones del frontend (ej. `http://localhost:4200` y el dominio de Netlify).
*   Protección CSRF deshabilitada (común para APIs stateless).

## 7. Base de Datos

*   Se utiliza H2 Database en modo memoria para el entorno de desarrollo.
*   El esquema se crea automáticamente al iniciar la aplicación a partir de `schema.sql`.
*   Los datos iniciales se cargan desde `data.sql`.
*   Configuración de la base de datos en `application.properties`.

---
