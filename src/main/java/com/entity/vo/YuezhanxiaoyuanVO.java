package com.entity.vo;

import com.entity.YuezhanxiaoyuanEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 约战校园
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuezhanxiaoyuan")
public class YuezhanxiaoyuanVO implements Serializable {
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
     * 约战校园名称
     */

    @TableField(value = "yuezhanxiaoyuan_name")
    private String yuezhanxiaoyuanName;


    /**
     * 约战校园照片
     */

    @TableField(value = "yuezhanxiaoyuan_photo")
    private String yuezhanxiaoyuanPhoto;


    /**
     * 约战时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yuezhan_time")
    private Date yuezhanTime;


    /**
     * 约战地点
     */

    @TableField(value = "yuezhanxiaoyuan_address")
    private String yuezhanxiaoyuanAddress;


    /**
     * 约战校园类型
     */

    @TableField(value = "yuezhanxiaoyuan_types")
    private Integer yuezhanxiaoyuanTypes;


    /**
     * 约战校园热度
     */

    @TableField(value = "yuezhanxiaoyuan_clicknum")
    private Integer yuezhanxiaoyuanClicknum;


    /**
     * 约战内容
     */

    @TableField(value = "yuezhanxiaoyuan_content")
    private String yuezhanxiaoyuanContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "yuezhanxiaoyuan_delete")
    private Integer yuezhanxiaoyuanDelete;


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
	 * 设置：约战校园名称
	 */
    public String getYuezhanxiaoyuanName() {
        return yuezhanxiaoyuanName;
    }


    /**
	 * 获取：约战校园名称
	 */

    public void setYuezhanxiaoyuanName(String yuezhanxiaoyuanName) {
        this.yuezhanxiaoyuanName = yuezhanxiaoyuanName;
    }
    /**
	 * 设置：约战校园照片
	 */
    public String getYuezhanxiaoyuanPhoto() {
        return yuezhanxiaoyuanPhoto;
    }


    /**
	 * 获取：约战校园照片
	 */

    public void setYuezhanxiaoyuanPhoto(String yuezhanxiaoyuanPhoto) {
        this.yuezhanxiaoyuanPhoto = yuezhanxiaoyuanPhoto;
    }
    /**
	 * 设置：约战时间
	 */
    public Date getYuezhanTime() {
        return yuezhanTime;
    }


    /**
	 * 获取：约战时间
	 */

    public void setYuezhanTime(Date yuezhanTime) {
        this.yuezhanTime = yuezhanTime;
    }
    /**
	 * 设置：约战地点
	 */
    public String getYuezhanxiaoyuanAddress() {
        return yuezhanxiaoyuanAddress;
    }


    /**
	 * 获取：约战地点
	 */

    public void setYuezhanxiaoyuanAddress(String yuezhanxiaoyuanAddress) {
        this.yuezhanxiaoyuanAddress = yuezhanxiaoyuanAddress;
    }
    /**
	 * 设置：约战校园类型
	 */
    public Integer getYuezhanxiaoyuanTypes() {
        return yuezhanxiaoyuanTypes;
    }


    /**
	 * 获取：约战校园类型
	 */

    public void setYuezhanxiaoyuanTypes(Integer yuezhanxiaoyuanTypes) {
        this.yuezhanxiaoyuanTypes = yuezhanxiaoyuanTypes;
    }
    /**
	 * 设置：约战校园热度
	 */
    public Integer getYuezhanxiaoyuanClicknum() {
        return yuezhanxiaoyuanClicknum;
    }


    /**
	 * 获取：约战校园热度
	 */

    public void setYuezhanxiaoyuanClicknum(Integer yuezhanxiaoyuanClicknum) {
        this.yuezhanxiaoyuanClicknum = yuezhanxiaoyuanClicknum;
    }
    /**
	 * 设置：约战内容
	 */
    public String getYuezhanxiaoyuanContent() {
        return yuezhanxiaoyuanContent;
    }


    /**
	 * 获取：约战内容
	 */

    public void setYuezhanxiaoyuanContent(String yuezhanxiaoyuanContent) {
        this.yuezhanxiaoyuanContent = yuezhanxiaoyuanContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getYuezhanxiaoyuanDelete() {
        return yuezhanxiaoyuanDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setYuezhanxiaoyuanDelete(Integer yuezhanxiaoyuanDelete) {
        this.yuezhanxiaoyuanDelete = yuezhanxiaoyuanDelete;
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
