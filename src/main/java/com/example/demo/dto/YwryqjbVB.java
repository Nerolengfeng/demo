/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @文件名：YwryqjbVB.java
 * @类描述：TODO( 请假记录表 )
 * @创建人：冯文超
 * @创建时间：2016-4-25  上午10:50:32
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @类名：YwryqjbVB
 * @描述：TODO( 请假记录表 )
 * @作者：冯文超
 * @创建时间：2016-4-25  上午10:50:32
 */
@Alias("YwryqjbVB")
public class YwryqjbVB {

	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 请假时间起
	 */
	private String qjsjq;
	/**
	 * 请假时间止
	 */
	private String qjsjz;
	/**
	 * 请假时长
	 */
	private String qjsc;
	/**
	 * 请假类别
	 */
	private String qjlb;
	/**
	 * 请假原因
	 */
	private String qjyy;
	/**
	 * 请假日期
	 */
	private String qjrq;
	/**
	 * 负责人
	 */
	private String fzrid;
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getQjsjq() {
		return qjsjq;
	}
	public void setQjsjq(String qjsjq) {
		this.qjsjq = qjsjq;
	}
	public String getQjsjz() {
		return qjsjz;
	}
	public void setQjsjz(String qjsjz) {
		this.qjsjz = qjsjz;
	}
	public String getQjsc() {
		return qjsc;
	}
	public void setQjsc(String qjsc) {
		this.qjsc = qjsc;
	}
	public String getQjlb() {
		return qjlb;
	}
	public void setQjlb(String qjlb) {
		this.qjlb = qjlb;
	}
	public String getQjyy() {
		return qjyy;
	}
	public void setQjyy(String qjyy) {
		this.qjyy = qjyy;
	}
	public String getQjrq() {
		return qjrq;
	}
	public void setQjrq(String qjrq) {
		this.qjrq = qjrq;
	}
	public String getFzrid() {
		return fzrid;
	}
	public void setFzrid(String fzrid) {
		this.fzrid = fzrid;
	}
}
