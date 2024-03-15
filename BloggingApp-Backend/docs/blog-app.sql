-- MySQL dump 10.13  Distrib 8.0.36, for Linux (x86_64)
--
-- Host: localhost    Database: reddit
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
-- Table structure for table `RefreshToken`
--

DROP TABLE IF EXISTS `RefreshToken`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `RefreshToken` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `createdDate` datetime(6) DEFAULT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `RefreshToken`
--

LOCK TABLES `RefreshToken` WRITE;
/*!40000 ALTER TABLE `RefreshToken` DISABLE KEYS */;
INSERT INTO `RefreshToken` VALUES (1,'2023-08-17 16:25:06.393602','4d86a93e-8140-4009-92de-8506f9909ce9'),(2,'2023-08-17 16:26:05.898758','2b5ee51a-ed29-4e31-9e09-85e88b56f100'),(3,'2023-08-17 16:27:10.325974','bf28f2cd-966f-4628-aa67-d2e92388a953'),(4,'2023-08-17 16:28:19.344555','07f251db-d8c7-4f82-8c6e-2b91bcd19c43'),(5,'2023-08-17 16:29:45.069638','196d3d87-064d-4ae0-a562-3601bd1cf1c2'),(6,'2023-08-17 16:32:15.984388','264729ce-1185-4e54-b6d2-162270641619'),(7,'2023-08-17 16:33:03.479242','6d5989bf-1a08-41e5-897c-a22a18ef7ce2'),(9,'2023-08-17 16:45:54.524188','943d0e06-5a0d-4a7a-80f9-7af742e99710'),(10,'2023-08-17 16:47:28.927536','71d74f20-646b-4300-b521-75de8de3b11e'),(11,'2023-08-18 16:41:20.795255','de37b925-8be8-4fe3-bc3c-643632d01120'),(12,'2023-08-19 13:05:05.887447','b55350c5-60cb-43f5-9d20-7fbc7ed27d5b'),(13,'2023-08-20 10:58:13.670436','69bcb2a6-cb53-4818-9b57-f58141aa52f3'),(14,'2023-08-20 10:59:41.303295','55130bdd-d83e-4998-b7c9-13c122cbeddc'),(15,'2023-08-20 11:05:59.822948','84292101-c17b-4457-84a3-2beca78f0f28'),(16,'2023-08-20 11:09:34.721888','b1ff72b4-e5b4-480d-bf61-5c9d0ae85319'),(17,'2023-08-20 11:11:10.811007','9663cd25-bb3e-4b1d-aa3f-9211e3571a5a'),(18,'2023-08-20 11:23:45.639183','2a286de2-6afa-4268-ae5a-af0cc9dbb71a'),(19,'2023-08-20 11:27:56.839585','10d5b679-2400-4b86-afe0-542edcb7a2fd'),(20,'2023-08-20 12:46:57.135438','67fe65d3-79a9-48f3-959b-a3a53bdbd87a'),(21,'2023-08-20 12:52:45.947491','837aa177-ab5b-4155-b3c8-d03e3b885dda'),(22,'2023-08-21 16:29:39.442981','155d2578-c110-46b4-b742-e6b815bfd0b6'),(23,'2023-08-21 16:46:43.644675','85f1fe5f-ce54-4b55-8d47-7ab44edf0c1e'),(24,'2023-08-21 16:46:43.648571','b628b051-874a-441c-a7c0-8391e7149989'),(25,'2023-08-21 16:46:46.211175','f010f840-1cf2-4f2c-b9b0-a9c90cfb0b72'),(26,'2023-08-21 16:46:46.211962','24928d32-30ab-4521-81e3-2ce190dc326e'),(27,'2023-08-21 16:46:46.217329','bedec146-89ab-47b9-a6db-bc81f83745bc'),(28,'2023-08-21 16:46:46.273192','495543e5-565e-4359-bbd5-aeeede12f36d'),(29,'2023-08-21 16:46:46.334330','fef0f5f5-8d68-48d9-9ab7-4a26ca243d27'),(30,'2023-08-23 13:12:42.947659','bd003e67-8189-45da-a6a8-51c6b23f76f2'),(31,'2023-08-23 13:12:42.948656','ed994919-0d07-4460-b02a-fc30ee99d9f2'),(32,'2023-08-23 13:12:42.946085','fe76e4c8-87af-4e0a-8430-4ec8e73e2902'),(33,'2023-08-23 13:15:32.122541','2f32278c-4f9c-4998-a654-e9fd7e86cb58'),(34,'2023-08-23 13:26:44.698361','7f1bbff5-48ce-4667-8fac-b4a2009339a0'),(35,'2023-08-23 13:37:34.081475','9a253d14-cb20-4cf1-9ba3-739783de0e7e'),(36,'2023-08-23 13:44:35.981616','d9d37d2c-26d9-4741-8646-cdd8bc79acf7'),(37,'2023-08-23 13:51:14.476296','3c3a8440-ab57-4324-bc00-23d9455eb44f'),(38,'2023-08-23 14:20:57.932269','dd6067c1-9b9d-46fe-af50-80b5a6409446'),(39,'2023-08-23 14:22:20.681770','34e067db-411e-4cd4-89ca-8a43f31c15d9'),(40,'2023-08-23 14:28:43.272208','b5c4f0e3-e2b6-4030-a770-b53c27045243'),(41,'2023-08-23 14:31:00.890582','33820bf0-978f-4eb2-8333-c553879377bb'),(42,'2023-08-23 14:49:48.794075','fe692888-4f59-420d-aa7d-27f371f2ae43'),(43,'2023-08-23 15:00:47.789443','1d67336a-477a-45f7-9856-e97814ff0cac'),(44,'2023-08-23 15:03:14.917701','119eb65d-d4d6-4d4d-8969-1dde77860860'),(45,'2023-08-23 15:04:39.481381','88df347f-2739-4bb0-85fc-48b52b854d19'),(46,'2023-08-23 15:06:28.535950','5983db60-7080-4d2b-9ede-c1b2913849d8'),(47,'2023-08-23 15:12:32.427274','62043fdf-e27a-45bc-a69f-c25f71a5ee86'),(48,'2023-08-23 15:21:07.783401','e6f6795a-e3a9-4559-b556-7558771c1308'),(49,'2023-08-23 15:24:43.603090','a3ae713b-fc9f-4084-aa4a-1493986865cb'),(50,'2023-08-23 15:34:33.055978','c476a866-aceb-4d7c-9d28-080465dab8bc'),(51,'2023-08-23 15:41:43.525914','3b738759-c294-427a-8cac-c06818beb016'),(52,'2023-08-23 15:42:55.817231','cef90851-60df-4232-9ff3-7ad968d3a77f'),(53,'2023-08-23 17:18:07.249700','840c02c6-2fe8-4883-8862-262e0ab5c2dd'),(54,'2023-08-23 17:23:45.407373','f1b0586d-914b-493f-9783-55cd600b705e'),(55,'2023-08-23 17:24:07.085539','a8f66422-c11a-483a-b671-994d029db8df'),(56,'2023-08-23 17:30:16.037529','f33e541b-1833-462e-a687-36df088ec18c'),(57,'2023-08-23 17:36:55.882863','cde8c2b5-7af1-4e8b-baf9-434a6146e62e'),(58,'2023-08-23 17:45:59.565103','bb146208-b417-4a68-a580-383797521034'),(59,'2023-08-23 17:50:39.103769','c8e5e895-7de8-461c-b27b-7bca1e966c6d'),(60,'2023-08-23 17:55:38.406916','8bcd86ff-468f-4f8d-b259-619a368cf505'),(61,'2023-08-23 18:03:06.269848','f4d6bdc8-3be5-4f23-a9d8-ff1d3a34bbdf'),(62,'2023-08-23 18:06:13.766002','71a2970e-d0f5-4a52-92cb-17eb2a4fa90f'),(63,'2023-08-23 18:08:21.670987','f9d3af8d-a272-42ca-a9b3-afc581fbb616'),(64,'2023-08-23 18:19:08.457646','3a6db4e8-1e55-4fb8-9216-19c954921fe8'),(65,'2023-08-23 18:23:31.391184','3994a113-c9a2-4357-8608-2fef160d08f1'),(66,'2023-08-24 16:01:51.991854','0ef6cba5-65e1-45b6-b756-095f29a1ea3d'),(67,'2023-08-24 16:22:40.160625','4e18c385-6b24-4ff3-a450-53f005630490'),(68,'2023-08-24 16:53:18.413708','83c5bd12-0fca-4e40-87c6-e72d55d9ef84'),(69,'2023-08-24 16:53:18.421813','7d2e01f3-4318-430f-a6d6-00f9329b4c5b'),(70,'2023-08-24 16:53:18.432089','3ec109b1-b59f-478a-bc9e-a06b694885c9'),(71,'2023-08-24 17:22:17.679213','3f44db26-2613-450a-b5f7-7295cd0302f4'),(72,'2023-08-24 17:40:09.924883','6114c859-0a6e-44a4-a0f3-652385febb6a'),(73,'2023-08-24 17:44:51.629683','d6258464-d86e-451f-92cf-c883f9150a7d'),(74,'2023-08-24 17:48:16.693252','55fbb60d-b20a-4cef-ac0e-e9a8633531d0'),(75,'2023-08-24 18:24:49.326107','a7d6ea15-d7a4-47a5-8202-6bfa8b49e1c3'),(76,'2023-08-24 18:27:23.621497','14f14af4-996f-4e97-a40c-95d7912d7756'),(77,'2023-08-25 17:14:12.245404','8c7ed43b-54db-433a-af55-22d20bfa9337'),(78,'2023-08-25 17:25:40.885226','b79ef458-4b7c-42f3-a344-9e9d2fdf9be7'),(79,'2023-08-25 17:31:01.948104','dc7b0098-19f7-49e2-a8c7-04f507c020fa'),(80,'2023-08-25 17:40:01.867113','53568f7c-1cfb-4838-acdd-d8b3fafb9b64'),(81,'2023-08-25 17:46:26.958787','7191ab8e-3c45-47d5-8e4b-78e0c9755ba5'),(82,'2023-08-25 18:19:35.785567','73cc5dfd-5d39-41e1-b020-2a878176ac38'),(84,'2023-08-25 19:43:27.011051','b174d314-3b75-4910-9013-71c8e14bd667'),(85,'2023-08-25 19:45:08.763724','c9a683b8-cbe8-4876-96fc-999793e98397'),(86,'2023-08-25 19:55:06.131654','b7977e63-f170-406c-9c7c-b820f40c7ff8'),(87,'2023-09-17 10:19:06.745746','10e3ef6f-0331-4b8e-8d3e-629b25efc930'),(88,'2023-09-17 13:16:37.326375','fbc63ca9-ecad-45c2-a176-8d63f9a3a445'),(89,'2023-09-17 17:54:03.621448','ac94624b-1460-4622-b6fc-d49012b5fa5e'),(90,'2023-09-17 19:10:26.326974','ee4eb746-6d7b-4f13-9eeb-6678b37f434a'),(91,'2023-11-21 16:54:32.571609','7db5aa0d-2c41-42cf-8f3b-e3ee6fbe2f11');
/*!40000 ALTER TABLE `RefreshToken` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subreddit`
--

DROP TABLE IF EXISTS `Subreddit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subreddit` (
  `id` bigint NOT NULL,
  `createddate` datetime(6) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_userid` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk5aybnkqg0l3kyuxrhrpnnoao` (`user_userid`),
  CONSTRAINT `FKk5aybnkqg0l3kyuxrhrpnnoao` FOREIGN KEY (`user_userid`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subreddit`
--

LOCK TABLES `Subreddit` WRITE;
/*!40000 ALTER TABLE `Subreddit` DISABLE KEYS */;
INSERT INTO `Subreddit` VALUES (1,'2023-08-16 17:10:17.067084','tennis','tennis',202),(2,'2023-08-16 17:11:57.784840','football','football',202),(3,'2023-08-16 17:12:07.351498','tt','tt',202),(4,'2023-08-16 17:12:15.297058','cse','cse',202),(5,'2023-08-16 17:12:21.966330','google','google',202),(6,'2023-08-16 17:12:29.983556','atlassian','atlassian',202),(52,'2023-08-23 13:54:47.337529','amazon','amazon',202),(102,'2023-08-23 14:21:27.418016','flipkart','flipkart',202),(152,'2023-08-23 14:29:55.166032','towerresearch','towerresearch',202),(202,'2023-08-23 18:19:15.233404','asdasd','adasdsd',202),(203,'2023-08-23 18:19:15.233209','asdasd','adasdsd',202),(252,'2023-08-23 18:27:55.399862','Create Subreddit\n','Create Subreddit',202),(253,'2023-08-23 18:27:55.411861','Create Subreddit\n','Create Subreddit',202),(254,'2023-08-23 18:29:27.850919','fucking hell, it worked. !','fucking hell, it worked. !',202),(255,'2023-08-23 18:29:32.115011','fucking hell, it worked. !','fucking hell, it worked. !',202),(302,'2023-08-24 16:03:47.013619','new try2','new try2',202),(303,'2023-08-24 16:04:07.569116','new try2','new try2',202),(304,'2023-08-24 16:22:48.579792','only','once',202),(352,'2023-08-24 17:40:21.072376','with complete flow ?','finally ',202),(353,'2023-08-24 17:45:08.743333','wtfff','wtff',202),(354,'2023-08-24 17:45:53.887236','wtfff','wtff',202),(355,'2023-08-24 17:48:23.826649','Subreddit11','Subreddit1',202),(357,'2023-08-24 17:49:58.851693','Create','Create',202),(358,'2023-08-24 17:50:25.128584','Create Subreddit','Create Subreddit',202),(402,'2023-09-17 10:32:52.957382','finance news and updates','finance',403);
/*!40000 ALTER TABLE `Subreddit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subreddit_SEQ`
--

DROP TABLE IF EXISTS `Subreddit_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subreddit_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subreddit_SEQ`
--

LOCK TABLES `Subreddit_SEQ` WRITE;
/*!40000 ALTER TABLE `Subreddit_SEQ` DISABLE KEYS */;
INSERT INTO `Subreddit_SEQ` VALUES (501);
/*!40000 ALTER TABLE `Subreddit_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Subreddit_posts`
--

DROP TABLE IF EXISTS `Subreddit_posts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Subreddit_posts` (
  `Subreddit_id` bigint NOT NULL,
  `posts_postid` bigint NOT NULL,
  UNIQUE KEY `UK_g04w3hfvhpoq8bvd6fxj8eq1f` (`posts_postid`),
  KEY `FK4kv9booprkny7pue6s4v6ba3v` (`Subreddit_id`),
  CONSTRAINT `FK4kv9booprkny7pue6s4v6ba3v` FOREIGN KEY (`Subreddit_id`) REFERENCES `Subreddit` (`id`),
  CONSTRAINT `FKkaterpxbiv84q5hguav893hh` FOREIGN KEY (`posts_postid`) REFERENCES `post` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Subreddit_posts`
--

LOCK TABLES `Subreddit_posts` WRITE;
/*!40000 ALTER TABLE `Subreddit_posts` DISABLE KEYS */;
/*!40000 ALTER TABLE `Subreddit_posts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vote`
--

DROP TABLE IF EXISTS `Vote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vote` (
  `voteId` bigint NOT NULL,
  `voteType` tinyint DEFAULT NULL,
  `postid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`voteId`),
  KEY `FKrtdn98q8qd31q7dmlp1s3nhdh` (`postid`),
  KEY `FKgktwkriu3yaqevc96x6q3p0ej` (`userid`),
  CONSTRAINT `FKgktwkriu3yaqevc96x6q3p0ej` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKrtdn98q8qd31q7dmlp1s3nhdh` FOREIGN KEY (`postid`) REFERENCES `post` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vote`
--

LOCK TABLES `Vote` WRITE;
/*!40000 ALTER TABLE `Vote` DISABLE KEYS */;
INSERT INTO `Vote` VALUES (1,0,1,202),(2,0,2,202),(52,0,3,202),(102,1,1,202),(152,0,3,253),(153,1,3,253),(154,0,52,253),(155,0,102,253);
/*!40000 ALTER TABLE `Vote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vote_SEQ`
--

DROP TABLE IF EXISTS `Vote_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Vote_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vote_SEQ`
--

LOCK TABLES `Vote_SEQ` WRITE;
/*!40000 ALTER TABLE `Vote_SEQ` DISABLE KEYS */;
INSERT INTO `Vote_SEQ` VALUES (251);
/*!40000 ALTER TABLE `Vote_SEQ` ENABLE KEYS */;
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
  `post_postid` bigint DEFAULT NULL,
  `userid` bigint DEFAULT NULL,
  PRIMARY KEY (`commentid`),
  KEY `FKn5viud8mxngdc73h9ekhemm0j` (`post_postid`),
  KEY `FKe7pshbkin4984x23q4wboi5ka` (`userid`),
  CONSTRAINT `FKe7pshbkin4984x23q4wboi5ka` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `FKn5viud8mxngdc73h9ekhemm0j` FOREIGN KEY (`post_postid`) REFERENCES `post` (`postid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comment`
--

LOCK TABLES `comment` WRITE;
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` VALUES (1,'2023-08-17 14:28:30.830034','goat',1,52),(2,'2023-08-17 14:29:42.028900','spanish',2,52),(52,'2023-08-17 14:32:43.321963','noleee',3,52),(53,'2023-08-17 14:34:18.641438','goattt',3,52),(102,'2023-08-17 14:50:57.582024','goattt-3',3,202),(103,'2023-08-17 14:51:06.186560','spanish-3',2,202),(104,'2023-08-17 14:51:18.079172','goat roger-3',1,202),(152,'2023-08-25 17:48:54.774743','asd',1,202),(153,'2023-08-25 17:49:23.865408','asd',1,202),(154,'2023-08-25 18:19:46.162125','',1,202),(155,'2023-08-25 18:20:03.862873','Some comment.',1,202);
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
INSERT INTO `comment_SEQ` VALUES (251);
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
  `description` tinytext,
  `postname` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `votecount` int DEFAULT NULL,
  `subreddit` bigint DEFAULT NULL,
  `userId` bigint DEFAULT NULL,
  PRIMARY KEY (`postid`),
  KEY `FKlvoacil2m347ma77hiai0820` (`subreddit`),
  KEY `FKm0h904i1j7xr6fovb3bhoh1p1` (`userId`),
  CONSTRAINT `FKlvoacil2m347ma77hiai0820` FOREIGN KEY (`subreddit`) REFERENCES `Subreddit` (`id`),
  CONSTRAINT `FKm0h904i1j7xr6fovb3bhoh1p1` FOREIGN KEY (`userId`) REFERENCES `user` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (1,NULL,'roger','roger','',-1,1,202),(2,NULL,'rafa','rafa','',0,1,202),(3,NULL,'novak','novak','',1,1,202),(52,NULL,'<p>adasdasasds</p>','asdasdas','asdasd',1,5,202),(102,NULL,'','Some post.','Some post.',1,4,202),(152,NULL,'novak','novak','',NULL,1,802);
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
INSERT INTO `post_SEQ` VALUES (251);
/*!40000 ALTER TABLE `post_SEQ` ENABLE KEYS */;
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
  `token` varchar(255) DEFAULT NULL,
  `user_userid` bigint DEFAULT NULL,
  `now` datetime(6) DEFAULT NULL,
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
INSERT INTO `token` VALUES (2,'2023-08-19 12:17:07.918173','e6dcc13b-e0cf-4027-bc6f-fe5a2bd4de79',2,'2023-08-16 12:18:38.944148'),(52,'2023-08-19 12:35:03.717555','79f3e052-88bb-46b4-9426-a4803a7390bb',52,'2023-08-16 12:35:44.682740'),(202,'2023-08-19 16:02:43.817589','244c5b06-227e-4208-a89c-99fceaea1c30',202,'2023-08-16 16:08:45.609835'),(253,'2023-08-23 09:56:50.309894','762ff32a-9921-44e0-aaeb-451f8bd586eb',253,'2023-08-20 09:59:23.784565'),(353,'2023-08-24 16:23:47.920528','9ce4f22d-6677-4d62-a305-05997c9655cc',353,'2023-08-21 16:28:35.193203'),(354,'2023-08-24 16:23:47.920528','1052f146-ab55-43bb-a382-9306ddf63b70',354,'2023-08-21 16:37:59.269671'),(355,'2023-08-24 16:23:47.920528','7188c194-7fb2-42cf-bbe9-76fd6c7cf28f',355,'2023-08-21 16:40:08.844444'),(403,'2023-09-20 09:51:01.586695','9ae47624-7abd-4d07-a908-e22033f2d7fb',403,'2023-09-17 09:56:30.735615'),(553,'2023-11-23 19:13:06.187294','12afe441-d811-4fe0-bf49-a0fb3368646a',553,'2023-11-20 19:16:21.645823'),(754,'2023-11-23 19:26:01.982748','ffae7077-3b95-457c-969d-f4c36b930edb',754,'2023-11-20 19:26:34.013483'),(802,'2023-11-24 16:50:56.842099','addcabc8-bced-413f-b8a9-c3bb90c73b73',802,'2023-11-21 16:51:37.320382');
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
INSERT INTO `token_SEQ` VALUES (901);
/*!40000 ALTER TABLE `token_SEQ` ENABLE KEYS */;
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
  PRIMARY KEY (`userid`),
  UNIQUE KEY `user_email_unq` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (2,'2023-08-16 12:18:26.229719','kaustubhdcpo@gmail.com',_binary '\0','$2a$10$3j3SMgQga5lI5xkQPkbsVuaaK1K2qh1wFX3gamn3AJUhIVNWeNjd.','kaustubhdcpo'),(52,'2023-08-16 12:35:44.648936','testuser2@gmail.com',_binary '','$2a$10$wzrdP3bWz9/Fo2kaEKWv.umssOaIvWGp82IZBYCN0LAHpG6Jtd0Ym','testuser2'),(202,'2023-08-16 16:08:45.574633','testuser3@gmail.com',_binary '','$2a$10$0OBJ2YxXHLvF79sNDODIFeqMYIPgXahvfwU16wm9bUD2NrAsbCwzO','testuser3'),(253,'2023-08-20 09:59:23.783210','testuser4@gmail.com',_binary '','$2a$10$B.QjKKp5rXacbeni8O8y7uM7ge6eTSoiZKBlYv5Oj2vDRKKcCLAmC','testuser4'),(304,'2023-08-21 16:23:34.524375','adminuser@email.com',_binary '\0','$2a$10$/Cg0qV2gpr5xuU.TrlTBx.KeFU/syr0hObc8Ec9hvt1HwqVvRxQva','adminuser'),(353,'2023-08-21 16:28:32.518928','adminuser1@email.com',_binary '','$2a$10$5P9dgYd/59VR9ya.Oc8Pce8w1wU.A/.HFY0gHKJtEv1pepQ6ynDC6','adminuser1'),(354,'2023-08-21 16:37:59.268715','adminuser2@email.com',_binary '\0','$2a$10$WvUagiu9cQ26OISS5v9kauTTjXCxKFseLF13hxAruN5heSVseDIOa','adminuser2'),(355,'2023-08-21 16:40:08.843584','adminuser3@email.com',_binary '\0','$2a$10$QKR5.tGDosSv1p6FUIFjZejO0xA/.kl8xdmoFuphab0l.R37pZTwq','adminuser3'),(403,'2023-09-17 09:56:30.734977','worker1@email.com',_binary '','$2a$10$qDeS3F37cuMYr/zA7WgSyecWangEzCQXTS2hD7zTb330q45rOW1/y','worker1'),(553,'2023-11-20 19:16:21.645164','testuser5@gmail.com',_binary '\0','$2a$10$puCqjHgdr13rxKNomjgvJ.HveuB4Wq7wsal89mZ6sRkSZwqth8wta','testuser5'),(754,'2023-11-20 19:26:34.012552','testuser6@gmail.com',_binary '\0','$2a$10$gX7gjE8BSo5NYVLsdd8mvOGfKz0B7iZ2jyUaC8kl3/7CdqBs.NQRK','testuser6'),(802,'2023-11-21 16:51:37.277291','testuser7@gmail.com',_binary '','$2a$10$ShJG6PIkZWo3KC/NRl53RezkFVxx81MXk7WXKm.5S8rlqgJ1jF0ZC','testuser7');
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
INSERT INTO `user_SEQ` VALUES (901);
/*!40000 ALTER TABLE `user_SEQ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `userid` bigint NOT NULL,
  `created` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`),
  UNIQUE KEY `UK_6dotkott2kjsp8vw4d0m25fb7` (`email`),
  UNIQUE KEY `UK_r43af9ap4edm43mmtq01oddj6` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_SEQ`
--

DROP TABLE IF EXISTS `users_SEQ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users_SEQ` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_SEQ`
--

LOCK TABLES `users_SEQ` WRITE;
/*!40000 ALTER TABLE `users_SEQ` DISABLE KEYS */;
INSERT INTO `users_SEQ` VALUES (1);
/*!40000 ALTER TABLE `users_SEQ` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-25 17:26:29
