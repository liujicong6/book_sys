/*
MySQL Data Transfer
Source Host: localhost
Source Database: system_book
Target Host: localhost
Target Database: system_book
Date: 2020/4/10 9:06:31
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for system_book_category
-- ----------------------------
CREATE TABLE `system_book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category` varchar(32) NOT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_info
-- ----------------------------
CREATE TABLE `system_book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ä¸»é”®',
  `bookName` varchar(128) DEFAULT NULL COMMENT 'ä¹¦å',
  `author` varchar(128) DEFAULT NULL COMMENT 'ä½œè€…',
  `categoryId` int(11) DEFAULT NULL COMMENT 'åˆ†ç±»id',
  `publisher` varchar(128) DEFAULT NULL COMMENT 'å‡ºç‰ˆç¤¾',
  `price` double DEFAULT NULL COMMENT 'å”®ä»·',
  `photo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_orders
-- ----------------------------
CREATE TABLE `system_book_orders` (
  `oid` varchar(32) NOT NULL COMMENT 'è®¢å•å·',
  `bid` int(11) DEFAULT NULL COMMENT 'å…³è”SYTEM_BOOK_INFOçš„ä¸»é”®',
  `count` double DEFAULT NULL COMMENT 'è®¢å•æ•°é‡',
  `curPrice` double DEFAULT NULL COMMENT 'å•ä»·',
  `date` datetime DEFAULT NULL COMMENT 'è®¢å•æ—¥æœŸæ—¶é—´',
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_user
-- ----------------------------
CREATE TABLE `system_book_user` (
  `userId` varchar(64) NOT NULL COMMENT '账户',
  `userPsw` varchar(64) NOT NULL COMMENT '密码',
  `userName` varchar(128) DEFAULT NULL COMMENT '姓名',
  `role` int(11) DEFAULT '1' COMMENT '角色',
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `system_book_category` VALUES ('10', '仙侠');
INSERT INTO `system_book_category` VALUES ('9', '历史');
INSERT INTO `system_book_category` VALUES ('13', '小说');
INSERT INTO `system_book_category` VALUES ('11', '玄幻');
INSERT INTO `system_book_info` VALUES ('6', '凡人修仙传', '忘语', '10', '中国邮政出版社', '17', null);
INSERT INTO `system_book_user` VALUES ('21232f297a57a5a743894a0e4a801fc3', '21232f297a57a5a743894a0e4a801fc3', '管理员', '2');
