CREATE TABLE estado (
	id serial not null,
	uf varchar(2) not null,
	nome varchar(30) not null,
	CONSTRAINT PK_estado PRIMARY KEY(id),
	UNIQUE(uf)
);

INSERT INTO estado(uf, nome) VALUES ('AC', 'Acre');
INSERT INTO estado(uf, nome) VALUES ('AL', 'Alagoas');
INSERT INTO estado(uf, nome) VALUES ('AM', 'Amazonas');
INSERT INTO estado(uf, nome) VALUES ('AP', 'Amapá');
INSERT INTO estado(uf, nome) VALUES ('BA', 'Bahia');
INSERT INTO estado(uf, nome) VALUES ('CE', 'Ceará');
INSERT INTO estado(uf, nome) VALUES ('DF', 'Distrito Federal');
INSERT INTO estado(uf, nome) VALUES ('ES', 'Espirito Santo');
INSERT INTO estado(uf, nome) VALUES ('GO', 'Goiás');
INSERT INTO estado(uf, nome) VALUES ('MA', 'Maranhão');
INSERT INTO estado(uf, nome) VALUES ('MG', 'Minas Gerais');
INSERT INTO estado(uf, nome) VALUES ('MS', 'Mato Grosso do Sul');
INSERT INTO estado(uf, nome) VALUES ('MT', 'Mato Grosso');
INSERT INTO estado(uf, nome) VALUES ('PA', 'Pará');
INSERT INTO estado(uf, nome) VALUES ('PB', 'Paraíba');
INSERT INTO estado(uf, nome) VALUES ('PE', 'Pernambuco');
INSERT INTO estado(uf, nome) VALUES ('PI', 'Piauí');
INSERT INTO estado(uf, nome) VALUES ('PR', 'Paraná');
INSERT INTO estado(uf, nome) VALUES ('RJ', 'Rio de Janeiro');
INSERT INTO estado(uf, nome) VALUES ('RN', 'Rio Grande do Norte');
INSERT INTO estado(uf, nome) VALUES ('RO', 'Rondônia');
INSERT INTO estado(uf, nome) VALUES ('RR', 'Roraima');
INSERT INTO estado(uf, nome) VALUES ('RS', 'Rio Grande do Sul');
INSERT INTO estado(uf, nome) VALUES ('SC', 'Santa Catarina');
INSERT INTO estado(uf, nome) VALUES ('SE', 'Sergipe');
INSERT INTO estado(uf, nome) VALUES ('SP', 'São Paulo');
INSERT INTO estado(uf, nome) VALUES ('TO', 'Tocantins');
