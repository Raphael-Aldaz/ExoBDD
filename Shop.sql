DROP DATABASE IF EXISTS Shop;
CREATE DATABASE Shop;
USE Shop;

CREATE TABLE T_Articles (
	IdArticle int(4) PRIMARY KEY AUTO_INCREMENT,
	Description VARCHAR(30) NOT NULL,
	Brand VARCHAR(30) NOT NULL,
	UnitaryPrice float(8) NOT NULL
) ENGINE = InnoDB;

INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES ('Souris', 'Logitoch', 65);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Clavier', 'MicroHard', 49.5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Systeme d''exploitation', 'Fenetres Vistouillr' ,150);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Tapis souris', 'Chapeau Bleu',5);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Cle USB 8 TO', 'Syno', 8);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Laptop', 'PH', 1199);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('CD x 500', 'CETME', 250);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('DVD-R x 100', 'CETME' ,99);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('DVD-R x 100', 'CETME' ,105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Batterie Laptop', 'PH' ,80);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('Casque Audio', 'Syno',105);
INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES('WebCam', 'Logitoch',755);

SELECT * FROM T_Articles;

INSERT INTO T_Articles(Description, Brand, UnitaryPrice) VALUES ('Screen', 'Doll',340);
INSERT INTO T_Articles(Description, Brand, UnitaryPrice) VALUES ('PayStation', 'Syno',499);
INSERT INTO T_Articles(Description, Brand, UnitaryPrice) VALUES ('Lecteur K7', 'Syno',120);

UPDATE T_Articles SET Brand='Sony' WHERE IdArticle = 15;

SELECT * FROM T_Articles WHERE IdArticle = 15;

DELETE FROM T_Articles WHERE IdArticle = 14;

SELECT * From T_Articles WHERE IdArticle = 14;

SELECT * FROM T_Articles WHERE UnitaryPrice > 100;

SELECT * FROM T_Articles WHERE UnitaryPrice >50 && UnitaryPrice < 150;

SELECT * FROM T_Articles ORDER BY UnitaryPrice ASC;

SELECT Description FROM T_Articles;

SELECT * FROM T_Articles WHERE Description LIKE '% %';


CREATE TABLE T_Category (
	IdCategory int(4) PRIMARY KEY AUTO_INCREMENT,
	CatName VARCHAR(30) NOT NULL,
	CatDescription VARCHAR(30) NOT NULL 
) ENGINE = innoDB;
CREATE TABLE T_Users (
	IdUser int(4) PRIMARY KEY AUTO_INCREMENT,
	Login varchar(20) NOT NULL,
	Password varchar(20) NOT NULL
)ENGINE = InnoDB;


INSERT INTO T_Category(CatName, CatDescription) VALUES ('Materiel info', 'Tout materiel info');
INSERT INTO T_Category(CatName, CatDescription) VALUES ('PC', 'Ordinateur portable ou bureau');
INSERT INTO T_Category(CatName, CatDescription) VALUES ('Peripherique', 'Ecran, son, clavier, souris');
INSERT INTO T_Category(CatName, CatDescription) VALUES ('Console', 'Console de jeux');

ALTER TABLE T_Articles ADD COLUMN IdCategory INT(4);
ALTER TABLE T_Articles ADD FOREIGN KEY(IdCategory) REFERENCES T_Category(IdCategory);

SELECT * FROM T_Articles;
SELECT * FROM T_Category;

UPDATE T_Articles SET IdCategory= 3 WHERE IdArticle = 1;
UPDATE T_Articles SET IdCategory= 3 WHERE IdArticle = 2;
UPDATE T_Articles SET IdCategory= 1 WHERE IdArticle = 3;
UPDATE T_Articles SET IdCategory= 1 WHERE IdArticle = 4;
UPDATE T_Articles SET IdCategory= 2 WHERE IdArticle = 5;
UPDATE T_Articles SET IdCategory= 1 WHERE IdArticle = 6;
UPDATE T_Articles SET IdCategory= 1 WHERE IdArticle = 7;
UPDATE T_Articles SET IdCategory= 1 WHERE IdArticle = 8;
UPDATE T_Articles SET IdCategory= 1 WHERE IdArticle = 9;
UPDATE T_Articles SET IdCategory= 2 WHERE IdArticle = 10;
UPDATE T_Articles SET IdCategory= 3 WHERE IdArticle = 11;
UPDATE T_Articles SET IdCategory= 3 WHERE IdArticle = 12;
UPDATE T_Articles SET IdCategory= 3 WHERE IdArticle = 13;
UPDATE T_Articles SET IdCategory= 1 WHERE IdArticle = 15;

SELECT IdArticle, Description, Brand, UnitaryPrice, CatName  FROM T_Articles INNER JOIN T_Category on T_Articles.IdCategory = T_Category.IdCategory;

INSERT INTO T_Users(Login, Password) VALUES ('ARaphael', 'I<3SQL');
INSERT INTO T_Users(Login, Password) VALUES ('GNicolas', '12345');
INSERT INTO T_Users(Login, Password) VALUES ('PChristian', '54321');
INSERT INTO T_Users(Login, Password) VALUES ('AAlexandre', '147852');

