package com.ruoyi.project.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.domain.TaskMembers;
import com.ruoyi.project.service.ITaskMembersService;
import com.ruoyi.project.service.ITasksService;
import com.ruoyi.system.service.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 任务成员Controller
 *
 * @author ruoyi
 * @date 2025-11-24
 */
@RestController
@RequestMapping("/ruoyi-project/members")
public class TaskMembersController extends BaseController {
    @Autowired
    private ITaskMembersService taskMembersService;

    @Autowired
    private ITasksService tasksService;

    @Autowired
    private IUsersService usersService;

    /**
     * 查询任务成员列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:list')")
    @GetMapping("/list")
    public TableDataInfo list(TaskMembers taskMembers) {
        startPage();
        List<TaskMembers> list = taskMembersService.selectTaskMembersList(taskMembers);
        return getDataTable(list);
    }

    /**
     * 查询任务 & 用户ID
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:query')")
    @GetMapping("/allIds")
    public AjaxResult allIds() {
        Map<String, List<? extends BaseEntity>> idsMap = new HashMap<String, List<? extends BaseEntity>>() {{
            put("project_ids", tasksService.selectTasksIdList());
            put("user_ids", usersService.selectUsersIdList());
        }};
        return success(idsMap);
    }

    /**
     * 导出任务成员列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:export')")
    @Log(title = "任务成员", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskMembers taskMembers) {
        List<TaskMembers> list = taskMembersService.selectTaskMembersList(taskMembers);
        ExcelUtil<TaskMembers> util = new ExcelUtil<TaskMembers>(TaskMembers.class);
        util.exportExcel(response, list, "任务成员数据");
    }

    /**
     * 获取任务成员详细信息
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:query')")
    @GetMapping(value = "/{taskMemberId}")
    public AjaxResult getInfo(@PathVariable("taskMemberId") Long taskMemberId) {
        return success(taskMembersService.selectTaskMembersByTaskMemberId(taskMemberId));
    }

    /**
     * 新增任务成员
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:add')")
    @Log(title = "任务成员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskMembers taskMembers) {
        return toAjax(taskMembersService.insertTaskMembers(taskMembers));
    }

    /**
     * 修改任务成员
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:edit')")
    @Log(title = "任务成员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskMembers taskMembers) {
        return toAjax(taskMembersService.updateTaskMembers(taskMembers));
    }

    /**
     * 删除任务成员
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:members:remove')")
    @Log(title = "任务成员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskMemberIds}")
    public AjaxResult remove(@PathVariable Long[] taskMemberIds) {
        return toAjax(taskMembersService.deleteTaskMembersByTaskMemberIds(taskMemberIds));
    }
}
