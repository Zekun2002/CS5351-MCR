/*
 Navicat Premium Dump SQL

 Source Server         : Localhost MySQL
 Source Server Type    : MySQL
 Source Server Version : 80400 (8.4.0)
 Source Host           : localhost:3306
 Source Schema         : ry-aux3

 Target Server Type    : MySQL
 Target Server Version : 80400 (8.4.0)
 File Encoding         : 65001

 Date: 28/11/2025 11:52:48
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for task_members
-- ----------------------------
DROP TABLE IF EXISTS `task_members`;
CREATE TABLE `task_members`  (
  `task_member_id` int NOT NULL AUTO_INCREMENT COMMENT '任务成员唯一标识',
  `task_id` int NOT NULL COMMENT '任务ID（关联Tasks表）',
  `user_id` int NOT NULL COMMENT '用户ID（关联Users表）',
  `assigned_at` datetime NULL DEFAULT NULL COMMENT '任务分配给成员的时间',
  PRIMARY KEY (`task_member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '任务成员表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of task_members
-- ----------------------------
INSERT INTO `task_members` VALUES (1, 1, 1, '2025-11-27 11:51:53');
INSERT INTO `task_members` VALUES (2, 2, 1, '2025-11-27 11:52:02');
INSERT INTO `task_members` VALUES (3, 3, 1, '2025-11-27 11:52:15');

SET FOREIGN_KEY_CHECKS = 1;
