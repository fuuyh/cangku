package com.ruoyi.wh.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 计划行程明细对象 wh_journey_detail
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Data
@TableName("wh_journey_detail")
public class JourneyDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 行程明细id */
    private Long id;

    /** 计划id */
    private Long planId;

    /** 路线 */
    @Excel(name = "路线")
    private String route;

    /** 路线描述 */
    @Excel(name = "路线描述")
    private String describe;

    /** 排序码 */
    @Excel(name = "排序码")
    private Integer orderNo;

}
