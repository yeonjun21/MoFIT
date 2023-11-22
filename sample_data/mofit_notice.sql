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
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice` (
  `index` int NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL,
  `title` varchar(100) NOT NULL,
  `content` varchar(300) NOT NULL,
  `writer` int NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`index`),
  KEY `group_id` (`group_id`),
  KEY `writer` (`writer`),
  CONSTRAINT `notice_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`) ON DELETE CASCADE,
  CONSTRAINT `notice_ibfk_2` FOREIGN KEY (`writer`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice`
--

LOCK TABLES `notice` WRITE;
/*!40000 ALTER TABLE `notice` DISABLE KEYS */;
INSERT INTO `notice` VALUES (1,1,'산책 모임에 가입하신 걸 환영합니다 ^_^','저는 낙성대 산책을 즐기는 현지에요. 저희 모임에 가입하신 걸 환영합니당!',6,'2023-11-22 09:43:07'),(2,1,'매주 수요일 저녁 8시 정기 모임','매주 수요일 저녁 8시에 낙성대 공원에서 정기 산책 모임이 있어요.',6,'2023-11-22 09:43:52'),(3,3,'등산 모임 산 타는 쏘쏘입니다!','서울 남부와 수도권까지 등산을 즐기러 떠나는 등산 모임입니다. 저는 운영진 쏘쏘구요! 문의사항은 댓글 달아주세요.',18,'2023-11-22 10:39:28'),(4,3,'<신규 회원 공지사항>','신규 회원분들은 자유게시판에 가입인사 남겨주세요. 모임 참석도 언제든지 환영합니다!!',18,'2023-11-22 10:39:52'),(5,3,'매월 둘째, 넷째 일요일 오전 정기 등산 모임','한 달에 2번(매월 둘째, 넷째 일요일 오전) 정기 등산 모임이 있습니다. 많은 참여 부탁드려요!!',18,'2023-11-22 10:40:28'),(6,4,'개발도 열심히, 축구도 열심히!','열심히 개발하고 열심히 축구를 즐길 SSAFY인을 위한 모임입니다.',19,'2023-11-22 10:51:55'),(7,4,'<월드컵 예선 시청 공지>','같이 모여서 월드컵 예선 봐요! 경기 별로 공지와 신청은 이 공지사항에 댓글로 달겠습니다.',19,'2023-11-22 10:53:30'),(8,4,'자주 이용하는 풋살장 리스트','서울 용산 아이파크몰 / 보라매공원 축구장 / 서울 논현 누리풋볼클럽\n',19,'2023-11-22 10:54:39'),(9,9,'밍키에 러닝 모임에 오신 걸 환영합니다!','저는 러닝을 사랑하는 밍키에요. 가입해주신 분들 모두 감사드립니다! 저희 즐겁게 러닝하고 건강과 인연까지 모두 챙겨요!!!',29,'2023-11-22 11:34:24'),(10,9,'<신규 회원 공지사항>','새로 가입하신 신규 회원 분들은 자유게시판에 가입인사 남겨주시면 감사하겠습니다. 러닝 모임도 편하게 자주 참석해주세요!',29,'2023-11-22 11:34:55'),(11,9,'매주 목요일 저녁 정기 러닝','주 1회 매주 목요일 저녁 정기 러닝이 있습니다. 러닝 코스와 장소는 그때그때 다르니 매주 다시 공지 드릴게요. 저희 모임의 가장 메인 이벤트인 만큼 많은 참여 부탁드립니다!!',29,'2023-11-22 11:35:36');
/*!40000 ALTER TABLE `notice` ENABLE KEYS */;
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
