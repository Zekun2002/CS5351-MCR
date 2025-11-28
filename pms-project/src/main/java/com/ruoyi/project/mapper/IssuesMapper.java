package com.ruoyi.project.mapper;

import java.util.List;
import com.ruoyi.project.domain.Issues;

/**
 * 问题Mapper接口
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
public interface IssuesMapper 
{
    /**
     * 查询问题
     * 
     * @param issueId 问题主键
     * @return 问题
     */
    public Issues selectIssuesByIssueId(Long issueId);

    /**
     * 查询问题列表
     * 
     * @param issues 问题
     * @return 问题集合
     */
    public List<Issues> selectIssuesList(Issues issues);

    /**
     * 新增问题
     * 
     * @param issues 问题
     * @return 结果
     */
    public int insertIssues(Issues issues);

    /**
     * 修改问题
     * 
     * @param issues 问题
     * @return 结果
     */
    public int updateIssues(Issues issues);

    /**
     * 删除问题
     * 
     * @param issueId 问题主键
     * @return 结果
     */
    public int deleteIssuesByIssueId(Long issueId);

    /**
     * 批量删除问题
     * 
     * @param issueIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteIssuesByIssueIds(Long[] issueIds);
}
