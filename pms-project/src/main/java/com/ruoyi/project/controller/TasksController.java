package com.ruoyi.project.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.project.domain.Tasks;
import com.ruoyi.project.service.IProjectsService;
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
 * 任务Controller
 *
 * @author ruoyi
 * @date 2025-11-24
 */
@RestController
@RequestMapping("/ruoyi-project/tasks")
public class TasksController extends BaseController {
    @Autowired
    private ITasksService tasksService;

    @Autowired
    private IProjectsService projectsService;

    @Autowired
    private IUsersService usersService;

    /**
     * 查询任务列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:tasks:list')")
    @GetMapping("/list")
    public TableDataInfo list(Tasks tasks) {
        startPage();
        List<Tasks> list = tasksService.selectTasksList(tasks);
        return getDataTable(list);
    }

    /**
     * 查询项目 & 用户ID
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:tasks:query')")
    @GetMapping("/allIds")
    public AjaxResult allIds() {
        Map<String, List<? extends BaseEntity>> idsMap = new HashMap<String, List<? extends BaseEntity>>() {{
            put("project_ids", projectsService.selectProjectsIdList());
            put("user_ids", usersService.selectUsersIdList());
        }};
        return success(idsMap);
    }

    /**
     * 导出任务列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:tasks:export')")
    @Log(title = "任务", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Tasks tasks) {
        List<Tasks> list = tasksService.selectTasksList(tasks);
        ExcelUtil<Tasks> util = new ExcelUtil<Tasks>(Tasks.class);
        util.exportExcel(response, list, "任务数据");
    }

    /**
     * 获取任务详细信息
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:tasks:query')")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId) {
        return success(tasksService.selectTasksByTaskId(taskId));
    }

    /**
     * 新增任务
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:tasks:add')")
    @Log(title = "任务", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Tasks tasks) {
        return toAjax(tasksService.insertTasks(tasks));
    }

    /**
     * 修改任务
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:tasks:edit')")
    @Log(title = "任务", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Tasks tasks) {
        return toAjax(tasksService.updateTasks(tasks));
    }

    /**
     * 删除任务
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:tasks:remove')")
    @Log(title = "任务", businessType = BusinessType.DELETE)
    @DeleteMapping("/{taskIds}")
    public AjaxResult remove(@PathVariable Long[] taskIds) {
        return toAjax(tasksService.deleteTasksByTaskIds(taskIds));
    }
}
