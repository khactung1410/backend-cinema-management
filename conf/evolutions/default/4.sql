-- !Ups
CREATE TABLE `seat` (
                            `id` INT NOT NULL AUTO_INCREMENT,
                            `id_room` INT NULL,
                            `name` VARCHAR(100) NULL,
                            `status` VARCHAR(100) NULL,
                            PRIMARY KEY (`id`));
INSERT INTO seat values (1,1,'A1','EMPTY');
INSERT INTO seat values (2,1,'A2','NOT_EMPTY');
INSERT INTO seat values (3,1,'A3','EMPTY');
INSERT INTO seat values (4,1,'A4','NOT_EMPTY');
INSERT INTO seat values (5,1,'B1','EMPTY');
INSERT INTO seat values (6,1,'B2','NOT_EMPTY');
INSERT INTO seat values (7,1,'B3','NOT_EMPTY');
INSERT INTO seat values (8,1,'B4','EMPTY');
INSERT INTO seat values (9,1,'C1','NOT_EMPTY');
INSERT INTO seat values (10,1,'C2','NOT_EMPTY');
INSERT INTO seat values (11,1,'C3','NOT_EMPTY');
INSERT INTO seat values (12,1,'C4','EMPTY');
INSERT INTO seat values (13,2,'A1','EMPTY');
INSERT INTO seat values (14,2,'A2','NOT_EMPTY');
INSERT INTO seat values (15,2,'A3','EMPTY');
INSERT INTO seat values (16,2,'B1','EMPTY');
INSERT INTO seat values (17,2,'B2','NOT_EMPTY');
INSERT INTO seat values (18,2,'B3','NOT_EMPTY');
INSERT INTO seat values (19,2,'B4','EMPTY');
INSERT INTO seat values (20,2,'C1','NOT_EMPTY');
INSERT INTO seat values (21,2,'C2','EMPTY');
INSERT INTO seat values (22,2,'C3','NOT_EMPTY');
INSERT INTO seat values (23,2,'C4','NOT_EMPTY');
INSERT INTO seat values (24,2,'A4','EMPTY');
-- !Downs
DROP TABLE seat;
