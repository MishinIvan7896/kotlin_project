create table if not exists users
(
    id       int unsigned auto_increment primary key,
    username varchar(255),
    password varchar(255),
    role     varchar(255)
);

create table if not exists posts
(
    `id`       int unsigned auto_increment primary key,
    `authorId` int,
    `text`     varchar(255)
)