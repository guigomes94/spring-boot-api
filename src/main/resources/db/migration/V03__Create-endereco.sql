CREATE TABLE endereco (
	id serial not null,
	cep varchar(10) not null,
	logradouro varchar(255) not null,
	bairro varchar(100) not null,
	idCidade int not null,
	CONSTRAINT PK_endereco PRIMARY KEY(id),
	CONSTRAINT FK_end_cidade FOREIGN KEY(idCidade) references cidade
);

INSERT INTO endereco(cep, logradouro, bairro, idcidade) VALUES (58040490, 'Avenida Rui Barbosa', 'Torre', 15);
INSERT INTO endereco(cep, logradouro, bairro, idcidade) VALUES (58087100, 'Rua Doutor José Maia', 'Oitizeiro', 15);
INSERT INTO endereco(cep, logradouro, bairro, idcidade) VALUES (58085690, 'Rua Silvino Montenegro', 'Cruz das Armas', 15);
INSERT INTO endereco(cep, logradouro, bairro, idcidade) VALUES (58043002, 'Avenida Epitácio Pessoa', 'Miramar', 15);
INSERT INTO endereco(cep, logradouro, bairro, idcidade) VALUES (58010180, 'Rua da República', 'Centro', 15);
