import request from '@/utils/request'

// 查询问题管理列表
export function listIssue(query) {
  return request({
    url: '/software/issue/list',
    method: 'get',
    params: query
  })
}

// 查询问题管理详细
export function getIssue(issueId) {
  return request({
    url: '/software/issue/' + issueId,
    method: 'get'
  })
}

// 新增问题管理
export function addIssue(data) {
  return request({
    url: '/software/issue',
    method: 'post',
    data: data
  })
}

// 修改问题管理
export function updateIssue(data) {
  return request({
    url: '/software/issue',
    method: 'put',
    data: data
  })
}

// 删除问题管理
export function delIssue(issueId) {
  return request({
    url: '/software/issue/' + issueId,
    method: 'delete'
  })
}
