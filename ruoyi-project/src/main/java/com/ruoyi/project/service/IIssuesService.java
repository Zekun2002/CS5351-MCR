package com.ruoyi.project.service;

import java.util.List;
import com.ruoyi.project.domain.Issues;

/**
 * 问题管理Service接口
 * 
 * @author ruoyi
 * @date 2025-11-24
 */
public interface IIssuesService 
{
    /**
     * 查询问题管理
     * 
     * @param issueId 问题管理主键
     * @return 问题管理
     */
    public Issues selectIssuesByIssueId(Long issueId);

    /**
     * 查询问题管理列表
     * 
     * @param issues 问题管理
     * @return 问题管理集合
     */
    public List<Issues> selectIssuesList(Issues issues);

    /**
     * 新增问题管理
     * 
     * @param issues 问题管理
     * @return 结果
     */
    public int insertIssues(Issues issues);

    /**
     * 修改问题管理
     * 
     * @param issues 问题管理
     * @return 结果
     */
    public int updateIssues(Issues issues);

    /**
     * 批量删除问题管理
     * 
     * @param issueIds 需要删除的问题管理主键集合
     * @return 结果
     */
    public int deleteIssuesByIssueIds(Long[] issueIds);

    /**
     * 删除问题管理信息
     * 
     * @param issueId 问题管理主键
     * @return 结果
     */
    public int deleteIssuesByIssueId(Long issueId);
}
