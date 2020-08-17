create database posjava;

create table secretario(
	id int not null primary key auto_increment,
	nome varchar(255) not null,
	idade int not null,
	registroGeral varchar(255) not null,
	numeroCpf varchar(255) not null,
	nomePai varchar(255),
	nomeMae varchar(255),
	registro varchar(255),
	nivelCargo varchar(255),
	experiencia varchar(255),
	login varchar(255),
	senha varchar(255)
);
