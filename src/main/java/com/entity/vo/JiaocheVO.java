package com.entity.vo;

import com.entity.JiaocheEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 叫车
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoche")
public class JiaocheVO implements Serializable {
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
     * 司机
     */

    @TableField(value = "siji_id")
    private Integer sijiId;


    /**
     * 叫车编号
     */

    @TableField(value = "jiaoche_uuid_number")
    private String jiaocheUuidNumber;


    /**
     * 叫车标题
     */

    @TableField(value = "jiaoche_name")
    private String jiaocheName;


    /**
     * 叫车照片
     */

    @TableField(value = "jiaoche_photo")
    private String jiaochePhoto;


    /**
     * 上车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shangche_time")
    private Date shangcheTime;


    /**
     * 上车地点
     */

    @TableField(value = "jiaoche_address")
    private String jiaocheAddress;


    /**
     * 去往地点
     */

    @TableField(value = "jiaoche_quwang_address")
    private String jiaocheQuwangAddress;


    /**
     * 叫车类型
     */

    @TableField(value = "jiaoche_types")
    private Integer jiaocheTypes;


    /**
     * 出价
     */

    @TableField(value = "jiaoche_new_money")
    private Double jiaocheNewMoney;


    /**
     * 叫车详情
     */

    @TableField(value = "jiaoche_content")
    private String jiaocheContent;


    /**
     * 叫车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 叫车状态
     */

    @TableField(value = "jiaoche_zhuangtai_types")
    private Integer jiaocheZhuangtaiTypes;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：司机
	 */
    public Integer getSijiId() {
        return sijiId;
    }


    /**
	 * 获取：司机
	 */

    public void setSijiId(Integer sijiId) {
        this.sijiId = sijiId;
    }
    /**
	 * 设置：叫车编号
	 */
    public String getJiaocheUuidNumber() {
        return jiaocheUuidNumber;
    }


    /**
	 * 获取：叫车编号
	 */

    public void setJiaocheUuidNumber(String jiaocheUuidNumber) {
        this.jiaocheUuidNumber = jiaocheUuidNumber;
    }
    /**
	 * 设置：叫车标题
	 */
    public String getJiaocheName() {
        return jiaocheName;
    }


    /**
	 * 获取：叫车标题
	 */

    public void setJiaocheName(String jiaocheName) {
        this.jiaocheName = jiaocheName;
    }
    /**
	 * 设置：叫车照片
	 */
    public String getJiaochePhoto() {
        return jiaochePhoto;
    }


    /**
	 * 获取：叫车照片
	 */

    public void setJiaochePhoto(String jiaochePhoto) {
        this.jiaochePhoto = jiaochePhoto;
    }
    /**
	 * 设置：上车时间
	 */
    public Date getShangcheTime() {
        return shangcheTime;
    }


    /**
	 * 获取：上车时间
	 */

    public void setShangcheTime(Date shangcheTime) {
        this.shangcheTime = shangcheTime;
    }
    /**
	 * 设置：上车地点
	 */
    public String getJiaocheAddress() {
        return jiaocheAddress;
    }


    /**
	 * 获取：上车地点
	 */

    public void setJiaocheAddress(String jiaocheAddress) {
        this.jiaocheAddress = jiaocheAddress;
    }
    /**
	 * 设置：去往地点
	 */
    public String getJiaocheQuwangAddress() {
        return jiaocheQuwangAddress;
    }


    /**
	 * 获取：去往地点
	 */

    public void setJiaocheQuwangAddress(String jiaocheQuwangAddress) {
        this.jiaocheQuwangAddress = jiaocheQuwangAddress;
    }
    /**
	 * 设置：叫车类型
	 */
    public Integer getJiaocheTypes() {
        return jiaocheTypes;
    }


    /**
	 * 获取：叫车类型
	 */

    public void setJiaocheTypes(Integer jiaocheTypes) {
        this.jiaocheTypes = jiaocheTypes;
    }
    /**
	 * 设置：出价
	 */
    public Double getJiaocheNewMoney() {
        return jiaocheNewMoney;
    }


    /**
	 * 获取：出价
	 */

    public void setJiaocheNewMoney(Double jiaocheNewMoney) {
        this.jiaocheNewMoney = jiaocheNewMoney;
    }
    /**
	 * 设置：叫车详情
	 */
    public String getJiaocheContent() {
        return jiaocheContent;
    }


    /**
	 * 获取：叫车详情
	 */

    public void setJiaocheContent(String jiaocheContent) {
        this.jiaocheContent = jiaocheContent;
    }
    /**
	 * 设置：叫车时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：叫车时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：叫车状态
	 */
    public Integer getJiaocheZhuangtaiTypes() {
        return jiaocheZhuangtaiTypes;
    }


    /**
	 * 获取：叫车状态
	 */

    public void setJiaocheZhuangtaiTypes(Integer jiaocheZhuangtaiTypes) {
        this.jiaocheZhuangtaiTypes = jiaocheZhuangtaiTypes;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
