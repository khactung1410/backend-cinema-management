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
INSERT INTO room values
    (1,'P1','50','100','Floor 1, Vincom Times City Cinema','Normal','2019-12-24 04:05:32','2019-12-24 04:05:32'),
    (2,'P2','50','100','Floor 1, Vincom Times City Cinema','Normal','2019-12-24 04:06:23','2019-12-24 04:06:23'),
    (3,'P3','50','100','Floor 1, Vincom Times City Cinema','Normal','2019-12-24 04:07:19','2019-12-24 04:07:19'),
    (4,'P4','50','100','Floor 1, Vincom Times City Cinema','Normal','2019-12-24 04:08:11','2019-12-24 04:08:11'),
    (5,'P5','70','140','Floor 1, Vincom Times City Cinema','Middle','2019-12-24 04:08:30','2019-12-24 04:08:30'),
    (6,'P6','50','100','Floor 2, Vincom Times City Cinema','Normal','2019-12-24 04:09:15','2019-12-24 04:09:15'),
    (7,'P7','50','100','Floor 2, Vincom Times City Cinema','Normal','2019-12-24 04:09:54','2019-12-24 04:09:54'),
    (8,'P8','50','100','Floor 2, Vincom Times City Cinema','Normal','2019-12-24 04:10:18','2019-12-24 04:10:18'),
    (9,'P9','50','100','Floor 2, Vincom Times City Cinema','Normal','2019-12-24 04:10:35','2019-12-24 04:10:35'),
    (10,'P10','70','140','Floor 2, Vincom Times City Cinema','Middle','2019-12-24 04:10:53','2019-12-24 04:10:53');
-- !Downs
DROP TABLE room;
