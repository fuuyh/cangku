import request from '@/utils/request'

// 查询计划行程明细列表
export function listDetail(query) {
  return request({
    url: '/wh/detail/list',
    method: 'get',
    params: query
  })
}

// 查询计划行程明细详细
export function getDetail(id) {
  return request({
    url: '/wh/detail/' + id,
    method: 'get'
  })
}

// 新增计划行程明细
export function addDetail(data) {
  return request({
    url: '/wh/detail',
    method: 'post',
    data: data
  })
}

// 修改计划行程明细
export function updateDetail(data) {
  return request({
    url: '/wh/detail',
    method: 'put',
    data: data
  })
}

// 删除计划行程明细
export function delDetail(id) {
  return request({
    url: '/wh/detail/' + id,
    method: 'delete'
  })
}
