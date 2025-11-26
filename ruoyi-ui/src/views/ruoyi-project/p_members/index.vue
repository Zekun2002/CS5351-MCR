<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="项目id" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="请输入项目id"
          clearable
          @keyup.enter.native="handleQuery"
        />


      </el-form-item>
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户角色" prop="role">
        <el-input
          v-model="queryParams.role"
          placeholder="请输入用户角色"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="用户加入项目时间" prop="joinedAt">
        <el-date-picker clearable
          v-model="queryParams.joinedAt"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择用户加入项目时间">
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
          v-hasPermi="['ruoyi-project:p_members:add']"
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
          v-hasPermi="['ruoyi-project:p_members:edit']"
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
          v-hasPermi="['ruoyi-project:p_members:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ruoyi-project:p_members:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="p_membersList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="成员id" align="center" prop="memberId" />
      <el-table-column label="项目id" align="center" prop="projectId" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="用户角色" align="center" prop="role" />
      <el-table-column label="用户加入项目时间" align="center" prop="joinedAt" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.joinedAt, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['ruoyi-project:p_members:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ruoyi-project:p_members:remove']"
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

    <!-- 添加或修改项目成员管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">

        <el-form-item label="项目id" prop="projectId">
<!--          <el-input v-model="form.projectId" placeholder="请输入项目id" />-->

          <el-select v-model="form.projectId" placeholder="请输入项目id" >
            <el-option
              v-for="item in projectIds"
              :key="item.projectId"
              :label="item.projectName"
              :value="item.projectId">
            </el-option>
          </el-select>
        </el-form-item>


        <el-form-item label="用户" prop="userId">
          <el-select v-model="form.userId" placeholder="请选择用户" clearable filterable>
            <el-option
              v-for="item in userList"
              :key="item.userId"
              :label="item.username + ' (ID: ' + item.userId + ')'"
              :value="item.userId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="用户角色" prop="role">
          <el-input v-model="form.role" placeholder="请输入用户角色" />
        </el-form-item>
        <el-form-item label="用户加入项目时间" prop="joinedAt">
          <el-date-picker clearable
            v-model="form.joinedAt"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择用户加入项目时间">
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
import { listP_members, getP_members, delP_members, addP_members, updateP_members } from "@/api/ruoyi-project/p_members";
import { listProject } from "@/api/ruoyi-project/project";
import { listUsers } from "@/api/system/users";

export default {
  name: "P_members",
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
      // 项目成员管理表格数据
      p_membersList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 项目列表（用于下拉选择）
      projectIds: [],
      // 用户列表（用于下拉选择）
      userList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectId: null,
        userId: null,
        role: null,
        joinedAt: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        projectId: [
          { required: true, message: "项目不能为空", trigger: "change" }
        ],
        userId: [
          { required: true, message: "用户不能为空", trigger: "change" }
        ],
        role: [
          { required: true, message: "用户角色不能为空", trigger: "blur" }
        ],
        joinedAt: [
          { required: true, message: "加入时间不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.loadProjectList();
    this.loadUserList();
  },
  methods: {
    /** 查询项目成员管理列表 */
    getList() {
      this.loading = true;
      listP_members(this.queryParams).then(response => {
        this.p_membersList = response.rows;
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
        memberId: null,
        projectId: null,
        userId: null,
        role: null,
        joinedAt: null
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
      this.ids = selection.map(item => item.memberId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 加载项目列表 */
    loadProjectList() {
      listProject({}).then(response => {
        this.projectIds = response.rows || [];
      });
    },
    /** 加载用户列表 */
    loadUserList() {
      listUsers({}).then(response => {
        this.userList = response.rows || [];
      });
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.loadProjectList();
      this.loadUserList();
      // 设置默认加入时间为当前时间
      const now = new Date();
      this.form.joinedAt = this.parseTime(now, '{y}-{m}-{d}');
      this.open = true;
      this.title = "添加项目成员管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.loadProjectList();
      this.loadUserList();
      const memberId = row.memberId || this.ids
      getP_members(memberId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改项目成员管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.memberId != null) {
            updateP_members(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addP_members(this.form).then(response => {
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
      const memberIds = row.memberId || this.ids;
      this.$modal.confirm('是否确认删除项目成员管理编号为"' + memberIds + '"的数据项？').then(function() {
        return delP_members(memberIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('ruoyi-project/p_members/export', {
        ...this.queryParams
      }, `p_members_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
