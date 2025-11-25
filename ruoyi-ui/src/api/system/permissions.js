import request from '@/utils/request'

// 查询角色权限列表
export function listPermissions(query) {
  return request({
    url: '/system/permissions/list',
    method: 'get',
    params: query
  })
}

// 查询角色权限详细
export function getPermissions(roleId) {
  return request({
    url: '/system/permissions/' + roleId,
    method: 'get'
  })
}

// 新增角色权限
export function addPermissions(data) {
  return request({
    url: '/system/permissions',
    method: 'post',
    data: data
  })
}

// 修改角色权限
export function updatePermissions(data) {
  return request({
    url: '/system/permissions',
    method: 'put',
    data: data
  })
}

// 删除角色权限
export function delPermissions(roleId) {
  return request({
    url: '/system/permissions/' + roleId,
    method: 'delete'
  })
}
