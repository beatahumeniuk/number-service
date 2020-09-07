create sequence decerto.hibernate_sequence start 1 increment 1;

create table decerto.random_numberdb (
id int8 not null,
value numeric(19, 2) not null,
primary key (id)
);
