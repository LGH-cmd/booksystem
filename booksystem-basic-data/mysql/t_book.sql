/*
Navicat MySQL Data Transfer

Source Server         : localhost-3306-root
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2019-12-30 18:35:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_book
-- ----------------------------
DROP TABLE IF EXISTS `t_book`;
CREATE TABLE `t_book` (
  `id` varchar(10) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double(6,0) DEFAULT NULL,
  `bnum` int(15) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
