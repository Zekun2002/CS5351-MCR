<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="任务所属项目ID" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="请输入任务所属项目ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务名称" prop="taskName">
        <el-input
          v-model="queryParams.taskName"
          placeholder="请输入任务名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务优先级" prop="priority">
        <el-input
          v-model="queryParams.priority"
          placeholder="请输入任务优先级"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="创建任务的用户ID" prop="createdBy">
        <el-input
          v-model="queryParams.createdBy"
          placeholder="请输入创建任务的用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务分配给的用户ID" prop="assignedTo">
        <el-input
          v-model="queryParams.assignedTo"
          placeholder="请输入任务分配给的用户ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务创建时间" prop="createdAt">
        <el-date-picker clearable
          v-model="queryParams.createdAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择任务创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="任务更新时间" prop="updatedAt">
        <el-date-picker clearable
          v-model="queryParams.updatedAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择任务更新时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
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
          v-hasPermi="['ruoyi-project:tasks:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['ruoyi-project:tasks:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['ruoyi-project:tasks:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ruoyi-project:tasks:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="tasksList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="任务唯一标识" align="center" prop="taskId" />
      <el-table-column label="任务所属项目ID" align="center" prop="projectId" />
      <el-table-column label="任务名称" align="center" prop="taskName" />
      <el-table-column label="任务描述" align="center" prop="description" />
      <el-table-column label="任务优先级" align="center" prop="priority" />
      <el-table-column label="任务状态" align="center" prop="status" />
      <el-table-column label="创建任务的用户ID" align="center" prop="createdBy" />
      <el-table-column label="任务分配给的用户ID" align="center" prop="assignedTo" />
      <el-table-column label="任务创建时间" align="center" prop="createdAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="任务更新时间" align="center" prop="updatedAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.updatedAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['ruoyi-project:tasks:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ruoyi-project:tasks:remove']"
          >删除</el-button>
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

    <!-- 添加或修改任务对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <!-- <el-form-item label="任务所属项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入任务所属项目ID" />
        </el-form-item> -->
        <el-form-item label="问题所属项目ID" prop="projectId">
          <el-select v-model="form.projectId" placeholder="请输入问题所属任务ID" >
            <el-option
              v-for="item in projectIds"
              :key="item.projectId"
              :label="item.projectName"
              :value="item.projectId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="任务名称" prop="taskName">
          <el-input v-model="form.taskName" placeholder="请输入任务名称" />
        </el-form-item>
        <el-form-item label="任务描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="任务优先级" prop="priority">
          <el-input v-model="form.priority" placeholder="请输入任务优先级" />
        </el-form-item>
        <!-- <el-form-item label="创建任务的用户ID" prop="createdBy">
          <el-input v-model="form.createdBy" placeholder="请输入创建任务的用户ID" />
        </el-form-item> -->
        <el-form-item label="创建问题的用户ID" prop="createdById">
          <el-select v-model="form.createdById" placeholder="请输入创建问题的用户ID" >
            <el-option
              v-for="item in createdByIds"
              :key="item.createdById"
              :label="item.createdByName"
              :value="item.createdById">
            </el-option>
          </el-select>
        </el-form-item>
        <!-- <el-form-item label="任务分配给的用户ID" prop="assignedTo">
          <el-input v-model="form.assignedTo" placeholder="请输入任务分配给的用户ID" />
        </el-form-item> -->
        <el-form-item label="任务分配给的用户ID" prop="createdById">
          <el-select v-model="form.assignedToId" placeholder="请输入任务分配给的用户ID" >
            <el-option
              v-for="item in assignedToIds"
              :key="item.assignedToId"
              :label="item.assignedToName"
              :value="item.assignedToId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="任务创建时间" prop="createdAt">
          <el-date-picker clearable
            v-model="form.createdAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择任务创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="任务更新时间" prop="updatedAt">
          <el-date-picker clearable
            v-model="form.updatedAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择任务更新时间">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listTasks, getTasks, delTasks, addTasks, updateTasks,getConnectionData } from "@/api/ruoyi-project/tasks";

export default {
  name: "Tasks",
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
      // 任务表格数据
      tasksList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectId: null,
        taskName: null,
        description: null,
        priority: null,
        status: null,
        createdBy: null,
        assignedTo: null,
        createdAt: null,
        updatedAt: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      projectIds:[],
      createdByIds:[],
      assignedToIds:[]
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询任务列表 */
    getList() {
      this.loading = true;
      listTasks(this.queryParams).then(response => {
        this.tasksList = response.rows;
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
        taskId: null,
        projectId: null,
        taskName: null,
        description: null,
        priority: null,
        status: null,
        createdBy: null,
        assignedTo: null,
        createdAt: null,
        updatedAt: null
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
      this.ids = selection.map(item => item.taskId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      getConnectionData().then(response => {
        
      })
      this.reset();
      this.open = true;
      this.title = "添加任务";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const taskId = row.taskId || this.ids
      getTasks(taskId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改任务";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.taskId != null) {
            updateTasks(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addTasks(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const taskIds = row.taskId || this.ids;
      this.$modal.confirm('是否确认删除任务编号为"' + taskIds + '"的数据项？').then(function() {
        return delTasks(taskIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('ruoyi-project/tasks/export', {
        ...this.queryParams
      }, `tasks_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
