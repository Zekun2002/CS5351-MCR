package com.ruoyi.project.mapper;

import com.ruoyi.project.domain.TaskMembers;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 任务成员Mapper接口
 *
 * @author ruoyi
 * @date 2025-11-24
 */
public interface TaskMembersMapper {
    /**
     * 查询任务成员
     *
     * @param taskMemberId 任务成员主键
     * @return 任务成员
     */
    public TaskMembers selectTaskMembersByTaskMemberId(Long taskMemberId);

    /**
     * 查询任务成员列表
     *
     * @param taskMembers 任务成员
     * @return 任务成员集合
     */
    public List<TaskMembers> selectTaskMembersList(TaskMembers taskMembers);

    /**
     * 新增任务成员
     *
     * @param taskMembers 任务成员
     * @return 结果
     */
    public int insertTaskMembers(TaskMembers taskMembers);

    /**
     * 修改任务成员
     *
     * @param taskMembers 任务成员
     * @return 结果
     */
    public int updateTaskMembers(TaskMembers taskMembers);

    /**
     * 根据任务ID & 负责人ID修改任务成员
     *
     * @param taskMember 任务成员
     * @return 结果
     */
    public int updateTaskMembersById(@Param("userId") Long userId,
                                     @Param("taskMember") TaskMembers taskMember);

    /**
     * 删除任务成员
     *
     * @param taskMemberId 任务成员主键
     * @return 结果
     */
    public int deleteTaskMembersByTaskMemberId(Long taskMemberId);

    /**
     * 批量删除任务成员
     *
     * @param taskMemberIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTaskMembersByTaskMemberIds(Long[] taskMemberIds);
}
