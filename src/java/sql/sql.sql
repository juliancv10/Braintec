create table ordern_cabecera(
id int NOT NULL AUTO_INCREMENT,
numdocumento int,
placavehiculo varchar(100),
observaciones varchar(1000),
monto decimal(20,3),
pagado bit,
referencia_pago varchar(200),
fecha DATETIME NOT NULL DEFAULT NOW(),
fecha_pago timestamp,
primary key(id),
foreign key(numdocumento) references tusuario(numdocumento),
foreign key(placavehiculo) references tvehiculo(placavehiculo)
);


create table orden_detalle(
 id int NOT NULL AUTO_INCREMENT,
 id_orden int,
 id_servicio int,
 cantidad int,
 precio_unitario decimal(20,3),
 total decimal(20,3),
 fecha DATETIME NOT NULL DEFAULT NOW(),
 primary key(id),
 foreign key(id_orden) references ordern_cabecera(id)
);


create table servicio(
 id int NOT NULL AUTO_INCREMENT,
codigo varchar(100),
 nombre varchar(200),
 precio decimal(20,3),
 producto bit,
 activo bit,
 stock int,
 id_categoria int,
 id_proveedor  int,
 fecha DATETIME NOT NULL DEFAULT NOW(),
 primary key(id),
 foreign key(id_categoria) references tcategoria(idcategoria),
 foreign key(id_proveedor) references tproveedor(idproveedor)
);

create table remision(
idremision int NOT NULL AUTO_INCREMENT,
numordenp int,
fecharem DATETIME NOT NULL DEFAULT NOW(),
observaciones varchar(1000),
estado bit,
primary key(idremision),
foreign key(numordenp) references ordenmaestro(idocabecera)
);


create table detalleremision(
 iddetrem int NOT NULL AUTO_INCREMENT,
 idrem int,
 idproducto int,
 cantidad int,
 fecha DATETIME NOT NULL DEFAULT NOW(),
 estado bit,
 primary key(iddetrem),
 foreign key(idrem) references remision(idremision),
 foreign key(idproducto) references tproserv(idps)	
);
