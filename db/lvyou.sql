/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : lvyou

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-11-16 15:30:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `ly_advice`
-- ----------------------------
DROP TABLE IF EXISTS `ly_advice`;
CREATE TABLE `ly_advice` (
  `id` varchar(50) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `guest_id` varchar(50) DEFAULT NULL,
  `site_id` varchar(50) DEFAULT NULL,
  `versionNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7tewx0kasbhtc00tisqlr61no` (`guest_id`),
  KEY `FKsir3gtq4rumfub2qd9ruf6eog` (`site_id`),
  CONSTRAINT `FK7tewx0kasbhtc00tisqlr61no` FOREIGN KEY (`guest_id`) REFERENCES `ly_guest` (`id`),
  CONSTRAINT `FKsir3gtq4rumfub2qd9ruf6eog` FOREIGN KEY (`site_id`) REFERENCES `ly_site` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_advice
-- ----------------------------

-- ----------------------------
-- Table structure for `ly_comment`
-- ----------------------------
DROP TABLE IF EXISTS `ly_comment`;
CREATE TABLE `ly_comment` (
  `id` varchar(50) NOT NULL,
  `content` varchar(500) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `title` varchar(20) DEFAULT NULL,
  `guest_id` varchar(50) DEFAULT NULL,
  `site_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKnxr79t7laacjk9mqms0o5x38p` (`guest_id`),
  KEY `FKpd7dv2eikomxu20tca1719wy0` (`site_id`),
  CONSTRAINT `FKnxr79t7laacjk9mqms0o5x38p` FOREIGN KEY (`guest_id`) REFERENCES `ly_guest` (`id`),
  CONSTRAINT `FKpd7dv2eikomxu20tca1719wy0` FOREIGN KEY (`site_id`) REFERENCES `ly_site` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_comment
-- ----------------------------

-- ----------------------------
-- Table structure for `ly_employee`
-- ----------------------------
DROP TABLE IF EXISTS `ly_employee`;
CREATE TABLE `ly_employee` (
  `id` varchar(50) NOT NULL,
  `birthday` date DEFAULT NULL,
  `headImage` varchar(200) DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `no` varchar(50) DEFAULT NULL,
  `position` varchar(2) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `scene_id` varchar(50) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj3v9nsr72ajndvxi2k3whdhsn` (`user_id`),
  KEY `FK8rnql7iitnwsckxncw43acb04` (`scene_id`),
  CONSTRAINT `FK8rnql7iitnwsckxncw43acb04` FOREIGN KEY (`scene_id`) REFERENCES `ly_scene` (`id`),
  CONSTRAINT `FKj3v9nsr72ajndvxi2k3whdhsn` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_employee
-- ----------------------------
INSERT INTO `ly_employee` VALUES ('emp01', null, null, null, '13209847564', '侯大', null, null, null, 'sc1', 'db2ede8d-5212-4204-bbbe-a9e6d7751834');
INSERT INTO `ly_employee` VALUES ('emp02', null, null, null, '13790037564', '侯二', null, null, null, 'sc1', 'bf35d020-eb45-49ef-80e6-52eff6792455');

-- ----------------------------
-- Table structure for `ly_guest`
-- ----------------------------
DROP TABLE IF EXISTS `ly_guest`;
CREATE TABLE `ly_guest` (
  `id` varchar(50) NOT NULL,
  `birthday` date DEFAULT NULL,
  `idCard` varchar(50) DEFAULT NULL,
  `mobile` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(2) DEFAULT NULL,
  `user_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKs0vnvdwb1o3yiyl2a2hxe1v` (`user_id`),
  CONSTRAINT `FKs0vnvdwb1o3yiyl2a2hxe1v` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_guest
-- ----------------------------
INSERT INTO `ly_guest` VALUES ('guest01', null, null, '18983345656', '张三', null, 'a0eb4bb3-5cf9-48d7-904a-12b54c14a41b');
INSERT INTO `ly_guest` VALUES ('guest02', null, null, '17898755656', '李四', null, 'fabb438d-51e7-4e4d-887e-cf6573ab65c8');
INSERT INTO `ly_guest` VALUES ('guest03', null, null, '15398753490', '王五', null, '5bb0e5be-8abb-46d3-88a0-da0db11790ca');

-- ----------------------------
-- Table structure for `ly_scene`
-- ----------------------------
DROP TABLE IF EXISTS `ly_scene`;
CREATE TABLE `ly_scene` (
  `id` varchar(50) NOT NULL,
  `address` varchar(50) DEFAULT NULL,
  `description` varchar(50) DEFAULT NULL,
  `img` varchar(50) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `open` varchar(2) DEFAULT NULL,
  `telephone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_scene
-- ----------------------------
INSERT INTO `ly_scene` VALUES ('sc-jpa-1', null, null, null, '华山', null, null);
INSERT INTO `ly_scene` VALUES ('sc-jpa-3', null, null, null, '华山', null, null);
INSERT INTO `ly_scene` VALUES ('sc1', null, null, null, '峨眉山', null, null);

-- ----------------------------
-- Table structure for `ly_site`
-- ----------------------------
DROP TABLE IF EXISTS `ly_site`;
CREATE TABLE `ly_site` (
  `id` varchar(50) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `open` varchar(1) DEFAULT NULL,
  `place` varchar(50) DEFAULT NULL,
  `siteImage` varchar(200) DEFAULT NULL,
  `scene_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdq5cucujm5oal21v0qlw1qqng` (`scene_id`),
  CONSTRAINT `FKdq5cucujm5oal21v0qlw1qqng` FOREIGN KEY (`scene_id`) REFERENCES `ly_scene` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_site
-- ----------------------------
INSERT INTO `ly_site` VALUES ('site-jpa-1', null, '思过崖', null, null, null, 'sc-jpa-1');
INSERT INTO `ly_site` VALUES ('site-jpa-3', null, '思过崖', null, null, null, 'sc-jpa-3');
INSERT INTO `ly_site` VALUES ('site1', null, '长寿寺', null, null, null, 'sc1');

-- ----------------------------
-- Table structure for `ly_ticketrecord`
-- ----------------------------
DROP TABLE IF EXISTS `ly_ticketrecord`;
CREATE TABLE `ly_ticketrecord` (
  `id` varchar(50) NOT NULL,
  `instruction` varchar(200) DEFAULT NULL,
  `time` date DEFAULT NULL,
  `employee_id` varchar(50) DEFAULT NULL,
  `guest_id` varchar(50) DEFAULT NULL,
  `tickettype_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2myfnoeudfur1prlpbguolrca` (`employee_id`),
  KEY `FK8ikidcbhcryi763y1ox09udax` (`guest_id`),
  KEY `FKd5ajct54hwd2yx26gb3qja3yo` (`tickettype_id`),
  CONSTRAINT `FK2myfnoeudfur1prlpbguolrca` FOREIGN KEY (`employee_id`) REFERENCES `ly_employee` (`id`),
  CONSTRAINT `FK8ikidcbhcryi763y1ox09udax` FOREIGN KEY (`guest_id`) REFERENCES `ly_guest` (`id`),
  CONSTRAINT `FKd5ajct54hwd2yx26gb3qja3yo` FOREIGN KEY (`tickettype_id`) REFERENCES `ly_tickettype` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_ticketrecord
-- ----------------------------

-- ----------------------------
-- Table structure for `ly_tickettype`
-- ----------------------------
DROP TABLE IF EXISTS `ly_tickettype`;
CREATE TABLE `ly_tickettype` (
  `id` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `price` varchar(10) DEFAULT NULL,
  `scene_id` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKclit0c12yo0weynmokc33rvti` (`scene_id`),
  CONSTRAINT `FKclit0c12yo0weynmokc33rvti` FOREIGN KEY (`scene_id`) REFERENCES `ly_scene` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ly_tickettype
-- ----------------------------

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
  `id` varchar(50) NOT NULL,
  `icon` varchar(200) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  `parent_id` varchar(50) DEFAULT NULL,
  `no` varchar(30) DEFAULT NULL,
  `idx` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2jrf4gb0gjqi8882gxytpxnhe` (`parent_id`),
  CONSTRAINT `FK2jrf4gb0gjqi8882gxytpxnhe` FOREIGN KEY (`parent_id`) REFERENCES `sys_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('1', 'icon-cogs', '系统管理', '', null, '00', null);
INSERT INTO `sys_menu` VALUES ('10', 'icon-bank', '景区管理', null, null, '10', null);
INSERT INTO `sys_menu` VALUES ('2', 'icon-user', '用户', 'sys/user/list', '1', '0001', null);
INSERT INTO `sys_menu` VALUES ('323', 'icon-asterisk', '角色', 'sys/role/list', '1', '0090', null);
INSERT INTO `sys_menu` VALUES ('5', 'icon-bars', '菜单', 'sys/menu/list', '1', '0002', null);
INSERT INTO `sys_menu` VALUES ('advice', 'icon-asterisk', '投诉建议', 'ly/advice/list', '10', '1050', null);
INSERT INTO `sys_menu` VALUES ('comment', 'icon-asterisk', '评论', 'ly/comment/list', '10', '1060', null);
INSERT INTO `sys_menu` VALUES ('employee', 'icon-asterisk', '工作人员', 'ly/employee/list', '10', '1030', null);
INSERT INTO `sys_menu` VALUES ('guest', 'icon-asterisk', '游客', 'ly/guest/list', '10', '1070', null);
INSERT INTO `sys_menu` VALUES ('scene', 'icon-asterisk', '景区', 'ly/scene/list', '10', '1001', null);
INSERT INTO `sys_menu` VALUES ('site', 'icon-asterisk', '景点', 'ly/site/list', '10', '1010', null);
INSERT INTO `sys_menu` VALUES ('ticketRecord', 'icon-asterisk', '购票记录', 'ly/ticketRecord/list', '10', '1040', null);
INSERT INTO `sys_menu` VALUES ('tickettype', 'icon-asterisk', '票类型', 'ly/tickettype/list', '10', '1020', null);

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` varchar(50) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('admin', '具有最高权限', '系统管理员');
INSERT INTO `sys_role` VALUES ('employee', '可以管理景区所有数据', '工作人员');
INSERT INTO `sys_role` VALUES ('guest', '仅查看购票记录、景区、景点信息', '游客');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(50) NOT NULL,
  `menu_id` varchar(50) NOT NULL,
  KEY `FKf3mud4qoc7ayew8nml4plkevo` (`menu_id`),
  KEY `FKkeitxsgxwayackgqllio4ohn5` (`role_id`),
  CONSTRAINT `FKf3mud4qoc7ayew8nml4plkevo` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`),
  CONSTRAINT `FKkeitxsgxwayackgqllio4ohn5` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('employee', '10');
INSERT INTO `sys_role_menu` VALUES ('employee', 'scene');
INSERT INTO `sys_role_menu` VALUES ('employee', 'site');
INSERT INTO `sys_role_menu` VALUES ('employee', 'tickettype');
INSERT INTO `sys_role_menu` VALUES ('employee', 'employee');
INSERT INTO `sys_role_menu` VALUES ('employee', 'ticketRecord');
INSERT INTO `sys_role_menu` VALUES ('employee', 'advice');
INSERT INTO `sys_role_menu` VALUES ('employee', 'comment');
INSERT INTO `sys_role_menu` VALUES ('guest', '10');
INSERT INTO `sys_role_menu` VALUES ('guest', 'scene');
INSERT INTO `sys_role_menu` VALUES ('guest', 'site');
INSERT INTO `sys_role_menu` VALUES ('guest', 'tickettype');
INSERT INTO `sys_role_menu` VALUES ('guest', 'ticketRecord');
INSERT INTO `sys_role_menu` VALUES ('guest', 'advice');
INSERT INTO `sys_role_menu` VALUES ('guest', 'comment');
INSERT INTO `sys_role_menu` VALUES ('guest', 'guest');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(50) NOT NULL,
  `loginName` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `headImage` varchar(200) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_2n5scdnrxopq9btfgbqwlxdxy` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', null, null);
INSERT INTO `sys_user` VALUES ('4545', '454545', '4545454', 'upload/qf.png', null);
INSERT INTO `sys_user` VALUES ('5bb0e5be-8abb-46d3-88a0-da0db11790ca', '15398753490', '123456', null, null);
INSERT INTO `sys_user` VALUES ('a0eb4bb3-5cf9-48d7-904a-12b54c14a41b', '18983345656', '123456', null, null);
INSERT INTO `sys_user` VALUES ('bf35d020-eb45-49ef-80e6-52eff6792455', '13790037564', '123456', null, null);
INSERT INTO `sys_user` VALUES ('C01', 'cailei1', '123456', null, '2017-09-09 00:00:00');
INSERT INTO `sys_user` VALUES ('C02', 'cailei2', '123456', null, '2017-09-10 00:00:00');
INSERT INTO `sys_user` VALUES ('C03', 'cailei3', '123456', null, '2017-09-11 00:00:00');
INSERT INTO `sys_user` VALUES ('C04', 'cailei4', '123456', null, '2017-09-12 00:00:00');
INSERT INTO `sys_user` VALUES ('C05', 'cailei5', '123456', null, '2017-09-13 00:00:00');
INSERT INTO `sys_user` VALUES ('C06', 'cailei6', '123456', null, '2017-09-14 00:00:00');
INSERT INTO `sys_user` VALUES ('C07', 'cailei7', '123456', null, '2017-09-15 00:00:00');
INSERT INTO `sys_user` VALUES ('C08', 'cailei8', '123456', null, '2017-09-16 00:00:00');
INSERT INTO `sys_user` VALUES ('C09', 'cailei9', '123456', null, '2017-09-17 00:00:00');
INSERT INTO `sys_user` VALUES ('C10', 'cailei10', '123456', null, '2017-09-18 00:00:00');
INSERT INTO `sys_user` VALUES ('C11', 'cailei11', '123456', null, '2017-09-19 00:00:00');
INSERT INTO `sys_user` VALUES ('C12', 'cailei12', '123456', null, '2017-09-20 00:00:00');
INSERT INTO `sys_user` VALUES ('C13', 'cailei13', '123456', null, '2017-09-21 00:00:00');
INSERT INTO `sys_user` VALUES ('C14', 'cailei14', '123456', null, '2017-09-22 00:00:00');
INSERT INTO `sys_user` VALUES ('C15', 'cailei15', '123456', null, '2017-09-23 00:00:00');
INSERT INTO `sys_user` VALUES ('C16', 'cailei16', '123456', null, '2017-09-24 00:00:00');
INSERT INTO `sys_user` VALUES ('C17', 'cailei17', '123456', null, '2017-09-25 00:00:00');
INSERT INTO `sys_user` VALUES ('C18', 'cailei18', '123456', null, '2017-09-26 00:00:00');
INSERT INTO `sys_user` VALUES ('C19', 'cailei19', '123456', null, '2017-09-27 00:00:00');
INSERT INTO `sys_user` VALUES ('db2ede8d-5212-4204-bbbe-a9e6d7751834', '13209847564', '123456', null, null);
INSERT INTO `sys_user` VALUES ('fabb438d-51e7-4e4d-887e-cf6573ab65c8', '17898755656', '123456', null, null);
