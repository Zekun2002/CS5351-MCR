package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.ProjectMembersMapper;
import com.ruoyi.project.domain.ProjectMembers;
import com.ruoyi.project.service.IProjectMembersService;

/**
 * 项目成员管理Service业务层处理
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
@Service
public class ProjectMembersServiceImpl implements IProjectMembersService 
{
    @Autowired
    private ProjectMembersMapper projectMembersMapper;

    /**
     * 查询项目成员管理
     * 
     * @param memberId 项目成员管理主键
     * @return 项目成员管理
     */
    @Override
    public ProjectMembers selectProjectMembersByMemberId(Long memberId)
    {
        return projectMembersMapper.selectProjectMembersByMemberId(memberId);
    }

    /**
     * 查询项目成员管理列表
     * 
     * @param projectMembers 项目成员管理
     * @return 项目成员管理
     */
    @Override
    public List<ProjectMembers> selectProjectMembersList(ProjectMembers projectMembers)
    {
        return projectMembersMapper.selectProjectMembersList(projectMembers);
    }

    /**
     * 新增项目成员管理
     * 
     * @param projectMembers 项目成员管理
     * @return 结果
     */
    @Override
    public int insertProjectMembers(ProjectMembers projectMembers)
    {
        return projectMembersMapper.insertProjectMembers(projectMembers);
    }

    /**
     * 修改项目成员管理
     * 
     * @param projectMembers 项目成员管理
     * @return 结果
     */
    @Override
    public int updateProjectMembers(ProjectMembers projectMembers)
    {
        return projectMembersMapper.updateProjectMembers(projectMembers);
    }

    /**
     * 批量删除项目成员管理
     * 
     * @param memberIds 需要删除的项目成员管理主键
     * @return 结果
     */
    @Override
    public int deleteProjectMembersByMemberIds(Long[] memberIds)
    {
        return projectMembersMapper.deleteProjectMembersByMemberIds(memberIds);
    }

    /**
     * 删除项目成员管理信息
     * 
     * @param memberId 项目成员管理主键
     * @return 结果
     */
    @Override
    public int deleteProjectMembersByMemberId(Long memberId)
    {
        return projectMembersMapper.deleteProjectMembersByMemberId(memberId);
    }
}
