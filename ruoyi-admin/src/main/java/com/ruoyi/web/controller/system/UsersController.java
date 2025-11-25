package com.ruoyi.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Users;
import com.ruoyi.system.service.IUsersService;

@RestController
@RequestMapping("/system/users")
public class UsersController extends BaseController {

    @Autowired
    private IUsersService usersService;

    @PreAuthorize("@ss.hasPermi('system:users:list')")
    @GetMapping("/list")
    public TableDataInfo list(Users query) {
        startPage();
        List<Users> list = usersService.selectUsersList(query);
        list.forEach(u -> u.setPasswordHash(null));
        return getDataTable(list);
    }

    @Log(title = "用户管理", businessType = BusinessType.EXPORT)
    @PreAuthorize("@ss.hasPermi('system:users:export')")
    @PostMapping("/export")
    public void export(HttpServletResponse response, Users query) {
        List<Users> list = usersService.selectUsersList(query);
        list.forEach(u -> u.setPasswordHash(null));
        ExcelUtil<Users> util = new ExcelUtil<>(Users.class);
        util.exportExcel(response, list, "用户数据");
    }

    @PreAuthorize("@ss.hasPermi('system:users:query')")
    @GetMapping("/{userId}")
    public AjaxResult getInfo(@PathVariable Long userId) {
        Users user = usersService.selectUsersByUserId(userId);
        if (user != null) user.setPasswordHash(null);
        return success(user);
    }

    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    @PreAuthorize("@ss.hasPermi('system:users:add')")
    @PostMapping
    public AjaxResult add(@Validated @RequestBody Users user) {
        return toAjax(usersService.insertUsers(user));
    }

    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    @PreAuthorize("@ss.hasPermi('system:users:edit')")
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody Users user) {
        return toAjax(usersService.updateUsers(user));
    }

    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    @PreAuthorize("@ss.hasPermi('system:users:remove')")
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        return toAjax(usersService.deleteUsersByUserIds(userIds));
    }

    @PreAuthorize("@ss.hasPermi('system:users:assignRole')")
    @Log(title = "用户管理", businessType = BusinessType.GRANT)
    @PutMapping("/role/{userId}")
    public AjaxResult assignRoles(@PathVariable Long userId, @RequestBody List<Long> roleIds) {
        return toAjax(usersService.assignRoles(userId, roleIds));
    }

    @PreAuthorize("@ss.hasPermi('system:users:query')")
    @GetMapping("/ids")
    public AjaxResult ids() {
        return success(usersService.selectUserIdList());
    }
}

