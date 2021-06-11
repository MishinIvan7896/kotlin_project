INSERT INTO users (username, password, role)
VALUES ('admin', '$2y$12$HhK2Qkldaa2lDsGku9ws1eiXLQwNCob7yEn1V.TPyaSP1yV1PFFXG', 'ADMIN');
INSERT INTO users (username, password, role)
VALUES ('Lol', '$2y$12$HhK2Qkldaa2lDsGku9ws1eiXLQwNCob7yEn1V.TPyaSP1yV1PFFXG', 'USER');
INSERT INTO users (username, password, role)
VALUES ('Kevin', '$2y$12$HhK2Qkldaa2lDsGku9ws1eiXLQwNCob7yEn1V.TPyaSP1yV1PFFXG', 'USER');

INSERT INTO posts (authorId, text)
VALUES (1 , 'This is my first post!');
INSERT INTO posts (authorId, text)
VALUES (1 , 'Test post');
INSERT INTO posts (authorId, text)
VALUES (1 , 'Hello my friends!');
INSERT INTO posts (authorId, text)
VALUES (2 , 'Im Kevin!');
INSERT INTO posts (authorId, text)
VALUES (2 , 'Bla bla bla');
INSERT INTO posts (authorId, text)
VALUES (2 , 'I was able to create this post!');