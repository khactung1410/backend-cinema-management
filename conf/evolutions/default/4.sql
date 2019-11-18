-- !Ups
CREATE TABLE `seat` (
                `id` INT NOT NULL AUTO_INCREMENT,
                `name` VARCHAR(100) NULL,
                PRIMARY KEY (`id`));
INSERT INTO seat values (1,'A1');
INSERT INTO seat values (2,'A2');
INSERT INTO seat values (3,'A3');
INSERT INTO seat values (4,'A4');
INSERT INTO seat values (5,'A5');
INSERT INTO seat values (6,'A6');
INSERT INTO seat values (7,'A7');
INSERT INTO seat values (8,'A8');
INSERT INTO seat values (9,'A9');
INSERT INTO seat values (10,'A10');
INSERT INTO seat values (11,'B1');
INSERT INTO seat values (12,'B2');
INSERT INTO seat values (13,'B3');
INSERT INTO seat values (14,'B4');
INSERT INTO seat values (15,'B5');
INSERT INTO seat values (16,'B6');
INSERT INTO seat values (17,'B7');
INSERT INTO seat values (18,'B8');
INSERT INTO seat values (19,'B9');
INSERT INTO seat values (20,'B10');
INSERT INTO seat values (21,'C1');
INSERT INTO seat values (22,'C2');
INSERT INTO seat values (23,'C3');
INSERT INTO seat values (24,'C4');
INSERT INTO seat values (25,'C5');
INSERT INTO seat values (26,'C6');
INSERT INTO seat values (27,'C7');
INSERT INTO seat values (28,'C8');
INSERT INTO seat values (29,'C9');
INSERT INTO seat values (30,'C10');
INSERT INTO seat values (31,'D1');
INSERT INTO seat values (32,'D2');
INSERT INTO seat values (33,'D3');
INSERT INTO seat values (34,'D4');
INSERT INTO seat values (35,'D5');
INSERT INTO seat values (36,'D6');
INSERT INTO seat values (37,'D7');
INSERT INTO seat values (38,'D8');
INSERT INTO seat values (39,'D9');
INSERT INTO seat values (40,'D10');

-- !Downs
DROP TABLE seat;
