package com.ruoyi.software.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.software.mapper.TaskMapper;
import com.ruoyi.software.domain.Task;
import com.ruoyi.software.service.ITaskService;

/**
 * 任务管理Service业务层处理
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
@Service
public class TaskServiceImpl implements ITaskService 
{
    @Autowired
    private TaskMapper taskMapper;

    /**
     * 查询任务管理
     * 
     * @param taskId 任务管理主键
     * @return 任务管理
     */
    @Override
    public Task selectTaskByTaskId(Long taskId)
    {
        return taskMapper.selectTaskByTaskId(taskId);
    }

    /**
     * 查询任务管理列表
     * 
     * @param task 任务管理
     * @return 任务管理
     */
    @Override
    public List<Task> selectTaskList(Task task)
    {
        return taskMapper.selectTaskList(task);
    }

    /**
     * 新增任务管理
     * 
     * @param task 任务管理
     * @return 结果
     */
    @Override
    public int insertTask(Task task)
    {
        return taskMapper.insertTask(task);
    }

    /**
     * 修改任务管理
     * 
     * @param task 任务管理
     * @return 结果
     */
    @Override
    public int updateTask(Task task)
    {
        return taskMapper.updateTask(task);
    }

    /**
     * 批量删除任务管理
     * 
     * @param taskIds 需要删除的任务管理主键
     * @return 结果
     */
    @Override
    public int deleteTaskByTaskIds(Long[] taskIds)
    {
        return taskMapper.deleteTaskByTaskIds(taskIds);
    }

    /**
     * 删除任务管理信息
     * 
     * @param taskId 任务管理主键
     * @return 结果
     */
    @Override
    public int deleteTaskByTaskId(Long taskId)
    {
        return taskMapper.deleteTaskByTaskId(taskId);
    }
}
