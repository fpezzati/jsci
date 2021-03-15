--liquibase formatted sql
--changeset francesco.pezzati:20210114:002
insert into users (id, name, surname, age) values ('952e0f85-74ce-44ed-9586-3a826896af62'::uuid, 'jim', 'bent', 1);
insert into users (id, name, surname, age) values ('c636b043-e16e-4f6d-977a-d9be5c237212'::uuid, 'joe', 'bent', 2);
insert into users (id, name, surname, age) values ('ebf4ce36-fe9c-4847-86a6-d977ebf4ee9f'::uuid, 'jay', 'bent', 3);
insert into users (id, name, surname, age) values ('efb51fa1-9cbd-4c0c-9141-86e5ca01bbed'::uuid, 'jeez', 'bent', 4);
insert into users (id, name, surname, age) values ('ef912759-fd40-4a9c-8965-df312bb3cbaa'::uuid, 'jack', 'bent', 5);
