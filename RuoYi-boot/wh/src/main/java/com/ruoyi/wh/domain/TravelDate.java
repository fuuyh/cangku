package com.ruoyi.wh.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出行日期对象 wh_travel_date
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Data
@TableName("wh_travel_date")
public class TravelDate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 明细id */
    private Long id;

    /** 计划id */
    @Excel(name = "计划id")
    private Long planId;

    /** 出行日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "出行日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date datetime;

    /** 计划出行余量 */
    @Excel(name = "计划出行余量")
    private Integer planCount;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

}
