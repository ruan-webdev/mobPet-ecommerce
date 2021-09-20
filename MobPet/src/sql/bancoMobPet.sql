CREATE DATABASE IF NOT EXISTS db_mobpet;
USE db_mobpet;

drop database db_mobpet;

CREATE TABLE IF NOT EXISTS usuarios(
    usr_id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    usr_email            VARCHAR(30),
    usr_senha            VARCHAR(30),
    usr_tipo             VARCHAR(15),
    usr_ativo            Boolean
);

CREATE TABLE IF NOT EXISTS clientes (
    cli_id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    cli_nome             VARCHAR(60),
    cli_cpf              VARCHAR(14),
    cli_dt_nasc          DATE,
    cli_genero           VARCHAR(10),
    cli_tel              VARCHAR(15),
    cli_usr              INT,
    CONSTRAINT fk_cli_usr FOREIGN KEY ( cli_usr )REFERENCES usuarios ( usr_id )
);

CREATE TABLE IF NOT EXISTS produtos (
    pdt_id          INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pdt_nome        VARCHAR(50),
    pdt_marca       VARCHAR(50),
    pdt_categoria   VARCHAR(40),
    pdt_preco_unit  NUMERIC(8, 2),
    pdt_desc        VARCHAR(255),
    pdt_imagem      VARCHAR(255) 
);

CREATE TABLE IF NOT EXISTS trocas (
    trc_id               INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    trc_data             DATE,
    trc_status           VARCHAR(40),
    trc_desc             VARCHAR(255),
    trc_valor_diferenca  NUMERIC(8, 2)
);

CREATE TABLE IF NOT EXISTS cartoes_credito (
    cdc_id       INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    cdc_nome     VARCHAR(30),
    cdc_num      VARCHAR(20),
    cdc_codigo   VARCHAR(3),
    cdc_flag     VARCHAR(15),
    cdc_validade DATE,
    cdc_apelido  VARCHAR(50),
    cdc_cli_id   INT,
    CONSTRAINT fk_cdc_cli FOREIGN KEY ( cdc_cli_id )REFERENCES clientes ( cli_id )
);

CREATE TABLE IF NOT EXISTS enderecos (
    edr_id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    edr_estado       VARCHAR(30),
    edr_cep          VARCHAR(10),
    edr_cidade       VARCHAR(30),
    edr_bairro       VARCHAR(30),
    edr_logradouro   VARCHAR(30),
    edr_num          VARCHAR(5),
    edr_complemento  VARCHAR(255),
    edr_tipo         VARCHAR(30),
    edr_nome_perso   VARCHAR(255),
    edr_cli_id       INT,
    CONSTRAINT fk_edr_cli FOREIGN KEY ( edr_cli_id ) REFERENCES clientes ( cli_id )
);

CREATE TABLE IF NOT EXISTS pedidos (
    pdd_id           INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pdd_data         DATE,
    pdd_quant        NUMERIC(6),
    pdd_valor_total  NUMERIC(8, 2),
    pdd_status       VARCHAR(30),
    pdd_cli_id       INT,
    pdd_pdt_id       INT,
    pdd_trc_id       INT,
    CONSTRAINT fk_pdd_cli FOREIGN KEY ( pdd_cli_id ) REFERENCES clientes ( cli_id ),
    CONSTRAINT fk_pdd_pdt FOREIGN KEY ( pdd_pdt_id ) REFERENCES produtos ( pdt_id ),
    CONSTRAINT fk_pdd_trc FOREIGN KEY ( pdd_trc_id ) REFERENCES trocas ( trc_id )
);

select * from enderecos;

select * from clientes;

select * from usuarios;

select *  from cartoes_credito;

describe cartoes_credito;

describe enderecos;



