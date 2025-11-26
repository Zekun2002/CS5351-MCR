<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" >
      <el-form-item label="Task ID" prop="taskId">
        <el-input
          v-model="queryParams.taskId"
          placeholder="Please enter the task id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="User ID" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="Please enter the user id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Assigned Time" prop="assignedAt">
        <el-date-picker clearable
          v-model="queryParams.assignedAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Please enter the assigned time">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">search</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">reset</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['ruoyi-project:members:add']"
        >add</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['ruoyi-project:members:edit']"
        >update</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['ruoyi-project:members:remove']"
        >delete</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ruoyi-project:members:export']"
        >export</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="membersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Unique identifier of the task member" align="center" prop="taskMemberId" />
      <el-table-column label="Task ID" align="center" prop="taskId" />
      <el-table-column label="User ID" align="center" prop="userId" />
      <el-table-column label="Assigned Time" align="center" prop="assignedAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.assignedAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Operation" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['ruoyi-project:members:edit']"
          >update</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ruoyi-project:members:remove']"
          >delete</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改任务成员对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="任务ID" prop="taskId">
          <el-input v-model="form.taskId" placeholder="请输入任务ID" />
        </el-form-item> -->
        <el-form-item label="Task ID" prop="taskId">
          <el-select v-model="form.taskId" placeholder="Please enter the task id" >
            <el-option
              v-for="item in taskIds"
              :key="item.taskId"
              :label="item.taskName"
              :value="item.taskId">
            </el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="用户ID" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户ID" />
        </el-form-item> -->
        <el-form-item label="User ID" prop="userId">
          <el-select v-model="form.userId" placeholder="Please enter the user id" >
            <el-option
              v-for="item in userIds"
              :key="item.userId"
              :label="item.userName"
              :value="item.userId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Assigned Time" prop="assignedAt">
          <el-date-picker clearable
            v-model="form.assignedAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Please enter the assigned time">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">submit</el-button>
        <el-button @click="cancel">cancel</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMembers, getMembers, delMembers, addMembers, updateMembers, getConnectionData } from "@/api/ruoyi-project/members";

export default {
  name: "Members",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 任务成员表格数据
      membersList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        taskId: null,
        userId: null,
        assignedAt: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        taskId: [
          { required: true, message: "任务ID不能为空", trigger: "blur" }
        ],
        userId: [
          { required: true, message: "用户ID不能为空", trigger: "blur" }
        ],
      },
      taskIds:[],
      userIds:[]
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询任务成员列表 */
    getList() {
      this.loading = true;
      listMembers(this.queryParams).then(response => {
        this.membersList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        taskMemberId: null,
        taskId: null,
        userId: null,
        assignedAt: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.taskMemberId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      getConnectionData().then(response => {
        this.taskIds = response.data.task_ids
        this.taskIds.map(function(item){
            item.taskName = item.taskId + "\t" + item.taskName
            return item
          })
        this.userIds = response.data.user_ids
        this.userIds.map(function(item){
            item.userName = item.userId + "\t" + item.username
            return item
          })
      })
      this.reset();
      this.open = true;
      this.title = "Add Task Member";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const taskMemberId = row.taskMemberId || this.ids
      getConnectionData().then(response => {
        this.taskIds = response.data.task_ids
        this.taskIds.map(function(item){
            item.taskName = item.taskId + "\t" + item.taskName
            return item
          })
        this.userIds = response.data.user_ids
        this.userIds.map(function(item){
            item.userName = item.userId + "\t" + item.username
            return item
          })
      })
      getMembers(taskMemberId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "Update Task Member";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.taskMemberId != null) {
            updateMembers(this.form).then(response => {
              this.$modal.msgSuccess("Successfully Updated");
              this.open = false;
              this.getList();
            });
          } else {
            addMembers(this.form).then(response => {
              this.$modal.msgSuccess("Successfully Added");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const taskMemberIds = row.taskMemberId || this.ids;
      this.$modal.confirm('Are you sure you want to delete the data entry with task member ID ' + taskMemberIds + '?').then(function() {
        return delMembers(taskMemberIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("Successfully Deleted");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('ruoyi-project/members/export', {
        ...this.queryParams
      }, `members_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
