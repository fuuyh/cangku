import request from '@/utils/request'

// 查询出行日期列表
export function listDate(query) {
  return request({
    url: '/wh/date/list',
    method: 'get',
    params: query
  })
}

// 查询出行日期详细
export function getDate(id) {
  return request({
    url: '/wh/date/' + id,
    method: 'get'
  })
}

// 新增出行日期
export function addDate(data) {
  return request({
    url: '/wh/date',
    method: 'post',
    data: data
  })
}

// 修改出行日期
export function updateDate(data) {
  return request({
    url: '/wh/date',
    method: 'put',
    data: data
  })
}

// 删除出行日期
export function delDate(id) {
  return request({
    url: '/wh/date/' + id,
    method: 'delete'
  })
}
