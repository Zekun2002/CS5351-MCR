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
import com.ruoyi.project.domain.ProjectMembers;
import com.ruoyi.project.service.IProjectMembersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 项目成员管理Controller
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
@RestController
@RequestMapping("/ruoyi-project/p_members")
public class ProjectMembersController extends BaseController
{
    @Autowired
    private IProjectMembersService projectMembersService;

    /**
     * 查询项目成员管理列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:p_members:list')")
    @GetMapping("/list")
    public TableDataInfo list(ProjectMembers projectMembers)
    {
        startPage();
        List<ProjectMembers> list = projectMembersService.selectProjectMembersList(projectMembers);
        return getDataTable(list);
    }

    /**
     * 导出项目成员管理列表
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:p_members:export')")
    @Log(title = "项目成员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProjectMembers projectMembers)
    {
        List<ProjectMembers> list = projectMembersService.selectProjectMembersList(projectMembers);
        ExcelUtil<ProjectMembers> util = new ExcelUtil<ProjectMembers>(ProjectMembers.class);
        util.exportExcel(response, list, "项目成员管理数据");
    }

    /**
     * 获取项目成员管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:p_members:query')")
    @GetMapping(value = "/{memberId}")
    public AjaxResult getInfo(@PathVariable("memberId") Long memberId)
    {
        return success(projectMembersService.selectProjectMembersByMemberId(memberId));
    }

    /**
     * 新增项目成员管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:p_members:add')")
    @Log(title = "项目成员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProjectMembers projectMembers)
    {
        return toAjax(projectMembersService.insertProjectMembers(projectMembers));
    }

    /**
     * 修改项目成员管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:p_members:edit')")
    @Log(title = "项目成员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProjectMembers projectMembers)
    {
        return toAjax(projectMembersService.updateProjectMembers(projectMembers));
    }

    /**
     * 删除项目成员管理
     */
    @PreAuthorize("@ss.hasPermi('ruoyi-project:p_members:remove')")
    @Log(title = "项目成员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{memberIds}")
    public AjaxResult remove(@PathVariable Long[] memberIds)
    {
        return toAjax(projectMembersService.deleteProjectMembersByMemberIds(memberIds));
    }
}
