CREATE TABLE movies (
 id int unsigned AUTO_INCREMENT,
 title VARCHAR(20) NOT NULL,
 publication_year YEAR,
 PRIMARY KEY(id)
);
INSERT INTO movies (title,publication_year) VALUES ('Back to the Future',1985);
INSERT INTO movies (title,publication_year) VALUES ('Titanic',1997);


