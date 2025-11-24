import request from '@/utils/request'

// 查询任务列表
export function listTasks(query) {
  return request({
    url: '/ruoyi-project/tasks/list',
    method: 'get',
    params: query
  })
}

// 查询任务详细
export function getTasks(taskId) {
  return request({
    url: '/ruoyi-project/tasks/' + taskId,
    method: 'get'
  })
}

// 新增任务
export function addTasks(data) {
  return request({
    url: '/ruoyi-project/tasks',
    method: 'post',
    data: data
  })
}

// 修改任务
export function updateTasks(data) {
  return request({
    url: '/ruoyi-project/tasks',
    method: 'put',
    data: data
  })
}

// 删除任务
export function delTasks(taskId) {
  return request({
    url: '/ruoyi-project/tasks/' + taskId,
    method: 'delete'
  })
}
