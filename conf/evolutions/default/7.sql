-- !Ups
CREATE TABLE `genre` (
                        `id` INT NOT NULL AUTO_INCREMENT,
                        `name` VARCHAR(100) NULL,
                        `country` VARCHAR(100) NULL,
                        `total_movie_has` VARCHAR(255) NULL,
                        `language` VARCHAR(255) NULL,
                        PRIMARY KEY (`id`));
INSERT INTO genre values (1,'Romantic (Tình Cảm Lãng Mạn)','Việt Nam' ,'5','English, VietNamese');
INSERT INTO genre values (2,'Drama (Kịch)','Việt Nam' ,'5','English, VietNamese');
INSERT INTO genre values (3,'Comedy (Hài Kịch)','England' ,'5','English, VietNamese');
INSERT INTO genre values (4,'Science-Fiction (Khoa Học Viễn Tưởng)','Germany' ,'5','English, VietNamese');
INSERT INTO genre values (5,'Cartoon (Hoạt Hình)','Finland' ,'5','English, VietNamese');
INSERT INTO genre values (6,'Horror (Kinh Dị)','Brazil' ,'5','English, VietNamese');
INSERT INTO genre values (7,'Western (Phim Viễn Tây)','England' ,'5','English, VietNamese');
INSERT INTO genre values (8,'Detective (Trinh Thám)','Japan' ,'5','English, VietNamese');
INSERT INTO genre values (9,'Action (Hành Động)','China' ,'5','English, VietNamese');
INSERT INTO genre values (10,'Adventure (Phiêu Lưu)','Singapore' ,'5','English, VietNamese');
INSERT INTO genre values (11,'Magic/Fantasy (Kỳ Ảo)','Taiwan' ,'5','English, VietNamese');

-- !Downs
DROP TABLE genre;