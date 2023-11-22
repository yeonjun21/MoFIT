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
-- Table structure for table `comment_board`
--

DROP TABLE IF EXISTS `comment_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_board` (
  `comment_idx` int NOT NULL AUTO_INCREMENT,
  `board_idx` int NOT NULL,
  `content` varchar(300) NOT NULL,
  `writer` int NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_idx`),
  KEY `board_idx` (`board_idx`),
  KEY `writer` (`writer`),
  CONSTRAINT `comment_board_ibfk_1` FOREIGN KEY (`board_idx`) REFERENCES `board` (`index`) ON DELETE CASCADE,
  CONSTRAINT `comment_board_ibfk_2` FOREIGN KEY (`writer`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_board`
--

LOCK TABLES `comment_board` WRITE;
/*!40000 ALTER TABLE `comment_board` DISABLE KEYS */;
INSERT INTO `comment_board` VALUES (1,1,'네! 네! 대장님!',15,'2023-11-22 10:17:49'),(2,1,'산책 기대됩니다~! 가끔 러닝도 해요!!',22,'2023-11-22 10:25:25'),(3,4,'오 저도 서울대입구 살아요!! 민호님은 역 근처 사시나요??',15,'2023-11-22 11:14:33'),(4,18,'흠 아직 무플이네..',29,'2023-11-22 11:57:13'),(5,18,'제가 댓글 달아드릴게요!',30,'2023-11-22 13:27:52');
/*!40000 ALTER TABLE `comment_board` ENABLE KEYS */;
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
