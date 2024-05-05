package com.ruoyi.wh.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.TravelDateMapper;
import com.ruoyi.wh.domain.TravelDate;
import com.ruoyi.wh.service.ITravelDateService;

/**
 * 出行日期Service业务层处理
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Service
public class TravelDateServiceImpl extends ServiceImpl<TravelDateMapper,TravelDate> implements ITravelDateService
{
    @Autowired
    private TravelDateMapper travelDateMapper;

    /**
     * 查询出行日期
     * 
     * @param id 出行日期主键
     * @return 出行日期
     */
    @Override
    public TravelDate selectTravelDateById(Long id)
    {
        return travelDateMapper.selectTravelDateById(id);
    }

    /**
     * 查询出行日期列表
     * 
     * @param travelDate 出行日期
     * @return 出行日期
     */
    @Override
    public List<TravelDate> selectTravelDateList(TravelDate travelDate)
    {
        return travelDateMapper.selectTravelDateList(travelDate);
    }

    /**
     * 新增出行日期
     * 
     * @param travelDate 出行日期
     * @return 结果
     */
    @Override
    public int insertTravelDate(TravelDate travelDate)
    {
        travelDate.setCreateTime(DateUtils.getNowDate());
        return travelDateMapper.insertTravelDate(travelDate);
    }

    /**
     * 修改出行日期
     * 
     * @param travelDate 出行日期
     * @return 结果
     */
    @Override
    public int updateTravelDate(TravelDate travelDate)
    {
        travelDate.setUpdateTime(DateUtils.getNowDate());
        return travelDateMapper.updateTravelDate(travelDate);
    }

    /**
     * 批量删除出行日期
     * 
     * @param ids 需要删除的出行日期主键
     * @return 结果
     */
    @Override
    public int deleteTravelDateByIds(Long[] ids)
    {
        return travelDateMapper.deleteTravelDateByIds(ids);
    }

    /**
     * 删除出行日期信息
     * 
     * @param id 出行日期主键
     * @return 结果
     */
    @Override
    public int deleteTravelDateById(Long id)
    {
        return travelDateMapper.deleteTravelDateById(id);
    }
}
