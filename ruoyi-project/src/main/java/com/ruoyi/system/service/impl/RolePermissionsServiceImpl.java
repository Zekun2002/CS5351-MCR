package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.RolePermissionsMapper;
import com.ruoyi.system.domain.RolePermissions;
import com.ruoyi.system.service.IRolePermissionsService;

/**
 * 角色权限Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
@Service
public class RolePermissionsServiceImpl implements IRolePermissionsService 
{
    @Autowired
    private RolePermissionsMapper rolePermissionsMapper;

    /**
     * 查询角色权限
     * 
     * @param roleId 角色权限主键
     * @return 角色权限
     */
    @Override
    public RolePermissions selectRolePermissionsByRoleId(Long roleId)
    {
        return rolePermissionsMapper.selectRolePermissionsByRoleId(roleId);
    }

    /**
     * 查询角色权限列表
     * 
     * @param rolePermissions 角色权限
     * @return 角色权限
     */
    @Override
    public List<RolePermissions> selectRolePermissionsList(RolePermissions rolePermissions)
    {
        return rolePermissionsMapper.selectRolePermissionsList(rolePermissions);
    }

    /**
     * 新增角色权限
     * 
     * @param rolePermissions 角色权限
     * @return 结果
     */
    @Override
    public int insertRolePermissions(RolePermissions rolePermissions)
    {
        return rolePermissionsMapper.insertRolePermissions(rolePermissions);
    }

    /**
     * 修改角色权限
     * 
     * @param rolePermissions 角色权限
     * @return 结果
     */
    @Override
    public int updateRolePermissions(RolePermissions rolePermissions)
    {
        return rolePermissionsMapper.updateRolePermissions(rolePermissions);
    }

    /**
     * 批量删除角色权限
     * 
     * @param roleIds 需要删除的角色权限主键
     * @return 结果
     */
    @Override
    public int deleteRolePermissionsByRoleIds(Long[] roleIds)
    {
        return rolePermissionsMapper.deleteRolePermissionsByRoleIds(roleIds);
    }

    /**
     * 删除角色权限信息
     * 
     * @param roleId 角色权限主键
     * @return 结果
     */
    @Override
    public int deleteRolePermissionsByRoleId(Long roleId)
    {
        return rolePermissionsMapper.deleteRolePermissionsByRoleId(roleId);
    }
}
