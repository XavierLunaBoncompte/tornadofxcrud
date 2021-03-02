DROP DATABASE IF EXISTS gestacad;
CREATE DATABASE gestacad;
DROP USER IF EXISTS administrador;
CREATE USER administrador IDENTIFIED BY 'admin';
GRANT ALL PRIVILEGES ON gestacad.* TO administrador WITH GRANT OPTION;
USE gestacad;

CREATE TABLE client
	(telefon			VARCHAR(9)		PRIMARY KEY,
	nom					VARCHAR(20)		NOT NULL,
	adreca				VARCHAR(50)		NOT NULL,
	poblacio			VARCHAR(20)		NOT NULL DEFAULT 'Terrassa'
	)ENGINE=InnoDB
	;
INSERT INTO client VALUE ('937853354','Josep Vila','C. del Pi, 23',DEFAULT);
INSERT INTO client VALUE ('937883402','Carme Garcia','Plaça Nova 3',DEFAULT);
INSERT INTO client VALUE ('606989866','Enric Miralles','Carrer Romaní 6','Matadepera');
INSERT INTO client VALUE ('937753222','Miquel Bover','Carrer Can Boada 78', DEFAULT);
INSERT INTO client VALUE ('937862655','Marta Ribas','Carrer Aviació 3',DEFAULT);
INSERT INTO client VALUE ('937858555','Guillem Jam','Carrer de Dalt, 4', DEFAULT);
INSERT INTO client VALUE ('626895456','Júlia Guillén','C. Robert 8',DEFAULT);

SELECT * FROM client;