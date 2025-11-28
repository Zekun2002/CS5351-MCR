import request from '@/utils/request'

// 查询用户角色关联列表
export function listRoles(query) {
  return request({
    url: '/system/roles/list',
    method: 'get',
    params: query
  })
}

// 查询用户角色关联详细
export function getRoles(userRoleId) {
  return request({
    url: '/system/roles/' + userRoleId,
    method: 'get'
  })
}

// 新增用户角色关联
export function addRoles(data) {
  return request({
    url: '/system/roles',
    method: 'post',
    data: data
  })
}

// 修改用户角色关联
export function updateRoles(data) {
  return request({
    url: '/system/roles',
    method: 'put',
    data: data
  })
}

// 删除用户角色关联
export function delRoles(userRoleId) {
  return request({
    url: '/system/roles/' + userRoleId,
    method: 'delete'
  })
}
