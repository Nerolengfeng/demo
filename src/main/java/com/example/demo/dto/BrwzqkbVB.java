/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：BrwzqkbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月23日  下午10:21:43
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：BrwzqkbVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月23日  下午10:21:43
 */
@Alias("BrwzqkbVB")
public class BrwzqkbVB {

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
	 * 问诊时间
	 */
	private String wzsj;
	/**
	 * 医师编号
	 */
	private String ysbh;
	/**
	 * 注意事项
	 */
	private String zysx;
	
	private String ghsj;
	
	
	public String getGhsj() {
		return ghsj;
	}
	public void setGhsj(String ghsj) {
		this.ghsj = ghsj;
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
	public String getWzsj() {
		return wzsj;
	}
	public void setWzsj(String wzsj) {
		this.wzsj = wzsj;
	}
	public String getYsbh() {
		return ysbh;
	}
	public void setYsbh(String ysbh) {
		this.ysbh = ysbh;
	}
	public String getZysx() {
		return zysx;
	}
	public void setZysx(String zysx) {
		this.zysx = zysx;
	}
}
