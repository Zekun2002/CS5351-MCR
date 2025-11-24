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
import com.ruoyi.software.domain.TaskMember;
import com.ruoyi.software.service.ITaskMemberService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 任务成员管理Controller
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
@RestController
@RequestMapping("/software/member")
public class TaskMemberController extends BaseController
{
    @Autowired
    private ITaskMemberService taskMemberService;

    /**
     * 查询任务成员管理列表
     */
    @PreAuthorize("@ss.hasPermi('software:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(TaskMember taskMember)
    {
        startPage();
        List<TaskMember> list = taskMemberService.selectTaskMemberList(taskMember);
        return getDataTable(list);
    }

    /**
     * 导出任务成员管理列表
     */
    @PreAuthorize("@ss.hasPermi('software:member:export')")
    @Log(title = "任务成员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskMember taskMember)
    {
        List<TaskMember> list = taskMemberService.selectTaskMemberList(taskMember);
        ExcelUtil<TaskMember> util = new ExcelUtil<TaskMember>(TaskMember.class);
        util.exportExcel(response, list, "任务成员管理数据");
    }

    /**
     * 获取任务成员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('software:member:query')")
    @GetMapping(value = "/{taskMemberId}")
    public AjaxResult getInfo(@PathVariable("taskMemberId") Long taskMemberId)
    {
        return success(taskMemberService.selectTaskMemberByTaskMemberId(taskMemberId));
    }

    /**
     * 新增任务成员管理
     */
    @PreAuthorize("@ss.hasPermi('software:member:add')")
    @Log(title = "任务成员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskMember taskMember)
    {
        return toAjax(taskMemberService.insertTaskMember(taskMember));
    }

    /**
     * 修改任务成员管理
     */
    @PreAuthorize("@ss.hasPermi('software:member:edit')")
    @Log(title = "任务成员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskMember taskMember)
    {
        return toAjax(taskMemberService.updateTaskMember(taskMember));
    }

    /**
     * 删除任务成员管理
     */
    @PreAuthorize("@ss.hasPermi('software:member:remove')")
    @Log(title = "任务成员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{taskMemberIds}")
    public AjaxResult remove(@PathVariable Long[] taskMemberIds)
    {
        return toAjax(taskMemberService.deleteTaskMemberByTaskMemberIds(taskMemberIds));
    }
}
