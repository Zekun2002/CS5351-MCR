package com.ruoyi.progress.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.progress.domain.Workloads;
import com.ruoyi.progress.service.IWorkloadsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 工作量管理Controller
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
@RestController
@RequestMapping("/ruoyi-progress/workloads")
public class WorkloadsController extends BaseController
{
    @Autowired
    private IWorkloadsService workloadsService;

    /**
     * 查询工作量管理列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:workloads:list')")
    @GetMapping("/list")
    public TableDataInfo list(Workloads workloads)
    {
        startPage();
        List<Workloads> list = workloadsService.selectWorkloadsList(workloads);
        return getDataTable(list);
    }

    /**
     * 导出工作量管理列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:workloads:export')")
    @Log(title = "工作量管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Workloads workloads)
    {
        List<Workloads> list = workloadsService.selectWorkloadsList(workloads);
        ExcelUtil<Workloads> util = new ExcelUtil<Workloads>(Workloads.class);
        util.exportExcel(response, list, "工作量管理数据");
    }

    /**
     * 获取工作量管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:workloads:query')")
    @GetMapping(value = "/{reportId}")
    public AjaxResult getInfo(@PathVariable("reportId") Long reportId)
    {
        return success(workloadsService.selectWorkloadsByReportId(reportId));
    }

    /**
     * 新增工作量管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:workloads:add')")
    @Log(title = "工作量管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Workloads workloads)
    {
        return toAjax(workloadsService.insertWorkloads(workloads));
    }

    /**
     * 修改工作量管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:workloads:edit')")
    @Log(title = "工作量管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Workloads workloads)
    {
        return toAjax(workloadsService.updateWorkloads(workloads));
    }

    /**
     * 删除工作量管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:workloads:remove')")
    @Log(title = "工作量管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reportIds}")
    public AjaxResult remove(@PathVariable Long[] reportIds)
    {
        return toAjax(workloadsService.deleteWorkloadsByReportIds(reportIds));
    }
}
