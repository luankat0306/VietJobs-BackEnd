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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  `image` varchar(255) DEFAULT 'avatar.png',
  PRIMARY KEY (`id`),
  UNIQUE KEY `Email` (`email`),
  UNIQUE KEY `Username` (`username`),
  UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Võ Trí Luân','0938582362','votriluan99@gmail.com','$2a$10$RWMKDzwcnOzNskK72JzeqeKa2RnCyq.VEJQMl6j9gwNHR56hM48bS','admin','admin.png'),(2,'Võ Trí Luân','0935884510','luan@23ss','$2a$10$xzbISfyxfVNtbWIfHJDhPO3CPKmdlcRnMUGL9qiOhqyLjpxM..pTS','luan123a','admin.png'),(3,'Võ Trí Luân','0935884510','votriluan06@gmail.com','$2a$10$EG0hts7tCUczxTI94JGA5u5FEMefiXxh/nciaxbqcKqfqEdld1Lke','luan12','avatar.png'),(4,'Võ Trí Luân','0935884510','votriluan36@gmail.com1','$2a$10$rVm23Nbakp8t49z5nJNj8ubdcViyPjeFtFsYk9aEuaEFlMWlGrxEe','adminasd','avatar.png'),(5,'Võ Trí Luâna','0935884510','votriluan36@gmail.coma','$2a$10$FoCUKuudw9LjXauqmkBCh.Z405PKuHF6T3gz/9Gk0deaVYKM1Z6La','213asd','avatar.png'),(6,'samsung','0123456789','samsung@samsung.com','$2a$10$Sf/C3hQBTM4mKqX8RDwe2O5oXKRLeW8pP/cI3FTglcDubQ8nNuebK','samsung','black-samsung-logo-png-21.png'),(7,'lg','02439345151','lg@lg.com','$2a$10$FoCUKuudw9LjXauqmkBCh.Z405PKuHF6T3gz/9Gk0deaVYKM1Z6La','lg','lg-logo-1.png'),(8,'Coca Cola','0838961000','cocacola@cocacolavietnam.com','$2a$10$FoCUKuudw9LjXauqmkBCh.Z405PKuHF6T3gz/9Gk0deaVYKM1Z6La','coca','coca-cola-logo-10.png'),(9,'kms','0938118997','kms@kms-technology.com','$2a$10$FoCUKuudw9LjXauqmkBCh.Z405PKuHF6T3gz/9Gk0deaVYKM1Z6La','kms','kms.png'),(10,'fpt','02873002222','hotrokhachhang@fpt.com.vn','$2a$10$8ZuANCaslc8sgae3HSwJTe7vhBiyE0E/uDEBNuta/4wbdnIPWIZPW','fpt','logo-fpt.png'),(11,'Sun* Inc.','02437955417','sun@sun-asterisk.vn','$2a$10$FoCUKuudw9LjXauqmkBCh.Z405PKuHF6T3gz/9Gk0deaVYKM1Z6La','sun','sun.jpg'),(12,'vin','19006959','cskh@vinid.net','$2a$10$FoCUKuudw9LjXauqmkBCh.Z405PKuHF6T3gz/9Gk0deaVYKM1Z6La','vin','vin.png'),(13,'viettel','18008098','viettel@vietteltelecom.vn','$2a$10$rVm23Nbakp8t49z5nJNj8ubdcViyPjeFtFsYk9aEuaEFlMWlGrxEe','viettel','Logo_Viettel.svg.png'),(14,'sacombank','1900555588','sacombank@sacombank.com.vn','$2a$10$FoCUKuudw9LjXauqmkBCh.Z405PKuHF6T3gz/9Gk0deaVYKM1Z6La','sacombank','Sacombank-logo.png'),(20,'Võ Trí Luâna','0935884510','votriluan36@gmail.com','$2a$10$EYvutpRreEAQzJKCL8/XnuFR/SjObfjYy5Ds1lV0tNpuDDq/dUcDy','dsd','avatar.png'),(25,'luana','0938582362','luan@23','$2a$10$FoCUKuudw9LjXauqmkBCh.Z405PKuHF6T3gz/9Gk0deaVYKM1Z6La','as','avatar.png'),(26,'Võ Trí Luân','0935884510','votriluan36@gmail.comsddsd','$2a$10$KfDGzwQo/AiDRSE7qIWW3us8xqvD96dCD89cNk8G/ojadZrhe8Ui2','sdsd','avatar.png'),(28,'Võ Trí Luân','0935884510','votriluan36@gmail.comssss','$2a$10$Eg497zwlx.gZ7sgwGO.R7OmNnznhS0rj4DOBVQeeuK7Lli1GwgYu.','d','avatar.png'),(29,'luan','0938582362','luan@gmail.com','$2a$10$K66uXrUnLd/qgqFmL0QANueShLl/0h4CETMtP3rjTsKhqjNlhHFZi','luan11','http://localhost:8080/api/downloadFile/admin.png'),(31,'vo tri luan','0938582362','votriluan99@gmail.comabc','$2a$10$HEVVbTVDAp9SHQH2dFoAo.4TKJLXMOSESPnVt2wbl5W7ZUWvvhREq','luan1','admin.png'),(32,'Võ Trí Luân','0938582362','luan_hero@zing.vn','$2a$10$ER6WGAgpNKWFQ3rywOfoeuJJfzdsjSihJe7TRroMXE5d577pWvCpC','user01','default.png'),(33,NULL,NULL,'as@gmail.com','$2a$10$Gh89cwqQGJ3WDL4C4cKD5.lEy3ag.bIarEYKZH7CJ/iBngsFb3qh2','user02','default.png');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
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
