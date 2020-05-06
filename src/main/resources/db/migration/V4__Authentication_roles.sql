DROP TABLE IF EXISTS user_role;

CREATE TABLE user_role
(
    user_id int8 not null,
    roles   varchar(32)
);

ALTER TABLE IF EXISTS user_role
    ADD CONSTRAINT user_role_user_fk FOREIGN KEY (user_id) REFERENCES users;

INSERT INTO user_role(user_id, roles)
    SELECT id, 'USER' FROM users WHERE login != 'dev';

INSERT INTO users (id, login, password, fio)
    SELECT nextval('users_sequence'), 'dev', 'dev', 'dev'
    WHERE
    NOT EXISTS (SELECT 1 FROM users WHERE login='dev');

INSERT INTO user_role (user_id, roles) values ((select id from users where login = 'dev'), 'DEV');