package com.ruoyi.software.mapper;

import java.util.List;
import com.ruoyi.software.domain.Task;

/**
 * 任务管理Mapper接口
 * 
 * @author Li Jiajun
 * @date 2025-11-21
 */
public interface TaskMapper 
{
    /**
     * 查询任务管理
     * 
     * @param taskId 任务管理主键
     * @return 任务管理
     */
    public Task selectTaskByTaskId(Long taskId);

    /**
     * 查询任务管理列表
     * 
     * @param task 任务管理
     * @return 任务管理集合
     */
    public List<Task> selectTaskList(Task task);

    /**
     * 新增任务管理
     * 
     * @param task 任务管理
     * @return 结果
     */
    public int insertTask(Task task);

    /**
     * 修改任务管理
     * 
     * @param task 任务管理
     * @return 结果
     */
    public int updateTask(Task task);

    /**
     * 删除任务管理
     * 
     * @param taskId 任务管理主键
     * @return 结果
     */
    public int deleteTaskByTaskId(Long taskId);

    /**
     * 批量删除任务管理
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTaskByTaskIds(Long[] taskIds);
}
