-- MySQL dump 10.13  Distrib 5.6.10, for osx10.7 (x86_64)
--
-- Host: localhost    Database: prolims_db
-- ------------------------------------------------------
-- Server version	5.6.10

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
-- Table structure for table `t_sys_main_department`
--

DROP TABLE IF EXISTS `t_sys_main_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_main_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `name_en` varchar(255) DEFAULT NULL,
  `name_zh` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_main_department`
--

LOCK TABLES `t_sys_main_department` WRITE;
/*!40000 ALTER TABLE `t_sys_main_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_main_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_main_menu`
--

DROP TABLE IF EXISTS `t_sys_main_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_main_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `list_order` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_main_menu`
--

LOCK TABLES `t_sys_main_menu` WRITE;
/*!40000 ALTER TABLE `t_sys_main_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_main_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_role`
--

DROP TABLE IF EXISTS `t_sys_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_role`
--

LOCK TABLES `t_sys_role` WRITE;
/*!40000 ALTER TABLE `t_sys_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_role_menu`
--

DROP TABLE IF EXISTS `t_sys_role_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `menu_id` bigint(20) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEE8E7C0B36F747C6` (`menu_id`),
  KEY `FKEE8E7C0B8871BD6E` (`role_id`),
  CONSTRAINT `FKEE8E7C0B36F747C6` FOREIGN KEY (`menu_id`) REFERENCES `t_sys_sub_menu` (`id`),
  CONSTRAINT `FKEE8E7C0B8871BD6E` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_role_menu`
--

LOCK TABLES `t_sys_role_menu` WRITE;
/*!40000 ALTER TABLE `t_sys_role_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_role_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_sub_department`
--

DROP TABLE IF EXISTS `t_sys_sub_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_sub_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `list_order` int(11) NOT NULL,
  `name_en` varchar(255) DEFAULT NULL,
  `name_zh` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `main_department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4046780E76AE6D81` (`main_department_id`),
  CONSTRAINT `FK4046780E76AE6D81` FOREIGN KEY (`main_department_id`) REFERENCES `t_sys_main_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_sub_department`
--

LOCK TABLES `t_sys_sub_department` WRITE;
/*!40000 ALTER TABLE `t_sys_sub_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_sub_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_sub_menu`
--

DROP TABLE IF EXISTS `t_sys_sub_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_sub_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `is_delete` bit(1) DEFAULT NULL,
  `is_save` bit(1) DEFAULT NULL,
  `is_view` bit(1) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `main_menu_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF670871BA66527A1` (`main_menu_id`),
  CONSTRAINT `FKF670871BA66527A1` FOREIGN KEY (`main_menu_id`) REFERENCES `t_sys_main_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_sub_menu`
--

LOCK TABLES `t_sys_sub_menu` WRITE;
/*!40000 ALTER TABLE `t_sys_sub_menu` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_sub_menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_user_info`
--

DROP TABLE IF EXISTS `t_sys_user_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_user_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `activaty` bit(1) DEFAULT NULL,
  `age` int(11) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `sex` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEEC22D253E6F1DE6` (`department_id`),
  CONSTRAINT `FKEEC22D253E6F1DE6` FOREIGN KEY (`department_id`) REFERENCES `t_sys_sub_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_user_info`
--

LOCK TABLES `t_sys_user_info` WRITE;
/*!40000 ALTER TABLE `t_sys_user_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_user_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sys_user_role`
--

DROP TABLE IF EXISTS `t_sys_user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sys_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKEEC648ED8871BD6E` (`role_id`),
  KEY `FKEEC648ED3035A29C` (`user_id`),
  CONSTRAINT `FKEEC648ED3035A29C` FOREIGN KEY (`user_id`) REFERENCES `t_sys_user_info` (`id`),
  CONSTRAINT `FKEEC648ED8871BD6E` FOREIGN KEY (`role_id`) REFERENCES `t_sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sys_user_role`
--

LOCK TABLES `t_sys_user_role` WRITE;
/*!40000 ALTER TABLE `t_sys_user_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_sys_user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_department`
--

DROP TABLE IF EXISTS `tb_department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_department` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_department`
--

LOCK TABLES `tb_department` WRITE;
/*!40000 ALTER TABLE `tb_department` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_goods`
--

DROP TABLE IF EXISTS `tb_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `cupboard` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `number` int(11) NOT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `unit` varchar(255) DEFAULT NULL,
  `staff_id` bigint(20) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFA26FE4521A0BE81` (`staff_id`),
  KEY `FKFA26FE453567DD37` (`type_id`),
  CONSTRAINT `FKFA26FE4521A0BE81` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`),
  CONSTRAINT `FKFA26FE453567DD37` FOREIGN KEY (`type_id`) REFERENCES `tb_goods_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_goods`
--

LOCK TABLES `tb_goods` WRITE;
/*!40000 ALTER TABLE `tb_goods` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_goods_type`
--

DROP TABLE IF EXISTS `tb_goods_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_goods_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_goods_type`
--

LOCK TABLES `tb_goods_type` WRITE;
/*!40000 ALTER TABLE `tb_goods_type` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_goods_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_out_store`
--

DROP TABLE IF EXISTS `tb_out_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_out_store` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `number` int(11) NOT NULL,
  `pick_name` varchar(255) DEFAULT NULL,
  `pick_phone` varchar(255) DEFAULT NULL,
  `goods_id` bigint(20) DEFAULT NULL,
  `staff_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK87DC301F51B5E2C1` (`goods_id`),
  KEY `FK87DC301F21A0BE81` (`staff_id`),
  CONSTRAINT `FK87DC301F21A0BE81` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`),
  CONSTRAINT `FK87DC301F51B5E2C1` FOREIGN KEY (`goods_id`) REFERENCES `tb_goods` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_out_store`
--

LOCK TABLES `tb_out_store` WRITE;
/*!40000 ALTER TABLE `tb_out_store` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_out_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_staff`
--

DROP TABLE IF EXISTS `tb_staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_staff` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `department_id` bigint(20) DEFAULT NULL,
  `level_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFAD229CFFADA8413` (`department_id`),
  KEY `FKFAD229CF1E6B57D3` (`level_id`),
  CONSTRAINT `FKFAD229CF1E6B57D3` FOREIGN KEY (`level_id`) REFERENCES `tb_staff_level` (`id`),
  CONSTRAINT `FKFAD229CFFADA8413` FOREIGN KEY (`department_id`) REFERENCES `tb_department` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_staff`
--

LOCK TABLES `tb_staff` WRITE;
/*!40000 ALTER TABLE `tb_staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_staff_level`
--

DROP TABLE IF EXISTS `tb_staff_level`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_staff_level` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_staff_level`
--

LOCK TABLES `tb_staff_level` WRITE;
/*!40000 ALTER TABLE `tb_staff_level` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_staff_level` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_syslog`
--

DROP TABLE IF EXISTS `tb_syslog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tb_syslog` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT NULL,
  `level` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `staff_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5FC1CC4821A0BE81` (`staff_id`),
  CONSTRAINT `FK5FC1CC4821A0BE81` FOREIGN KEY (`staff_id`) REFERENCES `tb_staff` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_syslog`
--

LOCK TABLES `tb_syslog` WRITE;
/*!40000 ALTER TABLE `tb_syslog` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_syslog` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-03-31 21:42:02
