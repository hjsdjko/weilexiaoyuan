package com.entity.vo;

import com.entity.DaipiaoOrderEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 代跑订单
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("daipiao_order")
public class DaipiaoOrderVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 订单号
     */

    @TableField(value = "daipiao_order_uuid_number")
    private String daipiaoOrderUuidNumber;


    /**
     * 代跑
     */

    @TableField(value = "daipiao_id")
    private Integer daipiaoId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 实付价格
     */

    @TableField(value = "daipiao_order_true_price")
    private Double daipiaoOrderTruePrice;


    /**
     * 订单类型
     */

    @TableField(value = "daipiao_order_types")
    private Integer daipiaoOrderTypes;


    /**
     * 支付类型
     */

    @TableField(value = "daipiao_order_payment_types")
    private Integer daipiaoOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getDaipiaoOrderUuidNumber() {
        return daipiaoOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setDaipiaoOrderUuidNumber(String daipiaoOrderUuidNumber) {
        this.daipiaoOrderUuidNumber = daipiaoOrderUuidNumber;
    }
    /**
	 * 设置：代跑
	 */
    public Integer getDaipiaoId() {
        return daipiaoId;
    }


    /**
	 * 获取：代跑
	 */

    public void setDaipiaoId(Integer daipiaoId) {
        this.daipiaoId = daipiaoId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getDaipiaoOrderTruePrice() {
        return daipiaoOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setDaipiaoOrderTruePrice(Double daipiaoOrderTruePrice) {
        this.daipiaoOrderTruePrice = daipiaoOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getDaipiaoOrderTypes() {
        return daipiaoOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setDaipiaoOrderTypes(Integer daipiaoOrderTypes) {
        this.daipiaoOrderTypes = daipiaoOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getDaipiaoOrderPaymentTypes() {
        return daipiaoOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setDaipiaoOrderPaymentTypes(Integer daipiaoOrderPaymentTypes) {
        this.daipiaoOrderPaymentTypes = daipiaoOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
