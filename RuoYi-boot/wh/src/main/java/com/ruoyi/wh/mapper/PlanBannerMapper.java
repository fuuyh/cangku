package com.ruoyi.wh.mapper;

import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruoyi.wh.domain.PlanBanner;

/**
 * 计划轮播图Mapper接口
 * 
 * @author fyh
 * @date 2024-05-01
 */
public interface PlanBannerMapper extends BaseMapper<PlanBanner>
{
    /**
     * 查询计划轮播图
     * 
     * @param id 计划轮播图主键
     * @return 计划轮播图
     */
    public PlanBanner selectPlanBannerById(Long id);

    /**
     * 查询计划轮播图列表
     * 
     * @param planBanner 计划轮播图
     * @return 计划轮播图集合
     */
    public List<PlanBanner> selectPlanBannerList(PlanBanner planBanner);

    /**
     * 新增计划轮播图
     * 
     * @param planBanner 计划轮播图
     * @return 结果
     */
    public int insertPlanBanner(PlanBanner planBanner);

    /**
     * 修改计划轮播图
     * 
     * @param planBanner 计划轮播图
     * @return 结果
     */
    public int updatePlanBanner(PlanBanner planBanner);

    /**
     * 删除计划轮播图
     * 
     * @param id 计划轮播图主键
     * @return 结果
     */
    public int deletePlanBannerById(Long id);

    /**
     * 批量删除计划轮播图
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePlanBannerByIds(Long[] ids);
}
