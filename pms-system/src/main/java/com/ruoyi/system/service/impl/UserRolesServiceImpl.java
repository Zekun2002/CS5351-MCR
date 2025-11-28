package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserRolesMapper;
import com.ruoyi.system.domain.UserRoles;
import com.ruoyi.system.service.IUserRolesService;

/**
 * 用户角色关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
@Service
public class UserRolesServiceImpl implements IUserRolesService 
{
    @Autowired
    private UserRolesMapper userRolesMapper;

    /**
     * 查询用户角色关联
     * 
     * @param userRoleId 用户角色关联主键
     * @return 用户角色关联
     */
    @Override
    public UserRoles selectUserRolesByUserRoleId(Long userRoleId)
    {
        return userRolesMapper.selectUserRolesByUserRoleId(userRoleId);
    }

    /**
     * 查询用户角色关联列表
     * 
     * @param userRoles 用户角色关联
     * @return 用户角色关联
     */
    @Override
    public List<UserRoles> selectUserRolesList(UserRoles userRoles)
    {
        return userRolesMapper.selectUserRolesList(userRoles);
    }

    /**
     * 新增用户角色关联
     * 
     * @param userRoles 用户角色关联
     * @return 结果
     */
    @Override
    public int insertUserRoles(UserRoles userRoles)
    {
        return userRolesMapper.insertUserRoles(userRoles);
    }

    /**
     * 修改用户角色关联
     * 
     * @param userRoles 用户角色关联
     * @return 结果
     */
    @Override
    public int updateUserRoles(UserRoles userRoles)
    {
        return userRolesMapper.updateUserRoles(userRoles);
    }

    /**
     * 批量删除用户角色关联
     * 
     * @param userRoleIds 需要删除的用户角色关联主键
     * @return 结果
     */
    @Override
    public int deleteUserRolesByUserRoleIds(Long[] userRoleIds)
    {
        return userRolesMapper.deleteUserRolesByUserRoleIds(userRoleIds);
    }

    /**
     * 删除用户角色关联信息
     * 
     * @param userRoleId 用户角色关联主键
     * @return 结果
     */
    @Override
    public int deleteUserRolesByUserRoleId(Long userRoleId)
    {
        return userRolesMapper.deleteUserRolesByUserRoleId(userRoleId);
    }
}
