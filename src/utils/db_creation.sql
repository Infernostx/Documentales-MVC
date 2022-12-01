CREATE SCHEMA documental;
USE documental;
DROP TABLE IF EXISTS documental;
CREATE TABLE Documental(
	do_id     int PRIMARY KEY auto_increment,
    do_titulo varchar(40) NOT NULL,
	do_nombre varchar(40) NOT NULL,
    do_apellido varchar(30) NOT NULL,
    do_origen varchar(30) NOT NULL,
    do_anio int NOT NULL
);
INSERT INTO Documental VALUES(101, 'Close Ties','Zofia', 'Kowalewska','Polonia',2016); 
INSERT INTO Documental VALUES(102, 'Pulse','Robin', 'Petré','Hungría',2017);
INSERT INTO Documental VALUES(103, 'Rocknrollers','Daan', 'Bol','Países Bajos',2018);
INSERT INTO Documental VALUES(104, 'Learning to Skateboard in a Warzone','Carol', 'Dysinger','Gran Bretaña',2019);
INSERT INTO Documental VALUES(105, 'Period. End of Sentence','Rayka', 'Zehtabchi','India',2015);