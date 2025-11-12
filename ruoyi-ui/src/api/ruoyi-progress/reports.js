import request from '@/utils/request'

// 查询进度报告表列表
export function listReports(query) {
  return request({
    url: '/ruoyi-progress/reports/list',
    method: 'get',
    params: query
  })
}

// 查询进度报告表详细
export function getReports(reportId) {
  return request({
    url: '/ruoyi-progress/reports/' + reportId,
    method: 'get'
  })
}

// 新增进度报告表
export function addReports(data) {
  return request({
    url: '/ruoyi-progress/reports',
    method: 'post',
    data: data
  })
}

// 修改进度报告表
export function updateReports(data) {
  return request({
    url: '/ruoyi-progress/reports',
    method: 'put',
    data: data
  })
}

// 删除进度报告表
export function delReports(reportId) {
  return request({
    url: '/ruoyi-progress/reports/' + reportId,
    method: 'delete'
  })
}
