package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 角色权限对象 role_permissions
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
public class RolePermissions extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 角色唯一标识 */
    private Long roleId;

    /** 角色名称 */
    @Excel(name = "角色名称")
    private String roleName;

    /** 角色权限 (创建项目、编辑任务等) */
    @Excel(name = "角色权限 (创建项目、编辑任务等)")
    private String permission;

    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }

    public void setRoleName(String roleName) 
    {
        this.roleName = roleName;
    }

    public String getRoleName() 
    {
        return roleName;
    }

    public void setPermission(String permission) 
    {
        this.permission = permission;
    }

    public String getPermission() 
    {
        return permission;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("roleName", getRoleName())
            .append("permission", getPermission())
            .toString();
    }
}
