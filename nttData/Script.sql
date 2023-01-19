
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