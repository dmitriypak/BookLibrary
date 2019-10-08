INSERT INTO author (id, firstname, family, patronymic) VALUES (1, 'Корней', 'Чуковский', 'Иванович');
INSERT INTO author (id, firstname, family, patronymic) VALUES (2, 'Владимир', 'Маяковский', 'Владимирович');

INSERT INTO genre (id, name) VALUES (1, 'Фантастика');
INSERT INTO genre (id, name) VALUES (2, 'Детские сказки');
INSERT INTO genre (id, name) VALUES (3, 'Роман');
INSERT INTO genre (id, name) VALUES (4, 'Детектив');

INSERT INTO book (id, name, author_id, genre_id, release_year, cover_file_id) VALUES (1, 'Что такое хорошо и что такое плохо', 1, 2, 2000, null);
INSERT INTO book (id, name, author_id, genre_id, release_year, cover_file_id) VALUES (2, 'Мойдодыр', 2, 2, 2000, null);
INSERT INTO book (id, name, author_id, genre_id, release_year, cover_file_id) VALUES (3, 'Тараканище', 2, 2, 1980, null);

