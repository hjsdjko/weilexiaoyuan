package com.entity.vo;

import com.entity.DaipiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 代跑
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("daipiao")
public class DaipiaoVO implements Serializable {
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
     * 代跑标题
     */

    @TableField(value = "daipiao_name")
    private String daipiaoName;


    /**
     * 代跑照片
     */

    @TableField(value = "daipiao_photo")
    private String daipiaoPhoto;


    /**
     * 代跑地点
     */

    @TableField(value = "daipiao_address")
    private String daipiaoAddress;


    /**
     * 联系人
     */

    @TableField(value = "daipiao_lianxiren")
    private String daipiaoLianxiren;


    /**
     * 联系方式
     */

    @TableField(value = "daipiao_lianxifangshi")
    private String daipiaoLianxifangshi;


    /**
     * 代跑类型
     */

    @TableField(value = "daipiao_types")
    private Integer daipiaoTypes;


    /**
     * 代跑金额
     */

    @TableField(value = "daipiao_new_money")
    private Double daipiaoNewMoney;


    /**
     * 代跑时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "daipiao_time")
    private Date daipiaoTime;


    /**
     * 代跑内容
     */

    @TableField(value = "daipiao_content")
    private String daipiaoContent;


    /**
     * 代跑状态
     */

    @TableField(value = "daipiao_zhuangtai_types")
    private Integer daipiaoZhuangtaiTypes;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：代跑标题
	 */
    public String getDaipiaoName() {
        return daipiaoName;
    }


    /**
	 * 获取：代跑标题
	 */

    public void setDaipiaoName(String daipiaoName) {
        this.daipiaoName = daipiaoName;
    }
    /**
	 * 设置：代跑照片
	 */
    public String getDaipiaoPhoto() {
        return daipiaoPhoto;
    }


    /**
	 * 获取：代跑照片
	 */

    public void setDaipiaoPhoto(String daipiaoPhoto) {
        this.daipiaoPhoto = daipiaoPhoto;
    }
    /**
	 * 设置：代跑地点
	 */
    public String getDaipiaoAddress() {
        return daipiaoAddress;
    }


    /**
	 * 获取：代跑地点
	 */

    public void setDaipiaoAddress(String daipiaoAddress) {
        this.daipiaoAddress = daipiaoAddress;
    }
    /**
	 * 设置：联系人
	 */
    public String getDaipiaoLianxiren() {
        return daipiaoLianxiren;
    }


    /**
	 * 获取：联系人
	 */

    public void setDaipiaoLianxiren(String daipiaoLianxiren) {
        this.daipiaoLianxiren = daipiaoLianxiren;
    }
    /**
	 * 设置：联系方式
	 */
    public String getDaipiaoLianxifangshi() {
        return daipiaoLianxifangshi;
    }


    /**
	 * 获取：联系方式
	 */

    public void setDaipiaoLianxifangshi(String daipiaoLianxifangshi) {
        this.daipiaoLianxifangshi = daipiaoLianxifangshi;
    }
    /**
	 * 设置：代跑类型
	 */
    public Integer getDaipiaoTypes() {
        return daipiaoTypes;
    }


    /**
	 * 获取：代跑类型
	 */

    public void setDaipiaoTypes(Integer daipiaoTypes) {
        this.daipiaoTypes = daipiaoTypes;
    }
    /**
	 * 设置：代跑金额
	 */
    public Double getDaipiaoNewMoney() {
        return daipiaoNewMoney;
    }


    /**
	 * 获取：代跑金额
	 */

    public void setDaipiaoNewMoney(Double daipiaoNewMoney) {
        this.daipiaoNewMoney = daipiaoNewMoney;
    }
    /**
	 * 设置：代跑时间
	 */
    public Date getDaipiaoTime() {
        return daipiaoTime;
    }


    /**
	 * 获取：代跑时间
	 */

    public void setDaipiaoTime(Date daipiaoTime) {
        this.daipiaoTime = daipiaoTime;
    }
    /**
	 * 设置：代跑内容
	 */
    public String getDaipiaoContent() {
        return daipiaoContent;
    }


    /**
	 * 获取：代跑内容
	 */

    public void setDaipiaoContent(String daipiaoContent) {
        this.daipiaoContent = daipiaoContent;
    }
    /**
	 * 设置：代跑状态
	 */
    public Integer getDaipiaoZhuangtaiTypes() {
        return daipiaoZhuangtaiTypes;
    }


    /**
	 * 获取：代跑状态
	 */

    public void setDaipiaoZhuangtaiTypes(Integer daipiaoZhuangtaiTypes) {
        this.daipiaoZhuangtaiTypes = daipiaoZhuangtaiTypes;
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
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
