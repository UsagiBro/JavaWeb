DROP TABLE users;
DROP TABLE categories;
DROP TABLE manufacturers;
DROP TABLE instruments;

CREATE TABLE users(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL,
    email VARCHAR(32) NOT NULL UNIQUE,
    news BOOLEAN NOT NULL DEFAULT FALSE,
    new_products BOOLEAN NOT NULL DEFAULT FALSE
);
INSERT INTO users (first_name, surname, password, email, news, new_products) VALUES ("Ivan", "Gladush", "ivann", "i@gladush.com", DEFAULT, DEFAULT);
INSERT INTO users (first_name, surname, password, email, news, new_products) VALUES ("Roman", "Piccolo", "romann", "r@piccolo.com", DEFAULT, DEFAULT);
INSERT INTO users (first_name, surname, password, email, news, new_products) VALUES ("Albert", "Albeert", "albeert", "a@lbert.com", DEFAULT, DEFAULT);

CREATE TABLE categories(
  id INT PRIMARY KEY NOT NULL,
  label VARCHAR(32)  NOT NULL
);

INSERT INTO categories(id, label) VALUES (1, "Guitar");
INSERT INTO categories(id, label) VALUES (2, "Bass");
INSERT INTO categories(id, label) VALUES (3, "Drums");

CREATE TABLE manufacturers(
  id INT PRIMARY KEY NOT NULL,
  title VARCHAR(32) NOT NULL
);
INSERT INTO manufacturers(id, title) VALUES (1, "Fender");
INSERT INTO manufacturers(id, title) VALUES (2, "Gibson");
INSERT INTO manufacturers(id, title) VALUES (3, "Tama");

CREATE TABLE instruments(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    ins_name VARCHAR(32) NOT NULL UNIQUE,
    price DECIMAL(8,2) NOT NULL,
    category_id INT NOT NULL,
    CONSTRAINT instruments_categories_category_id_fk FOREIGN KEY (category_id) REFERENCES categories (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE,
    manufacturer_id INT NOT NULL,
    CONSTRAINT instruments_manufacturers_manufacturer_id_fk FOREIGN KEY (manufacturer_id) REFERENCES manufacturers (id)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

INSERT INTO instruments (ins_name, price, category_id, manufacturer_id) VALUES ("Stratocaster", 450, 1, 1);
INSERT INTO instruments (ins_name, price, category_id, manufacturer_id) VALUES ("Epiphone", 300, 2, 2);
INSERT INTO instruments (ins_name, price, category_id, manufacturer_id) VALUES ("RhytmMate", 380, 3, 3);

