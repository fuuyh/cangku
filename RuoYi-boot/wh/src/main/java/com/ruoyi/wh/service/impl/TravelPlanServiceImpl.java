package com.ruoyi.wh.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.TravelPlanMapper;
import com.ruoyi.wh.domain.TravelPlan;
import com.ruoyi.wh.service.ITravelPlanService;

/**
 * 出行计划概览Service业务层处理
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Service
public class TravelPlanServiceImpl extends ServiceImpl<TravelPlanMapper,TravelPlan> implements ITravelPlanService
{
    @Autowired
    private TravelPlanMapper travelPlanMapper;

    /**
     * 查询出行计划概览
     * 
     * @param id 出行计划概览主键
     * @return 出行计划概览
     */
    @Override
    public TravelPlan selectTravelPlanById(Long id)
    {
        return travelPlanMapper.selectTravelPlanById(id);
    }

    /**
     * 查询出行计划概览列表
     * 
     * @param travelPlan 出行计划概览
     * @return 出行计划概览
     */
    @Override
    public List<TravelPlan> selectTravelPlanList(TravelPlan travelPlan)
    {
        return travelPlanMapper.selectTravelPlanList(travelPlan);
    }

    /**
     * 新增出行计划概览
     * 
     * @param travelPlan 出行计划概览
     * @return 结果
     */
    @Override
    public int insertTravelPlan(TravelPlan travelPlan)
    {
        travelPlan.setCreateTime(DateUtils.getNowDate());
        return travelPlanMapper.insertTravelPlan(travelPlan);
    }

    /**
     * 修改出行计划概览
     * 
     * @param travelPlan 出行计划概览
     * @return 结果
     */
    @Override
    public int updateTravelPlan(TravelPlan travelPlan)
    {
        travelPlan.setUpdateTime(DateUtils.getNowDate());
        return travelPlanMapper.updateTravelPlan(travelPlan);
    }

    /**
     * 批量删除出行计划概览
     * 
     * @param ids 需要删除的出行计划概览主键
     * @return 结果
     */
    @Override
    public int deleteTravelPlanByIds(Long[] ids)
    {
        return travelPlanMapper.deleteTravelPlanByIds(ids);
    }

    /**
     * 删除出行计划概览信息
     * 
     * @param id 出行计划概览主键
     * @return 结果
     */
    @Override
    public int deleteTravelPlanById(Long id)
    {
        return travelPlanMapper.deleteTravelPlanById(id);
    }
}
