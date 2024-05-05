package com.ruoyi.wh.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.PlanBannerMapper;
import com.ruoyi.wh.domain.PlanBanner;
import com.ruoyi.wh.service.IPlanBannerService;

/**
 * 计划轮播图Service业务层处理
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Service
public class PlanBannerServiceImpl extends ServiceImpl<PlanBannerMapper,PlanBanner> implements IPlanBannerService
{
    @Autowired
    private PlanBannerMapper planBannerMapper;

    /**
     * 查询计划轮播图
     * 
     * @param id 计划轮播图主键
     * @return 计划轮播图
     */
    @Override
    public PlanBanner selectPlanBannerById(Long id)
    {
        return planBannerMapper.selectPlanBannerById(id);
    }

    /**
     * 查询计划轮播图列表
     * 
     * @param planBanner 计划轮播图
     * @return 计划轮播图
     */
    @Override
    public List<PlanBanner> selectPlanBannerList(PlanBanner planBanner)
    {
        return planBannerMapper.selectPlanBannerList(planBanner);
    }

    /**
     * 新增计划轮播图
     * 
     * @param planBanner 计划轮播图
     * @return 结果
     */
    @Override
    public int insertPlanBanner(PlanBanner planBanner)
    {
        planBanner.setCreateTime(DateUtils.getNowDate());
        return planBannerMapper.insertPlanBanner(planBanner);
    }

    /**
     * 修改计划轮播图
     * 
     * @param planBanner 计划轮播图
     * @return 结果
     */
    @Override
    public int updatePlanBanner(PlanBanner planBanner)
    {
        planBanner.setUpdateTime(DateUtils.getNowDate());
        return planBannerMapper.updatePlanBanner(planBanner);
    }

    /**
     * 批量删除计划轮播图
     * 
     * @param ids 需要删除的计划轮播图主键
     * @return 结果
     */
    @Override
    public int deletePlanBannerByIds(Long[] ids)
    {
        return planBannerMapper.deletePlanBannerByIds(ids);
    }

    /**
     * 删除计划轮播图信息
     * 
     * @param id 计划轮播图主键
     * @return 结果
     */
    @Override
    public int deletePlanBannerById(Long id)
    {
        return planBannerMapper.deletePlanBannerById(id);
    }
}
