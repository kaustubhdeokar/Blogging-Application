-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: completeblogapp
-- ------------------------------------------------------
-- Server version	8.0.36-0ubuntu0.22.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `blog_user`
--

DROP TABLE IF EXISTS `blog_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_user` (
  `userid` bigint NOT NULL,
  `created` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_user`
--

LOCK TABLES `blog_user` WRITE;
/*!40000 ALTER TABLE `blog_user` DISABLE KEYS */;
/*!40000 ALTER TABLE `blog_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `blog_user_SEQ`
--

DROP TABLE IF EXISTS `blog_user_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `blog_user_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `blog_user_SEQ`
--

LOCK TABLES `blog_user_SEQ` WRITE;
/*!40000 ALTER TABLE `blog_user_SEQ` DISABLE KEYS */;
INSERT INTO `blog_user_SEQ` VALUES (1);
/*!40000 ALTER TABLE `blog_user_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment`
--

DROP TABLE IF EXISTS `comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment` (
  `commentid` bigint NOT NULL,
  `createddate` datetime(6) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `postid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `FKlovp15gs1pi5dvo88erc45sk7` (`postid`),
  KEY `FKe7pshbkin4984x23q4wboi5ka` (`userid`),
  CONSTRAINT `FKe7pshbkin4984x23q4wboi5ka` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKlovp15gs1pi5dvo88erc45sk7` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'2024-03-17 12:02:12.519075','Seems interesting.. let me try',9,2),(2,'2024-03-18 17:14:53.173339','anywhere.',6,3),(3,'2024-03-18 17:21:16.135981','java ?',6,1),(52,'2024-03-19 17:18:34.388637','aus open',11,3),(102,'2024-03-20 18:51:00.535517','random comment',11,3),(152,'2024-03-21 16:25:58.701065','looks good. ',6,4),(202,'2024-03-21 17:06:02.521227','some comment',6,1),(203,'2024-03-21 17:09:24.465813','great',9,3),(204,'2024-03-21 17:10:48.470886','wow',3,1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comment_SEQ`
--

DROP TABLE IF EXISTS `comment_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comment_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment_SEQ`
--

LOCK TABLES `comment_SEQ` WRITE;
/*!40000 ALTER TABLE `comment_SEQ` DISABLE KEYS */;
INSERT INTO `comment_SEQ` VALUES (301);
/*!40000 ALTER TABLE `comment_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `postid` bigint NOT NULL,
  `createddate` datetime(6) DEFAULT NULL,
  `description` text,
  `postname` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `votecount` int DEFAULT NULL,
  `topic` bigint DEFAULT NULL,
  `userId` bigint DEFAULT NULL,
  PRIMARY KEY (`postid`),
  KEY `FKi8ih8hohm6g8bot1sithxy813` (`topic`),
  KEY `FKm0h904i1j7xr6fovb3bhoh1p1` (`userId`),
  CONSTRAINT `FKi8ih8hohm6g8bot1sithxy813` FOREIGN KEY (`topic`) REFERENCES `topic` (`topicid`),
  CONSTRAINT `FKm0h904i1j7xr6fovb3bhoh1p1` FOREIGN KEY (`userId`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (2,'2024-03-17 10:16:20.683351','This is your safe place for questions on financial careers, homework problems and finance in general. No question in the finance domain is unwelcome.Replies are expected to be constructive and civil. Any questions about your personal finances belong in r/PersonalFinance, and career-seekers are encouraged to also visit r/FinancialCareers.','Q/A\'s','',3,54,3),(3,'2024-03-17 10:20:36.756563','Dear residents of Mumbai. Thank you for your hospitality. I spent a week in your fair city, I rode the locals every day, during rush hour at that, ate lots of yummy street foods, rode in auto rickshaws and danced as often as I could. I haggled over prices at Crawford market and made everlasting memories. I tipped lavishly and enjoyed everything your city offers. I spent every day wandering, getting lost in magical neighborhoods and watching the frantic pace of life in Mumbai.','To Mumbai, A love letter','',1,102,3),(4,'2024-03-17 10:21:13.830116','CA Amber Dalal of Ritz Consultancy has absconded, leaving hundreds of investors thronging the Oshiwara Police Station as a Ponzi fraud of over Rs 1000 crores comes to light.','Fraud of 1096 crores in Mumbai','',-1,102,3),(5,'2024-03-17 10:22:33.024319','I’m planning on visiting mumbai for like 5 days next week and I’m looking for recommendations! I am also planning on doing my masters in this city so I would love some recs for places I can go regularly. Location and areas I will be in and around: Vidya Vihar East, Bandra west and Govandi','Mumbai recommendations!','',2,102,3),(6,'2024-03-17 10:26:36.144008','I wanna live economically comfortable so im thinking about going back to programming, I learned c and a little c++ but back-end is my go to at this point. wheret do you suggest I should start to learn back end?','Resource for learning back-end from scratch.','',5,52,3),(7,'2024-03-17 10:27:06.632783','A backend developer with experience of 1.5 years in php core, laravel. Want some online clients. How\'s goona find them...','Job required.','',0,52,3),(8,'2024-03-17 10:28:25.983113','I am creating an app that retrieves information from PCs, such as memory usage and CPU usage. I send this information to the backend every second. The backend then checks for any anomalies in resource usage and notifies the frontend accordingly. In this scenario, should I fetch the API every second to check for anomalies, or should I use web sockets so that the backend notifies the frontend if any anomaly is detected?','Web Socket or Fetch api every second?','',0,52,3),(9,'2024-03-17 10:30:33.677122','Multivariate calculus and vector calculus Complex numbers Linear algebra (All the basic stuff, but also decompositions, inner product spaces, jordan canonical form, singular value decomposition etc.)','Self-studying math - what\'s the next step?','',1,53,3),(10,'2024-03-17 10:31:04.955866','Brilliant.org used to have a community section where anyone can post math problems and then you can submit the answer directly in that problem page and gain some points. I find that the problems in the community section are very diverse (in difficulty, topic, etc.) and has a very unique flavor that you can’t find in schools, universities, or text books. A lot of them are very creative and puzzling. There are also some competitive aspect to it. The point system, leaderboard, and mastery badge make it much more fun to grind on mountains of problems.','Are there any sites similar to Brilliant.org’s old community section?','',0,53,3),(11,'2024-03-17 10:48:42.943690','The Australian Open is a major tennis tournament held annually over the last fortnight of January in Melbourne, Australia and is the first of the four major tennis tournaments of the year, known as the four Grand Slams.','Aus Open','',3,105,3),(12,'2024-03-17 10:49:16.819622','The French Open is the second of the four major annual tennis Grand Slam tournaments. It is the premier clay court tennis championship event in the world.','French Open','',2,105,3),(13,'2024-03-17 10:49:56.959169','Topic for the Wimbledon tennis championship.','Wimbledon','',2,105,3),(14,'2024-03-17 10:51:29.159675',' The US Open is the last of the four major annual tennis Grand Slam tournament.','US Open','',1,105,3),(52,'2024-03-19 16:19:46.105817','I’ve seen a bunch of posts asking questions like “what’s the most difficult area of math you’ve seen?” or similar lately. I started thinking about taking into to topology and how that course was pretty difficult for me, but went we got to algebraic topology I distinctly remember not even being close to understanding it. Like I felt completely hopeless in those lectures.','Mathematics Can Be Humbling','',0,53,3);
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post_SEQ`
--

DROP TABLE IF EXISTS `post_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post_SEQ`
--

LOCK TABLES `post_SEQ` WRITE;
/*!40000 ALTER TABLE `post_SEQ` DISABLE KEYS */;
INSERT INTO `post_SEQ` VALUES (301);
/*!40000 ALTER TABLE `post_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refreshtoken`
--

DROP TABLE IF EXISTS `refreshtoken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refreshtoken` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdDate` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refreshtoken`
--

LOCK TABLES `refreshtoken` WRITE;
/*!40000 ALTER TABLE `refreshtoken` DISABLE KEYS */;
INSERT INTO `refreshtoken` VALUES (1,'2024-03-17 09:28:50.060162','4752eec1-0669-4c53-be42-24ee5d3e92cd'),(2,'2024-03-17 09:54:43.891210','e8d83429-e0cb-45cc-bb67-479c40e32083'),(3,'2024-03-17 10:00:10.047850','3f92279e-b610-4c6d-a61f-1d539b0f2be8'),(4,'2024-03-17 10:44:06.744661','5efcb502-c0c7-452e-87aa-479ced045a10'),(5,'2024-03-17 10:46:25.618886','e784af9d-fc1b-42c8-8abb-ca44b9dc2fd2'),(6,'2024-03-17 10:52:47.802212','dc44f05f-67ef-4244-a939-1c5db43bc48f'),(7,'2024-03-17 10:55:07.361214','52145793-8b14-45fe-8acf-7276f6ecadff'),(8,'2024-03-17 11:04:40.021583','a0d9ce95-26d9-42ed-898f-5bf18a93ead5'),(9,'2024-03-17 11:07:43.707370','d5167e35-f215-403b-9f55-d0d4d65ef5b0'),(10,'2024-03-17 11:55:25.867743','8849073c-c5e2-48b9-937f-ba676987c354'),(11,'2024-03-17 11:56:00.854075','5d08efc5-3aba-404f-b98c-4e59ebd70c75'),(12,'2024-03-17 11:59:27.535558','08937470-3a5b-458a-b11b-c9bf81309469'),(13,'2024-03-17 12:04:54.523473','aaea5b1a-b085-4bc5-b8a3-db3e8528e8f3'),(14,'2024-03-17 16:02:30.150726','1cacf3d6-63e5-4415-87ad-38c1e7b818c2'),(15,'2024-03-17 16:04:22.814431','e308f972-33c6-449d-8001-bf406581ceb1'),(16,'2024-03-17 16:06:19.825688','4bfafeb2-9608-40fa-818c-1eaa28bc01f0'),(17,'2024-03-17 16:35:56.571859','96732eb0-a69d-4caa-9ea6-562d16684eb3'),(18,'2024-03-17 16:50:43.846058','659e9d18-d376-4a0f-83d5-ea371c356f03'),(19,'2024-03-17 16:52:05.267238','9cf7d6d1-a16d-4b28-a719-4008b046e308'),(20,'2024-03-17 16:53:29.990511','b3adf712-2321-4b95-8f86-2be04d6ed95e'),(21,'2024-03-17 16:58:13.740866','782d994f-1e25-4c93-858f-55cd9b202a4f'),(22,'2024-03-17 17:52:01.504927','54bbf7d6-368f-4320-9810-5f0879b3e201'),(23,'2024-03-17 18:00:02.761263','33bfc6b8-9e36-435d-83b8-d4bfe8fad1c0'),(24,'2024-03-17 18:21:24.126727','42a9c610-e962-486b-8bd2-9cd9ded0ecaa'),(25,'2024-03-17 18:26:13.232541','a314625c-9eb5-459a-9281-9ece95e810d8'),(26,'2024-03-17 18:28:25.679846','91c313a4-a9e4-4f91-9948-f047cb05f0ff'),(27,'2024-03-17 18:30:23.517549','66c0149c-2c30-447a-ae2b-063c8d78eab9'),(28,'2024-03-18 15:39:37.330878','c0a1fb26-c6e2-456f-b10e-fb50dc33f31f'),(29,'2024-03-18 15:40:34.670496','4c0441a5-85a4-4fb2-9fde-7d9a7999ff1f'),(30,'2024-03-18 15:49:25.740555','d88c1437-8361-4695-a78b-6bf16f7cb294'),(31,'2024-03-18 15:54:52.724850','a930139f-3dd7-41a8-a9fd-ce361bce4045'),(32,'2024-03-18 15:57:18.653073','26e446bb-f809-491b-b4b8-22c17bc02988'),(33,'2024-03-18 16:10:19.858662','3e543050-223e-4a38-b862-10e79cf036b6'),(34,'2024-03-18 16:10:51.893251','e7ecc40d-8fce-4497-97b1-2a32e42c8e0f'),(35,'2024-03-18 16:17:56.000472','4814a6ae-87a1-4740-bc14-0fcbbf419dac'),(36,'2024-03-18 16:53:44.536267','94dfafbc-fd00-4cf9-8556-4f5ce8c8368d'),(37,'2024-03-18 16:56:34.834992','87c19e61-ce85-43f6-8bc7-f7ea07e48e57'),(38,'2024-03-18 17:15:02.109963','b9d6c148-eab7-47df-91fb-2eeb954da93d'),(39,'2024-03-19 16:15:58.379382','143bf382-ef8a-44b4-8952-2e39b654bce0'),(40,'2024-03-19 16:23:46.982852','915bfd79-cc4b-4562-85e2-f8a51baed3f9'),(41,'2024-03-19 17:17:53.957088','4a1ab4a3-e7d1-40d8-b857-507fde2753fa'),(42,'2024-03-19 17:53:05.939355','c0f2aa00-193e-4395-8159-d20aebaaae54'),(43,'2024-03-19 18:14:38.703006','cf6a807f-8611-4d1c-8319-4badc8a32f73'),(44,'2024-03-19 18:23:13.340408','115d5e74-7e50-43bf-a903-e3a26eec0cf3'),(45,'2024-03-19 18:25:11.464097','60cc390e-78ba-4665-bf59-8a5c2e238335'),(46,'2024-03-19 18:31:50.470236','78448622-8028-4549-88b5-b04c366d2827'),(47,'2024-03-19 18:41:06.142073','f2a50d4a-1e6d-46cf-b8a7-866936e967fd'),(48,'2024-03-20 03:14:14.400551','1dc3f0d8-6c39-442b-9c89-662ac96cd385'),(49,'2024-03-20 03:56:21.484927','a7e4041a-59a7-4c5b-b385-0a0cf34cbd78'),(50,'2024-03-20 16:08:44.150609','141ea13d-3fa2-405c-a800-a5f5bb456134'),(51,'2024-03-20 16:30:59.013591','cfc70a6c-4fe6-4b4e-b475-12e70a63fd58'),(52,'2024-03-20 16:45:24.884203','dd1ec214-7d08-4e35-a0d8-04f711bb32bc'),(53,'2024-03-20 18:49:22.523998','d708a5ea-ec43-42d1-88d6-84d747facaec'),(54,'2024-03-20 19:14:31.576946','45ccdd8a-4fac-40d3-84cb-c73a4839f7a9'),(55,'2024-03-21 16:09:50.625424','bc80ac0c-efb8-4d95-ad04-27bc6bed5b0b'),(56,'2024-03-21 16:11:13.974867','d693fc11-691e-4ae1-8e66-75a1b85b3644'),(57,'2024-03-21 16:11:32.946789','b4fe9774-cf96-4240-afee-0622dfe92e90'),(58,'2024-03-21 16:13:53.586807','ad4cf6fd-6908-430e-a624-2614e5c015ad'),(59,'2024-03-21 16:14:07.722803','50dae801-d0d6-4b40-be0e-884352e41675'),(60,'2024-03-21 16:17:33.691466','8f1e83c2-b5c2-4d76-bce0-ab45a391c44c'),(61,'2024-03-21 16:23:32.795993','df746f48-7f6d-41fd-b5db-608fd53655b3'),(62,'2024-03-21 17:04:50.039004','30746b85-5273-4115-9eca-b196fcbaa55d'),(63,'2024-03-21 17:04:58.502034','d140394f-9de2-415b-a62f-a7adead04439'),(64,'2024-03-21 17:06:16.040740','12d792e9-3154-4106-9f4c-be09c367d77e'),(65,'2024-03-21 17:09:01.321156','3605061c-358a-4151-8fdc-bdd932a210a7'),(66,'2024-03-21 17:09:39.125793','924bd6ce-5b49-4bd4-b371-2e361daae336'),(67,'2024-03-21 17:10:37.893127','7d4b8ba3-e0e2-499c-9b9f-b159c2c5c214');
/*!40000 ALTER TABLE `refreshtoken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `roleid` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`roleid`),
  UNIQUE KEY `UK_ofx66keruapi6vyqpv6f2or37` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'ROLE_USER');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token`
--

DROP TABLE IF EXISTS `token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token` (
  `id` bigint NOT NULL,
  `expiryDate` datetime(6) DEFAULT NULL,
  `now` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  `user_userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_lmxnbqcdc7kvjkg37gffa9ijb` (`user_userid`),
  CONSTRAINT `FKp2lrydh553poqd4jq5f2gxh5u` FOREIGN KEY (`user_userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token`
--

LOCK TABLES `token` WRITE;
/*!40000 ALTER TABLE `token` DISABLE KEYS */;
INSERT INTO `token` VALUES (1,'2024-03-20 09:25:54.495395','2024-03-17 09:26:09.551560','7a4021db-c344-4dd2-8ff4-a7f2e3bc1005',1),(2,'2024-03-20 09:25:54.495395','2024-03-17 09:26:38.553002','d5f0e033-7273-4d98-b6fe-1ccd1085b74a',2),(3,'2024-03-20 09:25:54.495395','2024-03-17 09:26:45.001943','1453cd43-f0d8-4765-b72d-a7c2fcd98ed8',3),(4,'2024-03-20 09:25:54.495395','2024-03-17 09:27:24.647134','5977e555-bc79-42dc-a5c3-08c4df269d94',4);
/*!40000 ALTER TABLE `token` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `token_SEQ`
--

DROP TABLE IF EXISTS `token_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `token_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `token_SEQ`
--

LOCK TABLES `token_SEQ` WRITE;
/*!40000 ALTER TABLE `token_SEQ` DISABLE KEYS */;
INSERT INTO `token_SEQ` VALUES (151);
/*!40000 ALTER TABLE `token_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic` (
  `topicid` bigint NOT NULL,
  `createddate` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`topicid`),
  KEY `FK1aj222byxcs8168hx22iuh68b` (`userid`),
  CONSTRAINT `FK1aj222byxcs8168hx22iuh68b` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (52,'2024-03-17 09:54:59.747818','For back-end programming discussion.','Backend Development',3),(53,'2024-03-17 09:55:09.511994','Math 101','Math',3),(54,'2024-03-17 09:55:12.703775','finance 101','Finance',3),(102,'2024-03-17 10:19:56.003968','Welcome to Mumbai\'s Community!','Mumbai',3),(105,'2024-03-17 10:47:57.782508','Welcome to Tennis Community!','Tennis',3);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_SEQ`
--

DROP TABLE IF EXISTS `topic_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_SEQ`
--

LOCK TABLES `topic_SEQ` WRITE;
/*!40000 ALTER TABLE `topic_SEQ` DISABLE KEYS */;
INSERT INTO `topic_SEQ` VALUES (301);
/*!40000 ALTER TABLE `topic_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic_subscribed`
--

DROP TABLE IF EXISTS `topic_subscribed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `topic_subscribed` (
  `user_id` bigint NOT NULL,
  `topic_id` bigint NOT NULL,
  KEY `FKl2ovbegclea03gehf5bb5nfj` (`topic_id`),
  KEY `FKcmpv0n8pm0xxbgp3ur1snun11` (`user_id`),
  CONSTRAINT `FKcmpv0n8pm0xxbgp3ur1snun11` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKl2ovbegclea03gehf5bb5nfj` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`topicid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic_subscribed`
--

LOCK TABLES `topic_subscribed` WRITE;
/*!40000 ALTER TABLE `topic_subscribed` DISABLE KEYS */;
INSERT INTO `topic_subscribed` VALUES (2,53),(2,102),(2,54),(2,105),(4,53),(4,52),(4,54),(3,52),(1,105),(1,102);
/*!40000 ALTER TABLE `topic_subscribed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userid` bigint NOT NULL,
  `created` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2024-03-17 09:26:09.528109','testuser2@gmail.com',_binary '','$2a$10$cNWqKBcVd5hIbAoxyUANk.7uYoVmr0iiVQAEMCfyI/3KNp9GNMS4K','testuser2'),(2,'2024-03-17 09:26:38.532211','testuser3@gmail.com',_binary '','$2a$10$eEUYG3TXEjDDbQu6a1mhfuXo78yJjjqxaDA0.819hNboeivrJLBjO','testuser3'),(3,'2024-03-17 09:26:45.001457','testuser1@gmail.com',_binary '','$2a$10$Upvw1BiIgBMQ.1tgqtECWe03uwjxReRbScUxoIBNekcZmoctZOp.C','testuser1'),(4,'2024-03-17 09:27:24.645761','testuser4@gmail.com',_binary '','$2a$10$XdlDMkO/.MFE8XodyCjJIud3nYWJG9LcV3iYproNuygJmFXhkcYbG','testuser4');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_SEQ`
--

DROP TABLE IF EXISTS `user_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_SEQ`
--

LOCK TABLES `user_SEQ` WRITE;
/*!40000 ALTER TABLE `user_SEQ` DISABLE KEYS */;
INSERT INTO `user_SEQ` VALUES (151);
/*!40000 ALTER TABLE `user_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_roles`
--

DROP TABLE IF EXISTS `users_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_roles` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  KEY `FKj6m8fwv7oqv74fcehir1a9ffy` (`role_id`),
  KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`),
  CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKj6m8fwv7oqv74fcehir1a9ffy` FOREIGN KEY (`role_id`) REFERENCES `roles` (`roleid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_roles`
--

LOCK TABLES `users_roles` WRITE;
/*!40000 ALTER TABLE `users_roles` DISABLE KEYS */;
INSERT INTO `users_roles` VALUES (1,1),(2,1),(3,1),(4,1);
/*!40000 ALTER TABLE `users_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote`
--

DROP TABLE IF EXISTS `vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote` (
  `voteId` bigint NOT NULL,
  `voteType` int NOT NULL,
  `postid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`voteId`),
  KEY `FKkvt60urhmtcnmqhlj5jwcrf1q` (`postid`),
  KEY `FKhooe28xitvncfflnpi8ejc28t` (`userid`),
  CONSTRAINT `FKhooe28xitvncfflnpi8ejc28t` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKkvt60urhmtcnmqhlj5jwcrf1q` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote`
--

LOCK TABLES `vote` WRITE;
/*!40000 ALTER TABLE `vote` DISABLE KEYS */;
INSERT INTO `vote` VALUES (1,1,2,3),(2,1,11,3),(3,1,11,3),(4,1,12,3),(5,1,12,3),(6,1,14,3),(7,1,4,3),(8,1,5,3),(9,1,5,3),(10,-1,4,3),(11,-1,3,3),(12,-1,4,3),(13,1,2,3),(14,1,2,3),(15,1,11,3),(16,1,13,3),(17,1,13,3),(18,1,3,3),(19,1,3,3),(52,1,9,1),(102,1,6,3),(152,1,6,4),(153,1,6,4),(202,1,6,1),(203,1,6,1);
/*!40000 ALTER TABLE `vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vote_SEQ`
--

DROP TABLE IF EXISTS `vote_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vote_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vote_SEQ`
--

LOCK TABLES `vote_SEQ` WRITE;
/*!40000 ALTER TABLE `vote_SEQ` DISABLE KEYS */;
INSERT INTO `vote_SEQ` VALUES (301);
/*!40000 ALTER TABLE `vote_SEQ` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-21 23:25:27
