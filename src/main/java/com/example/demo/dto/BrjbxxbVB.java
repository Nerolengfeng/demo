/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：BrjbxxbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月22日  下午3:40:51
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：BrjbxxbVB
 * @描述：TODO( 病人基本信息表 )
 * @作者：冯文超
 * @创建时间：2016年5月22日  下午3:40:51
 */
@Alias("BrjbxxbVB")
public class BrjbxxbVB {

	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 挂号卡编号
	 */
	private String ghkbh;
	/**
	 * 录入时间
	 */
	private String lrsj;
	/**
	 * 录入人ID
	 */
	private String lrrid;
	/**
	 * 人员近况
	 */
	private String ryjk;
	
	
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
	public String getLrsj() {
		return lrsj;
	}
	public void setLrsj(String lrsj) {
		this.lrsj = lrsj;
	}
	public String getLrrid() {
		return lrrid;
	}
	public void setLrrid(String lrrid) {
		this.lrrid = lrrid;
	}
	public String getRyjk() {
		return ryjk;
	}
	public void setRyjk(String ryjk) {
		this.ryjk = ryjk;
	}
	
	
	
}
