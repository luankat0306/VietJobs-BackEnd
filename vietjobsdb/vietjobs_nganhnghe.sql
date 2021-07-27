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
-- Table structure for table `nganhnghe`
--

DROP TABLE IF EXISTS `nganhnghe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nganhnghe` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nganh_nghe` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=132 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nganhnghe`
--

LOCK TABLES `nganhnghe` WRITE;
/*!40000 ALTER TABLE `nganhnghe` DISABLE KEYS */;
INSERT INTO `nganhnghe` VALUES (19,'Báo chí-Truyền hình'),(20,'Bảo hiểm'),(21,'Biên-Phiên dịch'),(22,'Bưu chính'),(23,'Chứng khoán- Vàng'),(24,'Công nghệ cao'),(25,'Công nghiệp'),(26,'Dầu khí-Hóa chất'),(27,'Dệt may - Da giày'),(28,'Dịch vụ'),(29,'Du lịch'),(30,'Điện tử viễn thông'),(31,'Game'),(32,'Giáo dục-Đào tạo'),(33,'Hàng gia dụng'),(34,'Hàng hải'),(35,'Hàng không'),(36,'Hoá học-Sinh học'),(37,'Hoạch định-Dự án'),(38,'In ấn-Xuất bản'),(39,'IT phần cứng/mạng'),(40,'IT phần mềm'),(41,'KD bất động sản'),(42,'Khách sạn-Nhà hàng'),(43,'Kho vận-Vật tư'),(44,'Kiến trúc-TK nội thất'),(46,'Làm bán thời gian'),(47,'Lao động phổ thông'),(48,'Marketing-PR'),(49,'Ngân hàng'),(50,'Ngành nghề khác'),(51,'Nghệ thuật - Điện ảnh'),(52,'Ngoại thương-Xuất nhập khẩu'),(53,'Người giúp việc'),(54,'Nhân sự'),(55,'Nông-Lâm-Ngư nghiệp'),(56,'NV trông quán Internet'),(57,'Ô tô - Xe máy'),(58,'Pháp lý-Luật'),(59,'Promotion Girl (PG)'),(60,'Quan hệ đối ngoạ'),(61,'Sinh viên làm thêm'),(62,'Spa-Mỹ phẩm-Trang sức'),(63,'Tài chính-Đầu tư'),(64,'Thiết kế đồ hoạ web'),(65,'Thiết kế-Mỹ thuật'),(66,'Thời trang'),(67,'Thủ công mỹ nghệ'),(68,'Thư ký-Trợ lý'),(95,'Kỹ thuật ứng dụng'),(120,'Thực phẩm-Đồ uống'),(121,'Thực tập'),(122,'Thương mại điện tử'),(123,'Tiếp thị-Quảng cáo'),(124,'Tổ chức sự kiện-Quà tặng'),(125,'Vận tải'),(126,'Y tế-Dược'),(129,'Kế toán');
/*!40000 ALTER TABLE `nganhnghe` ENABLE KEYS */;
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
