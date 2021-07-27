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
-- Table structure for table `hoso`
--

DROP TABLE IF EXISTS `hoso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_nguoi_tim_viec` int NOT NULL,
  `vi_tri_mm` varchar(100) NOT NULL,
  `id_nganh_nghe` int NOT NULL,
  `trinh_do` varchar(50) NOT NULL,
  `kinh_nghiem` varchar(50) NOT NULL,
  `hinh_thuc` varchar(50) NOT NULL,
  `ngoai_ngu` varchar(50) NOT NULL,
  `muc_luong` varchar(50) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `id_NguoiTimViec` (`id_nguoi_tim_viec`),
  KEY `id_NganhNghe` (`id_nganh_nghe`),
  CONSTRAINT `hoso_ibfk_1` FOREIGN KEY (`id_nguoi_tim_viec`) REFERENCES `nguoitimviec` (`id`),
  CONSTRAINT `hoso_ibfk_2` FOREIGN KEY (`id_nganh_nghe`) REFERENCES `nganhnghe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoso`
--

LOCK TABLES `hoso` WRITE;
/*!40000 ALTER TABLE `hoso` DISABLE KEYS */;
INSERT INTO `hoso` VALUES (30,279,'Nhân Viên',129,'Đại Học','Chưa','Parttime','Tiếng Anh','1.000.000 VNĐ'),(31,280,'Lập Trình Viên',40,'Đại Học','Chưa Có','Thực tập','Tiếng Anh','8 Triệu (VNĐ)'),(32,281,'nhan vien',22,'VCS','10 nam','Fulltime','English','10 trieu'),(33,282,'Nhân viên',27,'Trung Học','1 năm','Toàn thời gian','Tiếng Anh','10 Triệu (VNĐ)'),(34,291,'luan@23sdsd',19,'Trung học','Chưa Có','Parttime','Tiếng Anh','100 USD'),(35,297,'lap trinh vien',40,'Đại học','Chưa Có','Fulltime','Tiếng Anh','13.000.000 VNĐ'),(36,298,'IT',40,'Đại học','Dưới 1 năm','Fulltime','Tiếng Anh','10.000.000 VNĐ');
/*!40000 ALTER TABLE `hoso` ENABLE KEYS */;
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
