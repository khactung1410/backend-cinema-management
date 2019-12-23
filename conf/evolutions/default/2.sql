-- !Ups
CREATE TABLE `movie` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NULL,
    `genre` VARCHAR(100) NULL,
    `director` VARCHAR(100) NULL,
    `public_year` VARCHAR(100) NULL,
    `description` VARCHAR(1000) NULL,
    `trailer` VARCHAR(1000) NULL,
    `poster` VARCHAR(100) NULL,
    PRIMARY KEY (`id`));
INSERT INTO movie values
    (1,'MẮT BIẾC','Tình cảm','Victor Vũ','2019','Mắc Biếc: Một sự kết hợp tinh tế vẻ đẹp thuần khiết của văn chương Nguyễn Nhật Ánh, với những khung hình mãn nhãn đặc trưng của Victor Vũ, đã từng khiến khán giả choáng ngợp từ “Thiên mệnh anh hùng” tới “Tôi thấy hoa vàng trên cỏ xanh”.','https://www.youtube.com/watch?v=ITlQ0oU7tDA','/upload/191224020024.jpg'),
    (2,'NỮ HOÀNG BĂNG GIÁ','Cartoon (Hoạt Hình)','Chris Buck, Jennifer Lee','2019','Cùng dấn thân vào một cuộc phiêu lưu xa xôi thú vị, hai chị em Anna và Elsa đi đến chốn rừng sâu để tìm kiếm sự thật về bí ẩn cổ xưa của vương quốc mình.','https://youtu.be/C70I39Pqlhs','/upload/191224025641.jpg'),
    (3,'KHỦNG LONG ĂN CHAY','Adventure (Phiêu Lưu)','Kobun Shizuno','2019','Tyrano - chú khủng long bạo chúa... ăn chay, cùng với Punon - cô khủng long nhỏ bé không biết bay đồng hành cùng nhau trên hành trình tìm kiếm vùng đất Thiên Đường - vùng đất bình yên đầy những Quả Thần thơm ngon.','https://youtu.be/ZDmSkuMPgkw','/upload/191224030528.jpg'),
    (4,'TRÒ CHƠI KỲ ẢO','Detective (Trinh Thám)','Jake Kasdan','2019','Khi những người chơi quay lại, trò chơi đã thay đổi. Trở về Jumanji để giải cứu bạn mình, họ phát hiện mọi thứ không còn như mong đợi.','https://youtu.be/8zSawO1DaTE','/upload/191224030856.jpg'),
    (5,'GIÁNG SINH NĂM ẤY','Romantic (Tình Cảm)','Paul Feig','2019','Last Christmas là câu chuyện tình yêu cảm động giữa Kate và Tom, 2 tâm hồn cô đơn đang gặp phải những khó khăn trong cuộc sống.','https://youtu.be/DY00ArYybB8','/upload/191224031302.jpg'),
    (6,'HỒI KẾT ĐẪM MÁU','Horror (Kinh Dị)','Adrian Grunberg','2019','Đã gần 4 thập kỷ trôi qua kể từ ngày giọt máu đầu tiên nhỏ xuống. huyền thoại điện ảnh Sylvester Stallone trở lại với vai diễn là một trong những người hùng hành động vĩ đại nhất mọi thời đại.','https://youtu.be/qYhnL34DD44','/upload/191224031956.jpg'),
    (7,'NHỮNG CHÚ MÈO','Drama (Kịch)','Tom Hooper','2019','CATS của Universal Pictures và Working Title là tác phẩm chuyển thể từ vở nhạc kịch “Cats” được yêu thích của Andrew Lloyd Weber và những bài thơ trong tác phẩm “Old Possum’s Book of Practical Cats” của nhà văn T.S. Eliot.','https://youtu.be/kHKYHi7cz34','/upload/191224032145.jpg'),
    (8,'GIÁNG SINH ĐEN','Horror (Kinh Dị)','Sophia Takal','2019','Trường Đại học Hawthorne trở nên vắng lặng hơn khi bước vào kì nghỉ lễ. Tuy nhiên, Riley Stone (Imogen Poots của Green Room) và chị em nhà Kappa, Epsilon – Marty năng động (Lily Donoghue của Jane the Virgin), Kris nổi loạn (Aleyse Shannon của Charmed) và Jesse ham ăn (Brittany O’Grady của Star) – lại tưng bừng tiệc tùng, và bị một kẻ đeo mặt nạ đen theo dõi và bắt đầu kế hoạch sát hại lần lượt từng người trong nhóm.','https://youtu.be/cd-XvdJUuWA','/upload/191224032348.jpg'),
    (9,'CLARA VÀ KHU RỪNG KỲ BÍ','Magic/Fantasy (Kỳ Ảo)','Oleksandr Klymenko','2019','Clara, một cô gái trẻ và xinh đẹp sống trong xứ sở thần tiên cùng với các người lùn, những chú rồng và phù thuỷ. Một sứ mệnh cao cả được giao cho Clara và những người bạn của mình, khiến cô và mọi người cùng nhau bắt đầu một cuộc hành trình mới.','https://youtu.be/vd-3l83FGws','/upload/191224032531.jpg'),
    (10,'ANH TRAI YÊU QUÁI','Romantic (Tình Cảm)','Vũ Ngọc Phượng','2019','Lâm là một vận động viên Judo quốc gia bỗng chốc phải bỏ dở sự nghiệp vì gặp chấn thương mất đi thị giác. Phong - người anh cùng cha khác mẹ đang ở trong tù - ngay lập tức lợi dụng bi kịch của em trai để xin được ân xá về nhà chăm sóc em.','https://youtu.be/jRhw9v2MEjQ','/upload/191224032819.jpg'),
    (11,'ĐIỆP VIÊN ẨN DANH','Cartoon (Hoạt Hình)','Nick Bruno, Troy Quane','2019','Biệt đội giải cứu thế giới của siêu điệp viên Lance Sterling và các phụ tá siêu tài năng và thông minh!','https://youtu.be/YgI4fyka4oo','/upload/191224033025.jpg'),
    (12,'QUÁI VẬT NGUYÊN SINH','Horror (Kinh Dị)','Nick Powell','2019','Bộ phim xoay quanh Frank Walsh, một thợ săn đang thực hiện nhiệm vụ đưa một con báo trắng cùng nhiều loài động vật hoang dã từ Brazil về một sở thú ở Mỹ bằng tàu biển.','https://youtu.be/90Mtxo_IBiI','/upload/191224033217.jpg'),
    (13,'HÀI ĐỎ VÀ 7 CHÚ LÙN','Cartoon (Hoạt Hình)','Hong Sung-ho','2019','Bộ phim hoạt hình “Hài Đỏ và 7 Chú Lùn” xoay quanh câu chuyện của 7 chàng hoàng tử vì bị phù phép mà biến thành 7 chú lùn da xanh. Muốn hóa giải lời nguyền ác độc này, họ phải có được tình yêu chân thành từ cô gái mang đôi hài đỏ và xinh đẹp nhất trần đời.','https://youtu.be/hvAJxxXwlaA','/upload/191224033426.jpg'),
    (14,'BÁC SĨ DOLITTLE','Adventure (Phiêu Lưu)','Stephen Gaghan','2019','Bộ phim kể về vị bác sĩ nổi tiếng Dolittle - người đàn ông có thể nói chuyện với động vật. Sau khi vợ mất, anh sống tách biệt với thế giới bên ngoài, chỉ đến khi nữ hoàng Anh bị bệnh, anh mới trở lại.','https://youtu.be/JzDpEdkWBCg','/upload/191224033602.jpg'),
    (15,'STAR WARS IX','Khoa Học Viễn Tưởng','J.J. Abrams','2019','Hãng phim Lucas và đạo diển lừng danh J.J. Abrams một lần nữa tiếp tục chung tay dẫn dắt khán giả đến một thiên hà xa xôi với phần thứ 9 của loạt phim Chiến Tranh Giữa Các Vì Sao.','https://youtu.be/LTxMXEWsuFE','/upload/191224033825.jpg'),
    (16,'KHU VƯỜN HUYỀN BÍ','Western (Phim Viễn Tây)','Marc Munden','2019','Mary Lennox được sinh ra tại Ấn Độ trong 1 gia đình giàu có người Anh. Cha mẹ cô đột ngột qua đời và cô được gửi về Anh Quốc, sống cùng chú mình, Archibald Craven. Cô bé cùng các anh em họ tìm ra 1 khu vườn kỳ bí trong dinh thự Misselthwaite.','https://youtu.be/kSprOV4HFtk','/upload/191224034009.jpg');
-- !Downs
DROP TABLE movie;
