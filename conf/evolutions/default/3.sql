-- !Ups
CREATE TABLE `schedule` (
                         `id` INT NOT NULL AUTO_INCREMENT,
                         `id_movie` INT NULL,
                         `name` VARCHAR(100) NULL,
                         `id_room` INT NULL,
                         `room` VARCHAR(100) NULL,
                         `start_at` TIME(0) NULL,
                         `end_at` TIME(0) NULL,
                         `date` DATE NULL,
                         `ticket_price` VARCHAR(100) NULL,
                         `quantity_ticket` INT NULL,
                         `remaining_ticket` INT NULL,
                         PRIMARY KEY (`id`));
INSERT INTO schedule values (1,1,'Maleficent',1,'P1','08:10:00','10:10:00','2019-10-23','75000',40,40);
INSERT INTO schedule values (2,2,'Jocker',1,'P1','10:15:00','11:10:00','2019-10-23','75000',40,40);
INSERT INTO schedule values (3,3,'Song Tử',1,'P1','09:10:00','11:10:00','2019-10-23','75000',40,40);
INSERT INTO schedule values (8,4,'Thất Sơn Tâm Linh',1,'P1','09:10:00','11:10:00','2019-10-24','75000',40,40);
INSERT INTO schedule values (9,5,'Biệt Đội Bất Hảo',1,'P1','09:10:00','11:10:00','2019-10-25','75000',40,40);
INSERT INTO schedule values (10,6,'Thú Cưng Siêu Quậy',2,'P2','09:10:00','11:10:00','2019-10-26','75000',40,40);
INSERT INTO schedule values (11,7,'Ngọt Ngòa Điên Dại',2,'P2','09:10:00','11:10:00','2019-10-27','75000',40,40);
INSERT INTO schedule values (12,8,'Lời Từ Biệt',2,'P2','09:10:00','11:10:00','2019-10-28','75000',40,40);
INSERT INTO schedule values (13,9,'Nhân Duyên',2,'P2','09:10:00','11:10:00','2019-10-29','75000',40,40);
INSERT INTO schedule values (14,10,'Bước Nhảy Cuồng Nhiệt',2,'P2','09:10:00','11:10:00','2019-10-30','75000',40,40);
INSERT INTO schedule values (15,11,'Điện Ảnh Mọi Người',2,'P2','09:10:00','11:10:00','2019-11-1','75000',40,40);
INSERT INTO schedule values (16,12,'Bad Boy',3,'P3','09:10:00','11:10:00','2019-10-1','75000',40,40);
INSERT INTO schedule values (17,13,'Like a Five',3,'P3','09:10:00','11:10:00','2019-10-2','75000',40,40);
INSERT INTO schedule values (18,15,'Funny guy',3,'P3','09:10:00','11:10:00','2019-10-3','75000',40,40);
INSERT INTO schedule values (19,16,'Cô Dâu 8 Tuôi',3,'P3','09:10:00','11:10:00','2019-10-4','75000',40,40);
INSERT INTO schedule values (20,17,'Thàn Linh',3,'P3','09:10:00','11:10:00','2019-10-5','75000',40,40);
INSERT INTO schedule values (21,18,'Hành Trình',3,'P3','09:10:00','11:10:00','2019-10-6','75000',40,40);
INSERT INTO schedule values (22,19,'Crazy One',3,'P3','09:10:00','11:10:00','2019-10-7','75000',40,40);
INSERT INTO schedule values (23,20,'Seem Like All',4,'P4','09:10:00','11:10:00','2019-10-8','75000',40,40);
INSERT INTO schedule values (24,21,'Where you are',4,'P4','09:10:00','11:10:00','2019-10-9','75000',40,40);
-- !Downs
DROP TABLE schedule;
