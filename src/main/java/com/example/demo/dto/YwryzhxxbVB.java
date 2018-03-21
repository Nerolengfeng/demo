/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @文件名：YwryzhxxbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年4月23日  上午10:02:15
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @类名：YwryzhxxbVB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年4月23日  上午10:02:15
 */
@Alias("YwryzhxxbVB")
public class YwryzhxxbVB {

	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 账号编码
	 */
	private String zhbm;
	/**
	 * 账号密码
	 */
	private String zhmm;
	/**
	 * 是否有效
	 */
	private String sfyx;
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getZhbm() {
		return zhbm;
	}
	public void setZhbm(String zhbm) {
		this.zhbm = zhbm;
	}
	public String getZhmm() {
		return zhmm;
	}
	public void setZhmm(String zhmm) {
		this.zhmm = zhmm;
	}
	public String getSfyx() {
		return sfyx;
	}
	public void setSfyx(String sfyx) {
		this.sfyx = sfyx;
	}
}
