package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JiaocheEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 叫车
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jiaoche")
public class JiaocheView extends JiaocheEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 叫车类型的值
	*/
	@ColumnInfo(comment="叫车类型的字典表值",type="varchar(200)")
	private String jiaocheValue;
	/**
	* 叫车状态的值
	*/
	@ColumnInfo(comment="叫车状态的字典表值",type="varchar(200)")
	private String jiaocheZhuangtaiValue;

	//级联表 司机
		/**
		* 司机姓名
		*/

		@ColumnInfo(comment="司机姓名",type="varchar(200)")
		private String sijiName;
		/**
		* 司机手机号
		*/

		@ColumnInfo(comment="司机手机号",type="varchar(200)")
		private String sijiPhone;
		/**
		* 司机身份证号
		*/

		@ColumnInfo(comment="司机身份证号",type="varchar(200)")
		private String sijiIdNumber;
		/**
		* 司机头像
		*/

		@ColumnInfo(comment="司机头像",type="varchar(200)")
		private String sijiPhoto;
		/**
		* 余额
		*/
		@ColumnInfo(comment="余额",type="decimal(10,2)")
		private Double newMoney;
		/**
		* 电子邮箱
		*/

		@ColumnInfo(comment="电子邮箱",type="varchar(200)")
		private String sijiEmail;
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

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public JiaocheView() {

	}

	public JiaocheView(JiaocheEntity jiaocheEntity) {
		try {
			BeanUtils.copyProperties(this, jiaocheEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 叫车类型的值
	*/
	public String getJiaocheValue() {
		return jiaocheValue;
	}
	/**
	* 设置： 叫车类型的值
	*/
	public void setJiaocheValue(String jiaocheValue) {
		this.jiaocheValue = jiaocheValue;
	}
	//当前表的
	/**
	* 获取： 叫车状态的值
	*/
	public String getJiaocheZhuangtaiValue() {
		return jiaocheZhuangtaiValue;
	}
	/**
	* 设置： 叫车状态的值
	*/
	public void setJiaocheZhuangtaiValue(String jiaocheZhuangtaiValue) {
		this.jiaocheZhuangtaiValue = jiaocheZhuangtaiValue;
	}


	//级联表的get和set 司机

		/**
		* 获取： 司机姓名
		*/
		public String getSijiName() {
			return sijiName;
		}
		/**
		* 设置： 司机姓名
		*/
		public void setSijiName(String sijiName) {
			this.sijiName = sijiName;
		}

		/**
		* 获取： 司机手机号
		*/
		public String getSijiPhone() {
			return sijiPhone;
		}
		/**
		* 设置： 司机手机号
		*/
		public void setSijiPhone(String sijiPhone) {
			this.sijiPhone = sijiPhone;
		}

		/**
		* 获取： 司机身份证号
		*/
		public String getSijiIdNumber() {
			return sijiIdNumber;
		}
		/**
		* 设置： 司机身份证号
		*/
		public void setSijiIdNumber(String sijiIdNumber) {
			this.sijiIdNumber = sijiIdNumber;
		}

		/**
		* 获取： 司机头像
		*/
		public String getSijiPhoto() {
			return sijiPhoto;
		}
		/**
		* 设置： 司机头像
		*/
		public void setSijiPhoto(String sijiPhoto) {
			this.sijiPhoto = sijiPhoto;
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

		/**
		* 获取： 电子邮箱
		*/
		public String getSijiEmail() {
			return sijiEmail;
		}
		/**
		* 设置： 电子邮箱
		*/
		public void setSijiEmail(String sijiEmail) {
			this.sijiEmail = sijiEmail;
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


	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "JiaocheView{" +
			", jiaocheValue=" + jiaocheValue +
			", jiaocheZhuangtaiValue=" + jiaocheZhuangtaiValue +
			", sijiName=" + sijiName +
			", sijiPhone=" + sijiPhone +
			", sijiIdNumber=" + sijiIdNumber +
			", sijiPhoto=" + sijiPhoto +
			", newMoney=" + newMoney +
			", sijiEmail=" + sijiEmail +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", newMoney=" + newMoney +
			"} " + super.toString();
	}
}
