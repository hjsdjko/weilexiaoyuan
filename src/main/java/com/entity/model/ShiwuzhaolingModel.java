package com.entity.model;

import com.entity.ShiwuzhaolingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 失物招领
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShiwuzhaolingModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 物品名称
     */
    private String shiwuzhaolingName;


    /**
     * 物品编号
     */
    private String shiwuzhaolingUuidNumber;


    /**
     * 物品照片
     */
    private String shiwuzhaolingPhoto;


    /**
     * 丢失地点/找到地点
     */
    private String shiwuzhaolingAddress;


    /**
     * 物品类型
     */
    private Integer shiwuzhaolingTypes;


    /**
     * 具体时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jutishijianTime;


    /**
     * 热度
     */
    private Integer shiwuzhaolingClicknum;


    /**
     * 详细描述
     */
    private String shiwuzhaolingContent;


    /**
     * 状态
     */
    private Integer shiwuzhaolingZhuangtaiTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
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
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
