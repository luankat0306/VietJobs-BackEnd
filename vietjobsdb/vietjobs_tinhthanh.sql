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
-- Table structure for table `tinhthanh`
--

DROP TABLE IF EXISTS `tinhthanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tinhthanh` (
  `id` int NOT NULL AUTO_INCREMENT,
  `tinh_thanh` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tinhthanh`
--

LOCK TABLES `tinhthanh` WRITE;
/*!40000 ALTER TABLE `tinhthanh` DISABLE KEYS */;
INSERT INTO `tinhthanh` VALUES (1,'TP.HCM'),(2,'Hà Nội'),(9,'Bình Dương'),(19,'Đồng Nai'),(21,'Cần Thơ'),(22,'Hải Phòng'),(23,'Đà Nẵng'),(26,'Hưng Yên'),(27,'Hải Dương'),(30,'Quảng Ngãi'),(32,'Bắc Ninh'),(42,'Yên Bái'),(43,'Vĩnh Phúc'),(44,'Vĩnh Long'),(45,'Tuyên Quang'),(46,'Trà Vinh'),(47,'Tiền Giang'),(48,'Thanh Hóa'),(49,'Thái Nguyên'),(50,'Thái Bình'),(51,'Tây Ninh'),(52,'An Giang'),(53,'Bà Rịa - Vũng Tàu'),(54,'Sơn La'),(55,'Sóc Trăng'),(56,'Quảng Trị'),(57,'Quảng Ninh'),(58,'Quảng Nam'),(59,'Quảng Bình'),(60,'Phú Yên'),(61,'Phú Thọ'),(62,'Ninh Thuận'),(63,'Ninh Bình'),(64,'Nghệ An'),(65,'Nam Định'),(66,'Long An'),(67,'Lâm Đồng'),(68,'Lào Cai'),(69,'Lạng Sơn'),(70,'Lai Châu'),(71,'Kon Tum'),(72,'Kiên Giang'),(73,'Khánh Hòa'),(74,'Hòa Bình'),(75,'Hậu Giang'),(76,'Hà Tĩnh'),(77,'Hà Nam'),(78,'Hà Giang'),(79,'Gia Lai'),(80,'Đồng Tháp'),(81,'Điện Biên'),(82,'Đắc Nông'),(83,'Đắc Lắc'),(84,'Cửu Long'),(85,'Cao Bằng'),(86,'Cà Mau'),(87,'Bình Thuận'),(88,'Bình Phước'),(89,'Bình Định'),(90,'Bến Tre'),(91,'Bắc Giang'),(92,'Bắc Kạn'),(93,'Bạc Liêu'),(94,'Thừa Thiên Huế'),(95,'Toàn quốc'),(96,'Miền Bắc'),(97,'Miền Trung'),(98,'Miền Nam'),(99,'Nước ngoài');
/*!40000 ALTER TABLE `tinhthanh` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-19  2:22:09
