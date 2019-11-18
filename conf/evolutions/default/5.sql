-- !Ups
CREATE TABLE `room` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(100) NULL,
                        `total_seat` VARCHAR(100) NULL,
                        PRIMARY KEY (`id`));
INSERT INTO room values (1,'P1',40);
INSERT INTO room values (2,'P2',40);
INSERT INTO room values (3,'P3',40);
INSERT INTO room values (4,'P4',40);
INSERT INTO room values (5,'P4',40);

-- !Downs
DROP TABLE room;
