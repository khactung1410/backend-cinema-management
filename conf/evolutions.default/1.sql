-- create table user
-- !Ups
CREATE TABLE `user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NULL,
  `password` VARCHAR(500) NULL,
  `fullname` VARCHAR(45) NULL,
  `address` VARCHAR(45) NULL,
  `phone` VARCHAR(45) NULL,
  `cmnd` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

-- !Downs
DROP TABLE user
