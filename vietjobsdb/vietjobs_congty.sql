-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: localhost    Database: vietjobs
-- ------------------------------------------------------
-- Server version	8.0.23

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `congty`
--

DROP TABLE IF EXISTS `congty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `congty` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ten_nguoi_lien_he` varchar(100) DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `website` varchar(100) DEFAULT NULL,
  `mo_ta` longtext,
  `user_id` int NOT NULL,
  `ten_cong_ty` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_congty_user1_idx` (`user_id`),
  CONSTRAINT `fk_congty_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `congty`
--

LOCK TABLES `congty` WRITE;
/*!40000 ALTER TABLE `congty` DISABLE KEYS */;
INSERT INTO `congty` VALUES (1,'Recruitment Team','Lot I-11 , D2 street, Hi-Tech Park, Tang Nhon Phu B Ward','www.samsung.com','<p>The Samsung Group is a multinational corporation headquartered in Samsung Town, Seoul, South Korea. It is the world\'s largest conglomerate by revenue with annual revenues of US$138.14 billion in 2010. The Samsung Group is composed of numerous international affiliated businesses, most of them united under the Samsung brand including Samsung Electronics, the world\'s largest electronics and information technology company.&nbsp;</p><p>Samsung Electronics has been the world\'s most popular consumer electronics brand since 2005 and is the best known South Korean brand in the world. The company manufactures various electronic products, such as mobile phones, tablets, LCDs, laptops, DVD players, digital cameras and camcorders, laser printers, fax machines, and plasma and flat screen TVs. It also manufactures and sells home appliances such as washing machines, refrigerators, air conditioners and vacuum cleaners</p>',6,'SAMSUNG ELECTRONICS HCMC CE COMPLEX'),(2,'Ko Myung Eon',' Lô CN2, KCN Tràng Duệ, xã Lê Lợi, huyện An Dương, thành phố Hải Phòng, Việt Nam.','www.lg.com','<p>LG Electronics is made up of five forward-looking business units – Home Entertainment, Mobile Communications, Home Appliance, Air Conditioning &amp; Energy Solution and Vehicle Components.</p>',7,'LG Vehicle Component Solutions Development'),(3,'HR South Department','Lầu 10, tòa nhà Metropolitan, 235 Đồng Khởi, Quận 1, tp HCM, Việt Nam','www.cocacolavietnam.com','<p>Coca Cola Beverages Vietnam Ltd. started its operation in 1994. It has plants in Ha Noi, Da Nang and Ho Chi Minh City. Ho Chi Minh City is the company\'s head office.</p>',8,'Coca-Cola Beverages Vietnam Ltd.'),(4,'HR South Department','123 Cong Hoa Street, Ward 12, Tan Binh District, Ho Chi Minh City, Vietnam','www.kms-technology.com','<p>KMS is a provider of offshore product development &amp; independent software testing with offices in the US and Vietnam. www.kms-technology.com</p><p>Agile, Innovative &amp; Excellent Global Technology Company with deep roots in Vietnam</p>',9,'KMS Technology'),(5,'Ms.Thanh','Tòa nhà PVI, số 1 Phạm Văn Bạch, Cầu Giấy','fpt.vn','<p>Được thành lập ngày 31/01/1997,&nbsp;Công ty Cổ phần Viễn thông FPT&nbsp;(FPT Telecom)&nbsp;khởi đầu từ Trung tâm Dịch vụ Trực tuyến với 4 thành viên sáng lập cùng sản phẩm mạng Intranet đầu tiên của Việt Nam mang tên “Trí tuệ Việt Nam – TTVN”. Sau 21 năm hoạt động,&nbsp;FPT Telecom&nbsp;đã trở thành một trong những nhà cung cấp dịch vụ viễn thông và Internet hàng đầu khu vực với gần 14 000&nbsp;nhân viên, 2 công ty thành viên,&nbsp;59&nbsp;chi nhánh trong và ngoài nước. Hiện nay,&nbsp;FPT Telecom&nbsp;đang cung cấp các sản phẩm, dịch vụ chính bao gồm:</p><p>- Dịch vụ Internet<br>- Kênh thuê riêng, Tên miền, Email, Lưu trữ web, Trung tâm dữ liệu<br>- Các dịch vụ giá trị gia tăng trên Internet: Truyền hình internet&nbsp;(FPT play HD), Điện thoại cố định&nbsp;(VoIP), Giám sát từ xa(IP Camera), Chứng thực chữ ký số&nbsp;(CA), Điện toán đám mây&nbsp;(Cloud computing),...<br><br>Với phương châm “Mọi dịch vụ trên một kết nối”,&nbsp;FPT Telecom&nbsp;luôn không ngừng nghiên cứu và triển khai tích hợp ngày càng nhiều các dịch vụ giá trị gia tăng trên cùng một đường truyền Internet nhằm đem lại lợi ích tối đa cho khách hàng sử dụng. Đồng thời, việc đẩy mạnh hợp tác với các đối tác viễn thông lớn trên thế giới, xây dựng các tuyến cáp quang quốc tế là những hướng đi được triển khai mạnh mẽ để đưa các dịch vụ tiếp cận với thị trường toàn cầu, nâng cao hơn nữa vị thế của&nbsp;FPT Telecom&nbsp;nói riêng và các nhà cung cấp dịch vụ viễn thông Việt Nam nói chung.</p>',10,'FPT Telecom'),(6,'HR South Department','8F Nice building, 467 Dien Bien Phu Str., Ward 25, Binh Thanh district, HCMC','sun-asterisk.vn','<p>Sun* Inc. – tiền thân là công ty Framgia Inc., được thành lập vào năm 2012, là một Creative Studio hiện có hơn 1300 thành viên tại 7 thành phố ở 5 quốc gia Châu Á. Mang trên mình sứ mệnh kết nối doanh nghiệp toàn cầu với top nhân lực sáng giá nhất châu Á, từ khi thành lập cho đến nay, Sun* luôn nỗ lực để đem tới cho thế giới những điều ‘Awesome”.</p>',11,'Sun* Inc.'),(7,'HR South Department','Tầng 4, Tòa văn phòng T26, KĐT Times City, 458 Minh Khai, Phường Vĩnh Tuy, Quận Hai Bà Trưng,Thành phố Hà Nội, Việt Nam','vinid.net','<p>Follow the first mission is to support VinGroup\'s member companies in improving their customers\' experience with more added values through integrating advanced technologies to optimize the marketing activities and service management systems, VinID now is looking for top talents to join our team, offer good jobs with attractive salary!</p>',12,'Vinid Joint Stock Company'),(8,'HR South Department','Số 1 Giang Văn Minh, P Kim Mã, Q Ba Đình','vietteltelecom.vn','<p>Tập đoàn Công nghiệp – Viễn thông Quân đội Viettel - Nơi làm việc tốt nhất Việt Nam 2017, 2018 ngành Viễn thông (theo khảo sát Anphabe) là Doanh nghiệp viễn thông có tốc độ tăng trưởng nhanh nhất thế giới, luôn đi đầu trong đổi mới sáng tạo và luôn lắng nghe, thấu hiểu để đem tới những dịch vụ tốt nhất cho khách hàng.</p>',13,'Viettel Group'),(9,'HR South Department','số 62-64 Tôn Đức thắng, phường Trần Nguyễn Hãn, CN Hải Phòng','www.sacombank.com.vn','<p>Sacombank thành lập ngày 21/12/1991. Hiện vốn điều lệ đạt trên 18.852 tỷ đồng, là ngân hàng TMCP có ưu thế về mạng lưới hoạt động với gần 570 điểm giao dịch tại 52/63 tỉnh thành Việt Nam và 2 nước Lào, Campuchia.</p>',14,'Sacombank');
/*!40000 ALTER TABLE `congty` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-19  2:22:07
