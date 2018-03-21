/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：BrjcxbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月23日  下午10:54:40
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：BrjcxbVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月23日  下午10:54:40
 */
@Alias("BrjcxbVB")
public class BrjcxbVB {

	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 挂号卡编号
	 */
	private String ghkbh;
	/**
	 * 问诊编号
	 */
	private String wzbh;
	/**
	 * 检查代码
	 */
	private String jcdm;
	/**
	 * 是否缴费
	 */
	private String sfjf;
	/**
	 * 缴纳金额
	 */
	private String jnje;
	/**
	 * 是否检查
	 */
	private String sfjc;
	/**
	 * 检查说明
	 */
	private String jcsm;
	
	private String jcmc;
	
	
	public String getJcmc() {
		return jcmc;
	}
	public void setJcmc(String jcmc) {
		this.jcmc = jcmc;
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
	public String getWzbh() {
		return wzbh;
	}
	public void setWzbh(String wzbh) {
		this.wzbh = wzbh;
	}
	public String getJcdm() {
		return jcdm;
	}
	public void setJcdm(String jcdm) {
		this.jcdm = jcdm;
	}
	public String getSfjf() {
		return sfjf;
	}
	public void setSfjf(String sfjf) {
		this.sfjf = sfjf;
	}
	public String getJnje() {
		return jnje;
	}
	public void setJnje(String jnje) {
		this.jnje = jnje;
	}
	public String getSfjc() {
		return sfjc;
	}
	public void setSfjc(String sfjc) {
		this.sfjc = sfjc;
	}
	public String getJcsm() {
		return jcsm;
	}
	public void setJcsm(String jcsm) {
		this.jcsm = jcsm;
	}
}
