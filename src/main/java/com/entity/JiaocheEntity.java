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
 * 叫车
 *
 * @author 
 * @email
 */
@TableName("jiaoche")
public class JiaocheEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaocheEntity() {

	}

	public JiaocheEntity(T t) {
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
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 司机
     */
    @ColumnInfo(comment="司机",type="int(11)")
    @TableField(value = "siji_id")

    private Integer sijiId;


    /**
     * 叫车编号
     */
    @ColumnInfo(comment="叫车编号",type="varchar(200)")
    @TableField(value = "jiaoche_uuid_number")

    private String jiaocheUuidNumber;


    /**
     * 叫车标题
     */
    @ColumnInfo(comment="叫车标题",type="varchar(200)")
    @TableField(value = "jiaoche_name")

    private String jiaocheName;


    /**
     * 叫车照片
     */
    @ColumnInfo(comment="叫车照片",type="varchar(200)")
    @TableField(value = "jiaoche_photo")

    private String jiaochePhoto;


    /**
     * 上车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="上车时间",type="timestamp")
    @TableField(value = "shangche_time")

    private Date shangcheTime;


    /**
     * 上车地点
     */
    @ColumnInfo(comment="上车地点",type="varchar(200)")
    @TableField(value = "jiaoche_address")

    private String jiaocheAddress;


    /**
     * 去往地点
     */
    @ColumnInfo(comment="去往地点",type="varchar(200)")
    @TableField(value = "jiaoche_quwang_address")

    private String jiaocheQuwangAddress;


    /**
     * 叫车类型
     */
    @ColumnInfo(comment="叫车类型",type="int(11)")
    @TableField(value = "jiaoche_types")

    private Integer jiaocheTypes;


    /**
     * 出价
     */
    @ColumnInfo(comment="出价",type="decimal(10,2)")
    @TableField(value = "jiaoche_new_money")

    private Double jiaocheNewMoney;


    /**
     * 叫车详情
     */
    @ColumnInfo(comment="叫车详情",type="text")
    @TableField(value = "jiaoche_content")

    private String jiaocheContent;


    /**
     * 叫车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="叫车时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 叫车状态
     */
    @ColumnInfo(comment="叫车状态",type="int(11)")
    @TableField(value = "jiaoche_zhuangtai_types")

    private Integer jiaocheZhuangtaiTypes;


    /**
     * 创建时间   listShow
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
	 * 获取：司机
	 */
    public Integer getSijiId() {
        return sijiId;
    }
    /**
	 * 设置：司机
	 */

    public void setSijiId(Integer sijiId) {
        this.sijiId = sijiId;
    }
    /**
	 * 获取：叫车编号
	 */
    public String getJiaocheUuidNumber() {
        return jiaocheUuidNumber;
    }
    /**
	 * 设置：叫车编号
	 */

    public void setJiaocheUuidNumber(String jiaocheUuidNumber) {
        this.jiaocheUuidNumber = jiaocheUuidNumber;
    }
    /**
	 * 获取：叫车标题
	 */
    public String getJiaocheName() {
        return jiaocheName;
    }
    /**
	 * 设置：叫车标题
	 */

    public void setJiaocheName(String jiaocheName) {
        this.jiaocheName = jiaocheName;
    }
    /**
	 * 获取：叫车照片
	 */
    public String getJiaochePhoto() {
        return jiaochePhoto;
    }
    /**
	 * 设置：叫车照片
	 */

    public void setJiaochePhoto(String jiaochePhoto) {
        this.jiaochePhoto = jiaochePhoto;
    }
    /**
	 * 获取：上车时间
	 */
    public Date getShangcheTime() {
        return shangcheTime;
    }
    /**
	 * 设置：上车时间
	 */

    public void setShangcheTime(Date shangcheTime) {
        this.shangcheTime = shangcheTime;
    }
    /**
	 * 获取：上车地点
	 */
    public String getJiaocheAddress() {
        return jiaocheAddress;
    }
    /**
	 * 设置：上车地点
	 */

    public void setJiaocheAddress(String jiaocheAddress) {
        this.jiaocheAddress = jiaocheAddress;
    }
    /**
	 * 获取：去往地点
	 */
    public String getJiaocheQuwangAddress() {
        return jiaocheQuwangAddress;
    }
    /**
	 * 设置：去往地点
	 */

    public void setJiaocheQuwangAddress(String jiaocheQuwangAddress) {
        this.jiaocheQuwangAddress = jiaocheQuwangAddress;
    }
    /**
	 * 获取：叫车类型
	 */
    public Integer getJiaocheTypes() {
        return jiaocheTypes;
    }
    /**
	 * 设置：叫车类型
	 */

    public void setJiaocheTypes(Integer jiaocheTypes) {
        this.jiaocheTypes = jiaocheTypes;
    }
    /**
	 * 获取：出价
	 */
    public Double getJiaocheNewMoney() {
        return jiaocheNewMoney;
    }
    /**
	 * 设置：出价
	 */

    public void setJiaocheNewMoney(Double jiaocheNewMoney) {
        this.jiaocheNewMoney = jiaocheNewMoney;
    }
    /**
	 * 获取：叫车详情
	 */
    public String getJiaocheContent() {
        return jiaocheContent;
    }
    /**
	 * 设置：叫车详情
	 */

    public void setJiaocheContent(String jiaocheContent) {
        this.jiaocheContent = jiaocheContent;
    }
    /**
	 * 获取：叫车时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：叫车时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：叫车状态
	 */
    public Integer getJiaocheZhuangtaiTypes() {
        return jiaocheZhuangtaiTypes;
    }
    /**
	 * 设置：叫车状态
	 */

    public void setJiaocheZhuangtaiTypes(Integer jiaocheZhuangtaiTypes) {
        this.jiaocheZhuangtaiTypes = jiaocheZhuangtaiTypes;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Jiaoche{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", sijiId=" + sijiId +
            ", jiaocheUuidNumber=" + jiaocheUuidNumber +
            ", jiaocheName=" + jiaocheName +
            ", jiaochePhoto=" + jiaochePhoto +
            ", shangcheTime=" + DateUtil.convertString(shangcheTime,"yyyy-MM-dd") +
            ", jiaocheAddress=" + jiaocheAddress +
            ", jiaocheQuwangAddress=" + jiaocheQuwangAddress +
            ", jiaocheTypes=" + jiaocheTypes +
            ", jiaocheNewMoney=" + jiaocheNewMoney +
            ", jiaocheContent=" + jiaocheContent +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", jiaocheZhuangtaiTypes=" + jiaocheZhuangtaiTypes +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
