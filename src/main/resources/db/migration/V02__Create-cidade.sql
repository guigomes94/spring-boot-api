CREATE TABLE cidade (
	id serial not null,
	nome varchar(100) not null,
	idUf int not null,
	CONSTRAINT PK_cidade PRIMARY KEY(id),
	CONSTRAINT FK_uf_cidade FOREIGN KEY(idUf) references estado
);

INSERT INTO cidade(nome, iduf) VALUES ('Rio Branco', 1);
INSERT INTO cidade(nome, iduf) VALUES ('Maceió', 2);
INSERT INTO cidade(nome, iduf) VALUES ('Manaus', 3);
INSERT INTO cidade(nome, iduf) VALUES ('Macapá', 4);
INSERT INTO cidade(nome, iduf) VALUES ('Salvador', 5);
INSERT INTO cidade(nome, iduf) VALUES ('Fortaleza', 6);
INSERT INTO cidade(nome, iduf) VALUES ('Brasília', 7);
INSERT INTO cidade(nome, iduf) VALUES ('Vitória', 8);
INSERT INTO cidade(nome, iduf) VALUES ('Goiânia', 9);
INSERT INTO cidade(nome, iduf) VALUES ('São Luís', 10);
INSERT INTO cidade(nome, iduf) VALUES ('Belo Horizonte', 11);
INSERT INTO cidade(nome, iduf) VALUES ('Campo Grande', 12);
INSERT INTO cidade(nome, iduf) VALUES ('Cuiabá', 13);
INSERT INTO cidade(nome, iduf) VALUES ('Belém', 14);
INSERT INTO cidade(nome, iduf) VALUES ('João Pessoa', 15);
INSERT INTO cidade(nome, iduf) VALUES ('Recife', 16);
INSERT INTO cidade(nome, iduf) VALUES ('Teresina', 17);
INSERT INTO cidade(nome, iduf) VALUES ('Curitiba', 18);
INSERT INTO cidade(nome, iduf) VALUES ('Rio de Janeiro', 19);
INSERT INTO cidade(nome, iduf) VALUES ('Natal', 20);
INSERT INTO cidade(nome, iduf) VALUES ('Porto Velho', 21);
INSERT INTO cidade(nome, iduf) VALUES ('Boa Vista', 22);
INSERT INTO cidade(nome, iduf) VALUES ('Porto Alegre', 23);
INSERT INTO cidade(nome, iduf) VALUES ('Florianópolis', 24);
INSERT INTO cidade(nome, iduf) VALUES ('Aracaju', 25);
INSERT INTO cidade(nome, iduf) VALUES ('São Paulo', 26);
INSERT INTO cidade(nome, iduf) VALUES ('Palmas', 27);
