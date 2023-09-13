SELECT * FROM products;

-- >>>>>>>> suma y conteo de registros <<<<<<<
-- Mostrar los productos de la categoria id 2
SELECT * FROM products WHERE fk_category_id = 2;

-- Mostrar la sumatoria de la columna price
SELECT SUM( price ) AS total
	FROM products WHERE fk_category_id = 2;
    
-- Mostrar el promedio de la columna price
SELECT AVG( price ) AS total
	FROM products WHERE fk_category_id = 2;

-- Mostrar los registros que sean mayor al valor promedio de price (287.74)
SELECT * FROM products WHERE price > 287.74;

-- Consultas anidadas
SELECT * FROM products 
	WHERE price > ( SELECT AVG( price) FROM products );
    
-- Mostrar el valor mínimo del campo price
SELECT MIN(price) FROM products; -- 5.99
SELECT MAX(price) FROM products; -- 1999.00

-- Mostrar el registro o registros que tengan el valor mínimo
SELECT price, name, description
	FROM products
	WHERE price = (SELECT MIN(price) FROM products);
    
-- Contar registros
SELECT COUNT(*) FROM products;

-- Contar los registros donde 'price' sea mayor al valor promedio
SELECT COUNT(*) FROM products 
 WHERE price > (SELECT AVG(price) FROM products);
 
-- >>>>>>> Agrupar filas de acuerdo a una columna <<<<<<<
SELECT fk_category_id, SUM(price) 
	FROM products
    GROUP BY fk_category_id;

SELECT * FROM products;