import request from '@/utils/request'

// 查询会员报名列表
export function listUp(query) {
  return request({
    url: '/wh/up/list',
    method: 'get',
    params: query
  })
}

// 查询会员报名详细
export function getUp(id) {
  return request({
    url: '/wh/up/' + id,
    method: 'get'
  })
}

// 新增会员报名
export function addUp(data) {
  return request({
    url: '/wh/up',
    method: 'post',
    data: data
  })
}

// 修改会员报名
export function updateUp(data) {
  return request({
    url: '/wh/up',
    method: 'put',
    data: data
  })
}

// 删除会员报名
export function delUp(id) {
  return request({
    url: '/wh/up/' + id,
    method: 'delete'
  })
}
