CREATE TABLE email (
	id serial not null,
	email varchar(100) not null,
	idcliente int not null,
	CONSTRAINT PK_email PRIMARY KEY(id),
	CONSTRAINT FK_email_cliente FOREIGN KEY(idcliente) references cliente,
	UNIQUE(email)
);

insert into email (email, idcliente) values ('lbinion0@addtoany.com', 1);
insert into email (email, idcliente) values ('ithormann1@ted.com', 1);
insert into email (email, idcliente) values ('ddurdan2@joomla.org', 2);
insert into email (email, idcliente) values ('ccounter3@hhs.gov', 3);
insert into email (email, idcliente) values ('coxbrow4@umn.edu', 4);
insert into email (email, idcliente) values ('erix5@ask.com', 5);
insert into email (email, idcliente) values ('vredholls6@mediafire.com', 6);
insert into email (email, idcliente) values ('iscourfield7@columbia.edu', 6);
insert into email (email, idcliente) values ('kleckie8@comsenz.com', 7);
insert into email (email, idcliente) values ('btingley9@loc.gov', 7);
insert into email (email, idcliente) values ('eentwhistlea@fda.gov', 8);
insert into email (email, idcliente) values ('bripleyb@usatoday.com', 9);
insert into email (email, idcliente) values ('wkarolowskic@ask.com', 10);
insert into email (email, idcliente) values ('hblakelockd@reference.com', 11);
insert into email (email, idcliente) values ('scorragane@hc360.com', 11);
insert into email (email, idcliente) values ('lseppeyf@answers.com', 12);
insert into email (email, idcliente) values ('dtoffelg@go.com', 13);
insert into email (email, idcliente) values ('lkochlinh@360.cn', 14);
insert into email (email, idcliente) values ('bherrerosi@instagram.com', 15);
insert into email (email, idcliente) values ('ilightowlerj@ca.gov', 15);
