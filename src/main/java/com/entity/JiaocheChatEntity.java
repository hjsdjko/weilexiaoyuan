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
 * 用户咨询
 *
 * @author 
 * @email
 */
@TableName("jiaoche_chat")
public class JiaocheChatEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JiaocheChatEntity() {

	}

	public JiaocheChatEntity(T t) {
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
     * 提问人
     */
    @ColumnInfo(comment="提问人",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 回答人
     */
    @ColumnInfo(comment="回答人",type="int(11)")
    @TableField(value = "siji_id")

    private Integer sijiId;


    /**
     * 问题
     */
    @ColumnInfo(comment="问题",type="text")
    @TableField(value = "jiaoche_chat_issue_text")

    private String jiaocheChatIssueText;


    /**
     * 问题时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="问题时间",type="timestamp")
    @TableField(value = "issue_time")

    private Date issueTime;


    /**
     * 回复
     */
    @ColumnInfo(comment="回复",type="text")
    @TableField(value = "jiaoche_chat_reply_text")

    private String jiaocheChatReplyText;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="回复时间",type="timestamp")
    @TableField(value = "reply_time")

    private Date replyTime;


    /**
     * 状态
     */
    @ColumnInfo(comment="状态",type="int(255)")
    @TableField(value = "zhuangtai_types")

    private Integer zhuangtaiTypes;


    /**
     * 数据类型
     */
    @ColumnInfo(comment="数据类型",type="int(11)")
    @TableField(value = "jiaoche_chat_types")

    private Integer jiaocheChatTypes;


    /**
     * 提问时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="提问时间",type="timestamp")
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
	 * 获取：提问人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：提问人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：回答人
	 */
    public Integer getSijiId() {
        return sijiId;
    }
    /**
	 * 设置：回答人
	 */

    public void setSijiId(Integer sijiId) {
        this.sijiId = sijiId;
    }
    /**
	 * 获取：问题
	 */
    public String getJiaocheChatIssueText() {
        return jiaocheChatIssueText;
    }
    /**
	 * 设置：问题
	 */

    public void setJiaocheChatIssueText(String jiaocheChatIssueText) {
        this.jiaocheChatIssueText = jiaocheChatIssueText;
    }
    /**
	 * 获取：问题时间
	 */
    public Date getIssueTime() {
        return issueTime;
    }
    /**
	 * 设置：问题时间
	 */

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }
    /**
	 * 获取：回复
	 */
    public String getJiaocheChatReplyText() {
        return jiaocheChatReplyText;
    }
    /**
	 * 设置：回复
	 */

    public void setJiaocheChatReplyText(String jiaocheChatReplyText) {
        this.jiaocheChatReplyText = jiaocheChatReplyText;
    }
    /**
	 * 获取：回复时间
	 */
    public Date getReplyTime() {
        return replyTime;
    }
    /**
	 * 设置：回复时间
	 */

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
    /**
	 * 获取：状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }
    /**
	 * 设置：状态
	 */

    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
    }
    /**
	 * 获取：数据类型
	 */
    public Integer getJiaocheChatTypes() {
        return jiaocheChatTypes;
    }
    /**
	 * 设置：数据类型
	 */

    public void setJiaocheChatTypes(Integer jiaocheChatTypes) {
        this.jiaocheChatTypes = jiaocheChatTypes;
    }
    /**
	 * 获取：提问时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：提问时间
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
        return "JiaocheChat{" +
            ", id=" + id +
            ", yonghuId=" + yonghuId +
            ", sijiId=" + sijiId +
            ", jiaocheChatIssueText=" + jiaocheChatIssueText +
            ", issueTime=" + DateUtil.convertString(issueTime,"yyyy-MM-dd") +
            ", jiaocheChatReplyText=" + jiaocheChatReplyText +
            ", replyTime=" + DateUtil.convertString(replyTime,"yyyy-MM-dd") +
            ", zhuangtaiTypes=" + zhuangtaiTypes +
            ", jiaocheChatTypes=" + jiaocheChatTypes +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
