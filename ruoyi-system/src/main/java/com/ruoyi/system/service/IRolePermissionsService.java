package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.RolePermissions;

/**
 * 角色权限Service接口
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
public interface IRolePermissionsService 
{
    /**
     * 查询角色权限
     * 
     * @param roleId 角色权限主键
     * @return 角色权限
     */
    public RolePermissions selectRolePermissionsByRoleId(Long roleId);

    /**
     * 查询角色权限列表
     * 
     * @param rolePermissions 角色权限
     * @return 角色权限集合
     */
    public List<RolePermissions> selectRolePermissionsList(RolePermissions rolePermissions);

    /**
     * 新增角色权限
     * 
     * @param rolePermissions 角色权限
     * @return 结果
     */
    public int insertRolePermissions(RolePermissions rolePermissions);

    /**
     * 修改角色权限
     * 
     * @param rolePermissions 角色权限
     * @return 结果
     */
    public int updateRolePermissions(RolePermissions rolePermissions);

    /**
     * 批量删除角色权限
     * 
     * @param roleIds 需要删除的角色权限主键集合
     * @return 结果
     */
    public int deleteRolePermissionsByRoleIds(Long[] roleIds);

    /**
     * 删除角色权限信息
     * 
     * @param roleId 角色权限主键
     * @return 结果
     */
    public int deleteRolePermissionsByRoleId(Long roleId);
}
