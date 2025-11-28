-- 删除生成器菜单与权限标识
DELETE FROM sys_menu WHERE perms LIKE 'tool:gen:%' OR path LIKE '%/tool/gen%';
-- 删除生成器元数据表
DROP TABLE IF EXISTS gen_table;
DROP TABLE IF EXISTS gen_table_column;
