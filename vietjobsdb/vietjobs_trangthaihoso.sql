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
-- Table structure for table `trangthaihoso`
--

DROP TABLE IF EXISTS `trangthaihoso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trangthaihoso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_ho_so` int NOT NULL,
  `id_cong_viec` int NOT NULL,
  `trang_thai` enum('Đang Chờ','Đã Chấp Thuận','Bị Từ Chối') NOT NULL DEFAULT 'Đang Chờ',
  PRIMARY KEY (`id`),
  KEY `id_HoSo` (`id_ho_so`),
  KEY `id_DangTinCongViec` (`id_cong_viec`),
  CONSTRAINT `FKmmurjq8il8llk4fdy5d9xuunu` FOREIGN KEY (`id_ho_so`) REFERENCES `hoso` (`id`),
  CONSTRAINT `trangthaihoso_ibfk_2` FOREIGN KEY (`id_cong_viec`) REFERENCES `congviec` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trangthaihoso`
--

LOCK TABLES `trangthaihoso` WRITE;
/*!40000 ALTER TABLE `trangthaihoso` DISABLE KEYS */;
INSERT INTO `trangthaihoso` VALUES (53,30,15,'Đã Chấp Thuận'),(55,32,15,'Bị Từ Chối'),(86,33,1,'Bị Từ Chối'),(87,33,2,'Đang Chờ'),(88,33,3,'Đã Chấp Thuận'),(89,33,5,'Đã Chấp Thuận'),(93,34,1,'Đang Chờ'),(95,34,17,'Đã Chấp Thuận'),(96,34,18,'Đang Chờ'),(100,30,1,'Đang Chờ'),(112,30,30,'Đã Chấp Thuận'),(116,30,30,'Đang Chờ'),(117,36,2,'Đang Chờ');
/*!40000 ALTER TABLE `trangthaihoso` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-19  2:22:08
