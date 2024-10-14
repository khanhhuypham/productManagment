DROP DATABASE IF EXISTS productManagement;

CREATE DATABASE productManagement;

USE productManagement;


CREATE TABLE category(
	id int primary key auto_increment,
	name varchar(100) NOT NULL UNIQUE,
    description text NOT NULL
);


CREATE TABLE product(
	id int primary key auto_increment,
    name varchar(100) NOT NULL unique,
    price double,
    category_id int not null,
    image VARCHAR(255),
    status tinyint(1) DEFAULT 1,
    foreign key(category_id) references category(id)
);




INSERT INTO category (name, description) VALUES
('Electronics', 'All kinds of electronic devices and gadgets.'),
('Books', 'A wide range of books across various genres.'),
('Clothing', 'Fashion and clothing items for all ages.'),
('Home & Kitchen', 'Items for your home and kitchen needs.'),
('Toys & Games', 'Entertainment and educational toys for kids and adults.');


INSERT INTO product (name, price, category_id, image, status) VALUES
('Smartphone X10', 499.99, 1, 'https://example.com/images/smartphone-x10.jpg', 1),
('Laptop Pro', 999.99, 1, 'https://example.com/images/laptop-pro.jpg', 1),
('Mystery Novel', 19.99, 2, 'https://example.com/images/mystery-novel.jpg', 1),
('Fantasy Book', 14.99, 2, 'https://example.com/images/fantasy-book.jpg', 1),
('T-Shirt', 24.99, 3, 'https://example.com/images/t-shirt.jpg', 1),
('Jeans', 39.99, 3, 'https://example.com/images/jeans.jpg', 1),
('Coffee Maker', 49.99, 4, 'https://example.com/images/coffee-maker.jpg', 1),
('Blender', 59.99, 4, 'https://example.com/images/blender.jpg', 1),
('Board Game', 29.99, 5, 'https://example.com/images/board-game.jpg', 1),
('Puzzle', 19.99, 5, 'https://example.com/images/puzzle.jpg', 1);