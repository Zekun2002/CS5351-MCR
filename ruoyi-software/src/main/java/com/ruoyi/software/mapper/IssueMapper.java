package com.ruoyi.software.mapper;

import java.util.List;
import com.ruoyi.software.domain.Issue;

/**
 * 问题管理Mapper接口
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
public interface IssueMapper 
{
    /**
     * 查询问题管理
     * 
     * @param issueId 问题管理主键
     * @return 问题管理
     */
    public Issue selectIssueByIssueId(Long issueId);

    /**
     * 查询问题管理列表
     * 
     * @param issue 问题管理
     * @return 问题管理集合
     */
    public List<Issue> selectIssueList(Issue issue);

    /**
     * 新增问题管理
     * 
     * @param issue 问题管理
     * @return 结果
     */
    public int insertIssue(Issue issue);

    /**
     * 修改问题管理
     * 
     * @param issue 问题管理
     * @return 结果
     */
    public int updateIssue(Issue issue);

    /**
     * 删除问题管理
     * 
     * @param issueId 问题管理主键
     * @return 结果
     */
    public int deleteIssueByIssueId(Long issueId);

    /**
     * 批量删除问题管理
     * 
     * @param issueIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteIssueByIssueIds(Long[] issueIds);
}
