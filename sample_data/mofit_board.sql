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
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `index` int NOT NULL AUTO_INCREMENT,
  `group_id` int NOT NULL,
  `content` varchar(300) NOT NULL,
  `writer` int NOT NULL,
  `date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`index`),
  KEY `group_id` (`group_id`),
  KEY `writer` (`writer`),
  CONSTRAINT `board_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `group` (`group_id`) ON DELETE CASCADE,
  CONSTRAINT `board_ibfk_2` FOREIGN KEY (`writer`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,1,'저희 즐거운 산책해요!! >_<',6,'2023-11-22 09:44:09'),(2,1,'저는 서울대입구 사는 이지우입니다!! 잘 부탁드려요!ㅎㅎㅎ',15,'2023-11-22 10:14:20'),(3,1,'Hi I\'m minho',22,'2023-11-22 10:25:06'),(4,1,'저도 서울대입구 사는데, 모임 멤버 중에 관악구민이 많겠네요~!',22,'2023-11-22 10:25:55'),(5,3,'모두들 어서오세용~~~ >_<',18,'2023-11-22 10:40:42'),(6,3,'정기 모임은 멤버가 4명이 넘으면 시작할 예정입니다!! 많은 홍보 부탁드려요~!',18,'2023-11-22 10:41:06'),(7,4,'안녕하세요, 전 모임을 만든 정승원입니다. 모두 함께 즐겁게 축구해요!!',19,'2023-11-22 10:55:00'),(8,2,'내가 첫 글이다!!! 와아아아!!!!',27,'2023-11-22 11:04:42'),(9,3,'정기 모임 기대돼요! 얼른 멤버가 많아졌으면 좋겠어요ㅎㅎ',27,'2023-11-22 11:05:05'),(10,3,'등산 모임 끝나고 막걸리 필수인 거 아시죠?!',27,'2023-11-22 11:05:18'),(11,4,'저도 풋살경기에 끼워주세용!!',27,'2023-11-22 11:05:35'),(12,4,'부쩍 추워졌는데 다들 건강 조심하세요~!! 축구할 때 무리하지 마시구요!! 건강이 최고입니다! 화석이가 여러분 걱정하고 있어요 ^_^',27,'2023-11-22 11:12:58'),(13,4,'같이 헬스하실 분은 없나요?',22,'2023-11-22 11:13:25'),(14,1,'모임 끝나고 관악구에서 맥주 한 잔 해요!ㅎㅎ',15,'2023-11-22 11:14:50'),(15,1,'요즘 많이 춥던데 다들 따뜻하게 입고 오세요!!',15,'2023-11-22 11:15:29'),(16,1,'저녁에 러닝할 때 입을 가벼운 점퍼 추천해주세요! 다들 뭐 입으시나요??',15,'2023-11-22 11:16:05'),(17,1,'오늘 산책 겸 러닝 모임! 너무 즐거웠어요~! 현지님 모임 덕분에 유산소 따로 안 해도 돼서 너무 좋아요!',22,'2023-11-22 11:17:25'),(18,9,'저는 러닝을 사랑하는 밍키에요!! 모두들 즐겁게 러닝하고 좋은 인연 만들었으면 좋겠습니다 ^_^ 모두 반가워요!!',29,'2023-11-22 11:36:09'),(19,9,'신규 회원님들 모두모두 환영합니다~~~',29,'2023-11-22 11:46:33'),(20,9,'저는 러닝 시작한지 얼마 안 된 초보 러너에요! 밍키님과 함께 러닝 많이많이 해보겠습니다!! 저희 뒷풀이도 자주 해요 >_<',30,'2023-11-22 11:47:38'),(21,9,'저도 초보 러너지만 열심히 뛰어볼게요!!!',24,'2023-11-22 11:48:53'),(22,9,'러닝? 모르겠고 뒷풀이 달려~',2,'2023-11-22 11:49:34'),(23,9,'다음 러닝 모임 장소가 궁금해요!!',2,'2023-11-22 11:50:17'),(24,9,'새로 가입한 오화석입니다! 모임 열심히 참석할게요!!!',27,'2023-11-22 11:50:55'),(25,9,'우왕 저도 러닝 모임(인 척하는 산책 모임) 운영 중인데 놀러왔어요~~ 저희 모임도 많이 놀러오세요!',6,'2023-11-22 11:51:28'),(26,9,'다들 러닝 목표가 어떻게 되시나요? 전 체력이 좋아지고 싶어요!!',3,'2023-11-22 11:52:43'),(27,9,'다음 모임 끝나고 맥주 한 잔할 팟 구함!',3,'2023-11-22 11:52:51'),(28,1,'저는 새로 가입한 연준이에요! 모두들 잘 부탁드립니다!!ㅎㅎ',30,'2023-11-22 11:59:27'),(29,3,'다음 등산 모임 끝나면 막걸리 때려요~~ >_< ',30,'2023-11-22 11:59:51'),(30,2,'저는 헬린인데 같이 재밌게 운동하고 싶어요!!!ㅎㅎ 다들 3대 몇 치세요?',30,'2023-11-22 12:01:05'),(32,9,'다음 모임이 너무 기다려져요~~~ㅎㅎ 다음 모임까지 다들 감기 조심하시고 건강히 지내세요!!',30,'2023-11-22 13:26:40');
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
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
