import request from '@/utils/request'

// 查询任务成员管理列表
export function listMember(query) {
  return request({
    url: '/software/member/list',
    method: 'get',
    params: query
  })
}

// 查询任务成员管理详细
export function getMember(taskMemberId) {
  return request({
    url: '/software/member/' + taskMemberId,
    method: 'get'
  })
}

// 新增任务成员管理
export function addMember(data) {
  return request({
    url: '/software/member',
    method: 'post',
    data: data
  })
}

// 修改任务成员管理
export function updateMember(data) {
  return request({
    url: '/software/member',
    method: 'put',
    data: data
  })
}

// 删除任务成员管理
export function delMember(taskMemberId) {
  return request({
    url: '/software/member/' + taskMemberId,
    method: 'delete'
  })
}
