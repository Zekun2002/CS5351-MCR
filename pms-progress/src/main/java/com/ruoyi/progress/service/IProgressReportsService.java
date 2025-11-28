package com.ruoyi.progress.service;

import java.util.List;
import com.ruoyi.progress.domain.ProgressReports;

/**
 * 进度报告表Service接口
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
public interface IProgressReportsService 
{
    /**
     * 查询进度报告表
     * 
     * @param reportId 进度报告表主键
     * @return 进度报告表
     */
    public ProgressReports selectProgressReportsByReportId(Long reportId);

    /**
     * 查询进度报告表列表
     * 
     * @param progressReports 进度报告表
     * @return 进度报告表集合
     */
    public List<ProgressReports> selectProgressReportsList(ProgressReports progressReports);

    /**
     * 新增进度报告表
     * 
     * @param progressReports 进度报告表
     * @return 结果
     */
    public int insertProgressReports(ProgressReports progressReports);

    /**
     * 修改进度报告表
     * 
     * @param progressReports 进度报告表
     * @return 结果
     */
    public int updateProgressReports(ProgressReports progressReports);

    /**
     * 批量删除进度报告表
     * 
     * @param reportIds 需要删除的进度报告表主键集合
     * @return 结果
     */
    public int deleteProgressReportsByReportIds(Long[] reportIds);

    /**
     * 删除进度报告表信息
     * 
     * @param reportId 进度报告表主键
     * @return 结果
     */
    public int deleteProgressReportsByReportId(Long reportId);
}
