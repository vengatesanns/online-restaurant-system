-- Drop tables
drop table user_roles;
drop table users;
drop table roles;

-- user table
CREATE TABLE users(
	id bigint IDENTITY(1,1) NOT NULL,
	account_non_expired bit NOT NULL,
	account_non_locked bit NOT NULL,
	credentials_non_expired bit NOT NULL,
	email varchar(255) NOT NULL,
	enabled bit NOT NULL,
	first_name varchar(255) NULL,
	last_name varchar(255) NULL,
	password varchar(255) NOT NULL,
	phone_number varchar(10) NOT NULL,
	created_date_time datetime NULL,
	updated_date_time datetime NULL
	PRIMARY KEY(id)
	);

-- roles table
CREATE TABLE roles(
    id bigint IDENTITY(1,1) NOT NULL,
    role_name varchar(255) NOT NULL,
    created_date_time datetime NULL,
    updated_date_time datetime NULL
    PRIMARY KEY(id)
);

-- user_roles table
CREATE TABLE user_roles(
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
	FOREIGN KEY(user_id) REFERENCES users(id),
	FOREIGN KEY(role_id) REFERENCES roles(id)
);