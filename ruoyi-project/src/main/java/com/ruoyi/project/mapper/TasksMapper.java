package com.ruoyi.project.mapper;

import java.util.List;
import com.ruoyi.project.domain.Tasks;

/**
 * 任务Mapper接口
 * 
 * @author ruoyi
 * @date 2025-11-24
 */
public interface TasksMapper 
{
    /**
     * 查询任务
     * 
     * @param taskId 任务主键
     * @return 任务
     */
    public Tasks selectTasksByTaskId(Long taskId);

    /**
     * 查询任务列表
     * 
     * @param tasks 任务
     * @return 任务集合
     */
    public List<Tasks> selectTasksList(Tasks tasks);

    /**
     * 新增任务
     * 
     * @param tasks 任务
     * @return 结果
     */
    public int insertTasks(Tasks tasks);

    /**
     * 修改任务
     * 
     * @param tasks 任务
     * @return 结果
     */
    public int updateTasks(Tasks tasks);

    /**
     * 删除任务
     * 
     * @param taskId 任务主键
     * @return 结果
     */
    public int deleteTasksByTaskId(Long taskId);

    /**
     * 批量删除任务
     * 
     * @param taskIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTasksByTaskIds(Long[] taskIds);
}
