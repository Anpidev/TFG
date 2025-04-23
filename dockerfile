# Usa una imagen con Java y Maven
FROM maven:3.9.4-eclipse-temurin-17 AS build

# Crea directorio de trabajo
WORKDIR /app

# Copia todo el contenido al contenedor
COPY . .

# Da permisos al script de Maven wrapper
RUN chmod +x mvnw

# Compila el proyecto
RUN ./mvnw clean package -DskipTests

# Imagen final con solo el JAR
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copia el JAR desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expone el puerto (ajústalo al de tu app)
EXPOSE 8080

# Ejecuta el JAR
ENTRYPOINT ["java", "-jar", "app.jar"]
# En Dockerfile, después de compilar:
RUN rm -rf target
