create database demorelaciones;

use demorelaciones;

create table cliente(
  idcli integer not null primary key,
  nombre varchar(100) not null
);

create table factura(
  nro integer not null,
  importe decimal(10,2) not null,
  idcli integer not null,
  constraint pk_factura primary key(nro),
  constraint fk_cliente
     foreign key (idcli)
	 references cliente (idcli)
);
