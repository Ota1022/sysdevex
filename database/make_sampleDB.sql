\c postgres
DROP DATABASE IF EXISTS tbsystem;
DROP USER IF EXISTS student;
CREATE USER student WITH PASSWORD 'himitu';
CREATE DATABASE tbsystem OWNER student ENCODING 'UTF8';

\c tbsystem
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS state;
DROP TABLE IF EXISTS user_table;
DROP TABLE IF EXISTS textbook;
DROP TABLE IF EXISTS inventory;
DROP TABLE IF EXISTS sell;

CREATE TABLE category
(
  category_code INTEGER PRIMARY KEY,
  category_name TEXT
);

CREATE TABLE state
(
  state_code INTEGER PRIMARY KEY,
  state_name TEXT
);

CREATE TABLE state_inventory
(
  isin_inventory_code INTEGER PRIMARY KEY,
  isin_inventory_name TEXT
);

CREATE TABLE user_table
(
  user_id SERIAL PRIMARY KEY,
  name TEXT,
  email TEXT,
  password TEXT,
  address TEXT,
  tel TEXT,
  regist_date DATE,
  delete_date DATE,
  birthday DATE
);

CREATE TABLE textbook
(
  isbn TEXT PRIMARY KEY,
  category_code INTEGER,
  title TEXT,
  author TEXT,
  FOREIGN KEY(category_code) REFERENCES category(category_code)
);

CREATE TABLE inventory
(
  inventory_id SERIAL PRIMARY KEY,
  isbn TEXT,
  user_id INTEGER,
  state_code INTEGER,
  price INTEGER,
  isin_inventory_code INTEGER,
  note TEXT,
  inventory_regist_date DATE,
  inventory_update_date DATE,
  FOREIGN KEY(isbn) REFERENCES textbook(isbn),
  FOREIGN KEY(user_id) REFERENCES user_table(user_id),
  FOREIGN KEY(state_code) REFERENCES state(state_code),
  FOREIGN KEY(isin_inventory_code) REFERENCES state_inventory(isin_inventory_code)
);

CREATE TABLE sell
(
  receipt_id SERIAL PRIMARY KEY,
  user_id INTEGER,
  inventory_id INTEGER,
  sell_date DATE,
  FOREIGN KEY(user_id) REFERENCES user_table(user_id),
  FOREIGN KEY(inventory_id) REFERENCES inventory(inventory_id)
);

/*category*/
INSERT INTO category(category_code, category_name) VALUES(0, '???w???n');
INSERT INTO category(category_code, category_name) VALUES(1, '????w???n');
INSERT INTO category(category_code, category_name) VALUES(2, '?@?w???n');
INSERT INTO category(category_code, category_name) VALUES(3, '???w???n');
INSERT INTO category(category_code, category_name) VALUES(4, '?o??w???n');
INSERT INTO category(category_code, category_name) VALUES(5, '???w???n');
INSERT INTO category(category_code, category_name) VALUES(6, '??w???n');
INSERT INTO category(category_code, category_name) VALUES(7, '???w???n');
INSERT INTO category(category_code, category_name) VALUES(8, '??w???n');
INSERT INTO category(category_code, category_name) VALUES(9, '?H?w???n');
INSERT INTO category(category_code, category_name) VALUES(10, '?_?w???n');

/*state*/
INSERT INTO state(state_code, state_name) VALUES(0, '?V?i?A???g?p');
INSERT INTO state(state_code, state_name) VALUES(1, '???g?p????');
INSERT INTO state(state_code, state_name) VALUES(2, '???????????????');
INSERT INTO state(state_code, state_name) VALUES(3, '?????????');
INSERT INTO state(state_code, state_name) VALUES(4, '????????');
INSERT INTO state(state_code, state_name) VALUES(5, '?S??I?????????');

/*state_inventory*/
INSERT INTO state_inventory(isin_inventory_code, isin_inventory_name) VALUES(0, '??????');
INSERT INTO state_inventory(isin_inventory_code, isin_inventory_name) VALUES(1, '?o?i??');
INSERT INTO state_inventory(isin_inventory_code, isin_inventory_name) VALUES(2, '?o?i??~');

/*user table*/
/*admin*/
/*regist_date, delete_date, birthday????????*/
INSERT INTO user_table(name, email, password) VALUES('admin', 'admin@test.ac.jp', 'himitu');
/*user*/
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user1', 'user1@test.ac.jp', 'himitu', '?????s?V?h??', '03-1111-1111', '2023-06-20', '1999-01-01');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user2', 'user2@test.ac.jp', 'himitu', '?????s?i???', '03-1111-1111', '2023-07-19', '2000-01-01');

/*textbook*/
INSERT INTO textbook(isbn, category_code, title, author) VALUES('0000000000000', 0, 'test book 0', 'test author 0');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('1111111111111', 1, 'test book 1', 'test author 1');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('2222222222222', 2, 'test book 2', 'test author 2');

/*inventory*/
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('0000000000000', 2, 0, 500, 0, 'test (sold)', '2023-07-19', '2023-07-20');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('1111111111111', 2, 1, 1000, 1, 'test (not sold)', '2023-07-20', '2023-07-20');

/*sell*/
INSERT INTO sell(user_id, inventory_id, sell_date) VALUES(1, 1, '2023-07-20');

ALTER TABLE category OWNER TO student;
ALTER TABLE state OWNER TO student;
ALTER TABLE state_inventory OWNER TO student;
ALTER TABLE user_table OWNER TO student;
ALTER TABLE textbook OWNER TO student;
ALTER TABLE inventory OWNER TO student;
ALTER TABLE sell OWNER TO student;
