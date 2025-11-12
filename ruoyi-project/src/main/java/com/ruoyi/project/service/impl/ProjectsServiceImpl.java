package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.ProjectsMapper;
import com.ruoyi.project.domain.Projects;
import com.ruoyi.project.service.IProjectsService;

/**
 * 项目管理Service业务层处理
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
@Service
public class ProjectsServiceImpl implements IProjectsService 
{
    @Autowired
    private ProjectsMapper projectsMapper;

    /**
     * 查询项目管理
     * 
     * @param projectId 项目管理主键
     * @return 项目管理
     */
    @Override
    public Projects selectProjectsByProjectId(Long projectId)
    {
        return projectsMapper.selectProjectsByProjectId(projectId);
    }

    /**
     * 查询项目管理列表
     * 
     * @param projects 项目管理
     * @return 项目管理
     */
    @Override
    public List<Projects> selectProjectsList(Projects projects)
    {
        return projectsMapper.selectProjectsList(projects);
    }

    /**
     * 新增项目管理
     * 
     * @param projects 项目管理
     * @return 结果
     */
    @Override
    public int insertProjects(Projects projects)
    {
        return projectsMapper.insertProjects(projects);
    }

    /**
     * 修改项目管理
     * 
     * @param projects 项目管理
     * @return 结果
     */
    @Override
    public int updateProjects(Projects projects)
    {
        return projectsMapper.updateProjects(projects);
    }

    /**
     * 批量删除项目管理
     * 
     * @param projectIds 需要删除的项目管理主键
     * @return 结果
     */
    @Override
    public int deleteProjectsByProjectIds(Long[] projectIds)
    {
        return projectsMapper.deleteProjectsByProjectIds(projectIds);
    }

    /**
     * 删除项目管理信息
     * 
     * @param projectId 项目管理主键
     * @return 结果
     */
    @Override
    public int deleteProjectsByProjectId(Long projectId)
    {
        return projectsMapper.deleteProjectsByProjectId(projectId);
    }
}
