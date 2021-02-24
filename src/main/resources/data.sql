DROP TABLE IF EXISTS users;

CREATE TABLE users (
                        id INT AUTO_INCREMENT  PRIMARY KEY,
                        username VARCHAR(250) NOT NULL,
                        password VARCHAR(250) NOT NULL
);

INSERT INTO users (username, password) VALUES
                        ('tomislav', 'tomo1234'),
                        ('pero', 'peric123');

DROP TABLE IF EXISTS bookmarks;

CREATE TABLE bookmarks (
                       id INT AUTO_INCREMENT  PRIMARY KEY,
                       uri VARCHAR(250) NOT NULL,
                       description VARCHAR(250) NOT NULL
);

INSERT INTO bookmarks (description, uri) VALUES
                        ('www.linkedin.com/in/tomislav1989', 'LinkedIn profile'),
                        ('facebook.com', 'Facebook profil');