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


INSERT INTO users(id, username, password, email) VALUES (1, 'ADMIN', 'admin', 'email@email.com');
INSERT INTO users(id, username, password, email) VALUES (2, 'USER', 'user', 'email@email.com');
INSERT INTO users(id, username, password, email) VALUES (3, 'USERONE', 'userone', 'email@email.com');
INSERT INTO users(id, username, password, email) VALUES (4, 'USERTWO', 'usertwo', 'email@email.com');

INSERT INTO roles(id, role) VALUES (1, 'ADMIN');
INSERT INTO roles(id, role) VALUES (2, 'USER');
INSERT INTO roles(id, role) VALUES (3, 'VIEW_INFO');
INSERT INTO roles(id, role) VALUES (4, 'VIEW_ADMIN');

INSERT INTO user_roles(id, user_id, role_id) VALUES (1, 1, 1);
INSERT INTO user_roles(id, user_id, role_id) VALUES (2, 1, 4);
INSERT INTO user_roles(id, user_id, role_id) VALUES (3, 2, 2);
INSERT INTO user_roles(id, user_id, role_id) VALUES (4, 3, 3);
INSERT INTO user_roles(id, user_id, role_id) VALUES (5, 4, 3);



