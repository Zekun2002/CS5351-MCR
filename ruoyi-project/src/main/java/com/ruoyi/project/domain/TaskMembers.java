package com.ruoyi.project.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import com.ruoyi.system.domain.Users;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 任务成员对象 task_members
 *
 * @author ruoyi
 * @date 2025-11-24
 */
public class TaskMembers extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 任务成员唯一标识
     */
    private Long taskMemberId;

    /**
     * 任务ID（关联Tasks表）
     */
    @Excel(name = "任务ID", readConverterExp = "关=联Tasks表")
    private Long taskId;

    /**
     * 用户ID（关联Users表）
     */
    @Excel(name = "用户ID", readConverterExp = "关=联Users表")
    private Long userId;

    /**
     * 任务分配给成员的时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务分配给成员的时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date assignedAt;

    private Tasks task;
    private Users contributor;

    public void setTaskMemberId(Long taskMemberId) {
        this.taskMemberId = taskMemberId;
    }

    public Long getTaskMemberId() {
        return taskMemberId;
    }

    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    public Long getTaskId() {
        return taskId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setAssignedAt(Date assignedAt) {
        this.assignedAt = assignedAt;
    }

    public Date getAssignedAt() {
        return assignedAt;
    }

    public void setTask(Tasks task) {
        this.task = task;
    }

    public Tasks getTask() {
        return task;
    }

    public void setContributor(Users contributor) {
        this.contributor = contributor;
    }

    public Users getContributor() {
        return contributor;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("taskMemberId", getTaskMemberId())
                .append("taskId", getTaskId())
                .append("userId", getUserId())
                .append("assignedAt", getAssignedAt())
                .toString();
    }
}
