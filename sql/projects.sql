/*
MySQL Data Transfer
Source Host: localhost
Source Database: ry-new1
Target Host: localhost
Target Database: ry-new1
Date: 2025/11/25 0:42:23
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for projects
-- ----------------------------
DROP TABLE IF EXISTS `projects`;
CREATE TABLE `projects` (
  `project_id` int NOT NULL AUTO_INCREMENT COMMENT '项目id',
  `project_name` varchar(100) DEFAULT NULL COMMENT '项目名称',
  `description` text COMMENT '项目描述',
  `start_date` date DEFAULT NULL COMMENT '项目开始日期',
  `end_date` date DEFAULT NULL COMMENT '项目预计结束日期',
  `created_by` int DEFAULT NULL COMMENT '创建者id',
  `created_at` datetime DEFAULT NULL COMMENT '项目创建时间',
  `updated_at` datetime DEFAULT NULL COMMENT '项目更新时间',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `projects` VALUES ('1', 'First project', 'a', '2025-09-01', '2025-11-29', '2', '2025-11-25 00:00:00', '2025-11-27 00:00:00');
INSERT INTO `projects` VALUES ('2', 'att1', 'a', '2025-11-19', '2025-11-29', '1', '2025-11-25 00:00:00', '2025-11-27 00:00:00');
INSERT INTO `projects` VALUES ('3', '3', '3', '2025-11-26', '2025-11-29', '1', '2025-11-26 00:00:00', '2025-11-27 00:00:00');
