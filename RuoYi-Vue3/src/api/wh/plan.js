import request from '@/utils/request'

// 查询出行计划概览列表
export function listPlan(query) {
  return request({
    url: '/wh/plan/list',
    method: 'get',
    params: query
  })
}

// 查询出行计划概览详细
export function getPlan(id) {
  return request({
    url: '/wh/plan/' + id,
    method: 'get'
  })
}

// 新增出行计划概览
export function addPlan(data) {
  return request({
    url: '/wh/plan',
    method: 'post',
    data: data
  })
}

// 修改出行计划概览
export function updatePlan(data) {
  return request({
    url: '/wh/plan',
    method: 'put',
    data: data
  })
}

// 删除出行计划概览
export function delPlan(id) {
  return request({
    url: '/wh/plan/' + id,
    method: 'delete'
  })
}
