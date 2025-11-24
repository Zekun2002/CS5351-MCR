package com.ruoyi.software.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 问题管理对象 issues
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
public class Issue extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 问题唯一标识 */
    private Long issueId;

    /** 问题所属项目ID（关联Projects表）  */
    @Excel(name = "问题所属项目ID", readConverterExp = "关=联Projects表")
    private Long projectId;

    /** 问题所属任务ID（关联Tasks表） */
    @Excel(name = "问题所属任务ID", readConverterExp = "关=联Tasks表")
    private Long taskId;

    /** 问题类型（Bug、技术债务） */
    @Excel(name = "问题类型", readConverterExp = "B=ug、技术债务")
    private String issueType;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String description;

    /** 问题状态（待办、进行中、已解决）  */
    @Excel(name = "问题状态", readConverterExp = "待=办、进行中、已解决")
    private String status;

    /** 创建问题的用户ID（关联Users表） */
    @Excel(name = "创建问题的用户ID", readConverterExp = "关=联Users表")
    private Long createdBy;

    /** 问题创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "问题创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 问题更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "问题更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setIssueId(Long issueId) 
    {
        this.issueId = issueId;
    }

    public Long getIssueId() 
    {
        return issueId;
    }

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setIssueType(String issueType) 
    {
        this.issueType = issueType;
    }

    public String getIssueType() 
    {
        return issueType;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public void setCreatedBy(Long createdBy) 
    {
        this.createdBy = createdBy;
    }

    public Long getCreatedBy() 
    {
        return createdBy;
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
            .append("issueId", getIssueId())
            .append("projectId", getProjectId())
            .append("taskId", getTaskId())
            .append("issueType", getIssueType())
            .append("description", getDescription())
            .append("status", getStatus())
            .append("createdBy", getCreatedBy())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
