/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @文件名：YwryxxbVB.java
 * @类描述：TODO(  )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午03:36:28
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.valuebean
 * @类名：YwryxxbVB
 * @描述：TODO(  )
 * @作者：冯文超
 * @创建时间：2016-4-21  下午03:36:28
 */
@Alias("YwryxxbVB")
public class YwryxxbVB {
	
	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 政治面貌
	 */
	private String zzmm;
	/**
	 * 文化程度
	 */
	private String whcd;
	/**
	 * 所属科室
	 */
	private String ssks;
	/**
	 * 人员身份
	 */
	private String rysf;
	/**
	 * 毕业院校
	 */
	private String byyx;
	/**
	 * 所学专业
	 */
	private String sxzy;
	/**
	 * 医师等级
	 */
	private String ysdj;
	/**
	 * 年假天数
	 */
	private String njts;
	/**
	 * 基本工资
	 */
	private String jbgz;
	/**
	 * 操作员id
	 */
	private String czyid;
	/**
	 * 操作时间
	 */
	private String czsj;
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getZzmm() {
		return zzmm;
	}
	public void setZzmm(String zzmm) {
		this.zzmm = zzmm;
	}
	public String getWhcd() {
		return whcd;
	}
	public void setWhcd(String whcd) {
		this.whcd = whcd;
	}
	public String getSsks() {
		return ssks;
	}
	public void setSsks(String ssks) {
		this.ssks = ssks;
	}
	public String getRysf() {
		return rysf;
	}
	public void setRysf(String rysf) {
		this.rysf = rysf;
	}
	public String getByyx() {
		return byyx;
	}
	public void setByyx(String byyx) {
		this.byyx = byyx;
	}
	public String getSxzy() {
		return sxzy;
	}
	public void setSxzy(String sxzy) {
		this.sxzy = sxzy;
	}
	public String getYsdj() {
		return ysdj;
	}
	public void setYsdj(String ysdj) {
		this.ysdj = ysdj;
	}
	public String getNjts() {
		return njts;
	}
	public void setNjts(String njts) {
		this.njts = njts;
	}
	public String getJbgz() {
		return jbgz;
	}
	public void setJbgz(String jbgz) {
		this.jbgz = jbgz;
	}
	public String getCzyid() {
		return czyid;
	}
	public void setCzyid(String czyid) {
		this.czyid = czyid;
	}
	public String getCzsj() {
		return czsj;
	}
	public void setCzsj(String czsj) {
		this.czsj = czsj;
	}
}
