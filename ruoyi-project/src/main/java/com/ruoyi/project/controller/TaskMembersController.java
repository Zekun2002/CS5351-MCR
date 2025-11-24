package com.ruoyi.project.controller;

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
import com.ruoyi.project.domain.TaskMembers;
import com.ruoyi.project.service.ITaskMembersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务成员Controller
 * 
 * @author ruoyi
 * @date 2025-11-24
 */
@RestController
@RequestMapping("/ruoyi-project/members")
public class TaskMembersController extends BaseController
{
    @Autowired
    private ITaskMembersService taskMembersService;

    /**
     * 查询任务成员列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:list')")
    @GetMapping("/list")
    public TableDataInfo list(TaskMembers taskMembers)
    {
        startPage();
        List<TaskMembers> list = taskMembersService.selectTaskMembersList(taskMembers);
        return getDataTable(list);
    }

    /**
     * 导出任务成员列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:export')")
    @Log(title = "任务成员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskMembers taskMembers)
    {
        List<TaskMembers> list = taskMembersService.selectTaskMembersList(taskMembers);
        ExcelUtil<TaskMembers> util = new ExcelUtil<TaskMembers>(TaskMembers.class);
        util.exportExcel(response, list, "任务成员数据");
    }

    /**
     * 获取任务成员详细信息
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:query')")
    @GetMapping(value = "/{taskMemberId}")
    public AjaxResult getInfo(@PathVariable("taskMemberId") Long taskMemberId)
    {
        return success(taskMembersService.selectTaskMembersByTaskMemberId(taskMemberId));
    }

    /**
     * 新增任务成员
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:add')")
    @Log(title = "任务成员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskMembers taskMembers)
    {
        return toAjax(taskMembersService.insertTaskMembers(taskMembers));
    }

    /**
     * 修改任务成员
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:edit')")
    @Log(title = "任务成员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskMembers taskMembers)
    {
        return toAjax(taskMembersService.updateTaskMembers(taskMembers));
    }

    /**
     * 删除任务成员
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:remove')")
    @Log(title = "任务成员", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskMemberIds}")
    public AjaxResult remove(@PathVariable Long[] taskMemberIds)
    {
        return toAjax(taskMembersService.deleteTaskMembersByTaskMemberIds(taskMemberIds));
    }
}
