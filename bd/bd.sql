-- Criando a database
create database anuncios;

-- Criando tabela de anúncios
create table `anuncios`.`anuncio` (
    `nome` VARCHAR (45) NOT NULL,
    `cliente` VARCHAR (45) NOT NULL,
    `data_inicio` VARCHAR(45) NOT NULL,
    `data_termino` VARCHAR(45) NOT NULL,
    `investimento` FLOAT NOT NULL);   

SELECT * from anuncio;