package com.ruoyi.system.controller;

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
import com.ruoyi.system.domain.UserRoles;
import com.ruoyi.system.service.IUserRolesService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户角色关联Controller
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
@RestController
@RequestMapping("/system/roles")
public class UserRolesController extends BaseController
{
    @Autowired
    private IUserRolesService userRolesService;

    /**
     * 查询用户角色关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:roles:list')")
    @GetMapping("/list")
    public TableDataInfo list(UserRoles userRoles)
    {
        startPage();
        List<UserRoles> list = userRolesService.selectUserRolesList(userRoles);
        return getDataTable(list);
    }

    /**
     * 导出用户角色关联列表
     */
    @PreAuthorize("@ss.hasPermi('system:roles:export')")
    @Log(title = "用户角色关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserRoles userRoles)
    {
        List<UserRoles> list = userRolesService.selectUserRolesList(userRoles);
        ExcelUtil<UserRoles> util = new ExcelUtil<UserRoles>(UserRoles.class);
        util.exportExcel(response, list, "用户角色关联数据");
    }

    /**
     * 获取用户角色关联详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:roles:query')")
    @GetMapping(value = "/{userRoleId}")
    public AjaxResult getInfo(@PathVariable("userRoleId") Long userRoleId)
    {
        return success(userRolesService.selectUserRolesByUserRoleId(userRoleId));
    }

    /**
     * 新增用户角色关联
     */
    @PreAuthorize("@ss.hasPermi('system:roles:add')")
    @Log(title = "用户角色关联", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserRoles userRoles)
    {
        return toAjax(userRolesService.insertUserRoles(userRoles));
    }

    /**
     * 修改用户角色关联
     */
    @PreAuthorize("@ss.hasPermi('system:roles:edit')")
    @Log(title = "用户角色关联", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserRoles userRoles)
    {
        return toAjax(userRolesService.updateUserRoles(userRoles));
    }

    /**
     * 删除用户角色关联
     */
    @PreAuthorize("@ss.hasPermi('system:roles:remove')")
    @Log(title = "用户角色关联", businessType = BusinessType.DELETE)
	@DeleteMapping("/{userRoleIds}")
    public AjaxResult remove(@PathVariable Long[] userRoleIds)
    {
        return toAjax(userRolesService.deleteUserRolesByUserRoleIds(userRoleIds));
    }
}
