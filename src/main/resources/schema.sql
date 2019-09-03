create schema prod;

create table prod.author
(
  id         bigserial not null
    constraint author_pk
      primary key,
  firstname  varchar(300),
  family     varchar(300),
  patronymic varchar(300)
);


create unique index author_id_uindex
  on prod.author (id);

create table prod.book
(
  id            bigserial not null
    constraint book_pk
      primary key,
  name          varchar(300),
  author_id     bigint,
  genre_id      bigint,
  release_year  integer,
  cover_file_id bigint
);

create unique index book_id_uindex
  on prod.book (id);

create table prod.genre
(
  id   bigserial    not null
    constraint genre_pk
      primary key,
  name varchar(300) not null
);


create unique index genre_id_uindex
  on prod.genre (id);

create table prod.db_files
(
  id   bigserial not null
    constraint db_file_pk
      primary key,
  name varchar(255),
  type varchar(50)
);


create unique index db_file_id_uindex
  on prod.db_files (id);

