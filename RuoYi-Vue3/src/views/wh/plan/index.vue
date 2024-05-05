<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="地区" prop="district">
        <el-input
          v-model="queryParams.district"
          placeholder="请输入地区"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="路线概览" prop="routeOverview">
        <el-input
          v-model="queryParams.routeOverview"
          placeholder="请输入路线概览"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="集合点" prop="rallyPoint">
        <el-input
          v-model="queryParams.rallyPoint"
          placeholder="请输入集合点"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="年龄限制" prop="age">
        <el-input
          v-model="queryParams.age"
          placeholder="请输入年龄限制"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="解散点" prop="breakUpPoint">
        <el-input
          v-model="queryParams.breakUpPoint"
          placeholder="请输入解散点"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['wh:plan:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['wh:plan:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['wh:plan:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['wh:plan:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="planList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="计划id" align="center" prop="id" />
      <el-table-column label="地区" align="center" prop="district" />
      <el-table-column label="景点标题" align="center" prop="scenicSpot" />
      <el-table-column label="景点描述" align="center" prop="scenicSpotDes" />
      <el-table-column label="路线概览" align="center" prop="routeOverview" />
      <el-table-column label="报名状态" align="center" prop="status" />
      <el-table-column label="封面图片地址" align="center" prop="image" width="100">
        <template #default="scope">
          <image-preview :src="scope.row.image" :width="50" :height="50"/>
        </template>
      </el-table-column>
      <el-table-column label="出行天数" align="center" prop="days" />
      <el-table-column label="集合点" align="center" prop="rallyPoint" />
      <el-table-column label="年龄限制" align="center" prop="age" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="解散点" align="center" prop="breakUpPoint" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['wh:plan:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['wh:plan:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改出行计划概览对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="planRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="地区" prop="district">
          <el-input v-model="form.district" placeholder="请输入地区" />
        </el-form-item>
        <el-form-item label="景点标题" prop="scenicSpot">
          <el-input v-model="form.scenicSpot" placeholder="请输入景点标题" />
        </el-form-item>
        <el-form-item label="景点描述" prop="scenicSpotDes">
          <el-input v-model="form.scenicSpotDes" placeholder="请输入景点描述" />
        </el-form-item>
        <el-form-item label="路线概览" prop="routeOverview">
          <el-input v-model="form.routeOverview" placeholder="请输入路线概览" />
        </el-form-item>
        <el-form-item label="封面图片地址" prop="image">
          <image-upload v-model="form.image"/>
        </el-form-item>
        <el-form-item label="出行天数" prop="days">
          <el-input v-model="form.days" placeholder="请输入出行天数" />
        </el-form-item>
        <el-form-item label="集合点" prop="rallyPoint">
          <el-input v-model="form.rallyPoint" placeholder="请输入集合点" />
        </el-form-item>
        <el-form-item label="年龄限制" prop="age">
          <el-input v-model="form.age" placeholder="请输入年龄限制" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="解散点" prop="breakUpPoint">
          <el-input v-model="form.breakUpPoint" placeholder="请输入解散点" />
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Plan">
import { listPlan, getPlan, delPlan, addPlan, updatePlan } from "@/api/wh/plan";

const { proxy } = getCurrentInstance();

const planList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    district: null,
    routeOverview: null,
    status: null,
    rallyPoint: null,
    age: null,
    breakUpPoint: null
  },
  rules: {
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询出行计划概览列表 */
function getList() {
  loading.value = true;
  listPlan(queryParams.value).then(response => {
    planList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    district: null,
    scenicSpot: null,
    scenicSpotDes: null,
    routeOverview: null,
    status: null,
    image: null,
    days: null,
    createBy: null,
    rallyPoint: null,
    createTime: null,
    updateBy: null,
    age: null,
    updateTime: null,
    remark: null,
    breakUpPoint: null
  };
  proxy.resetForm("planRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加出行计划概览";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getPlan(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改出行计划概览";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["planRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updatePlan(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addPlan(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除出行计划概览编号为"' + _ids + '"的数据项？').then(function() {
    return delPlan(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('wh/plan/export', {
    ...queryParams.value
  }, `plan_${new Date().getTime()}.xlsx`)
}

getList();
</script>
