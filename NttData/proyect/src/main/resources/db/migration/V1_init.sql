
create table person(
  codigo_persona varchar(40) primary key not null,
  primer_nombre varchar(10)not null,
  segundo_nombre varchar(30),
  primer_apellido varchar(10)not null,
  segundo_apellido varchar(30),
  edad int,
  estado_civil varchar(10),
  email varchar(50)not null,
  telefono_movil varchar(10),
  telefono_fijo varchar(10),
  estatus boolean not null,
  fecha_creacion timestamp not null,
  fecha_actualizacion timestamp
 );