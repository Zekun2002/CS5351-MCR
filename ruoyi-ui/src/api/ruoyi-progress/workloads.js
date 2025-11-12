import request from '@/utils/request'

// 查询工作量管理列表
export function listWorkloads(query) {
  return request({
    url: '/ruoyi-progress/workloads/list',
    method: 'get',
    params: query
  })
}

// 查询工作量管理详细
export function getWorkloads(reportId) {
  return request({
    url: '/ruoyi-progress/workloads/' + reportId,
    method: 'get'
  })
}

// 新增工作量管理
export function addWorkloads(data) {
  return request({
    url: '/ruoyi-progress/workloads',
    method: 'post',
    data: data
  })
}

// 修改工作量管理
export function updateWorkloads(data) {
  return request({
    url: '/ruoyi-progress/workloads',
    method: 'put',
    data: data
  })
}

// 删除工作量管理
export function delWorkloads(reportId) {
  return request({
    url: '/ruoyi-progress/workloads/' + reportId,
    method: 'delete'
  })
}
