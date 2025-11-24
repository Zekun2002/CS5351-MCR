package com.ruoyi.progress.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.progress.mapper.ProgressReportsMapper;
import com.ruoyi.progress.domain.ProgressReports;
import com.ruoyi.progress.service.IProgressReportsService;

/**
 * 进度报告表Service业务层处理
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
@Service
public class ProgressReportsServiceImpl implements IProgressReportsService 
{
    @Autowired
    private ProgressReportsMapper progressReportsMapper;

    /**
     * 查询进度报告表
     * 
     * @param reportId 进度报告表主键
     * @return 进度报告表
     */
    @Override
    public ProgressReports selectProgressReportsByReportId(Long reportId)
    {
        return progressReportsMapper.selectProgressReportsByReportId(reportId);
    }

    /**
     * 查询进度报告表列表
     * 
     * @param progressReports 进度报告表
     * @return 进度报告表
     */
    @Override
    public List<ProgressReports> selectProgressReportsList(ProgressReports progressReports)
    {
        return progressReportsMapper.selectProgressReportsList(progressReports);
    }

    /**
     * 新增进度报告表
     * 
     * @param progressReports 进度报告表
     * @return 结果
     */
    @Override
    public int insertProgressReports(ProgressReports progressReports)
    {
        return progressReportsMapper.insertProgressReports(progressReports);
    }

    /**
     * 修改进度报告表
     * 
     * @param progressReports 进度报告表
     * @return 结果
     */
    @Override
    public int updateProgressReports(ProgressReports progressReports)
    {
        return progressReportsMapper.updateProgressReports(progressReports);
    }

    /**
     * 批量删除进度报告表
     * 
     * @param reportIds 需要删除的进度报告表主键
     * @return 结果
     */
    @Override
    public int deleteProgressReportsByReportIds(Long[] reportIds)
    {
        return progressReportsMapper.deleteProgressReportsByReportIds(reportIds);
    }

    /**
     * 删除进度报告表信息
     * 
     * @param reportId 进度报告表主键
     * @return 结果
     */
    @Override
    public int deleteProgressReportsByReportId(Long reportId)
    {
        return progressReportsMapper.deleteProgressReportsByReportId(reportId);
    }
}
