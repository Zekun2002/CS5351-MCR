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
import com.ruoyi.system.domain.RolePermissions;
import com.ruoyi.system.service.IRolePermissionsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 角色权限Controller
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
@RestController
@RequestMapping("/system/permissions")
public class RolePermissionsController extends BaseController
{
    @Autowired
    private IRolePermissionsService rolePermissionsService;

    /**
     * 查询角色权限列表
     */
    @PreAuthorize("@ss.hasPermi('system:permissions:list')")
    @GetMapping("/list")
    public TableDataInfo list(RolePermissions rolePermissions)
    {
        startPage();
        List<RolePermissions> list = rolePermissionsService.selectRolePermissionsList(rolePermissions);
        return getDataTable(list);
    }

    /**
     * 导出角色权限列表
     */
    @PreAuthorize("@ss.hasPermi('system:permissions:export')")
    @Log(title = "角色权限", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RolePermissions rolePermissions)
    {
        List<RolePermissions> list = rolePermissionsService.selectRolePermissionsList(rolePermissions);
        ExcelUtil<RolePermissions> util = new ExcelUtil<RolePermissions>(RolePermissions.class);
        util.exportExcel(response, list, "角色权限数据");
    }

    /**
     * 获取角色权限详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:permissions:query')")
    @GetMapping(value = "/{roleId}")
    public AjaxResult getInfo(@PathVariable("roleId") Long roleId)
    {
        return success(rolePermissionsService.selectRolePermissionsByRoleId(roleId));
    }

    /**
     * 新增角色权限
     */
    @PreAuthorize("@ss.hasPermi('system:permissions:add')")
    @Log(title = "角色权限", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RolePermissions rolePermissions)
    {
        return toAjax(rolePermissionsService.insertRolePermissions(rolePermissions));
    }

    /**
     * 修改角色权限
     */
    @PreAuthorize("@ss.hasPermi('system:permissions:edit')")
    @Log(title = "角色权限", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RolePermissions rolePermissions)
    {
        return toAjax(rolePermissionsService.updateRolePermissions(rolePermissions));
    }

    /**
     * 删除角色权限
     */
    @PreAuthorize("@ss.hasPermi('system:permissions:remove')")
    @Log(title = "角色权限", businessType = BusinessType.DELETE)
	@DeleteMapping("/{roleIds}")
    public AjaxResult remove(@PathVariable Long[] roleIds)
    {
        return toAjax(rolePermissionsService.deleteRolePermissionsByRoleIds(roleIds));
    }
}
