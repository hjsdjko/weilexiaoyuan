package com.entity.model;

import com.entity.SijiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 司机
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class SijiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 账户
     */
    private String username;


    /**
     * 密码
     */
    private String password;


    /**
     * 司机姓名
     */
    private String sijiName;


    /**
     * 司机手机号
     */
    private String sijiPhone;


    /**
     * 司机身份证号
     */
    private String sijiIdNumber;


    /**
     * 司机头像
     */
    private String sijiPhoto;


    /**
     * 性别
     */
    private Integer sexTypes;


    /**
     * 余额
     */
    private Double newMoney;


    /**
     * 电子邮箱
     */
    private String sijiEmail;


    /**
     * 创建时间
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
	 * 获取：账户
	 */
    public String getUsername() {
        return username;
    }


    /**
	 * 设置：账户
	 */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
	 * 获取：密码
	 */
    public String getPassword() {
        return password;
    }


    /**
	 * 设置：密码
	 */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
	 * 获取：司机姓名
	 */
    public String getSijiName() {
        return sijiName;
    }


    /**
	 * 设置：司机姓名
	 */
    public void setSijiName(String sijiName) {
        this.sijiName = sijiName;
    }
    /**
	 * 获取：司机手机号
	 */
    public String getSijiPhone() {
        return sijiPhone;
    }


    /**
	 * 设置：司机手机号
	 */
    public void setSijiPhone(String sijiPhone) {
        this.sijiPhone = sijiPhone;
    }
    /**
	 * 获取：司机身份证号
	 */
    public String getSijiIdNumber() {
        return sijiIdNumber;
    }


    /**
	 * 设置：司机身份证号
	 */
    public void setSijiIdNumber(String sijiIdNumber) {
        this.sijiIdNumber = sijiIdNumber;
    }
    /**
	 * 获取：司机头像
	 */
    public String getSijiPhoto() {
        return sijiPhoto;
    }


    /**
	 * 设置：司机头像
	 */
    public void setSijiPhoto(String sijiPhoto) {
        this.sijiPhoto = sijiPhoto;
    }
    /**
	 * 获取：性别
	 */
    public Integer getSexTypes() {
        return sexTypes;
    }


    /**
	 * 设置：性别
	 */
    public void setSexTypes(Integer sexTypes) {
        this.sexTypes = sexTypes;
    }
    /**
	 * 获取：余额
	 */
    public Double getNewMoney() {
        return newMoney;
    }


    /**
	 * 设置：余额
	 */
    public void setNewMoney(Double newMoney) {
        this.newMoney = newMoney;
    }
    /**
	 * 获取：电子邮箱
	 */
    public String getSijiEmail() {
        return sijiEmail;
    }


    /**
	 * 设置：电子邮箱
	 */
    public void setSijiEmail(String sijiEmail) {
        this.sijiEmail = sijiEmail;
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

    }
