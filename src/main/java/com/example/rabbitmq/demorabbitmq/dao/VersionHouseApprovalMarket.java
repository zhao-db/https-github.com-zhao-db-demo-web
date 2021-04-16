package com.example.rabbitmq.demorabbitmq.dao;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class VersionHouseApprovalMarket implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 版本code
     */
    private Long versionCode;

    /**
     * 周边配套
     */
    private String prjPeripheral;

    /**
     * 原物业缴费方式(0:月付,1:季度,2:年付)
     */
    private Integer paymentMethods;

    /**
     * 原物业费是否预缴(0:否,1:是)
     */
    private Integer isPaymentUpfront;

    /**
     * 前物业公司离场如何处理
     */
    private String oldCompanyLeaveDoInfor;

    /**
     * 新项目首次交付时间
     */
    private Date newPrjFirstHandoverTime;

    /**
     * 老项目首次交付时间
     */
    private Date oldPrjFirstHandoverTime;

    /**
     * 老项目末次交付时间
     */
    private Date oldPrjEndHandoverTime;

    /**
     * 项目描述
     */
    private String prjDescribe;

    /**
     * 能耗公摊(0:元/方/月,1:元/户/月)
     */
    private Integer energySharedUnit;

    /**
     * 电梯公摊(0:元/方/月,1:元/户/月)
     */
    private Integer watereleSharedUnit;

    /**
     * 维修公摊(0:元/方/月,1:元/户/月)
     */
    private Integer repareSharedUnit;

    /**
     * 项目物业费原收费率
     */
    private BigDecimal prjOldFeeRate;

    /**
     * 区位类型(0:CBD,1:高新科技园,2:工厂区,3:大学城,4:城市远郊,5:城区)
     */
    private String locType;

    /**
     * 业主群体情况
     */
    private String runningInfoOwner;

    /**
     * 专项维修基金有无
     */
    private String runningInfoSpecialFunds;

    /**
     * 项目公共收益情况描述
     */
    private String runningInfoPubEarnings;

    /**
     * 其他配套建筑面积(m²)
     */
    private BigDecimal prjConPlanOtherArea;

    /**
     * 规划商业建筑面积(m²)
     */
    private BigDecimal prjConPlanBusinessArea;

    /**
     * 规划住宅建筑面积(m²)
     */
    private BigDecimal prjConPlanBuildingArea;

    /**
     * 规划公共建筑面积(m²)
     */
    private BigDecimal prjConPlanPubArea;

    /**
     * 地上建筑面积(m²)
     */
    private BigDecimal prjConOnfloorArea;

    /**
     * 地下停车建筑面积(m²)
     */
    private BigDecimal prjConPlanUndparkingArea;

    /**
     * 地下人防建筑面积(m²)
     */
    private BigDecimal prjConPlanUnddefenArea;

    /**
     * 地下建筑面积(m²)
     */
    private BigDecimal prjConPlanUndergroundArea;

    /**
     * 总建筑面积(m²)
     */
    private BigDecimal prjConTotalArea;

    /**
     * 规划净用地面积(m²)
     */
    private BigDecimal prjConPlanLandArea;

    /**
     * 容积率
     */
    private BigDecimal prjConPlotRatio;

    /**
     * 创建人账号
     */
    private String createUserAccount;

    /**
     * 修改人账号
     */
    private String updateUserAccount;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 二手-预计接管时间
     */
    private Date exceptedTakeOverTime;


    /**
     * 预计接管时间
     */
    private Integer yn;


}