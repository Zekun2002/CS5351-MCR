import request from '@/utils/request'

// 查询问题列表
export function listIssues(query) {
  return request({
    url: '/ruoyi-project/issues/list',
    method: 'get',
    params: query
  })
}

// 查询问题详细
export function getIssues(issueId) {
  return request({
    url: '/ruoyi-project/issues/' + issueId,
    method: 'get'
  })
}

// 新增问题
export function addIssues(data) {
  return request({
    url: '/ruoyi-project/issues',
    method: 'post',
    data: data
  })
}

// 修改问题
export function updateIssues(data) {
  return request({
    url: '/ruoyi-project/issues',
    method: 'put',
    data: data
  })
}

// 删除问题
export function delIssues(issueId) {
  return request({
    url: '/ruoyi-project/issues/' + issueId,
    method: 'delete'
  })
}
