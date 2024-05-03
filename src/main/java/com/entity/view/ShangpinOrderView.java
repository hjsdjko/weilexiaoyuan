package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShangpinOrderEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 二手商品订单
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shangpin_order")
public class ShangpinOrderView extends ShangpinOrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 订单类型的值
	*/
	@ColumnInfo(comment="订单类型的字典表值",type="varchar(200)")
	private String shangpinOrderValue;
	/**
	* 支付类型的值
	*/
	@ColumnInfo(comment="支付类型的字典表值",type="varchar(200)")
	private String shangpinOrderPaymentValue;

	//级联表 二手商品
					 
		/**
		* 二手商品 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer shangpinYonghuId;
		/**
		* 二手商品名称
		*/

		@ColumnInfo(comment="二手商品名称",type="varchar(200)")
		private String shangpinName;
		/**
		* 二手商品编号
		*/

		@ColumnInfo(comment="二手商品编号",type="varchar(200)")
		private String shangpinUuidNumber;
		/**
		* 二手商品照片
		*/

		@ColumnInfo(comment="二手商品照片",type="varchar(200)")
		private String shangpinPhoto;
		/**
		* 商品类型
		*/
		@ColumnInfo(comment="商品类型",type="int(11)")
		private Integer shangpinTypes;
			/**
			* 商品类型的值
			*/
			@ColumnInfo(comment="商品类型的字典表值",type="varchar(200)")
			private String shangpinValue;
		/**
		* 二手数量
		*/

		@ColumnInfo(comment="二手数量",type="int(11)")
		private Integer shangpinKucunNumber;
		/**
		* 二手商品原价
		*/
		@ColumnInfo(comment="二手商品原价",type="decimal(10,2)")
		private Double shangpinOldMoney;
		/**
		* 现价/个
		*/
		@ColumnInfo(comment="现价/个",type="decimal(10,2)")
		private Double shangpinNewMoney;
		/**
		* 二手商品热度
		*/

		@ColumnInfo(comment="二手商品热度",type="int(11)")
		private Integer shangpinClicknum;
		/**
		* 二手商品介绍
		*/

		@ColumnInfo(comment="二手商品介绍",type="text")
		private String shangpinContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shangpinDelete;
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



	public ShangpinOrderView() {

	}

	public ShangpinOrderView(ShangpinOrderEntity shangpinOrderEntity) {
		try {
			BeanUtils.copyProperties(this, shangpinOrderEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 订单类型的值
	*/
	public String getShangpinOrderValue() {
		return shangpinOrderValue;
	}
	/**
	* 设置： 订单类型的值
	*/
	public void setShangpinOrderValue(String shangpinOrderValue) {
		this.shangpinOrderValue = shangpinOrderValue;
	}
	//当前表的
	/**
	* 获取： 支付类型的值
	*/
	public String getShangpinOrderPaymentValue() {
		return shangpinOrderPaymentValue;
	}
	/**
	* 设置： 支付类型的值
	*/
	public void setShangpinOrderPaymentValue(String shangpinOrderPaymentValue) {
		this.shangpinOrderPaymentValue = shangpinOrderPaymentValue;
	}


	//级联表的get和set 二手商品
		/**
		* 获取：二手商品 的 用户
		*/
		public Integer getShangpinYonghuId() {
			return shangpinYonghuId;
		}
		/**
		* 设置：二手商品 的 用户
		*/
		public void setShangpinYonghuId(Integer shangpinYonghuId) {
			this.shangpinYonghuId = shangpinYonghuId;
		}

		/**
		* 获取： 二手商品名称
		*/
		public String getShangpinName() {
			return shangpinName;
		}
		/**
		* 设置： 二手商品名称
		*/
		public void setShangpinName(String shangpinName) {
			this.shangpinName = shangpinName;
		}

		/**
		* 获取： 二手商品编号
		*/
		public String getShangpinUuidNumber() {
			return shangpinUuidNumber;
		}
		/**
		* 设置： 二手商品编号
		*/
		public void setShangpinUuidNumber(String shangpinUuidNumber) {
			this.shangpinUuidNumber = shangpinUuidNumber;
		}

		/**
		* 获取： 二手商品照片
		*/
		public String getShangpinPhoto() {
			return shangpinPhoto;
		}
		/**
		* 设置： 二手商品照片
		*/
		public void setShangpinPhoto(String shangpinPhoto) {
			this.shangpinPhoto = shangpinPhoto;
		}
		/**
		* 获取： 商品类型
		*/
		public Integer getShangpinTypes() {
			return shangpinTypes;
		}
		/**
		* 设置： 商品类型
		*/
		public void setShangpinTypes(Integer shangpinTypes) {
			this.shangpinTypes = shangpinTypes;
		}


			/**
			* 获取： 商品类型的值
			*/
			public String getShangpinValue() {
				return shangpinValue;
			}
			/**
			* 设置： 商品类型的值
			*/
			public void setShangpinValue(String shangpinValue) {
				this.shangpinValue = shangpinValue;
			}

		/**
		* 获取： 二手数量
		*/
		public Integer getShangpinKucunNumber() {
			return shangpinKucunNumber;
		}
		/**
		* 设置： 二手数量
		*/
		public void setShangpinKucunNumber(Integer shangpinKucunNumber) {
			this.shangpinKucunNumber = shangpinKucunNumber;
		}

		/**
		* 获取： 二手商品原价
		*/
		public Double getShangpinOldMoney() {
			return shangpinOldMoney;
		}
		/**
		* 设置： 二手商品原价
		*/
		public void setShangpinOldMoney(Double shangpinOldMoney) {
			this.shangpinOldMoney = shangpinOldMoney;
		}

		/**
		* 获取： 现价/个
		*/
		public Double getShangpinNewMoney() {
			return shangpinNewMoney;
		}
		/**
		* 设置： 现价/个
		*/
		public void setShangpinNewMoney(Double shangpinNewMoney) {
			this.shangpinNewMoney = shangpinNewMoney;
		}

		/**
		* 获取： 二手商品热度
		*/
		public Integer getShangpinClicknum() {
			return shangpinClicknum;
		}
		/**
		* 设置： 二手商品热度
		*/
		public void setShangpinClicknum(Integer shangpinClicknum) {
			this.shangpinClicknum = shangpinClicknum;
		}

		/**
		* 获取： 二手商品介绍
		*/
		public String getShangpinContent() {
			return shangpinContent;
		}
		/**
		* 设置： 二手商品介绍
		*/
		public void setShangpinContent(String shangpinContent) {
			this.shangpinContent = shangpinContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShangpinDelete() {
			return shangpinDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShangpinDelete(Integer shangpinDelete) {
			this.shangpinDelete = shangpinDelete;
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
		return "ShangpinOrderView{" +
			", shangpinOrderValue=" + shangpinOrderValue +
			", shangpinOrderPaymentValue=" + shangpinOrderPaymentValue +
			", shangpinName=" + shangpinName +
			", shangpinUuidNumber=" + shangpinUuidNumber +
			", shangpinPhoto=" + shangpinPhoto +
			", shangpinKucunNumber=" + shangpinKucunNumber +
			", shangpinOldMoney=" + shangpinOldMoney +
			", shangpinNewMoney=" + shangpinNewMoney +
			", shangpinClicknum=" + shangpinClicknum +
			", shangpinContent=" + shangpinContent +
			", shangpinDelete=" + shangpinDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
