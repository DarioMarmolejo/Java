# SERVICIO API REST Personas

## Setup base de datos en PostgreSQL

    Descargar imagen y crear contenedor de mariadb:10.3 en  una terminal de docker.

    sudo docker run --name ntt-postgres -p5432:5432 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=toor -d postgres:latest

### Crear conexion en algun gestor de BD (en este caso utilice dbeaver).

    Sobre la base de datos postgresql local ejecutar las siguientes instrucciones sql

    CREATE DATABASE ntt_personas;
    USE ntt_personas;
    CREATE USER 'contactsusr' IDENTIFIED BY 'c0nt4ctsus3r';
    GRANT ALL PRIVILEGES ON ntt_personas.* TO 'contactsusr'@'%' IDENTIFIED BY 'c0nt4ctsus3r';
    FLUSH PRIVILEGES;

    create database ntt_persons;

    create table person(
    codigo_persona varchar(40) primary key not null,
    primer_nombre varchar(10),
    segundo_nombre varchar(30),
    primer_apellido varchar(10),
    segundo_apellido varchar(30),
    edad int,
    estado_civil varchar(10),
    email varchar(50),
    telefono_movil int,
    telefono_fijo int,
    estatus boolean not null,
    fecha_creacion timestamp not null,
    fecha_actualizacion timestamp
    );

## Setup proyecto spring-boot gradle

    Para realizar este proyecto se utilizaron las siguientes herramientas y sus versiones.

### Herramientas - Versiones
    -----------------------------------------------------------
    openjdk version "1.8.0_342"
    -----------------------------------------------------------
    OpenJDK Runtime Environment (Temurin)(build 1.8.0_342-b07)
    OpenJDK 64-Bit Server VM (Temurin)(build 25.342-b07, mixed mode)

    ------------------------------------------------------------
    Gradle 7.5.1
    ------------------------------------------------------------
    Ant:          Apache Ant(TM) version 1.10.11 compiled on July 10 2021
    JVM:          1.8.0_342 (Temurin 25.342-b07)
    OS:           Linux 5.15.0-47-generic amd64

    ------------------------------------------------------------
    Docker version 20.10.18, build b40c2f6
    ------------------------------------------------------------
    docker pull postgres:14-bullseye

## Detalles del proyecto

    Los detalles especificos del proyecto se encontraran en el archivo build.gradle

### Requeridos
    Se requiere crear el dise??o de base de datos para guardar informaci??n de una persona con los iguientes datos:
    ??? C??digo persona
    ??? Primer Nombre
    ??? Segundo Nombre
    ??? Primer Apellido
    ??? Segundo Apellido
    ??? Edad
    ??? Estado civil
    ??? Email
    ??? Tel??fono M??vil
    ??? Tel??fono Fijo
    
    Considerar agregar campos de auditoria (Fecha de creaci??n, fecha de modificaci??n, estatus)
    Posteriormente se requiere crear un microservicio en Spring Framework utilizando dependencias de Gradle, el cual deber?? tener la capacidad de crear, modificar, eliminar y consultar la informaci??n del dise??o de base de datos que han creado en el paso anterior.

    Deber?? considerar a??adir la dependencia de Swagger.
    Deber?? considerar utilizar JPA.
    Deber?? considerar utilizar Java 8.

    Deber?? considerar para las operaciones de consultar que permita:
    ??? Buscar todos los registros activos
    ??? Buscar por c??digo de persona
    ??? Buscar por estado civil

    Al t??rmino del ejercicio deber?? proporcionar una colecci??n en postman con las pruebas que
    realiz??, el script de base de datos, y el microservicio en .zip
