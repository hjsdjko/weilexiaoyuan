package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 代跑订单
 *
 * @author 
 * @email
 */
@TableName("daipiao_order")
public class DaipiaoOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DaipiaoOrderEntity() {

	}

	public DaipiaoOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @ColumnInfo(comment="订单号",type="varchar(200)")
    @TableField(value = "daipiao_order_uuid_number")

    private String daipiaoOrderUuidNumber;


    /**
     * 代跑
     */
    @ColumnInfo(comment="代跑",type="int(11)")
    @TableField(value = "daipiao_id")

    private Integer daipiaoId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 实付价格
     */
    @ColumnInfo(comment="实付价格",type="decimal(10,2)")
    @TableField(value = "daipiao_order_true_price")

    private Double daipiaoOrderTruePrice;


    /**
     * 订单类型
     */
    @ColumnInfo(comment="订单类型",type="int(11)")
    @TableField(value = "daipiao_order_types")

    private Integer daipiaoOrderTypes;


    /**
     * 支付类型
     */
    @ColumnInfo(comment="支付类型",type="int(11)")
    @TableField(value = "daipiao_order_payment_types")

    private Integer daipiaoOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="订单创建时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DaipiaoOrder{" +
            ", id=" + id +
            ", daipiaoOrderUuidNumber=" + daipiaoOrderUuidNumber +
            ", daipiaoId=" + daipiaoId +
            ", yonghuId=" + yonghuId +
            ", daipiaoOrderTruePrice=" + daipiaoOrderTruePrice +
            ", daipiaoOrderTypes=" + daipiaoOrderTypes +
            ", daipiaoOrderPaymentTypes=" + daipiaoOrderPaymentTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
