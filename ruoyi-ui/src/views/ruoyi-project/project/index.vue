<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目名称" prop="projectName">
        <el-input
          v-model="queryParams.projectName"
          placeholder="请输入项目名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目开始日期" prop="startDate">
        <el-date-picker clearable
          v-model="queryParams.startDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择项目开始日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="项目预计结束日期" prop="endDate">
        <el-date-picker clearable
          v-model="queryParams.endDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择项目预计结束日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="创建者id" prop="createdBy">
        <el-input
          v-model="queryParams.createdBy"
          placeholder="请输入创建者id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="项目创建时间" prop="createdAt">
        <el-date-picker clearable
          v-model="queryParams.createdAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择项目创建时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="项目更新时间" prop="updatedAt">
        <el-date-picker clearable
          v-model="queryParams.updatedAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择项目更新时间">
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
          v-hasPermi="['ruoyi-project:project:add']"
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
          v-hasPermi="['ruoyi-project:project:edit']"
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
          v-hasPermi="['ruoyi-project:project:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ruoyi-project:project:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="projectList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="项目id" align="center" prop="projectId" />
      <el-table-column label="项目名称" align="center" prop="projectName" />
      <el-table-column label="项目描述" align="center" prop="description" />
      <el-table-column label="项目开始日期" align="center" prop="startDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.startDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="项目预计结束日期" align="center" prop="endDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="创建者id" align="center" prop="createdBy" />
      <el-table-column label="项目创建时间" align="center" prop="createdAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createdAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="项目更新时间" align="center" prop="updatedAt" width="180">
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
            v-hasPermi="['ruoyi-project:project:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ruoyi-project:project:remove']"
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

    <!-- 添加或修改项目管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目名称" prop="projectName">
          <el-input v-model="form.projectName" placeholder="请输入项目名称" />
        </el-form-item>
        <el-form-item label="项目描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="项目开始日期" prop="startDate">
          <el-date-picker clearable
            v-model="form.startDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择项目开始日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="项目预计结束日期" prop="endDate">
          <el-date-picker clearable
            v-model="form.endDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择项目预计结束日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="创建者" prop="createdBy">
          <el-select v-model="form.createdBy" placeholder="请选择创建者" clearable filterable>
            <el-option
              v-for="item in userList"
              :key="item.userId"
              :label="item.username + ' (ID: ' + item.userId + ')'"
              :value="item.userId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="项目创建时间" prop="createdAt">
          <el-date-picker clearable
            v-model="form.createdAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择项目创建时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="项目更新时间" prop="updatedAt">
          <el-date-picker clearable
            v-model="form.updatedAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择项目更新时间">
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
import { listProject, getProject, delProject, addProject, updateProject } from "@/api/ruoyi-project/project";
import { listUsers } from "@/api/system/users";

export default {
  name: "Project",
  data() {
    // 日期验证函数
    const validateStartDate = (rule, value, callback) => {
      if (!value) {
        callback();
        return;
      }
      if (this.form.endDate && value > this.form.endDate) {
        callback(new Error('项目开始日期不能晚于预计结束日期'));
      } else {
        callback();
      }
    };
    const validateEndDate = (rule, value, callback) => {
      if (!value) {
        callback();
        return;
      }
      if (this.form.startDate && value < this.form.startDate) {
        callback(new Error('项目预计结束日期不能早于开始日期'));
      } else {
        callback();
      }
    };
    const validateCreatedAt = (rule, value, callback) => {
      if (!value) {
        callback();
        return;
      }
      if (this.form.updatedAt && value > this.form.updatedAt) {
        callback(new Error('项目创建时间不能晚于更新时间'));
      } else {
        callback();
      }
    };
    const validateUpdatedAt = (rule, value, callback) => {
      if (!value) {
        callback();
        return;
      }
      if (this.form.createdAt && value < this.form.createdAt) {
        callback(new Error('项目更新时间不能早于创建时间'));
      } else {
        callback();
      }
    };
    
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
      // 项目管理表格数据
      projectList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 用户列表（用于下拉选择）
      userList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectName: null,
        description: null,
        startDate: null,
        endDate: null,
        createdBy: null,
        createdAt: null,
        updatedAt: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectName: [
          { required: true, message: "项目名称不能为空", trigger: "blur" }
        ],
        startDate: [
          { validator: validateStartDate, trigger: "change" }
        ],
        endDate: [
          { validator: validateEndDate, trigger: "change" }
        ],
        createdAt: [
          { validator: validateCreatedAt, trigger: "change" }
        ],
        updatedAt: [
          { validator: validateUpdatedAt, trigger: "change" }
        ],
        createdBy: [
          { required: true, message: "创建者不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.loadUserList();
  },
  methods: {
    /** 加载用户列表 */
    loadUserList() {
      listUsers({}).then(response => {
        this.userList = response.rows || [];
      });
    },
    /** 查询项目管理列表 */
    getList() {
      this.loading = true;
      listProject(this.queryParams).then(response => {
        this.projectList = response.rows;
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
        projectId: null,
        projectName: null,
        description: null,
        startDate: null,
        endDate: null,
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
      this.ids = selection.map(item => item.projectId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.loadUserList();
      // 设置默认创建时间为当前时间
      const now = new Date();
      this.form.createdAt = this.parseTime(now, '{y}-{m}-{d}');
      this.form.updatedAt = this.parseTime(now, '{y}-{m}-{d}');
      this.open = true;
      this.title = "添加项目管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.loadUserList();
      const projectId = row.projectId || this.ids
      getProject(projectId).then(response => {
        this.form = response.data;
        // 更新时自动设置更新时间为当前时间
        const now = new Date();
        this.form.updatedAt = this.parseTime(now, '{y}-{m}-{d}');
        this.open = true;
        this.title = "修改项目管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.projectId != null) {
            updateProject(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addProject(this.form).then(response => {
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
      const projectIds = row.projectId || this.ids;
      this.$modal.confirm('是否确认删除项目管理编号为"' + projectIds + '"的数据项？').then(function() {
        return delProject(projectIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('ruoyi-project/project/export', {
        ...this.queryParams
      }, `project_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
