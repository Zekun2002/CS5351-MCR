package com.ruoyi.project.service;

import java.util.List;

import com.ruoyi.project.domain.Tasks;

/**
 * 任务Service接口
 *
 * @author ruoyi
 * @date 2025-11-24
 */
public interface ITasksService {
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
     * ###################################
     * 查询所有任务id
     *
     * @return 任务管理集合
     */
    public List<Tasks> selectTasksIdList();

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
     * 批量删除任务
     *
     * @param taskIds 需要删除的任务主键集合
     * @return 结果
     */
    public int deleteTasksByTaskIds(Long[] taskIds);

    /**
     * 删除任务信息
     *
     * @param taskId 任务主键
     * @return 结果
     */
    public int deleteTasksByTaskId(Long taskId);
}
