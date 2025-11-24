package com.ruoyi.progress.service;

import java.util.List;
import com.ruoyi.progress.domain.Workloads;

/**
 * 工作量管理Service接口
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
public interface IWorkloadsService 
{
    /**
     * 查询工作量管理
     * 
     * @param reportId 工作量管理主键
     * @return 工作量管理
     */
    public Workloads selectWorkloadsByReportId(Long reportId);

    /**
     * 查询工作量管理列表
     * 
     * @param workloads 工作量管理
     * @return 工作量管理集合
     */
    public List<Workloads> selectWorkloadsList(Workloads workloads);

    /**
     * 新增工作量管理
     * 
     * @param workloads 工作量管理
     * @return 结果
     */
    public int insertWorkloads(Workloads workloads);

    /**
     * 修改工作量管理
     * 
     * @param workloads 工作量管理
     * @return 结果
     */
    public int updateWorkloads(Workloads workloads);

    /**
     * 批量删除工作量管理
     * 
     * @param reportIds 需要删除的工作量管理主键集合
     * @return 结果
     */
    public int deleteWorkloadsByReportIds(Long[] reportIds);

    /**
     * 删除工作量管理信息
     * 
     * @param reportId 工作量管理主键
     * @return 结果
     */
    public int deleteWorkloadsByReportId(Long reportId);
}
