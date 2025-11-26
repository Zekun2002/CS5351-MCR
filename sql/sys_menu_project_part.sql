
INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2100, '项目管理', 0, 5, 'project', NULL, NULL, '', 1, 0, 'M', '0', '0', NULL, 'tab', 'admin', '2025/11/12 14:51:59', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2101, '进度管理', 0, 6, 'progress', NULL, NULL, '', 1, 0, 'M', '0', '0', NULL, 'nested', 'admin', '2025/11/12 14:53:29', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2102, '项目成员管理', 2100, 1, 'p_members', 'ruoyi-project/p_members/index', NULL, '', 1, 0, 'C', '0', '0', 'ruoyi-project:p_members:list', '#', 'admin', '2025/11/12 15:08:56', '', NULL, '项目成员管理菜单');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2103, '项目成员管理查询', 2102, 1, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:p_members:query', '#', 'admin', '2025/11/12 15:08:56', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2104, '项目成员管理新增', 2102, 2, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:p_members:add', '#', 'admin', '2025/11/12 15:08:56', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2105, '项目成员管理修改', 2102, 3, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:p_members:edit', '#', 'admin', '2025/11/12 15:08:56', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2106, '项目成员管理删除', 2102, 4, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:p_members:remove', '#', 'admin', '2025/11/12 15:08:56', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2107, '项目成员管理导出', 2102, 5, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:p_members:export', '#', 'admin', '2025/11/12 15:08:56', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2108, '项目管理', 2100, 1, 'project', 'ruoyi-project/project/index', NULL, '', 1, 0, 'C', '0', '0', 'ruoyi-project:project:list', '#', 'admin', '2025/11/12 15:09:01', '', NULL, '项目管理菜单');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2109, '项目管理查询', 2108, 1, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:project:query', '#', 'admin', '2025/11/12 15:09:01', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2110, '项目管理新增', 2108, 2, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:project:add', '#', 'admin', '2025/11/12 15:09:01', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2111, '项目管理修改', 2108, 3, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:project:edit', '#', 'admin', '2025/11/12 15:09:01', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2112, '项目管理删除', 2108, 4, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:project:remove', '#', 'admin', '2025/11/12 15:09:01', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2113, '项目管理导出', 2108, 5, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-project:project:export', '#', 'admin', '2025/11/12 15:09:01', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2114, '进度报告表', 2101, 1, 'reports', 'ruoyi-progress/reports/index', NULL, '', 1, 0, 'C', '0', '0', 'ruoyi-progress:reports:list', '#', 'admin', '2025/11/12 15:31:13', '', NULL, '进度报告表菜单');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2115, '进度报告表查询', 2114, 1, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-progress:reports:query', '#', 'admin', '2025/11/12 15:31:13', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2116, '进度报告表新增', 2114, 2, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-progress:reports:add', '#', 'admin', '2025/11/12 15:31:13', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2117, '进度报告表修改', 2114, 3, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-progress:reports:edit', '#', 'admin', '2025/11/12 15:31:13', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2118, '进度报告表删除', 2114, 4, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-progress:reports:remove', '#', 'admin', '2025/11/12 15:31:13', NULL, NULL, '');

INSERT INTO sys_menu
   (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `query`, `route_name`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES
   (2119, '进度报告表导出', 2114, 5, '#', '', NULL, '', 1, 0, 'F', '0', '0', 'ruoyi-progress:reports:export', '#', 'admin', '2025/11/12 15:31:13', NULL, NULL, '');

