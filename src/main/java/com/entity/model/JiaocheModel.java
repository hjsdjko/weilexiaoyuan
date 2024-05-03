package com.entity.model;

import com.entity.JiaocheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 叫车
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JiaocheModel implements Serializable {
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
     * 司机
     */
    private Integer sijiId;


    /**
     * 叫车编号
     */
    private String jiaocheUuidNumber;


    /**
     * 叫车标题
     */
    private String jiaocheName;


    /**
     * 叫车照片
     */
    private String jiaochePhoto;


    /**
     * 上车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shangcheTime;


    /**
     * 上车地点
     */
    private String jiaocheAddress;


    /**
     * 去往地点
     */
    private String jiaocheQuwangAddress;


    /**
     * 叫车类型
     */
    private Integer jiaocheTypes;


    /**
     * 出价
     */
    private Double jiaocheNewMoney;


    /**
     * 叫车详情
     */
    private String jiaocheContent;


    /**
     * 叫车时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 叫车状态
     */
    private Integer jiaocheZhuangtaiTypes;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
