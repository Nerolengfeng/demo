/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：BrnyxxbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月23日  下午10:48:51
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：BrnyxxbVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月23日  下午10:48:51
 */
@Alias("BrnyxxbVB")
public class BrnyxxbVB {

	private String grbh;
	private String ghkbh;
	private String wzbh;
	private String ypbh;
	private String ypfs;
	private String sfjf;
	private String jnje;
	private String sfly;
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
	public String getYpbh() {
		return ypbh;
	}
	public void setYpbh(String ypbh) {
		this.ypbh = ypbh;
	}
	public String getYpfs() {
		return ypfs;
	}
	public void setYpfs(String ypfs) {
		this.ypfs = ypfs;
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
	public String getSfly() {
		return sfly;
	}
	public void setSfly(String sfly) {
		this.sfly = sfly;
	}
}
