USE juguetilandia;

SELECT * FROM categories;
SELECT * FROM products;

-- Cuantos productos hay en total
SELECT COUNT(*) FROM products; -- 31

-- Cuantos productos tiene asignado una categoria
SELECT COUNT(*) FROM products WHERE fk_category_id IS NOT NULL ; -- 26 

-- Cuantos productos no tiene asignado una categoria ( son nulos)
SELECT COUNT(*) FROM products WHERE fk_category_id IS NULL ; -- 5

-- Cuantas categorias hay
SELECT COUNT(*) FROM categories; -- 6

-- Cuantas categorias están siendo usadas en la tabla productos
-- id de la categoria
SELECT DISTINCT fk_category_id AS CategoriaID
	FROM products
	WHERE fk_category_id IS NOT NULL; -- 1, 2, 3

-- Inner JOIN
SELECT * FROM products
	INNER JOIN categories
    ON products.fk_category_id = categories.id;
	
-- Visualizar id producto, nombre, price, id category, nombre categoria
SELECT products.id, products.name , products.price, 
	   categories.id AS categoryID, categories.name AS categoryName
       FROM products
       INNER JOIN categories
       ON products.fk_category_id = categories.id
       ORDER By name;


-- Visualizar id producto, nombre, price, id category, nombre categoria
-- Mostrar solamente los productos que tengan la categoria 1 y 2
SELECT products.id,products.name, products.price,
	categories.id AS categoryID, categories.name AS categoryName
	FROM products
	INNER JOIN categories
	ON products.fk_category_id=categories.id
	WHERE products.fk_category_id in( 1, 2);

-- left join
SELECT *
	FROM products -- tabla izquierda
    LEFT JOIN categories
    ON products.fk_category_id = categories.id;

-- Mostrar solo categorias 1, 2 y null
SELECT *
	FROM products -- tabla izquierda
    LEFT JOIN categories -- tabla derecha
    ON products.fk_category_id = categories.id
    WHERE products.fk_category_id in( 1, 2)  OR products.fk_category_id IS NULL;

-- Right Join
SELECT *
 FROM products -- tabla izq
 RIGHT JOIN categories -- tabla der
 ON products.fk_category_id = categories.id;





