/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：RyjbxxbVB.java
 * @类描述：TODO(  )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午03:34:43
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：RyjbxxbVB
 * @描述：TODO(  )
 * @作者：冯文超
 * @创建时间：2016-4-21  下午03:34:43
 */
@Alias("RyjbxxbVB")
public class RyjbxxbVB {

	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 身份证号码
	 */
	private String sfzhm;
	/**
	 * 姓名
	 */
	private String xm;
	/**
	 * 性别
	 */
	private String xb;
	/**
	 * 年龄
	 */
	private String nl;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 民族
	 */
	private String mz;
	/**
	 * 手机
	 */
	private String telephone;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 户口所在地行政区划
	 */
	private String hkszdxzqh;
	/**
	 * 居住所在地行政区划
	 */
	private String jzszdxzqh;
	/**
	 * 居住所在地细项
	 */
	private String jzszdxx;
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHkszdxzqh() {
		return hkszdxzqh;
	}
	public void setHkszdxzqh(String hkszdxzqh) {
		this.hkszdxzqh = hkszdxzqh;
	}
	public String getJzszdxzqh() {
		return jzszdxzqh;
	}
	public void setJzszdxzqh(String jzszdxzqh) {
		this.jzszdxzqh = jzszdxzqh;
	}
	public String getJzszdxx() {
		return jzszdxx;
	}
	public void setJzszdxx(String jzszdxx) {
		this.jzszdxx = jzszdxx;
	}
}
