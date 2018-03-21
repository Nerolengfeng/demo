/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：JbdmbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月24日  下午5:08:20
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：JbdmbVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月24日  下午5:08:20
 */
@Alias("JbdmbVB")
public class JbdmbVB {

	private String dmid;
	private String dmmc;
	private String ssks;
	private String sort;
	private String sfyx;
	public String getDmid() {
		return dmid;
	}
	public void setDmid(String dmid) {
		this.dmid = dmid;
	}
	public String getDmmc() {
		return dmmc;
	}
	public void setDmmc(String dmmc) {
		this.dmmc = dmmc;
	}
	public String getSsks() {
		return ssks;
	}
	public void setSsks(String ssks) {
		this.ssks = ssks;
	}
	public String getSort() {
		return sort;
	}
	public void setSort(String sort) {
		this.sort = sort;
	}
	public String getSfyx() {
		return sfyx;
	}
	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}
	
	
}
