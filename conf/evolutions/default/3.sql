-- !Ups
CREATE TABLE `schedule` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `name` VARCHAR(100) NULL,
                         `room` VARCHAR(100) NULL,
                         `start_at` TIME(0) NULL,
                         `end_at` TIME(0) NULL,
                         `date` DATE NULL,
                         `ticket_price` VARCHAR(100) NULL,
                         PRIMARY KEY (`id`));
INSERT INTO schedule values (1,'Maleficent','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (2,'Jocker','P124','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (3,'Song Tử','P125','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (4,'Maleficent4','P126','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (5,'Maleficent5','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (6,'Maleficent6','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (7,'Maleficent7','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (8,'Thất Sơn Tâm Linh','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (9,'Biệt Đội Bất Hảo','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (10,'Thú Cưng Siêu Quậy','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (11,'Ngọt Ngòa Điên Dại','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (12,'Lời Từ Biệt','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (13,'Nhân Duyên','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (14,'Bước Nhảy Cuồng Nhiệt','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (15,'Điện Ảnh Mọi Người','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (16,'Bad Boy','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (17,'Like a Five','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (18,'Funny guy','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (19,'Cô Dâu 8 Tuôi','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (20,'Thàn Linh','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (21,'Hành Trình','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (22,'Crazy One','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (23,'Seem Like All','P123','09:10:00','11:10:00','2019-10-23','75000');
INSERT INTO schedule values (24,'Where you are','P123','09:10:00','11:10:00','2019-10-23','75000');
-- !Downs
DROP TABLE schedule;
