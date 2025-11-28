package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.IssuesMapper;
import com.ruoyi.project.domain.Issues;
import com.ruoyi.project.service.IIssuesService;

/**
 * 问题Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-25
 */
@Service
public class IssuesServiceImpl implements IIssuesService 
{
    @Autowired
    private IssuesMapper issuesMapper;

    /**
     * 查询问题
     * 
     * @param issueId 问题主键
     * @return 问题
     */
    @Override
    public Issues selectIssuesByIssueId(Long issueId)
    {
        return issuesMapper.selectIssuesByIssueId(issueId);
    }

    /**
     * 查询问题列表
     * 
     * @param issues 问题
     * @return 问题
     */
    @Override
    public List<Issues> selectIssuesList(Issues issues)
    {
        return issuesMapper.selectIssuesList(issues);
    }

    /**
     * 新增问题
     * 
     * @param issues 问题
     * @return 结果
     */
    @Override
    public int insertIssues(Issues issues)
    {
        return issuesMapper.insertIssues(issues);
    }

    /**
     * 修改问题
     * 
     * @param issues 问题
     * @return 结果
     */
    @Override
    public int updateIssues(Issues issues)
    {
        return issuesMapper.updateIssues(issues);
    }

    /**
     * 批量删除问题
     * 
     * @param issueIds 需要删除的问题主键
     * @return 结果
     */
    @Override
    public int deleteIssuesByIssueIds(Long[] issueIds)
    {
        return issuesMapper.deleteIssuesByIssueIds(issueIds);
    }

    /**
     * 删除问题信息
     * 
     * @param issueId 问题主键
     * @return 结果
     */
    @Override
    public int deleteIssuesByIssueId(Long issueId)
    {
        return issuesMapper.deleteIssuesByIssueId(issueId);
    }
}
