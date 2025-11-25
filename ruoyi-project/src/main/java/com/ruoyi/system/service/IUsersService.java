package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Users;

/**
 * 用户信息Service接口
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
public interface IUsersService 
{
    /**
     * 查询用户信息
     * 
     * @param userId 用户信息主键
     * @return 用户信息
     */
    public Users selectUsersByUserId(Long userId);

    /**
     * 查询用户信息列表
     * 
     * @param users 用户信息
     * @return 用户信息集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增用户信息
     * 
     * @param users 用户信息
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改用户信息
     * 
     * @param users 用户信息
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 批量删除用户信息
     * 
     * @param userIds 需要删除的用户信息主键集合
     * @return 结果
     */
    public int deleteUsersByUserIds(Long[] userIds);

    /**
     * 删除用户信息信息
     * 
     * @param userId 用户信息主键
     * @return 结果
     */
    public int deleteUsersByUserId(Long userId);
}
