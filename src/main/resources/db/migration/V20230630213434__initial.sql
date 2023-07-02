create table book
(
    id          serial not null,
    title       varchar(150) not null,
    description varchar(150),
    author      varchar(150) not null,
    constraint book_pk primary key (id)
);


insert into BOOK (id, title, author, description) values (1, 'Crime and Punishment', 'F. Dostoevsky', null);
insert into BOOK (id, title, author, description) values (2, 'Anna Karenina', 'L. Tolstoy', null);
insert into BOOK (id, title, author, description) values (3, 'The Brothers Karamazov', 'F. Dostoevsky', null);
insert into BOOK (id, title, author, description) values (4, 'War and Peace', 'L. Tolstoy', null);
insert into BOOK (id, title, author, description) values (5, 'Dead Souls', 'N. Gogol', null);

ALTER SEQUENCE book_id_seq RESTART WITH 6;