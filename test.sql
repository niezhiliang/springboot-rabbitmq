/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50560
 Source Host           : localhost
 Source Database       : test

 Target Server Type    : MySQL
 Target Server Version : 50560
 File Encoding         : utf-8

 Date: 01/25/2019 11:11:39 AM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `broker_message_log`
-- ----------------------------
DROP TABLE IF EXISTS `broker_message_log`;
CREATE TABLE `broker_message_log` (
  `message_id` varchar(128) NOT NULL,
  `message` varchar(4000) DEFAULT NULL,
  `try_count` int(4) DEFAULT '0',
  `status` varchar(10) DEFAULT NULL,
  `next_retry` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `broker_message_log`
-- ----------------------------
BEGIN;
INSERT INTO `broker_message_log` VALUES ('13374406-41a8-42b7-9196-c9f796e5646b1548385185925', '{\"id\":14,\"message_id\":\"13374406-41a8-42b7-9196-c9f796e5646b1548385185925\",\"name\":\"06778844-acc2-4f6d-827a-e3a31c1273fd\"}', '0', '1', '2019-01-25 11:00:46', '2019-01-25 10:59:46', '2019-01-25 10:59:50'), ('a9c8700c-27d2-4a66-bc80-18169caf23c61548385387459', '{\"id\":15,\"message_id\":\"a9c8700c-27d2-4a66-bc80-18169caf23c61548385387459\",\"name\":\"c8e2dbf8-1b35-4088-b265-7d5414134186\"}', '1', '0', '2019-01-25 11:04:08', '2019-01-25 11:03:08', '2019-01-25 11:04:46'), ('df93bba6-f749-451a-9aed-0965db5a68061548385451106', '{\"id\":16,\"message_id\":\"df93bba6-f749-451a-9aed-0965db5a68061548385451106\",\"name\":\"5b684d54-0a0a-48de-863f-050543a1f216\"}', '0', '0', '2019-01-25 11:05:12', '2019-01-25 11:04:12', '2019-01-25 11:05:46'), ('e5d30da6-fbc3-4094-b2c3-4e7cf1ce88dd1548383818964', '{\"id\":13,\"message_id\":\"e5d30da6-fbc3-4094-b2c3-4e7cf1ce88dd1548383818964\",\"name\":\"6f592682-58f0-40c3-a9f6-d225ef7851b4\"}', '0', '1', '2019-01-25 10:38:00', '2019-01-25 10:37:00', '2019-01-25 10:37:00');
COMMIT;

-- ----------------------------
--  Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `message_id` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `t_order`
-- ----------------------------
BEGIN;
INSERT INTO `t_order` VALUES ('13', '6f592682-58f0-40c3-a9f6-d225ef7851b4', 'e5d30da6-fbc3-4094-b2c3-4e7cf1ce88dd1548383818964'), ('14', '06778844-acc2-4f6d-827a-e3a31c1273fd', '13374406-41a8-42b7-9196-c9f796e5646b1548385185925'), ('15', 'c8e2dbf8-1b35-4088-b265-7d5414134186', 'a9c8700c-27d2-4a66-bc80-18169caf23c61548385387459'), ('16', '5b684d54-0a0a-48de-863f-050543a1f216', 'df93bba6-f749-451a-9aed-0965db5a68061548385451106');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
