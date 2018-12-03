CREATE table persons(
  id integer not null primary key,
  name varchar(255),
  location varchar(255),
  birth_date timestamp
);

insert into persons(id, name, location, birth_date)
values (1001, 'alexandre', 'curitiba-PR', sysdate());

insert into persons(id, name, location, birth_date)
values (1002, 'arthur', 'curitiba-PR', sysdate());

insert into persons(id, name, location, birth_date)
values (1003, 'dayane', 'curitiba-PR', sysdate());