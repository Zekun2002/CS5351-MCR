import request from '@/utils/request'

// 查询用户信息列表
export function listUsers(query) {
  return request({
    url: '/system/users/list',
    method: 'get',
    params: query
  })
}

// 查询用户信息详细
export function getUsers(userId) {
  return request({
    url: '/system/users/' + userId,
    method: 'get'
  })
}

// 新增用户信息
export function addUsers(data) {
  return request({
    url: '/system/users',
    method: 'post',
    data: data
  })
}

// 修改用户信息
export function updateUsers(data) {
  return request({
    url: '/system/users',
    method: 'put',
    data: data
  })
}

// 删除用户信息
export function delUsers(userId) {
  return request({
    url: '/system/users/' + userId,
    method: 'delete'
  })
}
