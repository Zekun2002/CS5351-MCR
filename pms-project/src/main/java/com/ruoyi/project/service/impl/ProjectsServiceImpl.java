package com.ruoyi.project.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.project.mapper.ProjectsMapper;
import com.ruoyi.project.domain.Projects;
import com.ruoyi.project.domain.ProjectMembers;
import com.ruoyi.project.service.IProjectsService;
import com.ruoyi.project.service.IProjectMembersService;
import com.ruoyi.common.utils.SecurityUtils;

/**
 * 项目管理Service业务层处理
 *
 * @author weijiazhe
 * @date 2025-11-12
 */
@Service
public class ProjectsServiceImpl implements IProjectsService {
    @Autowired
    private ProjectsMapper projectsMapper;
    
    @Autowired
    private IProjectMembersService projectMembersService;

    /**
     * 查询项目管理
     *
     * @param projectId 项目管理主键
     * @return 项目管理
     */
    @Override
    public Projects selectProjectsByProjectId(Long projectId) {
        return projectsMapper.selectProjectsByProjectId(projectId);
    }

    /**
     * 查询项目管理列表
     *
     * @param projects 项目管理
     * @return 项目管理
     */
    @Override
    public List<Projects> selectProjectsList(Projects projects) {
        return projectsMapper.selectProjectsList(projects);
    }

    @Override
    public List<Projects> selectProjectsIdList() {
        return projectsMapper.selectProjectsIdList();
    }

    /**
     * 新增项目管理
     *
     * @param projects 项目管理
     * @return 结果
     */
    @Override
    @Transactional
    public int insertProjects(Projects projects) {
        // 设置创建时间和更新时间
        Date now = new Date();
        if (projects.getCreatedAt() == null) {
            projects.setCreatedAt(now);
        }
        if (projects.getUpdatedAt() == null) {
            projects.setUpdatedAt(now);
        }
        
        // 插入项目
        int result = projectsMapper.insertProjects(projects);
        
        // 如果项目创建成功，自动将创建者添加为PM
        if (result > 0 && projects.getProjectId() != null && projects.getCreatedBy() != null) {
            ProjectMembers projectMember = new ProjectMembers();
            projectMember.setProjectId(projects.getProjectId());
            projectMember.setUserId(projects.getCreatedBy());
            projectMember.setRole("PM");
            projectMember.setJoinedAt(now);
            projectMembersService.insertProjectMembers(projectMember);
        }
        
        return result;
    }

    /**
     * 修改项目管理
     *
     * @param projects 项目管理
     * @return 结果
     */
    @Override
    public int updateProjects(Projects projects) {
        return projectsMapper.updateProjects(projects);
    }

    /**
     * 批量删除项目管理
     *
     * @param projectIds 需要删除的项目管理主键
     * @return 结果
     */
    @Override
    public int deleteProjectsByProjectIds(Long[] projectIds) {
        return projectsMapper.deleteProjectsByProjectIds(projectIds);
    }

    /**
     * 删除项目管理信息
     *
     * @param projectId 项目管理主键
     * @return 结果
     */
    @Override
    public int deleteProjectsByProjectId(Long projectId) {
        return projectsMapper.deleteProjectsByProjectId(projectId);
    }
}
