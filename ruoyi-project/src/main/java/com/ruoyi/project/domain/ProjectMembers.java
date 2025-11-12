package com.ruoyi.project.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目成员管理对象 project_members
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
public class ProjectMembers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 成员id */
    private Long memberId;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 用户角色 */
    @Excel(name = "用户角色")
    private String role;

    /** 用户加入项目时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "用户加入项目时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date joinedAt;

    public void setMemberId(Long memberId) 
    {
        this.memberId = memberId;
    }

    public Long getMemberId() 
    {
        return memberId;
    }

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }

    public void setRole(String role) 
    {
        this.role = role;
    }

    public String getRole() 
    {
        return role;
    }

    public void setJoinedAt(Date joinedAt) 
    {
        this.joinedAt = joinedAt;
    }

    public Date getJoinedAt() 
    {
        return joinedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("memberId", getMemberId())
            .append("projectId", getProjectId())
            .append("userId", getUserId())
            .append("role", getRole())
            .append("joinedAt", getJoinedAt())
            .toString();
    }
}
