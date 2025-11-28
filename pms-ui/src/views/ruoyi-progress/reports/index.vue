<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" >
      <el-form-item label="Project ID" prop="projectId">
        <el-input
          v-model="queryParams.projectId"
          placeholder="Please enter the project ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Report Date" prop="reportDate">
        <el-date-picker clearable
          v-model="queryParams.reportDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Please select the report date">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="Project Progess" prop="progress">
        <el-input
          v-model="queryParams.progress"
          placeholder="Please select the project progess"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="Expected Completion Date" prop="expectedEndDate">
        <el-date-picker clearable
          v-model="queryParams.expectedEndDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Please select the expected completion date">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="Actual Completion Date" prop="actualEndDate">
        <el-date-picker clearable
          v-model="queryParams.actualEndDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="Please select the actual completion date">
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
          v-hasPermi="['ruoyi-progress:reports:add']"
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
          v-hasPermi="['ruoyi-progress:reports:edit']"
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
          v-hasPermi="['ruoyi-progress:reports:remove']"
        >delete</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ruoyi-progress:reports:export']"
        >export</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="reportsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="Progress Report ID" align="center" prop="reportId" />
      <el-table-column label="Project ID" align="center" prop="projectId" />
      <el-table-column label="Report Date" align="center" prop="reportDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.reportDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="项目进度" align="center" prop="progress" /> -->
      <el-table-column label="Project Progress" align="center" prop="progress" width="180">
        <!-- <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expectedEndDate, '{y}-{m}-{d}') }}</span>
        </template> -->
        <template slot-scope="scope">
          <el-progress :text-inside="true" :stroke-width="26" :percentage="scope.row.progress"></el-progress>
        </template>
      </el-table-column>
      <el-table-column label="Expected Completion Date" align="center" prop="expectedEndDate">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expectedEndDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Actual Completion Date" align="center" prop="actualEndDate" >
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.actualEndDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="Operation" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['ruoyi-progress:reports:edit']"
          >update</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ruoyi-progress:reports:remove']"
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

    <!-- 添加或修改进度报告表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="700px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="200px">
        <el-form-item label="Project ID" prop="projectId">
          <el-select v-model="form.projectId" placeholder="Please select a project" clearable>
            <el-option
              v-for="item in projectList"
              :key="item.projectId"
              :label="item.projectName"
              :value="item.projectId">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="Report Date" prop="reportDate">
          <el-date-picker clearable
            v-model="form.reportDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Please select the report date">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="Project Progress" prop="progress">
          <template>
            <div class="block">
              <el-slider v-model="form.progress" show-input :disabled="isDisabled"></el-slider>
            </div>
          </template>
          <!-- <el-input v-model="form.progress" placeholder="请输入项目进度" /> -->
        </el-form-item>
        <el-form-item label="Expected completion date" prop="expectedEndDate">
          <el-date-picker clearable
            v-model="form.expectedEndDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Please select the expected completion date" size="large">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="Actual Completion Date" prop="actualEndDate" v-if="form.progress != null && form.progress >= 100">
          <el-date-picker clearable
            v-model="form.actualEndDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="Please select the actual completion date">
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
import { listReports, getReports, delReports, addReports, updateReports } from "@/api/ruoyi-progress/reports";
import { listProject } from "@/api/ruoyi-project/project";

export default {
  name: "Reports",
  data() {
    // 日期验证函数
    const validateExpectedEndDate = (rule, value, callback) => {
      if (!value) {
        callback();
        return;
      }
      if (this.form.reportDate && value < this.form.reportDate) {
        callback(new Error('预期完成日期不能早于报告日期'));
      } else {
        callback();
      }
    };
    const validateActualEndDate = (rule, value, callback) => {
      if (!value) {
        callback();
        return;
      }
      if (this.form.reportDate && value < this.form.reportDate) {
        callback(new Error('实际完成日期不能早于报告日期'));
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
      // 进度报告表表格数据
      reportsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 项目列表（用于下拉选择）
      projectList: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        projectId: null,
        reportDate: null,
        progress: null,
        expectedEndDate: null,
        actualEndDate: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      },
      // 是否禁用项目进度条
      isDisabled:true
    };
  },
  created() {
    this.getList();
    this.loadProjectList();
  },
  methods: {
    /** 加载项目列表 */
    loadProjectList() {
      listProject({}).then(response => {
        this.projectList = response.rows || [];
      });
    },
    /** 查询进度报告表列表 */
    getList() {
      this.loading = true;
      listReports(this.queryParams).then(response => {
        this.reportsList = response.rows;
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
        reportId: null,
        projectId: null,
        reportDate: null,
        progress: null,
        expectedEndDate: null,
        actualEndDate: null
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
      this.ids = selection.map(item => item.reportId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.loadProjectList();
      this.isDisabled = true
      this.form.progress = 0
      // 设置默认报告日期为当前时间
      const now = new Date();
      this.form.reportDate = this.parseTime(now, '{y}-{m}-{d}');
      this.open = true;
      this.title = "Add Progress Reoprt Table";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      this.loadProjectList();
      this.isDisabled = false
      const reportId = row.reportId || this.ids
      getReports(reportId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "Update Progress Reoprt Table";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          // 如果进度未达到100%，清空实际完成日期
          if (this.form.progress == null || this.form.progress < 100) {
            this.form.actualEndDate = null;
          }
          if (this.form.reportId != null) {
            updateReports(this.form).then(response => {
              this.$modal.msgSuccess("Successfully modified");
              this.open = false;
              this.getList();
            });
          } else {
            addReports(this.form).then(response => {
              this.$modal.msgSuccess("Successfully added");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const reportIds = row.reportId || this.ids;
      this.$modal.confirm('Are you sure you want to delete the data entry with progress report ID ' + reportIds).then(function() {
        return delReports(reportIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("Successfully deleted");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('ruoyi-progress/reports/export', {
        ...this.queryParams
      }, `reports_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
