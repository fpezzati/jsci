--liquibase formatted sql
--changeset francesco.pezzati:20210301:001
create table kind (
  id UUID,
  name varchar(50) NOT NULL,
  CONSTRAINT kind_pkey PRIMARY KEY (id)
);

create table user_kind (
  userid UUID,
  kindid UUID,
  CONSTRAINT user_kind_uniqueness UNIQUE (userid, kindid),
  CONSTRAINT user_fkey FOREIGN KEY (userid) REFERENCES users(id),
  CONSTRAINT kind_fkey FOREIGN KEY (kindid) REFERENCES kind(id)
);

insert into kind (id, name) values ('0591432c-b239-4f4c-bf1f-4b5d3b48ae91', 'admin');
insert into kind (id, name) values ('5c506f61-cca1-4a3d-a21c-89ef60696f92', 'member');
insert into kind (id, name) values ('3ac4c0aa-15f1-43f1-b146-27f8f4e006ca', 'guest');