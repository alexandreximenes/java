create database CRUD;

use CRUD;

create table Aluno (

   
matriculaID int NOT NULL AUTO_INCREMENT,
   
cpf varchar(14),
   
nome varchar(100),
   
idade int,
   
primary key(matriculaID)
);



create table Endereco(
   
enderecoID int NOT NULL AUTO_INCREMENT,
   
logradouro varchar(150),
   
numero int, 
   
complemento varchar(150),
   
bairro varchar(150),
  
cep varchar(10),
cidade varchar(100),
    
estado varchar(100),
   
matriculaID int,
   
primary key(enderecoID),
   
foreign key(matriculaID) 
references Aluno(matriculaID)
);



select * from Aluno;
select * from Endereco;
INSERT INTO Aluno (cpf, nome, idade) values ("00000","alex",15);
SELECT enderecoID, logradouro, numero, complemento, bairro, matriculaID FROM Endereco WHERE enderecoID = 6;