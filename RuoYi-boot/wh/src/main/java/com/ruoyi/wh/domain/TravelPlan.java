package com.ruoyi.wh.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 出行计划概览对象 wh_travel_plan
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Data
@TableName("wh_travel_plan")
public class TravelPlan extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 计划id */
    private Long id;

    /** 地区 */
    @Excel(name = "地区")
    private String district;

    /** 景点标题 */
    @Excel(name = "景点标题")
    private String scenicSpot;

    /** 景点描述 */
    @Excel(name = "景点描述")
    private String scenicSpotDes;

    /** 路线概览 */
    @Excel(name = "路线概览")
    private String routeOverview;

    /** 报名状态 */
    @Excel(name = "报名状态")
    private String status;

    /** 封面图片地址 */
    @Excel(name = "封面图片地址")
    private String image;

    /** 出行天数 */
    @Excel(name = "出行天数")
    private String days;

    /** 集合点 */
    @Excel(name = "集合点")
    private String rallyPoint;

    /** 年龄限制 */
    @Excel(name = "年龄限制")
    private String age;

    /** 解散点 */
    @Excel(name = "解散点")
    private String breakUpPoint;

}
