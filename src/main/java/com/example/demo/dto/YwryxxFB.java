/**
 * @包路径：cn.edu.jmun.mzgl.formbean
 * @文件名：YwryxxFB.java
 * @类描述：TODO(  )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午03:15:32
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.mzgl.formbean
 * @类名：YwryxxFB
 * @描述：TODO(  )
 * @作者：冯文超
 * @创建时间：2016-4-21  下午03:15:32
 */
@Alias("YwryxxFB")
public class YwryxxFB {

	/**
	 * 个人编号
	 */
	private String grbh;
	/**
	 * 身份证号码
	 */
	private String sfzhm;
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
	 * 
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
	/**
	 * 账号编码
	 */
	private String zhbm;
	/**
	 * 账号密码
	 */
	private String zhmm;
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

	/**
	 * 当前年月
	 */
	private String nowYM;
	/**
	 * 遵守工作时间
	 */
	private String zsgzsj;
	/**
	 * 责任事故
	 */
	private String zrsg;
	/**
	 * 遵守纪律
	 */
	private String zsjl;
	/**
	 * 工作态度
	 */
	private String gztd;
	/**
	 * 任务完成情况
	 */
	private String rwwcqk;
	/**
	 * 工作合规性
	 */
	private String gzhgx;
	/**
	 * 工作质量
	 */
	private String gzzl;
	/**
	 * 考核年
	 */
	private String khn;
	/**
	 * 考核月
	 */
	private String khy;
	/**
	 * 考核年月
	 */
	private String khny;
	/**
	 * 考勤日期
	 */
	private String kqrq;
	/**
	 * 打卡时间
	 */
	private String dksj;
	/**
	 * 是否迟到
	 */
	private String sfcd;
	/**
	 * 是否早退
	 */
	private String sfzt;
	/**
	 * 1：签到，2：签退
	 */
	private String qdqt;
	
	private String sjq;
	private String sjz;
	
	private String gzffsj;
	
	
	
	public String getGzffsj() {
		return gzffsj;
	}
	public void setGzffsj(String gzffsj) {
		this.gzffsj = gzffsj;
	}
	public String getSjq() {
		return sjq;
	}
	public void setSjq(String sjq) {
		this.sjq = sjq;
	}
	public String getSjz() {
		return sjz;
	}
	public void setSjz(String sjz) {
		this.sjz = sjz;
	}
	public String getKqrq() {
		return kqrq;
	}
	public void setKqrq(String kqrq) {
		this.kqrq = kqrq;
	}
	public String getDksj() {
		return dksj;
	}
	public void setDksj(String dksj) {
		this.dksj = dksj;
	}
	public String getSfcd() {
		return sfcd;
	}
	public void setSfcd(String sfcd) {
		this.sfcd = sfcd;
	}
	public String getSfzt() {
		return sfzt;
	}
	public void setSfzt(String sfzt) {
		this.sfzt = sfzt;
	}
	public String getQdqt() {
		return qdqt;
	}
	public void setQdqt(String qdqt) {
		this.qdqt = qdqt;
	}
	public String getKhny() {
		return khny;
	}
	public void setKhny(String khny) {
		this.khny = khny;
	}
	public String getKhn() {
		return khn;
	}
	public void setKhn(String khn) {
		this.khn = khn;
	}
	public String getKhy() {
		return khy;
	}
	public void setKhy(String khy) {
		this.khy = khy;
	}
	public String getZsgzsj() {
		return zsgzsj;
	}
	public void setZsgzsj(String zsgzsj) {
		this.zsgzsj = zsgzsj;
	}
	public String getZrsg() {
		return zrsg;
	}
	public void setZrsg(String zrsg) {
		this.zrsg = zrsg;
	}
	public String getZsjl() {
		return zsjl;
	}
	public void setZsjl(String zsjl) {
		this.zsjl = zsjl;
	}
	public String getGztd() {
		return gztd;
	}
	public void setGztd(String gztd) {
		this.gztd = gztd;
	}
	public String getRwwcqk() {
		return rwwcqk;
	}
	public void setRwwcqk(String rwwcqk) {
		this.rwwcqk = rwwcqk;
	}
	public String getGzhgx() {
		return gzhgx;
	}
	public void setGzhgx(String gzhgx) {
		this.gzhgx = gzhgx;
	}
	public String getGzzl() {
		return gzzl;
	}
	public void setGzzl(String gzzl) {
		this.gzzl = gzzl;
	}
	public String getNowYM() {
		return nowYM;
	}
	public void setNowYM(String nowYM) {
		this.nowYM = nowYM;
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
	public int getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
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
	public String getGrbh() {
		return grbh;
	}
	public void setGrbh(String grbh) {
		this.grbh = grbh;
	}
	public String getSfzhm() {
		return sfzhm;
	}
	public void setSfzhm(String sfzhm) {
		this.sfzhm = sfzhm;
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
