-- MySQL dump 10.13  Distrib 8.0.46, for Linux (x86_64)
--
-- Host: localhost    Database: A-Hun_Lyhorng-db
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `profiles`
--

DROP TABLE IF EXISTS `profiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profiles` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `barcode_type` enum('CODE_128','EAN_13') DEFAULT NULL,
  `blood_group` varchar(255) DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `department` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `photo_content_type` varchar(255) DEFAULT NULL,
  `photo_file_name` varchar(255) DEFAULT NULL,
  `registration_number` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` enum('EMPLOYEE','STUDENT','USER') DEFAULT NULL,
  `updated_at` datetime(6) DEFAULT NULL,
  `uuid` varchar(255) DEFAULT NULL,
  `template_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK66yiwv2n5ntj3i3m0tj36x2yw` (`registration_number`),
  UNIQUE KEY `UKfetebim4s6b2yrqmjjwuakic9` (`uuid`),
  KEY `FK92ganbu1q1rhy9wdmquc37xr9` (`template_id`),
  CONSTRAINT `FK92ganbu1q1rhy9wdmquc37xr9` FOREIGN KEY (`template_id`) REFERENCES `templates` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profiles`
--

LOCK TABLES `profiles` WRITE;
/*!40000 ALTER TABLE `profiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `profiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `templates`
--

DROP TABLE IF EXISTS `templates`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `templates` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `content` longtext,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `templates`
--

LOCK TABLES `templates` WRITE;
/*!40000 ALTER TABLE `templates` DISABLE KEYS */;
/*!40000 ALTER TABLE `templates` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-17 17:17:29
