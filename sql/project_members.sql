/*
MySQL Data Transfer
Source Host: localhost
Source Database: ry-new1
Target Host: localhost
Target Database: ry-new1
Date: 2025/11/25 0:42:09
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for project_members
-- ----------------------------
DROP TABLE IF EXISTS `project_members`;
CREATE TABLE `project_members` (
  `member_id` int NOT NULL AUTO_INCREMENT COMMENT '成员id',
  `project_id` int DEFAULT NULL COMMENT '项目id',
  `user_id` int DEFAULT NULL COMMENT '用户id',
  `role` varchar(50) DEFAULT NULL COMMENT '用户角色',
  `joined_at` datetime DEFAULT NULL COMMENT '用户加入项目时间',
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `project_members` VALUES ('1', '1', '1', 'PA', '2025-11-19 00:00:00');
INSERT INTO `project_members` VALUES ('2', '1', '6', 'PA', '2025-11-29 00:00:00');
INSERT INTO `project_members` VALUES ('3', '2', '2', 'user', '2025-11-19 00:00:00');
