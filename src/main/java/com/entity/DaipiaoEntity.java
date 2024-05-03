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
 * 代跑
 *
 * @author 
 * @email
 */
@TableName("daipiao")
public class DaipiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public DaipiaoEntity() {

	}

	public DaipiaoEntity(T t) {
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
     * 代跑标题
     */
    @ColumnInfo(comment="代跑标题",type="varchar(200)")
    @TableField(value = "daipiao_name")

    private String daipiaoName;


    /**
     * 代跑照片
     */
    @ColumnInfo(comment="代跑照片",type="varchar(200)")
    @TableField(value = "daipiao_photo")

    private String daipiaoPhoto;


    /**
     * 代跑地点
     */
    @ColumnInfo(comment="代跑地点",type="varchar(200)")
    @TableField(value = "daipiao_address")

    private String daipiaoAddress;


    /**
     * 联系人
     */
    @ColumnInfo(comment="联系人",type="varchar(200)")
    @TableField(value = "daipiao_lianxiren")

    private String daipiaoLianxiren;


    /**
     * 联系方式
     */
    @ColumnInfo(comment="联系方式",type="varchar(200)")
    @TableField(value = "daipiao_lianxifangshi")

    private String daipiaoLianxifangshi;


    /**
     * 代跑类型
     */
    @ColumnInfo(comment="代跑类型",type="int(11)")
    @TableField(value = "daipiao_types")

    private Integer daipiaoTypes;


    /**
     * 代跑金额
     */
    @ColumnInfo(comment="代跑金额",type="decimal(10,2)")
    @TableField(value = "daipiao_new_money")

    private Double daipiaoNewMoney;


    /**
     * 代跑时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="代跑时间",type="timestamp")
    @TableField(value = "daipiao_time")

    private Date daipiaoTime;


    /**
     * 代跑内容
     */
    @ColumnInfo(comment="代跑内容",type="text")
    @TableField(value = "daipiao_content")

    private String daipiaoContent;


    /**
     * 代跑状态
     */
    @ColumnInfo(comment="代跑状态",type="int(11)")
    @TableField(value = "daipiao_zhuangtai_types")

    private Integer daipiaoZhuangtaiTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="录入时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
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
	 * 获取：代跑标题
	 */
    public String getDaipiaoName() {
        return daipiaoName;
    }
    /**
	 * 设置：代跑标题
	 */

    public void setDaipiaoName(String daipiaoName) {
        this.daipiaoName = daipiaoName;
    }
    /**
	 * 获取：代跑照片
	 */
    public String getDaipiaoPhoto() {
        return daipiaoPhoto;
    }
    /**
	 * 设置：代跑照片
	 */

    public void setDaipiaoPhoto(String daipiaoPhoto) {
        this.daipiaoPhoto = daipiaoPhoto;
    }
    /**
	 * 获取：代跑地点
	 */
    public String getDaipiaoAddress() {
        return daipiaoAddress;
    }
    /**
	 * 设置：代跑地点
	 */

    public void setDaipiaoAddress(String daipiaoAddress) {
        this.daipiaoAddress = daipiaoAddress;
    }
    /**
	 * 获取：联系人
	 */
    public String getDaipiaoLianxiren() {
        return daipiaoLianxiren;
    }
    /**
	 * 设置：联系人
	 */

    public void setDaipiaoLianxiren(String daipiaoLianxiren) {
        this.daipiaoLianxiren = daipiaoLianxiren;
    }
    /**
	 * 获取：联系方式
	 */
    public String getDaipiaoLianxifangshi() {
        return daipiaoLianxifangshi;
    }
    /**
	 * 设置：联系方式
	 */

    public void setDaipiaoLianxifangshi(String daipiaoLianxifangshi) {
        this.daipiaoLianxifangshi = daipiaoLianxifangshi;
    }
    /**
	 * 获取：代跑类型
	 */
    public Integer getDaipiaoTypes() {
        return daipiaoTypes;
    }
    /**
	 * 设置：代跑类型
	 */

    public void setDaipiaoTypes(Integer daipiaoTypes) {
        this.daipiaoTypes = daipiaoTypes;
    }
    /**
	 * 获取：代跑金额
	 */
    public Double getDaipiaoNewMoney() {
        return daipiaoNewMoney;
    }
    /**
	 * 设置：代跑金额
	 */

    public void setDaipiaoNewMoney(Double daipiaoNewMoney) {
        this.daipiaoNewMoney = daipiaoNewMoney;
    }
    /**
	 * 获取：代跑时间
	 */
    public Date getDaipiaoTime() {
        return daipiaoTime;
    }
    /**
	 * 设置：代跑时间
	 */

    public void setDaipiaoTime(Date daipiaoTime) {
        this.daipiaoTime = daipiaoTime;
    }
    /**
	 * 获取：代跑内容
	 */
    public String getDaipiaoContent() {
        return daipiaoContent;
    }
    /**
	 * 设置：代跑内容
	 */

    public void setDaipiaoContent(String daipiaoContent) {
        this.daipiaoContent = daipiaoContent;
    }
    /**
	 * 获取：代跑状态
	 */
    public Integer getDaipiaoZhuangtaiTypes() {
        return daipiaoZhuangtaiTypes;
    }
    /**
	 * 设置：代跑状态
	 */

    public void setDaipiaoZhuangtaiTypes(Integer daipiaoZhuangtaiTypes) {
        this.daipiaoZhuangtaiTypes = daipiaoZhuangtaiTypes;
    }
    /**
	 * 获取：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Daipiao{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", daipiaoName=" + daipiaoName +
            ", daipiaoPhoto=" + daipiaoPhoto +
            ", daipiaoAddress=" + daipiaoAddress +
            ", daipiaoLianxiren=" + daipiaoLianxiren +
            ", daipiaoLianxifangshi=" + daipiaoLianxifangshi +
            ", daipiaoTypes=" + daipiaoTypes +
            ", daipiaoNewMoney=" + daipiaoNewMoney +
            ", daipiaoTime=" + DateUtil.convertString(daipiaoTime,"yyyy-MM-dd") +
            ", daipiaoContent=" + daipiaoContent +
            ", daipiaoZhuangtaiTypes=" + daipiaoZhuangtaiTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
