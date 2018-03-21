/**
 * @包路径：cn.edu.jmun.common.formbean
 * @文件名：RegionFB.java
 * @类描述：TODO ( 行政区划代码formbean )
 * @创建人：冯文超
 * @创建时间：2016年3月26日  下午9:05:25
 */
package com.example.demo.dto;

/**
 * @包路径：cn.edu.jmun.common.formbean
 * @类名：RegionFB
 * @描述：TODO ( 行政区划代码formbean )
 * @作者：冯文超
 * @创建时间：2016年3月26日  下午9:05:25
 */
public class RegionFB {

	/**
	 * 行政区划表ID 
	 */
	private String id;
	/**
	 * 地名
	 */
	private String name;
	/**
	 * 上级ID
	 */
	private String pid;
	/**
	 * 排序
	 */
	private String sort;
	/**
	 * 行政区划等级()
	 */
	private String level;
	/**
	 * 行政区划代码
	 */
	private String longcode;
	/**
	 * 行政区划代码（小）
	 */
	private String code;
	
	
	private String szs;
	private String szq;
	private String szx;
	private String szz;
	private String szc;
	private String xzqh;
	
	
	
	public String getXzqh() {
		return xzqh;
	}
	public void setXzqh(String xzqh) {
		this.xzqh = xzqh;
	}
	public String getSzs() {
		return szs;
	}
	public void setSzs(String szs) {
		this.szs = szs;
	}
	public String getSzq() {
		return szq;
	}
	public void setSzq(String szq) {
		this.szq = szq;
	}
	public String getSzx() {
		return szx;
	}
	public void setSzx(String szx) {
		this.szx = szx;
	}
	public String getSzz() {
		return szz;
	}
	public void setSzz(String szz) {
		this.szz = szz;
	}
	public String getSzc() {
		return szc;
	}
	public void setSzc(String szc) {
		this.szc = szc;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getLongcode() {
		return longcode;
	}
	public void setLongcode(String longcode) {
		this.longcode = longcode;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}	
}
