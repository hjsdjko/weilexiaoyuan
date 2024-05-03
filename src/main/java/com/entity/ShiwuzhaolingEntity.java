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
 * 失物招领
 *
 * @author 
 * @email
 */
@TableName("shiwuzhaoling")
public class ShiwuzhaolingEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShiwuzhaolingEntity() {

	}

	public ShiwuzhaolingEntity(T t) {
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
     * 物品名称
     */
    @ColumnInfo(comment="物品名称",type="varchar(200)")
    @TableField(value = "shiwuzhaoling_name")

    private String shiwuzhaolingName;


    /**
     * 物品编号
     */
    @ColumnInfo(comment="物品编号",type="varchar(200)")
    @TableField(value = "shiwuzhaoling_uuid_number")

    private String shiwuzhaolingUuidNumber;


    /**
     * 物品照片
     */
    @ColumnInfo(comment="物品照片",type="varchar(200)")
    @TableField(value = "shiwuzhaoling_photo")

    private String shiwuzhaolingPhoto;


    /**
     * 丢失地点/找到地点
     */
    @ColumnInfo(comment="丢失地点/找到地点",type="varchar(200)")
    @TableField(value = "shiwuzhaoling_address")

    private String shiwuzhaolingAddress;


    /**
     * 物品类型
     */
    @ColumnInfo(comment="物品类型",type="int(11)")
    @TableField(value = "shiwuzhaoling_types")

    private Integer shiwuzhaolingTypes;


    /**
     * 具体时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="具体时间",type="timestamp")
    @TableField(value = "jutishijian_time")

    private Date jutishijianTime;


    /**
     * 热度
     */
    @ColumnInfo(comment="热度",type="int(11)")
    @TableField(value = "shiwuzhaoling_clicknum")

    private Integer shiwuzhaolingClicknum;


    /**
     * 详细描述
     */
    @ColumnInfo(comment="详细描述",type="text")
    @TableField(value = "shiwuzhaoling_content")

    private String shiwuzhaolingContent;


    /**
     * 状态
     */
    @ColumnInfo(comment="状态",type="int(11)")
    @TableField(value = "shiwuzhaoling_zhuangtai_types")

    private Integer shiwuzhaolingZhuangtaiTypes;


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
	 * 获取：物品名称
	 */
    public String getShiwuzhaolingName() {
        return shiwuzhaolingName;
    }
    /**
	 * 设置：物品名称
	 */

    public void setShiwuzhaolingName(String shiwuzhaolingName) {
        this.shiwuzhaolingName = shiwuzhaolingName;
    }
    /**
	 * 获取：物品编号
	 */
    public String getShiwuzhaolingUuidNumber() {
        return shiwuzhaolingUuidNumber;
    }
    /**
	 * 设置：物品编号
	 */

    public void setShiwuzhaolingUuidNumber(String shiwuzhaolingUuidNumber) {
        this.shiwuzhaolingUuidNumber = shiwuzhaolingUuidNumber;
    }
    /**
	 * 获取：物品照片
	 */
    public String getShiwuzhaolingPhoto() {
        return shiwuzhaolingPhoto;
    }
    /**
	 * 设置：物品照片
	 */

    public void setShiwuzhaolingPhoto(String shiwuzhaolingPhoto) {
        this.shiwuzhaolingPhoto = shiwuzhaolingPhoto;
    }
    /**
	 * 获取：丢失地点/找到地点
	 */
    public String getShiwuzhaolingAddress() {
        return shiwuzhaolingAddress;
    }
    /**
	 * 设置：丢失地点/找到地点
	 */

    public void setShiwuzhaolingAddress(String shiwuzhaolingAddress) {
        this.shiwuzhaolingAddress = shiwuzhaolingAddress;
    }
    /**
	 * 获取：物品类型
	 */
    public Integer getShiwuzhaolingTypes() {
        return shiwuzhaolingTypes;
    }
    /**
	 * 设置：物品类型
	 */

    public void setShiwuzhaolingTypes(Integer shiwuzhaolingTypes) {
        this.shiwuzhaolingTypes = shiwuzhaolingTypes;
    }
    /**
	 * 获取：具体时间
	 */
    public Date getJutishijianTime() {
        return jutishijianTime;
    }
    /**
	 * 设置：具体时间
	 */

    public void setJutishijianTime(Date jutishijianTime) {
        this.jutishijianTime = jutishijianTime;
    }
    /**
	 * 获取：热度
	 */
    public Integer getShiwuzhaolingClicknum() {
        return shiwuzhaolingClicknum;
    }
    /**
	 * 设置：热度
	 */

    public void setShiwuzhaolingClicknum(Integer shiwuzhaolingClicknum) {
        this.shiwuzhaolingClicknum = shiwuzhaolingClicknum;
    }
    /**
	 * 获取：详细描述
	 */
    public String getShiwuzhaolingContent() {
        return shiwuzhaolingContent;
    }
    /**
	 * 设置：详细描述
	 */

    public void setShiwuzhaolingContent(String shiwuzhaolingContent) {
        this.shiwuzhaolingContent = shiwuzhaolingContent;
    }
    /**
	 * 获取：状态
	 */
    public Integer getShiwuzhaolingZhuangtaiTypes() {
        return shiwuzhaolingZhuangtaiTypes;
    }
    /**
	 * 设置：状态
	 */

    public void setShiwuzhaolingZhuangtaiTypes(Integer shiwuzhaolingZhuangtaiTypes) {
        this.shiwuzhaolingZhuangtaiTypes = shiwuzhaolingZhuangtaiTypes;
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
        return "Shiwuzhaoling{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", shiwuzhaolingName=" + shiwuzhaolingName +
            ", shiwuzhaolingUuidNumber=" + shiwuzhaolingUuidNumber +
            ", shiwuzhaolingPhoto=" + shiwuzhaolingPhoto +
            ", shiwuzhaolingAddress=" + shiwuzhaolingAddress +
            ", shiwuzhaolingTypes=" + shiwuzhaolingTypes +
            ", jutishijianTime=" + DateUtil.convertString(jutishijianTime,"yyyy-MM-dd") +
            ", shiwuzhaolingClicknum=" + shiwuzhaolingClicknum +
            ", shiwuzhaolingContent=" + shiwuzhaolingContent +
            ", shiwuzhaolingZhuangtaiTypes=" + shiwuzhaolingZhuangtaiTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
