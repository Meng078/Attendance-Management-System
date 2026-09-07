-- 注意：该页面对应的前台目录为views/edu文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


-- 主菜单
INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external)
VALUES ('178875146445101', NULL, '请假单', '/edu/eduQingjiadanList', 'edu/EduQingjiadanList', NULL, NULL, 0, NULL, '1', 0.00, 0, NULL, 1, 0, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2026-09-07 11:24:24', NULL, NULL, 0);

-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178875146445102', '178875146445101', '添加请假单', NULL, NULL, 0, NULL, NULL, 2, 'edu:edu_qingjiadan:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-07 11:24:24', NULL, NULL, 0, 0, '1', 0);

-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178875146445103', '178875146445101', '编辑请假单', NULL, NULL, 0, NULL, NULL, 2, 'edu:edu_qingjiadan:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-07 11:24:24', NULL, NULL, 0, 0, '1', 0);

-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178875146445104', '178875146445101', '删除请假单', NULL, NULL, 0, NULL, NULL, 2, 'edu:edu_qingjiadan:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-07 11:24:24', NULL, NULL, 0, 0, '1', 0);

-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178875146445105', '178875146445101', '批量删除请假单', NULL, NULL, 0, NULL, NULL, 2, 'edu:edu_qingjiadan:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-07 11:24:24', NULL, NULL, 0, 0, '1', 0);

-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178875146445106', '178875146445101', '导出excel_请假单', NULL, NULL, 0, NULL, NULL, 2, 'edu:edu_qingjiadan:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-07 11:24:24', NULL, NULL, 0, 0, '1', 0);

-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('178875146445107', '178875146445101', '导入excel_请假单', NULL, NULL, 0, NULL, NULL, 2, 'edu:edu_qingjiadan:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2026-09-07 11:24:24', NULL, NULL, 0, 0, '1', 0);

-- 角色授权（以 admin 角色为例，role_id 可替换）
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178875146445108', 'f6817f48af4fb3af11b9e8bf182f618b', '178875146445101', NULL, '2026-09-07 11:24:24', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178875146445109', 'f6817f48af4fb3af11b9e8bf182f618b', '178875146445102', NULL, '2026-09-07 11:24:24', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178875146445110', 'f6817f48af4fb3af11b9e8bf182f618b', '178875146445103', NULL, '2026-09-07 11:24:24', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178875146445111', 'f6817f48af4fb3af11b9e8bf182f618b', '178875146445104', NULL, '2026-09-07 11:24:24', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178875146445112', 'f6817f48af4fb3af11b9e8bf182f618b', '178875146445105', NULL, '2026-09-07 11:24:24', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178875146445113', 'f6817f48af4fb3af11b9e8bf182f618b', '178875146445106', NULL, '2026-09-07 11:24:24', '127.0.0.1');
INSERT INTO sys_role_permission (id, role_id, permission_id, data_rule_ids, operate_date, operate_ip) VALUES ('178875146445114', 'f6817f48af4fb3af11b9e8bf182f618b', '178875146445107', NULL, '2026-09-07 11:24:24', '127.0.0.1');