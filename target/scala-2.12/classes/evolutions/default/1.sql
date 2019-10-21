-- !Ups
CREATE TABLE `user` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `username` VARCHAR(45) NULL,
      `password` VARCHAR(500) NULL,
      `fullname` VARCHAR(45) NULL,
      `address` VARCHAR(45) NULL,
      `phone` VARCHAR(45) NULL,
      PRIMARY KEY (`id`));
INSERT INTO user values (1,'tungdk','$2a$10$5ZhG1zulmNJ/XpZn4T271Ofb37oxhbOy4cDYPuOkH2DDf/8rTZ95a','Duong Khac Tung','Septeni','0918334306');
INSERT INTO user values (2,'tungdk2','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung2','Septeni2','09183324306');
INSERT INTO user values (3,'tungdk3','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung3','Septeni2','09183324306');
INSERT INTO user values (4,'admin','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung4','Septeni2','09183324306');
INSERT INTO user values (5,'tungdk4','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung5','Septeni2','09183324306');
INSERT INTO user values (6,'tungdk5','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung6','Septeni2','09183324306');
INSERT INTO user values (7,'tungdk6','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung7','Septeni2','09183324306');
INSERT INTO user values (8,'tungdk7','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung8','Septeni2','09183324306');
INSERT INTO user values (9,'tungdk8','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung9','Septeni2','09183324306');
INSERT INTO user values (10,'tungdk9','$2a$10$x/igtG8/uIZWQwb/GjshNuYy7h1zqbJJU4iflMTNjeYxJ1454UkEi','Duong Khac Tung10','Septeni2','09183324306');
-- !Downs
DROP TABLE user;
