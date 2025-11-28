package com.ruoyi.project.mapper;

import java.util.List;
import com.ruoyi.project.domain.ProjectMembers;

/**
 * 项目成员管理Mapper接口
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
public interface ProjectMembersMapper 
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
     * 删除项目成员管理
     * 
     * @param memberId 项目成员管理主键
     * @return 结果
     */
    public int deleteProjectMembersByMemberId(Long memberId);

    /**
     * 批量删除项目成员管理
     * 
     * @param memberIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProjectMembersByMemberIds(Long[] memberIds);
}
