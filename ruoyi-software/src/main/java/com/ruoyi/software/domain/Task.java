package com.ruoyi.software.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 任务管理对象 tasks
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
public class Task extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务唯一标识 */
    private Long taskId;

    /** 任务所属项目ID（关联Projects表） */
    @Excel(name = "任务所属项目ID", readConverterExp = "关=联Projects表")
    private Long projectId;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String description;

    /** 任务优先级（高、中、低） */
    @Excel(name = "任务优先级", readConverterExp = "高=、中、低")
    private String priority;

    /** 任务状态（待办、进行中、已完成） */
    @Excel(name = "任务状态", readConverterExp = "待=办、进行中、已完成")
    private String status;

    /** 创建任务的用户ID（关联Users表）    */
    @Excel(name = "创建任务的用户ID", readConverterExp = "关=联Users表")
    private Long createdBy;

    /** 任务分配给的用户ID（关联Users表） */
    @Excel(name = "任务分配给的用户ID", readConverterExp = "关=联Users表")
    private Long assignedTo;

    /** 任务创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 任务更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setPriority(String priority) 
    {
        this.priority = priority;
    }

    public String getPriority() 
    {
        return priority;
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

    public void setAssignedTo(Long assignedTo) 
    {
        this.assignedTo = assignedTo;
    }

    public Long getAssignedTo() 
    {
        return assignedTo;
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
            .append("taskId", getTaskId())
            .append("projectId", getProjectId())
            .append("taskName", getTaskName())
            .append("description", getDescription())
            .append("priority", getPriority())
            .append("status", getStatus())
            .append("createdBy", getCreatedBy())
            .append("assignedTo", getAssignedTo())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
