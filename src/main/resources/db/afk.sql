/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50559
Source Host           : 127.0.0.1:3306
Source Database       : afk

Target Server Type    : MYSQL
Target Server Version : 50559
File Encoding         : 65001

Date: 2019-04-16 16:12:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `is_button` int(11) DEFAULT NULL,
  `is_menu` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `sorting` int(11) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_permission
-- ----------------------------
INSERT INTO `sys_permission` VALUES ('10', 'set', null, '1', '系统管理', '0', '1', 'set');
INSERT INTO `sys_permission` VALUES ('11', 'permission', null, '1', '功能管理', '10', '1', '/auth/permission/list');
INSERT INTO `sys_permission` VALUES ('12', 'role', null, '1', '角色管理', '10', '2', '/auth/role/list');
INSERT INTO `sys_permission` VALUES ('13', 'user', null, '1', '用户管理', '10', '3', '/auth/user/list');
INSERT INTO `sys_permission` VALUES ('14', 'log', null, '1', '日志管理', '0', '2', 'log');
INSERT INTO `sys_permission` VALUES ('18', 'druid', null, '1', '数据库监控', '14', '1', '/druid/index.html');

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', '超级管理员', '测试');
INSERT INTO `sys_role` VALUES ('2', '测试角色', '');

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_permission
-- ----------------------------
INSERT INTO `sys_role_permission` VALUES ('21', '10', '1');
INSERT INTO `sys_role_permission` VALUES ('23', '11', '1');
INSERT INTO `sys_role_permission` VALUES ('24', '13', '1');
INSERT INTO `sys_role_permission` VALUES ('27', '12', '1');
INSERT INTO `sys_role_permission` VALUES ('28', '10', '2');
INSERT INTO `sys_role_permission` VALUES ('29', '11', '2');
INSERT INTO `sys_role_permission` VALUES ('30', '12', '2');
INSERT INTO `sys_role_permission` VALUES ('31', '13', '2');
INSERT INTO `sys_role_permission` VALUES ('32', '14', '2');
INSERT INTO `sys_role_permission` VALUES ('33', '15', '2');
INSERT INTO `sys_role_permission` VALUES ('34', '17', '2');
INSERT INTO `sys_role_permission` VALUES ('35', '18', '2');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL,
  `real_name` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `is_enabled` varchar(10) DEFAULT NULL,
  `update_time` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', 'admin', '123456', '2019-04-01 11:03:23', '老大哥', '15340440270', 'Y', '2019-04-12 03:56:38');
INSERT INTO `sys_user` VALUES ('6', 'fuxj', '123456', '2019-04-12 05:30:00', '傅孝均', '15340440270', 'Y', '2019-04-12 05:30:14');

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_role
-- ----------------------------
INSERT INTO `sys_user_role` VALUES ('1', '2', '2');
INSERT INTO `sys_user_role` VALUES ('2', '1', '1');
INSERT INTO `sys_user_role` VALUES ('3', '2', '5');
INSERT INTO `sys_user_role` VALUES ('4', '2', '6');
SET FOREIGN_KEY_CHECKS=1;
