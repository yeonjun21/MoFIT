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
-- Table structure for table `comment_notice`
--

DROP TABLE IF EXISTS `comment_notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_notice` (
  `comment_idx` int NOT NULL AUTO_INCREMENT,
  `notice_idx` int NOT NULL,
  `content` varchar(300) NOT NULL,
  `writer` int NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`comment_idx`),
  KEY `notice_idx` (`notice_idx`),
  KEY `writer` (`writer`),
  CONSTRAINT `comment_notice_ibfk_1` FOREIGN KEY (`notice_idx`) REFERENCES `notice` (`index`) ON DELETE CASCADE,
  CONSTRAINT `comment_notice_ibfk_2` FOREIGN KEY (`writer`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_notice`
--

LOCK TABLES `comment_notice` WRITE;
/*!40000 ALTER TABLE `comment_notice` DISABLE KEYS */;
INSERT INTO `comment_notice` VALUES (1,1,'가입하신 분들은 자유게시판에 가입 인사 남겨주세요!!',6,'2023-11-22 09:43:22'),(2,1,'안녕하세요~ㅎㅎㅎ 가입인사 남길게요!',15,'2023-11-22 10:13:47'),(3,1,'많이많이 가입하셨으면 좋겠어요!!!',15,'2023-11-22 10:13:58'),(4,1,'저도 가입했어요! 가입인사 바로 남길게요!',22,'2023-11-22 10:25:42'),(5,9,'오오 러닝을 사랑하신다니 완전 러너 그 잡채!',30,'2023-11-22 11:47:06'),(6,9,'저는 가입인사 남기러 갈게요 총총~~~',30,'2023-11-22 11:48:05'),(7,9,'밍키님 모임 만들어주셔서 감사합니다ㅎㅎ',24,'2023-11-22 11:48:43'),(8,9,'밍키님이 운영진이군요! 반가워요!!',6,'2023-11-22 11:51:46');
/*!40000 ALTER TABLE `comment_notice` ENABLE KEYS */;
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
