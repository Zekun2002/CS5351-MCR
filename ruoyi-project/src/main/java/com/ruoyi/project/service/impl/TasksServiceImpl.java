package com.ruoyi.project.service.impl;

import com.ruoyi.project.domain.TaskMembers;
import com.ruoyi.project.domain.Tasks;
import com.ruoyi.project.mapper.TaskMembersMapper;
import com.ruoyi.project.mapper.TasksMapper;
import com.ruoyi.project.service.ITasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 任务Service业务层处理
 *
 * @author ruoyi
 * @date 2025-11-24
 */
@Service
public class TasksServiceImpl implements ITasksService {
    @Autowired
    private TasksMapper tasksMapper;

    @Autowired
    private TaskMembersMapper taskMembersMapper;

    /**
     * 查询任务
     *
     * @param taskId 任务主键
     * @return 任务
     */
    @Override
    public Tasks selectTasksByTaskId(Long taskId) {
        return tasksMapper.selectTasksByTaskId(taskId);
    }

    /**
     * 查询任务列表
     *
     * @param tasks 任务
     * @return 任务
     */
    @Override
    public List<Tasks> selectTasksList(Tasks tasks) {
        return tasksMapper.selectTasksList(tasks);
    }

    /**
     * ###################################
     * 查询所有任务id
     *
     * @return 任务管理集合
     */
    @Override
    public List<Tasks> selectTasksIdList() {
        return tasksMapper.selectTasksIdList();
    }

    /**
     * 新增任务
     *
     * @param tasks 任务
     * @return 结果
     */
    @Override
    public int insertTasks(Tasks tasks) {
        tasksMapper.insertTasks(tasks);
        TaskMembers taskMember = new TaskMembers();
        taskMember.setTaskId(tasks.getTaskId());
        taskMember.setUserId(tasks.getAssignedTo());
        taskMember.setAssignedAt(tasks.getCreatedAt());
        return taskMembersMapper.insertTaskMembers(taskMember);
    }

    /**
     * 修改任务
     *
     * @param tasks 任务
     * @return 结果
     */
    @Override
    public int updateTasks(Tasks tasks) {
        Tasks t = tasksMapper.selectTasksByTaskId(tasks.getTaskId());

        TaskMembers taskMember = new TaskMembers();
        taskMember.setTaskId(t.getTaskId());
        taskMember.setUserId(t.getAssignedTo());
        taskMembersMapper.deleteTaskMembers(taskMember);

        taskMember.setUserId(tasks.getAssignedTo());
        taskMember.setAssignedAt(tasks.getUpdatedAt());

        if (taskMembersMapper.selectTaskMembersByTaskAndUserId(taskMember) == null) {
            taskMembersMapper.insertTaskMembers(taskMember);
        }

        return tasksMapper.updateTasks(tasks);
    }

    /**
     * 批量删除任务
     *
     * @param taskIds 需要删除的任务主键
     * @return 结果
     */
    @Override
    public int deleteTasksByTaskIds(Long[] taskIds) {
        return tasksMapper.deleteTasksByTaskIds(taskIds);
    }

    /**
     * 删除任务信息
     *
     * @param taskId 任务主键
     * @return 结果
     */
    @Override
    public int deleteTasksByTaskId(Long taskId) {
        return tasksMapper.deleteTasksByTaskId(taskId);
    }
}
