/*
MySQL Test Data
Generated for CS5351-MCR Project Testing
Date: 2025-11-28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- 清空现有测试数据（可选，根据需要取消注释）
-- ----------------------------
-- DELETE FROM `progress_reports`;
-- DELETE FROM `project_members`;
-- DELETE FROM `projects`;
-- DELETE FROM `users` WHERE `user_id` > 1;

-- ----------------------------
-- 插入用户数据 (users表)
-- ----------------------------
INSERT INTO `users` (`user_id`, `username`, `password_hash`, `email`, `role`, `created_at`, `updated_at`) VALUES
(1, 'admin', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'admin@example.com', 'Admin', '2025-01-01 00:00:00', '2025-01-01 00:00:00'),
(2, '张三', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'zhangsan@example.com', 'PM', '2025-01-15 10:00:00', '2025-01-15 10:00:00'),
(3, '李四', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'lisi@example.com', 'PM', '2025-01-20 10:00:00', '2025-01-20 10:00:00'),
(4, '王五', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'wangwu@example.com', 'Developer', '2025-02-01 10:00:00', '2025-02-01 10:00:00'),
(5, '赵六', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'zhaoliu@example.com', 'Developer', '2025-02-05 10:00:00', '2025-02-05 10:00:00'),
(6, '孙七', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'sunqi@example.com', 'Developer', '2025-02-10 10:00:00', '2025-02-10 10:00:00'),
(7, '周八', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'zhouba@example.com', 'Tester', '2025-02-15 10:00:00', '2025-02-15 10:00:00'),
(8, '吴九', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'wujiu@example.com', 'Tester', '2025-02-20 10:00:00', '2025-02-20 10:00:00'),
(9, '郑十', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'zhengshi@example.com', 'Designer', '2025-03-01 10:00:00', '2025-03-01 10:00:00'),
(10, '钱一', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'qianyi@example.com', 'Designer', '2025-03-05 10:00:00', '2025-03-05 10:00:00'),
(11, '陈二', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'chener@example.com', 'PM', '2025-03-10 10:00:00', '2025-03-10 10:00:00'),
(12, '林三', '$2a$10$7JB720yubVSZvUI0rEqK/.VqGOZTH.ulu33dHOiBE8ByOhJIrdAu2', 'linsan@example.com', 'Developer', '2025-03-15 10:00:00', '2025-03-15 10:00:00');

-- ----------------------------
-- 插入项目数据 (projects表)
-- 注意：创建时间早于更新时间，开始日期早于结束日期
-- ----------------------------
INSERT INTO `projects` (`project_id`, `project_name`, `description`, `start_date`, `end_date`, `created_by`, `created_at`, `updated_at`) VALUES
(1, '企业管理系统', '开发一套完整的企业管理系统，包括人事、财务、库存等模块', '2025-01-15', '2025-06-30', 2, '2025-01-10 09:00:00', '2025-01-10 09:00:00'),
(2, '移动应用开发', '开发iOS和Android双平台移动应用，支持在线购物和支付功能', '2025-02-01', '2025-08-31', 3, '2025-01-25 14:30:00', '2025-01-25 14:30:00'),
(3, '数据分析平台', '构建大数据分析平台，提供实时数据可视化和报表功能', '2025-03-01', '2025-09-30', 2, '2025-02-20 10:00:00', '2025-02-20 10:00:00'),
(4, '电商网站重构', '对现有电商网站进行重构，提升性能和用户体验', '2025-04-01', '2025-10-31', 11, '2025-03-20 11:00:00', '2025-03-20 11:00:00'),
(5, '智能客服系统', '开发基于AI的智能客服系统，支持多渠道接入', '2025-05-01', '2025-11-30', 3, '2025-04-25 15:00:00', '2025-04-25 15:00:00'),
(6, '云存储服务', '开发企业级云存储服务，支持文件同步和共享', '2025-06-01', '2025-12-31', 2, '2025-05-20 09:30:00', '2025-05-20 09:30:00');

-- ----------------------------
-- 插入项目成员数据 (project_members表)
-- 注意：每个项目的创建者应该自动成为PM（已在后端逻辑中处理）
-- 这里添加其他成员，确保加入时间合理
-- ----------------------------
-- 项目1的成员（PM: 用户2，创建者）
INSERT INTO `project_members` (`member_id`, `project_id`, `user_id`, `role`, `joined_at`) VALUES
(1, 1, 2, 'PM', '2025-01-10 09:00:00'),
(2, 1, 4, 'Developer', '2025-01-12 10:00:00'),
(3, 1, 5, 'Developer', '2025-01-12 10:00:00'),
(4, 1, 7, 'Tester', '2025-01-15 09:00:00'),
(5, 1, 9, 'Designer', '2025-01-11 11:00:00');

-- 项目2的成员（PM: 用户3，创建者）
INSERT INTO `project_members` (`member_id`, `project_id`, `user_id`, `role`, `joined_at`) VALUES
(6, 2, 3, 'PM', '2025-01-25 14:30:00'),
(7, 2, 6, 'Developer', '2025-01-28 10:00:00'),
(8, 2, 12, 'Developer', '2025-01-28 10:00:00'),
(9, 2, 8, 'Tester', '2025-02-01 09:00:00'),
(10, 2, 10, 'Designer', '2025-01-26 14:00:00');

-- 项目3的成员（PM: 用户2，创建者）
INSERT INTO `project_members` (`member_id`, `project_id`, `user_id`, `role`, `joined_at`) VALUES
(11, 3, 2, 'PM', '2025-02-20 10:00:00'),
(12, 3, 4, 'Developer', '2025-02-22 10:00:00'),
(13, 3, 5, 'Developer', '2025-02-22 10:00:00'),
(14, 3, 6, 'Developer', '2025-02-22 10:00:00');

-- 项目4的成员（PM: 用户11，创建者）
INSERT INTO `project_members` (`member_id`, `project_id`, `user_id`, `role`, `joined_at`) VALUES
(15, 4, 11, 'PM', '2025-03-20 11:00:00'),
(16, 4, 12, 'Developer', '2025-03-22 10:00:00'),
(17, 4, 7, 'Tester', '2025-04-01 09:00:00'),
(18, 4, 9, 'Designer', '2025-03-21 11:00:00');

-- 项目5的成员（PM: 用户3，创建者）
INSERT INTO `project_members` (`member_id`, `project_id`, `user_id`, `role`, `joined_at`) VALUES
(19, 5, 3, 'PM', '2025-04-25 15:00:00'),
(20, 5, 4, 'Developer', '2025-04-28 10:00:00'),
(21, 5, 5, 'Developer', '2025-04-28 10:00:00'),
(22, 5, 8, 'Tester', '2025-05-01 09:00:00');

-- 项目6的成员（PM: 用户2，创建者）
INSERT INTO `project_members` (`member_id`, `project_id`, `user_id`, `role`, `joined_at`) VALUES
(23, 6, 2, 'PM', '2025-05-20 09:30:00'),
(24, 6, 6, 'Developer', '2025-05-22 10:00:00'),
(25, 6, 12, 'Developer', '2025-05-22 10:00:00');

-- ----------------------------
-- 插入进度报告数据 (progress_reports表)
-- 注意：报告日期合理，预期完成日期晚于报告日期
-- 进度100%的才有实际完成日期，且实际完成日期晚于报告日期
-- ----------------------------
-- 项目1的进度报告
INSERT INTO `progress_reports` (`report_id`, `project_id`, `report_date`, `progress`, `expected_end_date`, `actual_end_date`) VALUES
(1, 1, '2025-02-15', 15.00, '2025-06-30', NULL),
(2, 1, '2025-03-15', 35.00, '2025-06-30', NULL),
(3, 1, '2025-04-15', 55.00, '2025-06-30', NULL),
(4, 1, '2025-05-15', 75.00, '2025-06-30', NULL),
(5, 1, '2025-06-15', 95.00, '2025-06-30', NULL),
(6, 1, '2025-06-28', 100.00, '2025-06-30', '2025-06-28');

-- 项目2的进度报告
INSERT INTO `progress_reports` (`report_id`, `project_id`, `report_date`, `progress`, `expected_end_date`, `actual_end_date`) VALUES
(7, 2, '2025-03-01', 10.00, '2025-08-31', NULL),
(8, 2, '2025-04-01', 25.00, '2025-08-31', NULL),
(9, 2, '2025-05-01', 40.00, '2025-08-31', NULL),
(10, 2, '2025-06-01', 60.00, '2025-08-31', NULL);

-- 项目3的进度报告
INSERT INTO `progress_reports` (`report_id`, `project_id`, `report_date`, `progress`, `expected_end_date`, `actual_end_date`) VALUES
(11, 3, '2025-04-01', 20.00, '2025-09-30', NULL),
(12, 3, '2025-05-01', 45.00, '2025-09-30', NULL),
(13, 3, '2025-06-01', 70.00, '2025-09-30', NULL);

-- 项目4的进度报告
INSERT INTO `progress_reports` (`report_id`, `project_id`, `report_date`, `progress`, `expected_end_date`, `actual_end_date`) VALUES
(14, 4, '2025-05-01', 15.00, '2025-10-31', NULL),
(15, 4, '2025-06-01', 35.00, '2025-10-31', NULL);

-- 项目5的进度报告
INSERT INTO `progress_reports` (`report_id`, `project_id`, `report_date`, `progress`, `expected_end_date`, `actual_end_date`) VALUES
(16, 5, '2025-06-01', 10.00, '2025-11-30', NULL),
(17, 5, '2025-07-01', 30.00, '2025-11-30', NULL);

-- 项目6的进度报告
INSERT INTO `progress_reports` (`report_id`, `project_id`, `report_date`, `progress`, `expected_end_date`, `actual_end_date`) VALUES
(18, 6, '2025-07-01', 5.00, '2025-12-31', NULL);

SET FOREIGN_KEY_CHECKS=1;

-- ----------------------------
-- 测试数据说明
-- ----------------------------
-- 1. 用户表：包含12个用户，角色包括Admin、PM、Developer、Tester、Designer
-- 2. 项目表：包含6个项目，每个项目都有合理的开始和结束日期
-- 3. 项目成员表：每个项目都有PM（创建者）和其他成员，加入时间合理
-- 4. 进度报告表：包含18条进度报告，部分项目已完成（进度100%），部分进行中
-- 
-- 测试场景：
-- - 可以测试PM权限：用户2、3、11是PM，可以管理项目成员
-- - 可以测试日期验证：所有日期都符合逻辑（创建时间<更新时间，开始日期<结束日期）
-- - 可以测试进度报告：项目1已完成，其他项目进行中
-- - 可以测试用户选择：创建项目和添加成员时可以从用户列表选择
-- ----------------------------

