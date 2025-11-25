package com.ruoyi.project.service;

import java.util.List;
import com.ruoyi.project.domain.Issues;

/**
 * 问题Service接口
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
public interface IIssuesService 
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
     * 批量删除问题
     * 
     * @param issueIds 需要删除的问题主键集合
     * @return 结果
     */
    public int deleteIssuesByIssueIds(Long[] issueIds);

    /**
     * 删除问题信息
     * 
     * @param issueId 问题主键
     * @return 结果
     */
    public int deleteIssuesByIssueId(Long issueId);
}
