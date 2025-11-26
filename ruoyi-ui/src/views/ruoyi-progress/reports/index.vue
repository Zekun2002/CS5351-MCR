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
      <el-form-item label="报告日期" prop="reportDate">
        <el-date-picker clearable
          v-model="queryParams.reportDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择报告日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="项目进度" prop="progress">
        <el-input
          v-model="queryParams.progress"
          placeholder="请输入项目进度"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="预期完成日期" prop="expectedEndDate">
        <el-date-picker clearable
          v-model="queryParams.expectedEndDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择预期完成日期">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="实际完成日期" prop="actualEndDate">
        <el-date-picker clearable
          v-model="queryParams.actualEndDate"
          type="date"
          value-format="yyyy-MM-dd"
          placeholder="请选择实际完成日期">
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
          v-hasPermi="['ruoyi-progress:reports:add']"
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
          v-hasPermi="['ruoyi-progress:reports:edit']"
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
          v-hasPermi="['ruoyi-progress:reports:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['ruoyi-progress:reports:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="reportsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="进度报告id" align="center" prop="reportId" />
      <el-table-column label="项目id" align="center" prop="projectId" />
      <el-table-column label="报告日期" align="center" prop="reportDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.reportDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <!-- <el-table-column label="项目进度" align="center" prop="progress" /> -->
      <el-table-column label="项目进度" align="center" prop="progress" width="180">
        <!-- <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expectedEndDate, '{y}-{m}-{d}') }}</span>
        </template> -->
        <template slot-scope="scope">
          <el-progress :text-inside="true" :stroke-width="26" :percentage="scope.row.progress"></el-progress>
        </template>
      </el-table-column>
      <el-table-column label="预期完成日期" align="center" prop="expectedEndDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.expectedEndDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="实际完成日期" align="center" prop="actualEndDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.actualEndDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['ruoyi-progress:reports:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['ruoyi-progress:reports:remove']"
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

    <!-- 添加或修改进度报告表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="项目id" prop="projectId">
          <el-input v-model="form.projectId" placeholder="请输入项目id" />
        </el-form-item>
        <el-form-item label="报告日期" prop="reportDate">
          <el-date-picker clearable
            v-model="form.reportDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择报告日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="项目进度" prop="progress">
          <template>
            <div class="block">
              <el-slider v-model="form.progress" show-input></el-slider>
            </div>
          </template>
          <!-- <el-input v-model="form.progress" placeholder="请输入项目进度" /> -->
        </el-form-item>
        <el-form-item label="预期完成日期" prop="expectedEndDate">
          <el-date-picker clearable
            v-model="form.expectedEndDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择预期完成日期">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="实际完成日期" prop="actualEndDate">
          <el-date-picker clearable
            v-model="form.actualEndDate"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="请选择实际完成日期">
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
import { listReports, getReports, delReports, addReports, updateReports } from "@/api/ruoyi-progress/reports";

export default {
  name: "Reports",
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
      // 进度报告表表格数据
      reportsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
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
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
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
      this.form.progress = 0
      this.open = true;
      this.title = "添加进度报告表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const reportId = row.reportId || this.ids
      getReports(reportId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改进度报告表";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.reportId != null) {
            updateReports(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addReports(this.form).then(response => {
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
      const reportIds = row.reportId || this.ids;
      this.$modal.confirm('是否确认删除进度报告表编号为"' + reportIds + '"的数据项？').then(function() {
        return delReports(reportIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
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
