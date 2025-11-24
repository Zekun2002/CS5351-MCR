package com.ruoyi.software.service;

import java.util.List;
import com.ruoyi.software.domain.TaskMember;

/**
 * 任务成员管理Service接口
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
public interface ITaskMemberService 
{
    /**
     * 查询任务成员管理
     * 
     * @param taskMemberId 任务成员管理主键
     * @return 任务成员管理
     */
    public TaskMember selectTaskMemberByTaskMemberId(Long taskMemberId);

    /**
     * 查询任务成员管理列表
     * 
     * @param taskMember 任务成员管理
     * @return 任务成员管理集合
     */
    public List<TaskMember> selectTaskMemberList(TaskMember taskMember);

    /**
     * 新增任务成员管理
     * 
     * @param taskMember 任务成员管理
     * @return 结果
     */
    public int insertTaskMember(TaskMember taskMember);

    /**
     * 修改任务成员管理
     * 
     * @param taskMember 任务成员管理
     * @return 结果
     */
    public int updateTaskMember(TaskMember taskMember);

    /**
     * 批量删除任务成员管理
     * 
     * @param taskMemberIds 需要删除的任务成员管理主键集合
     * @return 结果
     */
    public int deleteTaskMemberByTaskMemberIds(Long[] taskMemberIds);

    /**
     * 删除任务成员管理信息
     * 
     * @param taskMemberId 任务成员管理主键
     * @return 结果
     */
    public int deleteTaskMemberByTaskMemberId(Long taskMemberId);
}
