# SERVICIO API REST Personas

## Setup base de datos en PostgreSQL

    Descargar imagen y crear contenedor de mariadb:10.3 en  una terminal de docker.

    sudo docker run --name ntt-postgres -p5432:5432 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=toor -d postgres:latest

    Crear conexion en algun gestor de BD (en este caso utilice dbeaver).

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

 