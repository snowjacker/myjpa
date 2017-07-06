/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.17-log : Database - dashboard
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`dashboard` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `dashboard`;

/*Table structure for table `boarduser` */

DROP TABLE IF EXISTS `boarduser`;

CREATE TABLE `boarduser` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(50) NOT NULL COMMENT '用户名字',
  `USER_ROLE` varchar(50) NOT NULL DEFAULT 'admin' COMMENT '用户角色',
  `USER_AGE` int(3) NOT NULL COMMENT '用户年纪',
  `USER_ADDRESS` varchar(50) NOT NULL COMMENT '用户家庭住址',
  `USER_SEX` char(5) NOT NULL COMMENT '用户性别',
  `USER_BIRTHDAY` date NOT NULL COMMENT '用户生日',
  `USER_EMAIL` varchar(20) NOT NULL COMMENT '用户邮箱',
  `USER_PASSWORD` varchar(20) NOT NULL COMMENT '用户密码',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

/*Data for the table `boarduser` */

insert  into `boarduser`(`user_id`,`USER_NAME`,`USER_ROLE`,`USER_AGE`,`USER_ADDRESS`,`USER_SEX`,`USER_BIRTHDAY`,`USER_EMAIL`,`USER_PASSWORD`) values (1,'QQ','admin',200,'www.qq.com','男','1993-02-02','www@qq.com','adminadmin'),(2,'Ali','admin',14,'www.alibaba.com','男','2007-02-02','www@ali.com','adminadmin'),(3,'Bai','admin',28,'www.baidu.com','男','2009-09-09','www@bai.com','adminadmin'),(4,'Yi','admin',22,'www.163.com','男','2007-07-07','www@163.com','adminadmin'),(5,'Sina','admin',45,'www.sina.com','男','2003-03-03','www@sina.com','adminadmin'),(6,'Jing','admin',22,'www.jingdong.com','男','2003-03-03','www@jingdong.com','adminadmin'),(7,'Hu','admin',22,'www.souhu.com','男','1988-08-08','www@souhu.com','adminadmin'),(8,'360','admin',22,'www.360.com','男','1986-08-08','www@360.com','adminadmin'),(9,'youKu','admin',34,'www.youku.com','男','1890-09-09','www@youku.com','adminadmin'),(42,'test','admin',67,'adminadminadmin','男','2009-09-09','test@test.com','adminadmin');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
