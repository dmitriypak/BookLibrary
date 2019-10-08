--DROP TABLE IF EXISTS author;
create table author
(
  id         bigserial not null
    constraint author_pk
      primary key,
  firstname  varchar(300),
  family     varchar(300),
  patronymic varchar(300)
);


create unique index author_id_uindex
  on author (id);

--DROP TABLE IF EXISTS book;
create table book
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
  on book (id);

--DROP TABLE IF EXISTS genre;
create table genre
(
  id   bigserial    not null
    constraint genre_pk
      primary key,
  name varchar(300) not null
);


create unique index genre_id_uindex
  on genre (id);

create table db_files
(
  id   bigserial not null
    constraint db_file_pk
      primary key,
  name varchar(255),
  type varchar(50)
);


create unique index db_file_id_uindex
  on db_files (id);

