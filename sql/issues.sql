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

 Date: 24/11/2025 19:29:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for issues
-- ----------------------------
DROP TABLE IF EXISTS `issues`;
CREATE TABLE `issues`  (
  `issue_id` int NOT NULL AUTO_INCREMENT COMMENT '问题唯一标识',
  `project_id` int NULL DEFAULT NULL COMMENT '问题所属项目ID（关联Projects表） ',
  `task_id` int NULL DEFAULT NULL COMMENT '问题所属任务ID（关联Tasks表）',
  `issue_type` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '问题类型（Bug、技术债务）',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '问题描述',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '问题状态（待办、进行中、已解决） ',
  `created_by` int NULL DEFAULT NULL COMMENT '创建问题的用户ID（关联Users表）',
  `created_at` datetime NULL DEFAULT NULL COMMENT '问题创建时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '问题更新时间',
  PRIMARY KEY (`issue_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '问题表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of issues
-- ----------------------------
INSERT INTO `issues` VALUES (1, 1, 1, 'test', '无', '已解决', 1, '2025-11-10 00:00:00', '2025-11-10 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
