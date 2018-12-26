/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : news

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-12-26 12:58:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `article_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog_id` int(11) DEFAULT NULL,
  `article_number` varchar(2) DEFAULT NULL,
  `article_title` varchar(50) DEFAULT NULL,
  `article_content` text,
  `manager_id` int(11) DEFAULT NULL,
  `article_time` datetime DEFAULT NULL,
  `article_state` varchar(1) DEFAULT NULL,
  `article_clicks` int(11) DEFAULT NULL,
  `article_like` int(11) DEFAULT NULL,
  PRIMARY KEY (`article_id`),
  KEY `FK_Reference_11` (`manager_id`),
  KEY `FK_Reference_8` (`catalog_id`),
  CONSTRAINT `FK_Reference_11` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`catalog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('1', '1', null, '今天，是我离开自已创办的企业一周年', '<p>很多时候，自已并不是死在对手的攻击下，而是死在自已的欲望中。想多了，常常无法前行，纠结多了，也就越来越迷失自我。</p>', '1', '2018-12-06 10:00:54', '1', '78', '17');
INSERT INTO `article` VALUES ('2', '2', null, '对不起，文章迟发，又让你多吸了一根烟', '<p>不要误以为侥幸一直存在，死神只是和你擦肩而过；不要因为一时的兴奋，换来的是生命的尽头，这绝对世界上最廉价的交易。</p>', '1', '2018-12-06 02:55:03', '1', '23', '3');
INSERT INTO `article` VALUES ('6', '6', null, '12312', '<p>哈哈哈哈</p>', '1', '2018-12-06 00:51:39', '1', '6', '3');
INSERT INTO `article` VALUES ('7', '7', null, '测试123', '<p>哈哈哈</p>', '1', '2018-12-06 00:52:39', '1', '11', '4');
INSERT INTO `article` VALUES ('9', '1', null, '测试哈', '<p>哈<br/></p>', '1', '2018-12-06 00:51:02', '0', '1', '0');
INSERT INTO `article` VALUES ('10', '10', null, '图片测试', '1<p><br></p>', '1', '2018-12-12 18:10:04', '1', '0', '0');
INSERT INTO `article` VALUES ('11', '1', null, '图片测试2', '1', '1', '2018-12-05 20:05:30', '1', '0', '0');
INSERT INTO `article` VALUES ('12', '1', null, '测试是是是', '1', '1', '2018-12-05 20:09:37', '1', '0', '0');
INSERT INTO `article` VALUES ('13', '1', null, '测试123', '1', '1', '2018-12-05 20:14:21', '1', '0', '0');
INSERT INTO `article` VALUES ('14', '1', null, '测试12324567', '<p>123</p>', '1', '2018-12-06 00:52:09', '1', '2', '0');
INSERT INTO `article` VALUES ('15', '1', null, 'a', '1', '1', '2018-12-05 20:23:07', '1', '0', '0');
INSERT INTO `article` VALUES ('16', '1', null, '测试123123', '1', '1', '2018-12-05 20:24:25', '1', '0', '0');
INSERT INTO `article` VALUES ('17', '1', null, '测试12312312', '1', '1', '2018-12-05 20:26:02', '1', '0', '0');
INSERT INTO `article` VALUES ('18', '1', null, '阿萨德', '1', '1', '2018-12-05 20:29:54', '1', '0', '0');
INSERT INTO `article` VALUES ('19', '1', null, '测试789阿萨德', '1', '1', '2018-12-05 20:30:51', '1', '0', '0');
INSERT INTO `article` VALUES ('20', '1', null, '测试刚刚', '<p>阿斯蒂芬</p>', '1', '2018-12-05 20:32:23', '1', '0', '0');
INSERT INTO `article` VALUES ('21', '1', null, '测试123阿斯蒂芬发', '<p>阿斯蒂芬</p><p><img src=\"http://192.168.25.133/group1/M00/00/00/wKgZhVwHxWmAJ61vAANzVJ4oEHI933.jpg\" style=\"max-width:100%;\"><img src=\"http://192.168.25.133/group1/M00/00/00/wKgZhVwHxW2AEN_DAAULRA6p5o8120.jpg\" style=\"max-width: 100%;\"><br></p>', '1', '2018-12-06 01:12:58', '1', '1', '0');
INSERT INTO `article` VALUES ('22', '1', null, '测试123123', '<p>123</p>', '1', '2018-12-05 20:48:08', '1', '0', '0');
INSERT INTO `article` VALUES ('23', '1', null, '12', '<p>1</p>', '1', '2018-12-06 00:52:20', '1', '3', '0');
INSERT INTO `article` VALUES ('24', '1', null, '23567', '<p>2</p>', '1', '2018-12-06 03:19:44', '3', '0', '0');
INSERT INTO `article` VALUES ('25', '4', null, '测试12312312', '<p>1231312</p>', '1', '2018-12-20 17:11:37', '1', '1', '0');
INSERT INTO `article` VALUES ('26', '3', null, '测试123', '<p>as</p>', '16', '2018-12-06 09:57:47', '3', '0', '0');
INSERT INTO `article` VALUES ('27', '2', null, '测试123123', '<p>111</p>', '16', '2018-12-06 09:59:35', '4', '0', '0');
INSERT INTO `article` VALUES ('28', '1', null, 'dddddd', '<p>fadsfafds</p><p><img src=\"http://192.168.25.133/group1/M00/00/00/wKgZhVwIgfuAbXOvAASegmjY5i8880.jpg\" style=\"max-width:100%;\"><br></p>', '1', '2018-12-20 17:14:27', '1', '6', '0');
INSERT INTO `article` VALUES ('29', '1', null, '测试123456', '<p>2313231132</p>', '16', '2018-12-06 10:00:46', '1', '2', '0');
INSERT INTO `article` VALUES ('30', '10', null, '10', '<p>10</p>', '1', '2018-12-12 18:13:48', '1', '0', '0');
INSERT INTO `article` VALUES ('31', '1', null, '干货', '<p>干货干货干货干货</p>', '16', '2018-12-16 20:17:52', '0', '0', '0');

-- ----------------------------
-- Table structure for `catalog`
-- ----------------------------
DROP TABLE IF EXISTS `catalog`;
CREATE TABLE `catalog` (
  `catalog_id` int(11) NOT NULL AUTO_INCREMENT,
  `catalog_name` varchar(10) DEFAULT NULL,
  `catalog_state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`catalog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of catalog
-- ----------------------------
INSERT INTO `catalog` VALUES ('1', '干货', '1');
INSERT INTO `catalog` VALUES ('2', '段子', '1');
INSERT INTO `catalog` VALUES ('3', '趣文', '1');
INSERT INTO `catalog` VALUES ('4', 'ONE', '1');
INSERT INTO `catalog` VALUES ('5', '体育2', '1');
INSERT INTO `catalog` VALUES ('6', '体育3', '1');
INSERT INTO `catalog` VALUES ('7', '体育4', '1');
INSERT INTO `catalog` VALUES ('8', '体育12', '3');
INSERT INTO `catalog` VALUES ('9', '体育1', '1');
INSERT INTO `catalog` VALUES ('10', '科技', '1');
INSERT INTO `catalog` VALUES ('11', '音乐', '1');
INSERT INTO `catalog` VALUES ('12', '电影', '1');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `comment_id` int(11) NOT NULL AUTO_INCREMENT,
  `comment_content` text,
  `comment_time` datetime DEFAULT NULL,
  `article_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `comment_state` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `FK_Reference_14` (`user_id`),
  KEY `FK_Reference_9` (`article_id`),
  CONSTRAINT `FK_Reference_14` FOREIGN KEY (`user_id`) REFERENCES `user_info` (`user_id`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '加油加油', '2018-12-06 02:47:12', '1', '1', '1');
INSERT INTO `comment` VALUES ('2', '你好啊', '2018-12-06 02:49:58', '1', '1', '1');
INSERT INTO `comment` VALUES ('3', '哈哈哈', '2018-12-06 02:51:53', '1', '1', '1');
INSERT INTO `comment` VALUES ('4', '很美丽', '2018-12-06 03:39:07', '1', '1', '1');
INSERT INTO `comment` VALUES ('5', 'hhuhu', '2018-12-06 10:00:54', '1', '1', '1');
INSERT INTO `comment` VALUES ('6', 'asdf ', '2018-12-12 18:33:04', '30', '1', '1');
INSERT INTO `comment` VALUES ('7', '123', '2018-12-20 17:14:26', '28', '1', '1');

-- ----------------------------
-- Table structure for `department_info`
-- ----------------------------
DROP TABLE IF EXISTS `department_info`;
CREATE TABLE `department_info` (
  `department_id` int(11) NOT NULL AUTO_INCREMENT,
  `department_name` varchar(30) DEFAULT NULL,
  `department_phone` varchar(11) DEFAULT NULL,
  `department_intro` varchar(255) DEFAULT NULL,
  `department_time` datetime DEFAULT NULL,
  `department_state` varchar(1) DEFAULT NULL,
  `department_likman` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of department_info
-- ----------------------------
INSERT INTO `department_info` VALUES ('1', '新闻管理总部', '18279265280', '新闻总部，可以操作所有栏目', '2018-11-21 23:18:13', '1', 'admin');
INSERT INTO `department_info` VALUES ('2', '体育栏目组', '18279265280', '体育有关的新闻', '2018-11-22 17:15:34', '1', 'admin');
INSERT INTO `department_info` VALUES ('3', '财经栏目组', '18279265280', '财经有关的新闻', '2018-11-22 17:15:51', '1', 'admin');
INSERT INTO `department_info` VALUES ('4', '娱乐栏目组', '18279265280', '123', '2018-11-22 17:16:05', '1', 'admin');
INSERT INTO `department_info` VALUES ('5', '科技栏目组', '18279265280', '有关科技方面的新闻', '2018-11-29 20:37:39', '1', 'admin');
INSERT INTO `department_info` VALUES ('6', '科技栏目组2', '18279265280', '科技2', '2018-11-29 20:39:13', '1', 'admin');
INSERT INTO `department_info` VALUES ('7', '科技栏目组3', '18279265280', '333', '2018-11-29 20:40:43', '3', 'admin');
INSERT INTO `department_info` VALUES ('8', '体育栏目组2', '18279265280', '体育', '2018-11-29 20:44:43', '1', 'admin');
INSERT INTO `department_info` VALUES ('9', '娱乐栏目组2', '18279265280', '娱乐', '2018-11-29 21:14:52', '1', 'admin');
INSERT INTO `department_info` VALUES ('10', '娱乐栏目组3', '18279265280', '12312312', '2018-11-29 21:55:01', '1', 'admin');
INSERT INTO `department_info` VALUES ('11', '娱乐栏目组4', '18279265280', '2313', '2018-11-29 21:55:44', '3', '');

-- ----------------------------
-- Table structure for `depart_catalog`
-- ----------------------------
DROP TABLE IF EXISTS `depart_catalog`;
CREATE TABLE `depart_catalog` (
  `department_id` int(11) DEFAULT NULL,
  `catalog_id` int(11) DEFAULT NULL,
  KEY `FK_Reference_16` (`department_id`),
  KEY `FK_Reference_19` (`catalog_id`),
  CONSTRAINT `FK_Reference_16` FOREIGN KEY (`department_id`) REFERENCES `department_info` (`department_id`),
  CONSTRAINT `FK_Reference_19` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`catalog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depart_catalog
-- ----------------------------
INSERT INTO `depart_catalog` VALUES ('2', '1');
INSERT INTO `depart_catalog` VALUES ('3', '2');
INSERT INTO `depart_catalog` VALUES ('7', '10');
INSERT INTO `depart_catalog` VALUES ('8', '1');
INSERT INTO `depart_catalog` VALUES ('9', '3');
INSERT INTO `depart_catalog` VALUES ('1', '1');
INSERT INTO `depart_catalog` VALUES ('1', '2');
INSERT INTO `depart_catalog` VALUES ('1', '3');
INSERT INTO `depart_catalog` VALUES ('1', '5');
INSERT INTO `depart_catalog` VALUES ('1', '6');
INSERT INTO `depart_catalog` VALUES ('1', '7');
INSERT INTO `depart_catalog` VALUES ('1', '9');
INSERT INTO `depart_catalog` VALUES ('1', '10');
INSERT INTO `depart_catalog` VALUES ('1', '11');
INSERT INTO `depart_catalog` VALUES ('1', '12');
INSERT INTO `depart_catalog` VALUES ('10', '3');
INSERT INTO `depart_catalog` VALUES ('4', '3');
INSERT INTO `depart_catalog` VALUES ('6', '10');
INSERT INTO `depart_catalog` VALUES ('5', '10');

-- ----------------------------
-- Table structure for `function_info`
-- ----------------------------
DROP TABLE IF EXISTS `function_info`;
CREATE TABLE `function_info` (
  `function_id` int(11) NOT NULL AUTO_INCREMENT,
  `function_name` varchar(10) DEFAULT NULL,
  `function_site` varchar(255) DEFAULT NULL,
  `function_comment` varchar(255) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`function_id`),
  KEY `FK_Reference_6` (`module_id`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of function_info
-- ----------------------------
INSERT INTO `function_info` VALUES ('1', '更新系统图片', null, null, '5');

-- ----------------------------
-- Table structure for `image`
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `image_title` varchar(30) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `image_date` datetime DEFAULT NULL,
  `image_state` varchar(2) DEFAULT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('1', '首页大图', 'http://192.168.25.133/group1/M00/00/00/wKgZhVwH2TGAfLvQAAKrxtsgBVg259.png', '2018-12-01 16:26:27', '1');
INSERT INTO `image` VALUES ('2', '右侧标签图1', 'http://192.168.25.133/group1/M00/00/00/wKgZhVwH2WWAa4CQAANlvaCmZos211.jpg', '2018-12-05 21:41:45', '1');
INSERT INTO `image` VALUES ('3', '右侧标签图2', 'http://192.168.25.133/group1/M00/00/00/wKgZhVwH2V2AIJRkAALGa5L5mik274.png', '2018-12-05 21:41:55', '1');
INSERT INTO `image` VALUES ('4', 'logo图', 'http://192.168.25.133/group1/M00/00/00/wKgZhVwH2XKAep1uAAAgNL1mbis521.png', '2018-12-05 21:42:28', '1');
INSERT INTO `image` VALUES ('5', '用户评论头像', 'http://192.168.25.133/group1/M00/00/00/wKgZhVwbXbeAe6D8AAPv18tGMxU992.jpg', '2018-12-20 17:15:39', '1');

-- ----------------------------
-- Table structure for `manager`
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(50) DEFAULT NULL,
  `manager_passwd` varchar(128) DEFAULT NULL,
  `manager_email` varchar(50) DEFAULT NULL,
  `manager_phone` varchar(11) DEFAULT NULL,
  `manager_state` varchar(1) DEFAULT NULL,
  `department_id` int(11) DEFAULT NULL,
  `manager_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`manager_id`),
  KEY `FK_Reference_1` (`department_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`department_id`) REFERENCES `department_info` (`department_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', 'admin', 'b33bad61b118c196d3e6e43e9417ab52', '1647093644@qq.com', '18279265280', '1', '1', '2018112001');
INSERT INTO `manager` VALUES ('3', 'zs2', '7b289bec1048e0206d7ef6ec035f5889', '1647093644@qq.com', '18279265280', '1', '1', '2018112002');
INSERT INTO `manager` VALUES ('4', 'zs3', '546342dbad97f3c7b5ca1f440c873a68', '1647093644@qq.com', '18279265280', '3', '1', '2018112003');
INSERT INTO `manager` VALUES ('8', 'zs5', '2a835b7b569e313eb2617300e16d6512', '1647093644@qq.com', '18279265280', '1', '1', '2018112005');
INSERT INTO `manager` VALUES ('9', 'zs6', 'd35ab52f07bbd6e16821482bb40a4dfb', '1647093644@qq.com', '18279265280', '3', '1', '2018112006');
INSERT INTO `manager` VALUES ('10', 'zs7', '57608128445bf13cbacb9f202e140480', '1647093644@qq.com', '18279265280', '3', '1', '2018112007');
INSERT INTO `manager` VALUES ('11', 'zs8', '608be22c38b7bec97fd4d93a9a030169', '1647093644@qq.com', '18279265280', '3', '1', '2018112008');
INSERT INTO `manager` VALUES ('12', 'zs9', '689cb06721d0070cdaab57f55e027564', '1647093644@qq.com', '18279265280', '1', '2', '2018112009');
INSERT INTO `manager` VALUES ('13', 'zs10', '5e25fd5c7665df0234c319ee2ff88171', '1647093644@qq.com', '18279265280', '3', '11', '20181120010');
INSERT INTO `manager` VALUES ('14', 'admin13', '86eb3fd465f5f5631377b38d3233660b', '1647093644@qq.com', '18279265280', '3', '1', '20181120013');
INSERT INTO `manager` VALUES ('15', 'admin15', '70769599e377a24530017907b1ed6763', '1647093644@qq.com', '18279265280', '1', '5', '20181120015');
INSERT INTO `manager` VALUES ('16', 'admin16', '6f58aef680eb96570866f1d2e3a8cf17', '1647093644@qq.com', '18279265280', '1', '2', '20181120016');
INSERT INTO `manager` VALUES ('17', 'zs17', '1abf129dc1ff8fbd5b4b16c1808f44ba', '1647093644@qq.com', '18279265280', '1', '5', '20181120017');
INSERT INTO `manager` VALUES ('18', 'zs18', 'a745d60a04323886b3920122001674a3', '1647093644@qq.com', '18279265280', '1', '5', '20181120018');

-- ----------------------------
-- Table structure for `manager_role`
-- ----------------------------
DROP TABLE IF EXISTS `manager_role`;
CREATE TABLE `manager_role` (
  `manager_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  KEY `FK_Reference_2` (`manager_id`),
  KEY `FK_Reference_3` (`role_id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager_role
-- ----------------------------
INSERT INTO `manager_role` VALUES ('1', '1');
INSERT INTO `manager_role` VALUES ('1', '1');
INSERT INTO `manager_role` VALUES ('1', '1');
INSERT INTO `manager_role` VALUES ('1', '1');
INSERT INTO `manager_role` VALUES ('4', '1');
INSERT INTO `manager_role` VALUES ('1', '1');
INSERT INTO `manager_role` VALUES ('1', '1');
INSERT INTO `manager_role` VALUES ('1', '1');
INSERT INTO `manager_role` VALUES ('8', '1');
INSERT INTO `manager_role` VALUES ('9', '1');
INSERT INTO `manager_role` VALUES ('10', '1');
INSERT INTO `manager_role` VALUES ('11', '1');
INSERT INTO `manager_role` VALUES ('12', '2');
INSERT INTO `manager_role` VALUES ('13', '2');
INSERT INTO `manager_role` VALUES ('14', '1');
INSERT INTO `manager_role` VALUES ('16', '3');
INSERT INTO `manager_role` VALUES ('15', '2');
INSERT INTO `manager_role` VALUES ('17', '3');
INSERT INTO `manager_role` VALUES ('18', '3');
INSERT INTO `manager_role` VALUES ('3', '1');

-- ----------------------------
-- Table structure for `module`
-- ----------------------------
DROP TABLE IF EXISTS `module`;
CREATE TABLE `module` (
  `module_id` int(11) NOT NULL AUTO_INCREMENT,
  `module_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of module
-- ----------------------------
INSERT INTO `module` VALUES ('1', '新闻管理');
INSERT INTO `module` VALUES ('2', '栏目管理');
INSERT INTO `module` VALUES ('3', '管理员管理');
INSERT INTO `module` VALUES ('4', '用户管理');
INSERT INTO `module` VALUES ('5', '图片管理');
INSERT INTO `module` VALUES ('6', '部门管理');
INSERT INTO `module` VALUES ('7', '评论管理');
INSERT INTO `module` VALUES ('8', '审核管理');
INSERT INTO `module` VALUES ('9', '添加新闻');
INSERT INTO `module` VALUES ('10', '提交审核新闻');
INSERT INTO `module` VALUES ('11', '新闻操作');
INSERT INTO `module` VALUES ('12', '查看部门新闻');
INSERT INTO `module` VALUES ('13', '查看评论');
INSERT INTO `module` VALUES ('14', '查看栏目');
INSERT INTO `module` VALUES ('15', '查看管理员');
INSERT INTO `module` VALUES ('16', '查看部门管理员');
INSERT INTO `module` VALUES ('17', '查看所有新闻');
INSERT INTO `module` VALUES ('18', '部门评论管理');
INSERT INTO `module` VALUES ('19', '部门评论操作');

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) DEFAULT NULL,
  `role_comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_超级管理员', null);
INSERT INTO `role` VALUES ('2', 'ROLE_栏目主管', null);
INSERT INTO `role` VALUES ('3', 'ROLE_栏目管理员', null);

-- ----------------------------
-- Table structure for `role_module`
-- ----------------------------
DROP TABLE IF EXISTS `role_module`;
CREATE TABLE `role_module` (
  `role_id` int(11) DEFAULT NULL,
  `module_id` int(11) DEFAULT NULL,
  KEY `FK_Reference_15` (`role_id`),
  KEY `FK_Reference_5` (`module_id`),
  CONSTRAINT `FK_Reference_15` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`module_id`) REFERENCES `module` (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_module
-- ----------------------------
INSERT INTO `role_module` VALUES ('1', '1');
INSERT INTO `role_module` VALUES ('1', '2');
INSERT INTO `role_module` VALUES ('1', '3');
INSERT INTO `role_module` VALUES ('1', '4');
INSERT INTO `role_module` VALUES ('1', '6');
INSERT INTO `role_module` VALUES ('1', '5');
INSERT INTO `role_module` VALUES ('1', '7');
INSERT INTO `role_module` VALUES ('1', '8');
INSERT INTO `role_module` VALUES ('1', '9');
INSERT INTO `role_module` VALUES ('2', '9');
INSERT INTO `role_module` VALUES ('3', '10');
INSERT INTO `role_module` VALUES ('1', '11');
INSERT INTO `role_module` VALUES ('2', '12');
INSERT INTO `role_module` VALUES ('2', '13');
INSERT INTO `role_module` VALUES ('2', '14');
INSERT INTO `role_module` VALUES ('2', '15');
INSERT INTO `role_module` VALUES ('2', '8');
INSERT INTO `role_module` VALUES ('1', '13');
INSERT INTO `role_module` VALUES ('1', '14');
INSERT INTO `role_module` VALUES ('1', '15');
INSERT INTO `role_module` VALUES ('3', '12');
INSERT INTO `role_module` VALUES ('2', '16');
INSERT INTO `role_module` VALUES ('2', '1');
INSERT INTO `role_module` VALUES ('1', '17');
INSERT INTO `role_module` VALUES ('2', '18');
INSERT INTO `role_module` VALUES ('3', '1');
INSERT INTO `role_module` VALUES ('3', '13');
INSERT INTO `role_module` VALUES ('3', '18');
INSERT INTO `role_module` VALUES ('2', '19');

-- ----------------------------
-- Table structure for `tree_paths`
-- ----------------------------
DROP TABLE IF EXISTS `tree_paths`;
CREATE TABLE `tree_paths` (
  `parent_id` int(11) DEFAULT NULL,
  `child_id` int(11) DEFAULT NULL,
  KEY `FK_Reference_12` (`parent_id`),
  KEY `FK_Reference_13` (`child_id`),
  CONSTRAINT `FK_Reference_12` FOREIGN KEY (`parent_id`) REFERENCES `comment` (`comment_id`),
  CONSTRAINT `FK_Reference_13` FOREIGN KEY (`child_id`) REFERENCES `comment` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tree_paths
-- ----------------------------

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_passwd` varchar(128) DEFAULT NULL,
  `user_email` varchar(50) DEFAULT NULL,
  `user_phone` varchar(11) DEFAULT NULL,
  `user_state` varchar(1) DEFAULT NULL,
  `user_time` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'zs', '56540d0c925c006bcf1d20ac117b7d3f', '1647093644@qq.com', '18279265280', '1', '2018-12-03 00:33:44');
INSERT INTO `user_info` VALUES ('2', '123', 'efdb232bb4eccc8014c52b539c717b10', '1647093641@qq.com', '18279265280', '1', '2018-12-06 01:50:02');
INSERT INTO `user_info` VALUES ('3', '12456', 'b818465837538e1fddfaf8d286b27a20', '1647093642@qq.com', '123456', '1', '2018-12-06 01:54:12');
