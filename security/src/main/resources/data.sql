INSERT INTO roles(id, name) VALUES(1, 'ROLE_ADMIN');
INSERT INTO roles(id,name) VALUES(2, 'ROLE_MODERATOR');
INSERT INTO roles(id,name) VALUES(3, 'ROLE_USER');

INSERT INTO users (id, email, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES (1, 'admin@admin.com', 'admin', 'admin', true, true, true, true);
INSERT INTO users (id, email, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES (2, 'moderator@moderator.com', 'moderator', 'moderator', true, true, true, true);
INSERT INTO users (id, email, username, password, account_non_expired, account_non_locked, credentials_non_expired, enabled)
VALUES (3, 'user@user.com', 'user', 'user', true, true, true, true);

INSERT INTO user_roles (user_id, role_id) VALUES (1, 1);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (1, 3);

INSERT INTO user_roles (user_id, role_id) VALUES (2, 2);
INSERT INTO user_roles (user_id, role_id) VALUES (2, 3);

INSERT INTO user_roles (user_id, role_id) VALUES (3, 3);
