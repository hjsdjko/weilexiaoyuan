package com.entity.model;

import com.entity.DaipiaoOrderEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 代跑订单
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DaipiaoOrderModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 订单号
     */
    private String daipiaoOrderUuidNumber;


    /**
     * 代跑
     */
    private Integer daipiaoId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 实付价格
     */
    private Double daipiaoOrderTruePrice;


    /**
     * 订单类型
     */
    private Integer daipiaoOrderTypes;


    /**
     * 支付类型
     */
    private Integer daipiaoOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：订单号
	 */
    public String getDaipiaoOrderUuidNumber() {
        return daipiaoOrderUuidNumber;
    }


    /**
	 * 设置：订单号
	 */
    public void setDaipiaoOrderUuidNumber(String daipiaoOrderUuidNumber) {
        this.daipiaoOrderUuidNumber = daipiaoOrderUuidNumber;
    }
    /**
	 * 获取：代跑
	 */
    public Integer getDaipiaoId() {
        return daipiaoId;
    }


    /**
	 * 设置：代跑
	 */
    public void setDaipiaoId(Integer daipiaoId) {
        this.daipiaoId = daipiaoId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：实付价格
	 */
    public Double getDaipiaoOrderTruePrice() {
        return daipiaoOrderTruePrice;
    }


    /**
	 * 设置：实付价格
	 */
    public void setDaipiaoOrderTruePrice(Double daipiaoOrderTruePrice) {
        this.daipiaoOrderTruePrice = daipiaoOrderTruePrice;
    }
    /**
	 * 获取：订单类型
	 */
    public Integer getDaipiaoOrderTypes() {
        return daipiaoOrderTypes;
    }


    /**
	 * 设置：订单类型
	 */
    public void setDaipiaoOrderTypes(Integer daipiaoOrderTypes) {
        this.daipiaoOrderTypes = daipiaoOrderTypes;
    }
    /**
	 * 获取：支付类型
	 */
    public Integer getDaipiaoOrderPaymentTypes() {
        return daipiaoOrderPaymentTypes;
    }


    /**
	 * 设置：支付类型
	 */
    public void setDaipiaoOrderPaymentTypes(Integer daipiaoOrderPaymentTypes) {
        this.daipiaoOrderPaymentTypes = daipiaoOrderPaymentTypes;
    }
    /**
	 * 获取：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：订单创建时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
