package com.ruoyi.project.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 项目管理对象 projects
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
public class Projects extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 项目id */
    private Long projectId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目描述 */
    @Excel(name = "项目描述")
    private String description;

    /** 项目开始日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "项目开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startDate;

    /** 项目预计结束日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "项目预计结束日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endDate;

    /** 创建者id */
    @Excel(name = "创建者id")
    private Long createdBy;

    /** 项目创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "项目创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 项目更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "项目更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setStartDate(Date startDate) 
    {
        this.startDate = startDate;
    }

    public Date getStartDate() 
    {
        return startDate;
    }

    public void setEndDate(Date endDate) 
    {
        this.endDate = endDate;
    }

    public Date getEndDate() 
    {
        return endDate;
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
            .append("projectId", getProjectId())
            .append("projectName", getProjectName())
            .append("description", getDescription())
            .append("startDate", getStartDate())
            .append("endDate", getEndDate())
            .append("createdBy", getCreatedBy())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
