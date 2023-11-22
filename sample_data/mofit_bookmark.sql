-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mofit
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `bookmark`
--

DROP TABLE IF EXISTS `bookmark`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bookmark` (
  `user_id` int NOT NULL,
  `video_id` varchar(50) NOT NULL,
  `thumbnails` varchar(200) DEFAULT NULL,
  KEY `user_id` (`user_id`),
  CONSTRAINT `bookmark_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bookmark`
--

LOCK TABLES `bookmark` WRITE;
/*!40000 ALTER TABLE `bookmark` DISABLE KEYS */;
INSERT INTO `bookmark` VALUES (6,'O3GU4hMK75w','https://i.ytimg.com/vi/O3GU4hMK75w/mqdefault.jpg'),(6,'dxnS7RgcsCg','https://i.ytimg.com/vi/dxnS7RgcsCg/mqdefault.jpg'),(6,'nLAsU_z_U_c','https://i.ytimg.com/vi/nLAsU_z_U_c/mqdefault.jpg'),(6,'wy9K1qCJ_Y4','https://i.ytimg.com/vi/wy9K1qCJ_Y4/mqdefault.jpg'),(6,'OuP6X4n3tfc','https://i.ytimg.com/vi/OuP6X4n3tfc/mqdefault.jpg'),(6,'pya8S_PHUIo','https://i.ytimg.com/vi/pya8S_PHUIo/mqdefault.jpg'),(27,'MR1pO980vVk','https://i.ytimg.com/vi/MR1pO980vVk/mqdefault.jpg'),(27,'hOmhAXEne9w','https://i.ytimg.com/vi/hOmhAXEne9w/mqdefault.jpg'),(27,'tSyGUEAJ6QI','https://i.ytimg.com/vi/tSyGUEAJ6QI/mqdefault.jpg'),(27,'O3GU4hMK75w','https://i.ytimg.com/vi/O3GU4hMK75w/mqdefault.jpg'),(27,'wy9K1qCJ_Y4','https://i.ytimg.com/vi/wy9K1qCJ_Y4/mqdefault.jpg'),(27,'IJZvF8XITWo','https://i.ytimg.com/vi/IJZvF8XITWo/mqdefault.jpg'),(27,'GqZZTvVylBA','https://i.ytimg.com/vi/GqZZTvVylBA/mqdefault.jpg'),(27,'gn1Zqg81-N0','https://i.ytimg.com/vi/gn1Zqg81-N0/mqdefault.jpg'),(27,'etMFC5qP5RY','https://i.ytimg.com/vi/etMFC5qP5RY/mqdefault.jpg'),(27,'JGNJnMpxHgQ','https://i.ytimg.com/vi/JGNJnMpxHgQ/mqdefault.jpg'),(27,'iRfeov-7KeQ','https://i.ytimg.com/vi/iRfeov-7KeQ/mqdefault.jpg'),(27,'1OU7ZxJnYbU','https://i.ytimg.com/vi/1OU7ZxJnYbU/mqdefault.jpg'),(27,'eppTwxOicew','https://i.ytimg.com/vi/eppTwxOicew/mqdefault.jpg'),(27,'OuP6X4n3tfc','https://i.ytimg.com/vi/OuP6X4n3tfc/mqdefault.jpg'),(27,'O1AfIjuDzFk','https://i.ytimg.com/vi/O1AfIjuDzFk/mqdefault.jpg'),(30,'O3GU4hMK75w','https://i.ytimg.com/vi/O3GU4hMK75w/mqdefault.jpg'),(30,'dxnS7RgcsCg','https://i.ytimg.com/vi/dxnS7RgcsCg/mqdefault.jpg'),(30,'wy9K1qCJ_Y4','https://i.ytimg.com/vi/wy9K1qCJ_Y4/mqdefault.jpg'),(30,'OuP6X4n3tfc','https://i.ytimg.com/vi/OuP6X4n3tfc/mqdefault.jpg'),(30,'BVYKTeNUX30','https://i.ytimg.com/vi/BVYKTeNUX30/mqdefault.jpg'),(30,'gn1Zqg81-N0','https://i.ytimg.com/vi/gn1Zqg81-N0/mqdefault.jpg'),(30,'etMFC5qP5RY','https://i.ytimg.com/vi/etMFC5qP5RY/mqdefault.jpg'),(30,'eppTwxOicew','https://i.ytimg.com/vi/eppTwxOicew/mqdefault.jpg'),(30,'h0YH-jXr1n0','https://i.ytimg.com/vi/h0YH-jXr1n0/mqdefault.jpg'),(30,'JGNJnMpxHgQ','https://i.ytimg.com/vi/JGNJnMpxHgQ/mqdefault.jpg'),(30,'tSFr-MZIB7s','https://i.ytimg.com/vi/tSFr-MZIB7s/mqdefault.jpg'),(30,'8HDCdmmd2JM','https://i.ytimg.com/vi/8HDCdmmd2JM/mqdefault.jpg'),(30,'NHH9Bt_iOdc','https://i.ytimg.com/vi/NHH9Bt_iOdc/mqdefault.jpg'),(30,'GqZZTvVylBA','https://i.ytimg.com/vi/GqZZTvVylBA/mqdefault.jpg'),(30,'MFW6O-67c04','https://i.ytimg.com/vi/MFW6O-67c04/mqdefault.jpg');
/*!40000 ALTER TABLE `bookmark` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-22 13:29:25
