package com.ruoyi.project.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.project.mapper.TaskMembersMapper;
import com.ruoyi.project.domain.TaskMembers;
import com.ruoyi.project.service.ITaskMembersService;

/**
 * 任务成员Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-11-24
 */
@Service
public class TaskMembersServiceImpl implements ITaskMembersService 
{
    @Autowired
    private TaskMembersMapper taskMembersMapper;

    /**
     * 查询任务成员
     * 
     * @param taskMemberId 任务成员主键
     * @return 任务成员
     */
    @Override
    public TaskMembers selectTaskMembersByTaskMemberId(Long taskMemberId)
    {
        return taskMembersMapper.selectTaskMembersByTaskMemberId(taskMemberId);
    }

    /**
     * 查询任务成员列表
     * 
     * @param taskMembers 任务成员
     * @return 任务成员
     */
    @Override
    public List<TaskMembers> selectTaskMembersList(TaskMembers taskMembers)
    {
        return taskMembersMapper.selectTaskMembersList(taskMembers);
    }

    /**
     * 新增任务成员
     * 
     * @param taskMembers 任务成员
     * @return 结果
     */
    @Override
    public int insertTaskMembers(TaskMembers taskMembers)
    {
        return taskMembersMapper.insertTaskMembers(taskMembers);
    }

    /**
     * 修改任务成员
     * 
     * @param taskMembers 任务成员
     * @return 结果
     */
    @Override
    public int updateTaskMembers(TaskMembers taskMembers)
    {
        return taskMembersMapper.updateTaskMembers(taskMembers);
    }

    /**
     * 批量删除任务成员
     * 
     * @param taskMemberIds 需要删除的任务成员主键
     * @return 结果
     */
    @Override
    public int deleteTaskMembersByTaskMemberIds(Long[] taskMemberIds)
    {
        return taskMembersMapper.deleteTaskMembersByTaskMemberIds(taskMemberIds);
    }

    /**
     * 删除任务成员信息
     * 
     * @param taskMemberId 任务成员主键
     * @return 结果
     */
    @Override
    public int deleteTaskMembersByTaskMemberId(Long taskMemberId)
    {
        return taskMembersMapper.deleteTaskMembersByTaskMemberId(taskMemberId);
    }
}
