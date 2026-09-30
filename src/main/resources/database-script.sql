DROP DATABASE IF EXISTS hardwareapp;
CREATE DATABASE hardwareapp;

USE hardwareapp;

CREATE TABLE Type
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

CREATE TABLE Hardware
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    stock INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    type_id INT NOT NULL,
    FOREIGN KEY (type_id) REFERENCES Type(id)
);

INSERT INTO Type (name)
VALUES
    ('CPU'),
    ('GPU'),
    ('MBO'),
    ('RAM'),
    ('STORAGE'),
    ('OTHER');

INSERT INTO Hardware (name, code, stock, price, type_id)
VALUES
    ('Asus TUF RTX 3080', '1234561', 0, 1599.00, 2),
    ('EVGA XC3 RTX 3070 Ti', '1234562', 0, 1299.00, 2),
    ('AMD Ryzen 5950X', '1234563', 0, 899.00, 1),
    ('Samsung 980 PRO SSD 1TB', '1234564', 0, 299.00, 5),
    ('Kingston FURY Beast DDR5 32GB', '1234565', 0, 699.00, 4);