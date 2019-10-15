-- !Ups
CREATE TABLE `user` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `username` VARCHAR(45) NULL,
      `password` VARCHAR(45) NULL,
      `fullname` VARCHAR(45) NULL,
      `address` VARCHAR(45) NULL,
      `phone` VARCHAR(45) NULL,
      PRIMARY KEY (`id`));
INSERT INTO user values (1,'tungdk','123456','Duong Khac Tung','Septeni','0918334306');
INSERT INTO user values (2,'tungdk22','1234562','Duong 2Khac Tung','Sept2eni','09183324306');
-- !Downs
DROP TABLE user;