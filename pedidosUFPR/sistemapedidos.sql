/*CREATE DATABASE sistemapedidos;
USE sistemapedidos;*/

CREATE TABLE cliente(
	id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    cpf VARCHAR(15),
    nome VARCHAR(30),
    sobrenome VARCHAR(50)
);

CREATE TABLE produto(
	id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descricao VARCHAR(45)
);

CREATE TABLE pedido(
	id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    date VARCHAR(10),
    id_cliente int,
    CONSTRAINT fk_pedido FOREIGN KEY (id_cliente)
    REFERENCES cliente(id)
);

CREATE TABLE item_pedido(
	id INTEGER PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_pedido INTEGER REFERENCES pedido(id),
    id_produto INTEGER REFERENCES produto(id),
    quantidade INTEGER DEFAULT '0'
);