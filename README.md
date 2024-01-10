Aquí dejo el códgigo de la BD jaja:p
create database proyecto_final;

create table persona (

    id numeric(10, 0),
    nombre varchar(45) not null,
    apellidos varchar(45) not null,
    telefono varchar(45) not null,
    constraint persona_pk primary key(id)

);

create table paciente (

    id numeric(10, 0),
    edad numeric(2, 0) not null,
    peso float not null,
    talla float not null,
    padecimiento varchar(45) not null,
    num_estudio numeric(10, 0),

    constraint paciente_pk primary key(id),

    constraint paciente_persona_pk foreign key(id)
    references persona(id)

);
