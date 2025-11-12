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
import com.ruoyi.progress.domain.ProgressReports;
import com.ruoyi.progress.service.IProgressReportsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 进度报告表Controller
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
@RestController
@RequestMapping("/ruoyi-progress/reports")
public class ProgressReportsController extends BaseController
{
    @Autowired
    private IProgressReportsService progressReportsService;

    /**
     * 查询进度报告表列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:reports:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProgressReports progressReports)
    {
        startPage();
        List<ProgressReports> list = progressReportsService.selectProgressReportsList(progressReports);
        return getDataTable(list);
    }

    /**
     * 导出进度报告表列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:reports:export')")
    @Log(title = "进度报告表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProgressReports progressReports)
    {
        List<ProgressReports> list = progressReportsService.selectProgressReportsList(progressReports);
        ExcelUtil<ProgressReports> util = new ExcelUtil<ProgressReports>(ProgressReports.class);
        util.exportExcel(response, list, "进度报告表数据");
    }

    /**
     * 获取进度报告表详细信息
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:reports:query')")
    @GetMapping(value = "/{reportId}")
    public AjaxResult getInfo(@PathVariable("reportId") Long reportId)
    {
        return success(progressReportsService.selectProgressReportsByReportId(reportId));
    }

    /**
     * 新增进度报告表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:reports:add')")
    @Log(title = "进度报告表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProgressReports progressReports)
    {
        return toAjax(progressReportsService.insertProgressReports(progressReports));
    }

    /**
     * 修改进度报告表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:reports:edit')")
    @Log(title = "进度报告表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProgressReports progressReports)
    {
        return toAjax(progressReportsService.updateProgressReports(progressReports));
    }

    /**
     * 删除进度报告表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-progress:reports:remove')")
    @Log(title = "进度报告表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{reportIds}")
    public AjaxResult remove(@PathVariable Long[] reportIds)
    {
        return toAjax(progressReportsService.deleteProgressReportsByReportIds(reportIds));
    }
}
