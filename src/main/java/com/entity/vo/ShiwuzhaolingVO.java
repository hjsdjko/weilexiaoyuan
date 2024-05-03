package com.entity.vo;

import com.entity.ShiwuzhaolingEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 失物招领
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shiwuzhaoling")
public class ShiwuzhaolingVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 物品名称
     */

    @TableField(value = "shiwuzhaoling_name")
    private String shiwuzhaolingName;


    /**
     * 物品编号
     */

    @TableField(value = "shiwuzhaoling_uuid_number")
    private String shiwuzhaolingUuidNumber;


    /**
     * 物品照片
     */

    @TableField(value = "shiwuzhaoling_photo")
    private String shiwuzhaolingPhoto;


    /**
     * 丢失地点/找到地点
     */

    @TableField(value = "shiwuzhaoling_address")
    private String shiwuzhaolingAddress;


    /**
     * 物品类型
     */

    @TableField(value = "shiwuzhaoling_types")
    private Integer shiwuzhaolingTypes;


    /**
     * 具体时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jutishijian_time")
    private Date jutishijianTime;


    /**
     * 热度
     */

    @TableField(value = "shiwuzhaoling_clicknum")
    private Integer shiwuzhaolingClicknum;


    /**
     * 详细描述
     */

    @TableField(value = "shiwuzhaoling_content")
    private String shiwuzhaolingContent;


    /**
     * 状态
     */

    @TableField(value = "shiwuzhaoling_zhuangtai_types")
    private Integer shiwuzhaolingZhuangtaiTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 设置：物品名称
	 */
    public String getShiwuzhaolingName() {
        return shiwuzhaolingName;
    }


    /**
	 * 获取：物品名称
	 */

    public void setShiwuzhaolingName(String shiwuzhaolingName) {
        this.shiwuzhaolingName = shiwuzhaolingName;
    }
    /**
	 * 设置：物品编号
	 */
    public String getShiwuzhaolingUuidNumber() {
        return shiwuzhaolingUuidNumber;
    }


    /**
	 * 获取：物品编号
	 */

    public void setShiwuzhaolingUuidNumber(String shiwuzhaolingUuidNumber) {
        this.shiwuzhaolingUuidNumber = shiwuzhaolingUuidNumber;
    }
    /**
	 * 设置：物品照片
	 */
    public String getShiwuzhaolingPhoto() {
        return shiwuzhaolingPhoto;
    }


    /**
	 * 获取：物品照片
	 */

    public void setShiwuzhaolingPhoto(String shiwuzhaolingPhoto) {
        this.shiwuzhaolingPhoto = shiwuzhaolingPhoto;
    }
    /**
	 * 设置：丢失地点/找到地点
	 */
    public String getShiwuzhaolingAddress() {
        return shiwuzhaolingAddress;
    }


    /**
	 * 获取：丢失地点/找到地点
	 */

    public void setShiwuzhaolingAddress(String shiwuzhaolingAddress) {
        this.shiwuzhaolingAddress = shiwuzhaolingAddress;
    }
    /**
	 * 设置：物品类型
	 */
    public Integer getShiwuzhaolingTypes() {
        return shiwuzhaolingTypes;
    }


    /**
	 * 获取：物品类型
	 */

    public void setShiwuzhaolingTypes(Integer shiwuzhaolingTypes) {
        this.shiwuzhaolingTypes = shiwuzhaolingTypes;
    }
    /**
	 * 设置：具体时间
	 */
    public Date getJutishijianTime() {
        return jutishijianTime;
    }


    /**
	 * 获取：具体时间
	 */

    public void setJutishijianTime(Date jutishijianTime) {
        this.jutishijianTime = jutishijianTime;
    }
    /**
	 * 设置：热度
	 */
    public Integer getShiwuzhaolingClicknum() {
        return shiwuzhaolingClicknum;
    }


    /**
	 * 获取：热度
	 */

    public void setShiwuzhaolingClicknum(Integer shiwuzhaolingClicknum) {
        this.shiwuzhaolingClicknum = shiwuzhaolingClicknum;
    }
    /**
	 * 设置：详细描述
	 */
    public String getShiwuzhaolingContent() {
        return shiwuzhaolingContent;
    }


    /**
	 * 获取：详细描述
	 */

    public void setShiwuzhaolingContent(String shiwuzhaolingContent) {
        this.shiwuzhaolingContent = shiwuzhaolingContent;
    }
    /**
	 * 设置：状态
	 */
    public Integer getShiwuzhaolingZhuangtaiTypes() {
        return shiwuzhaolingZhuangtaiTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setShiwuzhaolingZhuangtaiTypes(Integer shiwuzhaolingZhuangtaiTypes) {
        this.shiwuzhaolingZhuangtaiTypes = shiwuzhaolingZhuangtaiTypes;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
