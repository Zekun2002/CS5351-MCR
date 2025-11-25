/*
MySQL Data Transfer
Source Host: localhost
Source Database: ry-new1
Target Host: localhost
Target Database: ry-new1
Date: 2025/11/25 0:42:03
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for progress_reports
-- ----------------------------
DROP TABLE IF EXISTS `progress_reports`;
CREATE TABLE `progress_reports` (
  `report_id` int NOT NULL AUTO_INCREMENT COMMENT '进度报告id',
  `project_id` int DEFAULT NULL COMMENT '项目id',
  `report_date` date DEFAULT NULL COMMENT '报告日期',
  `progress` decimal(5,2) unsigned zerofill DEFAULT NULL COMMENT '项目进度',
  `expected_end_date` date DEFAULT NULL COMMENT '预期完成日期',
  `actual_end_date` date DEFAULT NULL COMMENT '实际完成日期',
  PRIMARY KEY (`report_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `progress_reports` VALUES ('1', '1', '2025-11-28', '001.00', '2025-11-27', '2025-11-28');
INSERT INTO `progress_reports` VALUES ('2', '2', '2025-11-28', '005.00', '2025-11-29', '2025-11-29');
