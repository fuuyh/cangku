package com.ruoyi.wh.service;

import java.util.List;
import com.ruoyi.wh.domain.JourneyDetail;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 计划行程明细Service接口
 * 
 * @author fyh
 * @date 2024-05-01
 */
public interface IJourneyDetailService extends IService<JourneyDetail>
{
    /**
     * 查询计划行程明细
     * 
     * @param id 计划行程明细主键
     * @return 计划行程明细
     */
    public JourneyDetail selectJourneyDetailById(Long id);

    /**
     * 查询计划行程明细列表
     * 
     * @param journeyDetail 计划行程明细
     * @return 计划行程明细集合
     */
    public List<JourneyDetail> selectJourneyDetailList(JourneyDetail journeyDetail);

    /**
     * 新增计划行程明细
     * 
     * @param journeyDetail 计划行程明细
     * @return 结果
     */
    public int insertJourneyDetail(JourneyDetail journeyDetail);

    /**
     * 修改计划行程明细
     * 
     * @param journeyDetail 计划行程明细
     * @return 结果
     */
    public int updateJourneyDetail(JourneyDetail journeyDetail);

    /**
     * 批量删除计划行程明细
     * 
     * @param ids 需要删除的计划行程明细主键集合
     * @return 结果
     */
    public int deleteJourneyDetailByIds(Long[] ids);

    /**
     * 删除计划行程明细信息
     * 
     * @param id 计划行程明细主键
     * @return 结果
     */
    public int deleteJourneyDetailById(Long id);
}
