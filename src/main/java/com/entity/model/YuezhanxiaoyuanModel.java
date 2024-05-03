package com.entity.model;

import com.entity.YuezhanxiaoyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 约战校园
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuezhanxiaoyuanModel implements Serializable {
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
     * 约战校园名称
     */
    private String yuezhanxiaoyuanName;


    /**
     * 约战校园照片
     */
    private String yuezhanxiaoyuanPhoto;


    /**
     * 约战时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuezhanTime;


    /**
     * 约战地点
     */
    private String yuezhanxiaoyuanAddress;


    /**
     * 约战校园类型
     */
    private Integer yuezhanxiaoyuanTypes;


    /**
     * 约战校园热度
     */
    private Integer yuezhanxiaoyuanClicknum;


    /**
     * 约战内容
     */
    private String yuezhanxiaoyuanContent;


    /**
     * 逻辑删除
     */
    private Integer yuezhanxiaoyuanDelete;


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
