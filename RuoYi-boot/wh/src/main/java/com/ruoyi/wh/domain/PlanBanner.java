package com.ruoyi.wh.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 计划轮播图对象 wh_plan_banner
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Data
@TableName("wh_plan_banner")
public class PlanBanner extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 轮播图表id */
    private Long id;

    /** 计划id */
    @Excel(name = "计划id")
    private Long planId;

    /** 轮播图地址 */
    @Excel(name = "轮播图地址")
    private String banner;

    /** 排序码 */
    @Excel(name = "排序码")
    private Integer orderNo;

}
