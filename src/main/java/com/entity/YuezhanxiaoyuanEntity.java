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
 * 约战校园
 *
 * @author 
 * @email
 */
@TableName("yuezhanxiaoyuan")
public class YuezhanxiaoyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public YuezhanxiaoyuanEntity() {

	}

	public YuezhanxiaoyuanEntity(T t) {
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
     * 约战校园名称
     */
    @ColumnInfo(comment="约战校园名称",type="varchar(200)")
    @TableField(value = "yuezhanxiaoyuan_name")

    private String yuezhanxiaoyuanName;


    /**
     * 约战校园照片
     */
    @ColumnInfo(comment="约战校园照片",type="varchar(200)")
    @TableField(value = "yuezhanxiaoyuan_photo")

    private String yuezhanxiaoyuanPhoto;


    /**
     * 约战时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="约战时间",type="timestamp")
    @TableField(value = "yuezhan_time")

    private Date yuezhanTime;


    /**
     * 约战地点
     */
    @ColumnInfo(comment="约战地点",type="varchar(200)")
    @TableField(value = "yuezhanxiaoyuan_address")

    private String yuezhanxiaoyuanAddress;


    /**
     * 约战校园类型
     */
    @ColumnInfo(comment="约战校园类型",type="int(11)")
    @TableField(value = "yuezhanxiaoyuan_types")

    private Integer yuezhanxiaoyuanTypes;


    /**
     * 约战校园热度
     */
    @ColumnInfo(comment="约战校园热度",type="int(11)")
    @TableField(value = "yuezhanxiaoyuan_clicknum")

    private Integer yuezhanxiaoyuanClicknum;


    /**
     * 约战内容
     */
    @ColumnInfo(comment="约战内容",type="text")
    @TableField(value = "yuezhanxiaoyuan_content")

    private String yuezhanxiaoyuanContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "yuezhanxiaoyuan_delete")

    private Integer yuezhanxiaoyuanDelete;


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
	 * 获取：约战校园名称
	 */
    public String getYuezhanxiaoyuanName() {
        return yuezhanxiaoyuanName;
    }
    /**
	 * 设置：约战校园名称
	 */

    public void setYuezhanxiaoyuanName(String yuezhanxiaoyuanName) {
        this.yuezhanxiaoyuanName = yuezhanxiaoyuanName;
    }
    /**
	 * 获取：约战校园照片
	 */
    public String getYuezhanxiaoyuanPhoto() {
        return yuezhanxiaoyuanPhoto;
    }
    /**
	 * 设置：约战校园照片
	 */

    public void setYuezhanxiaoyuanPhoto(String yuezhanxiaoyuanPhoto) {
        this.yuezhanxiaoyuanPhoto = yuezhanxiaoyuanPhoto;
    }
    /**
	 * 获取：约战时间
	 */
    public Date getYuezhanTime() {
        return yuezhanTime;
    }
    /**
	 * 设置：约战时间
	 */

    public void setYuezhanTime(Date yuezhanTime) {
        this.yuezhanTime = yuezhanTime;
    }
    /**
	 * 获取：约战地点
	 */
    public String getYuezhanxiaoyuanAddress() {
        return yuezhanxiaoyuanAddress;
    }
    /**
	 * 设置：约战地点
	 */

    public void setYuezhanxiaoyuanAddress(String yuezhanxiaoyuanAddress) {
        this.yuezhanxiaoyuanAddress = yuezhanxiaoyuanAddress;
    }
    /**
	 * 获取：约战校园类型
	 */
    public Integer getYuezhanxiaoyuanTypes() {
        return yuezhanxiaoyuanTypes;
    }
    /**
	 * 设置：约战校园类型
	 */

    public void setYuezhanxiaoyuanTypes(Integer yuezhanxiaoyuanTypes) {
        this.yuezhanxiaoyuanTypes = yuezhanxiaoyuanTypes;
    }
    /**
	 * 获取：约战校园热度
	 */
    public Integer getYuezhanxiaoyuanClicknum() {
        return yuezhanxiaoyuanClicknum;
    }
    /**
	 * 设置：约战校园热度
	 */

    public void setYuezhanxiaoyuanClicknum(Integer yuezhanxiaoyuanClicknum) {
        this.yuezhanxiaoyuanClicknum = yuezhanxiaoyuanClicknum;
    }
    /**
	 * 获取：约战内容
	 */
    public String getYuezhanxiaoyuanContent() {
        return yuezhanxiaoyuanContent;
    }
    /**
	 * 设置：约战内容
	 */

    public void setYuezhanxiaoyuanContent(String yuezhanxiaoyuanContent) {
        this.yuezhanxiaoyuanContent = yuezhanxiaoyuanContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getYuezhanxiaoyuanDelete() {
        return yuezhanxiaoyuanDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setYuezhanxiaoyuanDelete(Integer yuezhanxiaoyuanDelete) {
        this.yuezhanxiaoyuanDelete = yuezhanxiaoyuanDelete;
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
        return "Yuezhanxiaoyuan{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", yuezhanxiaoyuanName=" + yuezhanxiaoyuanName +
            ", yuezhanxiaoyuanPhoto=" + yuezhanxiaoyuanPhoto +
            ", yuezhanTime=" + DateUtil.convertString(yuezhanTime,"yyyy-MM-dd") +
            ", yuezhanxiaoyuanAddress=" + yuezhanxiaoyuanAddress +
            ", yuezhanxiaoyuanTypes=" + yuezhanxiaoyuanTypes +
            ", yuezhanxiaoyuanClicknum=" + yuezhanxiaoyuanClicknum +
            ", yuezhanxiaoyuanContent=" + yuezhanxiaoyuanContent +
            ", yuezhanxiaoyuanDelete=" + yuezhanxiaoyuanDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
