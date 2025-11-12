package com.ruoyi.progress.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 进度报告表对象 progress_reports
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
public class ProgressReports extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 进度报告id */
    private Long reportId;

    /** 项目id */
    @Excel(name = "项目id")
    private Long projectId;

    /** 报告日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "报告日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reportDate;

    /** 项目进度 */
    @Excel(name = "项目进度")
    private BigDecimal progress;

    /** 预期完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预期完成日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date expectedEndDate;

    /** 实际完成日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实际完成日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date actualEndDate;

    public void setReportId(Long reportId) 
    {
        this.reportId = reportId;
    }

    public Long getReportId() 
    {
        return reportId;
    }

    public void setProjectId(Long projectId) 
    {
        this.projectId = projectId;
    }

    public Long getProjectId() 
    {
        return projectId;
    }

    public void setReportDate(Date reportDate) 
    {
        this.reportDate = reportDate;
    }

    public Date getReportDate() 
    {
        return reportDate;
    }

    public void setProgress(BigDecimal progress) 
    {
        this.progress = progress;
    }

    public BigDecimal getProgress() 
    {
        return progress;
    }

    public void setExpectedEndDate(Date expectedEndDate) 
    {
        this.expectedEndDate = expectedEndDate;
    }

    public Date getExpectedEndDate() 
    {
        return expectedEndDate;
    }

    public void setActualEndDate(Date actualEndDate) 
    {
        this.actualEndDate = actualEndDate;
    }

    public Date getActualEndDate() 
    {
        return actualEndDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("reportId", getReportId())
            .append("projectId", getProjectId())
            .append("reportDate", getReportDate())
            .append("progress", getProgress())
            .append("expectedEndDate", getExpectedEndDate())
            .append("actualEndDate", getActualEndDate())
            .toString();
    }
}
