package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.YuezhanxiaoyuanLiuyanEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 约战校园留言
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("yuezhanxiaoyuan_liuyan")
public class YuezhanxiaoyuanLiuyanView extends YuezhanxiaoyuanLiuyanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String yonghuEmail;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
	//级联表 约战校园
					 
		/**
		* 约战校园 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer yuezhanxiaoyuanYonghuId;
		/**
		* 约战校园名称
		*/

		@ColumnInfo(comment="约战校园名称",type="varchar(200)")
		private String yuezhanxiaoyuanName;
		/**
		* 约战校园照片
		*/

		@ColumnInfo(comment="约战校园照片",type="varchar(200)")
		private String yuezhanxiaoyuanPhoto;
		/**
		* 约战时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="约战时间",type="timestamp")
		private Date yuezhanTime;
		/**
		* 约战地点
		*/

		@ColumnInfo(comment="约战地点",type="varchar(200)")
		private String yuezhanxiaoyuanAddress;
		/**
		* 约战校园类型
		*/
		@ColumnInfo(comment="约战校园类型",type="int(11)")
		private Integer yuezhanxiaoyuanTypes;
			/**
			* 约战校园类型的值
			*/
			@ColumnInfo(comment="约战校园类型的字典表值",type="varchar(200)")
			private String yuezhanxiaoyuanValue;
		/**
		* 约战校园热度
		*/

		@ColumnInfo(comment="约战校园热度",type="int(11)")
		private Integer yuezhanxiaoyuanClicknum;
		/**
		* 约战内容
		*/

		@ColumnInfo(comment="约战内容",type="text")
		private String yuezhanxiaoyuanContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer yuezhanxiaoyuanDelete;



	public YuezhanxiaoyuanLiuyanView() {

	}

	public YuezhanxiaoyuanLiuyanView(YuezhanxiaoyuanLiuyanEntity yuezhanxiaoyuanLiuyanEntity) {
		try {
			BeanUtils.copyProperties(this, yuezhanxiaoyuanLiuyanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 电子邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

		/**
		* 获取： 余额
		*/
		public Double getNewMoney() {
			return newMoney;
		}
		/**
		* 设置： 余额
		*/
		public void setNewMoney(Double newMoney) {
			this.newMoney = newMoney;
		}
	//级联表的get和set 约战校园
		/**
		* 获取：约战校园 的 用户
		*/
		public Integer getYuezhanxiaoyuanYonghuId() {
			return yuezhanxiaoyuanYonghuId;
		}
		/**
		* 设置：约战校园 的 用户
		*/
		public void setYuezhanxiaoyuanYonghuId(Integer yuezhanxiaoyuanYonghuId) {
			this.yuezhanxiaoyuanYonghuId = yuezhanxiaoyuanYonghuId;
		}

		/**
		* 获取： 约战校园名称
		*/
		public String getYuezhanxiaoyuanName() {
			return yuezhanxiaoyuanName;
		}
		/**
		* 设置： 约战校园名称
		*/
		public void setYuezhanxiaoyuanName(String yuezhanxiaoyuanName) {
			this.yuezhanxiaoyuanName = yuezhanxiaoyuanName;
		}

		/**
		* 获取： 约战校园照片
		*/
		public String getYuezhanxiaoyuanPhoto() {
			return yuezhanxiaoyuanPhoto;
		}
		/**
		* 设置： 约战校园照片
		*/
		public void setYuezhanxiaoyuanPhoto(String yuezhanxiaoyuanPhoto) {
			this.yuezhanxiaoyuanPhoto = yuezhanxiaoyuanPhoto;
		}

		/**
		* 获取： 约战时间
		*/
		public Date getYuezhanTime() {
			return yuezhanTime;
		}
		/**
		* 设置： 约战时间
		*/
		public void setYuezhanTime(Date yuezhanTime) {
			this.yuezhanTime = yuezhanTime;
		}

		/**
		* 获取： 约战地点
		*/
		public String getYuezhanxiaoyuanAddress() {
			return yuezhanxiaoyuanAddress;
		}
		/**
		* 设置： 约战地点
		*/
		public void setYuezhanxiaoyuanAddress(String yuezhanxiaoyuanAddress) {
			this.yuezhanxiaoyuanAddress = yuezhanxiaoyuanAddress;
		}
		/**
		* 获取： 约战校园类型
		*/
		public Integer getYuezhanxiaoyuanTypes() {
			return yuezhanxiaoyuanTypes;
		}
		/**
		* 设置： 约战校园类型
		*/
		public void setYuezhanxiaoyuanTypes(Integer yuezhanxiaoyuanTypes) {
			this.yuezhanxiaoyuanTypes = yuezhanxiaoyuanTypes;
		}


			/**
			* 获取： 约战校园类型的值
			*/
			public String getYuezhanxiaoyuanValue() {
				return yuezhanxiaoyuanValue;
			}
			/**
			* 设置： 约战校园类型的值
			*/
			public void setYuezhanxiaoyuanValue(String yuezhanxiaoyuanValue) {
				this.yuezhanxiaoyuanValue = yuezhanxiaoyuanValue;
			}

		/**
		* 获取： 约战校园热度
		*/
		public Integer getYuezhanxiaoyuanClicknum() {
			return yuezhanxiaoyuanClicknum;
		}
		/**
		* 设置： 约战校园热度
		*/
		public void setYuezhanxiaoyuanClicknum(Integer yuezhanxiaoyuanClicknum) {
			this.yuezhanxiaoyuanClicknum = yuezhanxiaoyuanClicknum;
		}

		/**
		* 获取： 约战内容
		*/
		public String getYuezhanxiaoyuanContent() {
			return yuezhanxiaoyuanContent;
		}
		/**
		* 设置： 约战内容
		*/
		public void setYuezhanxiaoyuanContent(String yuezhanxiaoyuanContent) {
			this.yuezhanxiaoyuanContent = yuezhanxiaoyuanContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getYuezhanxiaoyuanDelete() {
			return yuezhanxiaoyuanDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setYuezhanxiaoyuanDelete(Integer yuezhanxiaoyuanDelete) {
			this.yuezhanxiaoyuanDelete = yuezhanxiaoyuanDelete;
		}


	@Override
	public String toString() {
		return "YuezhanxiaoyuanLiuyanView{" +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			", yuezhanxiaoyuanName=" + yuezhanxiaoyuanName +
			", yuezhanxiaoyuanPhoto=" + yuezhanxiaoyuanPhoto +
			", yuezhanTime=" + DateUtil.convertString(yuezhanTime,"yyyy-MM-dd") +
			", yuezhanxiaoyuanAddress=" + yuezhanxiaoyuanAddress +
			", yuezhanxiaoyuanClicknum=" + yuezhanxiaoyuanClicknum +
			", yuezhanxiaoyuanContent=" + yuezhanxiaoyuanContent +
			", yuezhanxiaoyuanDelete=" + yuezhanxiaoyuanDelete +
			"} " + super.toString();
	}
}
