CREATE DATABASE kidsLand CHARACTER SET 'utf8';
USE kidsLand;
CREATE TABLE person(
	name VARCHAR(20) NOT NULL,
	firstName VARCHAR(20),
	date_naissance DATETIME NOT NULL,
	email VARCHAR(40) NOT NULL,
	mdp VARCHAR(15) NOT NULL,
	employBool BOOLEAN NOT NULL,
	PRIMARY KEY (email)
);
CREATE TABLE ride(
	name VARCHAR(40) NOT NULL,
	placeNbr INT,
	placeNbrUse INT,
	price REAL,
	PRIMARY KEY(name)

)
ENGINE=INNODB;

INSERT INTO person(name,firstName,date_naissance,email,mdp,employBool) VALUES
('Jean', 'Dupont', '1961-02-26', 'jean.dupont23@gmail.com', 'DupJe89!',false),
('Lily', 'Morat', '2000-03-12', 'lily.morat@free.fr','jaimelavie1',false),
('John', 'Macdo', '1978-12-14', 'john.macdo1@hotmail.com','jmacdo123',false),
('Thomas', 'Shelby', '1999-07-21', 'Thomas.shelby@free.fr','dontfwpk',true),
('Ilana', 'jiste ', '2001-06-07', 'ilana.jiste@gmail.com','tchoin101',false),
('Pierre', 'Stone ', '2000-08-27', 'pierre.stone@outlook.fr','imlovinit121',false),
('Carole', 'yodja ', '1969-03-25', 'carole.yodja@free.fr','loveyoga09',false),
('Alexandre', 'Lacren ', '2005-09-19', 'alex.lacren@gmail.com','lacrem01',false),
('Theo', 'pirto ', '1998-01-20', 'theo.pirto@outlook.fr','pinkcat3',false),
('Shelly', 'colt ', '1980-02-12', 'Shelly.colt@free.fr','lovebrawlstar3',true);

INSERT INTO ride(name,placeNbr,placeNbrUse,price) VALUES
('TowerOfLove',100,50,8),
('Onceuponatime',120,120,7),
('SweetDream',80,68,10),
('CandyWorld',100,43,7),
('BoatTrip',60,55,10),
('CuteAnimals',30,28,10),
('EverythingIsSugar',130,97,5);
