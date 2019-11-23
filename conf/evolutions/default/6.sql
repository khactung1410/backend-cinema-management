-- !Ups
CREATE TABLE `seatstatus` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `id_seat` INT NULL,
                            `id_room` INT NULL,
                            `start_at` TIME(0) NULL,
                            `end_at` TIME(0) NULL,
                            `date` DATE NULL,
                            `status` VARCHAR(100) NULL,

                            PRIMARY KEY (`id`));
INSERT INTO seatstatus values (1 ,1 ,1,'08:10:00','10:10:00','2019-10-23','NOT_EMPTY');
INSERT INTO seatstatus values (2 ,2 ,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (3 ,3 ,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (4 ,4 ,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (5 ,5 ,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (6 ,6 ,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (7 ,7 ,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (8 ,8 ,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (9 ,9 ,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (10,10,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (11,11,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (12,12,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (13,13,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (14,14,1,'08:10:00','10:10:00','2019-10-23','NOT_EMPTY');
INSERT INTO seatstatus values (15,15,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (16,16,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (17,17,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (18,18,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (19,19,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (20,20,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (21,21,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (22,22,1,'08:10:00','10:10:00','2019-10-23','NOT_EMPTY');
INSERT INTO seatstatus values (23,23,1,'08:10:00','10:10:00','2019-10-23','NOT_EMPTY');
INSERT INTO seatstatus values (24,24,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (25,25,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (26,26,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (27,27,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (28,28,1,'08:10:00','10:10:00','2019-10-23','NOT_EMPTY');
INSERT INTO seatstatus values (29,29,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (30,30,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (31,31,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (32,32,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (33,33,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (34,34,1,'08:10:00','10:10:00','2019-10-23','NOT_EMPTY');
INSERT INTO seatstatus values (35,35,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (36,36,1,'08:10:00','10:10:00','2019-10-23','NOT_EMPTY');
INSERT INTO seatstatus values (37,37,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (38,38,1,'08:10:00','10:10:00','2019-10-23','NOT_EMPTY');
INSERT INTO seatstatus values (39,39,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
INSERT INTO seatstatus values (40,40,1,'08:10:00','10:10:00','2019-10-23','EMPTY');
-- !Downs
DROP TABLE seatstatus;
