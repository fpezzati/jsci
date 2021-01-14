--liquibase formatted sql
--changeset francesco.pezzati:20210114:001
create table users (
  id UUID primary key,
  name varchar(50) NOT NULL,
  surname varchar(50) NOT NULL,
  age integer,
  since date NOT NULL DEFAULT
);