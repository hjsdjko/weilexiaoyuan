package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.DaipiaoOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 代跑订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("daipiao_order")
public class DaipiaoOrderView extends DaipiaoOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String daipiaoOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String daipiaoOrderPaymentValue;

	//级联表 代跑
					 
		/**
		* 代跑 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer daipiaoYonghuId;
		/**
		* 代跑标题
		*/

		@ColumnInfo(comment="代跑标题",type="varchar(200)")
		private String daipiaoName;
		/**
		* 代跑照片
		*/

		@ColumnInfo(comment="代跑照片",type="varchar(200)")
		private String daipiaoPhoto;
		/**
		* 代跑地点
		*/

		@ColumnInfo(comment="代跑地点",type="varchar(200)")
		private String daipiaoAddress;
		/**
		* 联系人
		*/

		@ColumnInfo(comment="联系人",type="varchar(200)")
		private String daipiaoLianxiren;
		/**
		* 联系方式
		*/

		@ColumnInfo(comment="联系方式",type="varchar(200)")
		private String daipiaoLianxifangshi;
		/**
		* 代跑类型
		*/
		@ColumnInfo(comment="代跑类型",type="int(11)")
		private Integer daipiaoTypes;
			/**
			* 代跑类型的值
			*/
			@ColumnInfo(comment="代跑类型的字典表值",type="varchar(200)")
			private String daipiaoValue;
		/**
		* 代跑金额
		*/
		@ColumnInfo(comment="代跑金额",type="decimal(10,2)")
		private Double daipiaoNewMoney;
		/**
		* 代跑时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="代跑时间",type="timestamp")
		private Date daipiaoTime;
		/**
		* 代跑内容
		*/

		@ColumnInfo(comment="代跑内容",type="text")
		private String daipiaoContent;
		/**
		* 代跑状态
		*/
		@ColumnInfo(comment="代跑状态",type="int(11)")
		private Integer daipiaoZhuangtaiTypes;
			/**
			* 代跑状态的值
			*/
			@ColumnInfo(comment="代跑状态的字典表值",type="varchar(200)")
			private String daipiaoZhuangtaiValue;
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



	public DaipiaoOrderView() {

	}

	public DaipiaoOrderView(DaipiaoOrderEntity daipiaoOrderEntity) {
		try {
			BeanUtils.copyProperties(this, daipiaoOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getDaipiaoOrderValue() {
		return daipiaoOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setDaipiaoOrderValue(String daipiaoOrderValue) {
		this.daipiaoOrderValue = daipiaoOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getDaipiaoOrderPaymentValue() {
		return daipiaoOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setDaipiaoOrderPaymentValue(String daipiaoOrderPaymentValue) {
		this.daipiaoOrderPaymentValue = daipiaoOrderPaymentValue;
	}


	//级联表的get和set 代跑
		/**
		* 获取：代跑 的 用户
		*/
		public Integer getDaipiaoYonghuId() {
			return daipiaoYonghuId;
		}
		/**
		* 设置：代跑 的 用户
		*/
		public void setDaipiaoYonghuId(Integer daipiaoYonghuId) {
			this.daipiaoYonghuId = daipiaoYonghuId;
		}

		/**
		* 获取： 代跑标题
		*/
		public String getDaipiaoName() {
			return daipiaoName;
		}
		/**
		* 设置： 代跑标题
		*/
		public void setDaipiaoName(String daipiaoName) {
			this.daipiaoName = daipiaoName;
		}

		/**
		* 获取： 代跑照片
		*/
		public String getDaipiaoPhoto() {
			return daipiaoPhoto;
		}
		/**
		* 设置： 代跑照片
		*/
		public void setDaipiaoPhoto(String daipiaoPhoto) {
			this.daipiaoPhoto = daipiaoPhoto;
		}

		/**
		* 获取： 代跑地点
		*/
		public String getDaipiaoAddress() {
			return daipiaoAddress;
		}
		/**
		* 设置： 代跑地点
		*/
		public void setDaipiaoAddress(String daipiaoAddress) {
			this.daipiaoAddress = daipiaoAddress;
		}

		/**
		* 获取： 联系人
		*/
		public String getDaipiaoLianxiren() {
			return daipiaoLianxiren;
		}
		/**
		* 设置： 联系人
		*/
		public void setDaipiaoLianxiren(String daipiaoLianxiren) {
			this.daipiaoLianxiren = daipiaoLianxiren;
		}

		/**
		* 获取： 联系方式
		*/
		public String getDaipiaoLianxifangshi() {
			return daipiaoLianxifangshi;
		}
		/**
		* 设置： 联系方式
		*/
		public void setDaipiaoLianxifangshi(String daipiaoLianxifangshi) {
			this.daipiaoLianxifangshi = daipiaoLianxifangshi;
		}
		/**
		* 获取： 代跑类型
		*/
		public Integer getDaipiaoTypes() {
			return daipiaoTypes;
		}
		/**
		* 设置： 代跑类型
		*/
		public void setDaipiaoTypes(Integer daipiaoTypes) {
			this.daipiaoTypes = daipiaoTypes;
		}


			/**
			* 获取： 代跑类型的值
			*/
			public String getDaipiaoValue() {
				return daipiaoValue;
			}
			/**
			* 设置： 代跑类型的值
			*/
			public void setDaipiaoValue(String daipiaoValue) {
				this.daipiaoValue = daipiaoValue;
			}

		/**
		* 获取： 代跑金额
		*/
		public Double getDaipiaoNewMoney() {
			return daipiaoNewMoney;
		}
		/**
		* 设置： 代跑金额
		*/
		public void setDaipiaoNewMoney(Double daipiaoNewMoney) {
			this.daipiaoNewMoney = daipiaoNewMoney;
		}

		/**
		* 获取： 代跑时间
		*/
		public Date getDaipiaoTime() {
			return daipiaoTime;
		}
		/**
		* 设置： 代跑时间
		*/
		public void setDaipiaoTime(Date daipiaoTime) {
			this.daipiaoTime = daipiaoTime;
		}

		/**
		* 获取： 代跑内容
		*/
		public String getDaipiaoContent() {
			return daipiaoContent;
		}
		/**
		* 设置： 代跑内容
		*/
		public void setDaipiaoContent(String daipiaoContent) {
			this.daipiaoContent = daipiaoContent;
		}
		/**
		* 获取： 代跑状态
		*/
		public Integer getDaipiaoZhuangtaiTypes() {
			return daipiaoZhuangtaiTypes;
		}
		/**
		* 设置： 代跑状态
		*/
		public void setDaipiaoZhuangtaiTypes(Integer daipiaoZhuangtaiTypes) {
			this.daipiaoZhuangtaiTypes = daipiaoZhuangtaiTypes;
		}


			/**
			* 获取： 代跑状态的值
			*/
			public String getDaipiaoZhuangtaiValue() {
				return daipiaoZhuangtaiValue;
			}
			/**
			* 设置： 代跑状态的值
			*/
			public void setDaipiaoZhuangtaiValue(String daipiaoZhuangtaiValue) {
				this.daipiaoZhuangtaiValue = daipiaoZhuangtaiValue;
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


	@Override
	public String toString() {
		return "DaipiaoOrderView{" +
			", daipiaoOrderValue=" + daipiaoOrderValue +
			", daipiaoOrderPaymentValue=" + daipiaoOrderPaymentValue +
			", daipiaoName=" + daipiaoName +
			", daipiaoPhoto=" + daipiaoPhoto +
			", daipiaoAddress=" + daipiaoAddress +
			", daipiaoLianxiren=" + daipiaoLianxiren +
			", daipiaoLianxifangshi=" + daipiaoLianxifangshi +
			", daipiaoNewMoney=" + daipiaoNewMoney +
			", daipiaoTime=" + DateUtil.convertString(daipiaoTime,"yyyy-MM-dd") +
			", daipiaoContent=" + daipiaoContent +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
