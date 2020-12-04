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

CREATE TABLE History(
id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
customerEmail VARCHAR(40) NOT NULL,
rideName VARCHAR(40) NOT NULL,
dateOfRide DATETIME NOT NULL,
numberOfTickets INT DEFAULT 1,
price DOUBLE,
CONSTRAINT fk_Person_History FOREIGN KEY(customerEmail) REFERENCES Person(email),
CONSTRAINT fk_Ride_Histoty FOREIGN KEY(rideName) REFERENCES Ride(name)
)ENGINE=INNODB;

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
('Shelly', 'colt ', '1980-02-12', 'Shelly.colt@free.fr','lovebrawlstar3',true),
('Guest' , 'Guest' , '2000-10-10', 'Guest' , 'Guest' ,false);

INSERT INTO Ride(name,placeNbr,price) VALUES
('TowerOfLove',100,8),
('Onceuponatime',120,7),
('SweetDream',80,10),
('CandyWorld',100,7),
('BoatTrip',60,10),
('CuteAnimals',30,10),
('EverythingIsSugar',130,5);

INSERT INTO Time(name,date_m,placeNbrUsed,price) VALUES
('TowerOfLove','2020-12-18',0,8),
('Onceuponatime','2020-12-18',0,7),
('CuteAnimals','2020-12-18',0,10),
('BoatTrip','2020-12-18',0,10),
('CandyWorld','2020-12-18',0,7),
('SweetDream','2020-12-18',0,10),
('EverythingIsSugar','2020-12-18',0,5),
('CuteAnimals','2020-12-19',02,9),
('BoatTrip','2020-12-19',0,9),
('CandyWorld','2020-12-19',0,6),
('SweetDream','2020-12-19',0,9),
('EverythingIsSugar','2020-12-19',0,4),
('TowerOfLove','2020-12-21',0,8),
('Onceuponatime','2020-12-21',0,7),
('CuteAnimals','2020-12-21',0,10),
('CandyWorld','2020-12-21',0,7),
('SweetDream','2020-12-21',0,10),
('TowerOfLove','2020-12-23',0,8),
('Onceuponatime','2020-12-23',0,7),
('CuteAnimals','2020-12-23',0,10),
('BoatTrip','2020-12-23',0,10),
('CandyWorld','2020-12-23',0,7),
('EverythingIsSugar','2020-12-23',0,5),
('TowerOfLove','2020-12-26',0,7),
('Onceuponatime','2020-12-26',0,6),
('CuteAnimals','2020-12-26',0,9),
('BoatTrip','2020-12-26',0,9),
('CandyWorld','2020-12-26',0,6),
('SweetDream','2020-12-26',0,9),
('EverythingIsSugar','2020-12-26',0,4),
('TowerOfLove','2020-12-28',0,8),
('CuteAnimals','2020-12-28',0,10),
('BoatTrip','2020-12-28',0,10),
('SweetDream','2020-12-28',0,10),
('EverythingIsSugar','2020-12-28',0,5),
('TowerOfLove','2020-12-30',0,8),
('Onceuponatime','2020-12-30',0,7),
('CuteAnimals','2020-12-30',0,10),
('EverythingIsSugar','2020-12-30',0,5),
('CuteAnimals','2020-12-31',0,10),
('BoatTrip','2020-12-31',0,10),
('SweetDream','2020-12-31',0,10),
('EverythingIsSugar','2020-12-31',0,5),
('TowerOfLove','2021-01-03',0,8),
('Onceuponatime','2021-01-03',0,7),
('CuteAnimals','2021-01-03',0,10),
('BoatTrip','2021-01-03',0,10),
('CandyWorld','2021-01-03',0,7),
('SweetDream','2021-01-03',0,10),
('EverythingIsSugar','2021-01-03',0,5),
('TowerOfLove','2021-01-05',0,8),
('BoatTrip','2021-01-05',0,9),
('CandyWorld','2021-01-05',0,6),
('EverythingIsSugar','2021-01-05',0,4),
('TowerOfLove','2021-01-07',0,8),
('Onceuponatime','2021-01-07',0,8),
('CuteAnimals','2021-01-07',0,10),
('BoatTrip','2021-01-07',0,10),
('CandyWorld','2021-01-07',0,7),
('SweetDream','2021-01-07',0,10),
('EverythingIsSugar','2021-01-07',0,5),
('TowerOfLove','2021-02-12',0,8),
('Onceuponatime','2021-02-12',0,7),
('CuteAnimals','2021-02-12',0,10),
('EverythingIsSugar','2021-02-12',0,5),
('CandyWorld','2021-01-15',0,7),
('SweetDream','2021-01-15',0,10),
('EverythingIsSugar','2021-01-15',0,5),
('TowerOfLove','2021-01-18',0,8),
('CuteAnimals','2021-01-18',0,10),
('BoatTrip','2021-01-18',0,10),
('CandyWorld','2021-01-18',0,7);