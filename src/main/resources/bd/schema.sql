CREATE DATABASE adoptame;

CREATE TABLE rol(
    id_rol bigint AUTO_INCREMENT,
    nombre VARCHAR(120),
    PRIMARY KEY (id_rol)
);

CREATE TABLE usuario(
    correo VARCHAR(150) NOT NULL ,
    password_hash VARCHAR(100) NOT NULL,
    activo BOOLEAN,
    fecha_alta date,
    id_rol bigint,
    PRIMARY KEY (correo),
    FOREIGN KEY (id_rol) REFERENCES rol(id_rol)
);

CREATE TABLE albergue(
    id_albergue bigint AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(500) NOT NULL,
    contacto VARCHAR(100) NOT NULL,
    telefono VARCHAR(13) NOT NULL,
    esta_activo BOOLEAN DEFAULT 1,
    correo VARCHAR(100) UNIQUE NOT NULL,
    FOREIGN KEY (correo) REFERENCES usuario(correo)
);

CREATE TABLE mascota(
    id_mascota bigint NOT NULL AUTO_INCREMENT,
    tipo_mascota VARCHAR(20),
    nombre VARCHAR(100),
    sexo VARCHAR(20) NOT NULL ,
    fecha_nacimiento DATE,
    raza VARCHAR(50),
    descripcion VARCHAR(500) NOT NULL ,
    castrado BOOLEAN,
    fecha_registro DATE,
    disponible BOOLEAN,
    id_albergue bigint NOT NULL,
    PRIMARY KEY (id_mascota),
    FOREIGN KEY (id_albergue) REFERENCES albergue (id_albergue)
);