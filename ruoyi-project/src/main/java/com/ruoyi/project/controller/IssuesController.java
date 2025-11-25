package com.ruoyi.project.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.project.service.IProjectsService;
import com.ruoyi.project.service.ITasksService;
import com.ruoyi.system.domain.Users;
import com.ruoyi.system.service.IUsersService;
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
import com.ruoyi.project.domain.Issues;
import com.ruoyi.project.service.IIssuesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 问题Controller
 *
 * @author ruoyi
 * @date 2025-11-25
 */
@RestController
@RequestMapping("/ruoyi-project/issues")
public class IssuesController extends BaseController {
    @Autowired
    private IIssuesService issuesService;

    @Autowired
    private IProjectsService projectsService;

    @Autowired
    private ITasksService tasksService;

    @Autowired
    private IUsersService usersService;

    /**
     * 查询问题列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:issues:list')")
    @GetMapping("/list")
    public TableDataInfo list(Issues issues) {
        startPage();
        List<Issues> list = issuesService.selectIssuesList(issues);
        return getDataTable(list);
    }

    /**
     * 查询项目 & 任务 & 用户ID
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:issues:query')")
    @GetMapping("/allIds")
    public AjaxResult allIds() {
        Map<String, List<? extends BaseEntity>> idsMap = new HashMap<String, List<? extends BaseEntity>>() {{
            put("project_ids", projectsService.selectProjectsIdList());
            put("task_ids", tasksService.selectTasksIdList());
            put("user_ids", usersService.selectUsersIdList());
        }};
        return success(idsMap);
    }

    /**
     * 导出问题列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:issues:export')")
    @Log(title = "问题", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Issues issues) {
        List<Issues> list = issuesService.selectIssuesList(issues);
        ExcelUtil<Issues> util = new ExcelUtil<Issues>(Issues.class);
        util.exportExcel(response, list, "问题数据");
    }

    /**
     * 获取问题详细信息
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:issues:query')")
    @GetMapping(value = "/{issueId}")
    public AjaxResult getInfo(@PathVariable("issueId") Long issueId) {
        return success(issuesService.selectIssuesByIssueId(issueId));
    }

    /**
     * 新增问题
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:issues:add')")
    @Log(title = "问题", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Issues issues) {
        return toAjax(issuesService.insertIssues(issues));
    }

    /**
     * 修改问题
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:issues:edit')")
    @Log(title = "问题", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Issues issues) {
        return toAjax(issuesService.updateIssues(issues));
    }

    /**
     * 删除问题
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:issues:remove')")
    @Log(title = "问题", businessType = BusinessType.DELETE)
    @DeleteMapping("/{issueIds}")
    public AjaxResult remove(@PathVariable Long[] issueIds) {
        return toAjax(issuesService.deleteIssuesByIssueIds(issueIds));
    }
}
