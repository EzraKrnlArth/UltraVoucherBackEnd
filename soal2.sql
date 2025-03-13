-- Buat tabel untuk 
CREATE TABLE people (
  id INT PRIMARY KEY,
  name VARCHAR(50),
  parent_id INT,
  FOREIGN KEY (parent_id) REFERENCES people(id)
);

-- Masukkan data ke tabel
INSERT INTO people (id, name, parent_id) VALUES 
(1, 'Zaki', 2),
(2, 'Ilham', NULL),
(3, 'Irwan', 2),
(4, 'Arka', 3);

-- Query data
SELECT 
  a.id,
  a.name,
  b.name AS parent_name
FROM 
  people a
LEFT JOIN 
  people b
ON 
  a.parent_id = b.id
ORDER BY 
  a.id;