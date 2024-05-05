package com.ruoyi.wh.service;

import java.util.List;
import com.ruoyi.wh.domain.TravelDate;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 出行日期Service接口
 * 
 * @author fyh
 * @date 2024-05-01
 */
public interface ITravelDateService extends IService<TravelDate>
{
    /**
     * 查询出行日期
     * 
     * @param id 出行日期主键
     * @return 出行日期
     */
    public TravelDate selectTravelDateById(Long id);

    /**
     * 查询出行日期列表
     * 
     * @param travelDate 出行日期
     * @return 出行日期集合
     */
    public List<TravelDate> selectTravelDateList(TravelDate travelDate);

    /**
     * 新增出行日期
     * 
     * @param travelDate 出行日期
     * @return 结果
     */
    public int insertTravelDate(TravelDate travelDate);

    /**
     * 修改出行日期
     * 
     * @param travelDate 出行日期
     * @return 结果
     */
    public int updateTravelDate(TravelDate travelDate);

    /**
     * 批量删除出行日期
     * 
     * @param ids 需要删除的出行日期主键集合
     * @return 结果
     */
    public int deleteTravelDateByIds(Long[] ids);

    /**
     * 删除出行日期信息
     * 
     * @param id 出行日期主键
     * @return 结果
     */
    public int deleteTravelDateById(Long id);
}
