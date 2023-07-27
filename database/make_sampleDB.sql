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
INSERT INTO category(category_code, category_name) VALUES(0, 'ï∂äwïîån');
INSERT INTO category(category_code, category_name) VALUES(1, 'ã≥àÁäwïîån');
INSERT INTO category(category_code, category_name) VALUES(2, 'ñ@äwïîån');
INSERT INTO category(category_code, category_name) VALUES(3, 'é–âÔäwïîån');
INSERT INTO category(category_code, category_name) VALUES(4, 'åoçœäwïîån');
INSERT INTO category(category_code, category_name) VALUES(5, 'óùäwïîån');
INSERT INTO category(category_code, category_name) VALUES(6, 'à„äwïîån');
INSERT INTO category(category_code, category_name) VALUES(7, 'éïäwïîån');
INSERT INTO category(category_code, category_name) VALUES(8, 'ñÚäwïîån');
INSERT INTO category(category_code, category_name) VALUES(9, 'çHäwïîån');
INSERT INTO category(category_code, category_name) VALUES(10, 'î_äwïîån');

/*state*/
INSERT INTO state(state_code, state_name) VALUES(0, 'êVïiÅAñ¢égóp');
INSERT INTO state(state_code, state_name) VALUES(1, 'ñ¢égópÇ…ãﬂÇ¢');
INSERT INTO state(state_code, state_name) VALUES(2, 'ñ⁄óßÇ¡ÇΩèùÇ‚âòÇÍÇ»Çµ');
INSERT INTO state(state_code, state_name) VALUES(3, 'Ç‚Ç‚èùÇ‚âòÇÍÇ†ÇË');
INSERT INTO state(state_code, state_name) VALUES(4, 'èùÇ‚âòÇÍÇ†ÇË');
INSERT INTO state(state_code, state_name) VALUES(5, 'ëSëÃìIÇ…èÛë‘Ç™à´Ç¢');

/*state_inventory*/
INSERT INTO state_inventory(isin_inventory_code, isin_inventory_name) VALUES(0, 'îÑÇËêÿÇÍ');
INSERT INTO state_inventory(isin_inventory_code, isin_inventory_name) VALUES(1, 'èoïiíÜ');
INSERT INTO state_inventory(isin_inventory_code, isin_inventory_name) VALUES(2, 'èoïií‚é~');

/*user table*/
/*admin*/
/*regist_date, delete_date, birthdayÇÕì¸ÇÍÇƒÇ»Ç¢*/
INSERT INTO user_table(name, email, password) VALUES('admin', 'admin@test.ac.jp', 'himitu');
/*user*/
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user1', 'user1@test.ac.jp', 'himitu', 'ìåãûìsêVèhãÊ', '03-1111-1111', '2023-06-20', '1999-01-01');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user2', 'user2@test.ac.jp', 'himitu', 'ìåãûìsïiêÏãÊ', '03-1111-1111', '2023-07-19', '2000-01-01');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user3', 'user3@test.ac.jp', 'himitu', 'ëÂç„ï{ëÂç„és', '06-2222-2222', '2023-08-01', '2001-02-02');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user4', 'user4@test.ac.jp', 'himitu', 'ïüâ™åßïüâ™és', '092-3333-3333', '2023-08-02', '2002-03-03');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user5', 'user5@test.ac.jp', 'himitu', 'ñkäCìπéDñyés', '011-4444-4444', '2023-08-03', '2003-04-04');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user6', 'user6@test.ac.jp', 'himitu', 'à§ímåßñºå√âÆés', '052-5555-5555', '2023-08-04', '2004-05-05');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user7', 'user7@test.ac.jp', 'himitu', 'ê_ìﬁêÏåßâ°ïlés', '045-6666-6666', '2023-08-05', '2005-06-06');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user8', 'user8@test.ac.jp', 'himitu', 'çLìáåßçLìáés', '082-7777-7777', '2023-08-06', '2006-07-07');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user9', 'user9@test.ac.jp', 'himitu', 'ãûìsï{ãûìsés', '075-8888-8888', '2023-08-07', '2007-08-08');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user10', 'user10@test.ac.jp', 'himitu', 'ï∫å…åßê_åÀés', '078-9999-9999', '2023-08-08', '2008-09-09');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user11', 'user11@test.ac.jp', 'himitu', 'ã{èÈåßêÂë‰és', '022-1010-1010', '2023-08-09', '2009-10-10');
INSERT INTO user_table(name, email, password, address, tel, regist_date, birthday) VALUES('user12', 'user12@test.ac.jp', 'himitu', 'ê√â™åßê√â™és', '054-1111-1111', '2023-08-10', '2010-11-11');


/*textbook*/
INSERT INTO textbook(isbn, category_code, title, author) VALUES('0000000000000', 0, 'test book 0', 'test author 0');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('1111111111111', 1, 'test book 1', 'test author 1');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('2222222222222', 2, 'test book 2', 'test author 2');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('3333333333333', 3, 'test book 3', 'test author 3');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('4444444444444', 4, 'test book 4', 'test author 4');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('5555555555555', 5, 'test book 5', 'test author 5');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('6666666666666', 6, 'test book 6', 'test author 6');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('7777777777777', 7, 'test book 7', 'test author 7');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('8888888888888', 8, 'test book 8', 'test author 8');
INSERT INTO textbook(isbn, category_code, title, author) VALUES('9999999999999', 9, 'test book 9', 'test author 9');


/*inventory*/
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('0000000000000', 2, 0, 500, 0, 'test (sold)', '2023-07-19', '2023-07-20');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('1111111111111', 2, 1, 1000, 1, 'test (not sold)', '2023-07-20', '2023-07-20');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('3333333333333', 3, 1, 500, 1, 'test (not sold)', '2023-08-01', '2023-08-01');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('4444444444444', 4, 2, 800, 0, 'test (sold)', '2023-08-02', '2023-08-02');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('5555555555555', 5, 3, 750, 1, 'test (not sold)', '2023-08-03', '2023-08-03');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('6666666666666', 6, 2, 650, 0, 'test (sold)', '2023-08-04', '2023-08-04');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('7777777777777', 7, 1, 900, 1, 'test (not sold)', '2023-08-05', '2023-08-05');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('8888888888888', 8, 2, 600, 0, 'test (sold)', '2023-08-06', '2023-08-06');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('9999999999999', 9, 3, 850, 1, 'test (not sold)', '2023-08-07', '2023-08-07');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('1010101010101', 10, 1, 700, 1, 'test (not sold)', '2023-08-08', '2023-08-08');
INSERT INTO inventory(isbn, user_id, state_code, price, isin_inventory_code, note, inventory_regist_date, inventory_update_date) VALUES('1111111111112', 11, 2, 550, 0, 'test (sold)', '2023-08-09', '2023-08-09');

ALTER TABLE category OWNER TO student;
ALTER TABLE state OWNER TO student;
ALTER TABLE state_inventory OWNER TO student;
ALTER TABLE user_table OWNER TO student;
ALTER TABLE textbook OWNER TO student;
ALTER TABLE inventory OWNER TO student;
ALTER TABLE sell OWNER TO student;
