CREATE DATABASE kidsLand CHARACTER SET 'utf8';
USE kidsLand;
CREATE TABLE Person(
	name VARCHAR(20) NOT NULL,
	firstName VARCHAR(20),
	date_naissance DATETIME NOT NULL,
	email VARCHAR(40) NOT NULL,
	mdp VARCHAR(15) NOT NULL,
	employBool BOOLEAN NOT NULL,
	PRIMARY KEY (email)
)
ENGINE=INNODB;

CREATE TABLE Ride(
	name VARCHAR(40) NOT NULL,
	placeNbr INT,
	price DOUBLE,
	PRIMARY KEY(name)

)
ENGINE=INNODB;

CREATE TABLE Time(
	name VARCHAR(40) NOT NULL,
	date_m DATETIME NOT NULL,
	placeNbrUsed INT,
	price DOUBLE,
	PRIMARY KEY(name,date_m),
	CONSTRAINT fk_name_RideName
	FOREIGN KEY(name)
	REFERENCES Ride(name)
)
ENGINE=INNODB;

INSERT INTO Person(name,firstName,date_naissance,email,mdp,employBool) VALUES
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

INSERT INTO Ride(name,placeNbr,price) VALUES
('TowerOfLove',100,8),
('Onceuponatime',120,7),
('SweetDream',80,10),
('CandyWorld',100,7),
('BoatTrip',60,10),
('CuteAnimals',30,10),
('EverythingIsSugar',130,5);

INSERT INTO Time(name,date_m,placeNbrUsed,price) VALUES
('TowerOfLove','2020-11-25',20,8),
('TowerOfLove','2020-11-26',10,8),
('Onceuponatime','2020-11-25',50,7),
('CuteAnimals','2020-12-9',3,10),
('BoatTrip','2020-12-12',10,10),
('CandyWorld','2020-12-12',0,7);


