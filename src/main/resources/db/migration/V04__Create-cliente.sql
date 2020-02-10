CREATE TABLE cliente (
	id serial not null,
	nome varchar(100) not null,
	cpf varchar(15) not null,
	idendereco int not null,
	UNIQUE(cpf),
	CONSTRAINT PK_cliente PRIMARY KEY(id),
	CONSTRAINT FK_cliente_end FOREIGN KEY(idendereco) references endereco
);

INSERT INTO cliente(nome, cpf, idendereco) VALUES ('José da Silva', '10050040011', 2);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Maria da Luz', '10050040012', 5);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Solange Maria', '10050040013', 1);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Juliana Gomez', '10050040014', 3);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Guilherme Fernandes', '10050040015', 4);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Carol Viana', '10050040016', 1);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('George Lucas', '10050040017', 5);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Anakin Skywalker', '10050040018', 3);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Tom Hanks', '10050040019', 4);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Vin Diesel', '10050040050', 5);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Danilo Gentili', '10050040054', 1);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Romário', '10050040055', 2);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Michael Douglas', '10050040060', 1);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Amy Lee', '10050040063', 3);
INSERT INTO cliente(nome, cpf, idendereco) VALUES ('Simone Simmons', '10050040074', 2);