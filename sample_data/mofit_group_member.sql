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
-- Table structure for table `group_member`
--

DROP TABLE IF EXISTS `group_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group_member` (
  `user_id` int NOT NULL,
  `group_id` int NOT NULL,
  `grade` enum('일반회원','운영진') NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `group_id` (`group_id`),
  CONSTRAINT `group_member_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `group_member_ibfk_2` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group_member`
--

LOCK TABLES `group_member` WRITE;
/*!40000 ALTER TABLE `group_member` DISABLE KEYS */;
INSERT INTO `group_member` VALUES (6,1,'운영진'),(15,1,'일반회원'),(1,1,'일반회원'),(2,1,'일반회원'),(3,1,'일반회원'),(18,1,'일반회원'),(22,1,'일반회원'),(27,1,'일반회원'),(16,1,'일반회원'),(5,1,'일반회원'),(13,1,'일반회원'),(7,1,'일반회원'),(22,2,'운영진'),(18,3,'운영진'),(1,3,'일반회원'),(28,3,'일반회원'),(27,3,'일반회원'),(24,3,'일반회원'),(17,3,'일반회원'),(23,3,'일반회원'),(14,3,'일반회원'),(10,3,'일반회원'),(26,3,'일반회원'),(25,3,'일반회원'),(16,3,'일반회원'),(20,3,'일반회원'),(19,4,'운영진'),(2,4,'일반회원'),(5,4,'일반회원'),(7,4,'일반회원'),(9,4,'일반회원'),(10,4,'일반회원'),(11,4,'일반회원'),(13,4,'일반회원'),(14,4,'일반회원'),(16,4,'일반회원'),(17,4,'일반회원'),(20,4,'일반회원'),(21,4,'일반회원'),(22,4,'일반회원'),(23,4,'일반회원'),(27,4,'일반회원'),(28,4,'일반회원'),(27,2,'일반회원'),(27,5,'운영진'),(29,9,'운영진'),(1,9,'일반회원'),(2,9,'일반회원'),(3,9,'일반회원'),(4,9,'일반회원'),(5,9,'일반회원'),(6,9,'일반회원'),(7,9,'일반회원'),(8,9,'일반회원'),(9,9,'일반회원'),(10,9,'일반회원'),(11,9,'일반회원'),(13,9,'일반회원'),(14,9,'일반회원'),(15,9,'일반회원'),(16,9,'일반회원'),(17,9,'일반회원'),(18,9,'일반회원'),(19,9,'일반회원'),(20,9,'일반회원'),(21,9,'일반회원'),(22,9,'일반회원'),(23,9,'일반회원'),(24,9,'일반회원'),(25,9,'일반회원'),(26,9,'일반회원'),(27,9,'일반회원'),(28,9,'일반회원'),(30,9,'일반회원'),(30,3,'일반회원'),(30,1,'일반회원'),(30,2,'일반회원'),(30,5,'일반회원');
/*!40000 ALTER TABLE `group_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-22 13:29:26
