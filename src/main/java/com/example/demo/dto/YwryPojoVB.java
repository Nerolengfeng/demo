/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @文件名：YwryPojoVB.java
 * @类描述：TODO( 医务人员POJO valuebean )
 * @创建人：冯文超
 * @创建时间：2016-4-21  下午04:40:36
 */
package com.example.demo.dto;

import org.apache.ibatis.type.Alias;

/**
 * @包路径：cn.edu.jmun.rygl.valuebean
 * @类名：YwryPojoVB
 * @描述：TODO( 医务人员POJO valuebean )
 * @作者：冯文超
 * @创建时间：2016-4-21  下午04:40:36
 */
@Alias("YwryPojoVB")
public class YwryPojoVB {

	private RyjbxxbVB ryxx;// 人员基础信息表
	private YwryxxbVB ywry;// 医务人员信息表
	private YwryzhxxbVB zhxx;// 医务人员账号信息表
	private YwryjxkhfsVB jxkh;// 绩效考核分数表
	
	private String qjcs;// 请假次数
	
	/**
	 * 请假信息
	 */
	private YwryqjbVB[] qjxx;
	
	
	public YwryjxkhfsVB getJxkh() {
		return jxkh;
	}
	public void setJxkh(YwryjxkhfsVB jxkh) {
		this.jxkh = jxkh;
	}
	public YwryqjbVB[] getQjxx() {
		return qjxx;
	}
	public void setQjxx(YwryqjbVB[] qjxx) {
		this.qjxx = qjxx;
	}
	public String getQjcs() {
		return qjcs;
	}
	public void setQjcs(String qjcs) {
		this.qjcs = qjcs;
	}
	public YwryzhxxbVB getZhxx() {
		return zhxx;
	}
	public void setZhxx(YwryzhxxbVB zhxx) {
		this.zhxx = zhxx;
	}
	public RyjbxxbVB getRyxx() {
		return ryxx;
	}
	public void setRyxx(RyjbxxbVB ryxx) {
		this.ryxx = ryxx;
	}
	public YwryxxbVB getYwry() {
		return ywry;
	}
	public void setYwry(YwryxxbVB ywry) {
		this.ywry = ywry;
	}
}
