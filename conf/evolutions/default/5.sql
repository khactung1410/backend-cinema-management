-- !Ups
CREATE TABLE `room` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(100) NULL,
                        `total_seat` VARCHAR(100) NULL,
                        `square` VARCHAR(255) NULL,
                        `location` VARCHAR(255) NULL,
                        `type_room` VARCHAR(255) NULL,
                        `create_at` DATETIME(0) NULL,
                        `update_at` DATETIME(0) NULL,
                        PRIMARY KEY (`id`));
INSERT INTO room values (1,'P1',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (2,'P2',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (3,'P3',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (4,'P4',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (5,'P5',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (6,'P6',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (7,'P7',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (8,'P8',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (9,'P9',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (10,'P10',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (11,'P11',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (12,'P12',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (13,'P13',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (14,'P14',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
INSERT INTO room values (15,'P15',40,'100','Floor 2, Nguyễn Chí Thanh','Normal','2019-12-20 15:50:46','2019-12-20 15:50:46');
-- !Downs
DROP TABLE room;
