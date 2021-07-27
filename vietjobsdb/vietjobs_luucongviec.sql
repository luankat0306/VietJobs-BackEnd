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
-- Table structure for table `luucongviec`
--

DROP TABLE IF EXISTS `luucongviec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `luucongviec` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_nguoi_tim_viec` int NOT NULL,
  `id_cong_viec` int NOT NULL,
  `luu` enum('Lưu','Chưa Lưu') NOT NULL DEFAULT 'Chưa Lưu',
  PRIMARY KEY (`id`),
  KEY `id_NguoiTimViec` (`id_nguoi_tim_viec`),
  KEY `id_DangTinCongViec` (`id_cong_viec`),
  CONSTRAINT `FK2g9lwdhlquhvsxqu3u0gtsqd7` FOREIGN KEY (`id_nguoi_tim_viec`) REFERENCES `nguoitimviec` (`id`),
  CONSTRAINT `FKmfpqfxdq845sv5fmhio2gjqbm` FOREIGN KEY (`id_cong_viec`) REFERENCES `congviec` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `luucongviec`
--

LOCK TABLES `luucongviec` WRITE;
/*!40000 ALTER TABLE `luucongviec` DISABLE KEYS */;
INSERT INTO `luucongviec` VALUES (78,279,4,'Lưu'),(83,295,1,'Lưu'),(85,279,1,'Lưu'),(86,279,5,'Lưu'),(87,279,1,'Lưu');
/*!40000 ALTER TABLE `luucongviec` ENABLE KEYS */;
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
