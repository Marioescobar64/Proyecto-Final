drop database if exists proyectoFinal;
create database proyectoFinal;
use proyectoFinal;

create table Usuarios (
	idUsuario int auto_increment,
	nombre varchar(100) not null,
	apellido varchar(128) not null,
	email varchar(100) not null unique,
	password varchar(255) not null,
	constraint pk_usuarios primary key (idUsuario)
);

create table tipo_sangre (
    id_tipo_sangre int auto_increment,
    grupo_sanguineo varchar(3) not null,
    factor_rh char(1) not null,
    constraint chk_factor_rh check (factor_rh in ('+', '-')),
    constraint pk_tipo_sangre primary key (id_tipo_sangre)
);

create table donador (
    id_donador int auto_increment,
    nombres varchar(100) not null,
    apellidos varchar(100) not null,
    dpi varchar(13) not null unique,
    fecha_nacimiento date not null,
    genero varchar(10) not null,
    telefono varchar(8),
    email varchar(100),
    direccion varchar(255),
    id_tipo_sangre int,
    fecha_ultima_donacion date,
    elegible boolean default true,
    fecha_creacion timestamp default current_timestamp,
    constraint pk_donador primary key (id_donador),
    foreign key (id_tipo_sangre) references tipo_sangre(id_tipo_sangre)
);

create table centro (
    id_centro int auto_increment,
    nombre varchar(150) not null,
    direccion varchar(255) not null,
    telefono varchar(8),
    constraint pk_centro primary key (id_centro)
);

create table jornada (
    id_jornada int auto_increment,
    nombre_jornada varchar(200) not null,
    fecha_inicio date not null,
    fecha_fin date not null,
    id_centro int,
    meta_unidades int,
    constraint pk_jornada primary key (id_jornada),
    foreign key (id_centro) references centro(id_centro)
);

create table enfermero (
    id_enfermero int auto_increment,
    nombres varchar(100) not null,
    apellidos varchar(100) not null,
    colegiado varchar(20),
    telefono varchar(8),
    email varchar(100),
    id_centro int,
    constraint pk_enfermero primary key (id_enfermero),
    foreign key (id_centro) references centro(id_centro)
);

create table cita (
    id_cita int auto_increment,
    fecha_cita date not null,
    hora time not null,
    estado varchar(20) default 'Programada',
    id_donador int,
    id_centro int,
    id_jornada int null,
    constraint pk_cita primary key (id_cita),
    foreign key (id_donador) references donador(id_donador),
    foreign key (id_centro) references centro(id_centro),
    foreign key (id_jornada) references jornada(id_jornada)
);

create table donacion (
    id_donacion int auto_increment,
    id_cita int,
    id_enfermero int,
    fecha_donacion timestamp default current_timestamp,
    volumen_ml int not null,
    resultado_serologia varchar(20),
    codigo_unidad varchar(50) unique,
    constraint pk_donacion primary key (id_donacion),
    foreign key (id_cita) references cita(id_cita),
    foreign key (id_enfermero) references enfermero(id_enfermero)
);




