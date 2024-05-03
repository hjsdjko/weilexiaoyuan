package com.entity.model;

import com.entity.DaipiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 代跑
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class DaipiaoModel implements Serializable {
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
     * 代跑标题
     */
    private String daipiaoName;


    /**
     * 代跑照片
     */
    private String daipiaoPhoto;


    /**
     * 代跑地点
     */
    private String daipiaoAddress;


    /**
     * 联系人
     */
    private String daipiaoLianxiren;


    /**
     * 联系方式
     */
    private String daipiaoLianxifangshi;


    /**
     * 代跑类型
     */
    private Integer daipiaoTypes;


    /**
     * 代跑金额
     */
    private Double daipiaoNewMoney;


    /**
     * 代跑时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date daipiaoTime;


    /**
     * 代跑内容
     */
    private String daipiaoContent;


    /**
     * 代跑状态
     */
    private Integer daipiaoZhuangtaiTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
