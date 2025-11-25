package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.UserRoles;
import org.apache.ibatis.annotations.Param;

/**
 * 用户角色关联Mapper接口
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
public interface UserRolesMapper 
{
    /**
     * 查询用户角色关联
     * 
     * @param userRoleId 用户角色关联主键
     * @return 用户角色关联
     */
    public UserRoles selectUserRolesByUserRoleId(Long userRoleId);

    /**
     * 查询用户角色关联列表
     * 
     * @param userRoles 用户角色关联
     * @return 用户角色关联集合
     */
    public List<UserRoles> selectUserRolesList(UserRoles userRoles);

    /**
     * 新增用户角色关联
     * 
     * @param userRoles 用户角色关联
     * @return 结果
     */
    public int insertUserRoles(UserRoles userRoles);

    /**
     * 修改用户角色关联
     * 
     * @param userRoles 用户角色关联
     * @return 结果
     */
    public int updateUserRoles(UserRoles userRoles);

    /**
     * 删除用户角色关联
     * 
     * @param userRoleId 用户角色关联主键
     * @return 结果
     */
    public int deleteUserRolesByUserRoleId(Long userRoleId);

    /**
     * 批量删除用户角色关联
     * 
     * @param userRoleIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserRolesByUserRoleIds(Long[] userRoleIds);

    int deleteByUserId(@Param("userId") Long userId);

    int batchInsert(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);
}
