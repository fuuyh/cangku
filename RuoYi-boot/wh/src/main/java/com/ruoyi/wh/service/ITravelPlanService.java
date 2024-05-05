package com.ruoyi.wh.service;

import java.util.List;
import com.ruoyi.wh.domain.TravelPlan;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 出行计划概览Service接口
 * 
 * @author fyh
 * @date 2024-05-01
 */
public interface ITravelPlanService extends IService<TravelPlan>
{
    /**
     * 查询出行计划概览
     * 
     * @param id 出行计划概览主键
     * @return 出行计划概览
     */
    public TravelPlan selectTravelPlanById(Long id);

    /**
     * 查询出行计划概览列表
     * 
     * @param travelPlan 出行计划概览
     * @return 出行计划概览集合
     */
    public List<TravelPlan> selectTravelPlanList(TravelPlan travelPlan);

    /**
     * 新增出行计划概览
     * 
     * @param travelPlan 出行计划概览
     * @return 结果
     */
    public int insertTravelPlan(TravelPlan travelPlan);

    /**
     * 修改出行计划概览
     * 
     * @param travelPlan 出行计划概览
     * @return 结果
     */
    public int updateTravelPlan(TravelPlan travelPlan);

    /**
     * 批量删除出行计划概览
     * 
     * @param ids 需要删除的出行计划概览主键集合
     * @return 结果
     */
    public int deleteTravelPlanByIds(Long[] ids);

    /**
     * 删除出行计划概览信息
     * 
     * @param id 出行计划概览主键
     * @return 结果
     */
    public int deleteTravelPlanById(Long id);
}
