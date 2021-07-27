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
-- Table structure for table `nguoitimviec`
--

DROP TABLE IF EXISTS `nguoitimviec`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nguoitimviec` (
  `id` int NOT NULL AUTO_INCREMENT,
  `ngay_sinh` date DEFAULT NULL,
  `gioi_tinh` enum('Nam','Nữ') DEFAULT NULL,
  `dia_chi` varchar(255) DEFAULT NULL,
  `tinh_thanh` varchar(255) DEFAULT NULL,
  `fb` varchar(255) DEFAULT NULL,
  `ig` varchar(255) DEFAULT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_nguoitimviec_user1_idx` (`user_id`),
  CONSTRAINT `fk_nguoitimviec_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=300 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguoitimviec`
--

LOCK TABLES `nguoitimviec` WRITE;
/*!40000 ALTER TABLE `nguoitimviec` DISABLE KEYS */;
INSERT INTO `nguoitimviec` VALUES (279,'1999-06-03','Nam','304/13 Hòa Hưng P13 Q10','TP.HCM','https://www.facebook.com/profile.php?id=100008997271489',NULL,2),(280,'2021-01-01','Nữ','304/13 Hòa Hưng P13 Q10','',NULL,NULL,3),(281,'2021-01-08','Nam','sdsdsa304/13 Hòa Hưng P13 Q10','TP.HCM ',NULL,NULL,4),(282,'2021-01-01','Nữ','asdsd','TP.HCM ',NULL,NULL,5),(288,'2021-01-06','Nam','q2w3','TP.HCM ',NULL,NULL,20),(291,'2021-02-06','Nam','0938582362sss','TP.HCM ','https://www.facebook.com/profile.php?id=100008997271489','',25),(292,'2020-12-31','Nam','sds','TP.HCM ',NULL,NULL,26),(294,'2021-01-16','Nữ','sd','Tuyên Quang ',NULL,NULL,28),(295,'2021-01-13','Nam','304/13 Hoaf Huwng','TP.HCM ',NULL,NULL,29),(297,'2021-01-04','Nam','304/13 Hòa Hưng P13 Q10','TP.HCM',NULL,NULL,31),(298,'1999-06-03','Nam','304/13/Hoa Hung','TP.HCM',NULL,NULL,32),(299,NULL,NULL,NULL,NULL,NULL,NULL,33);
/*!40000 ALTER TABLE `nguoitimviec` ENABLE KEYS */;
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
