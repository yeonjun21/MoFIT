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
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow` (
  `follower` int NOT NULL,
  `following` int NOT NULL,
  KEY `follower` (`follower`),
  KEY `following` (`following`),
  CONSTRAINT `follow_ibfk_1` FOREIGN KEY (`follower`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `follow_ibfk_2` FOREIGN KEY (`following`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
INSERT INTO `follow` VALUES (15,6),(15,1),(15,5),(6,1),(6,15),(6,18),(6,22),(6,27),(1,6),(4,6),(11,6),(24,6),(26,6),(16,6),(21,6),(22,6),(18,20),(18,1),(18,14),(18,10),(18,23),(19,28),(19,5),(19,16),(19,20),(19,21),(27,6),(27,15),(27,2),(27,7),(27,16),(27,3),(27,13),(27,9),(27,19),(22,27),(28,27),(8,27),(3,27),(5,27),(20,27),(24,27),(10,27),(1,27),(21,27),(27,14),(27,21),(27,23),(27,28),(29,1),(29,2),(29,3),(29,8),(29,10),(29,24),(29,30),(29,13),(30,29),(30,1),(30,18),(30,27),(30,6),(30,15),(30,2),(30,14),(30,26),(30,17),(30,9),(30,13),(30,22),(1,30),(2,30),(3,30),(4,30),(5,30),(6,30),(7,30),(8,30),(9,30),(10,30),(14,30),(15,30),(16,30),(22,30),(23,30),(27,30),(28,30),(26,30),(17,30),(18,30),(30,21),(30,4),(30,3);
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
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
