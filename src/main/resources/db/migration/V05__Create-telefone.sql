CREATE TABLE telefone (
	id serial not null,
	tipo varchar(20) not null,
	numero varchar(15) not null,
	idcliente int not null,
	CONSTRAINT PK_fone PRIMARY KEY(id),
	CONSTRAINT FK_tel_cliente FOREIGN KEY(idcliente) references cliente
);

INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83996286546', 1);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83988409039', 2);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('RESIDENCIAL', '8332341225', 2);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('COMERCIAL', '8330034000', 3);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83996286558', 4);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83996286590', 5);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('RESIDENCIAL', '8333225002', 5);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83996285004', 6);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('COMERCIAL', '8340405522', 7);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('COMERCIAL', '8340528862', 8);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83993374512', 9);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83991501416', 10);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('RESIDENCIAL', '8342600245', 10);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('COMERCIAL', '8335528091', 10);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83999999090', 11);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83994905180', 12);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('RESIDENCIAL', '8333546266', 13);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83996286599', 14);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('CELULAR', '83996286588', 15);
INSERT INTO telefone(tipo, numero, idcliente) VALUES ('RESIDENCIAL', '83933334422', 15);
