import request from '@/utils/request'

// 查询任务成员列表
export function listMembers(query) {
  return request({
    url: '/ruoyi-project/members/list',
    method: 'get',
    params: query
  })
}

// 查询任务成员详细
export function getMembers(taskMemberId) {
  return request({
    url: '/ruoyi-project/members/' + taskMemberId,
    method: 'get'
  })
}

// 新增任务成员
export function addMembers(data) {
  return request({
    url: '/ruoyi-project/members',
    method: 'post',
    data: data
  })
}

// 修改任务成员
export function updateMembers(data) {
  return request({
    url: '/ruoyi-project/members',
    method: 'put',
    data: data
  })
}

// 删除任务成员
export function delMembers(taskMemberId) {
  return request({
    url: '/ruoyi-project/members/' + taskMemberId,
    method: 'delete'
  })
}

export function getConnectionData(){
  return request({
    url: '/ruoyi-project/members/allIds',
    method: 'get'
  })
}
