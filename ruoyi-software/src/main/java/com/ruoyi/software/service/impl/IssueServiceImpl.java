package com.ruoyi.software.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.software.mapper.IssueMapper;
import com.ruoyi.software.domain.Issue;
import com.ruoyi.software.service.IIssueService;

/**
 * 问题管理Service业务层处理
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
@Service
public class IssueServiceImpl implements IIssueService 
{
    @Autowired
    private IssueMapper issueMapper;

    /**
     * 查询问题管理
     * 
     * @param issueId 问题管理主键
     * @return 问题管理
     */
    @Override
    public Issue selectIssueByIssueId(Long issueId)
    {
        return issueMapper.selectIssueByIssueId(issueId);
    }

    /**
     * 查询问题管理列表
     * 
     * @param issue 问题管理
     * @return 问题管理
     */
    @Override
    public List<Issue> selectIssueList(Issue issue)
    {
        return issueMapper.selectIssueList(issue);
    }

    /**
     * 新增问题管理
     * 
     * @param issue 问题管理
     * @return 结果
     */
    @Override
    public int insertIssue(Issue issue)
    {
        return issueMapper.insertIssue(issue);
    }

    /**
     * 修改问题管理
     * 
     * @param issue 问题管理
     * @return 结果
     */
    @Override
    public int updateIssue(Issue issue)
    {
        return issueMapper.updateIssue(issue);
    }

    /**
     * 批量删除问题管理
     * 
     * @param issueIds 需要删除的问题管理主键
     * @return 结果
     */
    @Override
    public int deleteIssueByIssueIds(Long[] issueIds)
    {
        return issueMapper.deleteIssueByIssueIds(issueIds);
    }

    /**
     * 删除问题管理信息
     * 
     * @param issueId 问题管理主键
     * @return 结果
     */
    @Override
    public int deleteIssueByIssueId(Long issueId)
    {
        return issueMapper.deleteIssueByIssueId(issueId);
    }
}
