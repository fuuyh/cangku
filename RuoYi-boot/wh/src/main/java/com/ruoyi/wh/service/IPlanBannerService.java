package com.ruoyi.wh.service;

import java.util.List;
import com.ruoyi.wh.domain.PlanBanner;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 计划轮播图Service接口
 * 
 * @author fyh
 * @date 2024-05-01
 */
public interface IPlanBannerService extends IService<PlanBanner>
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
     * 批量删除计划轮播图
     * 
     * @param ids 需要删除的计划轮播图主键集合
     * @return 结果
     */
    public int deletePlanBannerByIds(Long[] ids);

    /**
     * 删除计划轮播图信息
     * 
     * @param id 计划轮播图主键
     * @return 结果
     */
    public int deletePlanBannerById(Long id);
}
