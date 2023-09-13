USE juguetilandia;

-- ver todos los registros
SELECT * FROM users;

-- limitar el número de registros a visualizar
SELECT * FROM users LIMIT 10;

-- Ordenar por el campo email de forma descendente
SELECT * FROM users ORDER BY email DESC LIMIT 10 ;

-- Ordenar por el campo email de forma ascendente
SELECT * FROM users ORDER BY email LIMIT 10 ;

INSERT INTO users (firstname, lastname, email, password, active)
	VALUES("Mau", "Obrador", "ma@gmail.com", "123", 1);
INSERT INTO users (firstname, lastname, email, password, active)
	VALUES("Mau", "Salinas", "mas@gmail.com", "123", 1);
INSERT INTO users (firstname, lastname, email, password, active)
	VALUES("Mau", "Darth", "mad@gmail.com", "estrella", 1);
    
-- Mostra todos los campos con los registros que tengan el nombre 'Mau'    
SELECT * FROM users 
	WHERE firstname = "Mau"
    ORDER BY password ASC, lastname ASC;

--  Renombrar el nombre de la columna en la consulta
SELECT id AS "N.Serie" , firstname AS "Primer nombre"
 FROM users WHERE firstname = "Mau";

-- >>>>>>>>>>>>> Trabajar con caracteres <<<<<<<<<<<<<
-- concatenar el nombre y apellido y mostrarlos en una solo columna
SELECT 
		id AS "Participante",
		CONCAT( firstname, " ", lastname) AS "Nombre Completo",
		email
	FROM users
    WHERE firstname = "Mau"
    ORDER by `Nombre Completo`;
    
-- Mostrar todos los campos y la concatenación
SELECT 
		 * ,
		CONCAT( firstname, " ", lastname) AS "Nombre Completo"
	FROM users
    WHERE firstname = "Mau"
    ORDER by `Nombre Completo`;

-- Mostrar el nombre, apellido y la longitud del apellido
SELECT
		firstname, lastname,
        length( lastname ) AS "lengh_lastname"
	FROM users WHERE firstname = "Mau";

-- Mostrar el apelldo y apellido en reversa
SELECT lastname, REVERSE(lastname) FROM users WHERE firstname = "Mau";

-- Mostrar el apelldo y apellido en reversa en minúsculas
SELECT 
		UPPER(lastname), 
		LOWER( REVERSE(lastname) ) 
	FROM users WHERE firstname = "Mau";






