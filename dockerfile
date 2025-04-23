# Etapa 1: Construcción con Maven + Java
FROM maven:3.9.3-eclipse-temurin-17 AS build

# Establecer JAVA_HOME en la etapa de construcción
ENV JAVA_HOME=/usr/local/openjdk-17
ENV PATH=$JAVA_HOME/bin:$PATH

WORKDIR /app
# Copiar el directorio tfg al contenedor
COPY tfg /app/tfg

# Construir el proyecto con Maven
RUN cd tfg && mvn clean package -DskipTests

# Etapa 2: Solo Java para ejecutar
FROM eclipse-temurin:17-jdk

# Establecer JAVA_HOME en la etapa de ejecución
ENV JAVA_HOME=/usr/local/openjdk-17
ENV PATH=$JAVA_HOME/bin:$PATH

WORKDIR /app
# Copiar el archivo JAR del contenedor de construcción
COPY --from=build /app/tfg/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
