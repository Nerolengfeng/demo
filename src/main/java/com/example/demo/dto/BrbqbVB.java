/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：BrbqbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月24日  下午5:37:52
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：BrbqbVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月24日  下午5:37:52
 */
@Alias("BrbqbVB")
public class BrbqbVB {

	private String grbh;
	private String ghkbh;
	private String wzbh;
	private String jbdm;
	private String jbbx;
	private String yzcd;
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
	public String getJbdm() {
		return jbdm;
	}
	public void setJbdm(String jbdm) {
		this.jbdm = jbdm;
	}
	public String getJbbx() {
		return jbbx;
	}
	public void setJbbx(String jbbx) {
		this.jbbx = jbbx;
	}
	public String getYzcd() {
		return yzcd;
	}
	public void setYzcd(String yzcd) {
		this.yzcd = yzcd;
	}
}
