/**
 * @包路径：cn.edu.jmun.mzgl.formbean
 * @文件名：MzglFB.java
 * @类描述：TODO(TODO)
 * @创建人：冯文超
 * @创建时间：2016年5月21日  下午4:46:41
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.formbean
 * @类名：MzglFB
 * @描述：TODO(TODO)
 * @作者：冯文超
 * @创建时间：2016年5月21日  下午4:46:41
 */
@Alias("MzglFB")
public class MzglFB {

	/**
	 * 基础库是否存在
	 */
	private String jcksfcz;
	/**
	 * 身份证号码
	 */
	private String sfzhm;
	/**
	 * 挂号时间
	 */
	private String ghsj;
	
	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 姓名
	 */
	private String xm;
	/**
	 * 性别
	 */
	private String xb;
	/**
	 * 年龄
	 */
	private String nl;
	/**
	 * 出生日期
	 */
	private String birthday;
	/**
	 * 民族
	 */
	private String mz;
	/**
	 * 手机
	 */
	private String telephone;
	/**
	 * 电话
	 */
	private String phone;
	/**
	 * 户口所在地行政区划
	 */
	private String hkszdxzqh;
	/**
	 * 居住所在地行政区划
	 */
	private String jzszdxzqh;
	/**
	 * 居住所在地细项
	 */
	private String jzszdxx;
	/**
	 * 所属科室
	 */
	private String ssks;
	/**
	 * 挂号卡编号
	 */
	private String ghkbh;
	/**
	 * 流程状态
	 */
	private String lczt;
	/**
	 * 当前时间
	 */
	private String dqsj;
	/**
	 * 药物名称
	 */
	private String ywmc;
	/**
	 * 药物单价
	 */
	private String ywdj;
	/**
	 * pageIndex
	 */
	private int pageIndex;
	/**
	 * pageSize
	 */
	private int pageSize;
	private int startRows;
	private int endRows;
	private int dmid;
	/**
	 * 表名
	 */
	private String tablename;
	private String[] jcid;
	private String[] ywfs;
	private String[] ywid;
	/**
	 * 是否取药
	 */
	private String sfqy;
	/**
	 * 是否住院
	 */
	private String sfzy;
	/**
	 * 是否检查
	 */
	private String sfjc;
	private String zysx;
	private String wzbh;
	private String[] jbid;
	private String[] jbbx;
	private String[] jcsm;
	
	
	public String[] getJcsm() {
		return jcsm;
	}
	public void setJcsm(String[] jcsm) {
		this.jcsm = jcsm;
	}
	public String[] getJbbx() {
		return jbbx;
	}
	public void setJbbx(String[] jbbx) {
		this.jbbx = jbbx;
	}
	public String[] getJbid() {
		return jbid;
	}
	public void setJbid(String[] jbid) {
		this.jbid = jbid;
	}
	public String getWzbh() {
		return wzbh;
	}
	public void setWzbh(String wzbh) {
		this.wzbh = wzbh;
	}
	public String[] getYwfs() {
		return ywfs;
	}
	public void setYwfs(String[] ywfs) {
		this.ywfs = ywfs;
	}
	public String getZysx() {
		return zysx;
	}
	public void setZysx(String zysx) {
		this.zysx = zysx;
	}
	public String[] getJcid() {
		return jcid;
	}
	public void setJcid(String[] jcid) {
		this.jcid = jcid;
	}
	public String[] getYwid() {
		return ywid;
	}
	public void setYwid(String[] ywid) {
		this.ywid = ywid;
	}
	public String getSfqy() {
		return sfqy;
	}
	public void setSfqy(String sfqy) {
		this.sfqy = sfqy;
	}
	public String getSfzy() {
		return sfzy;
	}
	public void setSfzy(String sfzy) {
		this.sfzy = sfzy;
	}
	public String getSfjc() {
		return sfjc;
	}
	public void setSfjc(String sfjc) {
		this.sfjc = sfjc;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public int getDmid() {
		return dmid;
	}
	public void setDmid(int dmid) {
		this.dmid = dmid;
	}
	public int getPageIndex() {
		return pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getStartRows() {
		return startRows;
	}
	public void setStartRows(int startRows) {
		this.startRows = startRows;
	}
	public int getEndRows() {
		return endRows;
	}
	public void setEndRows(int endRows) {
		this.endRows = endRows;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getYwmc() {
		return ywmc;
	}
	public void setYwmc(String ywmc) {
		this.ywmc = ywmc;
	}
	public String getYwdj() {
		return ywdj;
	}
	public void setYwdj(String ywdj) {
		this.ywdj = ywdj;
	}
	public String getDqsj() {
		return dqsj;
	}
	public void setDqsj(String dqsj) {
		this.dqsj = dqsj;
	}
	public String getLczt() {
		return lczt;
	}
	public void setLczt(String lczt) {
		this.lczt = lczt;
	}
	public String getGhkbh() {
		return ghkbh;
	}
	public void setGhkbh(String ghkbh) {
		this.ghkbh = ghkbh;
	}
	public String getSsks() {
		return ssks;
	}
	public void setSsks(String ssks) {
		this.ssks = ssks;
	}
	public String getJcksfcz() {
		return jcksfcz;
	}
	public void setJcksfcz(String jcksfcz) {
		this.jcksfcz = jcksfcz;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
	}
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
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public String getNl() {
		return nl;
	}
	public void setNl(String nl) {
		this.nl = nl;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getMz() {
		return mz;
	}
	public void setMz(String mz) {
		this.mz = mz;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getHkszdxzqh() {
		return hkszdxzqh;
	}
	public void setHkszdxzqh(String hkszdxzqh) {
		this.hkszdxzqh = hkszdxzqh;
	}
	public String getJzszdxzqh() {
		return jzszdxzqh;
	}
	public void setJzszdxzqh(String jzszdxzqh) {
		this.jzszdxzqh = jzszdxzqh;
	}
	public String getJzszdxx() {
		return jzszdxx;
	}
	public void setJzszdxx(String jzszdxx) {
		this.jzszdxx = jzszdxx;
	}
}
