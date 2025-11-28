package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户角色关联对象 user_roles
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
public class UserRoles extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户角色唯一标识 */
    private Long userRoleId;

    /** 用户ID (关联Users表) */
    @Excel(name = "用户ID (关联Users表)")
    private Long userId;

    /** 角色ID (关联Role_Permissions表) */
    @Excel(name = "角色ID (关联Role_Permissions表)")
    private Long roleId;

    public void setUserRoleId(Long userRoleId) 
    {
        this.userRoleId = userRoleId;
    }

    public Long getUserRoleId() 
    {
        return userRoleId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setRoleId(Long roleId) 
    {
        this.roleId = roleId;
    }

    public Long getRoleId() 
    {
        return roleId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userRoleId", getUserRoleId())
            .append("userId", getUserId())
            .append("roleId", getRoleId())
            .toString();
    }
}
