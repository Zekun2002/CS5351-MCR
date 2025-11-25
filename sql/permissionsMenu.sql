-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('角色权限', '3', '1', 'permissions', 'system/permissions/index', 1, 0, 'C', '0', '0', 'system:permissions:list', '#', 'admin', sysdate(), '', null, '角色权限菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('角色权限查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:permissions:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('角色权限新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:permissions:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('角色权限修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:permissions:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('角色权限删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:permissions:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('角色权限导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:permissions:export',       '#', 'admin', sysdate(), '', null, '');