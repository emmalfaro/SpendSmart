

drop schema if exists spendsmart;
drop user if exists usuario_proyecto;

/* Creacion de la base de datos */
CREATE SCHEMA spendsmart;

/* Creacion del usuario y acceso a privilegios */
create user 'usuario_proyecto'@'%' identified by '12345678';
grant all privileges on spendsmart.* to 'usuario_proyecto'@'%';
flush privileges;

use spendsmart;

/* Creacion de la tabla usuarios */
CREATE TABLE usuarios (
    id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    contraseña VARCHAR(255) NOT NULL,
    fecha_registro DATETIME DEFAULT CURRENT_TIMESTAMP,
    activo boolean)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;
    
/* Creacion de la tabla roles con el nombre del rol que puede tener un usuario */
CREATE TABLE roles (
    id_rol INT AUTO_INCREMENT PRIMARY KEY,
    nombre_rol ENUM('usuario', 'administrador') NOT NULL
);

create table role (  
  rol varchar(20),
  PRIMARY KEY (rol)  
);

insert into role (rol) values ('ADMIN'), ('USER');

create table rol (
  id_rol INT NOT NULL AUTO_INCREMENT,
  nombre varchar(20),
  id_usuario int,
  PRIMARY KEY (id_rol))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

insert into rol (id_rol, nombre, id_usuario) values
 (1,'ADMIN',1), (2,'USER',1);


ALTER TABLE usuarios
ADD id_rol INT,
ADD CONSTRAINT fk_usuarios_roles FOREIGN KEY (id_rol) REFERENCES roles(id_rol);


/* Creacion de la tabla categorias */
CREATE TABLE categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre_categoria VARCHAR(100) NOT NULL)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO categorias (id_categoria, nombre_categoria) VALUES 
(1, 'Alimentación'), 
(2,'Transporte'),
(3,'Alquiler');

/* Creacion de la tabla presupuestos */
CREATE TABLE presupuestos (
    id_presupuesto INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    CONSTRAINT fk_presupuestos_categorias FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO presupuestos (id_presupuesto, id_categoria, monto) VALUES 
(1, 1, 300),
(2, 2, 50),
(3, 3, 300);


/* Creacion de la tabla gastos */
CREATE TABLE gastos (
    id_gasto INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria INT NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    descripcion TEXT,
    fecha_gasto DATETIME DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_gastos_categorias FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;

INSERT INTO gastos (id_gasto, id_categoria, monto, descripcion, fecha_gasto) VALUES 
(1, 1, 10, 'Supermercado', '2024-10-22'),
(2, 1, 20, 'Restaurante', '2024-10-26'),
(3, 2, 30, 'Gasolina', '2024-10-30');


/* Creacion de la tabla ingresos */
CREATE TABLE ingresos (
    id_ingreso INT AUTO_INCREMENT PRIMARY KEY,
    monto DECIMAL(10, 2) NOT NULL,
    descripcion TEXT,
    fecha_ingreso DATE
);

INSERT INTO ingresos (id_ingreso, monto, descripcion, fecha_ingreso) VALUES 
(1, 100, 'Reembolso', '2024-10-22'),
(2, 200, 'Bono', '2024-10-26'),
(3, 300, 'Sueldo', '2024-10-30');