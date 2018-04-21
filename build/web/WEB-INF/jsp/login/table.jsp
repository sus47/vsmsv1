<%-- 
-- MySQL dump 10.13  Distrib 5.5.59, for Win32 (AMD64)
--
-- Host: localhost    Database: rps
-- ------------------------------------------------------
-- Server version	5.5.59

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `academic_year`
--

DROP TABLE IF EXISTS `academic_year`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `academic_year` (
  `ACADEMIC_YEAR` varchar(10) NOT NULL,
  `AD_START_DATE` date NOT NULL,
  `AD_END_DATE` date NOT NULL,
  `BS_START_DATE` varchar(10) NOT NULL,
  `BS_END_DATE` varchar(10) NOT NULL,
  `STATUS` varchar(1) NOT NULL DEFAULT 'N',
  PRIMARY KEY (`ACADEMIC_YEAR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `academic_year`
--

LOCK TABLES `academic_year` WRITE;
/*!40000 ALTER TABLE `academic_year` DISABLE KEYS */;
INSERT INTO `academic_year` VALUES ('1','2070-01-01','2071-01-01','111','111','1'),('2','2070-01-01','2071-01-01','2','2','2');
/*!40000 ALTER TABLE `academic_year` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ad_bs_calender`
--

DROP TABLE IF EXISTS `ad_bs_calender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ad_bs_calender` (
  `AD_DATE` date NOT NULL,
  `BS_DATE` varchar(255) NOT NULL,
  `DAY` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`AD_DATE`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ad_bs_calender`
--

LOCK TABLES `ad_bs_calender` WRITE;
/*!40000 ALTER TABLE `ad_bs_calender` DISABLE KEYS */;
INSERT INTO `ad_bs_calender` VALUES ('2016-04-13','2073-01-01','Wed'),('2016-04-14','2073-01-02','Thu'),('2016-04-15','2073-01-03','Fri'),('2016-04-16','2073-01-04','Sat'),('2016-04-17','2073-01-05','Sun'),('2016-04-18','2073-01-06','Mon'),('2016-04-19','2073-01-07','Tue'),('2016-04-20','2073-01-08','Wed'),('2016-04-21','2073-01-09','Thu'),('2016-04-22','2073-01-10','Fri'),('2016-04-23','2073-01-11','Sat'),('2016-04-24','2073-01-12','Sun'),('2016-04-25','2073-01-13','Mon'),('2016-04-26','2073-01-14','Tue'),('2016-04-27','2073-01-15','Wed'),('2016-04-28','2073-01-16','Thu'),('2016-04-29','2073-01-17','Fri'),('2016-04-30','2073-01-18','Sat'),('2016-05-01','2073-01-19','Sun'),('2016-05-02','2073-01-20','Mon'),('2016-05-03','2073-01-21','Tue'),('2016-05-04','2073-01-22','Wed'),('2016-05-05','2073-01-23','Thu'),('2016-05-06','2073-01-24','Fri'),('2016-05-07','2073-01-25','Sat'),('2016-05-08','2073-01-26','Sun'),('2016-05-09','2073-01-27','Mon'),('2016-05-10','2073-01-28','Tue'),('2016-05-11','2073-01-29','Wed'),('2016-05-12','2073-01-30','Thu'),('2016-05-13','2073-01-31','Fri'),('2016-05-14','2073-02-01','Sat'),('2016-05-15','2073-02-02','Sun'),('2016-05-16','2073-02-03','Mon'),('2016-05-17','2073-02-04','Tue'),('2016-05-18','2073-02-05','Wed'),('2016-05-19','2073-02-06','Thu'),('2016-05-20','2073-02-07','Fri'),('2016-05-21','2073-02-08','Sat'),('2016-05-22','2073-02-09','Sun'),('2016-05-23','2073-02-10','Mon'),('2016-05-24','2073-02-11','Tue'),('2016-05-25','2073-02-12','Wed'),('2016-05-26','2073-02-13','Thu'),('2016-05-27','2073-02-14','Fri'),('2016-05-28','2073-02-15','Sat'),('2016-05-29','2073-02-16','Sun'),('2016-05-30','2073-02-17','Mon'),('2016-05-31','2073-02-18','Tue'),('2016-06-01','2073-02-19','Wed'),('2016-06-02','2073-02-20','Thu'),('2016-06-03','2073-02-21','Fri'),('2016-06-04','2073-02-22','Sat'),('2016-06-05','2073-02-23','Sun'),('2016-06-06','2073-02-24','Mon'),('2016-06-07','2073-02-25','Tue'),('2016-06-08','2073-02-26','Wed'),('2016-06-09','2073-02-27','Thu'),('2016-06-10','2073-02-28','Fri'),('2016-06-11','2073-02-29','Sat'),('2016-06-12','2073-02-30','Sun'),('2016-06-13','2073-02-31','Mon'),('2016-06-14','2073-02-32','Tue'),('2016-06-15','2073-03-01','Wed'),('2016-06-16','2073-03-02','Thu'),('2016-06-17','2073-03-03','Fri'),('2016-06-18','2073-03-04','Sat'),('2016-06-19','2073-03-05','Sun'),('2016-06-20','2073-03-06','Mon'),('2016-06-21','2073-03-07','Tue'),('2016-06-22','2073-03-08','Wed'),('2016-06-23','2073-03-09','Thu'),('2016-06-24','2073-03-10','Fri'),('2016-06-25','2073-03-11','Sat'),('2016-06-26','2073-03-12','Sun'),('2016-06-27','2073-03-13','Mon'),('2016-06-28','2073-03-14','Tue'),('2016-06-29','2073-03-15','Wed'),('2016-06-30','2073-03-16','Thu'),('2016-07-01','2073-03-17','Fri'),('2016-07-02','2073-03-18','Sat'),('2016-07-03','2073-03-19','Sun'),('2016-07-04','2073-03-20','Mon'),('2016-07-05','2073-03-21','Tue'),('2016-07-06','2073-03-22','Wed'),('2016-07-07','2073-03-23','Thu'),('2016-07-08','2073-03-24','Fri'),('2016-07-09','2073-03-25','Sat'),('2016-07-10','2073-03-26','Sun'),('2016-07-11','2073-03-27','Mon'),('2016-07-12','2073-03-28','Tue'),('2016-07-13','2073-03-29','Wed'),('2016-07-14','2073-03-30','Thu'),('2016-07-15','2073-03-31','Fri'),('2016-07-16','2073-04-01','Sat'),('2016-07-17','2073-04-02','Sun'),('2016-07-18','2073-04-03','Mon'),('2016-07-19','2073-04-04','Tue'),('2016-07-20','2073-04-05','Wed'),('2016-07-21','2073-04-06','Thu'),('2016-07-22','2073-04-07','Fri'),('2016-07-23','2073-04-08','Sat'),('2016-07-24','2073-04-09','Sun'),('2016-07-25','2073-04-10','Mon'),('2016-07-26','2073-04-11','Tue'),('2016-07-27','2073-04-12','Wed'),('2016-07-28','2073-04-13','Thu'),('2016-07-29','2073-04-14','Fri'),('2016-07-30','2073-04-15','Sat'),('2016-07-31','2073-04-16','Sun'),('2016-08-01','2073-04-17','Mon'),('2016-08-02','2073-04-18','Tue'),('2016-08-03','2073-04-19','Wed'),('2016-08-04','2073-04-20','Thu'),('2016-08-05','2073-04-21','Fri'),('2016-08-06','2073-04-22','Sat'),('2016-08-07','2073-04-23','Sun'),('2016-08-08','2073-04-24','Mon'),('2016-08-09','2073-04-25','Tue'),('2016-08-10','2073-04-26','Wed'),('2016-08-11','2073-04-27','Thu'),('2016-08-12','2073-04-28','Fri'),('2016-08-13','2073-04-29','Sat'),('2016-08-14','2073-04-30','Sun'),('2016-08-15','2073-04-31','Mon'),('2016-08-16','2073-04-32','Tue'),('2016-08-17','2073-05-01','Wed'),('2016-08-18','2073-05-02','Thu'),('2016-08-19','2073-05-03','Fri'),('2016-08-20','2073-05-04','Sat'),('2016-08-21','2073-05-05','Sun'),('2016-08-22','2073-05-06','Mon'),('2016-08-23','2073-05-07','Tue'),('2016-08-24','2073-05-08','Wed'),('2016-08-25','2073-05-09','Thu'),('2016-08-26','2073-05-10','Fri'),('2016-08-27','2073-05-11','Sat'),('2016-08-28','2073-05-12','Sun'),('2016-08-29','2073-05-13','Mon'),('2016-08-30','2073-05-14','Tue'),('2016-08-31','2073-05-15','Wed'),('2016-09-01','2073-05-16','Thu'),('2016-09-02','2073-05-17','Fri'),('2016-09-03','2073-05-18','Sat'),('2016-09-04','2073-05-19','Sun'),('2016-09-05','2073-05-20','Mon'),('2016-09-06','2073-05-21','Tue'),('2016-09-07','2073-05-22','Wed'),('2016-09-08','2073-05-23','Thu'),('2016-09-09','2073-05-24','Fri'),('2016-09-10','2073-05-25','Sat'),('2016-09-11','2073-05-26','Sun'),('2016-09-12','2073-05-27','Mon'),('2016-09-13','2073-05-28','Tue'),('2016-09-14','2073-05-29','Wed'),('2016-09-15','2073-05-30','Thu'),('2016-09-16','2073-05-31','Fri'),('2016-09-17','2073-06-01','Sat'),('2016-09-18','2073-06-02','Sun'),('2016-09-19','2073-06-03','Mon'),('2016-09-20','2073-06-04','Tue'),('2016-09-21','2073-06-05','Wed'),('2016-09-22','2073-06-06','Thu'),('2016-09-23','2073-06-07','Fri'),('2016-09-24','2073-06-08','Sat'),('2016-09-25','2073-06-09','Sun'),('2016-09-26','2073-06-10','Mon'),('2016-09-27','2073-06-11','Tue'),('2016-09-28','2073-06-12','Wed'),('2016-09-29','2073-06-13','Thu'),('2016-09-30','2073-06-14','Fri'),('2016-10-01','2073-06-15','Sat'),('2016-10-02','2073-06-16','Sun'),('2016-10-03','2073-06-17','Mon'),('2016-10-04','2073-06-18','Tue'),('2016-10-05','2073-06-19','Wed'),('2016-10-06','2073-06-20','Thu'),('2016-10-07','2073-06-21','Fri'),('2016-10-08','2073-06-22','Sat'),('2016-10-09','2073-06-23','Sun'),('2016-10-10','2073-06-24','Mon'),('2016-10-11','2073-06-25','Tue'),('2016-10-12','2073-06-26','Wed'),('2016-10-13','2073-06-27','Thu'),('2016-10-14','2073-06-28','Fri'),('2016-10-15','2073-06-29','Sat'),('2016-10-16','2073-06-30','Sun'),('2016-10-17','2073-07-01','Mon'),('2016-10-18','2073-07-02','Tue'),('2016-10-19','2073-07-03','Wed'),('2016-10-20','2073-07-04','Thu'),('2016-10-21','2073-07-05','Fri'),('2016-10-22','2073-07-06','Sat'),('2016-10-23','2073-07-07','Sun'),('2016-10-24','2073-07-08','Mon'),('2016-10-25','2073-07-09','Tue'),('2016-10-26','2073-07-10','Wed'),('2016-10-27','2073-07-11','Thu'),('2016-10-28','2073-07-12','Fri'),('2016-10-29','2073-07-13','Sat'),('2016-10-30','2073-07-14','Sun'),('2016-10-31','2073-07-15','Mon'),('2016-11-01','2073-07-16','Tue'),('2016-11-02','2073-07-17','Wed'),('2016-11-03','2073-07-18','Thu'),('2016-11-04','2073-07-19','Fri'),('2016-11-05','2073-07-20','Sat'),('2016-11-06','2073-07-21','Sun'),('2016-11-07','2073-07-22','Mon'),('2016-11-08','2073-07-23','Tue'),('2016-11-09','2073-07-24','Wed'),('2016-11-10','2073-07-25','Thu'),('2016-11-11','2073-07-26','Fri'),('2016-11-12','2073-07-27','Sat'),('2016-11-13','2073-07-28','Sun'),('2016-11-14','2073-07-29','Mon'),('2016-11-15','2073-07-30','Tue'),('2016-11-16','2073-08-01','Wed'),('2016-11-17','2073-08-02','Thu'),('2016-11-18','2073-08-03','Fri'),('2016-11-19','2073-08-04','Sat'),('2016-11-20','2073-08-05','Sun'),('2016-11-21','2073-08-06','Mon'),('2016-11-22','2073-08-07','Tue'),('2016-11-23','2073-08-08','Wed'),('2016-11-24','2073-08-09','Thu'),('2016-11-25','2073-08-10','Fri'),('2016-11-26','2073-08-11','Sat'),('2016-11-27','2073-08-12','Sun'),('2016-11-28','2073-08-13','Mon'),('2016-11-29','2073-08-14','Tue'),('2016-11-30','2073-08-15','Wed'),('2016-12-01','2073-08-16','Thu'),('2016-12-02','2073-08-17','Fri'),('2016-12-03','2073-08-18','Sat'),('2016-12-04','2073-08-19','Sun'),('2016-12-05','2073-08-20','Mon'),('2016-12-06','2073-08-21','Tue'),('2016-12-07','2073-08-22','Wed'),('2016-12-08','2073-08-23','Thu'),('2016-12-09','2073-08-24','Fri'),('2016-12-10','2073-08-25','Sat'),('2016-12-11','2073-08-26','Sun'),('2016-12-12','2073-08-27','Mon'),('2016-12-13','2073-08-28','Tue'),('2016-12-14','2073-08-29','Wed'),('2016-12-15','2073-08-30','Thu'),('2016-12-16','2073-09-01','Fri'),('2016-12-17','2073-09-02','Sat'),('2016-12-18','2073-09-03','Sun'),('2016-12-19','2073-09-04','Mon'),('2016-12-20','2073-09-05','Tue'),('2016-12-21','2073-09-06','Wed'),('2016-12-22','2073-09-07','Thu'),('2016-12-23','2073-09-08','Fri'),('2016-12-24','2073-09-09','Sat'),('2016-12-25','2073-09-10','Sun'),('2016-12-26','2073-09-11','Mon'),('2016-12-27','2073-09-12','Tue'),('2016-12-28','2073-09-13','Wed'),('2016-12-29','2073-09-14','Thu'),('2016-12-30','2073-09-15','Fri'),('2016-12-31','2073-09-16','Sat'),('2017-01-01','2073-09-17','Sun'),('2017-01-02','2073-09-18','Mon'),('2017-01-03','2073-09-19','Tue'),('2017-01-04','2073-09-20','Wed'),('2017-01-05','2073-09-21','Thu'),('2017-01-06','2073-09-22','Fri'),('2017-01-07','2073-09-23','Sat'),('2017-01-08','2073-09-24','Sun'),('2017-01-09','2073-09-25','Mon'),('2017-01-10','2073-09-26','Tue'),('2017-01-11','2073-09-27','Wed'),('2017-01-12','2073-09-28','Thu'),('2017-01-13','2073-09-29','Fri'),('2017-01-14','2073-10-01','Sat'),('2017-01-15','2073-10-02','Sun'),('2017-01-16','2073-10-03','Mon'),('2017-01-17','2073-10-04','Tue'),('2017-01-18','2073-10-05','Wed'),('2017-01-19','2073-10-06','Thu'),('2017-01-20','2073-10-07','Fri'),('2017-01-21','2073-10-08','Sat'),('2017-01-22','2073-10-09','Sun'),('2017-01-23','2073-10-10','Mon'),('2017-01-24','2073-10-11','Tue'),('2017-01-25','2073-10-12','Wed'),('2017-01-26','2073-10-13','Thu'),('2017-01-27','2073-10-14','Fri'),('2017-01-28','2073-10-15','Sat'),('2017-01-29','2073-10-16','Sun'),('2017-01-30','2073-10-17','Mon'),('2017-01-31','2073-10-18','Tue'),('2017-02-01','2073-10-19','Wed'),('2017-02-02','2073-10-20','Thu'),('2017-02-03','2073-10-21','Fri'),('2017-02-04','2073-10-22','Sat'),('2017-02-05','2073-10-23','Sun'),('2017-02-06','2073-10-24','Mon'),('2017-02-07','2073-10-25','Tue'),('2017-02-08','2073-10-26','Wed'),('2017-02-09','2073-10-27','Thu'),('2017-02-10','2073-10-28','Fri'),('2017-02-11','2073-10-29','Sat'),('2017-02-12','2073-11-01','Sun'),('2017-02-13','2073-11-02','Mon'),('2017-02-14','2073-11-03','Tue'),('2017-02-15','2073-11-04','Wed'),('2017-02-16','2073-11-05','Thu'),('2017-02-17','2073-11-06','Fri'),('2017-02-18','2073-11-07','Sat'),('2017-02-19','2073-11-08','Sun'),('2017-02-20','2073-11-09','Mon'),('2017-02-21','2073-11-10','Tue'),('2017-02-22','2073-11-11','Wed'),('2017-02-23','2073-11-12','Thu'),('2017-02-24','2073-11-13','Fri'),('2017-02-25','2073-11-14','Sat'),('2017-02-26','2073-11-15','Sun'),('2017-02-27','2073-11-16','Mon'),('2017-02-28','2073-11-17','Tue'),('2017-03-01','2073-11-18','Wed'),('2017-03-02','2073-11-19','Thu'),('2017-03-03','2073-11-20','Fri'),('2017-03-04','2073-11-21','Sat'),('2017-03-05','2073-11-22','Sun'),('2017-03-06','2073-11-23','Mon'),('2017-03-07','2073-11-24','Tue'),('2017-03-08','2073-11-25','Wed'),('2017-03-09','2073-11-26','Thu'),('2017-03-10','2073-11-27','Fri'),('2017-03-11','2073-11-28','Sat'),('2017-03-12','2073-11-29','Sun'),('2017-03-13','2073-11-30','Mon'),('2017-03-14','2073-12-01','Tue'),('2017-03-15','2073-12-02','Wed'),('2017-03-16','2073-12-03','Thu'),('2017-03-17','2073-12-04','Fri'),('2017-03-18','2073-12-05','Sat'),('2017-03-19','2073-12-06','Sun'),('2017-03-20','2073-12-07','Mon'),('2017-03-21','2073-12-08','Tue'),('2017-03-22','2073-12-09','Wed'),('2017-03-23','2073-12-10','Thu'),('2017-03-24','2073-12-11','Fri'),('2017-03-25','2073-12-12','Sat'),('2017-03-26','2073-12-13','Sun'),('2017-03-27','2073-12-14','Mon'),('2017-03-28','2073-12-15','Tue'),('2017-03-29','2073-12-16','Wed'),('2017-03-30','2073-12-17','Thu'),('2017-03-31','2073-12-18','Fri'),('2017-04-01','2073-12-19','Sat'),('2017-04-02','2073-12-20','Sun'),('2017-04-03','2073-12-21','Mon'),('2017-04-04','2073-12-22','Tue'),('2017-04-05','2073-12-23','Wed'),('2017-04-06','2073-12-24','Thu'),('2017-04-07','2073-12-25','Fri'),('2017-04-08','2073-12-26','Sat'),('2017-04-09','2073-12-27','Sun'),('2017-04-10','2073-12-28','Mon'),('2017-04-11','2073-12-29','Tue'),('2017-04-12','2073-12-30','Wed'),('2017-04-13','2073-12-31','Thu'),('2017-04-14','2074-01-01','Fri'),('2017-04-15','2074-01-02','Sat'),('2017-04-16','2074-01-03','Sun'),('2017-04-17','2074-01-04','Mon'),('2017-04-18','2074-01-05','Tue'),('2017-04-19','2074-01-06','Wed'),('2017-04-20','2074-01-07','Thu'),('2017-04-21','2074-01-08','Fri'),('2017-04-22','2074-01-09','Sat'),('2017-04-23','2074-01-10','Sun'),('2017-04-24','2074-01-11','Mon'),('2017-04-25','2074-01-12','Tue'),('2017-04-26','2074-01-13','Wed'),('2017-04-27','2074-01-14','Thu'),('2017-04-28','2074-01-15','Fri'),('2017-04-29','2074-01-16','Sat'),('2017-04-30','2074-01-17','Sun'),('2017-05-01','2074-01-18','Mon'),('2017-05-02','2074-01-19','Tue'),('2017-05-03','2074-01-20','Wed'),('2017-05-04','2074-01-21','Thu'),('2017-05-05','2074-01-22','Fri'),('2017-05-06','2074-01-23','Sat'),('2017-05-07','2074-01-24','Sun'),('2017-05-08','2074-01-25','Mon'),('2017-05-09','2074-01-26','Tue'),('2017-05-10','2074-01-27','Wed'),('2017-05-11','2074-01-28','Thu'),('2017-05-12','2074-01-29','Fri'),('2017-05-13','2074-01-30','Sat'),('2017-05-14','2074-01-31','Sun'),('2017-05-15','2074-02-01','Mon'),('2017-05-16','2074-02-02','Tue'),('2017-05-17','2074-02-03','Wed'),('2017-05-18','2074-02-04','Thu'),('2017-05-19','2074-02-05','Fri'),('2017-05-20','2074-02-06','Sat'),('2017-05-21','2074-02-07','Sun'),('2017-05-22','2074-02-08','Mon'),('2017-05-23','2074-02-09','Tue'),('2017-05-24','2074-02-10','Wed'),('2017-05-25','2074-02-11','Thu'),('2017-05-26','2074-02-12','Fri'),('2017-05-27','2074-02-13','Sat'),('2017-05-28','2074-02-14','Sun'),('2017-05-29','2074-02-15','Mon'),('2017-05-30','2074-02-16','Tue'),('2017-05-31','2074-02-17','Wed'),('2017-06-01','2074-02-18','Thu'),('2017-06-02','2074-02-19','Fri'),('2017-06-03','2074-02-20','Sat'),('2017-06-04','2074-02-21','Sun'),('2017-06-05','2074-02-22','Mon'),('2017-06-06','2074-02-23','Tue'),('2017-06-07','2074-02-24','Wed'),('2017-06-08','2074-02-25','Thu'),('2017-06-09','2074-02-26','Fri'),('2017-06-10','2074-02-27','Sat'),('2017-06-11','2074-02-28','Sun'),('2017-06-12','2074-02-29','Mon'),('2017-06-13','2074-02-30','Tue'),('2017-06-14','2074-02-31','Wed'),('2017-06-15','2074-03-01','Thu'),('2017-06-16','2074-03-02','Fri'),('2017-06-17','2074-03-03','Sat'),('2017-06-18','2074-03-04','Sun'),('2017-06-19','2074-03-05','Mon'),('2017-06-20','2074-03-06','Tue'),('2017-06-21','2074-03-07','Wed'),('2017-06-22','2074-03-08','Thu'),('2017-06-23','2074-03-09','Fri'),('2017-06-24','2074-03-10','Sat'),('2017-06-25','2074-03-11','Sun'),('2017-06-26','2074-03-12','Mon'),('2017-06-27','2074-03-13','Tue'),('2017-06-28','2074-03-14','Wed'),('2017-06-29','2074-03-15','Thu'),('2017-06-30','2074-03-16','Fri'),('2017-07-01','2074-03-17','Sat'),('2017-07-02','2074-03-18','Sun'),('2017-07-03','2074-03-19','Mon'),('2017-07-04','2074-03-20','Tue'),('2017-07-05','2074-03-21','Wed'),('2017-07-06','2074-03-22','Thu'),('2017-07-07','2074-03-23','Fri'),('2017-07-08','2074-03-24','Sat'),('2017-07-09','2074-03-25','Sun'),('2017-07-10','2074-03-26','Mon'),('2017-07-11','2074-03-27','Tue'),('2017-07-12','2074-03-28','Wed'),('2017-07-13','2074-03-29','Thu'),('2017-07-14','2074-03-30','Fri'),('2017-07-15','2074-03-31','Sat'),('2017-07-16','2074-04-01','Sun'),('2017-07-17','2074-04-02','Mon'),('2017-07-18','2074-04-03','Tue'),('2017-07-19','2074-04-04','Wed'),('2017-07-20','2074-04-05','Thu'),('2017-07-21','2074-04-06','Fri'),('2017-07-22','2074-04-07','Sat'),('2017-07-23','2074-04-08','Sun'),('2017-07-24','2074-04-09','Mon'),('2017-07-25','2074-04-10','Tue'),('2017-07-26','2074-04-11','Wed'),('2017-07-27','2074-04-12','Thu'),('2017-07-28','2074-04-13','Fri'),('2017-07-29','2074-04-14','Sat'),('2017-07-30','2074-04-15','Sun'),('2017-07-31','2074-04-16','Mon'),('2017-08-01','2074-04-17','Tue'),('2017-08-02','2074-04-18','Wed'),('2017-08-03','2074-04-19','Thu'),('2017-08-04','2074-04-20','Fri'),('2017-08-05','2074-04-21','Sat'),('2017-08-06','2074-04-22','Sun'),('2017-08-07','2074-04-23','Mon'),('2017-08-08','2074-04-24','Tue'),('2017-08-09','2074-04-25','Wed'),('2017-08-10','2074-04-26','Thu'),('2017-08-11','2074-04-27','Fri'),('2017-08-12','2074-04-28','Sat'),('2017-08-13','2074-04-29','Sun'),('2017-08-14','2074-04-30','Mon'),('2017-08-15','2074-04-31','Tue'),('2017-08-16','2074-04-32','Wed'),('2017-08-17','2074-05-01','Thu'),('2017-08-18','2074-05-02','Fri'),('2017-08-19','2074-05-03','Sat'),('2017-08-20','2074-05-04','Sun'),('2017-08-21','2074-05-05','Mon'),('2017-08-22','2074-05-06','Tue'),('2017-08-23','2074-05-07','Wed'),('2017-08-24','2074-05-08','Thu'),('2017-08-25','2074-05-09','Fri'),('2017-08-26','2074-05-10','Sat'),('2017-08-27','2074-05-11','Sun'),('2017-08-28','2074-05-12','Mon'),('2017-08-29','2074-05-13','Tue'),('2017-08-30','2074-05-14','Wed'),('2017-08-31','2074-05-15','Thu'),('2017-09-01','2074-05-16','Fri'),('2017-09-02','2074-05-17','Sat'),('2017-09-03','2074-05-18','Sun'),('2017-09-04','2074-05-19','Mon'),('2017-09-05','2074-05-20','Tue'),('2017-09-06','2074-05-21','Wed'),('2017-09-07','2074-05-22','Thu'),('2017-09-08','2074-05-23','Fri'),('2017-09-09','2074-05-24','Sat'),('2017-09-10','2074-05-25','Sun'),('2017-09-11','2074-05-26','Mon'),('2017-09-12','2074-05-27','Tue'),('2017-09-13','2074-05-28','Wed'),('2017-09-14','2074-05-29','Thu'),('2017-09-15','2074-05-30','Fri'),('2017-09-16','2074-05-31','Sat'),('2017-09-17','2074-06-01','Sun'),('2017-09-18','2074-06-02','Mon'),('2017-09-19','2074-06-03','Tue'),('2017-09-20','2074-06-04','Wed'),('2017-09-21','2074-06-05','Thu'),('2017-09-22','2074-06-06','Fri'),('2017-09-23','2074-06-07','Sat'),('2017-09-24','2074-06-08','Sun'),('2017-09-25','2074-06-09','Mon'),('2017-09-26','2074-06-10','Tue'),('2017-09-27','2074-06-11','Wed'),('2017-09-28','2074-06-12','Thu'),('2017-09-29','2074-06-13','Fri'),('2017-09-30','2074-06-14','Sat'),('2017-10-01','2074-06-15','Sun'),('2017-10-02','2074-06-16','Mon'),('2017-10-03','2074-06-17','Tue'),('2017-10-04','2074-06-18','Wed'),('2017-10-05','2074-06-19','Thu'),('2017-10-06','2074-06-20','Fri'),('2017-10-07','2074-06-21','Sat'),('2017-10-08','2074-06-22','Sun'),('2017-10-09','2074-06-23','Mon'),('2017-10-10','2074-06-24','Tue'),('2017-10-11','2074-06-25','Wed'),('2017-10-12','2074-06-26','Thu'),('2017-10-13','2074-06-27','Fri'),('2017-10-14','2074-06-28','Sat'),('2017-10-15','2074-06-29','Sun'),('2017-10-16','2074-06-30','Mon'),('2017-10-17','2074-06-31','Tue'),('2017-10-18','2074-07-01','Wed'),('2017-10-19','2074-07-02','Thu'),('2017-10-20','2074-07-03','Fri'),('2017-10-21','2074-07-04','Sat'),('2017-10-22','2074-07-05','Sun'),('2017-10-23','2074-07-06','Mon'),('2017-10-24','2074-07-07','Tue'),('2017-10-25','2074-07-08','Wed'),('2017-10-26','2074-07-09','Thu'),('2017-10-27','2074-07-10','Fri'),('2017-10-28','2074-07-11','Sat'),('2017-10-29','2074-07-12','Sun'),('2017-10-30','2074-07-13','Mon'),('2017-10-31','2074-07-14','Tue'),('2017-11-01','2074-07-15','Wed'),('2017-11-02','2074-07-16','Thu'),('2017-11-03','2074-07-17','Fri'),('2017-11-04','2074-07-18','Sat'),('2017-11-05','2074-07-19','Sun'),('2017-11-06','2074-07-20','Mon'),('2017-11-07','2074-07-21','Tue'),('2017-11-08','2074-07-22','Wed'),('2017-11-09','2074-07-23','Thu'),('2017-11-10','2074-07-24','Fri'),('2017-11-11','2074-07-25','Sat'),('2017-11-12','2074-07-26','Sun'),('2017-11-13','2074-07-27','Mon'),('2017-11-14','2074-07-28','Tue'),('2017-11-15','2074-07-29','Wed'),('2017-11-16','2074-07-30','Thu'),('2017-11-17','2074-08-01','Fri'),('2017-11-18','2074-08-02','Sat'),('2017-11-19','2074-08-03','Sun'),('2017-11-20','2074-08-04','Mon'),('2017-11-21','2074-08-05','Tue'),('2017-11-22','2074-08-06','Wed'),('2017-11-23','2074-08-07','Thu'),('2017-11-24','2074-08-08','Fri'),('2017-11-25','2074-08-09','Sat'),('2017-11-26','2074-08-10','Sun'),('2017-11-27','2074-08-11','Mon'),('2017-11-28','2074-08-12','Tue'),('2017-11-29','2074-08-13','Wed'),('2017-11-30','2074-08-14','Thu'),('2017-12-01','2074-08-15','Fri'),('2017-12-02','2074-08-16','Sat'),('2017-12-03','2074-08-17','Sun'),('2017-12-04','2074-08-18','Mon'),('2017-12-05','2074-08-19','Tue'),('2017-12-06','2074-08-20','Wed'),('2017-12-07','2074-08-21','Thu'),('2017-12-08','2074-08-22','Fri'),('2017-12-09','2074-08-23','Sat'),('2017-12-10','2074-08-24','Sun'),('2017-12-11','2074-08-25','Mon'),('2017-12-12','2074-08-26','Tue'),('2017-12-13','2074-08-27','Wed'),('2017-12-14','2074-08-28','Thu'),('2017-12-15','2074-08-29','Fri'),('2017-12-16','2074-09-01','Sat'),('2017-12-17','2074-09-02','Sun'),('2017-12-18','2074-09-03','Mon'),('2017-12-19','2074-09-04','Tue'),('2017-12-20','2074-09-05','Wed'),('2017-12-21','2074-09-06','Thu'),('2017-12-22','2074-09-07','Fri'),('2017-12-23','2074-09-08','Sat'),('2017-12-24','2074-09-09','Sun'),('2017-12-25','2074-09-10','Mon'),('2017-12-26','2074-09-11','Tue'),('2017-12-27','2074-09-12','Wed'),('2017-12-28','2074-09-13','Thu'),('2017-12-29','2074-09-14','Fri'),('2017-12-30','2074-09-15','Sat'),('2017-12-31','2074-09-16','Sun'),('2018-01-01','2074-09-17','Mon'),('2018-01-02','2074-09-18','Tue'),('2018-01-03','2074-09-19','Wed'),('2018-01-04','2074-09-20','Thu'),('2018-01-05','2074-09-21','Fri'),('2018-01-06','2074-09-22','Sat'),('2018-01-07','2074-09-23','Sun'),('2018-01-08','2074-09-24','Mon'),('2018-01-09','2074-09-25','Tue'),('2018-01-10','2074-09-26','Wed'),('2018-01-11','2074-09-27','Thu'),('2018-01-12','2074-09-28','Fri'),('2018-01-13','2074-09-29','Sat'),('2018-01-14','2074-09-30','Sun'),('2018-01-15','2074-10-01','Mon'),('2018-01-16','2074-10-02','Tue'),('2018-01-17','2074-10-03','Wed'),('2018-01-18','2074-10-04','Thu'),('2018-01-19','2074-10-05','Fri'),('2018-01-20','2074-10-06','Sat'),('2018-01-21','2074-10-07','Sun'),('2018-01-22','2074-10-08','Mon'),('2018-01-23','2074-10-09','Tue'),('2018-01-24','2074-10-10','Wed'),('2018-01-25','2074-10-11','Thu'),('2018-01-26','2074-10-12','Fri'),('2018-01-27','2074-10-13','Sat'),('2018-01-28','2074-10-14','Sun'),('2018-01-29','2074-10-15','Mon'),('2018-01-30','2074-10-16','Tue'),('2018-01-31','2074-10-17','Wed'),('2018-02-01','2074-10-18','Thu'),('2018-02-02','2074-10-19','Fri'),('2018-02-03','2074-10-20','Sat'),('2018-02-04','2074-10-21','Sun'),('2018-02-05','2074-10-22','Mon'),('2018-02-06','2074-10-23','Tue'),('2018-02-07','2074-10-24','Wed'),('2018-02-08','2074-10-25','Thu'),('2018-02-09','2074-10-26','Fri'),('2018-02-10','2074-10-27','Sat'),('2018-02-11','2074-10-28','Sun'),('2018-02-12','2074-10-29','Mon'),('2018-02-13','2074-11-01','Tue'),('2018-02-14','2074-11-02','Wed'),('2018-02-15','2074-11-03','Thu'),('2018-02-16','2074-11-04','Fri'),('2018-02-17','2074-11-05','Sat'),('2018-02-18','2074-11-06','Sun'),('2018-02-19','2074-11-07','Mon'),('2018-02-20','2074-11-08','Tue'),('2018-02-21','2074-11-09','Wed'),('2018-02-22','2074-11-10','Thu'),('2018-02-23','2074-11-11','Fri'),('2018-02-24','2074-11-12','Sat'),('2018-02-25','2074-11-13','Sun'),('2018-02-26','2074-11-14','Mon'),('2018-02-27','2074-11-15','Tue'),('2018-02-28','2074-11-16','Wed'),('2018-03-01','2074-11-17','Thu'),('2018-03-02','2074-11-18','Fri'),('2018-03-03','2074-11-19','Sat'),('2018-03-04','2074-11-20','Sun'),('2018-03-05','2074-11-21','Mon'),('2018-03-06','2074-11-22','Tue'),('2018-03-07','2074-11-23','Wed'),('2018-03-08','2074-11-24','Thu'),('2018-03-09','2074-11-25','Fri'),('2018-03-10','2074-11-26','Sat'),('2018-03-11','2074-11-27','Sun'),('2018-03-12','2074-11-28','Mon'),('2018-03-13','2074-11-29','Tue'),('2018-03-14','2074-11-30','Wed'),('2018-03-15','2074-12-01','Thu'),('2018-03-16','2074-12-02','Fri'),('2018-03-17','2074-12-03','Sat'),('2018-03-18','2074-12-04','Sun'),('2018-03-19','2074-12-05','Mon'),('2018-03-20','2074-12-06','Tue'),('2018-03-21','2074-12-07','Wed'),('2018-03-22','2074-12-08','Thu'),('2018-03-23','2074-12-09','Fri'),('2018-03-24','2074-12-10','Sat'),('2018-03-25','2074-12-11','Sun'),('2018-03-26','2074-12-12','Mon'),('2018-03-27','2074-12-13','Tue'),('2018-03-28','2074-12-14','Wed'),('2018-03-29','2074-12-15','Thu'),('2018-03-30','2074-12-16','Fri'),('2018-03-31','2074-12-17','Sat'),('2018-04-01','2074-12-18','Sun'),('2018-04-02','2074-12-19','Mon'),('2018-04-03','2074-12-20','Tue'),('2018-04-04','2074-12-21','Wed'),('2018-04-05','2074-12-22','Thu'),('2018-04-06','2074-12-23','Fri'),('2018-04-07','2074-12-24','Sat'),('2018-04-08','2074-12-25','Sun'),('2018-04-09','2074-12-26','Mon'),('2018-04-10','2074-12-27','Tue'),('2018-04-11','2074-12-28','Wed'),('2018-04-12','2074-12-29','Thu'),('2018-04-13','2074-12-30','Fri');
/*!40000 ALTER TABLE `ad_bs_calender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_name_para`
--

DROP TABLE IF EXISTS `class_name_para`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class_name_para` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(20) NOT NULL,
  `COURSE_GROUP` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_name_para`
--

LOCK TABLES `class_name_para` WRITE;
/*!40000 ALTER TABLE `class_name_para` DISABLE KEYS */;
/*!40000 ALTER TABLE `class_name_para` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course_group`
--

DROP TABLE IF EXISTS `course_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `course_group` (
  `CODE` varchar(10) NOT NULL,
  `NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`CODE`),
  UNIQUE KEY `NAME` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course_group`
--

LOCK TABLES `course_group` WRITE;
/*!40000 ALTER TABLE `course_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `course_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_details`
--

DROP TABLE IF EXISTS `exam_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_details` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `EXAM_ID` varchar(10) NOT NULL,
  `EXAM_YEAR` varchar(10) NOT NULL,
  `EXAM_NAME` varchar(30) NOT NULL,
  `START_DATE` date DEFAULT NULL,
  `END_DATE` date DEFAULT NULL,
  PRIMARY KEY (`SN`),
  UNIQUE KEY `UNIQUE_EXAM_ID_EXAM_YEAR` (`EXAM_ID`,`EXAM_YEAR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_details`
--

LOCK TABLES `exam_details` WRITE;
/*!40000 ALTER TABLE `exam_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_result`
--

DROP TABLE IF EXISTS `exam_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_result` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `EXAM_SN` int(11) DEFAULT NULL,
  `SCHOOL_ID` int(11) NOT NULL,
  `STUDENT_ID` int(11) DEFAULT NULL,
  `TOTAL_PM` float DEFAULT NULL,
  `TOTAL_FM` float DEFAULT NULL,
  `TOTAL_OBTAIN_MARK` float DEFAULT NULL,
  `DIVISION` varchar(15) DEFAULT NULL,
  `GRADE` varchar(2) DEFAULT NULL,
  `GPA` varchar(3) DEFAULT NULL,
  `RESULT` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`SN`),
  KEY `FK_SCHOOL_ID_OF_SCHOOL_INFO` (`SCHOOL_ID`),
  KEY `FK_STUDENT_ID_OF_students` (`STUDENT_ID`),
  KEY `FK_EXAM_SN_OF_exam_details` (`EXAM_SN`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_result`
--

LOCK TABLES `exam_result` WRITE;
/*!40000 ALTER TABLE `exam_result` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_result_details`
--

DROP TABLE IF EXISTS `exam_result_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_result_details` (
  `MARK_ID` double(20,10) NOT NULL,
  `EXAM_SUBJECT_SN` int(11) NOT NULL,
  `EXAM_RESULT_SN` int(11) DEFAULT NULL,
  `TH_OM` float(5,2) DEFAULT NULL,
  `PH_OM` float(5,2) DEFAULT NULL,
  PRIMARY KEY (`MARK_ID`),
  KEY `FK_EXAM_SUBJECT_SN` (`EXAM_SUBJECT_SN`),
  KEY `FK_EXAM_RESULT_SN` (`EXAM_RESULT_SN`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_result_details`
--

LOCK TABLES `exam_result_details` WRITE;
/*!40000 ALTER TABLE `exam_result_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_result_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_student_reg`
--

DROP TABLE IF EXISTS `exam_student_reg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_student_reg` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `ACADEMIC_YEAR` varchar(9) NOT NULL,
  `EXAM_ID` varchar(30) DEFAULT NULL,
  `SCHOOL_SN` int(11) DEFAULT NULL,
  `STUDENT_SN` int(11) DEFAULT NULL,
  `REG_NO` varchar(30) NOT NULL,
  `TIME_OF_ATTEMPT` int(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`SN`),
  UNIQUE KEY `UNIQUE_EXAM_YEAR_REG_NO` (`ACADEMIC_YEAR`,`REG_NO`),
  UNIQUE KEY `UNIQUE_EXAM_YEAR_EXAM_ID_SCHOOL_STUDENT` (`ACADEMIC_YEAR`,`EXAM_ID`,`SCHOOL_SN`,`STUDENT_SN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_student_reg`
--

LOCK TABLES `exam_student_reg` WRITE;
/*!40000 ALTER TABLE `exam_student_reg` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_student_reg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_subject`
--

DROP TABLE IF EXISTS `exam_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exam_subject` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `SUBJECT_COM_SN` int(11) DEFAULT NULL,
  `SUBJECT_OPT_SN` int(11) DEFAULT NULL,
  `EXAM_ID_ES_REG` varchar(30) NOT NULL,
  `GRADING_TYPE` varchar(1) NOT NULL,
  `TH_FM` float(5,2) DEFAULT NULL,
  `TH_PM` float(5,2) DEFAULT NULL,
  `PH_FM` float(5,2) DEFAULT NULL,
  `PH_PM` float(5,2) DEFAULT NULL,
  `IN_ORDER` int(11) DEFAULT NULL,
  PRIMARY KEY (`SN`),
  KEY `FK_SUBJECT_OPT_SN` (`SUBJECT_OPT_SN`),
  KEY `FK_SUBJECT_COM_SN` (`SUBJECT_COM_SN`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_subject`
--

LOCK TABLES `exam_subject` WRITE;
/*!40000 ALTER TABLE `exam_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `exam_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result_div_para`
--

DROP TABLE IF EXISTS `result_div_para`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result_div_para` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRECENT_FROM` float NOT NULL,
  `PRECENT_TO` float NOT NULL,
  `DIVISION_NAME` varchar(15) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result_div_para`
--

LOCK TABLES `result_div_para` WRITE;
/*!40000 ALTER TABLE `result_div_para` DISABLE KEYS */;
/*!40000 ALTER TABLE `result_div_para` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result_grade_para`
--

DROP TABLE IF EXISTS `result_grade_para`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `result_grade_para` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRECENT_FROM` float NOT NULL,
  `PRECENT_TO` float NOT NULL,
  `GRADE_NAME` varchar(10) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result_grade_para`
--

LOCK TABLES `result_grade_para` WRITE;
/*!40000 ALTER TABLE `result_grade_para` DISABLE KEYS */;
/*!40000 ALTER TABLE `result_grade_para` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school_info`
--

DROP TABLE IF EXISTS `school_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ADDRESS` varchar(255) DEFAULT NULL,
  `ALIAS_NAME` varchar(255) DEFAULT NULL,
  `ALIAS_NAME_NEPALI` varchar(255) DEFAULT NULL,
  `CODE` varchar(255) NOT NULL,
  `CONTACT_EMAIL` varchar(255) DEFAULT NULL,
  `CONTACT_NO` varchar(255) DEFAULT NULL,
  `CONTACT_PERSON` varchar(255) DEFAULT NULL,
  `DISTRICT` varchar(255) NOT NULL,
  `EST_YEAR` varchar(255) DEFAULT NULL,
  `MAX_GRADE_LEVEL` varchar(255) NOT NULL,
  `NAME` varchar(255) NOT NULL,
  `NAME_NEPALI` varchar(255) DEFAULT NULL,
  `ORG_TYPE` varchar(255) NOT NULL,
  `PRINCIPAL_CONTACT_NO` varchar(255) DEFAULT NULL,
  `PRINCIPAL_NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school_info`
--

LOCK TABLES `school_info` WRITE;
/*!40000 ALTER TABLE `school_info` DISABLE KEYS */;
INSERT INTO `school_info` VALUES (3,'1','1','1','1','1','1','1','1','1','1','1','1','1','1','1'),(4,'1','1','1','2','1','1','1','1','1','1','2','1','1','1','1'),(5,'1','1','1','5','1','1','1','1','1','1','2','1','1','1','1'),(6,'5','5','55','5','5','5','5','5','5','5','5','5','5','5','5'),(7,'6','6','6','6','6','6','6','6','6','6','6','6','6','6','6');
/*!40000 ALTER TABLE `school_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_photo_details`
--

DROP TABLE IF EXISTS `student_photo_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_photo_details` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `STUDENT_SN` int(11) NOT NULL,
  `PHOTO_LINK` varchar(100) NOT NULL,
  PRIMARY KEY (`SN`),
  KEY `FK_STUDENT_SN_PHOTO_DETAILS` (`STUDENT_SN`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_photo_details`
--

LOCK TABLES `student_photo_details` WRITE;
/*!40000 ALTER TABLE `student_photo_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_photo_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `ACADEMIC_YEAR` varchar(10) NOT NULL,
  `SCHOOL_ID` int(11) DEFAULT NULL,
  `SCHOOL_GRADE` varchar(5) NOT NULL,
  `SCHOOL_ROLL` varchar(5) NOT NULL,
  `REG_NO` varchar(30) DEFAULT NULL,
  `SYMBOL_NO` varchar(30) DEFAULT NULL,
  `STUDENT_NAME` varchar(40) NOT NULL,
  `NAME_NEPALI` varchar(500) NOT NULL,
  `DOB_AD` date NOT NULL,
  `DOB_BS` varchar(10) NOT NULL,
  PRIMARY KEY (`SN`),
  UNIQUE KEY `UNIQUE_ACADEMIC_YEAR_SCHOOL_GRADE_ROLL` (`ACADEMIC_YEAR`,`SCHOOL_ID`,`SCHOOL_GRADE`,`SCHOOL_ROLL`),
  UNIQUE KEY `UNIQUE_REG_NO` (`REG_NO`),
  UNIQUE KEY `UNIQUE_SYMBOL_NO` (`SYMBOL_NO`),
  KEY `FK_SCHOOL_ID_STUDENTS` (`SCHOOL_ID`)) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_general_info`
--

DROP TABLE IF EXISTS `students_general_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students_general_info` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `PERMANENT_STREET` varchar(300) DEFAULT NULL,
  `PERMANENT_MUNICIPAL` varchar(50) DEFAULT NULL,
  `PERMANENT_WARD_NO` varchar(2) DEFAULT NULL,
  `PERMANENT_DISTRICT` varchar(40) NOT NULL,
  `TEMPORARY_ADDRESS` varchar(300) DEFAULT NULL,
  `CONTACT_NO` varchar(25) DEFAULT NULL,
  `CONTACT_EMAIL` varchar(30) DEFAULT NULL,
  `STUDENT_SN` int(11) NOT NULL,
  PRIMARY KEY (`SN`),
  KEY `FK_STUDENT_SN_OF_GENERAL_INFO` (`STUDENT_SN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_general_info`
--

LOCK TABLES `students_general_info` WRITE;
/*!40000 ALTER TABLE `students_general_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `students_general_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students_guardian_information`
--

DROP TABLE IF EXISTS `students_guardian_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `students_guardian_information` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `FATHER_NAME` varchar(30) NOT NULL,
  `FATHER_CONTACT_NO` varchar(25) DEFAULT NULL,
  `FATHER_EMAIL` varchar(30) DEFAULT NULL,
  `FATHER_OCCUPATION` varchar(30) DEFAULT NULL,
  `MOTHER_NAME` varchar(30) DEFAULT NULL,
  `MOTHER_CONTACT_NO` varchar(25) DEFAULT NULL,
  `LOCAL_GUARDIAN_NAME` varchar(30) DEFAULT NULL,
  `LOCAL_GUARDIAN_CONTACT_NO` varchar(30) DEFAULT NULL,
  `LOCAL_GUARDION_EMAIL` varchar(30) DEFAULT NULL,
  `STUDENT_SN` int(11) NOT NULL,
  PRIMARY KEY (`SN`),
  KEY `FK_STUDENT_SN_SGI` (`STUDENT_SN`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students_guardian_information`
--

LOCK TABLES `students_guardian_information` WRITE;
/*!40000 ALTER TABLE `students_guardian_information` DISABLE KEYS */;
/*!40000 ALTER TABLE `students_guardian_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_para_com`
--

DROP TABLE IF EXISTS `subject_para_com`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_para_com` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_GROUP` varchar(10) NOT NULL,
  `CLASS_ID` int(11) NOT NULL,
  `SUB_CODE` varchar(10) NOT NULL,
  `SUB_NAME` varchar(30) NOT NULL,
  `TH_FM` float DEFAULT NULL,
  `TH_PM` float DEFAULT NULL,
  `PH_FM` float DEFAULT NULL,
  `PH_PM` float DEFAULT NULL,
  PRIMARY KEY (`SN`),
  UNIQUE KEY `UNIQUE_COURSE_GROUP_CLASS_ID_SUB_NAME` (`COURSE_GROUP`,`CLASS_ID`,`SUB_NAME`),
  KEY `FK_COURSE_GROUP_COM` (`COURSE_GROUP`),
  KEY `FK_CLASS_ID_COM` (`CLASS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_para_com`
--

LOCK TABLES `subject_para_com` WRITE;
/*!40000 ALTER TABLE `subject_para_com` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_para_com` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_para_opt`
--

DROP TABLE IF EXISTS `subject_para_opt`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_para_opt` (
  `SN` int(11) NOT NULL AUTO_INCREMENT,
  `COURSE_GROUP` varchar(10) NOT NULL,
  `CLASS_ID` int(11) NOT NULL,
  `SUB_CODE` varchar(10) NOT NULL,
  `SUB_NAME` varchar(30) NOT NULL,
  `TH_FM` float DEFAULT NULL,
  `TH_PM` float DEFAULT NULL,
  `PH_FM` float DEFAULT NULL,
  `PH_PM` float DEFAULT NULL,
  PRIMARY KEY (`SN`),
  UNIQUE KEY `UNIQUE_COURSE_GROUP_CLASS_ID_SUB_NAME_OPT` (`COURSE_GROUP`,`CLASS_ID`,`SUB_NAME`),
  KEY `FK_COURSE_GROUP_OPT` (`COURSE_GROUP`),
  KEY `FK_CLASS_ID_OPT` (`CLASS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_para_opt`
--

LOCK TABLES `subject_para_opt` WRITE;
/*!40000 ALTER TABLE `subject_para_opt` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_para_opt` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-02-19  7:55:37

--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
