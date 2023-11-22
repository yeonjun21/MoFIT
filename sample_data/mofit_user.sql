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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(10) NOT NULL,
  `nickname` varchar(10) NOT NULL,
  `img` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `nickname` (`nickname`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'ksa@ssafy.com','1234qwer','강수아','수아',NULL),(2,'ksm@ssafy.com','1234qwer','고승민','승민',NULL),(3,'khr@ssafy.com','1234qwer','고해림','해림',NULL),(4,'kay@ssafy.com','1234qwer','김아영','아영',NULL),(5,'kth@ssafy.com','1234qwer','김태훈','태훈',NULL),(6,'khj@ssafy.com','1234qwer','김현지','현지',NULL),(7,'psw@ssafy.com','1234qwer','박세웅','세웅',NULL),(8,'bcj@ssafy.com','1234qwer','백천주','천주',NULL),(9,'sjs@ssafy.com','1234qwer','송준석','준석',NULL),(10,'asj@ssafy.com','1234qwer','안수진','수진',NULL),(11,'ajh@ssafy.com','1234qwer','안준현','준현',NULL),(13,'ykw@ssafy.com','1234qwer','유광우','광우',NULL),(14,'yjh@ssafy.com','1234qwer','유제훈','제훈',NULL),(15,'ljw@ssafy.com','1234qwer','이지우','지우',NULL),(16,'ljy@ssafy.com','1234qwer','임종율','종율',NULL),(17,'jsh@ssafy.com','1234qwer','장승호','승호',NULL),(18,'jsy@ssafy.com','1234qwer','정소영','소영',NULL),(19,'jsw@ssafy.com','1234qwer','정승원','승원',NULL),(20,'csh@ssafy.com','1234qwer','조성호','성호',NULL),(21,'cyw@ssafy.com','1234qwer','조용운','용운',NULL),(22,'cmh@ssafy.com','1234qwer','최민호','민호',NULL),(23,'cjc@ssafy.com','1234qwer','최지찬','지찬',NULL),(24,'lsj@ssafy.com','1234qwer','이승재','승재',NULL),(25,'kdh@ssafy.com','1234qwer','김도하','도하',NULL),(26,'usw@ssafy.com','1234qwer','엄세원','세원',NULL),(27,'ohs@ssafy.com','1234qwer','오화석','화석',NULL),(28,'ydg@ssafy.com','1234qwer','유동건','동건',NULL),(29,'smk@ssafy.com','1234qwer','손민기','밍키',NULL),(30,'cyj@ssafy.com','1234qwer','최연준','연준',NULL);
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

-- Dump completed on 2023-11-22 13:29:26
