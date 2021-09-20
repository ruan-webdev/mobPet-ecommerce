CREATE DATABASE IF NOT EXISTS db_mobpet;
USE db_mobpet;

drop database db_mobpet;

CREATE TABLE IF NOT EXISTS users (
	usr_id int AUTO_INCREMENT NOT NULL,
    usr_email varchar(255),
    usr_password varchar(255),
    usr_role varchar(255),
	usr_is_active boolean,
    PRIMARY KEY (usr_id)
);

CREATE TABLE IF NOT EXISTS clients (
	cli_id int AUTO_INCREMENT NOT NULL,
    cli_name varchar(255),
    cli_cpf varchar(255),
    cli_date_of_birth date,
    cli_gender varchar(255),
    cli_usr_id int,
    PRIMARY KEY (cli_id),
    FOREIGN KEY (cli_usr_id) REFERENCES users(usr_id)
);

CREATE TABLE IF NOT EXISTS phones (
	pho_id int AUTO_INCREMENT NOT NULL,
    pho_number varchar(255),
    pho_cli_id int,
    pho_is_active boolean,
    PRIMARY KEY (pho_id),
    FOREIGN KEY (pho_cli_id) REFERENCES clients(cli_id)
);

CREATE TABLE IF NOT EXISTS credit_cards (
	crc_id int AUTO_INCREMENT NOT NULL,
    crc_number varchar(255),
    crc_expiration_date date,
    crc_security_code varchar(255),
    crc_printed_name varchar(255),
    crc_cli_id int,
    crc_is_active boolean,
    PRIMARY KEY (crc_id),
    FOREIGN KEY (crc_cli_id) REFERENCES clients(cli_id)
);

CREATE TABLE IF NOT EXISTS address (
	ads_id int AUTO_INCREMENT NOT NULL,
    ads_cep varchar(255),
    ads_public_place varchar(255),
    ads_number varchar(255),
    ads_complement varchar(255),
    ads_neighbourhood varchar(255),
    ads_city varchar(255),
    ads_state varchar(255),
    ads_type varchar(255),
    ads_cli_id int,
    ads_is_active boolean,
    PRIMARY KEY (ads_id),
    FOREIGN KEY (ads_cli_id) REFERENCES clients(cli_id)
);


select * from enderecos;

select * from clientes;

select * from usuarios;

select *  from cartoes_credito;

describe cartoes_credito;

describe enderecos;



