package com.ruoyi.wh.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wh.mapper.JourneyDetailMapper;
import com.ruoyi.wh.domain.JourneyDetail;
import com.ruoyi.wh.service.IJourneyDetailService;

/**
 * 计划行程明细Service业务层处理
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Service
public class JourneyDetailServiceImpl extends ServiceImpl<JourneyDetailMapper,JourneyDetail> implements IJourneyDetailService
{
    @Autowired
    private JourneyDetailMapper journeyDetailMapper;

    /**
     * 查询计划行程明细
     * 
     * @param id 计划行程明细主键
     * @return 计划行程明细
     */
    @Override
    public JourneyDetail selectJourneyDetailById(Long id)
    {
        return journeyDetailMapper.selectJourneyDetailById(id);
    }

    /**
     * 查询计划行程明细列表
     * 
     * @param journeyDetail 计划行程明细
     * @return 计划行程明细
     */
    @Override
    public List<JourneyDetail> selectJourneyDetailList(JourneyDetail journeyDetail)
    {
        return journeyDetailMapper.selectJourneyDetailList(journeyDetail);
    }

    /**
     * 新增计划行程明细
     * 
     * @param journeyDetail 计划行程明细
     * @return 结果
     */
    @Override
    public int insertJourneyDetail(JourneyDetail journeyDetail)
    {
        journeyDetail.setCreateTime(DateUtils.getNowDate());
        return journeyDetailMapper.insertJourneyDetail(journeyDetail);
    }

    /**
     * 修改计划行程明细
     * 
     * @param journeyDetail 计划行程明细
     * @return 结果
     */
    @Override
    public int updateJourneyDetail(JourneyDetail journeyDetail)
    {
        journeyDetail.setUpdateTime(DateUtils.getNowDate());
        return journeyDetailMapper.updateJourneyDetail(journeyDetail);
    }

    /**
     * 批量删除计划行程明细
     * 
     * @param ids 需要删除的计划行程明细主键
     * @return 结果
     */
    @Override
    public int deleteJourneyDetailByIds(Long[] ids)
    {
        return journeyDetailMapper.deleteJourneyDetailByIds(ids);
    }

    /**
     * 删除计划行程明细信息
     * 
     * @param id 计划行程明细主键
     * @return 结果
     */
    @Override
    public int deleteJourneyDetailById(Long id)
    {
        return journeyDetailMapper.deleteJourneyDetailById(id);
    }
}
