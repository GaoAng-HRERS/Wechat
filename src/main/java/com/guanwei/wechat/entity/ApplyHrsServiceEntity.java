package com.guanwei.wechat.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ApplyHRSServiceEntity.
 * @program: wechat
 * @description: ${description}
 * @author: Leborn.Xu
 * @create: 2019-01-22 15:12
 **/
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplyHrsServiceEntity {
    /**
     * 大都会客户唯一编号ID.
     */
    private String customerId;
    /**
     * 客户姓名.
     */
    private String customerName;
    /**
     * 客户类型.
     */
    private String customerRole;
    /**
     * 性别 男1 女2.
     */
    private String gender;
    /**
     * 证件类型Code.
     */
    private String certTypeCode;
    /**
     * 证件号后四位.
     */
    private String rpadFourth;
    /**
     * 保单号.
     */
    private String policyNumber;
    /**
     * 产品名称.
     */
    private String productName;
    /**
     * 产品code.
     */
    private String productCode;
    /**
     * 产品套餐名.
     */
    private String proPackageName;
    /**
     * 产品套餐code.
     */
    private String proPackageCode;

    /**
     * 申请服务名称.
     */
    private String hisServiceName;

    /**
     * 申请服务的code.
     */
    private String hisServiceCode;

    /**
     * 服务状态.
     */
    private String statusMsg;
    /**
     * 服务状态code：01已申请  011待服务 012服务中  02继续服务 03已完成 04已取消.
     */
    private String statusCode;
}
