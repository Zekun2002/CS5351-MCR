package com.ruoyi.software.controller;

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
import com.ruoyi.software.domain.Issue;
import com.ruoyi.software.service.IIssueService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 问题管理Controller
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
@RestController
@RequestMapping("/software/issue")
public class IssueController extends BaseController
{
    @Autowired
    private IIssueService issueService;

    /**
     * 查询问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('software:issue:list')")
    @GetMapping("/list")
    public TableDataInfo list(Issue issue)
    {
        startPage();
        List<Issue> list = issueService.selectIssueList(issue);
        return getDataTable(list);
    }

    /**
     * 导出问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('software:issue:export')")
    @Log(title = "问题管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Issue issue)
    {
        List<Issue> list = issueService.selectIssueList(issue);
        ExcelUtil<Issue> util = new ExcelUtil<Issue>(Issue.class);
        util.exportExcel(response, list, "问题管理数据");
    }

    /**
     * 获取问题管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('software:issue:query')")
    @GetMapping(value = "/{issueId}")
    public AjaxResult getInfo(@PathVariable("issueId") Long issueId)
    {
        return success(issueService.selectIssueByIssueId(issueId));
    }

    /**
     * 新增问题管理
     */
    @PreAuthorize("@ss.hasPermi('software:issue:add')")
    @Log(title = "问题管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Issue issue)
    {
        return toAjax(issueService.insertIssue(issue));
    }

    /**
     * 修改问题管理
     */
    @PreAuthorize("@ss.hasPermi('software:issue:edit')")
    @Log(title = "问题管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Issue issue)
    {
        return toAjax(issueService.updateIssue(issue));
    }

    /**
     * 删除问题管理
     */
    @PreAuthorize("@ss.hasPermi('software:issue:remove')")
    @Log(title = "问题管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{issueIds}")
    public AjaxResult remove(@PathVariable Long[] issueIds)
    {
        return toAjax(issueService.deleteIssueByIssueIds(issueIds));
    }
}
