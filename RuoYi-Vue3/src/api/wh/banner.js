import request from '@/utils/request'

// 查询计划轮播图列表
export function listBanner(query) {
  return request({
    url: '/wh/banner/list',
    method: 'get',
    params: query
  })
}

// 查询计划轮播图详细
export function getBanner(id) {
  return request({
    url: '/wh/banner/' + id,
    method: 'get'
  })
}

// 新增计划轮播图
export function addBanner(data) {
  return request({
    url: '/wh/banner',
    method: 'post',
    data: data
  })
}

// 修改计划轮播图
export function updateBanner(data) {
  return request({
    url: '/wh/banner',
    method: 'put',
    data: data
  })
}

// 删除计划轮播图
export function delBanner(id) {
  return request({
    url: '/wh/banner/' + id,
    method: 'delete'
  })
}
