package com.ruoyi.project.service;

import java.util.List;
import com.ruoyi.project.domain.ProjectMembers;

/**
 * 项目成员管理Service接口
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
public interface IProjectMembersService 
{
    /**
     * 查询项目成员管理
     * 
     * @param memberId 项目成员管理主键
     * @return 项目成员管理
     */
    public ProjectMembers selectProjectMembersByMemberId(Long memberId);

    /**
     * 查询项目成员管理列表
     * 
     * @param projectMembers 项目成员管理
     * @return 项目成员管理集合
     */
    public List<ProjectMembers> selectProjectMembersList(ProjectMembers projectMembers);

    /**
     * 新增项目成员管理
     * 
     * @param projectMembers 项目成员管理
     * @return 结果
     */
    public int insertProjectMembers(ProjectMembers projectMembers);

    /**
     * 修改项目成员管理
     * 
     * @param projectMembers 项目成员管理
     * @return 结果
     */
    public int updateProjectMembers(ProjectMembers projectMembers);

    /**
     * 批量删除项目成员管理
     * 
     * @param memberIds 需要删除的项目成员管理主键集合
     * @return 结果
     */
    public int deleteProjectMembersByMemberIds(Long[] memberIds);

    /**
     * 删除项目成员管理信息
     * 
     * @param memberId 项目成员管理主键
     * @return 结果
     */
    public int deleteProjectMembersByMemberId(Long memberId);
    
    /**
     * 检查用户是否为指定项目的PM
     * 
     * @param userId 用户ID
     * @param projectId 项目ID
     * @return 是否为PM
     */
    public boolean isProjectPM(Long userId, Long projectId);
}
