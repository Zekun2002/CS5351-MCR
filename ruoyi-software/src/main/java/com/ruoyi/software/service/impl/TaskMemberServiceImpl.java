package com.ruoyi.software.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.software.mapper.TaskMemberMapper;
import com.ruoyi.software.domain.TaskMember;
import com.ruoyi.software.service.ITaskMemberService;

/**
 * 任务成员管理Service业务层处理
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
@Service
public class TaskMemberServiceImpl implements ITaskMemberService 
{
    @Autowired
    private TaskMemberMapper taskMemberMapper;

    /**
     * 查询任务成员管理
     * 
     * @param taskMemberId 任务成员管理主键
     * @return 任务成员管理
     */
    @Override
    public TaskMember selectTaskMemberByTaskMemberId(Long taskMemberId)
    {
        return taskMemberMapper.selectTaskMemberByTaskMemberId(taskMemberId);
    }

    /**
     * 查询任务成员管理列表
     * 
     * @param taskMember 任务成员管理
     * @return 任务成员管理
     */
    @Override
    public List<TaskMember> selectTaskMemberList(TaskMember taskMember)
    {
        return taskMemberMapper.selectTaskMemberList(taskMember);
    }

    /**
     * 新增任务成员管理
     * 
     * @param taskMember 任务成员管理
     * @return 结果
     */
    @Override
    public int insertTaskMember(TaskMember taskMember)
    {
        return taskMemberMapper.insertTaskMember(taskMember);
    }

    /**
     * 修改任务成员管理
     * 
     * @param taskMember 任务成员管理
     * @return 结果
     */
    @Override
    public int updateTaskMember(TaskMember taskMember)
    {
        return taskMemberMapper.updateTaskMember(taskMember);
    }

    /**
     * 批量删除任务成员管理
     * 
     * @param taskMemberIds 需要删除的任务成员管理主键
     * @return 结果
     */
    @Override
    public int deleteTaskMemberByTaskMemberIds(Long[] taskMemberIds)
    {
        return taskMemberMapper.deleteTaskMemberByTaskMemberIds(taskMemberIds);
    }

    /**
     * 删除任务成员管理信息
     * 
     * @param taskMemberId 任务成员管理主键
     * @return 结果
     */
    @Override
    public int deleteTaskMemberByTaskMemberId(Long taskMemberId)
    {
        return taskMemberMapper.deleteTaskMemberByTaskMemberId(taskMemberId);
    }
}
