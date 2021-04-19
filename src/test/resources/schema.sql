DROP TABLE book_author IF EXISTS;
DROP TABLE book IF EXISTS;
DROP TABLE category IF EXISTS;
DROP TABLE author IF EXISTS;

create table category (
                          id bigserial not null primary key,
                          name varchar(25) not null unique
);

create table author (
                        id bigserial not null primary key,
                        name varchar(40) not null
);

create table book (
                      id bigserial not null primary key,
                      title varchar(150) not null,
                      description text not null,
                      category_id	bigint not null,
                      price decimal(5,2) not null,
                      constraint fk_book_category foreign key(category_id) references category(id)
);

create table book_author (
                             book_id bigint not null,
                             author_id bigint not null,
                             primary key (book_id, author_id),
                             constraint fk_book_author_book foreign key(book_id) references book(id),
                             constraint fk_book_author_author foreign key(author_id) references author(id)
);