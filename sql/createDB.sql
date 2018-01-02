DROP TABLE users;
CREATE TABLE users(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL,
    email VARCHAR(32) NOT NULL,
    news BOOLEAN NOT NULL DEFAULT FALSE,
    new_products BOOLEAN NOT NULL DEFAULT FALSE
);
INSERT INTO users (first_name, surname, password, email, news, new_products) VALUES ("Ivan", "Gladush", "ivann", "i@gladush.com", DEFAULT, DEFAULT);
INSERT INTO users (first_name, surname, password, email, news, new_products) VALUES ("Roman", "Piccolo", "romann", "r@piccolo.com", DEFAULT, DEFAULT);
INSERT INTO users (first_name, surname, password, email, news, new_products) VALUES ("Albert", "Albeert", "albeert", "a@lbert.com", DEFAULT, DEFAULT);