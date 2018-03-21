/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：BrxxVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月23日  上午10:09:05
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：BrxxVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月23日  上午10:09:05
 */
@Alias("BrxxVB")
public class BrxxVB {

	private String grbh;
	private String ghkbh;
	private String xm;
	private String sfzhm;
	private String phone;
	private String telephone;
	private String jzszdxzqh;
	private String xb;
	private String nl;
	private String ghsj;
	private String wzbh;
	
	
	public String getWzbh() {
		return wzbh;
	}
	public void setWzbh(String wzbh) {
		this.wzbh = wzbh;
	}
	public String getGhsj() {
		return ghsj;
	}
	public void setGhsj(String ghsj) {
		this.ghsj = ghsj;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getGhkbh() {
		return ghkbh;
	}
	public void setGhkbh(String ghkbh) {
		this.ghkbh = ghkbh;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
	public String getJzszdxzqh() {
		return jzszdxzqh;
	}
	public void setJzszdxzqh(String jzszdxzqh) {
		this.jzszdxzqh = jzszdxzqh;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}

	
}
