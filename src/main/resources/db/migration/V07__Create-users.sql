create table usuario (
	id serial not null,
	nome varchar(50) not null,
	senha varchar(150) not null,
	CONSTRAINT PK_usuario PRIMARY KEY(id)
);

create table permissao (
	id serial not null,
	descricao varchar(150) not null,
	CONSTRAINT PK_permissao PRIMARY KEY(id)
);

create table usuario_permissao (
	idusuario int not null,
	idpermissao int not null,
	CONSTRAINT PK_usuario_permissao PRIMARY KEY(idusuario, idpermissao),
	CONSTRAINT FK_usuario FOREIGN KEY(idusuario) references usuario,
	CONSTRAINT FK_permissao FOREIGN KEY(idpermissao) references permissao	
);

INSERT INTO usuario(nome, senha) VALUES ('admin', '$2a$10$flAeaRdAekIB340NYPUdy.g8aOc2QRdelATd2HxeOiPYzLLQXg3ES');
INSERT INTO usuario(nome, senha) VALUES ('comum', '$2a$10$flAeaRdAekIB340NYPUdy.g8aOc2QRdelATd2HxeOiPYzLLQXg3ES');

INSERT INTO permissao(descricao) VALUES ('ROLE_CADASTRAR_ESTADO');
INSERT INTO permissao(descricao) VALUES ('ROLE_PESQUISAR_ESTADO');
INSERT INTO permissao(descricao) VALUES ('ROLE_CADASTRAR_CIDADE');
INSERT INTO permissao(descricao) VALUES ('ROLE_PESQUISAR_CIDADE');
INSERT INTO permissao(descricao) VALUES ('ROLE_CADASTRAR_ENDERECO');
INSERT INTO permissao(descricao) VALUES ('ROLE_PESQUISAR_ENDERECO');
INSERT INTO permissao(descricao) VALUES ('ROLE_CADASTRAR_CLIENTE');
INSERT INTO permissao(descricao) VALUES ('ROLE_PESQUISAR_CLIENTE');
INSERT INTO permissao(descricao) VALUES ('ROLE_DELETAR_CLIENTE');
INSERT INTO permissao(descricao) VALUES ('ROLE_CADASTRAR_EMAIL');
INSERT INTO permissao(descricao) VALUES ('ROLE_PESQUISAR_EMAIL');
INSERT INTO permissao(descricao) VALUES ('ROLE_DELETAR_EMAIL');
INSERT INTO permissao(descricao) VALUES ('ROLE_CADASTRAR_TELEFONE');
INSERT INTO permissao(descricao) VALUES ('ROLE_PESQUISAR_TELEFONE');
INSERT INTO permissao(descricao) VALUES ('ROLE_DELETAR_TELEFONE');

INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 1);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 2);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 3);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 4);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 5);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 6);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 7);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 8);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 9);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 10);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 11);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 12);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 13);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 14);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (1, 15);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (2, 2);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (2, 4);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (2, 6);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (2, 8);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (2, 11);
INSERT INTO usuario_permissao(idusuario, idpermissao) VALUES (2, 14);
