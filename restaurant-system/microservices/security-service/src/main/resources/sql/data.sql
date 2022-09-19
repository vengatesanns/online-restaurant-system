-- user table
INSERT INTO users(account_non_expired
           ,account_non_locked
           ,credentials_non_expired
           ,email
           ,enabled
           ,first_name
           ,last_name
           ,password
           ,phone_number
           ,created_date_time
           ,updated_date_time)
           -- password - 123
     VALUES (1, 1, 1, 'vengat@gmail.com', 1, 'Vengat', 'N', '$2a$15$adeorGs5fr/eUWXov59DGuZ3N2Bkut7eDfkOSbdmoV9U7AnMtADtK', '9876543210',  CURRENT_TIMESTAMP,  CURRENT_TIMESTAMP);

INSERT INTO users(account_non_expired
           ,account_non_locked
           ,credentials_non_expired
           ,email
           ,enabled
           ,first_name
           ,last_name
           ,password
           ,phone_number
           ,created_date_time
           ,updated_date_time)
           -- password 12345
     VALUES (1, 1, 1, 'mano@gmail.com', 1, 'Mano', 'R', '$2a$15$GiYJXkWoPY4nWU44lQa3r.o3P6s2wm0FaoZU.ZvAiDnls2xqcty9i', '8787878787',  CURRENT_TIMESTAMP,  CURRENT_TIMESTAMP);


-- roles table
INSERT INTO roles(role_name) VALUES('ROLE_ADMIN');
INSERT INTO roles(role_name) VALUES('ROLE_CUSTOMER');
INSERT INTO roles(role_name) VALUES('ROLE_DEVELOPER');
INSERT INTO roles(role_name) VALUES('ROLE_QA');
INSERT INTO roles(role_name) VALUES('ROLE_GUEST');


-- user_roles table
INSERT INTO user_roles(user_id, role_id) values(1, 1);
INSERT INTO user_roles(user_id, role_id) values(2, 2);
