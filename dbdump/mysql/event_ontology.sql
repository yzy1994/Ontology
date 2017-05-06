-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: event_ontology
-- ------------------------------------------------------
-- Server version	5.6.28-log

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
-- Table structure for table `env_ont_lat`
--

DROP TABLE IF EXISTS `env_ont_lat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `env_ont_lat` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `latsid` varchar(45) DEFAULT NULL,
  `latname` varchar(45) DEFAULT NULL,
  `parentsid` varchar(45) DEFAULT NULL,
  `latnote` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `env_ont_lat`
--

LOCK TABLES `env_ont_lat` WRITE;
/*!40000 ALTER TABLE `env_ont_lat` DISABLE KEYS */;
INSERT INTO `env_ont_lat` VALUES (1,'eve11','事故现场','root',NULL),(2,'eve21','城市','eve11',NULL),(5,'eve22','山区','eve11','notew');
/*!40000 ALTER TABLE `env_ont_lat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `eve_ont_lat`
--

DROP TABLE IF EXISTS `eve_ont_lat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `eve_ont_lat` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `latsid` varchar(45) DEFAULT NULL,
  `latname` varchar(45) DEFAULT NULL,
  `parentsid` varchar(45) DEFAULT NULL,
  `latnote` text,
  `peoelement` varchar(45) DEFAULT NULL,
  `objelement` varchar(45) DEFAULT NULL,
  `envelement` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eve_ont_lat`
--

LOCK TABLES `eve_ont_lat` WRITE;
/*!40000 ALTER TABLE `eve_ont_lat` DISABLE KEYS */;
/*!40000 ALTER TABLE `eve_ont_lat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `obj_ont_lat`
--

DROP TABLE IF EXISTS `obj_ont_lat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `obj_ont_lat` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `latsid` varchar(96) DEFAULT NULL,
  `latname` varchar(96) DEFAULT NULL,
  `parentsid` varchar(765) DEFAULT NULL,
  `latnote` text,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `obj_ont_lat`
--

LOCK TABLES `obj_ont_lat` WRITE;
/*!40000 ALTER TABLE `obj_ont_lat` DISABLE KEYS */;
INSERT INTO `obj_ont_lat` VALUES (25,'obj11','交通工具','root',NULL),(26,'obj21','机动车','obj11',NULL),(28,'obj22','非机动车','obj11','note'),(29,'eve33','机动车-行人事故','eve21','1');
/*!40000 ALTER TABLE `obj_ont_lat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peo_ont_lat`
--

DROP TABLE IF EXISTS `peo_ont_lat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `peo_ont_lat` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `latsid` varchar(45) DEFAULT NULL,
  `latname` varchar(45) DEFAULT NULL,
  `parentsid` varchar(45) DEFAULT NULL,
  `latnote` text,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peo_ont_lat`
--

LOCK TABLES `peo_ont_lat` WRITE;
/*!40000 ALTER TABLE `peo_ont_lat` DISABLE KEYS */;
INSERT INTO `peo_ont_lat` VALUES (1,'obj11','参与者','root','1'),(2,'obj21','当事人','obj11',NULL),(3,'obj22','执法者','obj11',NULL),(4,'obj23','救护者','obj11','。');
/*!40000 ALTER TABLE `peo_ont_lat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission`
--

DROP TABLE IF EXISTS `permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission` (
  `perid` int(11) NOT NULL AUTO_INCREMENT,
  `pername` varchar(30) NOT NULL,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`perid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission`
--

LOCK TABLES `permission` WRITE;
/*!40000 ALTER TABLE `permission` DISABLE KEYS */;
INSERT INTO `permission` VALUES (1,'system:query','查询事件类、事件、要素、关系、平台界面、程序接口'),(2,'system:invoke','调用接口函数'),(3,'system:build','事件本体有关信息的插入与修改；本体一致性检查和冗余性检查'),(4,'system:maintenance','系统维护的权限');
/*!40000 ALTER TABLE `permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permission_role`
--

DROP TABLE IF EXISTS `permission_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permission_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `perid` (`perid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `permission_role_ibfk_1` FOREIGN KEY (`perid`) REFERENCES `permission` (`perid`),
  CONSTRAINT `permission_role_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permission_role`
--

LOCK TABLES `permission_role` WRITE;
/*!40000 ALTER TABLE `permission_role` DISABLE KEYS */;
INSERT INTO `permission_role` VALUES (1,1,2,'2016-04-21 16:02:42'),(2,1,3,'2016-04-21 16:02:43'),(3,1,4,'2016-04-21 16:02:45'),(4,2,2,'2016-04-21 16:02:47'),(5,2,3,'2016-04-21 16:02:48'),(6,2,4,'2016-04-21 16:02:49'),(7,3,3,'2016-04-21 16:02:51'),(8,3,4,'2016-04-21 16:02:52'),(9,4,4,'2016-04-21 16:02:55');
/*!40000 ALTER TABLE `permission_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `roleid` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) NOT NULL,
  `note` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'guest','游客'),(2,'normal_user','普通用户'),(3,'builder','本体构建用户'),(4,'administrator','系统管理员');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `realname` varchar(20) DEFAULT NULL,
  `organization` varchar(30) NOT NULL,
  `mobilephone` char(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin1','123','liqiang','shu','15821822802','603265406@qq.com','2016-04-21 16:02:14'),(2,'admin2','123','Rose','anjuke','13821522802','60326dk@anjuke.com','2016-04-21 16:02:16'),(3,'admin3','123','Lin','huawei','13822422601','123hua@huawei.com','2016-04-21 16:02:18');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `userid` (`userid`),
  KEY `roleid` (`roleid`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`userid`),
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1,1,NULL),(2,2,2,NULL),(3,3,3,NULL),(4,3,4,NULL);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'event_ontology'
--

--
-- Dumping routines for database 'event_ontology'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-06 17:06:39
