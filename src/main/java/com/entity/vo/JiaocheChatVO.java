package com.entity.vo;

import com.entity.JiaocheChatEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 用户咨询
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jiaoche_chat")
public class JiaocheChatVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 提问人
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 回答人
     */

    @TableField(value = "siji_id")
    private Integer sijiId;


    /**
     * 问题
     */

    @TableField(value = "jiaoche_chat_issue_text")
    private String jiaocheChatIssueText;


    /**
     * 问题时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "issue_time")
    private Date issueTime;


    /**
     * 回复
     */

    @TableField(value = "jiaoche_chat_reply_text")
    private String jiaocheChatReplyText;


    /**
     * 回复时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "reply_time")
    private Date replyTime;


    /**
     * 状态
     */

    @TableField(value = "zhuangtai_types")
    private Integer zhuangtaiTypes;


    /**
     * 数据类型
     */

    @TableField(value = "jiaoche_chat_types")
    private Integer jiaocheChatTypes;


    /**
     * 提问时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
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
	 * 设置：提问人
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：提问人
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：回答人
	 */
    public Integer getSijiId() {
        return sijiId;
    }


    /**
	 * 获取：回答人
	 */

    public void setSijiId(Integer sijiId) {
        this.sijiId = sijiId;
    }
    /**
	 * 设置：问题
	 */
    public String getJiaocheChatIssueText() {
        return jiaocheChatIssueText;
    }


    /**
	 * 获取：问题
	 */

    public void setJiaocheChatIssueText(String jiaocheChatIssueText) {
        this.jiaocheChatIssueText = jiaocheChatIssueText;
    }
    /**
	 * 设置：问题时间
	 */
    public Date getIssueTime() {
        return issueTime;
    }


    /**
	 * 获取：问题时间
	 */

    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }
    /**
	 * 设置：回复
	 */
    public String getJiaocheChatReplyText() {
        return jiaocheChatReplyText;
    }


    /**
	 * 获取：回复
	 */

    public void setJiaocheChatReplyText(String jiaocheChatReplyText) {
        this.jiaocheChatReplyText = jiaocheChatReplyText;
    }
    /**
	 * 设置：回复时间
	 */
    public Date getReplyTime() {
        return replyTime;
    }


    /**
	 * 获取：回复时间
	 */

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
    /**
	 * 设置：状态
	 */
    public Integer getZhuangtaiTypes() {
        return zhuangtaiTypes;
    }


    /**
	 * 获取：状态
	 */

    public void setZhuangtaiTypes(Integer zhuangtaiTypes) {
        this.zhuangtaiTypes = zhuangtaiTypes;
    }
    /**
	 * 设置：数据类型
	 */
    public Integer getJiaocheChatTypes() {
        return jiaocheChatTypes;
    }


    /**
	 * 获取：数据类型
	 */

    public void setJiaocheChatTypes(Integer jiaocheChatTypes) {
        this.jiaocheChatTypes = jiaocheChatTypes;
    }
    /**
	 * 设置：提问时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：提问时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
