CREATE DATABASE users;


CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(128) NOT NULL,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(56) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);
