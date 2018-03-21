/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：MzlcztbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月22日  下午4:07:06
 */
package com.example.demo.dto;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：MzlcztbVB
 * @描述：TODO( 门诊流程状态表 )
 * @作者：冯文超
 * @创建时间：2016年5月22日  下午4:07:06
 */
public class MzlcztbVB {
	
	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 挂号卡编号
	 */
	private String ghkbh;
	/**
	 * 挂号时间
	 */
	private String ghsj;
	/**
	 * 流程状态
	 */
	private String lczt;
	/**
	 * 是否问诊
	 */
	private String sfwz;
	/**
	 * 问诊医师ID
	 */
	private String wzysid;
	/**
	 * 是否取药
	 */
	private String sfqy;
	/**
	 * 是否住院
	 */
	private String 	sfzy;
	/**
	 * 是否检查
	 */
	private String sfjc;
	/**
	 * 所属科室
	 */
	private String ssks;
	
	
	public String getSsks() {
		return ssks;
	}
	public void setSsks(String ssks) {
		this.ssks = ssks;
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
	public String getGhsj() {
		return ghsj;
	}
	public void setGhsj(String ghsj) {
		this.ghsj = ghsj;
	}
	public String getLczt() {
		return lczt;
	}
	public void setLczt(String lczt) {
		this.lczt = lczt;
	}
	public String getSfwz() {
		return sfwz;
	}
	public void setSfwz(String sfwz) {
		this.sfwz = sfwz;
	}
	public String getWzysid() {
		return wzysid;
	}
	public void setWzysid(String wzysid) {
		this.wzysid = wzysid;
	}
	public String getSfqy() {
		return sfqy;
	}
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}
	public String getSfzy() {
		return sfzy;
	}
	public void setSfzy(String sfzy) {
		this.sfzy = sfzy;
	}
	public String getSfjc() {
		return sfjc;
	}
	public void setSfjc(String sfjc) {
		this.sfjc = sfjc;
	}
}
