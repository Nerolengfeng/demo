/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @文件名：YwryjxkhbVB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月17日  下午3:32:52
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @类名：YwryjxkhbVB
 * @描述：TODO( 医务人员绩效考核表 )
 * @作者：冯文超
 * @创建时间：2016年5月17日  下午3:32:52
 */
@Alias("YwryjxkhbVB")
public class YwryjxkhbVB {

	private String grbh;	// 个人编号
	private String khny;	// 考核年月
	private String khx;		// 考核项
	private String khxsm;	// 考核项说明
	private String khfs;	// 考核分数
	private String czsj;	// 操作时间
	private String czrid;	// 操作员ID
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getKhny() {
		return khny;
	}
	public void setKhny(String khny) {
		this.khny = khny;
	}
	public String getKhx() {
		return khx;
	}
	public void setKhx(String khx) {
		this.khx = khx;
	}
	public String getKhxsm() {
		return khxsm;
	}
	public void setKhxsm(String khxsm) {
		this.khxsm = khxsm;
	}
	public String getKhfs() {
		return khfs;
	}
	public void setKhfs(String khfs) {
		this.khfs = khfs;
	}
	public String getCzsj() {
		return czsj;
	}
	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}
	public String getCzrid() {
		return czrid;
	}
	public void setCzrid(String czrid) {
		this.czrid = czrid;
	}
}
