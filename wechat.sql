/*
 Navicat Premium Data Transfer

 Source Server         : docker3307
 Source Server Type    : MySQL
 Source Server Version : 50640
 Source Host           : localhost
 Source Database       : wechat

 Target Server Type    : MySQL
 Target Server Version : 50640
 File Encoding         : utf-8

 Date: 07/14/2018 18:57:54 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `hibernate_sequence`
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Table structure for `mem`
-- ----------------------------
DROP TABLE IF EXISTS `mem`;
CREATE TABLE `mem` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `id_card` varchar(100) DEFAULT NULL,
  `sex` varchar(100) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  `ticket_num` varchar(100) DEFAULT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `child_contact` varchar(100) DEFAULT NULL,
  `residence` varchar(255) DEFAULT NULL,
  `seat_requirements` varchar(255) DEFAULT NULL,
  `office` varchar(255) DEFAULT NULL,
  `passenger_region` varchar(255) DEFAULT NULL,
  `passenger_source` varchar(255) DEFAULT NULL,
  `food_requirements` varchar(255) DEFAULT NULL,
  `meal_optional_content` varchar(255) DEFAULT NULL,
  `is_in_group` varchar(255) DEFAULT NULL,
  `we_chat_id` varchar(255) DEFAULT NULL,
  `chatroom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=362 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
