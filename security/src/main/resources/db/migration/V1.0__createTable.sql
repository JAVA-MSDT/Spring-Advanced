----------------------------------------------------
------------------- BUILD TABLES -------------------
----------------------------------------------------
create table users (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
     username VARCHAR(255),
     password VARCHAR(255),
     email VARCHAR(255)
);

create table roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    role VARCHAR(255)
);

create table user_roles (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT NOT NULL,
    role_id INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (role_id) REFERENCES roles(id)
);


INSERT INTO users(id, username, password, email) VALUES (1, 'ADMIN', '{bcrypt}$2a$10$Hp1D3AGqRta6xg/4hq43NOQS.18fZ6IMX.9Hpxw9sEgKiB7Gv1aAy', 'email@email.com');
INSERT INTO users(id, username, password, email) VALUES (2, 'USER', '{bcrypt}$2a$10$zMIvUGQfFDxE6gqahhLng.XPZX9FJyu2PgvodWmwV56/GyAHMbHmy', 'email@email.com');
INSERT INTO users(id, username, password, email) VALUES (3, 'USERONE', '{bcrypt}$2a$10$zoj0.5ok/j4aaPvDhhFZ9uEvkESM9XiDM0j/dkzNUGbGzkoY4zeIm', 'email@email.com');
INSERT INTO users(id, username, password, email) VALUES (4, 'USERTWO', '{bcrypt}$2a$10$3E9q3YU8esj1Z5Jo7x1PsOeymCfsLCq5uk3C8pMcx/nzss77FEWJ6', 'email@email.com');

INSERT INTO roles(id, role) VALUES (1, 'ADMIN');
INSERT INTO roles(id, role) VALUES (2, 'USER');
INSERT INTO roles(id, role) VALUES (3, 'VIEW_INFO');
INSERT INTO roles(id, role) VALUES (4, 'VIEW_ADMIN');

INSERT INTO user_roles(id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO user_roles(id, user_id, role_id) VALUES (3, 1, 2);
INSERT INTO user_roles(id, user_id, role_id) VALUES (4, 1, 3);
INSERT INTO user_roles(id, user_id, role_id) VALUES (5, 1, 4);
INSERT INTO user_roles(id, user_id, role_id) VALUES (6, 2, 2);
INSERT INTO user_roles(id, user_id, role_id) VALUES (7, 2, 3);
INSERT INTO user_roles(id, user_id, role_id) VALUES (8, 3, 2);
INSERT INTO user_roles(id, user_id, role_id) VALUES (9, 3, 3);
INSERT INTO user_roles(id, user_id, role_id) VALUES (10, 4, 2);
INSERT INTO user_roles(id, user_id, role_id) VALUES (11, 4, 3);



