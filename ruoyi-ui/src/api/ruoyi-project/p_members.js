import request from '@/utils/request'

// 查询项目成员管理列表
export function listP_members(query) {
  return request({
    url: '/ruoyi-project/p_members/list',
    method: 'get',
    params: query
  })
}

// 查询项目成员管理详细
export function getP_members(memberId) {
  return request({
    url: '/ruoyi-project/p_members/' + memberId,
    method: 'get'
  })
}

// 新增项目成员管理
export function addP_members(data) {
  return request({
    url: '/ruoyi-project/p_members',
    method: 'post',
    data: data
  })
}

// 修改项目成员管理
export function updateP_members(data) {
  return request({
    url: '/ruoyi-project/p_members',
    method: 'put',
    data: data
  })
}

// 删除项目成员管理
export function delP_members(memberId) {
  return request({
    url: '/ruoyi-project/p_members/' + memberId,
    method: 'delete'
  })
}
