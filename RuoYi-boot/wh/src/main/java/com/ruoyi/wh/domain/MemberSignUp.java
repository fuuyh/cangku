package com.ruoyi.wh.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 会员报名对象 wh_member_sign_up
 * 
 * @author fyh
 * @date 2024-05-01
 */
@Data
@TableName("wh_member_sign_up")
public class MemberSignUp extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单id */
    private Long id;

    /** 计划id */
    @Excel(name = "计划id")
    private Long planId;

    /** 计划日期id */
    @Excel(name = "计划日期id")
    private Long planDateId;

    /** 订单状态(0:已完成，1 等待出行) */
    @Excel(name = "订单状态(0:已完成，1 等待出行)")
    private String status;

    /** 支付状态(0 未支付， 1已支付) */
    @Excel(name = "支付状态(0 未支付， 1已支付)")
    private String payStatus;

}
