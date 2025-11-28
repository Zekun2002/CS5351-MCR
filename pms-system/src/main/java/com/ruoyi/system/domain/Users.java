package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 users
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
public class Users extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户唯一标识 */
    private Long userId;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 加密后的密码 */
    @Excel(name = "加密后的密码")
    private String passwordHash;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 用户角色 (PM、Developer等) */
    @Excel(name = "用户角色 (PM、Developer等)")
    private String role;

    /** 账号创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "账号创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 账号更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "账号更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setPasswordHash(String passwordHash) 
    {
        this.passwordHash = passwordHash;
    }

    public String getPasswordHash() 
    {
        return passwordHash;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setRole(String role) 
    {
        this.role = role;
    }

    public String getRole() 
    {
        return role;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("username", getUsername())
            .append("passwordHash", getPasswordHash())
            .append("email", getEmail())
            .append("role", getRole())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
