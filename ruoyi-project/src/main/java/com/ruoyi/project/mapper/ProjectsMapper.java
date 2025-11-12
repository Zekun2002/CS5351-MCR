package com.ruoyi.project.mapper;

import java.util.List;
import com.ruoyi.project.domain.Projects;

/**
 * 项目管理Mapper接口
 * 
 * @author weijiazhe
 * @date 2025-11-12
 */
public interface ProjectsMapper 
{
    /**
     * 查询项目管理
     * 
     * @param projectId 项目管理主键
     * @return 项目管理
     */
    public Projects selectProjectsByProjectId(Long projectId);

    /**
     * 查询项目管理列表
     * 
     * @param projects 项目管理
     * @return 项目管理集合
     */
    public List<Projects> selectProjectsList(Projects projects);

    /**
     * 新增项目管理
     * 
     * @param projects 项目管理
     * @return 结果
     */
    public int insertProjects(Projects projects);

    /**
     * 修改项目管理
     * 
     * @param projects 项目管理
     * @return 结果
     */
    public int updateProjects(Projects projects);

    /**
     * 删除项目管理
     * 
     * @param projectId 项目管理主键
     * @return 结果
     */
    public int deleteProjectsByProjectId(Long projectId);

    /**
     * 批量删除项目管理
     * 
     * @param projectIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProjectsByProjectIds(Long[] projectIds);
}
