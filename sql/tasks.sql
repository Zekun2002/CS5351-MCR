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

 Date: 24/11/2025 19:28:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for tasks
-- ----------------------------
DROP TABLE IF EXISTS `tasks`;
CREATE TABLE `tasks`  (
  `task_id` int NOT NULL AUTO_INCREMENT COMMENT '任务唯一标识',
  `project_id` int NULL DEFAULT NULL COMMENT '任务所属项目ID（关联Projects表）',
  `task_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任务名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '任务描述',
  `priority` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任务优先级（高、中、低）',
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '任务状态（待办、进行中、已完成）',
  `created_by` int NULL DEFAULT NULL COMMENT '创建任务的用户ID（关联Users表）   ',
  `assigned_to` int NULL DEFAULT NULL COMMENT '任务分配给的用户ID（关联Users表）',
  `created_at` datetime NULL DEFAULT NULL COMMENT '任务创建时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '任务更新时间',
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '任务表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tasks
-- ----------------------------
INSERT INTO `tasks` VALUES (1, 1, '测试任务', '', '高', '已完成', 1, 1, '2025-11-10 00:00:00', '2025-11-13 00:00:00');

SET FOREIGN_KEY_CHECKS = 1;
