<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" >
      <el-form-item label="Issue Project ID" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="Please enter the issue project ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Issue Task ID" prop="taskId">
        <el-input
          v-model="queryParams.taskId"
          placeholder="Please enter the issue task ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Issue ID" prop="issueId">
        <el-input
          v-model="queryParams.issueId"
          placeholder="Please enter the issue ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Issue Type" prop="issueType">
        <el-select v-model="queryParams.issueType" placeholder="Please enter the issue type" >
            <el-option
              v-for="item in issueTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
      </el-form-item>
      <el-form-item label="Issue Status" prop="status">
        <el-select v-model="queryParams.status" placeholder="Please enter the issue status" >
            <el-option
              v-for="item in statusTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
      </el-form-item>
      <el-form-item label="Created By User ID" prop="createdBy">
        <el-input
          v-model="queryParams.createdBy"
          placeholder="Please enter the created by user ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Issue Creation Time" prop="createdAt">
        <el-date-picker clearable
          v-model="queryParams.createdAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Please select the issue creation time">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="Issue Update Time" prop="updatedAt">
        <el-date-picker clearable
          v-model="queryParams.updatedAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Please select the issue update time">
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
          v-hasPermi="['ruoyi-project:issues:add']"
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
          v-hasPermi="['ruoyi-project:issues:edit']"
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
          v-hasPermi="['ruoyi-project:issues:remove']"
        >delete</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ruoyi-project:issues:export']"
        >export</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="issuesList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Unique Issue Identifier" align="center" prop="issueId" />
      <el-table-column label="Issue Project ID" align="center" prop="projectId" />
      <el-table-column label="Issue Task ID" align="center" prop="taskId" />
      <el-table-column label="Issue Type" align="center" prop="issueType" />
      <el-table-column label="Description" align="center" prop="description" />
      <el-table-column label="Issue Status" align="center" prop="status" />
      <el-table-column label="Creator ID" align="center" prop="createdBy" />
      <el-table-column label="Created Time" align="center" prop="createdAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Updated Time" align="center" prop="updatedAt" width="180">
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
            v-hasPermi="['ruoyi-project:issues:edit']"
          >update</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ruoyi-project:issues:remove']"
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

    <!-- 添加或修改问题对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="550px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label="200px">
        <!-- <el-form-item label="问题所属项目ID" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入问题所属项目ID" />
        </el-form-item> -->
        <el-form-item label="Issue Project ID" prop="projectId">
          <el-select v-model="form.projectId" placeholder="Please enter the issue project ID" >
            <el-option
              v-for="item in projectIds"
              :key="item.projectId"
              :label="item.projectName"
              :value="item.projectId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Issue Task ID" prop="taskId">
          <el-select v-model="form.taskId" placeholder="Please enter the issue task ID" >
            <el-option
              v-for="item in taskIds"
              :key="item.taskId"
              :label="item.taskName"
              :value="item.taskId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Description" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="Please enter the description" />
        </el-form-item>
        <!-- <el-form-item label="创建问题的用户ID" prop="createdBy">
          <el-input v-model="form.createdBy" placeholder="请输入创建问题的用户ID" />
        </el-form-item> -->
        <el-form-item label="Creator ID" prop="userId">
          <el-select v-model="form.createdBy" placeholder="Please enter the creator ID" >
            <el-option
              v-for="item in userIds"
              :key="item.userId"
              :label="item.userName"
              :value="item.userId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Issue Type" prop="issueType">
          <el-select v-model="form.issueType" placeholder="Please enter the issue type" >
            <el-option
              v-for="item in issueTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Issue Status" prop="status">
          <el-select v-model="form.status" placeholder="Please enter the issue status" >
            <el-option
              v-for="item in statusTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Created Time" prop="createdAt">
          <el-date-picker clearable
            v-model="form.createdAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Please select the created time">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="Updated Time" prop="updatedAt">
          <el-date-picker clearable
            v-model="form.updatedAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Please select the updated time">
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
import { listIssues, getIssues, delIssues, addIssues, updateIssues,getConnectionData } from "@/api/ruoyi-project/issues";

export default {
  name: "Issues",
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
      // 问题表格数据
      issuesList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        issueId:null,
        projectId: null,
        taskId: null,
        issueType: null,
        description: null,
        status: null,
        createdBy: null,
        createdAt: null,
        updatedAt: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      // 用于存放获取的任务id列表
      taskIds:[],
      // 用于存放获取的项目id列表
      projectIds:[],
      // 用于存放获取的用户id列表
      userIds:[],
      // 用于所有的问题类型
      issueTypes:[{label:"Bug",value:"Bug"},{label:"技术债务",value:"技术债务"}],
      statusTypes:[{label:"待办",value:"待办"},{label:"进行中",value:"进行中"},{label:"已解决",value:"已解决"}]
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询问题列表 */
    getList() {
      this.loading = true;
      listIssues(this.queryParams).then(response => {
        this.issuesList = response.rows;
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
        issueId: null,
        projectId: null,
        taskId: null,
        issueType: null,
        description: null,
        status: null,
        createdBy: null,
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
      this.ids = selection.map(item => item.issueId)
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
          this.projectIds = response.data.project_ids
          this.projectIds.map(function(item){
            item.projectName = item.projectId + "\t" + item.projectName
            return item
          })
          this.userIds = response.data.user_ids
          this.userIds.map(function(item){
            item.userName = item.userId + "\t" + item.username
            return item
          })
      });
      this.reset();
      this.open = true;
      this.title = "Add Question";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const issueId = row.issueId || this.ids
      getConnectionData().then(response => {
          this.taskIds = response.data.task_ids
          this.taskIds.map(function(item){
            item.taskName = item.taskId + "\t" + item.taskName
            return item
          })
          this.projectIds = response.data.project_ids
          this.projectIds.map(function(item){
            item.projectName = item.projectId + "\t" + item.projectName
            return item
          })
          this.userIds = response.data.user_ids
          this.userIds.map(function(item){
            item.userName = item.userId + "\t" + item.username
            return item
          })
      });
      getIssues(issueId).then(response => {
        this.form = response.data;
        this.form.userId = this.form.createdBy
        this.open = true;
        this.title = "Update Question";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.issueId != null) {
            updateIssues(this.form).then(response => {
              this.$modal.msgSuccess("Successfully Updated");
              this.open = false;
              this.getList();
            });
          } else {
            addIssues(this.form).then(response => {
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
      const issueIds = row.issueId || this.ids;
      this.$modal.confirm('Confirm deletion of issue # ' + issueIds + '?').then(function() {
        return delIssues(issueIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("Successfully Delete");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('ruoyi-project/issues/export', {
        ...this.queryParams
      }, `issues_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
