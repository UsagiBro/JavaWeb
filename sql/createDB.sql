DROP TABLE users;
CREATE TABLE users(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    firs_name VARCHAR(32) NOT NULL,
    surname VARCHAR(32) NOT NULL,
    password VARCHAR(32) NOT NULL,
    email VARCHAR(32) NOT NULL,
    news BOOLEAN NOT NULL DEFAULT FALSE,
    new_products BOOLEAN NOT NULL DEFAULT FALSE
);
INSERT INTO users (name,surname,password,email,) VALUES ("Ivan", "Gladush", "ivann", "i@gladush.com", FALSE, FALSE);
INSERT INTO users VALUES ("Roman", "Piccolo", "romann", "r@piccolo.com", FALSE, FALSE);
INSERT INTO users VALUES ("Albert", "Albeert", "albeert", "a@lbert.com", FALSE, FALSE);