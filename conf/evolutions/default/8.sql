-- !Ups
CREATE TABLE `bill` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `name` VARCHAR(100) NULL,
                            `room` VARCHAR(100) NULL,
                            `seats` VARCHAR(100) NULL,
                            `employee` VARCHAR(100) NULL,
                            `start_at` TIME(0) NULL,
                            `end_at` TIME(0) NULL,
                            `date` DATE NULL,
                            `price` INT NULL,
                            `total_seat` INT NULL,
                            `buy_at` DATETIME NULL,
                            PRIMARY KEY (`id`));

# INSERT INTO bill values (1,'Making you laugh','P5','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-12-27',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (2,'Making you laugh2','P4','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-11-26',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (3,'Making you laugh3','P3','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-12-25',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (4,'Making you laugh4','P2','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-11-24',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (5,'Making you laugh5','P1','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-12-23',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (6,'Making you laugh6','P9','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-11-22',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (7,'Making you laugh7','P8','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-12-21',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (8,'Making you laugh8','P7','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-11-20',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (9,'Making you laugh9','P6','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-12-19',240000,2,'2019-12-23 23:00:07');
# INSERT INTO bill values (10,'Making you laugh10','P11','D10,E10','Duong Khac Tung','08:10:00','10:10:00','2019-11-18',240000,2,'2019-12-23 23:00:07');

-- !Downs
DROP TABLE bill;