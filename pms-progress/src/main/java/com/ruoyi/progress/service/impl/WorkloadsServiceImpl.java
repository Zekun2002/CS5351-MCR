package com.ruoyi.progress.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.progress.mapper.WorkloadsMapper;
import com.ruoyi.progress.domain.Workloads;
import com.ruoyi.progress.service.IWorkloadsService;

/**
 * 工作量管理Service业务层处理
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
@Service
public class WorkloadsServiceImpl implements IWorkloadsService 
{
    @Autowired
    private WorkloadsMapper workloadsMapper;

    /**
     * 查询工作量管理
     * 
     * @param reportId 工作量管理主键
     * @return 工作量管理
     */
    @Override
    public Workloads selectWorkloadsByReportId(Long reportId)
    {
        return workloadsMapper.selectWorkloadsByReportId(reportId);
    }

    /**
     * 查询工作量管理列表
     * 
     * @param workloads 工作量管理
     * @return 工作量管理
     */
    @Override
    public List<Workloads> selectWorkloadsList(Workloads workloads)
    {
        return workloadsMapper.selectWorkloadsList(workloads);
    }

    /**
     * 新增工作量管理
     * 
     * @param workloads 工作量管理
     * @return 结果
     */
    @Override
    public int insertWorkloads(Workloads workloads)
    {
        return workloadsMapper.insertWorkloads(workloads);
    }

    /**
     * 修改工作量管理
     * 
     * @param workloads 工作量管理
     * @return 结果
     */
    @Override
    public int updateWorkloads(Workloads workloads)
    {
        return workloadsMapper.updateWorkloads(workloads);
    }

    /**
     * 批量删除工作量管理
     * 
     * @param reportIds 需要删除的工作量管理主键
     * @return 结果
     */
    @Override
    public int deleteWorkloadsByReportIds(Long[] reportIds)
    {
        return workloadsMapper.deleteWorkloadsByReportIds(reportIds);
    }

    /**
     * 删除工作量管理信息
     * 
     * @param reportId 工作量管理主键
     * @return 结果
     */
    @Override
    public int deleteWorkloadsByReportId(Long reportId)
    {
        return workloadsMapper.deleteWorkloadsByReportId(reportId);
    }
}
